package com.pzj.dao;

import java.util.List;
import java.util.Map;
import com.pzj.base.entity.SysOffice;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysRole;

@MyBatisDao
public interface SysRoleMapper extends BaseUserMapper<SysRole> {

    List<SysRole> findByIdsMap(Map<String, String> map);

    List<SysRole> findByOfficeRole(SysRole role, PageModel pager);

    Integer countByOfficeRole(SysRole role);
    
    List<SysRole> findByOffice(SysOffice office);
}