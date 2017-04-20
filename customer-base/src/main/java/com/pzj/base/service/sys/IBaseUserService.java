package com.pzj.base.service.sys;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.BaseService;

public interface IBaseUserService<T extends BaseEntity> extends BaseService<T> {

    /**
     * 根据主键集合串Ids查询实体列表 呵呵
     * 
     * @param idsMap
     * 
     * @return 实体集合
     * 
     */
    public List<T> findByIds(Map<String, String> idsMap);

    /**
     * 根据主键集合列表查询实体列表
     * 
     * @param idList
     * 
     * @return 主键集合
     * 
     */
    public List<T> findByIdList(Map<String, Object> idsMap);

    /**
     * 批量添加或更新实体
     * 
     * @param records
     *            实体集合
     * 
     * @return 影响条数
     * 
     */
    public Long insertOrUpdateBatch(List<T> record);

    /**
     * 将实体map转为list
     * 
     */
    public List<T> map2Alllist(Map<String, List<T>> records);

}
