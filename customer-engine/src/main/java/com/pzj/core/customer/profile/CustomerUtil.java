package com.pzj.core.customer.profile;

import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.entitys.CustomerEntity;

/**
 * Created by Administrator on 2017-3-8.
 */
public class CustomerUtil {
    public static Long masterId(SysUser user){
        if ("1".equals(user.getIsRoot())){
            return user.getId();
        }
        return user.getSupplierId();
    }

    public static Long masterId(CustomerEntity user){
        if ("1".equals(user.getIsRoot())){
            return user.getId();
        }
        return user.getSupplierId();
    }
}
