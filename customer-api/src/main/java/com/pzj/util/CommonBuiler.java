package com.pzj.util;

import static com.pzj.util.ServiceUtil.checkNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.ServiceException;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.framework.toolkit.Check;

public abstract class CommonBuiler<S extends BaseEntity,E extends CommonEntity> {
    
    public abstract E convertFrom(S entity);

    public abstract S convertTo(E entity);
    
    
    /**
     * 从底层数据实体转换为API层业务实体
     *
     * @param sourceList
     * @return
     */
    public E buildSource(S sourceList){
        return convertFrom(sourceList);
    }
    
    /**
     * 从底层数据实体转换为API层业务实体
     * @param sourceList
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<E> buildSource(List<S> sourceList){
        return buildSource(sourceList, ForeachHandle.NULL);
    }
    
    /**
     * 从底层数据实体转换为API层业务实体
     *
     * @param sourceList
     * @param handle
     * @return
     */
    public List<E> buildSource(List<S> sourceList, ForeachHandle<S, E> handle){
        if(Check.NuNCollections(sourceList))
            return null;
        
        List<E> result = new ArrayList<E>(sourceList.size());
        
        for (Iterator<S> iterator = sourceList.iterator(); iterator.hasNext();) {
            S s = iterator.next();
            E e = convertFrom(s);

            handle.handle(s, e);
            result.add(e);
        }
        
        return result;
    }
    
    /**
     * 构建新数据
     *
     * 进行必要的检查
     *
     * @param entity
     * @return
     * @throws ServiceException
     */
    public S buildNew(E entity) throws ServiceException{
        checkNull(entity, "实体对象不能为null");
        if(null == entity.getId()){            
            // 设置默认参数
            customValueWhenCreate(entity);
            
            defaultValueWhenCreate(entity);

            // 验证
            validtionValueWhenCreate(entity, CommonCheck.Null);
        }
        
        // 转化
        return convertTo(entity);
    }
    
    /**
     * 构建新数据
     *
     * 进行必要的检查
     *
     * @param entityList
     * @return
     * @throws ServiceException
     */
    @SuppressWarnings("unchecked")
    public List<S> buildNew(List<E> entityList) throws ServiceException{
        return buildNew(entityList, ForeachHandle.NULL);
    }
    
    /**
     * 构建新数据
     *
     * 进行必要的检查
     *
     * @param entityList
     * @param handle
     * @return
     * @throws ServiceException
     */
    public List<S> buildNew(List<E> entityList, ForeachHandle<S, E> handle) throws ServiceException {
        if(Check.NuNCollections(entityList))
            return null;
        
        List<S> result = new ArrayList<S>(entityList.size());
        
        for (Iterator<E> iterator = entityList.iterator(); iterator.hasNext();) {
            E e = iterator.next();
            S s = buildNew(e);
            
            handle.handle(s, e);
            result.add(s);
        }
        
        return result;
    }
    
    /**
     * 构建已存在的实体
     *
     * 进行必要的检查
     *
     * @param entity
     * @return
     * @throws ServiceException 
     */
    public S buildExisted(E entity) throws ServiceException{
        checkNull(entity, "实体对象不能为null");
        checkNull(entity.getId(), "实体对象的id不能为null");
        
        defaultValueWhenModify(entity);
        
        return convertTo(entity);
    }
    
    /**
     * 构建已存在的实体
     *
     * 进行必要的检查
     *
     * @param entityList
     * @return
     * @throws ServiceException 
     */
    @SuppressWarnings("unchecked")
    public List<S> buildExisted(List<E> entityList) throws ServiceException{
        return buildExisted(entityList, ForeachHandle.NULL);
    }
    
    /**
     * 构建已存在的实体
     *
     * 进行必要的检查
     *
     * @param entityList
     * @param handle
     * @return
     * @throws ServiceException 
     */
    public List<S> buildExisted(List<E> entityList, ForeachHandle<S, E> handle) throws ServiceException{
        if(Check.NuNCollections(entityList))
            return null;
        
        List<S> result = new ArrayList<S>(entityList.size());
        
        for (Iterator<E> iterator = entityList.iterator(); iterator.hasNext();) {
            E e = iterator.next();
            S s = buildExisted(e);
            
            handle.handle(s, e);
            result.add(s);
        }
        
        return result;
    }
    
    
    /**
     * 构建已存在的实体
     *
     * 进行必要的检查
     *
     * @param entity
     * @return
     * @throws ServiceException 
     */
    private S buildNewOrExisted(E entity) throws ServiceException{
        checkNull(entity, "实体对象不能为null");
        checkNull(entity.getId(), "实体对象的id不能为null");
        
        if(null == entity.getId()){            
            // 设置默认参数
            customValueWhenCreate(entity);
            
            defaultValueWhenCreate(entity);

            // 验证
            validtionValueWhenCreate(entity, CommonCheck.Null);
        } else {
            if (null == entity.getUpdateDate()) {
                entity.setUpdateDate(new Date());
            }
        }
        
        // 转化
        return convertTo(entity);
    }
    
    /**
     * <h3>构建已存在的实体</h3>
     * <p>进行必要的检查</p>
     * @param entityList
     * @return
     * @throws ServiceException 
     */
    @SuppressWarnings({ "unchecked", "unused" })
    private List<S> buildNewOrExisted(List<E> entityList) throws ServiceException{
        return buildNewOrExisted(entityList, ForeachHandle.NULL);
    }
    
    /**
     * <h3>构建已存在的实体</h3>
     * <p>进行必要的检查</p>
     * @param entityList
     * @param handle
     * @return
     * @throws ServiceException 
     */
    private List<S> buildNewOrExisted(List<E> entityList, ForeachHandle<S, E> handle) throws ServiceException{
        if(Check.NuNCollections(entityList))
            return null;
        
        List<S> result = new ArrayList<S>(entityList.size());
        
        for (Iterator<E> iterator = entityList.iterator(); iterator.hasNext();) {
            E e = iterator.next();
            S s = buildNewOrExisted(e);
            
            handle.handle(s, e);
            result.add(s);
        }
        
        return result;
    }

    /**
     * 当实体被创建时的校验
     * @param entity
     * @throws ServiceException
     */
    protected abstract void validtionValueWhenCreate(E entity, CommonCheck check)throws ServiceException ;


    /**
     * 当实体被创建时，自定义的默认值
     * @param entity
     */
    protected abstract void customValueWhenCreate(E entity);
    
    /**
     * 当实体被修改时，自定义的默认值
     * @param entity
     */
    protected abstract void customValueWhenModify(E entity);
    
    /**
     * 当实体被创建时的默认值
     * @param entity
     */
    protected void defaultValueWhenCreate(E entity) {
        if(null == entity.getCreateDate()){
            entity.setCreateDate(new Date());
        }
        if (null == entity.getDelFlag()) {
            entity.setDelFlag(GlobalParam.FLAG.start().toString());
        }
    }
    
    /**
     * 当实体被修改时的默认值
     * @param entity
     */
    protected void defaultValueWhenModify(E entity) {
        if (null == entity.getUpdateDate()) {
            entity.setUpdateDate(new Date());
        }
    }
}