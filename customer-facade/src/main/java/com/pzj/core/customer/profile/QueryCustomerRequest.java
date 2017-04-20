package com.pzj.core.customer.profile;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-2-27.
 * 用户查询实体
 */
public class QueryCustomerRequest implements Serializable {
	/**  */
	private static final long serialVersionUID = -476369643388174044L;
	//用户id
	private Long id;
	//登录名称
	private String loginName;
	//手机号
	private String corporaterMobile;
	//联系人
	private String corporater;
	//供应商id
	private Long supplierId;
	//公司名称
	private String name;
	//品牌名
	private String supplierNormal;
	//公司名或品牌名
	private String nameOrNormal;
	//详细地址
	private String address;
	//查询具体时间
	private Date createDate;
	//省
	private String province;
	//市
	private String city;
	//县
	private String county;
	//分销商类型 2:旅行社, 3:旅行社部门, 4:导游, 5:商户, 8:OTA
	private Integer resellerType;
	/**
	 * 绑定时间开始点
	 */
	private Date bindDateBegin;

	/**
	 * 绑定时间结束点
	 */
	private Date bindDateEnd;
	/**
	 * 推荐人id
	 */
	private Long refereeId;

	/**
	 * 推荐码
	 */
	private String refereeCode;

	/**
	 * 商务负责人id
	 */
	private Long businessId;
	/**
	 * 服务热线供应商
	 */
	private String hotlineSupplier;
	/**
	 * 服务热线分销商
	 */
	private String hotlineReseller;

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

	public String getNameOrNormal() {
		return nameOrNormal;
	}

	public void setNameOrNormal(String nameOrNormal) {
		this.nameOrNormal = nameOrNormal;
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

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getRefereeCode() {
		return refereeCode;
	}

	public void setRefereeCode(String refereeCode) {
		this.refereeCode = refereeCode;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
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

}
