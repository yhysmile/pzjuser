package com.pzj.customer.entity;

import static com.pzj.menu.entity.MenuBuilder.AMenuBuilder;
import static com.pzj.role.entity.RoleBuilder.ARoleBuilder;
import static com.pzj.util.ServiceUtil.checkEmpty;
import static com.pzj.util.ServiceUtil.checkLengthMin;
import static com.pzj.util.ServiceUtil.checkNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pzj.base.entity.*;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.common.ServiceException;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.framework.toolkit.Check;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;
import com.pzj.util.KeyValueVo;

public class CustomerBuilder extends CommonBuiler<SysUser, Customer> {

	public final static CustomerBuilder ACustomerBuilder = new CustomerBuilder();

	@Override
	public Customer convertFrom(SysUser entity) {
		Customer customer = new Customer();
		customer.setId(entity.getId());
		customer.setAboutUs(entity.getAboutUs());
		customer.setAccountState(entity.getAccountState());
		customer.setAddress(entity.getAddress());
		customer.setApproveDate(entity.getApproveDate());
		customer.setApproveResult(entity.getApproveResult());
		customer.setBusinessCertificate(entity.getBusinessCertificate());
		customer.setBusinessLicense(entity.getBusinessLicense());
		customer.setBusinessQualification(entity.getBusinessQualification());
		customer.setCity(entity.getCity());
		customer.setCompanyId(entity.getCompanyId());
		customer.setContactWay(entity.getContactWay());
		customer.setContractNotes(entity.getContractNotes());
		customer.setContractNum(entity.getContractNum());
		customer.setContractRemarks(entity.getContractRemarks());
		customer.setCorporater(entity.getCorporater());
		customer.setCorporaterCredentials(entity.getCorporaterCredentials());
		customer.setCorporaterEmail(entity.getCorporaterEmail());
		customer.setCorporaterMobile(entity.getCorporaterMobile());
		customer.setCorporaterPhone(entity.getCorporaterPhone());
		customer.setCounty(entity.getCounty());
		customer.setCredentialsType(entity.getCredentialsType());
		customer.setDescription(entity.getDescription());
		customer.setFromDate(entity.getFromDate());
		customer.setIsBuygroup(entity.getIsBuygroup());
		customer.setIsBuysingle(entity.getIsBuysingle());
		customer.setIscreseller(entity.getIscreseller());
		customer.setIsManage(entity.getIsManage());
		customer.setLastLoginIp(entity.getLastLoginIp());
		customer.setLastLoginTime(entity.getLastLoginTime());
		customer.setLeaderFlag(entity.getLeaderFlag());
		customer.setLoginName(entity.getLoginName());
		customer.setLoginPasswd(entity.getLoginPasswd());
		customer.setLoginSource(entity.getLoginSource());

		customer.setDefaultLoginAddress(entity.getDefaultLoginAddress());
		customer.setGuideCertificate(entity.getGuideCertificate());
		customer.setIdentifyType(entity.getIdentifyType());
		customer.setDirectCompany(entity.getDirectCompany());
		customer.setDirectTime(entity.getDirectTime());

		customer.setName(entity.getName());
		customer.setOfficeId(entity.getOfficeId());
		customer.setOperChargerEmail(entity.getOperChargerEmail());
		customer.setOperChargerFax(entity.getOperChargerFax());
		customer.setOperChargerMobile(entity.getOperChargerMobile());
		customer.setOperChargerPhone(entity.getOperChargerPhone());
		customer.setOrgCodeCertificate(entity.getOrgCodeCertificate());
		customer.setOtherFile(entity.getOtherFile());
		customer.setOtherFile2(entity.getOtherFile2());
		customer.setOtherFiles(entity.getOtherFiles());
		customer.setParentId(entity.getParentId());
		customer.setPeriod(entity.getPeriod());
		customer.setProvince(entity.getProvince());
		customer.setRequestDate(entity.getRequestDate());
		customer.setResellerLevel(entity.getResellerLevel());
		customer.setResellerPhoneticShorthand(entity
				.getResellerPhoneticShorthand());
		customer.setResellerState(entity.getResellerState());
		customer.setResellerId(entity.getResellerId());
		customer.setResellerType(entity.getResellerType());
		customer.setSettleDate(entity.getSettleDate());
		customer.setSupplierPk(entity.getSupplierPk());
		customer.setSupplierAddress(entity.getSupplierAddress());
		customer.setSupplierDescription(entity.getSupplierDescription());
		customer.setSupplierDiscountValue(entity.getSupplierDiscountValue());
		customer.setSupplierLevel(entity.getSupplierLevel());
		customer.setSupplierNormal(entity.getSupplierNormal());
		customer.setSupplierPy(entity.getSupplierPy());
		customer.setSupplierState(entity.getSupplierState());
		customer.setSysCode(entity.getSysCode());
		customer.setTaxCertificate(entity.getTaxCertificate());
		customer.setId(entity.getId());
		customer.setUserSource(entity.getUserSource());
		customer.setUserType(entity.getUserType());
		customer.setVerificationCodes(entity.getVerificationCodes());
		customer.setWxOpenFlag(entity.getWxOpenFlag());
		customer.setWxOpenid(entity.getWxOpenid());
		customer.setCreateBy(entity.getCreateBy());
		customer.setCreateDate(entity.getCreateDate());
		customer.setCreateDateEnd(entity.getCreateDateEnd());
		customer.setUpdateBy(entity.getUpdateBy());
		customer.setUpdateDate(entity.getUpdateDate());
		customer.setUpdateDateEnd(entity.getUpdateDateEnd());
		customer.setSort(entity.getSort());
		customer.setCheckStatus(entity.getCheckStatus());
		customer.setReasonRejection(entity.getReasonRejection());
		customer.setCommonFlag01(entity.getCommonFlag01());
		customer.setCommonFlag02(entity.getCommonFlag02());
		// customer.setRootId(entity.getRootId());
		customer.setSupplierId(entity.getSupplierId());
		customer.setIsRoot(entity.getIsRoot());
		customer.setCheckCustomerId(entity.getCheckUserId());
		customer.setCheckCustomerName(entity.getCheckUserName());
		customer.setCheckDate(entity.getCheckDate());
		customer.setCheckDateEnd(entity.getCheckDateEnd());
		/**二维码*/
		customer.setTwoDimensionCode(entity.getTwoDimensionCode());
		// 票归处理
		String ticketRule = entity.getTicketRule();
		customer.setRule(KeyValueVo.getList(ticketRule));

		/****************************** start_pms客栈的特有属性字段 ****************************************/
		customer.setHotelMapLatitude(entity.getHotelMapLatitude());
		customer.setHotelMapLongitude(entity.getHotelMapLongitude());
		customer.setRegion(entity.getRegion());
		customer.setScenicInfo(KeyValueVo.getList(entity.getScenicInfo()));
		customer.setHotelStartDate(entity.getHotelStartDate());
		customer.setHotelEndDate(entity.getHotelEndDate());
		customer.setHotelNum(entity.getHotelNum());
		customer.setTreatPeopelNum(entity.getTreatPeopelNum());
		customer.setHotelFacility(KeyValueVo.getList(entity.getHotelFacility()));
		customer.setHotelFeature(KeyValueVo.getList(entity.getHotelFeature()));
		customer.setHotelPirture(entity.getHotelPirture());
		customer.setBossPirture(entity.getBossPirture());
		customer.setBossStory(entity.getBossStory());
		customer.setNotifyUpdateState(entity.getNotifyUpdateState());

		customer.setBelongScenicId(entity.getBelongScenicId());
		customer.setHotelType(entity.getHotelType());

		customer.setInvitationCode(entity.getInvitationCode());

		/****************************** end_pms客栈的特有属性字段 ******************************************/

		setSettlement(entity, customer);

		customer.setUserRelationCreateDate(entity.getUserRelationCreateDate());
		customer.setRegSource(entity.getRegSource());
		customer.setCheckType(entity.getCheckType());

		customer.setQualificationAudit(entity.getQualificationAudit());
		customer.setLogo(entity.getLogo());
		return customer;
	}

