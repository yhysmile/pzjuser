package com.pzj.authority.entity;

import java.io.Serializable;

/**
 * 角色的菜单权限
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-8-27 下午2:05:09
 */
public class RoleAuthMenu implements Serializable {

	private static final long serialVersionUID = -7861657774947922117L;

	/** 主键id */
	private Long ram_id;

	/** 角色id */
	private Long roleId;

	/** 菜单id */
	private Long menuId;

	public RoleAuthMenu() {
		super();
	}

	public Long getRam_id() {
		return ram_id;
	}

	public void setRam_id(Long ram_id) {
		this.ram_id = ram_id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

}
