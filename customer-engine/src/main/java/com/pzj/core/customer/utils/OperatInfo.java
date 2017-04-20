/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.utils;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Administrator
 * @version $Id: OperatInfo.java, v 0.1 2017年4月7日 下午3:56:16 Administrator Exp $
 */
public class OperatInfo implements Serializable {
	/**  */
	private static final long serialVersionUID = 8522863628389822977L;
	private Long operatorId;
	private Date operatingDate;

	/**
	 * Getter method for property <tt>operatorId</tt>.
	 * 
	 * @return property value of operatorId
	 */
	public Long getOperatorId() {
		return operatorId;
	}

	/**
	 * Setter method for property <tt>operatorId</tt>.
	 * 
	 * @param operatorId value to be assigned to property operatorId
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * Getter method for property <tt>operatingDate</tt>.
	 * 
	 * @return property value of operatingDate
	 */
	public Date getOperatingDate() {
		return operatingDate;
	}

	/**
	 * Setter method for property <tt>operatingDate</tt>.
	 * 
	 * @param operatingDate value to be assigned to property operatingDate
	 */
	public void setOperatingDate(Date operatingDate) {
		this.operatingDate = operatingDate;
	}

}
