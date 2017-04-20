package com.pzj.menu.entity;

import com.pzj.base.entity.SysMenu;
import com.pzj.util.ForeachHandle;

public interface MenuForeachHandle extends ForeachHandle<SysMenu, Menu> {

    void handle(SysMenu sysMenu, Menu menu);

}
