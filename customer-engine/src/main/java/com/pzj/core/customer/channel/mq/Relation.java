/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.channel.mq;

import java.io.Serializable;

/**
 * 关系表
 * @author Administrator
 * @version $Id: Relation.java, v 0.1 2017年4月7日 下午3:31:03 Administrator Exp $
 */
public class Relation implements Serializable {

	/**  */
	private static final long serialVersionUID = 4494699274392478528L;
	private Long customerId;
	private Long channelId;

	public Relation() {
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
	};

	public Relation(Long customerId, Long channelId) {
		this.channelId = channelId;
		this.customerId = customerId;
	}

}
