package com.pzj.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.entity.SysUserOfficeKey;
import com.pzj.base.service.sys.IRoleAuthOfficeService;
import com.pzj.base.service.sys.IUserAuthOfficeService;
import com.pzj.dao.SysUserOfficeMapper;

@Service("userAuthOfficeService")
public class UserAuthOfficeServiceImpl extends
        BaseRelationshipServiceImpl<SysUserOfficeKey, SysUserOfficeMapper>
        implements IUserAuthOfficeService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IRoleAuthOfficeService roleAuthOfficeService;

    public Long delAuthBatch(List<SysUserOfficeKey> records, boolean syncOtherRelation) {
        Long num = 0l;
        try {
            if (records == null) {
                logger.error("方法[UserAuthOfficeService.delAuthBatch],参数records不可以为空");
                return num;
            }
            // 删除用户部门角色的关系
            Map<String, String> udIdsMap = getRelationIds(records);
            num += roleAuthOfficeService.deleteByIds(udIdsMap);

            // 删除用户和部门的关系
            // num += deleteBatchSelective(records);
            num += deleteBatchByPrimaryKey(records);

        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    public String genMapKey(SysUserOfficeKey record, String regx) {
        String key = "";
        if (StringUtils.isBlank(regx)) {
            regx = ",";
        }
        if (record == null) {
            return key;
        }
        String userId = record.getUserId();
        String officeId = record.getOfficeId();
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(officeId)) {
            return key;
        }

        return userId + regx + officeId;
    }

    public Long insertAuthBatch(List<SysUserOfficeKey> records, boolean syncOtherRelation) {
        Long num = 0l;
        try {
            num = insertBatch(records);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    public Map<String, String> getRelationIds(List<SysUserOfficeKey> records) {
        if (records == null ) {
            return null;
        }
        StringBuffer userIds = new StringBuffer();
        StringBuffer officeIds = new StringBuffer();
        for (SysUserOfficeKey record : records) {
            if (userIds.indexOf(record.getUserId() + ",") < 0)
                userIds.append(record.getUserId()).append(",");
            if (officeIds.indexOf(record.getOfficeId() + ",") < 0)
                officeIds.append(record.getOfficeId()).append(",");
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY,
                userIds.substring(0, userIds.length() - 1));
        map.put(UserGlobalParam.UserMapKeyParam.DEPT_MAP_KEY,
                officeIds.substring(0, officeIds.length() - 1));
        return map;
    }

}
