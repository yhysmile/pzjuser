package com.pzj.service.Impl;

import java.util.*;

import com.pzj.base.common.BaseDataSourceEntity;
import com.pzj.dao.BaseRelationshipMapper;

/**
 * Created by Administrator on 2016-7-25.
 */
public abstract class BaseDataSourceService<T extends BaseDataSourceEntity, E extends BaseRelationshipMapper<T>> extends BaseRelationshipServiceImpl<T, E> {

    private boolean checkoutUpdateAuthBatch(Map<String, ?> idsMap, List<T> relationRecords){
        if (idsMap == null) {
            logger.error("方法[BaseDataSourceService.updateAuthBatch],参数idsMap不可以为空");
            return false;
        }
        if (relationRecords == null) {
            logger.error("方法[BaseDataSourceService.updateAuthBatch],参数relationRecords不可以为空");
            return false;
        }
        return true;
    }

    private Long updateAuthBatchDo(Map<String, ?> idsMap,
                                   List<T> relationRecords, boolean syncOtherRelation, List<T> findList) {
/*
         * 1. 查询数据库中存在的旧关系；
         * 2. 对比新旧关系列表，找出需要创建的新关系；
         * 3. 对比新旧关系列表，找出需要删除的旧关系；
         * 4. 如果有需要创建的新关系，则插入到数据库中；
         * 5. 如果有需要删除的旧关系，则从数据库中删除。
         * 新关系列表和旧关系列表中共同拥有的关系，直接忽略不作操作。
         */
        Long num = 0l;
        String regx = ",";
        try {
            if (idsMap == null) {
                logger.error("方法[BaseRelationshipService.updateAuthBatch],参数idsMap不可以为空");
                return num;
            }
            if (relationRecords == null) {
                logger.error("方法[BaseRelationshipService.updateAuthBatch],参数relationRecords不可以为null");
                return num;
            }

            // 1. 查询旧关系
            //List<SysUserRoleKey> findList = findByIds(idsMap);

            // 2. 对比新旧关系列表，找出需要创建的新关系。
            Map<String, T> havMap = new HashMap<>();
            if (findList != null) {
                // 将新关系列表转化为Map，
                havMap = listTMap(findList, regx);
            }
            // 创建保存[需要创建的新关系]的列表
            List<T> insertList = new ArrayList<>();
            Set<String> keySet1 = new HashSet<>(havMap.keySet());
            for (T record : relationRecords) {
                String genKey = genMapKey(record, regx);
                if (!contains(genKey, keySet1)) {
                    insertList.add(record);
                    havMap.put(genKey, record);
                }
            }

            // 3. 对比新旧关系列表，找出需要删除的旧关系；
            Map<String, T> havMap1 = listTMap(relationRecords, regx);
            // 创建保存[需要删除的旧关系]的列表
            List<T> deleteList = new ArrayList<>();
            Set<String> keySet2 = new HashSet<>(havMap1.keySet());
            for (T record : findList) {
                String genKey = genMapKey(record, regx);
                if (!contains(genKey, keySet2)) {
                    deleteList.add(record);
                    havMap1.put(genKey, record);
                }
            }

            // 4. 如果有需要删除的旧关系（deleteList不为空），则从数据库中删除
            if (!deleteList.isEmpty()) {
                // 批量删除
                num += delAuthBatch(deleteList, syncOtherRelation);
            }

            // 5. 如果有需要创建的新关系（insertList不为空），则插入到数据库中
            if (!insertList.isEmpty()) {
                // 批量插入
                num += insertAuthBatch(insertList, syncOtherRelation);
            }

        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    private boolean contains(String getKey, Set<String> keySet){
        for (String key : keySet){
            if (key.startsWith(getKey)) {
                return true;
            }
        }
        return false;
    }

    public Long updateAuthBatchByList(Map<String, Object> idsMap,
                                      List<T> relationRecords, boolean syncOtherRelation) {
        if (!checkoutUpdateAuthBatch(idsMap, relationRecords))
            return 0L;
        // 1. 查询旧关系
        List<T> findList = findByIdList(idsMap);
        return updateAuthBatchDo(idsMap, relationRecords, syncOtherRelation, findList);
    }

    public Long updateAuthBatch(Map<String, String> idsMap, List<T> relationRecords, boolean syncOtherRelation) {
        if (!checkoutUpdateAuthBatch(idsMap, relationRecords))
            return 0L;
        // 1. 查询旧关系
        List<T> findList = findByIds(idsMap);
        return updateAuthBatchDo(idsMap, relationRecords, syncOtherRelation, findList);
    }

}
