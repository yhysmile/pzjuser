package com.pzj.department.service;

import static com.pzj.department.entity.DepartmentBuilder.ADepartmentBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysOffice;
import com.pzj.base.entity.SysRole;
import com.pzj.base.entity.SysUser;
import com.pzj.base.service.sys.IOfficeService;
import com.pzj.customer.entity.Customer;
import com.pzj.department.entity.Department;
import com.pzj.department.entity.DepartmentBuilder;
import com.pzj.department.entity.DepartmentForeachHandle;
import com.pzj.department.entity.OfficeAndRole;
import com.pzj.framework.toolkit.Check;
import com.pzj.role.entity.Role;
import com.pzj.role.entity.RoleBuilder;
import com.pzj.role.entity.RoleForeachHandle;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IOfficeService iofficeService = null;

	private DepartmentUtil departmentUtil = null;

	private final DepartmentBuilder departmentBuiler = new DepartmentBuilder();

	/**
	 * 创建部门
	 * 
	 * @param department
	 *            部门实体
	 * @throws Exception
	 * 
	 */
	public Long createDepartment(Department department) throws Exception {
		try {
			SysOffice office = null;

			// 转化
			office = departmentBuiler.buildNew(department);

			// 获取部门下用户及用户下的角色
			List<SysUser> userList = null;
			Map<String, List<SysRole>> roleMap = null;
			List<Customer> customerList = department.getClist();
			if (customerList != null && !customerList.isEmpty()) {
				userList = new ArrayList<SysUser>();
				for (Customer customer : customerList) {
					SysUser user = Customer.createNewSysUser(customer, true);
					String userNum = user.getSysCode();
					userList.add(user);

					List<Role> roleList = customer.getRoleList();
					if (roleList != null && !roleList.isEmpty()) {
						roleMap = new HashMap<String, List<SysRole>>();
						List<SysRole> sysRoleList = Role.cList2SList(roleList);
						roleMap.put(userNum, sysRoleList);
					}

				}
			}

			/*
			 * List<SysRole> sysroles = null; List<Role> roles =
			 * department.getList(); if (null != roles && !roles.isEmpty()) {
			 * sysroles = Role.cList2SList(roles); }
			 */

			Long officeId = iofficeService.addOfficeAndUser(office, userList, roleMap);
			department.setId(officeId);
			return officeId;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 编辑保存部门
	 * 
	 * @param department
	 *            部门实体
	 * 
	 */
	public Integer saveDepartment(Department department) throws Exception { // OK
		try {
			if (department == null)
				return 0;

			SysOffice office = departmentBuiler.buildNew(department);

			int i = iofficeService.updateByPrimaryKey(office);

			return i;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}

	}

	public Long saveDepartmentRelation(Department department) throws Exception {
		try {
			if (department == null)
				return 0L;

			final SysOffice office = departmentBuiler.buildNew(department);

			List<Role> roleList = department.getList();

			List<SysRole> sysRoleList = Role.cList2SList(roleList, new RoleForeachHandle() {

				@Override
				public void handle(SysRole sysRole, Role role) {
					sysRole.setParentRef(office);
				}
			});

			Long i = iofficeService.saveOfficeAndRole(office, sysRoleList, true);
			department.setId(i);
			return i;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	public int saveDepartmentRelation(List<Department> departmentList) throws Exception {
		try {
			if (departmentList == null)
				return 0;

			return 0;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 根据主键id获取部门信息
	 * 
	 * @param officeId
	 *            部门主键
	 * 
	 */
	public Department getDepartmentById(Long officeId) throws Exception { // OK
		try {
			Department department = null;
			if (checkId(officeId)) {
				SysOffice office = iofficeService.getById(officeId);
				if (office != null) {
					department = departmentBuiler.convertFrom(office);
				}
			}
			return department;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	private boolean checkId(Long officeId) {
		return officeId != null && officeId > 0;
	}

	/**
	 * 查询部门列表，支持多参数
	 * 
	 * @param department
	 *            部门实体
	 * @return 分页对象
	 */
	public List<Department> findDepartmentByParams(Department department) throws Exception { // OK
		try {
			List<SysOffice> sysOffices = null;
			List<Department> departments = null;

			// 验证
			SysOffice office = null;
			if (department != null) {
				office = departmentBuiler.convertTo(department);
			}
			// 查询
			sysOffices = iofficeService.findListByParams(office);

			// 转换

			if (sysOffices != null && (!sysOffices.isEmpty())) {
				departments = departmentBuiler.buildSource(sysOffices);
			}

			return departments;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 查询部门列表及部门用户列表，用户部门角色关联关系列表，支持多参数
	 * 
	 * @param department
	 *            部门实体
	 * @return 分页对象
	 */
	public List<Department> findDepartmentAuthByParams(Department department) throws Exception {
		try {
			List<SysOffice> sysOffices = null;
			List<Department> departments = null;

			// 验证
			SysOffice office = null;
			if (department != null) {
				office = departmentBuiler.convertTo(department);
			}

			// 查询
			sysOffices = iofficeService.findListByParams(office);

			// 转换

			if (sysOffices != null && (!sysOffices.isEmpty())) {
				departments = departmentBuiler.buildSource(sysOffices);
				departmentUtil.setDepartmentAuthorityList(departments);
			}

			return departments;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 查询部门列表，支持多参数
	 * 
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            每页显示记录数
	 * @param department
	 *            部门实体
	 * @return 分页对象
	 */
	public PageList<Department> findDepartmentPageByParams(Integer pageNo, Integer pageSize, Department department)
			throws Exception {
		try {
			PageList<SysOffice> pageList = null;

			// 验证
			SysOffice office = null;
			if (department != null) {
				office = departmentBuiler.convertTo(department);
			}

			// 查询
			PageModel page = new PageModel(pageNo, pageSize);
			pageList = iofficeService.queryPageByParamMap(page, office);

			// 转换
			List<Department> departments = null;
			if (pageList != null && (!pageList.isEmpty())) {
				List<SysOffice> sysOffices = pageList.getResultList();
				departments = departmentBuiler.buildSource(sysOffices);
			}

			PageList<Department> result = new PageList<Department>();
			result.setPageBean(pageList.getPageBean());
			result.setResultList(departments);

			return result;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 查询部门列表及部门用户列表，用户部门角色关联关系列表，支持多参数
	 * 
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            每页显示记录数
	 * @param department
	 *            部门实体
	 * @return 分页对象
	 */
	public PageList<Department> findDepartmentAuthPageByParams(Integer pageNo, Integer pageSize, Department department)
			throws Exception {
		try {
			PageList<SysOffice> pageList = null;

			// 验证
			SysOffice office = null;
			if (department != null) {
				office = Department.changeTDepartment(department);
			}

			// 查询
			PageModel page = new PageModel(pageNo, pageSize);
			pageList = iofficeService.queryPageByParamMap(page, office);

			// 转换
			List<Department> departments = null;
			if (pageList != null && (!pageList.isEmpty())) {
				List<SysOffice> sysOffices = pageList.getResultList();
				departments = departmentBuiler.buildSource(sysOffices);

				departmentUtil.setDepartmentAuthorityList(departments);
			}

			PageList<Department> result = new PageList<Department>();
			result.setPageBean(pageList.getPageBean());
			result.setResultList(departments);

			return result;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 获取部门及部门的所有用户列表
	 * 
	 * @param departments
	 *            部门实体
	 * 
	 * @return 部门实体
	 * 
	 */
	public List<Department> getDepartmentCustomerList(List<Department> departments) throws Exception {
		try {
			if (departments == null || departments.isEmpty()) {
				return null;
			}

			// 查询部门
			String deptIds = departmentUtil.getDeptIds(departments);
			departments = departmentUtil.getDeptListByIds(deptIds);

			if (departments != null && !departments.isEmpty()) {

				// 封装部门的用户列表
				departmentUtil.setDeptCustList(departments);

			}
			return departments;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 获取部门及部门下的用户部门角色关系列表信息
	 * 
	 * @param departments
	 *            部门实体
	 * 
	 * @return 部门实体
	 * 
	 */
	public List<Department> getDepartmentCRList(List<Department> departments) throws Exception {
		try {
			if (departments == null || departments.isEmpty()) {
				return null;
			}

			// 查询部门
			// 获取部门集合的ID字符串
			String deptIds = departmentUtil.getDeptIds(departments);
			// 查询ID字符串查询出部门集合
			departments = departmentUtil.getDeptListByIds(deptIds);

			if (departments != null && !departments.isEmpty()) {

				// 封装部门的用户列表
				departmentUtil.setDeptDCRList(departments);

			}
			return departments;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}

	}

	/**
	 * 获取部门及部门下的用户列表，用户部门角色关系列表
	 * 
	 * @param departments
	 *            部门实体
	 * @return 部门实体
	 */
	public List<Department> getDepartmentAuthList(List<Department> departments) throws Exception {
		try {
			if (departments == null || departments.isEmpty()) {
				return null;
			}

			// 查询部门
			String deptIds = departmentUtil.getDeptIds(departments);
			departments = departmentUtil.getDeptListByIds(deptIds);

			if (departments != null && !departments.isEmpty()) {

				// 封装部门的用户列表
				departmentUtil.setDepartmentAuthorityList(departments);

			}
			return departments;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 获取部门的上一级部门
	 * 
	 * @param departments
	 *            部门实体列表
	 * 
	 */
	public List<Department> getParDepartment(List<Department> departments) throws Exception {
		try {
			if (departments == null || departments.isEmpty()) {
				return null;
			}

			String ids = departmentUtil.getDeptIds(departments);
			departments = departmentUtil.getDeptListByIds(ids);

			departmentUtil.setDepartmentPAR(departments);
			return departments;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	public String getSubParentids(Department subDepartments) {
		try {
			if (subDepartments == null || subDepartments.getParentId() == null)
				return null;

			SysOffice parent = iofficeService.getById(Long.valueOf(subDepartments.getParentId()));
			String subParentIds = parent.getParentIds() + "," + subDepartments.getParentId();
			return subParentIds;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 获取部门的下一级部门列表
	 * 
	 * @param departments
	 *            部门实体列表
	 * 
	 */
	public List<Department> getSubDepartmentList(List<Department> departments) throws Exception {
		try {
			if (departments == null || departments.isEmpty()) {
				return null;
			}
			String ids = departmentUtil.getDeptIds(departments);
			departments = departmentUtil.getDeptListByIds(ids);
			departmentUtil.setDepartmentSUB(departments);
			return departments;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 逻辑删除部门
	 * 
	 * @param departmentId
	 *            部门实体
	 * 
	 */
	public Integer deleteDepartment(Long departmentId) throws Exception {
		try {
			if (departmentId == null || departmentId < 1) {
				return 0;
			}

			int num = 0;

			SysOffice sysOffice = new SysOffice();
			sysOffice.setId(departmentId);
			sysOffice.setDelFlag(String.valueOf(GlobalParam.FLAG.del()));
			num = iofficeService.updateByPrimaryKey(sysOffice);

			return num;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 物理删除部门
	 * 
	 * @param departmentId
	 *            部门实体
	 * 
	 */
	public Integer deletePhysicalDepartment(Long departmentId) throws Exception {
		try {
			if (departmentId == null || departmentId < 1) {
				return 0;
			}

			int num = iofficeService.delete(departmentId);

			return num;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public Long addDepartmentToRole(Department departments) throws Exception {
		try {
			if (departments == null) {
				return 0L;
			}

			final SysOffice office = departmentBuiler.buildNew(departments);

			List<Role> roelList = departments.getList();
			List<SysRole> rels = Role.cList2SList(roelList, new RoleForeachHandle() {

				// 当每循环出Role并转换为SysRole时，将SysRole与SysOffice关联起来
				@Override
				public void handle(SysRole sysRole, Role role) {
					sysRole.setParentRef(office);
				}
			});

			Long num = iofficeService.saveOfficeAndRole(office, rels, true);
			office.setId(num);
			return num;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public Integer addDepartmentToRole(List<Department> departments) throws Exception {
		try {
			if (departments == null || departments.size() < 1) {
				return 0;
			}

			OfficeAndRole ora = ADepartmentBuilder.buildOfficeAndRole(departments);

			// 调用远程方法，保存SysOffice集合与SysRole集合
			Long num = iofficeService.saveBatchOfficeAndRole(ora.sysOfficeList, ora.sysRoleList);

			return Integer.valueOf(num.toString());
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public List<Department> findDepartmentByRole(Role role) throws Exception {

		/*
		 * HashMap<String, String> params = new HashMap<String, String> ();
		 * params.put(UserMapKeyParam.ROLE_MAP_KEY, value);
		 */

		/*
		 * SysRoleOfficeUserKey params = new SysRoleOfficeUserKey(); params.
		 * 
		 * iroleAuthOfficeService.findListByParams(entity);
		 */

		return null;
	}

	/**
	 * 根据部门及岗位的信息查询 部门及相应岗位的信息（其中用户的的信息为null）
	 * 
	 * @param department
	 *            部门相关信息（忽略部门中Roles的相关参数）
	 * @param role
	 *            岗位相关信息
	 * @return 符合条件的部门 含有岗位属性
	 * @throws Exception
	 */
	@Override
	public List<Department> findByDepartmentAndRole(Department department, Role role) throws Exception {
		try {

			List<SysOffice> sysOffices = null;
			List<Department> departments = null;
			// 将API端实体转换为底层实体
			SysOffice office = null;
			if (department != null) {
				office = departmentBuiler.convertTo(department);
			}
			SysRole sysRole = null;
			if (role != null) {
				sysRole = Role.changeTSysRole(role);
			}
			// 查询
			sysOffices = iofficeService.findByOfficeAndRole(office, sysRole);
			// 转换
			if (sysOffices != null && (!sysOffices.isEmpty())) {
				departments = DepartmentBuilder.ADepartmentBuilder.buildSource(sysOffices,
						new DepartmentForeachHandle() {
							public void handle(SysOffice sysOffice, Department department) {
								List<SysRole> sysRoleList = sysOffice.getRoles();
								if (Check.NuNCollections(sysRoleList))
									return;

								List<Role> roleList = RoleBuilder.ARoleBuilder.buildSource(sysRoleList);
								department.setList(roleList);
							}
						});
			}
			return departments;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

}
