/*
 * SysObjectDictRelation.java 
 * www.piaozhijia.coim
 */
package com.pzj.base.entity.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.pzj.base.common.BaseEntity;

/**
 * vo.区域
 * 
 * @author 票之家
 */

public class SysObjectDictRelationChild extends BaseEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -2946755347522513860L;
    /** 数据字典key */
    private String type;
    /** 数据字典value */
    private String value;
    /** 数据字典标签 */
    private String label;

    private String object;
    /** 对应列 */
    private String attribute;

    /** 对应数据列主键Id */
    private Long objectId;

    /** 创建时间 */
    private Date createDate;
    /** 使用状态1启用0禁用2删除 */
    private Integer delFlag;
    /** 排序 */
    private Integer sort;
    /** 更新时间 */
    private Date updateDate;
    /** 最新更新人 */
    private String updateBy;
    /** 创建人 */
    private String createBy;
    /** 创建供应商 */
    private Long supplierId;

    public SysObjectDictRelationChild() {

    }

    public static List<SysObjectDictRelationChild> convertTSysBean(SysObjectDictRelation parentBean, String attributeValue) {
        List<SysObjectDictRelationChild> childList = null;
        if (org.apache.commons.lang.StringUtils.isNotBlank(attributeValue)) {
            String[] rules = attributeValue.split(",");
            childList = new ArrayList<SysObjectDictRelationChild>();
            for (String s : rules) {
                String[] vo = s.split("#");
                if (vo != null && vo.length == 2) {
                    SysObjectDictRelationChild child = new SysObjectDictRelationChild();
                    child.setObject(parentBean.getObject());
                    child.setAttribute(parentBean.getAttribute());
                    child.setObjectId(parentBean.getObjectId());
                    child.setType(vo[0]);
                    child.setValue(vo[1]);
                    childList.add(child);
                }
            }
        }
        return childList;
    }

    /**
     * 获取数据字典key
     * 
     * @return type 数据字典key
     */
    public String getType() {
        return type;
    }

    /**
     * 设置数据字典key
     * 
     * @param type
     *            数据字典key
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取数据字典value
     * 
     * @return value 数据字典value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置数据字典value
     * 
     * @param value
     *            数据字典value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取数据字典标签
     * 
     * @return label 数据字典标签
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置数据字典标签
     * 
     * @param label
     *            数据字典标签
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 获取object
     * 
     * @return object object
     */
    public String getObject() {
        return object;
    }

    /**
     * 设置object
     * 
     * @param object
     *            object
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * 获取对应列
     * 
     * @return attribute 对应列
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * 设置对应列
     * 
     * @param attribute
     *            对应列
     */
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    /**
     * 获取对应数据列主键Id
     * 
     * @return objectId 对应数据列主键Id
     */
    public Long getObjectId() {
        return objectId;
    }

    /**
     * 设置对应数据列主键Id
     * 
     * @param objectId
     *            对应数据列主键Id
     */
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    /**
     * 获取创建时间
     * 
     * @return createDate 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     * 
     * @param createDate
     *            创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取使用状态1启用0禁用2删除
     * 
     * @return delFlag 使用状态1启用0禁用2删除
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置使用状态1启用0禁用2删除
     * 
     * @param delFlag
     *            使用状态1启用0禁用2删除
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取排序
     * 
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     * 
     * @param sort
     *            排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取更新时间
     * 
     * @return updateDate 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     * 
     * @param updateDate
     *            更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取最新更新人
     * 
     * @return updateBy 最新更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置最新更新人
     * 
     * @param updateBy
     *            最新更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取创建人
     * 
     * @return createBy 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     * 
     * @param createBy
     *            创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建供应商
     * 
     * @return supplierId 创建供应商
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * 设置创建供应商
     * 
     * @param supplierId
     *            创建供应商
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

}
