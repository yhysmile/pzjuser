/*
 * SysObjectDictRelationService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.sys;

import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.common.SysObjectDictRelation;
import com.pzj.base.entity.common.SysObjectDictRelationChild;

/**
 * @Description:service接口.区域
 * @author: 票之家
 */
public interface ISysObjectDictRelationService extends BaseService<SysObjectDictRelationChild> {

    /**
     * 按照条件删除数据
     * 
     * @param deleteParam
     *            删除条件
     * @return
     */
    int deleteBatchSelective(List<SysObjectDictRelation> deleteParam);

    /**
     * 更新最新的数据字典多选集的关系数据
     *
     * @param updateList
     *            最新的关系数据集
     * @return
     */
    int updateBatch(List<SysObjectDictRelation> updateList);
}