	@Override
	public SysUser convertTo(Customer entity) {
		SysUser user = new SysUser();
		return convertTo(entity, user);
	}

	protected SysUser convertTo(Customer entity, SysUser user) {

		if (entity.getId() == null) {
			user.setLoginPasswd(entity.getLoginPasswd());
		}

		user.setId(entity.getId());
		user.setAboutUs(entity.getAboutUs());
		user.setAccountState(entity.getAccountState());
		user.setAddress(entity.getAddress());
		user.setApproveDate(entity.getApproveDate());
		user.setApproveResult(entity.getApproveResult());
		user.setBusinessCertificate(entity.getBusinessCertificate());
		user.setBusinessLicense(entity.getBusinessLicense());
		user.setBusinessQualification(entity.getBusinessQualification());
		user.setCity(entity.getCity());
		user.setCompanyId(entity.getCompanyId());
		user.setContactWay(entity.getContactWay());
		user.setContractNotes(entity.getContractNotes());
		user.setContractNum(entity.getContractNum());
		user.setContractRemarks(entity.getContractRemarks());
		user.setCorporater(entity.getCorporater());
		user.setCorporaterCredentials(entity.getCorporaterCredentials());
		user.setCorporaterEmail(entity.getCorporaterEmail());
		user.setCorporaterMobile(entity.getCorporaterMobile());
		user.setCorporaterPhone(entity.getCorporaterPhone());
		user.setCounty(entity.getCounty());
		user.setCredentialsType(entity.getCredentialsType());
		user.setDescription(entity.getDescription());
		user.setFromDate(entity.getFromDate());
		user.setIsBuygroup(entity.getIsBuygroup());
		user.setIsBuysingle(entity.getIsBuysingle());
		user.setIscreseller(entity.getIscreseller());
		user.setIsManage(entity.getIsManage());
		user.setLastLoginIp(entity.getLastLoginIp());
		user.setLastLoginTime(entity.getLastLoginTime());
		user.setLeaderFlag(entity.getLeaderFlag());
		user.setLoginName(entity.getLoginName());

		user.setDefaultLoginAddress(entity.getDefaultLoginAddress());
		user.setGuideCertificate(entity.getGuideCertificate());
		user.setIdentifyType(entity.getIdentifyType());
		user.setDirectCompany(entity.getDirectCompany());
		user.setDirectTime(entity.getDirectTime());

		user.setLoginSource(entity.getLoginSource());
		user.setName(entity.getName());
		user.setOfficeId(entity.getOfficeId());
		user.setOperChargerEmail(entity.getOperChargerEmail());
		user.setOperChargerFax(entity.getOperChargerFax());
		user.setOperChargerMobile(entity.getOperChargerMobile());
		user.setOperChargerPhone(entity.getOperChargerPhone());
		user.setOrgCodeCertificate(entity.getOrgCodeCertificate());
		user.setOtherFile(entity.getOtherFile());
		user.setOtherFile2(entity.getOtherFile2());
		user.setOtherFiles(entity.getOtherFiles());
		user.setParentId(entity.getParentId());
		user.setPeriod(entity.getPeriod());
		user.setProvince(entity.getProvince());
		user.setRequestDate(entity.getRequestDate());
		user.setResellerLevel(entity.getResellerLevel());
		user.setResellerPhoneticShorthand(entity.getResellerPhoneticShorthand());
		user.setResellerState(entity.getResellerState());
		user.setResellerId(entity.getResellerId());
		user.setResellerType(entity.getResellerType());
		user.setSettleDate(entity.getSettleDate());
		user.setSupplierPk(entity.getSupplierPk());
		user.setSupplierAddress(entity.getSupplierAddress());
		user.setSupplierDescription(entity.getSupplierDescription());
		user.setSupplierDiscountValue(entity.getSupplierDiscountValue());
		user.setSupplierLevel(entity.getSupplierLevel());
		user.setSupplierNormal(entity.getSupplierNormal());
		user.setSupplierPy(entity.getSupplierPy());
		user.setSupplierState(entity.getSupplierState());
		user.setSysCode(entity.getSysCode());
		user.setTaxCertificate(entity.getTaxCertificate());
		user.setId(entity.getId());
		user.setUserSource(entity.getUserSource());
		user.setUserType(entity.getUserType());
		user.setVerificationCodes(entity.getVerificationCodes());
		user.setWxOpenFlag(entity.getWxOpenFlag());
		user.setWxOpenid(entity.getWxOpenid());
		user.setCreateBy(entity.getCreateBy());
		user.setCreateDate(entity.getCreateDate());
		user.setCreateDateEnd(entity.getCreateDateEnd());
		user.setUpdateBy(entity.getUpdateBy());
		user.setUpdateDate(entity.getUpdateDate());
		user.setUpdateDateEnd(entity.getUpdateDateEnd());
		user.setSort(entity.getSort());
		user.setCheckStatus(entity.getCheckStatus());
		user.setReasonRejection(entity.getReasonRejection());
		user.setCommonFlag01(entity.getCommonFlag01());
		user.setCommonFlag02(entity.getCommonFlag02());
		user.setSupplierId(entity.getSupplierId());
		user.setIsRoot(entity.getIsRoot());
		user.setIsRoot(entity.getIsRoot());
		user.setCheckUserId(entity.getCheckCustomerId());
		user.setCheckUserName(entity.getCheckCustomerName());
		user.setCheckDate(entity.getCheckDate());
		user.setCheckDateEnd(entity.getCheckDateEnd());
		/**二维码*/
		user.setTwoDimensionCode(entity.getTwoDimensionCode());
		// 判定票贵是否为空
		user.setTicketRule(KeyValueVo.getString(entity.getRule()));

		/****************************** start_pms客栈的特有属性字段 ****************************************/
		user.setHotelMapLatitude(entity.getHotelMapLatitude());
		user.setHotelMapLongitude(entity.getHotelMapLongitude());
		user.setRegion(entity.getRegion());
		user.setScenicInfo(KeyValueVo.getString(entity.getScenicInfo()));
		user.setHotelStartDate(entity.getHotelStartDate());
		user.setHotelEndDate(entity.getHotelEndDate());
		user.setHotelNum(entity.getHotelNum());
		user.setTreatPeopelNum(entity.getTreatPeopelNum());

		user.setBelongScenicId(entity.getBelongScenicId());
		user.setHotelType(entity.getHotelType());

		user.setHotelFeature(KeyValueVo.getString(entity.getHotelFeature()));
		user.setHotelPirture(entity.getHotelPirture());
		user.setBossPirture(entity.getBossPirture());
		user.setBossStory(entity.getBossStory());

		user.setNotifyUpdateState(entity.getNotifyUpdateState());

		user.setInvitationCode(entity.getInvitationCode());
		user.setLogo(entity.getLogo());

		if (entity.getHotelFacility() != null) {
			user.setHotelFacility(KeyValueVo.getString(entity
					.getHotelFacility()));
		}

		/****************************** end_pms客栈的特有属性字段 ******************************************/

		setSettlement(entity, user);
		setUserRelation(entity, user);

		user.setDirect(entity.getDirect());
		user.setDirectTimeEnd(entity.getDirectTimeEnd());

		user.setCheckStatusQuery(entity.getCheckStatusQuery());
		user.setResellerTypes(entity.getResellerTypes());
		user.setCheckType(entity.getCheckType());
		user.setCheckTypeQuery(entity.getCheckTypeQuery());
		user.setRegSource(entity.getRegSource());

		user.setQualificationAudit(entity.getQualificationAudit());
		user.setQualificationAuditQuery(entity.getQualificationAuditQuery());
		return user;
	}

