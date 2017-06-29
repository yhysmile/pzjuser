package com.pzj.core.customer.profile;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.pzj.core.customer.entitys.CustomerExtendsEntity;
import com.pzj.core.customer.entitys.CustomerEntity;
import com.pzj.core.customer.entitys.SaasCustomerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.core.customer.utils.ResellerTypeEnum;
import com.pzj.core.customer.utils.UserCheckStatusEnum;
import com.pzj.core.customer.utils.UserConfig;
import com.pzj.core.customer.utils.UserConstants;
import com.pzj.core.customer.utils.UserRootEnum;
import com.pzj.core.customer.utils.UserStatusEnum;
import com.pzj.core.customer.utils.UserTypeEnum;
import com.pzj.core.customer.write.CustomerWriteMapper;
import com.pzj.core.smp.delivery.IShortMessageService;
import com.pzj.core.smp.delivery.MessageBean;
import com.pzj.core.smp.delivery.MessageHead;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;

@Service("customerUpdateEngine")
public class CustomerUpdateEngine {
	private final Logger logger = LoggerFactory.getLogger(CustomerUpdateEngine.class);

	@Resource
	private CustomerWriteMapper customerWriteMapper;
	@Resource
	private CustomerExtendsService customerExtendsService;
	@Resource
	private UserConfig userConfig;
	@Resource
	private IShortMessageService shortMessageService;

	public Long addReseller(CreateCustomerRequest sysUser) {
		CustomerEntity customerEntity = initResellerEntity(sysUser);
		//新增用户信息
		customerWriteMapper.insertDistributor(customerEntity);

		//新增用户扩展信息
		CustomerExtendsEntity extendsInfoModel = initCustomerExtend(sysUser.getRefereeId(), sysUser.getBusinessId());
		if (null != extendsInfoModel) {
			Long userId = extendsInfoModel.getRefereeId();
			if (userId == null) {
				userId = extendsInfoModel.getBusinessId();
			}
			QueryCustomerResponse saleUser = this.queryUserById(userId);
			if (null != saleUser) {
				extendsInfoModel.setCustomerId(customerEntity.getId());
				extendsInfoModel.setSupplierId(customerEntity.getSupplierId());
				customerExtendsService.intserCustomerExtends(extendsInfoModel);
			}
		}

		return customerEntity.getId();
	}

	public Boolean sendSms(CreateCustomerRequest sysUser) {
		Long supplierId = sysUser.getSupplierId();
		String supplierName = "";
		if (supplierId != null && supplierId.longValue() > 0) {
			CustomerEntity customerEntity = customerWriteMapper.selectUserBaseInfoById(supplierId);
			if (null != customerEntity) {
				supplierName = customerEntity.getName();
				if (supplierName == null || "".equals(supplierName.trim())) {
					supplierName = customerEntity.getCorporater();
				}
			}
		}
		String initPassword = sysUser.getUserPassword();
		String appUrl = userConfig.getAppDownload();
		String smContent = PasswordGenerateUtil.passwordNoticeMessage(supplierName, sysUser.getLoginName(),
				initPassword, appUrl);

		List<String> phones = new ArrayList<String>();
		phones.add(sysUser.getCorporaterMobile());

		MessageHead head = new MessageHead(UserConstants.SMP_USER_PASSWORD_KEY, "A", 3000L);
		MessageBean messageBean = new MessageBean(head, phones, smContent);
		logger.info("invoke send message,param:{}", JSONConverter.toJson(messageBean));

		Result<Boolean> result = shortMessageService.sendMessage(messageBean);

		return result.getData();
	}

	public QueryCustomerResponse queryUserByInviteCode(String inviteCode) {
		CustomerEntity reseller = customerWriteMapper.selectUserBaseByInviteCode(inviteCode);

		return initSysUser(reseller);
	}

	public QueryCustomerResponse queryUserById(Long id) {

		CustomerEntity reseller = customerWriteMapper.selectUserBaseInfoById(id);

		return initSysUser(reseller);
	}

	private QueryCustomerResponse initSysUser(CustomerEntity reseller) {
		if (reseller == null) {
			return null;
		}
		QueryCustomerResponse sysUser = new QueryCustomerResponse();
		sysUser.setId(reseller.getId());
		sysUser.setLoginName(reseller.getLoginName());
		sysUser.setSupplierId(reseller.getSupplierId());
		sysUser.setCorporater(reseller.getCorporater());
		sysUser.setCorporaterMobile(reseller.getCorporaterMobile());
		sysUser.setName(reseller.getName());
		sysUser.setAddress(reseller.getAddress());
		sysUser.setResellerType(reseller.getResellerType() == null ? null
				: Integer.parseInt(reseller.getResellerType()));
		sysUser.setCreateDate(reseller.getCreateDate());
		sysUser.setProvince(reseller.getProvince());
		sysUser.setCity(reseller.getCity());
		sysUser.setCounty(reseller.getCounty());

		if (reseller.getName() == null || reseller.getName().trim().length() == 0) {
			sysUser.setName(reseller.getCorporater());
		}
		return sysUser;
	}

