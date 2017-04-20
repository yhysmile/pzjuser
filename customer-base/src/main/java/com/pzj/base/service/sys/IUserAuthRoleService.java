package com.pzj.base.service.sys;

import java.util.List;
import java.util.Map;

import com.pzj.base.entity.SysRole;
import com.pzj.base.entity.SysUserRoleKey;

/**
 * 权限接口
 * 
 * @author huxiaona
 * @email huxiaona@mftour.cn
 * @date 2015-9-11 上午11:13:01
 */
public interface IUserAuthRoleService extends IBaseRelationshipService<SysUserRoleKey> {
    public List<SysUserRoleKey> findRoleByRelationRole(SysUserRoleKey relationParam, SysRole roleParam);
    
    public Long updateAuthBatch(Map<String, String> idsMap, List<SysUserRoleKey> relationRecords, boolean copyRoleMneu); 
}
