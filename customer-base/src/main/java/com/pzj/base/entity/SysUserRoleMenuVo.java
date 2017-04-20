package com.pzj.base.entity;

import java.io.Serializable;
import java.util.*;

import org.apache.commons.lang.StringUtils;

import com.pzj.base.common.global.UserGlobalParam;

public class SysUserRoleMenuVo implements Serializable {

    private static final long serialVersionUID = 5057013250716956699L;

    /** 用户主键Id */
    private String            userId;

    /** 角色主键Id */
    private String            roleId;

    private String            dataSource;

    /** 菜单主键Id */
    private String            menuId;

    /**
     * 获取用户主键Id
     * 
     * @return userId 用户主键Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户主键Id
     * 
     * @param userId
     *            用户主键Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取角色主键Id
     * 
     * @return roleId 角色主键Id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色主键Id
     * 
     * @param roleId
     *            角色主键Id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取菜单主键Id
     * 
     * @return menuId 菜单主键Id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单主键Id
     * 
     * @param menuId
     *            菜单主键Id
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * 遍历用户角色菜单列表，拼接用户Ids:userIds, 角色Ids:roleIds，菜单Ids:menuIds
     * 
     * @param roleMenus
     *            角色菜单关系列表
     * 
     */
    public static Map<String, String> getStringForIds(List<SysUserRoleMenuVo> keys) {

        if (keys == null || keys.isEmpty()) {
            return null;
        }
        StringBuffer roleIds = new StringBuffer();
        StringBuffer menuIds = new StringBuffer();
        StringBuffer userIds = new StringBuffer();

        StringBuffer dataSources = new StringBuffer();
        HashSet<String> dataSourceSet = new HashSet<>();

        for (SysUserRoleMenuVo key : keys) {
            roleIds.append(key.getRoleId()).append(",");
            menuIds.append(key.getMenuId()).append(",");
            userIds.append(key.getUserId()).append(",");

            if (!StringUtils.isBlank(key.getDataSource())) {
                dataSourceSet.add(key.getDataSource());
            }
        }
        Map<String, String> map = new HashMap<>();
        map.put("roleIds", roleIds.substring(0, roleIds.length() - 1));
        map.put("menuIds", menuIds.substring(0, menuIds.length() - 1));
        map.put("userIds", userIds.substring(0, userIds.length() - 1));

        for (String dataSource : dataSourceSet) {
            dataSources.append(dataSource).append(",");
        }

        if (dataSources.length() > 1)
            map.put(UserGlobalParam.UserMapKeyParam.DATASOURCES_KEY,
                dataSources.substring(0, dataSources.length() - 1));
        return map;
    }

    /**
     * 遍历用户角色菜单列表，获取角色列表：roleIds，菜单列表：menuIds，用户列表：userIds
     * 
     * @param keys
     *            用户角色菜单关系列表
     * 
     */
    public static Map<String, List<String>> getListForIds(List<SysUserRoleMenuVo> keys) {

        if (keys == null || keys.isEmpty()) {
            return null;
        }
        List<String> roleIdList = new ArrayList<String>();
        List<String> menuIdList = new ArrayList<String>();
        List<String> userIdList = new ArrayList<String>();
        for (SysUserRoleMenuVo key : keys) {
            roleIdList.add(key.getRoleId());
            menuIdList.add(key.getMenuId());
            userIdList.add(key.getUserId());
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("roleIds", roleIdList);
        map.put("menuIds", menuIdList);
        map.put("userIds", userIdList);
        return map;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
}
