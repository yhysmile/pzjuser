package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.entity.SysRoleMenuKey;
import com.pzj.base.service.sys.IRoleAuthMenuService;
import com.pzj.base.service.sys.IUserAuthMenuService;
import com.pzj.dao.SysRoleMenuMapper;

@Service("roleAuthMenuService")
public class RoleAuthMenuServiceImpl extends
        BaseRelationshipServiceImpl<SysRoleMenuKey, SysRoleMenuMapper>
        implements IRoleAuthMenuService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserAuthMenuService userAuthMenuService;

    @Override
    public Long insertAuthBatch(List<SysRoleMenuKey> records, boolean syncUserMenu) {
        Long num = 0l;
        String regx = ",";
        try {
            if (records == null) {
                logger.error("方法[RoleAuthMenuService.insertAuthBatch],参数records不可以为空");
                return num;
            }
            Map<String, String> idsMap = getRelationIds(records);
            Map<String, SysRoleMenuKey> havMap = listTMap(findByIds(idsMap), regx);
            List<SysRoleMenuKey> insertList = new ArrayList<SysRoleMenuKey>();
            for (SysRoleMenuKey key : records) {
                String menuId = key.getMenuId();
                String roleId_ = key.getRoleId();
                if (StringUtils.isNotBlank(menuId)
                        && StringUtils.isNotBlank(roleId_)) {
                    String genKey = genMapKey(key, regx);
                    if (!havMap.containsKey(genKey)) {
                        insertList.add(key);
                        havMap.put(genKey, key);
                    }
                }
            }
            if (insertList != null) {
                num += insertBatch(insertList);
                if(syncUserMenu){
                    // 将新加角色的权限与用户挂接
                   userAuthMenuService.insertBatchByRoleAndMenu(insertList);
                }
            }
        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }
    
    public Long delAuthBatch(List<SysRoleMenuKey> records, boolean syncUserMenu) {
        Long num = 0l;
        try {
            if (records == null) {
                logger.error("方法[RoleAuthMenuService.delAuthBatch],参数records不可以为空");
                return num;
            }
            Map<String, String> idsMap = getRelationIds(records);
            
            if(syncUserMenu){
                // 删除用户与菜单的关系
                num += userAuthMenuService.deleteByIds(idsMap);
            }

            // 删除角色与菜单的关系
            num += deleteBatchSelective(records);

        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;

    }

    public String genMapKey(SysRoleMenuKey record, String regx) {
        String key = "";
        if (StringUtils.isBlank(regx)) {
            regx = ",";
        }
        if (record == null) {
            return key;
        }
        String roleId = record.getRoleId();
        String menuId = record.getMenuId();
        if (StringUtils.isBlank(roleId) || StringUtils.isBlank(menuId)) {
            return key;
        }

        return roleId + regx + menuId;

    }

    /**
     * 遍历角色菜单列表，拼接角色Ids，菜单Ids
     * 
     * @param roleMenus
     *            角色菜单关系列表
     * 
     */
    public Map<String, String> getRelationIds(List<SysRoleMenuKey> records) {

        if (records == null || records.isEmpty()) {
            return null;
        }
        StringBuffer roleIds = new StringBuffer();
        StringBuffer menuIds = new StringBuffer();
        for (SysRoleMenuKey record : records) {
            roleIds.append(record.getRoleId()).append(",");
            menuIds.append(record.getMenuId()).append(",");
        }
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isNotBlank(roleIds)) {
            map.put(UserGlobalParam.UserMapKeyParam.ROLE_MAP_KEY,
                    roleIds.substring(0, roleIds.length() - 1));
        }
        if (StringUtils.isNotBlank(menuIds)) {
            map.put(UserGlobalParam.UserMapKeyParam.MENU_MAP_KEY,
                    menuIds.substring(0, menuIds.length() - 1));
        }

        return map;
    }
}
