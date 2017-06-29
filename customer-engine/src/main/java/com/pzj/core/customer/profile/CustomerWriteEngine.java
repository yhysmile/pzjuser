/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.profile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pzj.base.entity.SysUserRelation;
import com.pzj.commons.utils.CheckUtils;
import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.common.work.UnitOfWork;
import com.pzj.core.customer.common.work.support.ThreadUnitOfWork;
import com.pzj.core.customer.dao.ISysUserRelationMapper;
import com.pzj.core.customer.profile.event.UnbindDirectDistributorEvent;
import com.pzj.core.customer.profile.mq.BindDistributor;
import com.pzj.core.customer.profile.mq.CustomerMqMessage;
import com.pzj.core.customer.utils.UserConstants;
import com.pzj.core.customer.utils.UserRelationEnum;
import com.pzj.core.customer.utils.UserRelationStatusEnum;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.idgen.IDGenerater;

/**
 * 
 * @author Administrator
 * @version $Id: CustomerWriteEngine.java, v 0.1 2017年4月11日 下午5:09:14 Administrator Exp $
 */
@Component
public class CustomerWriteEngine {
	private static final Logger logger = LoggerFactory.getLogger(CustomerWriteEngine.class);

	@Resource
	private CustomerUpdateEngine customerUpdateEngine;
	@Resource
	private ISysUserRelationMapper sysUserRelationMapper;
	@Resource
	private IDGenerater idGenerater;
	@Resource
	private CustomerMqMessage customerMqMessage;

	/**
	 * 绑定SaaS用户与分销商
	 * @param distributor
	 * @return
	 */
	public Long bindDirectDistributor(BindCustomerRequest distributor) {
		if (logger.isDebugEnabled()) {
			logger.debug("bind direct distributor request param:{}", JSONConverter.toJson(distributor));
		}

		//验证参数
		checkBindDistributor(distributor);

		//被绑定用户
		QueryCustomerResponse sysUser = customerUpdateEngine.queryUserById(distributor.getResellerId());
		if (CheckUtils.isNull(sysUser)) {
			logger.warn("query user not exists!param:{}", JSONConverter.toJson(distributor));
			throw new CustomerException(CustomerExceptionCode.ILLEGAL_OPERATION.getCode(), "被绑定分销商信息为空");
		}

		//操作人信息
		QueryCustomerResponse operUser = customerUpdateEngine.queryUserById(distributor.getOperateId());
		if (CheckUtils.isNull(operUser)) {
			logger.error("bind direct distributor user not exist,request:{}", JSONConverter.toJson(distributor));
			throw new CustomerException(CustomerExceptionCode.OPERATOR_NOT_EXIST);
		}

		//获取供应商id
		addUserRelation(distributor.getSupplierId(), distributor.getResellerId(), distributor.getOperateId());

		return distributor.getResellerId();
	}

	private void checkBindDistributor(BindCustomerRequest distributor) {
		if (CheckUtils.isNull(distributor)) {
			throw new CustomerException(CustomerExceptionCode.CUSTOMER_NULL_ID);
		}
		Long resellerId = distributor.getResellerId();
		if (CheckUtils.isNull(resellerId)) {
			throw new CustomerException(CustomerExceptionCode.PARAMS_ILLEGAL.getCode(),
					CustomerExceptionCode.PARAMS_ILLEGAL.getTemplateMessage("被绑定分销商不合法", resellerId));
		}
		if (resellerId.equals(UserConstants.MF_SAAS_USER_ID)) {
			throw new CustomerException(CustomerExceptionCode.CUSTOMER_RULE_MFSAAS_NOT_AS_DIRECT);
		}
		if (CheckUtils.isNull(distributor.getSupplierId())) {
			throw new CustomerException(CustomerExceptionCode.PARAMS_ILLEGAL.getCode(),
					CustomerExceptionCode.PARAMS_ILLEGAL.getTemplateMessage("主账号信息不合法", distributor.getSupplierId()));
		}
		if (CheckUtils.isNull(distributor.getOperateId())) {
			throw new CustomerException(CustomerExceptionCode.PARAMS_ILLEGAL.getCode(),
					CustomerExceptionCode.PARAMS_ILLEGAL.getTemplateMessage("操作人信息不合法", distributor.getOperateId()));
		}
	}

