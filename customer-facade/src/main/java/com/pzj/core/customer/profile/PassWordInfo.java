/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.profile;

import java.io.Serializable;

/**
 * 密码信息
 * @author Administrator
 * @version $Id: PassWordInfo.java, v 0.1 2017年4月14日 上午11:13:14 Administrator Exp $
 */
public class PassWordInfo implements Serializable {
	/**  */
	private static final long serialVersionUID = -7913910315249599723L;
	private String passWord;

	/**
	 * Getter method for property <tt>passWord</tt>.
	 * 
	 * @return property value of passWord
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * Setter method for property <tt>passWord</tt>.
	 * 
	 * @param passWord value to be assigned to property passWord
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public PassWordInfo() {
		super();
	};

	public PassWordInfo(String passWord) {
		this.passWord = passWord;
	}

}
