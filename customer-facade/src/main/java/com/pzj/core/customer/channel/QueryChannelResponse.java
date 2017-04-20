package com.pzj.core.customer.channel;

import java.io.Serializable;
import java.util.Date;

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

	/** 创建日期 */
	private Date createDate;

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
