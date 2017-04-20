package com.pzj.core.customer.profile;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-2-27.
 * 用户修改实体
 */
public class ModifyCustomerRequest implements Serializable {
	private static final long serialVersionUID = -944329258275123572L;
	//用户id
	private Long id;
	//供应商id
	private Long supplierId;
	//公司名称
	private String name;
	//品牌名
	private String supplierNormal;
	//身份类型  默认值: p 允许值: p:个人, q:企业
	private String identifyType;
	//手机号
	private String corporaterMobile;
	//联系人
	private String corporater;
	// 证件号（身份证号）
	private String corporaterCredentials;
	// 经营许可证
	private String businessCertificate;
	/** 经营资质 */
	private String businessQualification;
	// 经营业执照
	private String businessLicense;
	// 导游证
	private String guideCertificate;
	// 地址
	private String address;
	// 座机号码
	private String operChargerPhone;
	// 传真号码
	private String operChargerFax;
	// 电子邮箱
	private String operChargerEmail;
	// 推荐人id
	private Long refereeId;
	// 商务负责人id
	private Long businessId;
	//省
	private String province;
	//市
	private String city;
	//县
	private String county;
	//分销商类型 2:旅行社, 3:旅行社部门, 4:导游, 5:商户, 8:OTA
	private Integer resellerType;
	/**
	 * 更新人id
	 */
	private Long updateBy;

	//服务热线供应商
	private String hotlineSupplier;
	//服务热线分销商
	private String hotlineReseller;
	/**
	 * 企业logo
	 */
	private String logo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCorporaterMobile() {
		return corporaterMobile;
	}

	public void setCorporaterMobile(String corporaterMobile) {
		this.corporaterMobile = corporaterMobile;
	}

	public String getCorporater() {
		return corporater;
	}

	public void setCorporater(String corporater) {
		this.corporater = corporater;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Long getRefereeId() {
		return refereeId;
	}

	public void setRefereeId(Long refereeId) {
		this.refereeId = refereeId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Integer getResellerType() {
		return resellerType;
	}

	public void setResellerType(Integer resellerType) {
		this.resellerType = resellerType;
	}

	public String getBusinessQualification() {
		return businessQualification;
	}

	public void setBusinessQualification(String businessQualification) {
		this.businessQualification = businessQualification;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
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

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}
