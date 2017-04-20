package com.pzj.core.customer.visitor;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-2-23.
 */
public class ModifyVisitorRequest implements Serializable {
	private static final long serialVersionUID = 5366070673922958701L;

	private Long id;

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
	 * 操作id
	 */
	private Long operator;

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

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}
}
