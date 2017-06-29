/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.entitys;

import java.io.Serializable;

/**
 * 渠道包含的用户信息
 * @author Administrator
 * @version $Id: ChannelUsers.java, v 0.1 2017年4月6日 上午10:36:08 Administrator Exp $
 */
public class ChannelUsers implements Serializable {

	/**  */
	private static final long serialVersionUID = 2951311575816167552L;

	/**
	 * 渠道id
	 */
	private Long channelId;
	/**
	 * 渠道包含的用户名称
	 */
	private String userName;
	/**
	 * 渠道包含的用户id
	 */
	private Long userId;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
