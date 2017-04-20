package com.pzj.base.entity;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;

/**
 * <h3>部门与角色关系</h3>
 */
public class SysOfficeRoleKey extends BaseEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -8014542411363291037L;

    private String            roleId;

    private String            officeId;

    /**
     * <h3>获取角色id</h3>
     * @return
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * <h3>设置角色id</h3>
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * <h3>获取部门id</h3>
     * @return
     */
    public String getOfficeId() {
        return officeId;
    }

    /**
     * <h3>设置部门id</h3>
     * @param officeId
     */
    public void setOfficeId(String officeId) {
        this.officeId = officeId == null ? null : officeId.trim();
    }
}