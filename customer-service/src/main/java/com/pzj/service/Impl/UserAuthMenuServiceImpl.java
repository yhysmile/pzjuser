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
import com.pzj.base.entity.*;
import com.pzj.base.service.sys.IRoleAuthMenuService;
import com.pzj.base.service.sys.IUserAuthMenuService;
import com.pzj.base.service.sys.IUserAuthRoleService;
import com.pzj.core.customer.dao.SysUserMenuMapper;

@Service("userAuthMenuService")
public class UserAuthMenuServiceImpl extends
        BaseDataSourceService<SysUserMenuKey, SysUserMenuMapper>
        implements IUserAuthMenuService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserAuthRoleService userAuthRoleService;

    @Autowired
    private IRoleAuthMenuService roleAuthMenuService;

    public Long delAuthBatch(List<SysUserMenuKey> records, boolean syncOtherRelation) {
        Long num = 0l;
        try {
            num = deleteBatchSelective(records);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    public Long insertAuthBatch(List<SysUserMenuKey> records, boolean syncOtherRelation) {
        Long num = 0l;
        try {
            num = insertBatch(records);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    public Long insertBatchByRoleAndMenu(List<SysRoleMenuKey> records) {
        Long num = 0l;
        String regx = ";";
        try {
            if (records == null) {
                logger.error("方法[UserAuthMenuService.insertBatchByRoleAndMenu],参数records不可以为空");
                return num;
            }

            Map<String, String> roleMenuIds = roleAuthMenuService.getRelationIds(records);
            List<SysUserRoleKey> userRoleList = userAuthRoleService
                    .findByIds(roleMenuIds);

            if (userRoleList != null) {
                List<SysUserMenuKey> havUserMenuList = findByIds(roleMenuIds);
                Map<String, SysUserMenuKey> havMap = listTMap(havUserMenuList, regx);
                List<SysUserMenuKey> insertList = new ArrayList<>();
                for (SysRoleMenuKey record : records) {
                    String roleId = record.getRoleId();
                    String menuId = record.getMenuId();
                    if (StringUtils.isNotBlank(roleId)
                            && StringUtils.isNotBlank(menuId)) {
                        for (SysUserRoleKey key : userRoleList) {
                            String userId = key.getUserId();
                            String roleId_ = key.getRoleId();
                            if (StringUtils.isNotBlank(userId)
                                    && StringUtils.isNotBlank(roleId_)
                                    && roleId.equals(roleId_)) {
                                SysUserMenuKey userMenu = new SysUserMenuKey();
                                userMenu.setUserId(userId);
                                userMenu.setMenuId(menuId);
                                userMenu.setDataSource(key.getDataSource());

                                String genKey = genMapKey(userMenu, regx);
                                if (!havMap.containsKey(genKey)) {
                                    insertList.add(userMenu);
                                    havMap.put(genKey, userMenu);
                                }

                            }
                        }
                    }
                }
                if (insertList != null) {
                    num = insertBatch(insertList);
                }

            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    public Long insertBatchByUserAndRole(List<SysUserRoleKey> records) {

        Long num = 0L;
        String regx = ";";
        try {
            if (records == null) {
                logger.error("方法[UserAuthMenuService.insertBatchByRoleAndMenu],参数records不可以为空");
                return num;
            }

            Map<String, String> userRoleIds = userAuthRoleService.getRelationIds(records);
            List<SysRoleMenuKey> roleMenuList = roleAuthMenuService.findByIds(userRoleIds);

            if (roleMenuList != null) {
                List<SysUserMenuKey> havUserMenuList = findByIds(userRoleIds);
                Map<String, SysUserMenuKey> havMap = listTMap(havUserMenuList, regx);
                List<SysUserMenuKey> insertList = new ArrayList<SysUserMenuKey>();
                for (SysUserRoleKey record : records) {
                    String roleId = record.getRoleId();
                    String userId = record.getUserId();
                    String dataSource = record.getDataSource();
                    if (StringUtils.isNotBlank(roleId)
                            && StringUtils.isNotBlank(userId)) {
                        for (SysRoleMenuKey key : roleMenuList) {
                            String menuId = key.getMenuId();
                            String roleId_ = key.getRoleId();
                            if (StringUtils.isNotBlank(menuId)
                                    && StringUtils.isNotBlank(roleId_)
                                    && roleId.equals(roleId_)) {
                                SysUserMenuKey userMenu = new SysUserMenuKey();
                                userMenu.setUserId(userId);
                                userMenu.setMenuId(menuId);
                                userMenu.setDataSource(dataSource);

                                String genKey = genMapKey(userMenu, regx);
                                if (!havMap.containsKey(genKey)) {
                                    insertList.add(userMenu);
                                    havMap.put(genKey, userMenu);
                                }

                            }
                        }
                    }
                }
                if (insertList != null && !insertList.isEmpty()) {
                    num = insertBatch(insertList);
                }

            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    public Long deleteByIds(Map<String, String> idsMap) {
        Long num = 0l;
        try {
            if (idsMap == null) {
                logger.error("方法[UserAuthMenuService.deleteByIds],参数idsMap不可以为空");
                return num;
            }

            List<SysUserRoleMenuVo> list = findURMByIds(idsMap);
            idsMap = SysUserRoleMenuVo.getStringForIds(list);

            List<SysUserMenuKey> userMenuList = findByIds(idsMap);

            if (userMenuList != null) {
                num = deleteBatchSelective(userMenuList);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    public List<SysUserRoleMenuVo> findURMByIds(Map<String, String> idsMap) {
        List<SysUserRoleMenuVo> list = null;
        try {
            if (idsMap == null) {
                logger.error("方法[UserAuthMenuService.findURMByIds],参数idsMap不可以为空");
                return list;
            }
            list = mapper.findURMByIds(idsMap);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;

        }
        return list;
    }

    public List<SysUserRoleMenuVo> findURMById(SysUserRoleMenuVo record) {
        List<SysUserRoleMenuVo> list = null;
        try {
            list = mapper.findURMById(record);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return list;
    }

    public Map<String, String> getRelationIds(List<SysUserMenuKey> records) {
        if (records == null || records.isEmpty()) {
            return null;
        }
        StringBuffer userIds = new StringBuffer();
        StringBuffer menuIds = new StringBuffer();
        for (SysUserMenuKey record : records) {
            userIds.append(record.getUserId()).append(",");
            menuIds.append(record.getMenuId()).append(",");
        }
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isNotBlank(userIds)) {
            map.put(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY, userIds.substring(0, userIds.length() - 1));
        }
        if (StringUtils.isNotBlank(menuIds)) {
            map.put(UserGlobalParam.UserMapKeyParam.MENU_MAP_KEY, menuIds.substring(0, menuIds.length() - 1));
        }

        return map;
    }

    @Override
    public String genMapKey(SysUserMenuKey record, String regx) {
        String key = "";
        if (StringUtils.isBlank(regx)) {
            regx = ",";
        }
        if (record == null) {
            return key;
        }
        String menuId = record.getMenuId();
        String userId = record.getUserId();
        String dataSource = record.getDataSource();

        if (StringUtils.isBlank(menuId) || StringUtils.isBlank(userId)) {
            return key;
        }

        if (StringUtils.isBlank(dataSource))
            return userId + regx + menuId;
        else
            return userId + regx + menuId + regx + dataSource;

    }

    public List<SysUserMenuKey> findMenuByRelationMenu(SysUserMenuKey userMenuParam, SysMenu menuParam){
        return mapper.findMenuByRelationMenu(userMenuParam, menuParam);
    }
}
