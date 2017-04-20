package com.pzj.base.common;

import java.io.Serializable;
import java.util.List;

import com.pzj.base.entity.common.SysObjectDictRelation;

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 3121418431571658519L;

    private Long id;

    /**
     * 标记位更新实体，是否将字段值为NULL的数据更新到数据库
     */
    private Boolean isNeedUpdateNull = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取标记位更新实体，是否将字段值为NULL的数据更新到数据库
     * 
     * @return isNeedUpdateNull 标记位更新实体，是否将字段值为NULL的数据更新到数据库
     */
    public Boolean getIsNeedUpdateNull() {
        return isNeedUpdateNull;
    }

    /**
     * 设置标记位更新实体，是否将字段值为NULL的数据更新到数据库
     * 
     * @param isNeedUpdateNull
     *            标记位更新实体，是否将字段值为NULL的数据更新到数据库
     */
    public void setIsNeedUpdateNull(Boolean isNeedUpdateNull) {
        this.isNeedUpdateNull = isNeedUpdateNull;
    }

    /**
     * 设置标记位：是否有多选数据字典的属性以SysObjectDictRelation的方式储存。
     * 
     * @param dictRelationList
     *            标记位：是否有多选数据字典的属性以SysObjectDictRelation的方式储存。
     */
    public List<SysObjectDictRelation> getDictRelationList() {
        // 由子类自己实现
        return null;
    }
    
    public boolean hasValidID(){
    	if(this.id == null || this.id < 1){
    		return false;
    	}
    	return true;
    }
    

 
}
