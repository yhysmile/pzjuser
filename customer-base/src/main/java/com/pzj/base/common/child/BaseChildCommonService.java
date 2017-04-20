package com.pzj.base.common.child;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.BaseService;

public interface BaseChildCommonService<T extends BaseEntity> extends
        BaseService<T> {
    /**
     * 根据主键集合列表查询实体列表
     * 
     * @param idList
     * 
     * @return 主键集合
     * 
     */
    public List<T> findByIdList(List<Long> idList);

    /**
     * 根据父级主键集合查询实体列表
     * 
     * @param parentIds
     * @return
     */
    public List<T> findByParentIdList(List<Long> parentIdList);

    /**
     * 按条件批量删除实体
     * 
     * @param list
     * @return
     */
    public Integer deleteBatchByPrimaryKey(List<T> list);

    /**
     * 获取主键集合
     * 
     * @param records
     * @return
     */
    public List<Long> getIdList(List<T> records);

    /**
     * 更新实体的子集列表
     * 
     * @param parentList
     *            父级实体集合(包含了子集)
     * @param isNeedUpdate
     *            是否需要新建或更新
     * @param syncOtherRelation
     *            状态位，目前没用
     * @return
     */
    public Long updateParentRelationBatch(Map<Long, List<T>> entityMap,
            boolean syncOtherRelation);

    /**
     * 批量给子集设置父Id
     * 
     * @param childList
     * @param parentId
     */
    public void batchSetParentId(List<T> childList, Long parentId);

    public void setParentId(T child, Long parentId);

}
