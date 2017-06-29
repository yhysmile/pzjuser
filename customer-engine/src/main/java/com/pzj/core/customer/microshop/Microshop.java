package com.pzj.core.customer.microshop;

import com.pzj.core.customer.common.exception.CustomerException;

/**
 * Created by Administrator on 2017-6-8.
 */
public class Microshop {
    /**
     * 构建一个现在的、已经存在的微店
     * @param id
     * @param masterId
     * @param name
     * @param avatar
     * @param intro
     * @param phoneNum
     * @return
     */
    public static Microshop buildMicroshop(Long id, Long masterId, String name, String avatar, String intro, String phoneNum){
        Microshop microshop = new Microshop(id, masterId, name);
        microshop.changeIntro(intro);
        microshop.changeAvatar(avatar);
        microshop.changePhoneNun(phoneNum);

        return microshop;
    }

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
    private String phoneNun;

    private Microshop(Long id, Long masterId, String name) {
        if (id == null){
            throw new CustomerException(1, "123");
        }
        if (masterId == null){
            throw new CustomerException(1, "123");
        }

        this.id = id;
        this.masterId = masterId;
        this.name = name;
    }

    public Long id() {
        return id;
    }

    public Long masterId(){
        return masterId;
    }

    public String name(){
        return name;
    }

    public String intro(){
        return intro;
    }

    public String avatar(){
        return avatar;
    }

    public String phoneNum(){
        return phoneNun;
    }

    public void changeName(String name){
        this.name = name;
    }

    public void changeIntro(String intro){
        this.intro = intro;
    }

    public void changeAvatar(String avatar){
        this.avatar = avatar;
    }

    public void changePhoneNun(String phoneNun){
        this.phoneNun = phoneNun;
    }
}
