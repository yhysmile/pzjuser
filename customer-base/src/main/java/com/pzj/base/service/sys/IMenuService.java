package com.pzj.base.service.sys;

import java.util.List;
import java.util.Map;

import com.pzj.base.entity.SysMenu;

/**
 * 菜单接口
 * 
 * @author huxiaona
 * @email huxiaona@mftour.cn
 * @date 2015-9-11 上午10:27:24
 */
public interface IMenuService extends IBaseUserService<SysMenu> {

	/**
	 * 根据主键集合串Ids查询菜单列表
	 * 
	 * @param IdsMap
	 *            菜单Ids
	 * 
	 */
	public List<SysMenu> findSysMenuKeyByIds(Map<String, String> IdsMap);
}
