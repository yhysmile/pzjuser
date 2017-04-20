package com.pzj.authority.entity;

import java.io.Serializable;

import com.pzj.base.entity.SysRoleOfficeUserKey;

public class DepartmentAuthCustomerRole implements Serializable {

    private static final long serialVersionUID = -4485027887449172446L;

    /** 角色id */
    private String roleId;

    /** 部门id */
    private String departmentId;

    /** 用户id */
    private String userId;

    /**
     * 获取角色id
     * 
     * @return roleId 角色id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     * 
     * @param roleId
     *            角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取部门id
     * 
     * @return departmentId 部门id
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门id
     * 
     * @param departmentId
     *            部门id
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取用户id
     * 
     * @return userId 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     * 
     * @param userId
     *            用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static DepartmentAuthCustomerRole changeTDepartmentAuthCustomerRole(
            SysRoleOfficeUserKey roleOfficeUser) throws Exception {
        DepartmentAuthCustomerRole dcrKey = new DepartmentAuthCustomerRole();
        dcrKey.setDepartmentId(roleOfficeUser.getOfficeId());
        dcrKey.setRoleId(roleOfficeUser.getRoleId());
        dcrKey.setUserId(roleOfficeUser.getUserId());
        return dcrKey;

    }

}
