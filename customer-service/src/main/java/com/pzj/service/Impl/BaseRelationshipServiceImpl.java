package com.pzj.service.Impl;

import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.service.sys.IBaseRelationshipService;
import com.pzj.core.customer.dao.BaseRelationshipMapper;

public abstract class BaseRelationshipServiceImpl<T extends BaseEntity, E extends BaseRelationshipMapper<T>>
        extends BaseServiceImpl<T, E> implements IBaseRelationshipService<T> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    public List<T> findByIds(Map<String, String> IdsMap) {
        List<T> list = null;
        try {
            CompatibleDirectChannelHelper.compatibleDirectChannelUserParamForString(IdsMap);

            list = mapper.findByIdsMap(IdsMap);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return list;
    }

    public List<T> findByIdList(Map<String, Object> IdsMap) {
        List<T> list = null;
        try {
            list = mapper.findByIdListMap(IdsMap);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return list;
    }

    public Long deleteBatchSelective(List<T> recordList) {
        Long num = 0l;
        try {
            if (recordList == null || recordList.isEmpty()) {
                logger.error("方法[BaseRelationshipService.deleteBatchSelective],参数recordList不可以为空");
                return num;
            }
            num = Long.valueOf(mapper.deleteBatchSelective(recordList));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    public Long deleteBatchByPrimaryKey(List<T> recordList) {
        Long num = 0l;
        try {
            if (recordList == null || recordList.isEmpty()) {
                logger.error("方法[BaseRelationshipService.deleteBatchSelective],参数recordList不可以为空");
                return num;
            }
            num = Long.valueOf(mapper.deleteBatchByPrimaryKey(recordList));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    public Long deleteByIds(Map<String, String> idsMap) {
        Long num = 0l;
        try {
            if (idsMap == null || idsMap.isEmpty()) {
                logger.error("方法[BaseRelationshipService.deleteByIds],参数idsMap不可以为空");
                return num;
            }
            num = Long.valueOf(mapper.deleteByIdsMap(idsMap));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }
    

    public Long updateAuthBatch(Map<String, String> idsMap, List<T> relationRecords) {
        return updateAuthBatch(idsMap, relationRecords, false);
    }

    public Long updateAuthBatch(Map<String, String> idsMap, List<T> relationRecords, boolean syncOtherRelation) {
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
            List<T> findList = findByIds(idsMap);

            // 2. 对比新旧关系列表，找出需要创建的新关系。
            Map<String, T> havMap;
                if (CollectionUtils.isNotEmpty(findList)) {
                // 将新关系列表转化为Map，
                havMap = listTMap(findList, regx);
            } else {
                havMap = new HashMap<>();
            }
            // 创建保存[需要创建的新关系]的列表
            List<T> insertList = new ArrayList<>();
            for (T record : relationRecords) {
                String genKey = genMapKey(record, regx);
                if (!havMap.containsKey(genKey)) {
                    insertList.add(record);
                    havMap.put(genKey, record);
                }
            }

            // 3. 对比新旧关系列表，找出需要删除的旧关系；
            Map<String, T> havMap1 = listTMap(relationRecords, regx);
            // 创建保存[需要删除的旧关系]的列表
            List<T> deleteList = new ArrayList<T>();
            for (T record : findList) {
                String genKey = genMapKey(record, regx);
                if (!havMap1.containsKey(genKey)) {
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

    public Long updateAuthBatchByList(Map<String, Object> idsMap, List<T> relationRecords) {
        return updateAuthBatchByList(idsMap, relationRecords, false);
    }

    public Long updateAuthBatchByList(Map<String, Object> idsMap,
            List<T> relationRecords, boolean syncOtherRelation) {
        Long num = 0l;
        String regx = ",";
        try {
            if (idsMap == null) {
                logger.error("方法[BaseRelationshipService.updateAuthBatch],参数idsMap不可以为空");
                return num;
            }
            if (relationRecords == null) {
                logger.error("方法[BaseRelationshipService.updateAuthBatch],参数relationRecords不可以为空");
                return num;
            }

            List<T> findList = findByIdList(idsMap);

            // 获取需要添加的关系
            Map<String, T> havMap;
            if (findList != null && !findList.isEmpty()) {
                havMap = listTMap(findList, regx);
            } else {
                havMap = new HashMap<String, T>(relationRecords.size());
            }

            List<T> insertList = new ArrayList<T>();
            for (T record : relationRecords) {
                String genKey = genMapKey(record, regx);
                if (!havMap.containsKey(genKey)) {
                    insertList.add(record);
                    havMap.put(genKey, record);
                }
            }

            // 获取需要删除的关系
            Map<String, T> havMap1 = listTMap(relationRecords, regx);
            List<T> deleteList = new ArrayList<T>();
            for (T record : findList) {
                String genKey = genMapKey(record, regx);
                if (!havMap1.containsKey(genKey)) {
                    deleteList.add(record);
                    havMap1.put(genKey, record);
                }
            }

            // 添加关系
            if (!insertList.isEmpty()) {
                insertAuthBatch(insertList, syncOtherRelation);
            }

            // 删除关系
            if (!deleteList.isEmpty()) {
                delAuthBatch(deleteList, syncOtherRelation);
            }

        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    /**
     * 
     * @param records
     * @param regx
     * @return
     */
    public Map<String, T> listTMap(List<T> records, String regx) {
        Map<String, T> map = new HashMap<String, T>();
        if (records == null || records.isEmpty()) {
            return map;
        }

        // 循环关系集合
        for (T record : records) {
            String key = genMapKey(record, regx);
            if (StringUtils.isNotBlank(key) && !map.containsKey(record)) {
                map.put(key, record);
            }
        }
        return map;
    }

    public abstract Long delAuthBatch(List<T> records, boolean syncOtherRelation);

    public abstract Long insertAuthBatch(List<T> records, boolean syncOtherRelation);
    

    public Long insertAuthBatch(List<T> records) {
        return insertAuthBatch(records, false);
    }

    public Long delAuthBatch(List<T> records) {
        return delAuthBatch(records, false);
    }

    public abstract String genMapKey(T record, String regx);
}
