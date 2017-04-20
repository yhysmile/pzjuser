package com.pzj.service.Impl;

import com.pzj.base.common.global.UserGlobalParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015-12-23.
 */
public class LabelRelationServiceUtil {

    public static Map<String,String> createIdsMap(Long objId, List<Long> relIds, String relType){
        String objIdString = null;
        String relIdString = null;

        if (null != objId)
            objId.toString();
        if (null != relIds)
            createIdsString(relIds);

        return createIdsMap(objIdString, relIdString, relType);
    }

    public static Map<String,String> createIdsMap(List<Long> objId, List<Long> relIds, String relType){
        String objIdString = null;
        String relIdString = null;

        if (null != objId)
            createIdsString(objId);
        if (null != relIds)
            createIdsString(relIds);

        return createIdsMap(objIdString, relIdString, relType);
    }

    public static Map<String,String> createIdsMap(List<Long> objId, Long relIds, String relType){
        String objIdString = null;
        String relIdString = null;

        if (null != objId)
            createIdsString(objId);
        if (null != relIds)
            relIds.toString();

        return createIdsMap(objIdString, relIdString, relType);
    }

    private static String createIdsString(List<Long> relIds){
        StringBuffer buff = new StringBuffer();
        for (Long id : relIds) {
            if (id != null) {
                buff.append(id).append(",");
            }
        }
        if (buff.length() > 0) {
            return buff.substring(0, buff.length() - 1);
        } else {
            return "";
        }
    }

    private static Map<String,String> createIdsMap(String objId, String relIds, String relType){
        Map<String, String> idsMap = new HashMap<>(3);
        idsMap.put(UserGlobalParam.ChannelMapKeyParam.OBJ_MAP_KEY, objId);
        idsMap.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, relIds);
        idsMap.put(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY,relType);
        return idsMap;
    }
}
