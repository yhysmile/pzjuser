package com.pzj.core.customer.profile;

import com.pzj.base.entity.SysUser;

/**
 * Created by Administrator on 2017-6-12.
 */
public class ProfileModelConvert {
    public static SysUser convertToSysUser(Profile profile){
        if (profile == null){
            return null;
        }

        SysUser sysUser = new SysUser();
        sysUser.setId(profile.id());
        sysUser.setSupplierId(profile.superId());
        sysUser.setLoginName(profile.username());
        sysUser.setName(profile.getName());
        sysUser.setCorporater(profile.getContacts());
        sysUser.setCorporaterMobile(profile.getPhoneNum());
        sysUser.setUserType(String.valueOf(profile.getType().getValue()));
        sysUser.setAccountState(profile.status().getValue());
        if (profile.getIsRoot()) {
            sysUser.setIsRoot("1");
        } else {
            sysUser.setIsRoot("0");
        }
        return sysUser;
    }

    public static ProfileBasicInfo convertToProfileBasicInfo(Profile profile) {
        ProfileBasicInfo profileBasicInfo = new ProfileBasicInfo();
        profileBasicInfo.setId(profile.id());
        profileBasicInfo.setSupplierId(profile.superId());
        profileBasicInfo.setUserType(profile.getType().getValue());
        profileBasicInfo.setName(profile.getName());
        profileBasicInfo.setLoginName(profile.username());
        profileBasicInfo.setCorporater(profile.getContacts());
        profileBasicInfo.setCorporaterMobile(profile.getPhoneNum());
        return profileBasicInfo;
    }
}
