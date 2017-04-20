package com.pzj.dao;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysRoleMenuKey;

@MyBatisDao
public interface SysRoleMenuMapper extends
        BaseRelationshipMapper<SysRoleMenuKey> {

}