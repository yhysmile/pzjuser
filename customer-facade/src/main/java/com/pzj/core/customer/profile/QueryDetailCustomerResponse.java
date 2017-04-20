package com.pzj.core.customer.profile;

import java.util.Date;

/**
 * Created by Administrator on 2017-2-27.
 * 用户详细查询返回
 */
public class QueryDetailCustomerResponse extends QueryCustomerResponse {
	private static final long serialVersionUID = -7763973804129272858L;
	/**
	 * 品牌名
	 */
	private String supplierNormal;
	/**
	 * 身份类型  默认值: p 允许值: p:个人, q:企业
	 */
	private String identifyType;
	/**
	 * 证件号（身份证号）
	 */
	private String corporaterCredentials;
	/**
	 * 经营许可证
	 */
	private String businessCertificate;
	/**
	 * 经营资质
	 */
	private String businessLicense;
	/**
	 * 相关资质
	 */
	private String businessQualification;
	/**
	 * 导游证
	 */
	private String guideCertificate;
	/**
	 * 座机号码
	 */
	private String operChargerPhone;
	/**
	 * 传真号码
	 */
	private String operChargerFax;
	/**
	 * 电子邮箱
	 */
	private String operChargerEmail;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;

	/**
	 * 服务热线供应商
	 */
	private String hotlineSupplier;
	/**
	 * 服务热线分销商
	 */
	private String hotlineReseller;

	/**
	 * 企业logo
	 */
	private String logo;

	public QueryDetailCustomerResponse() {
	}

	public QueryDetailCustomerResponse(Long id, String loginName, String name, String corporaterMobile,
			String corporater, String province, String city, String county, Integer resellerType, String address,
			Date userRelationCreateDate, Long supplierId) {
		super(id, loginName, name, corporaterMobile, corporater, province, city, county, resellerType, address,
				userRelationCreateDate, supplierId);
	}

	public String getSupplierNormal() {
		return supplierNormal;
	}

	public void setSupplierNormal(String supplierNormal) {
		this.supplierNormal = supplierNormal;
	}

	public String getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}

	public String getCorporaterCredentials() {
		return corporaterCredentials;
	}

	public void setCorporaterCredentials(String corporaterCredentials) {
		this.corporaterCredentials = corporaterCredentials;
	}

	public String getBusinessCertificate() {
		return businessCertificate;
	}

	public void setBusinessCertificate(String businessCertificate) {
		this.businessCertificate = businessCertificate;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getGuideCertificate() {
		return guideCertificate;
	}

	public void setGuideCertificate(String guideCertificate) {
		this.guideCertificate = guideCertificate;
	}

	public String getOperChargerPhone() {
		return operChargerPhone;
	}

	public void setOperChargerPhone(String operChargerPhone) {
		this.operChargerPhone = operChargerPhone;
	}

	public String getOperChargerFax() {
		return operChargerFax;
	}

	public void setOperChargerFax(String operChargerFax) {
		this.operChargerFax = operChargerFax;
	}

	public String getOperChargerEmail() {
		return operChargerEmail;
	}

	public void setOperChargerEmail(String operChargerEmail) {
		this.operChargerEmail = operChargerEmail;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getHotlineSupplier() {
		return hotlineSupplier;
	}

	public void setHotlineSupplier(String hotlineSupplier) {
		this.hotlineSupplier = hotlineSupplier;
	}

	public String getHotlineReseller() {
		return hotlineReseller;
	}

	public void setHotlineReseller(String hotlineReseller) {
		this.hotlineReseller = hotlineReseller;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getBusinessQualification() {
		return businessQualification;
	}

	public void setBusinessQualification(String businessQualification) {
		this.businessQualification = businessQualification;
	}
}
