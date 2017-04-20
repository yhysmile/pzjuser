package com.pzj.address.entity;

import com.pzj.util.CommonEntity;

import java.io.Serializable;

/**
 * 地址
 * Created by wuliqing on 2016-10-18.
 */
public class Address extends CommonEntity implements Serializable {
    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县
     */
    private String county;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String postcode;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 所属供应商ID
     */
    private Long supplierId;

    /**
     * 是否为默认
     */
    private Boolean isDefault;


    /**
     * 创建人ID
     */
    private Long createBy;

    /**
     * 更新人ID
     */
    private Long updateBy;

    /**
     * 所属平台
     */
    private String dataSource;

    /**
     * 名称
     */
    private String name;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
        if (createBy != null) {
            super.setCreateBy(String.valueOf(createBy));
        }
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
        if (updateBy != null) {
            super.setUpdateBy(String.valueOf(updateBy));
        }
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
