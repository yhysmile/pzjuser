package com.pzj.core.customer.channel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-2-27.
 * 渠道查询参数
 */
public class QueryChannelRequest implements Serializable {
	/**  */
	private static final long serialVersionUID = 4588497923335193031L;
	//供应商id
	private Long supplierId;
	//渠道编号
	private Long id;
	//渠道名称
	private String name;
	//创建时间起
	private Date createDate;
	//创建时间止
	private Date createEndDate;
	//渠道id集合
	private List<Long> channelIds;

	/**
	 * Getter method for property <tt>channelIds</tt>.
	 * 
	 * @return property value of channelIds
	 */
	public List<Long> getChannelIds() {
		return channelIds;
	}

	/**
	 * Setter method for property <tt>channelIds</tt>.
	 * 
	 * @param channelIds value to be assigned to property channelIds
	 */
	public void setChannelIds(List<Long> channelIds) {
		this.channelIds = channelIds;
	}

	/**
	 * Getter method for property <tt>createEndDate</tt>.
	 * 
	 * @return property value of createEndDate
	 */
	public Date getCreateEndDate() {
		return createEndDate;
	}

	/**
	 * Setter method for property <tt>createEndDate</tt>.
	 * 
	 * @param createEndDate value to be assigned to property createEndDate
	 */
	public void setCreateEndDate(Date createEndDate) {
		this.createEndDate = createEndDate;
	}

	/**
	 * 使用状态1启用0禁用2删除
	 */
	private Integer delFlag;

	/**
	 * Getter method for property <tt>delFlag</tt>.
	 * 
	 * @return property value of delFlag
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	/**
	 * Setter method for property <tt>delFlag</tt>.
	 * 
	 * @param delFlag value to be assigned to property delFlag
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
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
}
