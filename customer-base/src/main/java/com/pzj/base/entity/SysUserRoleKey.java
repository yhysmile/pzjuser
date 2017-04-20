package com.pzj.base.entity;

import java.io.Serializable;
import java.util.List;

import com.pzj.base.common.BaseDataSourceEntity;

public class SysUserRoleKey extends BaseDataSourceEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1367013084584108992L;

    private String            userId;

    private String            roleId;

    private List<SysRole>     roles;

    private List<SysUser>     users;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}