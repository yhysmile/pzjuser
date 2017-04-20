package com.pzj.core.customer.visitor;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-2-24.
 */
public class QueryVisitorRequest implements Serializable {
	private static final long serialVersionUID = -5294174855894914527L;
	/**
	 * 拥有者id
	 */
	private Long ownerId;
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

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
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

}
