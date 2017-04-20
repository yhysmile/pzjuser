package com.pzj.customer.entity;

import com.pzj.base.entity.SysUser;
import com.pzj.util.ForeachHandle;

public interface CustomerForeachHandle extends ForeachHandle<SysUser, Customer> {

    void handle(SysUser sysUser, Customer customer);

}
