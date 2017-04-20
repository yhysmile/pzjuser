package com.pzj.base.common.child.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.child.BaseChildCommonMapper;
import com.pzj.base.common.child.BaseChildCommonService;
import com.pzj.base.common.impl.BaseServiceImpl;

public abstract class BaseChildCommonServiceImpl<T extends BaseEntity, E extends BaseChildCommonMapper<T>>
                                                extends BaseServiceImpl<T, E>
                                                implements BaseChildCommonService<T> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public void batchSetParentId(List<T> childList, Long parentId) {
        if (childList == null || childList.isEmpty()) {
            return;
        }
        for (T t : childList) {
            setParentId(t, parentId);
        }
    }

    public Integer deleteBatchByPrimaryKey(List<T> list) {
        Integer num = 0;
        if (list == null || list.isEmpty()) {
            String msg = "批量删除：list不可以为空";
            logger.error(msg);
            return num;
        }

        return mapper.deleteBatchByPrimaryKey(list);
    }

    public List<Long> getIdList(List<T> records) {
        if (records == null || records.isEmpty()) {
            return null;
        }
        List<Long> list = new ArrayList<Long>();
        StringBuffer buff = new StringBuffer();
        for (T record : records) {
            Long id = record.getId();
            if (id != null && (buff.indexOf(id + ",") < 0)) {
                buff.append(id).append(",");
                list.add(id);
            }

        }
        return list;
    }

    public Long updateParentRelationBatch(Map<Long, List<T>> entityMap, boolean syncOtherRelation) {

        Long num = 0l;
        if (entityMap == null || entityMap.isEmpty()) {
            return num;
        }
        String regx = ",";

        List<Long> parentIds = new ArrayList<Long>();
        List<T> allList = new ArrayList<T>();

        for (Map.Entry<Long, List<T>> entry : entityMap.entrySet()) {
            Long parentId = entry.getKey();
            List<T> tList = entry.getValue();
            if (parentId == null || tList == null) {
                continue;
            }
            parentIds.add(parentId);
            // 给子集设置父Id
            batchSetParentId(tList, parentId);
            allList.addAll(tList);

        }
        if (allList == null) {
            return num;
        }
        // 1.获取原始库里所有父id的子集map
        Map<String, T> haveMap = listTMap(findByParentIdList(parentIds), regx);

        // 2.更新所有最新子集
        if (!allList.isEmpty())
            num += insertOrUpdateBatch(allList);

        // 将最新子集list转化为map
        Map<String, T> allMap = listTMap(allList, regx);

        // 3.原始与最新子集比对，找出所有需要删除的子集
        List<T> deleteRecord = new ArrayList<T>();
        if (haveMap != null) {
            for (Map.Entry<String, T> entry : haveMap.entrySet()) {
                String key = entry.getKey();
                if (!allMap.containsKey(key)) {
                    deleteRecord.add(entry.getValue());
                }
            }
        }
        // 4.删除所有原始需要删除的数据
        if (deleteRecord != null) {
            num += deleteBatchByPrimaryKey(deleteRecord);
        }

        return num;
    }
}
