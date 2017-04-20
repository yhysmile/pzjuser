package com.pzj.dao;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysMenu;

/**
 * 
 * @author apple
 * 
 */
@MyBatisDao
public interface SysMenuMapper extends BaseUserMapper<SysMenu> {

    List<SysMenu> findByIdsMap(Map<String, String> map);

}