package com.pzj.authority.entity;

import java.io.Serializable;

/**
 * 用户配置角色
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-8-27 下午2:05:09
 */
public class CustomerAuthRole implements Serializable {

	private static final long serialVersionUID = -5230511057144988780L;

	/** 用户主键id */
	private Long userId;

	/** 角色主键id */
	private Long roleId;

	public CustomerAuthRole() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
