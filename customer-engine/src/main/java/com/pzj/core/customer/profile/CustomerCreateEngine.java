/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.profile;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.base.entity.SysUserMicroshop;
import com.pzj.commons.utils.CheckUtils;
import com.pzj.core.customer.commons.exception.CustomerException;
import com.pzj.core.customer.commons.exception.CustomerExceptionCode;
import com.pzj.core.customer.dao.SysUserMicroshopMapper;
import com.pzj.core.customer.profile.mq.CustomerMqMessage;
import com.pzj.core.customer.read.CustomerReadMapper;
import com.pzj.core.customer.utils.UserConfig;
import com.pzj.core.customer.utils.UserConstants;
import com.pzj.core.customer.utils.UserRootEnum;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.idgen.IDGenerater;
import com.pzj.framework.toolkit.RandomHelper;

/**
 * 
 * @author Administrator
 * @version $Id: CustomerCreateEngine.java, v 0.1 2017年4月12日 下午4:10:30 Administrator Exp $
 */
@Component
public class CustomerCreateEngine {
	private static final Logger logger = LoggerFactory.getLogger(CustomerCreateEngine.class);
	@Resource
	private CustomerUpdateEngine customerUpdateEngine;
	@Resource
	private CustomerMqMessage customerMqMessage;
	@Resource
	private CustomerWriteEngine customerWriteEngine;
	@Resource
	private CustomerReadMapper customerReadMapper;
	@Resource
	private CustomerQueryService customerQueryService;
	@Resource(name = "idGenerater")
	private IDGenerater idGenerater;
	@Resource
	private UserConfig userConfig;
	@Autowired
	private SysUserMicroshopMapper sysUserMicroshopMapper;

	public CreateCustomerRequest createDistributor(CreateCustomerRequest distributor) {

		//验证参数
		checkDistributorParams(distributor);

		//验证用户名是否已经存在
		checkCustomerExist(distributor.getLoginName());

		// 生成id并赋值给用户
		createNewCustomerId(distributor);

		if (CheckUtils.isNotNull(distributor.getCreateBy())) {
			getCreateBy(distributor);
		}
		if (CheckUtils.isNotNull(distributor.getRefereeCode())) {
			getRefereeInfo(distributor, distributor.getCreateBy(), distributor.getSupplierId());
		}
		boolean needPasswordInform = distributor.getUserPassword() == null && userConfig.getCustomerCreatePasswordSms();

		//密码为空需要生成密码
		if (CheckUtils.isNull(distributor.getUserPassword())) {
			// 1.生成密码
			String initPassword = createNewCustomerPassword(distributor);
			// 2.如果需要发送短信，封装密码参数
			if (needPasswordInform) {
				distributor.setPassWordInfo(new PassWordInfo(initPassword));
			}
		}

		// 创建用户
		customerUpdateEngine.addReseller(distributor);

		//创建微店信息
		createUserMicroshop(distributor.getUserId());
		//绑定直签分销商和SaaS用户
		BindCustomer(distributor);

		return distributor;
	}

	private void checkDistributorParams(CreateCustomerRequest distributor) {
		if (distributor == null) {
			throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
		}

		//用户名、联系人、手机号、创建人id,数据来源
		if (CheckUtils.isNull(distributor.getLoginName()) || distributor.getLoginName().length() < 6) {
			throw new CustomerException(CustomerExceptionCode.PARAMS_ILLEGAL.getCode(),
					CustomerExceptionCode.PARAMS_ILLEGAL.getTemplateMessage("登陆用户名", distributor.getLoginName()));
		}
		if (CheckUtils.isNull(distributor.getCorporater())) {
			throw new CustomerException(CustomerExceptionCode.PARAMS_ILLEGAL.getCode(),
					CustomerExceptionCode.PARAMS_ILLEGAL.getTemplateMessage("联系人", distributor.getCorporater()));
		}
		if (CheckUtils.isNull(distributor.getCorporaterMobile())) {
			throw new CustomerException(
					CustomerExceptionCode.PARAMS_ILLEGAL.getCode(),
					CustomerExceptionCode.PARAMS_ILLEGAL.getTemplateMessage("联系人手机号", distributor.getCorporaterMobile()));
		}
	}

