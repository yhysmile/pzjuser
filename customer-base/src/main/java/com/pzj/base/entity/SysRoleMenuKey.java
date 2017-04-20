package com.pzj.base.entity;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;

public class SysRoleMenuKey extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3056018059025728492L;

    private String            roleId;

    private String            menuId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

}