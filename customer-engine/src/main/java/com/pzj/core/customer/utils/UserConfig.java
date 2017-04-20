package com.pzj.core.customer.utils;

import java.util.Properties;

/**
 * Created by Administrator on 2016-12-22.
 */
public class UserConfig {
    private Properties configs;

    public void setConfigs(Properties configs) {
        this.configs = configs;
    }

    public String getMicroshopDefaultAvatar(){
        return configs.getProperty("microshop.default.avatar");
    }

    public String getMicroshopDefaultName(){
        return configs.getProperty("microshop.default.name");
    }

    public String getMicroshopDefaultIntro(){
        return configs.getProperty("microshop.default.intro");
    }

    public String getMqTopic(){
        return configs.getProperty("mq.topic");
    }

    public String getMqTagUserCheck(){
        return configs.getProperty("mq.tag.user.check");
    }

    public String getAppDownload(){
        return configs.getProperty("app.download");
    }

    public Boolean getCustomerCreatePasswordSms(){
        String value = configs.getProperty("customer.create.password.sms");
        return value == null ? false : "true".equals(value);
    }
}
