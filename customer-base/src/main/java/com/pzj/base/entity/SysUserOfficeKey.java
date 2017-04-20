package com.pzj.base.entity;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;

/**
 * <h3>用户与部门关系</h3>
 */
public class SysUserOfficeKey extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1675299070277849559L;

    private String            userId;

    private String            officeId;

    /**
     * <h3>获取用户id</h3>
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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