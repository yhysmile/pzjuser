package com.pzj.base.entity;

import com.pzj.base.common.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 联系人
 * Created by wuliqing on 2016-10-11.
 */
public class SysContacts extends BaseEntity implements Serializable {
    /**
     * 名称
     */
    private String name;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 类型说明
     */
    private String typeDesc;

    /**
     * 所属供应商ID
     */
    private Long   supplierId;

    /**
     * 创建人ID
     */
    private Long   createBy;

    /**
     * 创建时间
     */
    private Date   createDate;

    /**
     * 更新人ID
     */
    private Long   updateBy;

    /**
     * 更新时间
     */
    private Date   updateDate;

    /**
     * 所属平台
     */
    private String dataSource;

    /**
     * 英文名
     */
    private String nameEn;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否为默认
     */
    private Boolean isDefault;

    /**
     * 名称的拼音
     */
    private String namePinyin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
    }
}
