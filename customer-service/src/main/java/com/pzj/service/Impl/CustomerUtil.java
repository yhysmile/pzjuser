package com.pzj.service.Impl;

import com.pzj.base.entity.SysUser;

/**
 * Created by Administrator on 2017-3-8.
 */
public class CustomerUtil {
    public static Long ownerId(SysUser user){
        if ("1".equals(user.getIsRoot())){
            return user.getId();
        }
        return user.getSupplierId();
    }
}
