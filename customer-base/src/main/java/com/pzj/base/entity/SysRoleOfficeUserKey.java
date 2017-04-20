package com.pzj.base.entity;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;

/**
 * <h3>用户与部门与角色关系</h3>
 */
public class SysRoleOfficeUserKey extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -940724867360943803L;

    private String            roleId;

    private String            officeId;

    private String            userId;

    private String            relType;

    /**
     * <h3>获取用户id</h3>
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     * <h3>设置用户id</h3>
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    /**
     * <h3>设置关系类型</h3>
     * @return
     */
    public String getRelType() {
        return relType;
    }

    /**
     * <h3>获取关系类型</h3>
     * @param relType
     */
    public void setRelType(String relType) {
        this.relType = relType;
    }

}