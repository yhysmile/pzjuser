package com.pzj.service.Impl;

import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.SysUserAgent;
import com.pzj.base.service.sys.ISysUserAgentService;
import com.pzj.core.customer.dao.SysUserAgentMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-3-30.
 */
@Service("sysUserAgentServiceImpl")
public class SysUserAgentServiceImpl extends
        BaseRelationshipServiceImpl<SysUserAgent, SysUserAgentMapper> implements ISysUserAgentService {

    @Override
    public Long delAuthBatch(List<SysUserAgent> records, boolean syncOtherRelation) {
        Long num = 0l;
        try {
            num = deleteBatchSelective(records);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    @Override
    public Long insertAuthBatch(List<SysUserAgent> records, boolean syncOtherRelation) {
        Long num = 0l;
        try {
            num = insertBatch(records);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    @Override
    public String genMapKey(SysUserAgent record, String regx) {
        String key = "";
        if (StringUtils.isBlank(regx)) {
            regx = ",";
        }
        if (record == null) {
            return key;
        }
        Long userId = record.getUserId();
        Long agentId = record.getAgentId();
        if (userId == null || agentId == null) {
            return key;
        }

        return userId + regx + agentId;
    }

    @Override
    public Map<String, String> getRelationIds(List<SysUserAgent> records) {
        if (records == null || records.isEmpty()) {
            return null;
        }
        StringBuffer objIds = new StringBuffer();
        StringBuffer relIds = new StringBuffer();
        for (SysUserAgent record : records) {
            Long objId = record.getUserId();
            Long relId = record.getAgentId();
            if (objId != null) {
                objIds.append(objId).append(",");
            }
            if (relId != null) {
                relIds.append(relId).append(",");
            }
        }
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isNotBlank(objIds)) {
            map.put(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY, objIds.substring(0, objIds.length() - 1));
        }
        if (StringUtils.isNotBlank(relIds)) {
            map.put(UserGlobalParam.UserMapKeyParam.AGENT_MAP_KEY, relIds.substring(0, relIds.length() - 1));
        }

        return map;
    }

    @Override
    public void saveUserAgent(List<SysUserAgent> userAgentList) {
        if (CollectionUtils.isEmpty(userAgentList))
            return;

        Map<String, String> relationIds = getRelationIds(userAgentList);
        updateAuthBatch(relationIds, userAgentList);
    }

    @Override
    public List<SysUser> findAgentByParams(SysUserAgent usag, SysUser masterUser){
        return mapper.selectAgentByParams(usag, masterUser);
    }
}