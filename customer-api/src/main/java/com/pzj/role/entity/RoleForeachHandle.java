package com.pzj.role.entity;

import com.pzj.base.entity.SysRole;
import com.pzj.util.ForeachHandle;

public interface RoleForeachHandle extends ForeachHandle<SysRole, Role>{

    void handle(SysRole sysRole, Role role);

}
