package com.pzj.role.service;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.department.entity.Department;
import com.pzj.role.entity.Role;

/**
 * 角色接口
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-8-27 上午10:17:54
 */
public interface RoleService {

    /**
     * 创建角色
     * 
     * @param role
     *            角色实体
     */
    Long createRole(Role role) throws Exception;

    /**
     * 编辑保存角色
     * 
     * @param role
     *            角色实体
     */
    Long saveRole(Role role) throws Exception;

    /**
     * 更新角色的最新菜单列表
     * 
     * @param role
     *            角色实体
     * @return
     * @throws Exception
     */
    public Long saveRoleMenu(Role role) throws Exception;

    /**
     * 批量添加角色的菜单
     * 
     * @param roleList
     *            角色实体
     * @return
     * @throws Exception
     */
    public int saveRoleMenu(List<Role> roleList) throws Exception;

    /**
     * 根据主键id获得角色信息
     * 
     * @param id
     *            角色主键id
     * @return 角色实体
     */
    Role getRoleById(Long id) throws Exception;

    /**
     * 查询角色列表，支持多参数
     * 
     * @param role
     *            角色实体
     * @return 分页对象
     */
    List<Role> findRoleByParams(Role role) throws Exception;

    /**
     * 查询角色信息及角色下的菜单列表，支持多参数
     * 
     * @param role
     *            角色对象
     * 
     * 
     * @return 翻页对象
     */
    List<Role> findRoleAuthByParams(Role role) throws Exception;

    /**
     * 查询角色列表，支持多参数
     * 
     * @param pageNo
     *            当前页码
     * @param pageSize
     *            每页显示记录数
     * @param role
     *            角色实体
     * @return 分页对象
     */
    PageList<Role> findRolePageByParams(Integer pageNo, Integer pageSize, Role role) throws Exception;

    /**
     * 查询角色信息及角色下的菜单列表，支持多参数
     * 
     * @param pageNo
     *            页码
     * @param pageSize
     *            显示条数
     * @param role
     *            角色对象
     * 
     * @description pageNo和pageSize不为 null时，执行翻页
     * 
     * @return 翻页对象
     */
    public PageList<Role> findRoleAuthPageByParams(Integer pageNo, Integer pageSize, Role role) throws Exception;

    /**
     * 该角色的菜单列表
     * 
     * @param roles
     *            角色主键Id
     * 
     * @return 角色实体
     */
    List<Role> getRoleMenuList(List<Role> roles) throws Exception;

    /**
     * 逻辑删除角色
     * 
     * @param roleId
     *            角色主键id
     * @return
     */
    Integer deleteRole(Long roleId) throws Exception;

    /**
     * 物理删除角色，删除角色与用户，部门，菜单的关系
     * 
     * @param roleId
     *            角色主键id
     * @return
     */
    Integer deletePhysicalRole(Long roleId) throws Exception;

    /**
     * <h2>根据部门名称和角色名称查询角色</h2>
     * <p>
     * 参数role中可以设置角色名name、部门名alias查询角色，以及必须设置的dataSource。
     * <p>
     * 查询时通过部门信息中的name，部门与角色的关联，以及角色信息中的name，查询符合条件的角色信息，返回的角色信息中的alias为部门名称。
     * 
     * @param role
     * @return
     */
    public PageList<Role> findByDempartmentRole(Integer start, Integer size, Role role) throws Exception;

    /**
     * 根据部门ID查询部门的角色
     * 
     * @param department
     * @return
     * @throws Exception
     */
    public List<Role> findByDempartment(Department department) throws Exception;
    
    /**
     * 
     * @param role
     * @throws Exception
     */
    public Long saveRoleMenuSyncOther(Role role) throws Exception;
}
