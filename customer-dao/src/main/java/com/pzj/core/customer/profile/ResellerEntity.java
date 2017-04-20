package com.pzj.core.customer.profile;

import java.util.Date;
import java.util.List;

/**
 * 分销对象实体
 * @author yhy
 *
 */
public class ResellerEntity implements java.io.Serializable {

	private static final long serialVersionUID = 3696154360715755847L;
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 供应商id
	 */
	private Long supplierId;
	/**
	 * 用户名
	 */
	private String loginName;
	/**
	 * 联系人
	 */
	private String corporater;
	/**
	 * 手机号
	 */
	private String corporaterMobile;
	/**
	 * 公司名称
	 */
	private String name;
	/**
	 * 俗称
	 */
	private String supplierNormal;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 分销角色
	 */
	private String resellerType;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 推荐人id
	 */
	private Long refereeId;
	/**
	 * 操作人id
	 */
	private Long updateUserId;
	/**
	 * 创建人id
	 */
	private Long createUserId;
	/**
	 * 身份类型
	 */
	private String identifyType;
	/**
	 * 身份证号
	 */
	private String corporaterCredentials;
	/**
	 * 营业执照号
	 */
	private String businessLicense;
	/**
	 * 座机号
	 */
	private String operChargerPhone;
	/**
	 * 传真
	 */
	private String operChargerFax;
	/**
	 * 经营许可证号
	 */
	private String businessCertificate;
	/**
	 * 邮箱
	 */
	private String operChargerEmail;
	/**
	 * 相关资质
	 */
	private String businessQualification;
	/**
	 * 导游证号
	 */
	private String guideCertificate;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 县
	 */
	private String county;
	/**
	 * 用户状态
	 */
	private Integer accountState;
	/**
	 * 审核状态
	 */
	private String checkState;
	/**
	 * 用户渠道关联类型
	 */
	private String relType;
	/**
	 * 用户来源
	 */
	private String userSource;
	/**
	 * 是否是主帐号（1：主帐号，0：子账号）
	 */
	private String isRoot;
	/**
	 * 审核类型（1、无需审核；2、用户审核；3、资质审核）
	 */
	private Integer checkType;
	/**
	 * 服务热线供应商
	 */
	private String hotlineSupplier;
	/**
	 * 服务热线分销商
	 */
	private String hotlineReseller;
	/**
	 * 用户类型
	 */
	private String userType;
	/**
	 * 用户关系类型
	 */
	private String userRelType;

	/**
	 * 绑定时间开始点
	 */
	private Date bindDateBegin;

	/**
	 * 绑定时间结束点
	 */
	private Date bindDateEnd;
	/**
	 * 用户密码
	 */
	private String userPassword;
	/**
	 * 渠道id
	 */
	private Long channelId;

	/**
	 * 用户ids
	 */

	private List<Long> userIds;
	/**
	 * 查询类型  GlobalParam.QueryType
	 */
	private Integer queryType;

	/**
	 * Getter method for property <tt>queryType</tt>.
	 * 
	 * @return property value of queryType
	 */
	public Integer getQueryType() {
		return queryType;
	}

	/**
	 * Setter method for property <tt>queryType</tt>.
	 * 
	 * @param queryType value to be assigned to property queryType
	 */
	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}

	/**
	 * Getter method for property <tt>userIds</tt>.
	 * 
	 * @return property value of userIds
	 */
	public List<Long> getUserIds() {
		return userIds;
	}

	/**
	 * Setter method for property <tt>userIds</tt>.
	 * 
	 * @param userIds value to be assigned to property userIds
	 */
	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getCorporater() {
		return corporater;
	}

	public void setCorporater(String corporater) {
		this.corporater = corporater;
	}

	public String getCorporaterMobile() {
		return corporaterMobile;
	}

	public void setCorporaterMobile(String corporaterMobile) {
		this.corporaterMobile = corporaterMobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getResellerType() {
		return resellerType;
	}

	public void setResellerType(String resellerType) {
		this.resellerType = resellerType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getRefereeId() {
		return refereeId;
	}

	public void setRefereeId(Long refereeId) {
		this.refereeId = refereeId;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
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

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
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

	public String getBusinessCertificate() {
		return businessCertificate;
	}

	public void setBusinessCertificate(String businessCertificate) {
		this.businessCertificate = businessCertificate;
	}

	public String getOperChargerEmail() {
		return operChargerEmail;
	}

	public void setOperChargerEmail(String operChargerEmail) {
		this.operChargerEmail = operChargerEmail;
	}

	public String getBusinessQualification() {
		return businessQualification;
	}

	public void setBusinessQualification(String businessQualification) {
		this.businessQualification = businessQualification;
	}

	public String getGuideCertificate() {
		return guideCertificate;
	}

	public void setGuideCertificate(String guideCertificate) {
		this.guideCertificate = guideCertificate;
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

	public Integer getAccountState() {
		return accountState;
	}

	public void setAccountState(Integer accountState) {
		this.accountState = accountState;
	}

	public String getCheckState() {
		return checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getUserSource() {
		return userSource;
	}

	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}

	public String getIsRoot() {
		return isRoot;
	}

	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}

	public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getBindDateBegin() {
		return bindDateBegin;
	}

	public void setBindDateBegin(Date bindDateBegin) {
		this.bindDateBegin = bindDateBegin;
	}

	public Date getBindDateEnd() {
		return bindDateEnd;
	}

	public void setBindDateEnd(Date bindDateEnd) {
		this.bindDateEnd = bindDateEnd;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRelType() {
		return userRelType;
	}

	public void setUserRelType(String userRelType) {
		this.userRelType = userRelType;
	}

	public String getSupplierNormal() {
		return supplierNormal;
	}

	public void setSupplierNormal(String supplierNormal) {
		this.supplierNormal = supplierNormal;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

}
