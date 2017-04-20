/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.profile;

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
	 * 渠道包含的用户数量
	 */
	private Integer userNum;
	/**
	 * 渠道包含的用户姓名，逗号隔开的字符串，取前3位
	 */
	private String userNames;
	/**
	 * 渠道包含的用户id，逗号隔开的字符串
	 */
	private String userIds;

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
	 * Getter method for property <tt>userNum</tt>.
	 * 
	 * @return property value of userNum
	 */
	public Integer getUserNum() {
		return userNum;
	}

	/**
	 * Setter method for property <tt>userNum</tt>.
	 * 
	 * @param userNum value to be assigned to property userNum
	 */
	public void setUserNum(Integer userNum) {
		this.userNum = userNum;
	}

	/**
	 * Getter method for property <tt>userNames</tt>.
	 * 
	 * @return property value of userNames
	 */
	public String getUserNames() {
		return userNames;
	}

	/**
	 * Setter method for property <tt>userNames</tt>.
	 * 
	 * @param userNames value to be assigned to property userNames
	 */
	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	/**
	 * Getter method for property <tt>userIds</tt>.
	 * 
	 * @return property value of userIds
	 */
	public String getUserIds() {
		return userIds;
	}

	/**
	 * Setter method for property <tt>userIds</tt>.
	 * 
	 * @param userIds value to be assigned to property userIds
	 */
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

}
