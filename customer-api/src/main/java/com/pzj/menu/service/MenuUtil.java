package com.pzj.menu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pzj.base.common.global.UserGlobalParam.UserMapKeyParam;
import com.pzj.base.entity.SysMenu;
import com.pzj.base.service.sys.IMenuService;
import com.pzj.menu.entity.Menu;

@Component
public class MenuUtil {

    @Autowired
    private IMenuService imenuService = null;

    /**
     * 遍历菜单列表，拼接菜单Ids
     * 
     */
    public String getMenuIds(List<Menu> menus) {

        if (menus == null || menus.isEmpty()) {
            return "";
        }
        StringBuffer buff = new StringBuffer();
        for (Menu menu : menus) {
            Long id = menu.getId();
            if (id != null) {
                buff.append(id).append(",");
            }

        }
        return buff.substring(0, buff.length() - 1);
    }

    /**
     * 根据角色Ids获取所有有效角色列表
     * 
     * @throws Exception
     */
    public List<Menu> getMenuListByMenuIds(String menuIds)
            throws Exception {
        Map<String, String> idsMap = new HashMap<String, String>();
        idsMap.put(UserMapKeyParam.MENU_MAP_KEY, menuIds);
        idsMap.put(UserMapKeyParam.DELE_MAP_KEY, "1");
        List<Menu> menus = null;
        List<SysMenu> sysMenus = imenuService.findSysMenuKeyByIds(idsMap);
        if (sysMenus != null && !sysMenus.isEmpty()) {
            menus = Menu.sList2CList(sysMenus);
        }
        return menus;
    }
}
