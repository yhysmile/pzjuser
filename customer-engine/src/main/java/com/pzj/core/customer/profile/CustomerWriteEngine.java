/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.profile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.pzj.core.customer.profile.mq.BindDistributor;
import com.pzj.core.customer.profile.mq.CustomerMqMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pzj.base.entity.SysUserRelation;
import com.pzj.commons.utils.CheckUtils;
import com.pzj.core.customer.commons.exception.CustomerException;
import com.pzj.core.customer.commons.exception.CustomerExceptionCode;
import com.pzj.core.customer.dao.ISysUserRelationMapper;
import com.pzj.core.customer.utils.UserRelationEnum;
import com.pzj.core.customer.utils.UserRelationStatusEnum;
import com.pzj.core.customer.utils.UserRootEnum;
import com.pzj.framework.context.Result;
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
		Long supplierId = UserRootEnum.checkIsRoot(operUser.getIsRoot()) ? operUser.getId() : operUser.getSupplierId();
		addUserRelation(supplierId, distributor.getResellerId(), distributor.getOperateId());

		return distributor.getResellerId();
	}

	private void checkBindDistributor(BindCustomerRequest distributor) {
		if (CheckUtils.isNull(distributor)) {
			throw new CustomerException(CustomerExceptionCode.CUSTOMER_NULL_ID);
		}
		if (CheckUtils.isNull(distributor.getResellerId())) {
			throw new CustomerException(CustomerExceptionCode.PARAMS_ILLEGAL.getCode(),
					CustomerExceptionCode.PARAMS_ILLEGAL.getTemplateMessage("被绑定分销商不合法", distributor.getResellerId()));
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

	public void addUserRelation(Long supplierId, Long resellerId, Long operateId) {
		SysUserRelation sysUserRelation = new SysUserRelation();
		sysUserRelation.setUserId(supplierId);
		sysUserRelation.setRelUserId(resellerId);
		sysUserRelation.setRelType(UserRelationEnum.SUPPLIER_DIRECT_RESELLER.getId());

		Date currentDate =  new Date();

		List<SysUserRelation> sysUserRelations = sysUserRelationMapper.queryUserRelationByParam(sysUserRelation);
		if (sysUserRelations != null && sysUserRelations.size() > 0) {
			SysUserRelation opeUserRelation = sysUserRelations.get(0);
			if (opeUserRelation.getId() != null
					&& (opeUserRelation.getStatus() == null || opeUserRelation.getStatus() != UserRelationStatusEnum.AVAILABLE
							.getStatus())) {
				sysUserRelation.setUpdateBy(operateId);
				sysUserRelation.setStatus(UserRelationStatusEnum.AVAILABLE.getStatus());
				sysUserRelation.setId(opeUserRelation.getId());
				sysUserRelationMapper.updateUserRelationStatus(sysUserRelation);
				sendBindDirectDistributorMsg(supplierId, resellerId, operateId, currentDate);
			}
		} else {
			//sysUserRelation.setUserId(supplierId);
			sysUserRelation.setStatus(UserRelationStatusEnum.AVAILABLE.getStatus());
			sysUserRelation.setCreateBy(operateId);
			sysUserRelation.setCreateDate(new Date());
			sysUserRelation.setId(idGenerater.nextId());
			sysUserRelationMapper.insert(sysUserRelation);
			sendBindDirectDistributorMsg(supplierId, resellerId, operateId, currentDate);
		}
	}



	private void sendBindDirectDistributorMsg(Long supplierId, Long customerId, Long operatorId, Date operatorDate) {
		BindDistributor bindDistributor = new BindDistributor();
		bindDistributor.setSupplierId(supplierId);
		bindDistributor.setCustomerIds(Arrays.asList(customerId));
		bindDistributor.setOperatorId(operatorId);
		bindDistributor.setOperatingDate(operatorDate);

		customerMqMessage.sendBindDistributorMsg(bindDistributor);
	}
}
