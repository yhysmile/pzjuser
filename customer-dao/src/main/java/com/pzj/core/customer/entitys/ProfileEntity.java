package com.pzj.core.customer.entitys;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-5-16.
 */
public class ProfileEntity implements Serializable{
    /**
     * 主键id
     */
    private Long id;
    /**
     * 上级id。
     * 当isRoot=true时，superId即为agentId。
     * 当isRoot=false时，superId即为masterId。
     */
    private Long superId;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 状态
     * 0：禁用
     * 1：启用
     * 2：删除
     */
    private Integer status;
    /**
     * 昵称
     */
    private String name;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 联系人
     */
    private String contacts;
    /**
     * 手机号
     */
    private String phoneNum;
    /**
     * 是否是主帐号（1：主帐号，0：子账号）
     */
    private Boolean isRoot;

    private Long modifyUserId;

    private Date modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Boolean getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(Boolean root) {
        isRoot = root;
    }

    public Long getSuperId() {
        return superId;
    }

    public void setSuperId(Long superId) {
        this.superId = superId;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
