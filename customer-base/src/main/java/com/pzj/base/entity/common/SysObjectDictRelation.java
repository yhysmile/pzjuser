/*
 * SysObjectDictRelation.java 
 * www.piaozhijia.coim
 */
package com.pzj.base.entity.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * vo.区域
 * 
 * @author 票之家
 */

public class SysObjectDictRelation extends BaseEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -2946755347522513860L;

    private String object;
    /** 对应列 */
    private String attribute;

    /** 对应数据列主键Id */
    private Long objectId;

    /** 字典多选值列表 */
    List<SysObjectDictRelationChild> childList;

    /** 设置 对应表 */
    public void setObject(String object) {
        this.object = object;
    }

    /** 得到 对应表 */
    public String getObject() {
        return object;
    }

    /** 设置 对应列 */
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    /** 得到 对应列 */
    public String getAttribute() {
        return attribute;
    }

    /** 设置 对应数据列主键Id */
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    /** 得到 对应数据列主键Id */
    public Long getObjectId() {
        return objectId;
    }

    /**
     * 获取字典多选值列表
     * 
     * @return childList 字典多选值列表
     */
    public List<SysObjectDictRelationChild> getChildList() {
        return childList;
    }

    /**
     * 设置字典多选值列表
     * 
     * @param childList
     *            字典多选值列表
     */
    public void setChildList(List<SysObjectDictRelationChild> childList) {
        this.childList = childList;
    }

    public static SysObjectDictRelation convertTSysBean(String attributeValue, String object, String attribute, Long objectId) {  	
        SysObjectDictRelation bean = new SysObjectDictRelation();
        bean.setObject(object);
        bean.setAttribute(attribute);
        bean.setObjectId(objectId);
        bean.setChildList(SysObjectDictRelationChild.convertTSysBean(bean, attributeValue));
        return bean;
    }

    public static List<SysObjectDictRelationChild> getAllChildList(List<SysObjectDictRelation> entityList) {
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        List<SysObjectDictRelationChild> resultList = new ArrayList<SysObjectDictRelationChild>();
        for (SysObjectDictRelation entity : entityList) {
            if (entity.getChildList() != null)
                resultList.addAll(entity.getChildList());
        }
        return resultList;

    }

}
