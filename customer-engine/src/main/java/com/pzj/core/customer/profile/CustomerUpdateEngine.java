package com.pzj.core.customer.profile;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.base.common.global.UserGlobalDict;
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
		ResellerEntity resellerEntity = initResellerEntity(sysUser);
		//新增用户信息
		customerWriteMapper.insertDistributor(resellerEntity);

		//新增用户扩展信息
		CustomerExtendsEntity extendsInfoModel = initCustomerExtend(sysUser.getRefereeId(), sysUser.getBusinessId());
		if (null != extendsInfoModel) {
			Long userId = extendsInfoModel.getRefereeId();
			if (userId == null) {
				userId = extendsInfoModel.getBusinessId();
			}
			QueryCustomerResponse saleUser = this.queryUserById(userId);
			if (null != saleUser) {
				extendsInfoModel.setCustomerId(resellerEntity.getId());
				extendsInfoModel.setSupplierId(resellerEntity.getSupplierId());
				customerExtendsService.intserCustomerExtends(extendsInfoModel);
			}
		}

		return resellerEntity.getId();
	}

	public Boolean sendSms(CreateCustomerRequest sysUser) {
		Long supplierId = sysUser.getSupplierId();
		String supplierName = "";
		if (supplierId != null && supplierId.longValue() > 0) {
			ResellerEntity resellerEntity = customerWriteMapper.queryUserBaseInfoById(supplierId);
			if (null != resellerEntity) {
				supplierName = resellerEntity.getName();
				if (supplierName == null || "".equals(supplierName.trim())) {
					supplierName = resellerEntity.getCorporater();
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
		ResellerEntity reseller = customerWriteMapper.queryUserBaseByInviteCode(inviteCode);

		return initSysUser(reseller);
	}

	public QueryCustomerResponse queryUserById(Long id) {

		ResellerEntity reseller = customerWriteMapper.queryUserBaseInfoById(id);

		return initSysUser(reseller);
	}

	private QueryCustomerResponse initSysUser(ResellerEntity reseller) {
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

	private ResellerEntity initResellerEntity(CreateCustomerRequest sysUser) {
		ResellerEntity resellerEntity = new ResellerEntity();
		resellerEntity.setId(sysUser.getUserId());
		resellerEntity.setLoginName(sysUser.getLoginName());
		resellerEntity.setCorporater(sysUser.getCorporater());
		resellerEntity.setCorporaterMobile(sysUser.getCorporaterMobile());
		resellerEntity.setCreateUserId(sysUser.getCreateBy());
		resellerEntity.setIdentifyType(sysUser.getIdentifyType());
		ResellerTypeEnum resellerTypeEnum = ResellerTypeEnum.getResellerTypeEnumById(sysUser.getResellerType());
		if (resellerTypeEnum != null) {
			resellerEntity.setResellerType(resellerTypeEnum.getId().toString());
		}
		resellerEntity.setSupplierId(sysUser.getSupplierId());
		if (resellerEntity.getSupplierId() == null) {
			resellerEntity.setSupplierId(sysUser.getCreateBy());
		}
		resellerEntity.setUserType(UserTypeEnum.RESELLER.getId().toString());
		resellerEntity.setIsRoot(UserRootEnum.ROOT_USER.getKey());
		resellerEntity.setCheckType(1);
		resellerEntity.setUserSource(sysUser.getUserSource());
		resellerEntity.setName(sysUser.getName());
		resellerEntity.setSupplierNormal(sysUser.getSupplierNormal());
		resellerEntity.setAddress(sysUser.getAddress());
		resellerEntity.setCorporaterCredentials(sysUser.getCorporaterCredentials());
		resellerEntity.setBusinessLicense(sysUser.getBusinessLicense());
		resellerEntity.setOperChargerPhone(sysUser.getOperChargerPhone());
		resellerEntity.setUserSource(sysUser.getUserSource());
		resellerEntity.setOperChargerFax(sysUser.getOperChargerFax());
		resellerEntity.setBusinessCertificate(sysUser.getBusinessCertificate());
		resellerEntity.setOperChargerEmail(sysUser.getOperChargerEmail());
		resellerEntity.setBusinessQualification(sysUser.getBusinessQualification());
		resellerEntity.setGuideCertificate(sysUser.getGuideCertificate());
		resellerEntity.setProvince(sysUser.getProvince());
		resellerEntity.setCity(sysUser.getCity());
		resellerEntity.setCounty(sysUser.getCounty());
		resellerEntity.setAccountState(UserStatusEnum.AVAILABLE.getStatus());
		resellerEntity.setCheckState(UserCheckStatusEnum.AUDIT_PASS.getCheckStatus());
		resellerEntity.setHotlineReseller(sysUser.getHotlineReseller());
		resellerEntity.setHotlineSupplier(sysUser.getHotlineSupplier());
		resellerEntity.setUserPassword(sysUser.getUserPassword());

		if (resellerEntity.getHotlineReseller() == null) {
			resellerEntity.setHotlineReseller(sysUser.getCorporaterMobile());
		}

		return resellerEntity;
	}

	public QueryCustomerResponse queryUserByName(String name) {
		ResellerEntity reseller = customerWriteMapper.queryUserByName(name);

		return initSysUser(reseller);
	}

	private ArrayList<QueryCustomerResponse> initSysUsers(List<ResellerEntity> resellers) {
		if (resellers == null || resellers.size() == 0) {
			return null;
		}
		ArrayList<QueryCustomerResponse> sysUsers = new ArrayList<QueryCustomerResponse>();
		for (ResellerEntity reseller : resellers) {

			sysUsers.add(initSysUser(reseller));
		}
		return sysUsers;
	}
}
