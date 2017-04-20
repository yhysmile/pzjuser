package com.pzj.department.entity;

import com.pzj.base.entity.SysOffice;
import com.pzj.util.ForeachHandle;

public interface DepartmentForeachHandle extends ForeachHandle<SysOffice, Department> {

    void handle(SysOffice sysOffice, Department department);

}
