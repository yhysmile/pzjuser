package com.pzj.core.customer.microshop;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-6-9.
 */
public class MicroshopContent implements Serializable {
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
}
