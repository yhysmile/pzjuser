package com.pzj.dao;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysUserOfficeKey;

@MyBatisDao
public interface SysUserOfficeMapper extends
        BaseRelationshipMapper<SysUserOfficeKey> {

}