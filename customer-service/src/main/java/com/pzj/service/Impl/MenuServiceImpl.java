package com.pzj.service.Impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.entity.SysMenu;
import com.pzj.base.service.sys.IMenuService;
import com.pzj.core.customer.dao.SysMenuMapper;

@Service("menuService")
public class MenuServiceImpl extends
        BaseUserServiceImpl<SysMenu, SysMenuMapper> implements IMenuService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysMenuMapper menuMapper;

    /**
     * 根据主键集合串Ids查询菜单列表
     * 
     * @param IdsMap
     *            菜单Ids
     * 
     */
    public List<SysMenu> findSysMenuKeyByIds(Map<String, String> IdsMap) {
        List<SysMenu> sysMenuList = null;
        try {
            sysMenuList = menuMapper.findByIdsMap(IdsMap);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return sysMenuList;
    }


}
