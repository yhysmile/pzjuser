package com.pzj.authority.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pzj.base.common.BaseVO;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.entity.*;
import com.pzj.base.service.sys.*;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.channel.service.impl.ChannelVoUtil;

@Component
public class AuthorityUtil {

    @Autowired
    private IUserAuthRoleService iuserAuthRoleService = null;

    @Autowired
    private IUserAuthMenuService iuserAuthMenuService = null;

    @Autowired
    private IUserAuthOfficeService iuserAuthOfficeService = null;

    @Autowired
    private IRoleAuthMenuService iroleAuthMenuService = null;

    @Autowired
    private IRoleAuthOfficeService iroleAuthOfficeService = null;

    @Autowired
    private ILabelRelationService ilabelRelationService = null;

    @Autowired
    private ChannelVoUtil channelVoUtil;

    /**
     * 校验id重复
     */
    public List<Long> checkIDRepetition(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return null;
        }
        StringBuffer buff = new StringBuffer();
        List<Long> checkdList = new ArrayList<Long>();
        for (Long id : ids) {
            if (id == null || buff.indexOf(id + ",") > -1) {
                continue;
            }
            checkdList.add(id);
        }
        return checkdList;
    }

    /**
     * 校验对象重复
     * 
     * @return
     */
    public <T extends BaseVO> List<T> checkBeanRepetition(List<T> beans) {
        if (beans == null || beans.isEmpty()) {
            return null;
        }
        StringBuffer buff = new StringBuffer();
        List<T> checkdList = new ArrayList<T>();
        for (T bean : beans) {
            Long id = bean.getId();
            if (id == null || buff.indexOf(id + ",") > -1) {
                continue;
            }
            checkdList.add(bean);
        }
        return checkdList;

    }

    /**
     * 遍历用户角色关系列表，拼接用户Ids，角色Ids
     * 
     * @param userRoles
     *            用户角色关系列表
     * 
     */
    public Map<String, String> getCustomerRoleIds(
            List<SysUserRoleKey> userRoles) {

        if (userRoles == null || userRoles.isEmpty()) {
            return null;
        }
        StringBuffer userIds = new StringBuffer();
        StringBuffer roleIds = new StringBuffer();
        for (SysUserRoleKey userRole : userRoles) {
            userIds.append(userRole.getUserId()).append(",");
            roleIds.append(userRole.getRoleId()).append(",");
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("userIds", userIds.substring(0, userIds.length() - 1));
        map.put("roleIds", roleIds.substring(0, roleIds.length() - 1));
        return map;
    }

    /**
     * 遍历用户菜单关系列表，拼接用户Ids，菜单Ids
     * 
     * @param userMenus
     *            用户角色关系列表
     * 
     */
    public Map<String, String> getCustomerMenuIds(
            List<SysUserMenuKey> userMenus) {

        if (userMenus == null || userMenus.isEmpty()) {
            return null;
        }
        StringBuffer userIds = new StringBuffer();
        StringBuffer menuIds = new StringBuffer();
        for (SysUserMenuKey userMenu : userMenus) {
            userIds.append(userMenu.getUserId()).append(",");
            menuIds.append(userMenu.getMenuId()).append(",");
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("userIds", userIds.substring(0, userIds.length() - 1));
        map.put("menuIds", menuIds.substring(0, menuIds.length() - 1));
        return map;
    }

    /**
     * 遍历用户部门关系列表，拼接用户Ids，部门Ids
     * 
     * @param useroffices
     *            用户部门关系列表
     * 
     */
    public Map<String, String> getCustomerDepartmentIds(
            List<SysUserOfficeKey> useroffices) {

        if (useroffices == null || useroffices.isEmpty()) {
            return null;
        }
        StringBuffer userIds = new StringBuffer();
        StringBuffer officeIds = new StringBuffer();
        for (SysUserOfficeKey useroffice : useroffices) {
            userIds.append(useroffice.getUserId()).append(",");
            officeIds.append(useroffice.getOfficeId()).append(",");
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("userIds", userIds.substring(0, userIds.length() - 1));
        map.put("officeIds", officeIds.substring(0, officeIds.length() - 1));
        return map;
    }

    /**
     * 遍历角色菜单列表，拼接角色Ids，菜单Ids
     * 
     * @param roleMenus
     *            角色菜单关系列表
     * 
     */
    public Map<String, String> getRoleMenuIds(
            List<SysRoleMenuKey> roleMenus) {

        if (roleMenus == null || roleMenus.isEmpty()) {
            return null;
        }
        StringBuffer roleIds = new StringBuffer();
        StringBuffer menuIds = new StringBuffer();
        for (SysRoleMenuKey roleMenu : roleMenus) {
            roleIds.append(roleMenu.getRoleId()).append(",");
            menuIds.append(roleMenu.getMenuId()).append(",");
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("roleIds", roleIds.substring(0, roleIds.length() - 1));
        map.put("menuIds", menuIds.substring(0, menuIds.length() - 1));
        return map;
    }

    /**
     * 遍历角色部门用户列表，拼接角色Ids，部门Ids，用户Ids
     * 
     * @param roledeparts
     *            角色部门关系列表
     * 
     */
    public Map<String, String> getRoleDepartmentIds(
            List<SysRoleOfficeUserKey> roledeparts) {

        if (roledeparts == null || roledeparts.isEmpty()) {
            return null;
        }
        StringBuffer roleIds = new StringBuffer();
        StringBuffer officeIds = new StringBuffer();
        StringBuffer userIds = new StringBuffer();
        for (SysRoleOfficeUserKey roledept : roledeparts) {
            if (roleIds.indexOf(roledept.getRoleId() + ",") < 0)
                roleIds.append(roledept.getRoleId()).append(",");
            if (officeIds.indexOf(roledept.getOfficeId() + ",") < 0)
                officeIds.append(roledept.getOfficeId()).append(",");
            if (userIds.indexOf(roledept.getUserId() + ",") < 0)
                userIds.append(roledept.getUserId()).append(",");
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("roleIds", roleIds.substring(0, roleIds.length() - 1));
        map.put("officeIds", officeIds.substring(0, officeIds.length() - 1));
        map.put("userIds", userIds.substring(0, userIds.length() - 1));
        return map;
    }

    /**
     * 遍历渠道标签关系列表，拼接主对象Ids，关联对象Ids
     * 
     * @param records
     *            渠道标签关系列表
     * 
     */
    public Map<String, List<Long>> getRelationIdList(
            List<SysLabelRelationKey> records) {

        if (records == null || records.isEmpty()) {
            return null;
        }
        StringBuffer objIds = new StringBuffer();
        StringBuffer refIds = new StringBuffer();
        List<Long> objIdList = new ArrayList<Long>();
        List<Long> refIdList = new ArrayList<Long>();
        for (SysLabelRelationKey record : records) {
            String objId = record.getObjId();
            String refId = record.getRelId();
            if (StringUtils.isNotBlank(objId)
                    && (objIds.indexOf(objId + ",") < 0)) {
                objIds.append(objId).append(",");
                objIdList.add(Long.valueOf(objId));
            }
            if (StringUtils.isNotBlank(refId)
                    && (refIds.indexOf(refId + ",") < 0)) {
                refIds.append(refId).append(",");
                refIdList.add(Long.valueOf(refId));
            }

        }
        Map<String, List<Long>> map = new HashMap<String, List<Long>>();
        if (StringUtils.isNotBlank(objIds)) {
            map.put(UserGlobalParam.ChannelMapKeyParam.OBJ_MAP_KEY, objIdList);
        }
        if (StringUtils.isNotBlank(refIds)) {
            map.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, refIdList);
        }

        return map;
    }

    /**
     * 遍历渠道标签关系列表，拼接渠道Ids，标签Ids
     * 
     * @param records
     *            渠道标签关系列表
     * 
     */
    public Map<String, String> getRelationIds(
            List<SysLabelRelationKey> records) {

        if (records == null || records.isEmpty()) {
            return null;
        }
        StringBuffer objIds = new StringBuffer();
        StringBuffer refIds = new StringBuffer();
        for (SysLabelRelationKey record : records) {
            String objId = record.getObjId();
            String refId = record.getRelId();
            if (StringUtils.isNotBlank(objId)) {
                objId = objId + ",";
            }
            if (StringUtils.isNotBlank(refId)) {
                refId = refId + ",";
            }
            if (!(objIds.indexOf(objId) == 0 || objIds.indexOf("," + objId) > -1)) {
                objIds.append(objId);
            }
            if (!(refIds.indexOf(refId) == 0 || refIds.indexOf("," + refId) > -1)) {
                refIds.append(refId);
            }

        }
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isNotBlank(objIds)) {
            map.put(UserGlobalParam.ChannelMapKeyParam.OBJ_MAP_KEY,
                    objIds.substring(0, objIds.length() - 1));
        }
        if (StringUtils.isNotBlank(refIds)) {
            map.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY,
                    refIds.substring(0, refIds.length() - 1));
        }

        return map;
    }

    /**
     * 根据用户Ids,角色Ids获取用户与角色对应关系列表
     */
    public List<SysUserRoleKey> getCustomerRoleList(String userIds,
            String roleIds) {
        List<SysUserRoleKey> userRoleList = null;
        Map<String, String> map = new HashMap<String, String>();
        boolean isCanSearch = false;
        if (StringUtils.isNoneBlank(userIds)) {
            map.put("userIds", userIds);
            isCanSearch = true;
        }
        if (StringUtils.isNoneBlank(roleIds)) {
            map.put("roleIds", roleIds);
            isCanSearch = true;
        }
        if (isCanSearch) {
            userRoleList = iuserAuthRoleService.findByIds(map);
        }
        return userRoleList;
    }

    /**
     * 根据用户Ids,菜单Ids获取用户与菜单对应关系列表
     */
    public List<SysUserMenuKey> getCustomerMenuList(String userIds,
            String menuIds) {
        List<SysUserMenuKey> userMenuList = null;
        Map<String, String> map = new HashMap<String, String>();
        boolean isCanSearch = false;
        if (StringUtils.isNoneBlank(userIds)) {
            map.put("userIds", userIds);
            isCanSearch = true;
        }
        if (StringUtils.isNoneBlank(menuIds)) {
            map.put("roleIds", menuIds);
            isCanSearch = true;
        }
        if (isCanSearch) {
            userMenuList = iuserAuthMenuService.findByIds(map);
        }
        return userMenuList;
    }

    /**
     * 根据用户Ids,部门Ids获取用户与部门对应关系列表
     */
    public List<SysUserOfficeKey> getCustomerDepartmentList(
            String userIds, String deparIds) {
        List<SysUserOfficeKey> userOfficeList = null;
        Map<String, String> map = new HashMap<String, String>();
        boolean isCanSearch = false;
        if (StringUtils.isNoneBlank(userIds)) {
            map.put("userIds", userIds);
            isCanSearch = true;
        }
        if (StringUtils.isNoneBlank(deparIds)) {
            map.put("officeIds", deparIds);
            isCanSearch = true;
        }
        if (isCanSearch) {
            userOfficeList = iuserAuthOfficeService.findByIds(map);
        }
        return userOfficeList;
    }

    /**
     * 根据角色Ids,菜单Ids获取角色与菜单对应关系列表
     */
    public List<SysRoleMenuKey> getRoleMenuList(String roleIds,
            String menuIds) {
        List<SysRoleMenuKey> roleMenuList = null;
        Map<String, String> map = new HashMap<String, String>();
        boolean isCanSearch = false;
        if (StringUtils.isNoneBlank(roleIds)) {
            map.put("roleIds", roleIds);
            isCanSearch = true;
        }
        if (StringUtils.isNoneBlank(menuIds)) {
            map.put("menuIds", menuIds);
            isCanSearch = true;
        }
        if (isCanSearch) {
            roleMenuList = iroleAuthMenuService.findByIds(map);
        }
        return roleMenuList;
    }

    /**
     * 根据角色Ids,部门Ids,userIds获取角色,部门,用户之间的对应关系列表
     */
    public List<SysRoleOfficeUserKey> getRoleOfficeList(String roleIds,
            String officeIds, String userIds) {
        List<SysRoleOfficeUserKey> roleOfficeList = null;
        Map<String, String> map = new HashMap<String, String>();
        boolean isCanSearch = false;
        if (StringUtils.isNoneBlank(roleIds)) {
            map.put("roleIds", roleIds);
            isCanSearch = true;
        }
        if (StringUtils.isNoneBlank(officeIds)) {
            map.put("officeIds", officeIds);
            isCanSearch = true;
        }
        if (StringUtils.isNoneBlank(userIds)) {
            map.put("userIds", userIds);
            isCanSearch = true;
        }
        if (isCanSearch) {
            roleOfficeList = iroleAuthOfficeService.findByIds(map);
        }
        return roleOfficeList;
    }

    /**
     * 根据渠道关系表的对应关系列表
     */
    public List<SysLabelRelationKey> getRelationList(String objIds,
            String refIds, String type) {
        List<SysLabelRelationKey> list = null;
        Map<String, String> map = new HashMap<String, String>();
        boolean isCanSearch = false;
        if (StringUtils.isBlank(type)) {
            return list;
        }
        map.put(ChannelMapKeyParam.RELATION_TYPE_KEY, type);
        if (StringUtils.isNoneBlank(objIds)) {
            map.put(UserGlobalParam.ChannelMapKeyParam.OBJ_MAP_KEY, objIds);
            isCanSearch = true;
        }
        if (StringUtils.isNoneBlank(refIds)) {
            map.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, refIds);
            isCanSearch = true;
        }
        if (isCanSearch) {
            list = ilabelRelationService.findByIds(map);
        }
        return list;
    }
}
