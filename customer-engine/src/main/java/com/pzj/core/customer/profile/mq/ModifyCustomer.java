/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.profile.mq;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.utils.OperatInfo;

/**
 * 修改用户消息实体
 * @author Administrator
 * @version $Id: ModifyCustomer.java, v 0.1 2017年4月7日 下午3:01:02 Administrator Exp $
 */
public class ModifyCustomer extends OperatInfo implements Serializable {
	/**  */
	private static final long serialVersionUID = -6739979604460183709L;
	private Long customerId;
	private Integer oldStatus;
	private Integer newStaus;

	public ModifyCustomer() {
		super();
	};

	/**
	 * Getter method for property <tt>customerId</tt>.
	 * 
	 * @return property value of customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * Setter method for property <tt>customerId</tt>.
	 * 
	 * @param customerId value to be assigned to property customerId
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * Getter method for property <tt>oldStatus</tt>.
	 * 
	 * @return property value of oldStatus
	 */
	public Integer getOldStatus() {
		return oldStatus;
	}

	/**
	 * Setter method for property <tt>oldStatus</tt>.
	 * 
	 * @param oldStatus value to be assigned to property oldStatus
	 */
	public void setOldStatus(Integer oldStatus) {
		this.oldStatus = oldStatus;
	}

	/**
	 * Getter method for property <tt>newStaus</tt>.
	 * 
	 * @return property value of newStaus
	 */
	public Integer getNewStaus() {
		return newStaus;
	}

	/**
	 * Setter method for property <tt>newStaus</tt>.
	 * 
	 * @param newStaus value to be assigned to property newStaus
	 */
	public void setNewStaus(Integer newStaus) {
		this.newStaus = newStaus;
	}

	public ModifyCustomer(Long customerId) {
		super();
	};

	public ModifyCustomer(Long customerId, Integer oldStatus, Integer newStaus, Long operatorId, Date operatingDate) {
		super();
		this.customerId = customerId;
		this.oldStatus = oldStatus;
		this.newStaus = newStaus;
		setOperatorId(operatorId);
		setOperatingDate(operatingDate);
	};

	public byte[] createMsgData(ModifyCustomer customer) {
		try {
			String json = JSONObject.toJSONString(customer);
			return json.getBytes();
		} catch (Exception e) {
			throw new CustomerException(CustomerExceptionCode.SERIALIZE_DATA_ERROR);
		}
	}
}
