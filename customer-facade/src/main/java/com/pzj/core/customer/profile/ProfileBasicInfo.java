package com.pzj.core.customer.profile;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-5-10.
 */
public class ProfileBasicInfo implements Serializable {
    private Long id;

    private Long supplierId;

    private Integer userType;

    private String loginName;

    private String name;

    private String corporater;

    private String corporaterMobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
