package com.pzj.core.customer.profile;

import java.util.Date;

public class UserRelationEntity implements java.io.Serializable {

	private static final long serialVersionUID = -6002272867022953466L;
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 供应商id
	 */
	private Long supplierId;
	/**
	 * 关联用户id
	 */
	private Long relId;
	/**
	 * 关联类型（1供应商关系，2常用部门，3导游，4分销商）
	 */
	private Integer relType;
	/**
	 * 创建用户id
	 */
	private Long createUserId;
	/**
	 * 创建时间
	 */
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getRelId() {
		return relId;
	}

	public void setRelId(Long relId) {
		this.relId = relId;
	}

	public Integer getRelType() {
		return relType;
	}

	public void setRelType(Integer relType) {
		this.relType = relType;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
