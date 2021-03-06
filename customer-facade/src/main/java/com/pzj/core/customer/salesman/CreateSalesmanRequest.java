package com.pzj.core.customer.salesman;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-2-26.
 */
public class CreateSalesmanRequest implements Serializable {

    /**
     * 联系人名
     */
    private String corporater;

    /**
     * 联系人手机号
     */
    private String corporaterMobile;

    /**
     * 所属单位
     */
    private String department;

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
     * 地址
     */
    private String address;

    /**
     * 创建人id
     */
    private Long createBy;
    /**
     * 创建销售人员的软件平台编号
     */
    private Integer dataSource;

    public String getCorporater() {
        return corporater;
    }

    public void setCorporater(String corporater) {
        this.corporater = corporater;
    }

    public String getCorporaterMobile() {
        return corporaterMobile;
    }

    public void setCorporaterMobile(String corporaterMobile) {
        this.corporaterMobile = corporaterMobile;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

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

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }
}
