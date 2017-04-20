package com.pzj.base.common;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;

public abstract interface BaseService<T extends BaseEntity> {

    // public BaseMapper<T> getDefaulteMapper();

    /**
     * 返回对象主键
     * 
     * @param entity
     * @return
     */
    public Long insert(T entity);

    /**
     * 返回影响记录条数
     * 
     * @param entity
     * @return
     */
    public Integer updateByPrimaryKey(T entity);

    /**
     * <h3>新建或更新数据</h3>
     * <p>
     * 数据必须是BaseEntity的子类型，拥有属性id，如果id为null，则执行新建，否则执行更新。
     * 
     * @param entity
     *            数据实体
     * @return 返回对象主键
     */
    public Long insertOrUpdate(T entity);

    /**
     * 
     * @param id
     * @return 返回影响记录条数
     */
    public Integer delete(Long id);

    /**
     * 
     * @param id
     * @return 返回对象
     */
    public T getById(Long id);

    /**
     * 
     * @param pager
     * @param entity
     * @return 返回Pagination<T>队形
     */
    public PageList<T> queryPageByParamMap(PageModel pager, T entity);

    /**
     * 
     * @param entity
     * @return
     */
    public List<T> findListByParams(T entity);

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

    /**
     * 批量新建或更新
     * 
     * @param entityList
     * @return
     */
    Long insertOrUpdateBatch(List<T> entityList);

    /**
     * 将实体集合转换为以主键为key的map集合
     * 
     * @param entityList
     * @return
     */
    Map<String, T> listTMap(List<T> entityList, String regx);
}
