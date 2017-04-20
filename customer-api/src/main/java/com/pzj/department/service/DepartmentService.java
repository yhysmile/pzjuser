package com.pzj.department.service;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.department.entity.Department;
import com.pzj.role.entity.Role;

/**
 * 部门接口
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-8-27 下午5:36:11
 */
public interface DepartmentService {

	/**
	 * 创建部门
	 * 
	 * @param department
	 *            部门实体
	 */
	Long createDepartment(Department department) throws Exception;

	/**
	 * 编辑保存部门
	 * 
	 * param Department 部门实体
	 */
	Integer saveDepartment(Department department) throws Exception;

	/**
	 * 编辑保存部门及部门角色关系信息
	 * <p/>
	 * 此接口同{@link #addDepartmentToRole(Department)}重复，请参看其说明。
	 * 
	 * @param department
	 * @return
	 * @throws Exception
	 */
	Long saveDepartmentRelation(Department department) throws Exception;

	/**
	 * 
	 * @param departments
	 * @return
	 * @throws Exception
	 */
	Integer addDepartmentToRole(List<Department> departments) throws Exception;

	/**
	 * 根据主键id获取角色信息
	 * 
	 * @param id
	 *            部门主键id
	 * @return
	 */
	Department getDepartmentById(Long id) throws Exception;

	/**
	 * 查询部门列表，支持多参数
	 * 
	 * @param department
	 *            部门实体
	 * @return 分页对象
	 */
	List<Department> findDepartmentByParams(Department department) throws Exception;

	/**
	 * 查询部门列表及部门用户列表，用户部门角色关系列表，支持多参数
	 * 
	 * @param department
	 *            部门实体
	 * @return 分页对象
	 */
	List<Department> findDepartmentAuthByParams(Department department) throws Exception;

	/**
	 * 查询部门列表，根据角色
	 * 
	 * @param role
	 *            角色
	 * @return
	 * @throws Exception
	 */
	List<Department> findDepartmentByRole(Role role) throws Exception;

	/**
	 * 分页查询部门列表，支持多参数
	 * 
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            每页显示记录数
	 * @param department
	 *            部门实体
	 * @return 分页对象
	 */
	PageList<Department> findDepartmentPageByParams(Integer pageNo, Integer pageSize, Department department)
			throws Exception;

	/**
	 * 分页查询部门列表及部门用户列表，用户部门角色关系列表，支持多参数
	 * 
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            每页显示记录数
	 * @param department
	 *            部门实体
	 * @return 分页对象
	 */
	PageList<Department> findDepartmentAuthPageByParams(Integer pageNo, Integer pageSize, Department department)
			throws Exception;

	/**
	 * 获取部门及部门下的用户列表
	 * 
	 * @param departments
	 *            部门实体
	 * @return 部门实体
	 */
	List<Department> getDepartmentCustomerList(List<Department> departments) throws Exception;

	/**
	 * 获取部门及部门下的用户部门角色列表
	 * 
	 * @param departments
	 *            部门实体
	 * @return 部门实体
	 */
	List<Department> getDepartmentCRList(List<Department> departments) throws Exception;

	/**
	 * 获取部门及部门下的用户列表，用户部门角色列表
	 * 
	 * @param departments
	 *            部门实体
	 * @return 部门实体
	 */
	List<Department> getDepartmentAuthList(List<Department> departments) throws Exception;

	/**
	 * 获取部门的上一级部门
	 * 
	 */
	List<Department> getParDepartment(List<Department> departments) throws Exception;

	/**
	 * 获取部门的下一级部门列表
	 * 
	 */
	List<Department> getSubDepartmentList(List<Department> departments) throws Exception;

	/**
	 * 逻辑删除部门
	 * 
	 * @param departmentId
	 *            部门实体
	 * 
	 */
	Integer deleteDepartment(Long departmentId) throws Exception;

	/**
	 * 物理删除部门
	 * 
	 * @param departmentId
	 *            部门实体
	 * 
	 */
	Integer deletePhysicalDepartment(Long departmentId) throws Exception;

	/**
	 * 编辑保存部门及部门角色关系信息
	 * <p/>
	 * 添加或更新（存在ID时更新）部门信息； 如果角色信息不存在（角色没有ID），则添加角色信息； 关联部门与角色。
	 *
	 * @param departments
	 * @return
	 * @throws Exception
	 */
	Long addDepartmentToRole(Department departments) throws Exception;

	/**
	 * 根据部门及岗位的信息查询 部门及相应岗位的信息（其中用户的的信息为null）
	 * 
	 * @param department
	 *            部门相关信息 role 岗位相关信息
	 * @return 符合条件的部门 含有岗位属性
	 * @throws Exception
	 */

	List<Department> findByDepartmentAndRole(Department department, Role role) throws Exception;

}
