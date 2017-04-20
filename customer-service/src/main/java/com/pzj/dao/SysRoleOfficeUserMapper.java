package com.pzj.dao;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysRoleOfficeUserKey;

@MyBatisDao
public interface SysRoleOfficeUserMapper extends
        BaseRelationshipMapper<SysRoleOfficeUserKey> {

}