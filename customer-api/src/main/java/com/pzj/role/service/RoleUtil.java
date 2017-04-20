package com.pzj.role.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pzj.authority.service.AuthorityUtil;
import com.pzj.base.common.global.UserGlobalParam.UserMapKeyParam;
import com.pzj.base.entity.SysMenu;
import com.pzj.base.entity.SysRole;
import com.pzj.base.entity.SysRoleMenuKey;
import com.pzj.base.service.sys.IRoleAuthMenuService;
import com.pzj.base.service.sys.IRoleService;
import com.pzj.menu.entity.Menu;
import com.pzj.menu.service.MenuUtil;
import com.pzj.role.entity.Role;

@Component
public class RoleUtil {

    @Autowired
    private IRoleService iroleService = null;
    
    @Autowired
    private IRoleAuthMenuService iroleAuthMenuService = null;

    @Autowired
    private AuthorityUtil authorityUtil = null;

    @Autowired
    private MenuUtil menuUtil;
    
    /**
     * 遍历用户列表，拼接用户Ids
     * 
     */
    public String getRoleIds(List<Role> roles) {

        if (roles == null || roles.isEmpty()) {
            return "";
        }
        StringBuffer buff = new StringBuffer();
        for (Role role : roles) {
            Long id = role.getId();
            if (id != null) {
                buff.append(id).append(",");
            }

        }
        return buff.substring(0, buff.length() - 1);
    }

    public String getRoleIdsOfString(List<String> roleIds) {

        if (roleIds == null || roleIds.isEmpty()) {
            return "";
        }
        StringBuffer buff = new StringBuffer();
        for (String roleId : roleIds) {
            if (roleId != null) {
                buff.append(roleId).append(",");
            }

        }
        return buff.substring(0, buff.length() - 1);
    }

    public String getRoleIdsOfLong(List<Long> roleIds) {

        if (roleIds == null || roleIds.isEmpty()) {
            return "";
        }
        StringBuffer buff = new StringBuffer();
        for (Long roleId : roleIds) {
            if (roleId != null) {
                buff.append(roleId).append(",");
            }

        }
        return buff.substring(0, buff.length() - 1);
    }



    /**
     * 获取角色列表的所有有效菜单列表
     * 
     * @throws Exception
     */
    public List<Menu> getMenuListByRoleList(List<Role> roles)
            throws Exception {
        List<Menu> menus = null;
        if (roles != null && !roles.isEmpty()) {
            String roleIds = getRoleIds(roles);
            List<SysRoleMenuKey> roleMenuList = authorityUtil.getRoleMenuList(
                    roleIds, null);
            if (roleMenuList != null && !roleMenuList.isEmpty()) {
                Map<String, String> roleMenuIdsMap = authorityUtil
                        .getRoleMenuIds(roleMenuList);
                String menuIds = roleMenuIdsMap.get("menuIds");

                menus = menuUtil.getMenuListByMenuIds(menuIds);
            }
        }
        return menus;
    }

    /**
     * 根据角色Ids获取所有有效角色列表
     * 
     * @throws Exception
     */
    public List<Role> getRoleListByRoleIds(String roleIds) throws Exception {
        return getRoleListByRoleIds(roleIds, "1");
    }

    public List<Role> getRoleListByRoleIds(String roleIds,String delFlag) throws Exception {
        Map<String, String> idsMap = new HashMap<>(2);
        idsMap.put(UserMapKeyParam.ROLE_MAP_KEY, roleIds);
        if (checkDelFlag(delFlag)){
            idsMap.put(UserMapKeyParam.DELE_MAP_KEY, delFlag);
        }
        List<Role> roles = null;
        List<SysRole> sysRoleList = iroleService.findByIds(idsMap);
        if (sysRoleList != null && !sysRoleList.isEmpty()) {
            roles = Role.sList2CList(sysRoleList);
        }
        return roles;
    }

    public boolean checkDelFlag(String delFlag){
        return  delFlag != null && (delFlag == "0" || delFlag == "1" || delFlag == "2");
    }

