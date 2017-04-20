package com.pzj.base.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseDataSourceEntity;
import com.pzj.base.common.BaseEntity;

public class SysRole extends BaseDataSourceEntity implements Serializable {

    private static final long serialVersionUID = -5128761280458517912L;

    /** 角色名称 */
    private String            name;

    /**
     * 角色类型
     */
    private String            type;

    /** 数据范围 */
    private String            dataScope;

    /** 创建者 */
    private String            createBy;

    /** 创建时间 */
    private Date              createDate;

    /** 更新者 */
    private String            updateBy;

    /** 更新时间 */
    private Date              updateDate;

    /** 备注信息 */
    private String            remarks;

    /** 删除标记 2:删除 */
    private String            delFlag;

    private Integer           bingding;

    private BaseEntity        parentRef;

    private String            officeId;
    /**
     * 别名
     */
    private String            alias;

    /**
     * 供应商ID
     */
    private Long              supplierId;

    /**
     * 查询是否需要售票岗位（id为2215000000000000的Role）
     * <p/>
     * 用于findByDempartmentRole接口
     */
    private Boolean           needBingdingRole;

    /**
     * 查询参数，查询数据范围
     */
    private List<String>      queryDataScope;

    /**
     * 获取查询参数，查询数据范围
     * 
     * @return queryDataScope 查询参数，查询数据范围
     */
    public List<String> getQueryDataScope() {
        return queryDataScope;
    }

    /**
     * 设置查询参数，查询数据范围
     * 
     * @param queryDataScope
     *            查询参数，查询数据范围
     */
    public void setQueryDataScope(List<String> queryDataScope) {
        this.queryDataScope = queryDataScope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取角色类型
     * 
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * 设置角色类型
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope == null ? null : dataScope.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getBingding() {
        return bingding;
    }

    public void setBingding(Integer isBingding) {
        this.bingding = isBingding;
    }

    /**
     * @return the parentRef
     */
    public BaseEntity getParentRef() {
        return parentRef;
    }

    /**
     * @param parentRef
     *            the parentRef to set
     */
    public void setParentRef(BaseEntity parentRef) {
        this.parentRef = parentRef;
    }

    /**
     * @return the officeId
     */
    public String getOfficeId() {
        return officeId;
    }

    /**
     * @param officeId
     *            the officeId to set
     */
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Boolean getNeedBingdingRole() {
        return needBingdingRole;
    }

    public void setNeedBingdingRole(Boolean needBingdingRole) {
        this.needBingdingRole = needBingdingRole;
    }
}