package com.pzj.dao;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysMenu;
import com.pzj.base.entity.SysUserMenuKey;
import com.pzj.base.entity.SysUserRoleMenuVo;

@MyBatisDao
public interface SysUserMenuMapper extends
        BaseRelationshipMapper<SysUserMenuKey> {

    /**
     * 根据主键集合查询用户角色菜单关系
     * 
     * @param parameterMap
     * @return
     */
    List<SysUserRoleMenuVo> findURMByIds(Map<String, String> parameterMap);

    /**
     * 根据主键查询用户角色菜单关系
     * 
     * @param parameterMap
     * @return
     */
    List<SysUserRoleMenuVo> findURMById(SysUserRoleMenuVo vo);

    List<SysUserMenuKey> findMenuByRelationMenu(SysUserMenuKey userMenuParam, SysMenu menuParam);

}