package com.pzj.core.customer.profile;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-5-16.
 */
public class Profile implements Serializable {
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
    private ProfileType type;
    /**
     * 状态
     * 0：禁用
     * 1：启用
     * 2：删除
     */
    private ProfileStatus status;
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

    private Date lastLoginDate;

    public Profile(Long id){
        this.id = id;
    }

    public Long id() {
        return id;
    }

    public Long superId() {
        return superId;
    }

    public ProfileStatus status() {
        return status;
    }

    public void changeStatusTo(ProfileStatus status) {
        if (status != null) {
            this.status = status;
        }
    }

    public void enable(){
        this.status = ProfileStatus.Enable;
    }

    public void disable(){
        this.status = ProfileStatus.Disable;
    }

    public String password(){
        return password;
    }

    public void delete(){
        this.status = ProfileStatus.Deleted;
    }

    public String username() {
        return username;
    }

    public Date lastLoginDate() {
        return lastLoginDate;
    }

    public void loginAt(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void setSuperId(Long superId) {
        this.superId = superId;
    }

    public ProfileType getType() {
        return type;
    }

    public void setType(ProfileType type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
