package com.pzj.core.customer.microshop;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-6-8.
 */
public class MicroshopEntity implements Serializable {
    /**
     * 微店id
     */
    private Long id;
    /**
     * 所属用户id
     */
    private Long masterId;
    /**
     * 微店名称
     */
    private String name;
    /**
     * 微店简介
     */
    private String intro;
    /**
     * 微店头像
     */
    private String avatar;
    /**
     * 电话号码
     */
    private String phoneNum;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
