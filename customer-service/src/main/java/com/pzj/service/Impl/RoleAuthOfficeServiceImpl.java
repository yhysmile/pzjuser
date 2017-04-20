package com.pzj.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.entity.SysRoleOfficeUserKey;
import com.pzj.base.service.sys.IRoleAuthOfficeService;
import com.pzj.core.customer.dao.SysRoleOfficeUserMapper;

@Service("roleAuthOfficeService")
public class RoleAuthOfficeServiceImpl
        extends
        BaseRelationshipServiceImpl<SysRoleOfficeUserKey, SysRoleOfficeUserMapper>
        implements IRoleAuthOfficeService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public Long insertAuthBatch(List<SysRoleOfficeUserKey> records, boolean syncOtherRelation) {
        Long num = 0l;
        try {
            num = insertBatch(records);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    public Long delAuthBatch(List<SysRoleOfficeUserKey> records, boolean syncOtherRelation) {
        Long num = 0l;
        try {
            num = deleteBatchSelective(records);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    /**
     * 遍历用户部门角色关系列表，拼接用户Ids，角色Ids, 部门Ids
     * 
     * @param userRoles
     *            用户角色关系列表
     * 
     */
    public Map<String, String> getRelationIds(List<SysRoleOfficeUserKey> records) {

        if (records == null || records.isEmpty()) {
            return null;
        }
        StringBuffer userIds = new StringBuffer();
        StringBuffer roleIds = new StringBuffer();
        StringBuffer officeIds = new StringBuffer();
        for (SysRoleOfficeUserKey record : records) {
            if (userIds.indexOf(record.getUserId() + ",") < 0)
                userIds.append(record.getUserId()).append(",");
            if (roleIds.indexOf(record.getRoleId() + ",") < 0)
                roleIds.append(record.getRoleId()).append(",");
            if (officeIds.indexOf(record.getOfficeId() + ",") < 0)
                officeIds.append(record.getOfficeId()).append(",");

        }
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isNoneBlank(userIds)) {
            map.put("userIds", userIds.substring(0, userIds.length() - 1));
        }
        if (StringUtils.isNoneBlank(roleIds)) {
            map.put("roleIds", roleIds.substring(0, roleIds.length() - 1));
        }
        if (StringUtils.isNoneBlank(officeIds)) {
            map.put("officeIds", officeIds.substring(0, officeIds.length() - 1));
        }

        return map;
    }

    public String genMapKey(SysRoleOfficeUserKey record, String regx) {
        String key = "";
        if (StringUtils.isBlank(regx)) {
            regx = ",";
        }
        if (record == null) {
            return key;
        }
        String roleId = record.getRoleId();
        String officeId = record.getOfficeId();
        String userId = record.getUserId();
        if (StringUtils.isBlank(officeId) || StringUtils.isBlank(roleId)) {
            return key;
        }
        key = roleId + regx + officeId;
        if (StringUtils.isNotBlank(userId)) {
            key = key + regx + userId;
        }

        return key;
    }

}
