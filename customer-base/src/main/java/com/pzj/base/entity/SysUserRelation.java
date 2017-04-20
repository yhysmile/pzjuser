/*
 * SysUserRelation.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * vo.供应商关系
 * 
 * @author 票之家
 */

public class SysUserRelation extends BaseEntity implements Serializable {
	/** 供应商id */
	private Long userId;

	/** 关联供应商id */
	private Long relUserId;

	private List<Long> relUserIds;

	/** 关联类型（1供应商关系，2常用部门） */
	private String relType;

	/**
	 * 创建人ID
	 */
	private Long createBy;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/** 供应商名称 */
	private String userName;

	/** 关联供应商名称 */
	private String relUserName;
	/**
	 * 状态；1:启用；0：禁用
	 */
	private Integer status;

	/**
	 * 修改人ID
	 */
	private Long updateBy;

	/**
	 * 修改时间
	 */
	private Date updateDate;

	/** 设置 供应商id */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/** 得到 供应商id */
	public Long getUserId() {
		return userId;
	}

	/** 设置 关联供应商id */
	public void setRelUserId(Long relUserId) {
		this.relUserId = relUserId;
	}

	/** 得到 关联供应商id */
	public Long getRelUserId() {
		return relUserId;
	}

	/** 设置 关联类型（1供应商关系，2常用部门） */
	public void setRelType(String relType) {
		this.relType = relType;
	}

	/** 得到 关联类型（1供应商关系，2常用部门） */
	public String getRelType() {
		return relType;
	}

	/**
	 * 获取供应商名称
	 * 
	 * @return userName 供应商名称
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置供应商名称
	 * 
	 * @param userName
	 *            供应商名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取关联供应商名称
	 * 
	 * @return relUserName 关联供应商名称
	 */
	public String getRelUserName() {
		return relUserName;
	}

	/**
	 * 设置关联供应商名称
	 * 
	 * @param relUserName
	 *            关联供应商名称
	 */
	public void setRelUserName(String relUserName) {
		this.relUserName = relUserName;
	}

	@Override
	public String toString() {
		return "SysUserRelation [userId=" + userId + ", relUserId=" + relUserId + ", relUserIds=" + relUserIds
				+ ", relType=" + relType + ", createBy=" + createBy + ", createDate=" + createDate + ", userName="
				+ userName + ", relUserName=" + relUserName + ", status=" + status + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + "]";
	}

	public List<Long> getRelUserIds() {
		return relUserIds;
	}

	public void setRelUserIds(List<Long> relUserIds) {
		this.relUserIds = relUserIds;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
