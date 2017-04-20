package com.pzj.base.entity.query;

import java.util.Set;

import com.pzj.base.entity.SysUserDraft;

/**
 * Created by Administrator on 2016-12-2.
 */
public class SysUserDraftQuery extends SysUserDraft {
    private Set<Long> userIds;

    private Set<Integer> checkTypes;

    public Set<Integer> getCheckTypes() {
        return checkTypes;
    }

    public void setCheckTypes(Set<Integer> checkTypes) {
        this.checkTypes = checkTypes;
    }

    public Set<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(Set<Long> userIds) {
        this.userIds = userIds;
    }
}