	private void setSettlement(Customer entity, SysUser user) {
		CustomerSettlement settlement = entity.getSettlement();
		if (settlement != null) {
			SysUserSettlement userSettlement = new SysUserSettlement();
			userSettlement.setAccountingUnit(settlement.getAccountingUnit());
			userSettlement.setAccountingUnitName(settlement.getAccountingUnitName());
			userSettlement.setSupplierBillingMode(settlement
					.getSupplierBillingMode());
			userSettlement.setSupplierPlatformPayMode(settlement
					.getSupplierPlatformPayMode());
			userSettlement.setSupplierCreditPayMode(settlement
					.getSupplierCreditPayMode());
			userSettlement.setSupplierBrokeragePeriod(settlement
					.getSupplierBrokeragePeriod());
			userSettlement.setSupplierServiceFeePeriod(settlement
					.getSupplierServiceFeePeriod());
			userSettlement.setSupplierTradeServiceFee(settlement
					.getSupplierTradeServiceFee());
			userSettlement.setSupplierTradeServiceFeeType(settlement
					.getSupplierTradeServiceFeeType());
			userSettlement.setSupplierTradeServiceRemark(settlement
					.getSupplierTradeServiceRemark());
			userSettlement.setCurrencyType(settlement.getCurrencyType());
			userSettlement.setTradePayee(settlement.getTradePayee());
			user.setSettlement(userSettlement);
		}
	}

