package com.pzj.core.customer.profile;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-2-27.
 * 用户查询返回
 */
public class QueryCustomerResponse implements Serializable {
	/**  */
	private static final long serialVersionUID = 3394470162490063669L;
	//用户id
	private Long id;
	//用户名
	private String loginName;
	//公司名称
	private String name;
	//手机号
	private String corporaterMobile;
	//联系人
	private String corporater;
	//推荐码
	private String invitationCode;
	//省
	private String province;
	//市
	private String city;
	//县
	private String county;
	//分销商类型 2:旅行社, 3:旅行社部门, 4:导游, 5:商户, 8:OTA
	private Integer resellerType;
	// 地址
	private String address;
	/**
	 * 用户关联关系创建时间
	 *
	 * 只用于与sys_user_relation表关联查询的接口。
	 */
	private Date userRelationCreateDate;

	//供应商id
	private Long supplierId;
	//创建时间
	private Date createDate;
	//是否是主帐号（1：主帐号，0：子账号）
	private String isRoot;

	/**
	 * Getter method for property <tt>isRoot</tt>.
	 * 
	 * @return property value of isRoot
	 */
	public String getIsRoot() {
		return isRoot;
	}

	/**
	 * Setter method for property <tt>isRoot</tt>.
	 * 
	 * @param isRoot value to be assigned to property isRoot
	 */
	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getUserRelationCreateDate() {
		return userRelationCreateDate;
	}

	public void setUserRelationCreateDate(Date userRelationCreateDate) {
		this.userRelationCreateDate = userRelationCreateDate;
	}

	public QueryCustomerResponse() {
		super();
	};

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public QueryCustomerResponse(Long id, String loginName, String name, String corporaterMobile, String corporater,
			String province, String city, String county, Integer resellerType, String address,
			Date userRelationCreateDate, Long supplierId) {
		this.loginName = loginName;
		this.name = name;
		this.id = id;
		this.corporaterMobile = corporaterMobile;
		this.corporater = corporater;
		this.province = province;
		this.city = city;
		this.county = county;
		this.resellerType = resellerType;
		this.address = address;
		this.userRelationCreateDate = userRelationCreateDate;
		this.supplierId = supplierId;

	};

	public QueryCustomerResponse(Long id, Long suplierId, String invitationCode, String name, String corporaterMobile) {
		this.id = id;
		this.supplierId = suplierId;
		this.invitationCode = invitationCode;
		this.name = name;
		this.corporaterMobile = corporaterMobile;
	};
}
