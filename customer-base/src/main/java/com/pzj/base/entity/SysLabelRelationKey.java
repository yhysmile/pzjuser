package com.pzj.base.entity;

import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;

public class SysLabelRelationKey extends BaseEntity {

	private static final long serialVersionUID = 5525855809380805454L;

	private String objId;
	/**
	 * 供应商id,目前用于区分渠道的不同来源
	 */
	private Long sId;
	private String relId;
	private String relType;

	/**
	 * 根据objId集合查询
	 */
	private List<Long> queryObjIds;

	/**
	 * 根据relId集合查询
	 */
	private List<Long> queryRelIds;

	private List<SysLabel> labels;

	/**
	 * 关系状态，1、启用 0、禁用
	 */
	private Integer status;

	private Long createBy;

	private Long updateBy;

	private Date createDate;

	private Date updateDate;

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public SysLabelRelationKey() {

	}

	public List<Long> getQueryObjIds() {
		return queryObjIds;
	}

	public void setQueryObjIds(List<Long> queryObjIds) {
		this.queryObjIds = queryObjIds;
	}

	public List<Long> getQueryRelIds() {
		return queryRelIds;
	}

	public void setQueryRelIds(List<Long> queryRelIds) {
		this.queryRelIds = queryRelIds;
	}

	public SysLabelRelationKey(String objId, String relId, String relType) {
		setObjId(objId);
		setRelId(relId);
		setRelType(relType);
	}

	/**
	 * 获取objId
	 * 
	 * @return objId objId
	 */
	public String getObjId() {
		return objId;
	}

	/**
	 * 设置objId
	 * 
	 * @param objId
	 *            objId
	 */
	public void setObjId(String objId) {
		this.objId = objId;
	}

	/**
	 * 获取relId
	 * 
	 * @return relId relId
	 */
	public String getRelId() {
		return relId;
	}

	/**
	 * 设置relId
	 * 
	 * @param relId
	 *            relId
	 */
	public void setRelId(String relId) {
		this.relId = relId;
	}

	/**
	 * 获取relType
	 * 
	 * @return relType relType
	 */
	public String getRelType() {
		return relType;
	}

	/**
	 * 设置relType
	 * 
	 * @param relType
	 *            relType
	 */
	public void setRelType(String relType) {
		this.relType = relType;
	}

	public List<SysLabel> getLabels() {
		return labels;
	}

	public void setLabels(List<SysLabel> labels) {
		this.labels = labels;
	}

	public Long getsId() {
		return sId;
	}

	public void setsId(Long sId) {
		this.sId = sId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
