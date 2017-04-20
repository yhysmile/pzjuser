package com.pzj.base.common;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T extends BaseEntity> {

    /**
     * 删除对象
     * 
     * @param record
     * @return
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * 插入
     * 
     * @param record
     * @return
     */
    Long insert(T record);

    /**
     * 根据id查询对象
     * 
     * @param id
     * @return
     */
    T selectByPrimaryKey(Long id);

    /**
     * 按条件更新
     * 
     * @param record
     * @return
     */
    Integer updateByPrimaryKey(T record);

    /**
     * 全字段更新
     * 
     * @param record
     * @return
     */
    Integer updateAllByPrimaryKey(T record);

    /**
     * 返回所有数据
     * 
     * @param record
     * @return
     */
    List<T> selectAllObj(T record);

    /**
     * 通用总纪录数
     * 
     * @param record
     * @return
     */
    Integer countByParamMap(Map<String, Object> params);

    /**
     * 通用分页
     * 
     * @param params
     * @return
     */
    List<T> queryByParamMap(Map<String, Object> params);

    /**
     * 批量插入
     * 
     * @param entityList
     * @return
     */
    Long insertBatch(List<T> entityList);

    /**
     * 批量更新
     * 
     * @param entityList
     * @return
     */
    Integer updateBatchByPrimaryKey(List<T> entityList);

}
