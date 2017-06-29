package com.pzj.core.customer.profile;

import com.pzj.core.customer.common.enumerate.Enumerate;
import com.pzj.core.customer.common.enumerate.EnumerateUtil;

/**
 * Created by Administrator on 2017-5-16.
 */
public enum ProfileType implements Enumerate {
    SaaS(13, "SaaS用户"),

    Distributor(6, "分销商"),

    Supplier(7, "供应商"),

    Employee(1, "员工");

    private static String PROFILE_TYPE_VALUES_STRING = EnumerateUtil.valuesString(values());

    private int value;
    private String desc;

    ProfileType(int value, String desc){
        this.value = value;
        this.desc = desc;
    }

    public static boolean containsValue(int value){
        switch (value){
            case 1:
            case 6:
            case 7:
            case 13:
                return true;
            default:
                return false;
        }
    }

    public static ProfileType valueOf(int value){
        switch (value){
            case 1:
                return Employee;
            case 6:
                return Distributor;
            case 7:
                return Supplier;
            case 13:
                return SaaS;
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
