package com.pzj.base.entity.query;

import com.pzj.base.entity.SysUser;

/**
 * Created by Administrator on 2016-2-19.
 * <p/>
 * 用于查询的模型
 * <p/>
 */
public class User extends SysUser {
    /**
     * 用于查询，表示条件之前是并且的关系。
     * <p/>
     * 在SysUserMapper.xml的selectUserExclusiveUserRelation中使用
     */
    private Boolean whereIsAnd = true;
    /**
     * 用于查询，表示查询关联的用户，否则查询没有关联的用户。
     * <p/>
     * 在SysUserMapper.xml的selectUserExclusiveUserRelation中使用
     */
    private Boolean inclusiveRelationUser = true;

    public Boolean getInclusiveRelationUser() {
        return inclusiveRelationUser;
    }

    public void setInclusiveRelationUser(Boolean inclusiveRelationUser) {
        this.inclusiveRelationUser = inclusiveRelationUser;
    }

    public Boolean getWhereIsAnd() {
        return whereIsAnd;
    }

    public void setWhereIsAnd(Boolean whereIsAnd) {
        this.whereIsAnd = whereIsAnd;
    }
}
