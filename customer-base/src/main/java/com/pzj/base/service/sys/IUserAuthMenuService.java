package com.pzj.base.service.sys;

import java.util.List;
import java.util.Map;

import com.pzj.base.entity.SysMenu;
import com.pzj.base.entity.SysRoleMenuKey;
import com.pzj.base.entity.SysUserMenuKey;
import com.pzj.base.entity.SysUserRoleKey;
import com.pzj.base.entity.SysUserRoleMenuVo;

/**
 * 权限接口
 * 
 * @author huxiaona
 * @email huxiaona@mftour.cn
 * @date 2015-9-11 上午11:13:01
 */
public interface IUserAuthMenuService extends
		IBaseRelationshipService<SysUserMenuKey> {

	/**
	 * 通过角色与菜单关系，批量关联角色所拥有的菜单与用户的关联关系
	 * 
	 * @param roleIdList
	 * 
	 * @return 影响行数
	 */
	public Long insertBatchByRoleAndMenu(List<SysRoleMenuKey> records);

	/**
	 * 通过用户与角色的关系，批量关联用户与菜单的关联关系
	 * 
	 * @param roleIdList
	 * 
	 * @return 影响行数
	 */
	public Long insertBatchByUserAndRole(List<SysUserRoleKey> records);

	/**
	 * 多参数查询用户角色菜单关系信息
	 * 
	 * @param record
	 *            用户角色菜单关系实体
	 * 
	 * @return 用户角色关系信息列表
	 * 
	 */
	public List<SysUserRoleMenuVo> findURMById(SysUserRoleMenuVo record);

	/**
	 * 根据主键集合串Ids查询用户角色菜单关系信息
	 * 
	 * @param 用户Ids
	 *            :userIds,角色Ids:roleIds, 菜单Ids:menuIds
	 * 
	 * @return 用户角色菜单关系信息
	 */
	public List<SysUserRoleMenuVo> findURMByIds(Map<String, String> idsMap);

	public List<SysUserMenuKey> findMenuByRelationMenu(SysUserMenuKey userMenuParam, SysMenu menuParam);
}
