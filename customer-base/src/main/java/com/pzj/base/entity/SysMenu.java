package com.pzj.base.entity;

import java.io.Serializable;
import java.util.Date;

import com.pzj.base.common.BaseEntity;

public class SysMenu extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -3220721829746015405L;

    private String            parentId;

    private String            parentIds;

    private String            name;

    private String            href;

    private String            target;

    private String            icon;

    private Integer           sort;

    private String            isShow;

    private String            isActiviti;

    private String            permission;

    private String            createBy;

    private Date              createDate;

    private String            updateBy;

    private Date              updateDate;

    private String            remarks;

    private String            delFlag;

    /** 位置 */
    private String            position;

    /** 样式 */
    private String            style;

    /** 数据源 */
    private String            dataSource;

    /**
     * 供应商ID
     */
    private Long              supplierId;

    private BaseEntity        parentRef;

    /**
     * 分类
     */
    private String            catalog;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public SysMenu() {
        super();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    public String getIsActiviti() {
        return isActiviti;
    }

    public void setIsActiviti(String isActiviti) {
        this.isActiviti = isActiviti == null ? null : isActiviti.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
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

    /**
     * 设置数据源
     * @return
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 获取数据源
     * @param dataSource
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return the parentRef
     */
    public BaseEntity getParentRef() {
        return parentRef;
    }

    /**
     * @param parentRef the parentRef to set
     */
    public void setParentRef(BaseEntity parentRef) {
        this.parentRef = parentRef;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}