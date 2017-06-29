package com.pzj.core.customer.profile;

import com.pzj.core.customer.common.enumerate.Enumerate;
import com.pzj.core.customer.common.enumerate.EnumerateUtil;

/**
 * Created by Administrator on 2017-5-16.
 */
public enum ProfileStatus implements Enumerate {
    // 禁用
    Disable(0, "禁用"),
    // 启用
    Enable(1, "启用"),
    // 已删除
    Deleted(2, "已删除");

    private static String PROFILE_STATUS_VALUES_STRING = EnumerateUtil.valuesString(values());

    private int value;
    private String desc;

    ProfileStatus(int value, String desc){
        this.value = value;
        this.desc = desc;
    }

    public static boolean containsValue(int value){
        switch (value){
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static ProfileStatus valueOf(int value){
        switch (value){
            case 0:
                return Disable;
            case 1:
                return Enable;
            case 2:
                return Deleted;
            default:
                return null;
        }
    }


    public int getValue() {
        return value;
    }

    public String getDesc(){
        return desc;
    }

    public boolean equals(Integer value){
        return value != null && this.value == value;
    }

    public boolean equals(int value){
        return this.value == value;
    }
}
