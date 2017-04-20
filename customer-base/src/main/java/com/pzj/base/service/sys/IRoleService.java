package com.pzj.base.service.sys;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.entity.SysMenu;
import com.pzj.base.entity.SysOffice;
import com.pzj.base.entity.SysRole;

/**
 * 信息接口
 * 
 * @author huxiaona
 * 
 */
public interface IRoleService extends IBaseUserService<SysRole> {

	/**
	 * 编辑保存角色信息及角色下的菜单
	 * 
	 * @param Role
	 *            角色实体
	 * @param sysMenuList
	 *            菜单实体列表
	 * 
	 * @param isRoleNeedSave
	 *            角色实体是否需要更新
	 * 
	 * @return 影响行数
	 */

	public Long saveRoleAndAuth(SysRole role, List<SysMenu> menuList,
			boolean isRoleNeedSave, boolean copyOtherRelation) throws Exception;

	/**
	 * 批量编辑保存角色信息及角色下的菜单
	 * 
	 * @param Role
	 *            角色实体
	 * @param sysMenuList
	 *            菜单实体列表
	 * 
	 * @param isRoleNeedSave
	 *            角色实体是否需要更新
	 * 
	 * @return 影响行数
	 */
	public Long saveRoleAndAuth(List<SysRole> roleList, List<SysMenu> menuList) throws Exception;

	/**
	 * 物理删除角色及角色相关的关系
	 * 
	 * @param roleId
	 * @return
	 */
	public Long delRoleAndAuth(Long roleId, boolean syncUserMenu);

	/**
	 * 根据部门名称和角色名称查询角色
	 * 
	 * @param role
	 * @return
	 */
	public PageList<SysRole> findByDempartmentRole(Integer start, Integer size,
			SysRole role) throws Exception;

	/**
	 * 根据部门ID查询部门的角色
	 * 
	 * @param office
	 * @return
	 * @throws Exception
	 */
	public List<SysRole> findByDempartment(SysOffice office) throws Exception;

}
