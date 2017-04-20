package com.pzj.authority.entity;

import java.io.Serializable;

/**
 * 用户的菜单权限
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-8-27 下午2:05:09
 */
public class CustomerAuthMenu implements Serializable {

	private static final long serialVersionUID = -5230511057144988780L;

	/** 用户主键id */
	private Long userId;

	/** 菜单主键id */
	private Long menuId;

	public CustomerAuthMenu() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

}
