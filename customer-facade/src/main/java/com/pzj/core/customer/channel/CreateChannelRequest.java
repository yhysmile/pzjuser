package com.pzj.core.customer.channel;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-2-26.
 * 创建渠道
 */
public class CreateChannelRequest implements Serializable {
	/**  */
	private static final long serialVersionUID = -5500095856367193704L;
	/**
	 * 渠道名称
	 */
	private String name;
	/**
	 * 创建人id
	 */
	private Long createBy;
	/**
	 * 创建渠道的软件平台编号
	 */
	private Integer dataSource;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Integer getDataSource() {
		return dataSource;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

}
