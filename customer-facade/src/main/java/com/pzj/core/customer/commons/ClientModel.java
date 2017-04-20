package com.pzj.core.customer.commons;

import java.util.Date;

/**
 * 客户model
 * @author yhy
 *
 */
public class ClientModel implements java.io.Serializable {

	private static final long serialVersionUID = 4599856524671982988L;
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 主账号id
	 */
	private Long rootId;
	/**
	 * 客户名称
	 */
	private String name;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 创建用户id
	 */
	private Long createUser;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 修改用户id
	 */
	private Long updateUser;
	/**
	 * 修改时间
	 */
	private Date updateDate;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
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

	public Long getRootId() {
		return rootId;
	}

	public void setRootId(Long rootId) {
		this.rootId = rootId;
	}

}