	private void setUserRelation(Customer entity, SysUser user) {
		List<CustomerRelation> customerRelationList = entity.getCustomerRelationList();
		if (!Check.NuNCollections(customerRelationList)){
			List<SysUserRelation> userRelationList = new ArrayList<>(customerRelationList.size());
			for (CustomerRelation customerRelation : customerRelationList){
				SysUserRelation sysUserRelation = CustomerRelationBuilder.ACustomerRelationBuilder.buildNewOrExisted(customerRelation);
				userRelationList.add(sysUserRelation);
			}
			user.setUserRelationList(userRelationList);
		}

	}

	private void setSettlement(SysUser user, Customer entity) {
		SysUserSettlement settlement = user.getSettlement();
		if (settlement != null) {
			CustomerSettlement customerSettlement = new CustomerSettlement();
			customerSettlement
					.setAccountingUnit(settlement.getAccountingUnit());
			customerSettlement.setAccountingUnitName(settlement.getAccountingUnitName());
			customerSettlement.setSupplierBillingMode(settlement
					.getSupplierBillingMode());
			customerSettlement.setSupplierPlatformPayMode(settlement
					.getSupplierPlatformPayMode());
			customerSettlement.setSupplierCreditPayMode(settlement
					.getSupplierCreditPayMode());
			customerSettlement.setSupplierBrokeragePeriod(settlement
					.getSupplierBrokeragePeriod());
			customerSettlement.setSupplierServiceFeePeriod(settlement
					.getSupplierServiceFeePeriod());
			customerSettlement.setSupplierTradeServiceFee(settlement
					.getSupplierTradeServiceFee());
			customerSettlement.setSupplierTradeServiceFeeType(settlement
					.getSupplierTradeServiceFeeType());
			customerSettlement.setSupplierTradeServiceRemark(settlement
					.getSupplierTradeServiceRemark());
			customerSettlement.setCurrencyType(settlement.getCurrencyType());
			customerSettlement.setTradePayee(settlement.getTradePayee());
			entity.setSettlement(customerSettlement);
		}
	}


