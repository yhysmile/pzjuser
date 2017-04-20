package com.pzj.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;

public class SysOffice extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -3545239439316639595L;

    /** 父级编号 */
    private String            parentId;

    /** 所有父级编号 */
    private String            parentIds;

    /** 归属区域 */
    private String            areaId;

    /** 区域编码 */
    private String            code;

    /** 机构名称 */
    private String            name;

    /** 机构类型 */
    private String            type;

    /** 机构等级 */
    private String            grade;

    /** 联系地址 */
    private String            address;

    /** 邮政编码 */
    private String            zipCode;

    /** 负责人 */
    private String            master;

    /** 电话 */
    private String            phone;

    /** 传真 */
    private String            fax;

    /** 邮箱 */
    private String            email;

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

    /** 删除标记 1 正常、0禁用 */
    private String            delFlag;

    /**
     * 审核状态
     */
    private String            auditStatus;

    /** 数据源 */
    private String            dataSource;

    /**
     * 供应商ID
     */
    private Long              supplierId;
    private List<SysRole>     roles            = new ArrayList<SysRole>();

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

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master == null ? null : master.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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
     * 获取审核状态
     * 
     * @return
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态
     * 
     * @param auditStatus
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}