package com.pzj.base.entity;

import java.io.Serializable;
import java.util.Date;

import com.pzj.base.common.BaseEntity;

/**
 * 系统字典表
 * 
 * @author apple
 * 
 */
public class SysDict extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 4510573324699468935L;

    /** 主键ID */
    private Long              dictId;

    /** 显示名称 */
    private String            label;

    /** 值 */
    private String            value;

    /** 类型 */
    private String            type;

    /** 纬度 */
    private String            description;

    /** 排序 */
    private Integer           sort;

    /** 创建时间 */
    private Date              createDate;

    /** 创建人 */
    private String            createBy;

    /** 更新人 */
    private String            updateBy;

    /** 更新时间 */
    private Date              updateDate;

    /** 介绍 */
    private String            remarks;

    /** 状态 */
    private String            delFlag;

    /** 数据源 */
    private String            dataSource;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * 获取数据源
     * 
     * @return dataSource 数据源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 设置数据源
     * 
     * @param dataSource
     *            数据源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

}