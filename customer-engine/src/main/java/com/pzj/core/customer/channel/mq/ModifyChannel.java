/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.channel.mq;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.profile.mq.ModifyCustomer;
import com.pzj.core.customer.utils.OperatInfo;

/**
 * 
 * @author Administrator
 * @version $Id: ModifyChannel.java, v 0.1 2017年4月7日 下午4:00:43 Administrator Exp $
 */
public class ModifyChannel extends OperatInfo implements Serializable {

	/**  */
	private static final long serialVersionUID = 9001052837778238303L;

	private Long channelId;
	private Integer oldStatus;
	private Integer newStaus;

	public ModifyChannel() {
		super();
	};

	/**
	 * Getter method for property <tt>channelId</tt>.
	 * 
	 * @return property value of channelId
	 */
	public Long getChannelId() {
		return channelId;
	}

	/**
	 * Setter method for property <tt>channelId</tt>.
	 * 
	 * @param channelId value to be assigned to property channelId
	 */
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
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
	};

	public ModifyChannel(Long channelId, Integer oldStatus, Integer newStaus, Long operatorId, Date operatingDate) {
		super();
		this.channelId = channelId;
		this.oldStatus = oldStatus;
		this.newStaus = newStaus;
		setOperatingDate(operatingDate);
		setOperatorId(operatorId);
	}

	public byte[] createMsgData(ModifyCustomer customer) {
		try {
			String json = JSONObject.toJSONString(customer);
			return json.getBytes();
		} catch (Exception e) {
			throw new CustomerException(CustomerExceptionCode.SERIALIZE_DATA_ERROR);
		}
	}

}
