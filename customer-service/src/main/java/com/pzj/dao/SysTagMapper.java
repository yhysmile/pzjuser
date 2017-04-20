package com.pzj.dao;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysTag;

import java.util.Set;

/**
 * Created by Administrator on 2016-11-7.
 */
@MyBatisDao
public interface SysTagMapper extends BaseUserMapper<SysTag>{
    Set<String> existTagNames(Set<String> names);
}
