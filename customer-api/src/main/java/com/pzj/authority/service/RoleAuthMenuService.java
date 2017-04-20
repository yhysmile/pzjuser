package com.pzj.authority.service;

import java.util.List;

import com.pzj.authority.entity.RoleAuthMenu;

/**
 * 角色的菜单权限接口
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-8-27 上午11:26:40
 */
public interface RoleAuthMenuService {

	/**
	 * 配置角色的菜单权限
	 * 
	 * @param list
	 *            角色拥有菜单权限的集合
	 * @throws Exception
	 */
	void createRoleAuthMenu(List<RoleAuthMenu> list) throws Exception;

	/**
	 * 编辑保存角色拥有的菜单权限
	 * 
	 * @param list
	 *            角色拥有菜单权限的集合
	 * @throws Exception
	 */
	void deleteRoleAuthMenu(List<RoleAuthMenu> list) throws Exception;

}