	@Override
	protected void validtionValueWhenCreate(Customer entity, CommonCheck check)
			throws ServiceException {
		checkNull(entity, "Customer不能为null");

		// 取消验证用户输入的登陆密码 及 登陆账号信息
		// checkEmpty(entity.getLoginName(), "Customer.LoginName不能为空");
		// checkEmpty(entity.getLoginPasswd(), "Customer.LoginPasswd不能为空");

		if (entity.getLoginPasswd() != null)
			checkLengthMin(entity.getLoginPasswd(), 6, "Customer.LoginPasswd最小长度为6位");

		//checkEmpty(entity.getSysCode(), "Customer.SysCode不能为空");
		checkEmpty(entity.getUserType(), "Customer.UserType不能为空");
		checkNull(entity.getAccountState(), "Customer.AccountState不能为null");
		//checkEmpty(entity.getName(), "Customer.Name不能为空");
		checkNull(entity.getLeaderFlag(), "Customer.LeaderFlag不能为null");
		checkNull(entity.getSort(), "Customer.Sort不能为null");
	}

	@Override
	protected void customValueWhenCreate(Customer entity) {
		if (null == entity.getAccountState()) {
			entity.setAccountState(1);
		}
		if (StringUtils.isEmpty(entity.getSysCode())) {
			// entity.setSysCode(CustomerUtil.getNewSysCode());
		}
		if (null == entity.getLeaderFlag()) {
			entity.setLeaderFlag(3);
		}
		if (null == entity.getLastLoginTime()) {
			entity.setLastLoginTime(new Date());
		}
		if (null == entity.getCreateDate()) {
			entity.setCreateDate(new Date());
		}
		if (null == entity.getSort()) {
			entity.setSort(0);
		}
		if (null == entity.getUserType()) {
			entity.setUserType(UserGlobalDict.generUserType());
		}
		if (null == entity.getDelFlag()) {
			entity.setDelFlag(GlobalParam.FLAG.start().toString());
		}
		if (null == entity.getSupplierId()) {
			entity.setSupplierId(GlobalParam.SUPPILER);
		}
		if (null == entity.getIsRoot()) {
			entity.setIsRoot(UserGlobalDict.subAccount());
		}
	}

	@Override
	protected void defaultValueWhenCreate(Customer entity) {
		if (null == entity.getCreateDate()) {
			entity.setCreateDate(new Date());
		}
		if (null == entity.getAccountState()) {
			entity.setAccountState(GlobalParam.FLAG.start());
		}
	}

	public List<Customer> buildSourceAll(List<SysUser> users) {
		CustomerForeachHandle handle = new CustomerForeachHandle() {
			@Override
			public void handle(SysUser sysUser, Customer customer) {
				List<SysMenu> sysMenuList = sysUser.getMenuList();
				if (null != sysMenuList) {
					customer.setMenuList(AMenuBuilder.buildSource(sysMenuList));
				}
				List<SysRole> sysRoleList = sysUser.getRoleList();
				if (null != sysRoleList) {
					customer.setRoleList(ARoleBuilder.buildSource(sysRoleList));
				}
			}
		};

		return buildSource(users, handle);
	}

	@Override
	protected void customValueWhenModify(Customer entity) {
		// TODO Auto-generated method stub

	}
}
