package com.pzj.core.customer.salesman;

import java.io.Serializable;
import java.util.Date;

import com.pzj.framework.entity.PageableRequestBean;

/**
 * Created by Administrator on 2017-2-26.
 */
public class QuerySalesmanRequest extends PageableRequestBean implements Serializable {
	private static final long serialVersionUID = -4118309733977766293L;

	/**
	 * 销售人员id
	 */
	private Long id;

	/**
	 * 所属供应商id
	 */
	private Long supplierId;

	/**
	 * 联系人名
	 */
	private String corporater;

	/**
	 * 联系人手机号
	 */
	private String corporaterMobile;

	/**
	 * 推荐码
	 */
	private String invitationCode;

	/**
	 * 所属单位
	 */
	private String department;

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
	 * 地址
	 */
	private String address;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 创建时间
	 */
	private Date createDateEnd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
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

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}
}
