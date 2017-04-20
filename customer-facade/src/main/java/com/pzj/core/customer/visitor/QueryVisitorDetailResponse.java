package com.pzj.core.customer.visitor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-2-24.
 */
public class QueryVisitorDetailResponse implements Serializable {
	private static final long serialVersionUID = 7194430384987554356L;
	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 状态（1：启用，0：禁用）
	 */
	private Integer status;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 手机号
	 */
	private String phoneNum;

	/**
	 * 身份证号
	 */
	private String idNum;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 操作id
	 */
	private Long operator;
	/**
	 * 创建人id
	 */
	private Long createBy;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新人id
	 */
	private Long updateBy;

	/**
	 * 更新时间
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
