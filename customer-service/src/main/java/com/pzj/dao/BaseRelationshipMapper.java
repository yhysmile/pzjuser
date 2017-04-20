package com.pzj.dao;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.BaseMapper;

public interface BaseRelationshipMapper<T extends BaseEntity> extends BaseMapper<T> {
    /**
     * 根据主键串查询关系列表
     * 
     * @param parameterMap
     * @return 关系列表
     */
    List<T> findByIdsMap(Map<String, String> params);

    /**
     * 根据主键集合查询关系列表
     * 
     * @param parameterMap
     * @return 关系列表
     */
    List<T> findByIdListMap(Map<String, Object> params);

    /**
     * 按条件删除关系
     * 
     * @param record
     *            关系实体
     * 
     * @return 删除条数
     */
    Integer deleteSelective(T record);

    /**
     * 根据主键批量关系
     * 
     * @param record
     *            关系实体列表
     * @return 删除条数
     */
    Integer deleteBatchByPrimaryKey(List<T> entityList);

    /**
     * 按条件批量删除关系
     * 
     * @param record
     *            关系实体列表
     * @return 删除条数
     */
    Integer deleteBatchSelective(List<T> entityList);

    /**
     * 根据主键串删除关系
     * 
     * @param parameterMap
     * @return
     */
    int deleteByIdsMap(Map<String, String> params);

    /**
     * 根据主键集合删除关系
     * 
     * @param parameterMap
     * @return
     */
    int deleteByIdList(Map<String, Object> params);

}
