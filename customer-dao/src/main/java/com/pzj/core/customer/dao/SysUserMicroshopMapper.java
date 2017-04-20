package com.pzj.core.customer.dao;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysUserMicroshop;

/**
 * Created by Administrator on 2016-12-13.
 */
@MyBatisDao
public interface SysUserMicroshopMapper extends BaseMapper<SysUserMicroshop> {

    Integer updateByUserId(SysUserMicroshop record);
}