	private void checkCustomerExist(String loginName) {
		QueryCustomerResponse sysUser = customerUpdateEngine.queryUserByName(loginName);
		if (CheckUtils.isNotNull(sysUser)) {
			throw new CustomerException(CustomerExceptionCode.LOGINNAME_EXIST);
		}
	}

	private Long createNewCustomerId(CreateCustomerRequest distributor) {
		Long userId = idGenerater.nextId();
		distributor.setUserId(userId);
		return userId;
	}

	private void getCreateBy(CreateCustomerRequest distributor) {
		// 如果只有创建人，根据创建人找所属主账号id
		QueryCustomerResponse customerResponse = customerQueryService.queryUserById(distributor.getCreateBy());
		if (CheckUtils.isNull(customerResponse)) {
			throw new CustomerException(CustomerExceptionCode.OPERATOR_NOT_EXIST);
		}

		//获取供应商id
		distributor.setSupplierId(UserRootEnum.checkIsRoot(customerResponse.getIsRoot()) ? customerResponse.getId()
				: customerResponse.getSupplierId());
	}

	private void getRefereeInfo(CreateCustomerRequest distributor, Long createById, Long supplierId) {
		// 如果有推荐码，根据推荐码的销售人员找所属主账号id
		QueryCustomerResponse customerResponse = customerQueryService.queryUserByInviteCode(distributor
				.getRefereeCode());
		if (CheckUtils.isNull(customerResponse)) {
			return;
		}
		if (CheckUtils.isNotNull(supplierId) && CheckUtils.isNotNull(customerResponse.getSupplierId())
				&& supplierId != customerResponse.getSupplierId()) {
			throw new CustomerException(CustomerExceptionCode.SALESMAN_SUPPLIER_MISMATCH.getCode(),
					CustomerExceptionCode.SALESMAN_SUPPLIER_MISMATCH.getTemplateMessage(createById, supplierId));

		}
		distributor.setRefereeId(customerResponse.getId());
		distributor.setBusinessId(customerResponse.getId());
		if (CheckUtils.isNull(supplierId)) {
			supplierId = customerResponse.getSupplierId();
			distributor.setSupplierId(supplierId);
		}
		if (CheckUtils.isNull(createById)) {
			createById = customerResponse.getId();
			distributor.setCreateBy(createById);
		}
	}

	private String createNewCustomerPassword(CreateCustomerRequest distributor) {
		String initPassword;
		if (distributor.getUserPassword() != null) {
			initPassword = distributor.getUserPassword();
		} else {
			initPassword = RandomHelper.mixed(6);
		}
		String yjPassword = PasswordGenerateUtil.generatePassword(distributor.getUserId(), distributor.getLoginName(),
				initPassword);
		distributor.setUserPassword(yjPassword);
		return initPassword;
	}

	private void BindCustomer(CreateCustomerRequest distributor) {
		//绑定直签分销商
		BindCustomerRequest bindReseller = new BindCustomerRequest();
		bindReseller.setResellerId(distributor.getUserId());
		bindReseller.setSupplierId(distributor.getSupplierId());
		bindReseller.setOperateId(distributor.getCreateBy());
		Long bindResult = customerWriteEngine.bindDirectDistributor(bindReseller);
		logger.info("create reseller bind relation,request:{},result:{}", JSONConverter.toJson(bindReseller),
				JSONConverter.toJson(bindResult));

		//绑定魔方SaaS用户
		BindCustomerRequest mfsaasBindReseller = new BindCustomerRequest();
		mfsaasBindReseller.setResellerId(distributor.getUserId());
		mfsaasBindReseller.setSupplierId(UserConstants.MF_SAAS_USER_ID);
		mfsaasBindReseller.setOperateId(distributor.getCreateBy());
		Long mfsaasBindResult = customerWriteEngine.bindDirectDistributor(mfsaasBindReseller);
		logger.info("create reseller bind relation mfsaas,request:{},result:{}",
				JSONConverter.toJson(mfsaasBindReseller), JSONConverter.toJson(mfsaasBindResult));
	}

	private void createUserMicroshop(Long resellerId) {
		SysUserMicroshop userMicroshop = new SysUserMicroshop(idGenerater.nextId(), resellerId,
				userConfig.getMicroshopDefaultAvatar(), userConfig.getMicroshopDefaultName(),
				userConfig.getMicroshopDefaultIntro(), new Date());
		sysUserMicroshopMapper.insert(userMicroshop);
	}
}
