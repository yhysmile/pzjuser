/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.profile;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.pzj.core.customer.common.exception.ThrowOrCollect;
import com.pzj.core.customer.common.matches.CommonMatches;
import com.pzj.core.customer.entitys.CustomerEntity;
import com.pzj.core.customer.microshop.MicroshopWriteEngine;
import com.pzj.core.customer.operator.Creator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.commons.utils.CheckUtils;
import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.read.CustomerReadMapper;
import com.pzj.core.customer.utils.UserConfig;
import com.pzj.core.customer.utils.UserConstants;
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
	private CustomerWriteEngine customerWriteEngine;
	@Resource
	private CustomerReadMapper customerReadMapper;
	@Resource
	private CustomerQueryService customerQueryService;
	@Resource(name = "idGenerater")
	private IDGenerater idGenerater;
	@Resource
	private UserConfig userConfig;
	@Resource
	private MicroshopWriteEngine microshopWriteEngine;

	public CreateCustomerRequest createDistributor(CreateCustomerRequest distributor) {

		//验证参数
		checkCustomerParams(distributor);

		//验证用户名是否已经存在
		checkCustomerExist(distributor.getLoginName());

		// 生成id并赋值给用户
		createNewCustomerId(distributor);

		configDistributorByOperator(distributor);
		configDistributorByRefereeCodeOrId(distributor);
		configDistributorByDefault(distributor);

		boolean needPasswordInform = distributor.getUserPassword() == null && userConfig.getCustomerCreatePasswordSms();

		//密码为空需要生成密码
		// 1.生成密码
		String initPassword = createNewCustomerPassword(distributor);

		// 2.如果需要发送短信，封装密码参数
		if (needPasswordInform) {
			distributor.setPassWordInfo(new PassWordInfo(initPassword));
		}

		// 创建用户
		customerUpdateEngine.addReseller(distributor);

		//创建微店信息
		Creator creator = new Creator(distributor.getCreateBy(), new Date());
		microshopWriteEngine.createNewDefaultMicroshop(distributor.getUserId(), distributor.getCorporaterMobile(), creator);

		//绑定直签分销商和SaaS用户
		bindDistributorToMasterCustomer(distributor);

		return distributor;
	}


	private ThrowOrCollect throwOrCollectOf(List<Throwable> throwables){
		if (throwables != null){
			return ThrowOrCollect.Collect;
		} else {
			return ThrowOrCollect.Throw;
		}
	}

	private void checkCustomerParams(CreateCustomerRequest customer) {

		if (customer == null) {
			CustomerException customerException = new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
			throw customerException;
		}

		List<Throwable> throwables = null; // new ArrayList<>(4);
		ThrowOrCollect toc = throwOrCollectOf(throwables);

		//用户名、联系人、手机号、创建人id,数据来源
		if (CheckUtils.isNull(customer.getLoginName()) || customer.getLoginName().length() < 6) {
			CustomerException customerException = new CustomerException(CustomerExceptionCode.LOGINNAME_NULL);
			toc.thorco(customerException, throwables);
		}
		if (CheckUtils.isNull(customer.getCorporater())) {
			CustomerException customerException = new CustomerException(CustomerExceptionCode.CORPORATER_NULL);
			toc.thorco(customerException, throwables);
		}
		String corporaterMobile = customer.getCorporaterMobile();
		if (CheckUtils.isNull(corporaterMobile)) {
			CustomerException customerException = new CustomerException(CustomerExceptionCode.PHONE_NUM_NULL);
			toc.thorco(customerException, throwables);
		}
		if (!CommonMatches.checkPhone(corporaterMobile)) {
			CustomerExceptionCode code = CustomerExceptionCode.PHONE_NUM_FORMAT;
			String msg = code.getTemplateMessage(corporaterMobile);
			CustomerException customerException = new CustomerException(code.getCode(), msg);
			toc.thorco(customerException, throwables);
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

	private void configDistributorByOperator(CreateCustomerRequest distributor) {
		if (CheckUtils.isNull(distributor.getCreateBy())) {
			return;
		}

		CustomerEntity operator = customerReadMapper.selectUserBaseInfoById(distributor.getCreateBy());
		// 如果只有创建人，根据创建人找所属主账号id
		QueryCustomerResponse customerResponse = customerQueryService.queryUserById(distributor.getCreateBy());
		if (CheckUtils.isNull(customerResponse)) {
			throw new CustomerException(CustomerExceptionCode.OPERATOR_NOT_EXIST);
		}

		//获取供应商id
		distributor.setSupplierId(CustomerUtil.masterId(operator));
	}

	private void configDistributorByRefereeCodeOrId(CreateCustomerRequest distributor) {
		QueryCustomerResponse customerResponse = null;
		String refereeCode = distributor.getRefereeCode();
		Long refereeId = distributor.getRefereeId();
		if (refereeCode != null) {
			// 如果有推荐码，根据推荐码的销售人员找所属主账号id
			customerResponse = customerQueryService.queryUserByInviteCode(refereeCode);
			if (customerResponse == null) {
				throw new CustomerException(CustomerExceptionCode.SALESMAN_NOT_EXIST, "推荐码：推荐码无效");
			}
		} else if (refereeId != null){
			customerResponse = customerQueryService.queryUserById(refereeId);
			if (customerResponse == null) {
				throw new CustomerException(CustomerExceptionCode.SALESMAN_NOT_EXIST, "推荐码：推荐码无效");
			}
		}

		if (customerResponse == null){
			return;
		}

		Long createById = distributor.getCreateBy();
		Long supplierId = distributor.getSupplierId();

		if (CheckUtils.isNotNull(supplierId) && CheckUtils.isNotNull(customerResponse.getSupplierId())
				&& !supplierId.equals(customerResponse.getSupplierId())) {
			throw new CustomerException(CustomerExceptionCode.SALESMAN_SUPPLIER_MISMATCH.getCode(),
					CustomerExceptionCode.SALESMAN_SUPPLIER_MISMATCH.getTemplateMessage(refereeCode, createById, supplierId));
		}

		distributor.setRefereeId(customerResponse.getId());
		distributor.setBusinessId(customerResponse.getId());

		if (CheckUtils.isNull(supplierId)) {
			distributor.setSupplierId(customerResponse.getSupplierId());
		}
		if (CheckUtils.isNull(createById)) {
			distributor.setCreateBy(customerResponse.getId());
		}
	}

	private void configDistributorByDefault(CreateCustomerRequest distributor) {
		if (distributor.getSupplierId() == null){
			distributor.setSupplierId(distributor.getUserId());
		}
		if (distributor.getCreateBy() == null){
			distributor.setCreateBy(distributor.getUserId());
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

	private void bindDistributorToMasterCustomer(CreateCustomerRequest distributor) {
		if (distributor.getSupplierId().equals(distributor.getUserId())) {
			//自己注册的新分销商，在没有上级SaaS用户的情况下，就绑定到魔方SaaS用户
			BindCustomerRequest mfsaasBindReseller = new BindCustomerRequest();
			mfsaasBindReseller.setResellerId(distributor.getUserId());
			mfsaasBindReseller.setSupplierId(UserConstants.MF_SAAS_USER_ID);
			mfsaasBindReseller.setOperateId(distributor.getCreateBy());
			Long mfsaasBindResult = customerWriteEngine.bindDirectDistributor(mfsaasBindReseller);
			logger.info("create reseller bind relation mfsaas,request:{},result:{}",
					JSONConverter.toJson(mfsaasBindReseller), JSONConverter.toJson(mfsaasBindResult));
		} else {
			//绑定直签分销商到SaaS用户
			BindCustomerRequest bindReseller = new BindCustomerRequest();
			bindReseller.setResellerId(distributor.getUserId());
			bindReseller.setSupplierId(distributor.getSupplierId());
			bindReseller.setOperateId(distributor.getCreateBy());
			Long bindResult = customerWriteEngine.bindDirectDistributor(bindReseller);
			logger.info("create reseller bind relation,request:{},result:{}", JSONConverter.toJson(bindReseller),
					JSONConverter.toJson(bindResult));
		}
	}

	public CreateCustomerRequest createSaasCustomer(CreateSaasCustomerRequest createSaasCustomerRequest) {
		//验证参数
		checkCustomerParams(createSaasCustomerRequest);
		//验证用户名是否已经存在
		checkCustomerExist(createSaasCustomerRequest.getLoginName());

		// 生成id并赋值给用户
		createNewCustomerId(createSaasCustomerRequest);
		customerUpdateEngine.addSaasCustomer(createSaasCustomerRequest);
		return createSaasCustomerRequest;
	}
}
