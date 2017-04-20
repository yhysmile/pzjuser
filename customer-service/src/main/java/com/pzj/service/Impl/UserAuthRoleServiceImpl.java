package com.pzj.service.Impl;

import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.entity.SysRole;
import com.pzj.base.entity.SysUserRoleKey;
import com.pzj.base.service.sys.IRoleAuthOfficeService;
import com.pzj.base.service.sys.IUserAuthMenuService;
import com.pzj.base.service.sys.IUserAuthRoleService;
import com.pzj.core.customer.dao.SysUserRoleMapper;

@Service("userAuthRoleService")
public class UserAuthRoleServiceImpl extends
        BaseDataSourceService<SysUserRoleKey, SysUserRoleMapper>
        implements IUserAuthRoleService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserAuthMenuService userAuthMenuService;

    @Autowired
    private IRoleAuthOfficeService roleAuthOfficeService;

    public Long insertAuthBatch(List<SysUserRoleKey> records) {
        return insertAuthBatch(records, true);

    }

    public Long insertAuthBatch(List<SysUserRoleKey> records, boolean copyRoleMenu) {
        Long num = 0l;
        String regx = ",";
        try {
            if (records == null) {
                logger.error("方法[UserAuthRoleService.insertAuthBatch],参数records不可以为空");
                return num;
            }
            Map<String, String> idsMap = getRelationIds(records);
            Map<String, SysUserRoleKey> havMap = listTMap(findByIds(idsMap), regx);
            List<SysUserRoleKey> insertList = new ArrayList<SysUserRoleKey>();
            for (SysUserRoleKey key : records) {
                String userId = key.getUserId();
                String roleId_ = key.getRoleId();
                if (StringUtils.isNotBlank(userId)
                        && StringUtils.isNotBlank(roleId_)) {
                    String genKey = genMapKey(key, regx);
                    if (!havMap.containsKey(genKey)) {
                        insertList.add(key);
                        havMap.put(genKey, key);
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(insertList)) {
                num += insertBatch(insertList);
                // 将新加角色的权限与用户挂接
                if(copyRoleMenu){
                    num +=  userAuthMenuService.insertBatchByUserAndRole(insertList);
                }
            }

        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;

    }

    public Long delAuthBatch(List<SysUserRoleKey> records, boolean syncOtherRelation) {
        Long num = 0l;
        try {
            if (records == null) {
                logger.error("方法[UserAuthRoleService.delAuthBatch],参数records不可以为空");
                return num;
            }
            Map<String, String> idsMap = getRelationIds(records);

            // 删除用户与菜单的关系
            num += userAuthMenuService.deleteByIds(idsMap);

            // 删除用户部门角色的关系
            num += roleAuthOfficeService.deleteByIds(idsMap);

            // 删除用户与角色的关系
            num += deleteBatchSelective(records);

        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;

    }

    @Override
    public Map<String, String> getRelationIds(List<SysUserRoleKey> records) {
        if (records == null) {
            return null;
        }
        StringBuffer userIds = new StringBuffer();
        StringBuffer roleIds = new StringBuffer();
        StringBuffer dataSources = new StringBuffer();
        for (SysUserRoleKey record : records) {
            if (userIds.indexOf(record.getUserId() + ",") < 0)
                userIds.append(record.getUserId()).append(",");
            if (roleIds.indexOf(record.getRoleId() + ",") < 0)
                roleIds.append(record.getRoleId()).append(",");
            if (dataSources.indexOf(record.getDataSource() + ",") < 0)
                dataSources.append(record.getDataSource()).append(",");
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY,
                userIds.substring(0, userIds.length() - 1));
        map.put(UserGlobalParam.UserMapKeyParam.ROLE_MAP_KEY,
                roleIds.substring(0, roleIds.length() - 1));
        if (dataSources.length() > 1)
            map.put(UserGlobalParam.UserMapKeyParam.DATASOURCES_KEY,
                    dataSources.substring(0, dataSources.length() - 1));

        return map;
    }

    @Override
    public String genMapKey(SysUserRoleKey record, String regx) {
        String key = "";
        if (record == null) {
            return key;
        }
        if (StringUtils.isBlank(regx)) {
            regx = ",";
        }
        String roleId = record.getRoleId();
        String userId = record.getUserId();
        String dataSource = record.getDataSource();
        if (StringUtils.isBlank(roleId) || StringUtils.isBlank(userId)) {
            return key;
        }

        if (StringUtils.isBlank(dataSource))
            return userId + regx + roleId;
        else
            return userId + regx + roleId + regx + dataSource;
    }

    public Set<String> genMapKeySet(List<SysUserRoleKey> recordList, String regx) {
        if (recordList == null || recordList.size() == 0)
            return Collections.emptySet();

        Set<String> getKeySet = new HashSet<>();

        for (SysUserRoleKey key : recordList){
            String genMapKey = genMapKey(key, regx);
            getKeySet.add(genMapKey);
        }
        return getKeySet;
    }
    
    @Override
    public List<SysUserRoleKey> findRoleByRelationRole(SysUserRoleKey relationParam, SysRole roleParam){
        return mapper.selectRoleByRelationRole(relationParam, roleParam);
    }
}
