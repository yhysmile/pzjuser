package com.pzj.core.customer.channel;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-2-26.
 */
public class ModifyChannelRequest implements Serializable {
	/**  */
	private static final long serialVersionUID = 1802023383352637344L;
	/**
	 * 渠道id
	 */
	private Long id;
	/**
	 * 渠道名称
	 */
	private String name;
	/**
	 * 修改人id
	 */
	private Long updateBy;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