	private CustomerExtendsEntity initCustomerExtend(Long refereeId, Long businessId) {
		Boolean referFlag = Boolean.FALSE, businessFlag = Boolean.FALSE;
		if (refereeId != null && refereeId.longValue() > 0) {
			referFlag = Boolean.TRUE;
		}
		if (businessId != null && businessId.longValue() > 0) {
			businessFlag = Boolean.TRUE;
		}
		if (referFlag || businessFlag) {
			CustomerExtendsEntity extendsInfoModel = new CustomerExtendsEntity();
			if (referFlag) {
				extendsInfoModel.setRefereeId(refereeId);
			}
			if (businessFlag) {
				extendsInfoModel.setBusinessId(businessId);
			} else {
				extendsInfoModel.setBusinessId(refereeId);
			}
			return extendsInfoModel;
		}

		return null;
	}

	private CustomerEntity initResellerEntity(CreateCustomerRequest sysUser) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(sysUser.getUserId());
		customerEntity.setLoginName(sysUser.getLoginName());
		customerEntity.setCorporater(sysUser.getCorporater());
		customerEntity.setCorporaterMobile(sysUser.getCorporaterMobile());
		customerEntity.setCreateUserId(sysUser.getCreateBy());
		customerEntity.setIdentifyType(sysUser.getIdentifyType());
		ResellerTypeEnum resellerTypeEnum = ResellerTypeEnum.getResellerTypeEnumById(sysUser.getResellerType());
		if (resellerTypeEnum != null) {
			customerEntity.setResellerType(resellerTypeEnum.getId().toString());
		}
		customerEntity.setSupplierId(sysUser.getSupplierId());
		if (customerEntity.getSupplierId() == null) {
			customerEntity.setSupplierId(sysUser.getCreateBy());
		}
		customerEntity.setUserType(UserTypeEnum.RESELLER.getId().toString());
		customerEntity.setIsRoot(UserRootEnum.ROOT_USER.getKey());
		customerEntity.setCheckType(1);
		customerEntity.setUserSource(sysUser.getUserSource());
		customerEntity.setName(sysUser.getName());
		customerEntity.setSupplierNormal(sysUser.getSupplierNormal());
		customerEntity.setAddress(sysUser.getAddress());
		customerEntity.setCorporaterCredentials(sysUser.getCorporaterCredentials());
		customerEntity.setBusinessLicense(sysUser.getBusinessLicense());
		customerEntity.setOperChargerPhone(sysUser.getOperChargerPhone());
		customerEntity.setUserSource(sysUser.getUserSource());
		customerEntity.setOperChargerFax(sysUser.getOperChargerFax());
		customerEntity.setBusinessCertificate(sysUser.getBusinessCertificate());
		customerEntity.setOperChargerEmail(sysUser.getOperChargerEmail());
		customerEntity.setBusinessQualification(sysUser.getBusinessQualification());
		customerEntity.setGuideCertificate(sysUser.getGuideCertificate());
		customerEntity.setProvince(sysUser.getProvince());
		customerEntity.setCity(sysUser.getCity());
		customerEntity.setCounty(sysUser.getCounty());
		customerEntity.setAccountState(UserStatusEnum.AVAILABLE.getStatus());
		customerEntity.setCheckState(UserCheckStatusEnum.AUDIT_PASS.getCheckStatus());
		customerEntity.setHotlineReseller(sysUser.getHotlineReseller());
		customerEntity.setHotlineSupplier(sysUser.getHotlineSupplier());
		customerEntity.setUserPassword(sysUser.getUserPassword());

		if (customerEntity.getHotlineReseller() == null) {
			customerEntity.setHotlineReseller(sysUser.getCorporaterMobile());
		}

		return customerEntity;
	}

	public QueryCustomerResponse queryUserByName(String name) {
		CustomerEntity reseller = customerWriteMapper.selectUserByName(name);

		return initSysUser(reseller);
	}

	private ArrayList<QueryCustomerResponse> initSysUsers(List<CustomerEntity> resellers) {
		if (resellers == null || resellers.size() == 0) {
			return null;
		}
		ArrayList<QueryCustomerResponse> sysUsers = new ArrayList<QueryCustomerResponse>();
		for (CustomerEntity reseller : resellers) {

			sysUsers.add(initSysUser(reseller));
		}
		return sysUsers;
	}

	public Long addSaasCustomer(CreateSaasCustomerRequest createSaasCustomerRequest){
		SaasCustomerEntity saasCustomerEntity = (SaasCustomerEntity) initResellerEntity(createSaasCustomerRequest);
		saasCustomerEntity.setLogo(createSaasCustomerRequest.getLogo());
		//赋值默认属性
		saasCustomerEntity.setDefaultData();
		customerWriteMapper.insertDistributor(saasCustomerEntity);
		return saasCustomerEntity.getId();
	}
}
