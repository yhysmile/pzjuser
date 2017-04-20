package com.pzj.menu.service;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.utils.PageList;
import com.pzj.menu.entity.Menu;

/**
 * 菜单接口
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-8-27 下午3:45:12
 */
public interface MenuService {

    /**
     * 创建菜单
     * 
     * @param Menu
     *            菜单实体
     */
    Long createMenu(Menu menu) throws Exception;
    

    /**
     * <h3>创建菜单</h3>
     * 
     * <p>批量创建菜单</p>
     * 
     * @param menuList
     *            菜单实体集合
     */
    Long createMenu(List<Menu> menuList) throws Exception;

    /**
     * 编辑保存菜单
     * 
     * @param Menu
     *            菜单实体
     */
    Integer saveMenu(Menu menu) throws Exception;

    /**
     * <h3>编辑保存菜单</h3>
     * 
     * <p>批量保存菜单</p>
     * 
     * @param menuList
     *            菜单实体集合
     */
    Integer saveMenu(List<Menu> menuList) throws Exception;

    /**
     * 根据主键id获得菜单信息
     * 
     * @param id
     *            菜单主键id
     * @return 菜单实体
     */
    Menu getMenuById(Long id) throws Exception;

    /**
     * 查询菜单列表，支持多参数
     * 
     * @param Menu
     *            菜单实体
     * @return 分页对象
     */
    List<Menu> findMenuByParams(Menu menu) throws Exception;

    /**
     * 查询菜单列表，支持多参数
     * 
     * @param pageNo
     *            当前页码
     * @param pageSize
     *            每页显示记录数
     * @param Menu
     *            菜单实体
     * @return 分页对象
     */
    PageList<Menu> findMenuPageByParams(Integer pageNo, Integer pageSize, Menu menu) throws Exception;

    /**
     * 逻辑删除菜单
     * 
     * @param id
     *            菜单主键id
     * @return
     */
    public Integer deleteMenu(Long menuId) throws Exception;

    /**
     * 物理删除菜单，删除菜单与角色，用户的关系
     * 
     * @param id
     *            菜单主键id
     * @return
     */
    public Integer deletePhysicalMenu(Long menuId) throws Exception;

    /**
     * 
     * @param menuId
     * @return
     * @throws Exception
     */
    public Map<String, Object> findParentAndChild(Long menuId) throws Exception;
}
