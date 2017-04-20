package com.pzj.base.common.child;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.BaseMapper;

public interface BaseChildCommonMapper<T extends BaseEntity> extends
        BaseMapper<T> {
    /**
     * 根据主键集合查询列表
     * 
     * @param params
     * @return 实体列表
     */
    List<T> findByIdList(Map<String, Object> params);

    /**
     * 根据父ID集合查询列表
     * 
     * @param params
     * @return 实体列表
     */
    List<T> findByParentIdList(Map<String, Object> params);

    /**
     * 根据id批量删除实体
     * 
     * @param record
     *            实体列表
     * @return 删除条数
     */
    Integer deleteBatchByPrimaryKey(List<T> records);

}
