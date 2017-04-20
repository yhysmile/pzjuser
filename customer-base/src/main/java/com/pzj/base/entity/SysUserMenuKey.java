package com.pzj.base.entity;

import java.io.Serializable;
import java.util.List;

import com.pzj.base.common.BaseDataSourceEntity;

public class SysUserMenuKey extends BaseDataSourceEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1680786900626028841L;

    private String            menuId;

    private String            userId;

    private List<SysUser>     users;

    private List<SysMenu>     menus;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public boolean equals(SysUserMenuKey userMenu) {
        if (userMenu == this) {
            return true;
        }
        if (userMenu != null && (userMenu.getMenuId() != null) && (userMenu.getUserId() != null)) {
            if (userMenu.getMenuId().equals(this.menuId)
                && userMenu.getUserId().equals(this.menuId)) {
                return true;
            }
        }
        return false;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    public List<SysMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<SysMenu> menus) {
        this.menus = menus;
    }
}