package com.pzj.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.common.BaseVO;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.service.sys.ILabelRelationService;

public class AuthorityUtil {

    private ILabelRelationService ilabelRelationService;
    public void setIlabelRelationService(ILabelRelationService ilabelRelationService) {
		this.ilabelRelationService = ilabelRelationService;
	}

    /**
     * 校验id重复
     */
    public  List<Long> checkIDRepetition(List<Long> ids) {
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
    public  <T extends BaseVO> List<T> checkBeanRepetition(List<T> beans) {
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
     * 根据渠道关系表的对应关系列表
     */
    public  List<SysLabelRelationKey> getRelationList(List<Long> objIds, List<Long> refIds, String type) {
        List<SysLabelRelationKey> list = null;
        Map<String, Object> map = new HashMap<String, Object>();
        boolean isCanSearch = false;
        if (StringUtils.isBlank(type)) {
            return list;
        }
        map.put(ChannelMapKeyParam.RELATION_TYPE_KEY, type);
        if (objIds != null && !objIds.isEmpty()) {
            map.put(UserGlobalParam.ChannelMapKeyParam.OBJ_MAP_KEY, objIds);
            isCanSearch = true;
        }
        if (refIds != null && !refIds.isEmpty()) {
            map.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, refIds);
            isCanSearch = true;
        }
        if (isCanSearch) {
            list = ilabelRelationService.findByIdList(map);
        }
        return list;
    }

    public  Map<String, List<String>> getObjMap(List<SysLabelRelationKey> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Map<String, List<String>> returnMap = new HashMap<String, List<String>>();
        for (SysLabelRelationKey key : list) {
            String objId = key.getObjId();
            String relId = key.getRelId();
            List<String> relList = returnMap.get(objId);
            if (relList == null) {
                relList = new ArrayList<String>();
                returnMap.put(objId, relList);
            }
            relList.add(relId);

        }
        return returnMap;
    }

    public  Map<String, List<String>> getRelMap(List<SysLabelRelationKey> list) {
        Map<String, List<String>> returnMap = new HashMap<String, List<String>>();
        if (list == null) {
            return returnMap;
        }

        for (SysLabelRelationKey key : list) {
            String objId = key.getObjId();
            String relId = key.getRelId();
            List<String> relList = returnMap.get(relId);
            if (relList == null) {
                relList = new ArrayList<String>();
                returnMap.put(relId, relList);
            }
            relList.add(objId);

        }
        return returnMap;
    }

    public  List<Long> getObjIdList(List<SysLabelRelationKey> list) {
        if (list == null) {
            return null;
        }
        List<Long> objIdList = new ArrayList<Long>();
        for (SysLabelRelationKey key : list) {
            String objId = key.getObjId();
            if (StringUtils.isNotBlank(objId)) {
                objIdList.add(Long.valueOf(objId));
            }
        }
        return objIdList;
    }

    public static List<Long> getRelIdList(List<SysLabelRelationKey> list) {
        if (list == null) {
            return null;
        }
        List<Long> relIdList = new ArrayList<Long>();
        for (SysLabelRelationKey key : list) {
            String relId = key.getRelId();
            if (StringUtils.isNotBlank(relId)) {
                relIdList.add(Long.valueOf(relId));
            }
        }
        return relIdList;
    }
}
