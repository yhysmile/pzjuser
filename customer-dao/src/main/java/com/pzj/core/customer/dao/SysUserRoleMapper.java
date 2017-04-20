package com.pzj.core.customer.dao;

import java.util.List;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysRole;
import com.pzj.base.entity.SysUserRoleKey;

@MyBatisDao
public interface SysUserRoleMapper extends
        BaseRelationshipMapper<SysUserRoleKey> {

    List<SysUserRoleKey> selectRoleByRelationRole(SysUserRoleKey relationParam, SysRole roleParam);

}