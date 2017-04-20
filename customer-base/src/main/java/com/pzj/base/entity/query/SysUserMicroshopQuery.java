package com.pzj.base.entity.query;

import com.pzj.base.entity.SysUserMicroshop;

import java.util.Set;

/**
 * Created by Administrator on 2016-12-13.
 */
public class SysUserMicroshopQuery extends SysUserMicroshop {
    private Set<Long> userIds;

    public Set<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(Set<Long> userIds) {
        this.userIds = userIds;
    }
}
