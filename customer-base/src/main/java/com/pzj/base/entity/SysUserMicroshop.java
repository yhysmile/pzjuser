package com.pzj.base.entity;

import com.pzj.base.common.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016-12-7.
 */
public class SysUserMicroshop extends BaseEntity implements Serializable {
    private Long userId;
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

    private Date createDate;

    private Date updateDate;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
