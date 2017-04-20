package com.pzj.core.customer.visitor;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-2-23.
 */
public class CreateVisitorRequest implements Serializable {
	private static final long serialVersionUID = 9172573587598486007L;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 手机号
	 */
	private String phoneNum;

	/**
	 * 身份证号
	 */
	private String idNum;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 拥有者id（所属主账号）
	 */
	private Long ownerId;

	/**
	 * 操作id
	 */
	private Long operator;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}
}
