package com.pzj.dao;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.BaseMapper;

public interface BaseUserMapper<T extends BaseEntity> extends BaseMapper<T> {

    /**
     * 根据主键集合串关系列表
     * 
     * @param params
     * @return 关系列表
     */
    List<T> findByIdsMap(Map<String, String> params);

    /**
     * 根据主键集合查询关系列表
     * 
     * @param params
     * @return 关系列表
     */
    List<T> findByIdList(Map<String, Object> params);

    /**
     * 通用分页
     * 
     * @param params
     * @return
     */
    List<T> queryByParamMap(Map<String, Object> params);

    /**
     * 更新 : 值为Null也更新
     * 
     * @param record
     * @return
     */
    Integer updateAllByPrimaryKey(T record);
}