	private void addUserRelation(Long supplierId, Long distributorId, Long operateId) {
		Date currentDate = new Date();

		List<SysUserRelation> sysUserRelations = getSysUserRelations(supplierId, distributorId);
		if (sysUserRelations != null && sysUserRelations.size() > 0) {
			SysUserRelation opeUserRelation = sysUserRelations.get(0);
			if (opeUserRelation.getId() != null
					&& (opeUserRelation.getStatus() == null || opeUserRelation.getStatus() != UserRelationStatusEnum.AVAILABLE
							.getStatus())) {

				SysUserRelation sysUserRelation = new SysUserRelation();
				sysUserRelation.setUpdateBy(operateId);
				sysUserRelation.setStatus(UserRelationStatusEnum.AVAILABLE.getStatus());
				sysUserRelation.setId(opeUserRelation.getId());
				sysUserRelationMapper.updateUserRelationStatus(sysUserRelation);
				sendBindDirectDistributorMsg(supplierId, distributorId, operateId, currentDate);
			}
		} else {
			SysUserRelation sysUserRelation = new SysUserRelation();
			sysUserRelation.setUserId(supplierId);
			sysUserRelation.setRelUserId(distributorId);
			sysUserRelation.setStatus(UserRelationStatusEnum.AVAILABLE.getStatus());
			sysUserRelation.setRelType(UserRelationEnum.SUPPLIER_DIRECT_RESELLER.getId());
			sysUserRelation.setCreateBy(operateId);
			sysUserRelation.setCreateDate(new Date());
			sysUserRelation.setId(idGenerater.nextId());
			sysUserRelationMapper.insert(sysUserRelation);
			sendBindDirectDistributorMsg(supplierId, distributorId, operateId, currentDate);
		}
	}

	private List<SysUserRelation> getSysUserRelations(Long supplierId, Long distributorId) {
		SysUserRelation sysUserRelation = new SysUserRelation();
		sysUserRelation.setUserId(supplierId);
		sysUserRelation.setRelUserId(distributorId);
		sysUserRelation.setRelType(UserRelationEnum.SUPPLIER_DIRECT_RESELLER.getId());

		return sysUserRelationMapper.queryUserRelationByParam(sysUserRelation);
	}

	private void sendBindDirectDistributorMsg(Long supplierId, Long customerId, Long operatorId, Date operatorDate) {
		BindDistributor bindDistributor = new BindDistributor();
		bindDistributor.setSupplierId(supplierId);
		bindDistributor.setCustomerIds(Arrays.asList(customerId));
		bindDistributor.setOperatorId(operatorId);
		bindDistributor.setOperatingDate(operatorDate);

		customerMqMessage.sendBindDistributorMsg(bindDistributor);
	}

	/**
	 * 解绑SaaS用户与分销商
	 * @param supplierId
	 * @param distributorId
	 * @param operatorId
	 * @param operatingDate
	 * @return
	 */
	public boolean unbindDirectDistributor(Long supplierId, Long distributorId, Long operatorId, Date operatingDate) {
		//验证参数
		checkBindDistributor(supplierId, distributorId, operatorId);

		List<SysUserRelation> sysUserRelations = getSysUserRelations(supplierId, distributorId);

		boolean result = false;
		if (sysUserRelations != null && sysUserRelations.size() > 0) {
			SysUserRelation opeUserRelation = sysUserRelations.get(0);
			Integer status = opeUserRelation.getStatus();
			if (status == null || status.equals(UserRelationStatusEnum.AVAILABLE.getStatus())) {
				disableUserRelation(opeUserRelation.getId(), operatorId, operatingDate);
				publishUnbindDirectDistributor(supplierId, distributorId, operatorId, operatingDate);
				result = true;
			}
		}

		return result;
	}

	private void checkBindDistributor(Long masterId, Long distributorId, Long operatorId) {
		if (CheckUtils.isNull(distributorId)) {
			throw new CustomerException(CustomerExceptionCode.CUSTOMER_NULL_ID, "分销商id为空");
		}
		if (CheckUtils.isNull(masterId)) {
			throw new CustomerException(CustomerExceptionCode.CUSTOMER_NULL_ID, "主账号id为空");
		}
		if (CheckUtils.isNull(operatorId)) {
			throw new CustomerException(CustomerExceptionCode.OPERATOR_ID_NULL);
		}
	}

	private void disableUserRelation(Long id, Long updateBy, Date updateDate) {
		SysUserRelation updateUserRelation = new SysUserRelation();
		updateUserRelation.setId(id);
		updateUserRelation.setUpdateBy(updateBy);
		updateUserRelation.setUpdateDate(updateDate);
		updateUserRelation.setStatus(0);
		sysUserRelationMapper.updateUserRelationStatus(updateUserRelation);
	}

	private void publishUnbindDirectDistributor(Long supplierId, Long distributorId, Long operatorId, Date operatingDate) {
		UnitOfWork unitOfWork = ThreadUnitOfWork.getOrCreateThreadUnitOfWork();

		UnbindDirectDistributorEvent event = new UnbindDirectDistributorEvent();
		event.setSupplierId(supplierId);
		event.setDistributorId(distributorId);
		event.setOperatorId(operatorId);
		event.setOperatingDate(operatingDate);

		unitOfWork.addEvent(event);
	}

}