    /**
     * 给角色封装对应的有效菜单列表
     * 
     * @throws Exception
     * 
     */
    public void setRoleMenuList(List<Role> roles) throws Exception {
        if (roles != null && !roles.isEmpty()) {
            String roleIds = getRoleIds(roles);
            List<SysRoleMenuKey> roleMenuList = authorityUtil.getRoleMenuList(
                    roleIds, null);
            if (roleMenuList != null && !roleMenuList.isEmpty()) {
                Map<String, String> roleMenuIdsMap = authorityUtil
                        .getRoleMenuIds(roleMenuList);
                String menuIds = roleMenuIdsMap.get("menuIds");

                List<Menu> menus = menuUtil.getMenuListByMenuIds(menuIds);
                if (menus != null && !menus.isEmpty()) {
                    for (Role role : roles) {
                        List<Menu> menuList = new ArrayList<Menu>();
                        String roleId = String.valueOf(role.getId());
                        for (SysRoleMenuKey roleMenu : roleMenuList) {
                            if (roleId.equals(roleMenu.getRoleId())) {
                                for (Menu menu : menus) {
                                    if (roleMenu.getMenuId().equals(
                                            String.valueOf(menu.getId()))) {
                                        menuList.add(menu);
                                    }
                                }
                            }

                        }
                        role.setMlist(menuList);
                    }
                }

            }

        }

    }

    /**
     * 将菜单列表封装到对应的角色列表里
     * 
     */
    public void setMenuListTRoleList(List<Role> roles, List<Menu> menus) {
        if (roles != null && !roles.isEmpty()) {
            String roleIds = getRoleIds(roles);
            List<SysRoleMenuKey> roleMenuList = authorityUtil.getRoleMenuList(
                    roleIds, null);
            if (roleMenuList != null && !roleMenuList.isEmpty()) {
                if (menus != null && !menus.isEmpty()) {
                    for (Role role : roles) {
                        List<Menu> menuList = new ArrayList<Menu>();
                        String roleId = String.valueOf(role.getId());
                        for (SysRoleMenuKey roleMenu : roleMenuList) {
                            if (roleId.equals(roleMenu.getRoleId())) {
                                for (Menu menu : menus) {
                                    if (roleMenu.getMenuId().equals(
                                            menu.getId())) {
                                        menuList.add(menu);
                                    }
                                }
                            }

                        }
                        role.setMlist(menuList);
                    }
                }
            }
        }
    }

    /**
     * 拆分角色的最新菜单列表，分为：需要新加的和需要删除的
     * 
     * @param roleId
     *            角色主键Id
     * @param menuList
     *            菜单列表
     * @return
     * @throws Exception
     */

    public Map<String, List> splitData(String roleId, List<Menu> menuList)
            throws Exception {
        Map<String, List> map = new HashMap<String, List>();

        // 获取数据库里角色的菜单列表
        List<SysMenu> newMenu = new ArrayList<SysMenu>();
        List<SysRoleMenuKey> delMenu = new ArrayList<SysRoleMenuKey>();

        // 获取数据库现有的关联关系
        SysRoleMenuKey roleMenu = new SysRoleMenuKey();
        roleMenu.setRoleId(roleId);

        List<SysRoleMenuKey> roleMenuList = iroleAuthMenuService
                .findListByParams(roleMenu);

        if (roleMenuList == null || roleMenuList.isEmpty()) {
            newMenu = Menu.cList2SList(menuList);
        } else {
            Map<String, String> mapIds = authorityUtil
                    .getRoleMenuIds(roleMenuList);
            String havMenuIds = mapIds.get("menuIds");
            Map<String, SysMenu> checkMap = new HashMap<String, SysMenu>();

            for (Menu menu : menuList) {
                Long menuId = menu.getId();
                if (menuId == null || menuId < 1) {
                    newMenu.add(Menu.createNewSysMenu(menu));
                    continue;
                }
                if (havMenuIds.indexOf(menuId.toString()) > -1) {
                    checkMap.put(String.valueOf(menuId),
                            Menu.changeTSysMenu(menu));
                } else {
                    newMenu.add(Menu.changeTSysMenu(menu));
                }
            }
            for (SysRoleMenuKey roleMenu_ : roleMenuList) {
                if (!checkMap.containsKey(roleMenu_.getMenuId())) {
                    delMenu.add(roleMenu_);
                }
            }
        }

        map.put("NEW", newMenu);
        map.put("DELETE", delMenu);

        return map;
    }
}
