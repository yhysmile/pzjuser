package com.pzj.core.customer.channel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-2-27.
 * 渠道查询返回
 */
public class QueryChannelResponse implements Serializable {
	/**  */
	private static final long serialVersionUID = -8147957579350691494L;
	/**  */
	//渠道id
	private Long id;
	//渠道名称
	private String name;
	//用户id
	private List<Long> userIds;
	// 创建日期 
	private Date createDate;
	//用户名称，取前三个
	private String userNames;

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
	public List<Long> getUserIds() {
		return userIds;
	}

	/**
	 * Setter method for property <tt>userIds</tt>.
	 * 
	 * @param userIds value to be assigned to property userIds
	 */
	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public QueryChannelResponse() {
		super();
	};

	public QueryChannelResponse(Long id, String name, Date createDate) {
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	};
}
