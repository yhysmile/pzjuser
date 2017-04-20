package test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.pzj.base.common.utils.PageList;
import com.pzj.customer.entity.Customer;
import com.pzj.department.entity.Department;
import com.pzj.department.service.DepartmentService;
import com.pzj.department.service.DepartmentServiceImpl;
import com.pzj.menu.entity.Menu;
import com.pzj.role.entity.Role;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class departmentTest {

	@Autowired
	private DepartmentService departmentService = null;

	/*
	 * 创建分店
	 */
	@Test
	public void createDepartment() throws Exception {
		String aa = "邓我针喔喔喔喔喔喔喔喔喔喔喔";
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Department department = new Department();
		department.setName(aa + "Department");
		department.setParentId("1");
		department.setParentIds("1");
		department.setDelFlag("1");
		department.setAreaId("4");
		department.setType("1");
		department.setGrade("4");

		// create menu
		Menu menu = new Menu();
		menu.setName(aa + "Menu");
		menu.setCreateBy("test");
		menu.setUpdateBy("testUpdate");

		List<Menu> menulist = new ArrayList<Menu>();
		menulist.add(menu);

		// create role
		Role role = new Role();
		role.setName(aa + "Role");
		role.setDelFlag("1");
		role.setCreateBy("test");
		role.setUpdateBy("testUpdate");

		List<Role> rolelist = new ArrayList<Role>();
		rolelist.add(role);

		// create customer
		Customer custom = new Customer();
		custom.setName(aa + "Customer");
		custom.setLoginName("testLoginName");
		custom.setLoginPasswd("testpwd");
		custom.setUserType("1");
		custom.setLeaderFlag(1);
		custom.setSysCode("1");
		custom.setSort(1);
		custom.setAccountState(1);
		custom.setCreateDate(new Date());
		custom.setRoleList(rolelist);
		custom.setMenuList(menulist);

		List<Customer> customlist = new ArrayList<Customer>();
		customlist.add(custom);
		department.setClist(customlist);

		Long id = departmentService.createDepartment(department);
		System.out.println(">>>>department id is : " + id);
	}

	/*
	 * 编辑保存分店
	 */
	@Test
	public void saveDapartment() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Department dpt = new Department();
		dpt.setId(2215520224935946L);
		dpt.setParentId("2");
		dpt.setParentIds("2");
		dpt.setName("nn_2");
		dpt.setDelFlag("1");
		dpt.setAreaId("2");
		dpt.setType("2");
		dpt.setGrade("2");
		dpt.setEmail("2");
		Integer num = departmentService.saveDepartment(dpt);
		System.out.println(">>>>save num is : " + num);
	}

	/*
	 * 根据分店id获取分店
	 */
	@Test
	public void getDepartmentById() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Department dpt = new Department();
		dpt = departmentService.getDepartmentById(2L);
		System.out.println("\r\n\t>>>>>>>>>>>>department is : " + dpt.getName() + "\r\n");
	}

	/*
	 * 获取分店列表
	 */
	@Test
	public void findDepartmentByParams() throws Exception {
		Department department = new Department();
		//department.setId(11L);
		department.setSupplierId(2216619741564208L);
		List<Department> departmentlist = departmentService.findDepartmentByParams(department);
		assertNotNull(departmentlist);
		for (int i = 0; i < departmentlist.size(); i++) {
			System.out.println(">>>departmentlist is : " + departmentlist.get(i).getName());
		}
	}

	/*
	 * 获取分店及关系列表
	 */
	@Test
	public void findDepartmentAuthByParams() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Department department = new Department();
		department.setId(11L);
		List<Department> departmentlist = departmentService.findDepartmentAuthByParams(department);
		assertNotNull(departmentlist);
		for (int i = 0; i < departmentlist.size(); i++) {
			System.out.println(">>>departmentlist is : " + departmentlist.get(i).getName());
		}
	}

	/*
	 * 分页获取分店列表
	 */
	@Test
	public void findDepartmentPageByParams() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Department department = new Department();
		// department.setId(11L);
		PageList<Department> departmentlist = departmentService.findDepartmentPageByParams(1, 3, department);
		assertNotNull(departmentlist);
		for (int i = 0; i < 1; i++) {
			System.out.println(">>>findDepartmentPageByParams is : " + departmentlist.get(i).getName());
		}
	}

	/*
	 * 分页获取分店及关系列表
	 */
	@Test
	public void findDepartmentAuthPageByParams() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Department department = new Department();
		department.setId(11L);
		PageList<Department> departmentlist = departmentService.findDepartmentAuthPageByParams(0, 1, department);
		assertNotNull(departmentlist);
		for (int i = 0; i < 1; i++) {
			System.out.println(">>>findDepartmentAuthPageByParams is : " + departmentlist.get(i).getName());
		}
	}

	/*
	 * 获取部门用户
	 */
	@Test
	public void getDepartmentCustomerList() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Department department = new Department();
		department.setId(11L);
		List<Department> departmentlist = departmentService.findDepartmentByParams(department);
		List<Department> list = new ArrayList<Department>();
		list = departmentService.getDepartmentCustomerList(departmentlist);
		assertNotNull(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(">>>Customer is : " + list.get(i).getClist().get(i).getName());
		}
	}

	/*
	 * 获取部门角色
	 */
	@Test
	public void getDepartmentCRList() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Department department = new Department();
		department.setId(54L);
		List<Department> departmentlist = departmentService.findDepartmentByParams(department);
		List<Department> list = new ArrayList<Department>();
		list = departmentService.getDepartmentCRList(departmentlist);
		assertNotNull(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(">>>role is : " + list.get(i).getDcrList().get(i).getRoleId());
		}
	}

	/*
	 * 获取部门角色
	 */
	@Test
	public void getDepartmentAuthList() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Department department = new Department();
		department.setId(54L);
		List<Department> departmentlist = departmentService.findDepartmentByParams(department);
		List<Department> list = new ArrayList<Department>();
		list = departmentService.getDepartmentAuthList(departmentlist);
		assertNotNull(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(">>>role is : " + list.get(i).getDcrList().get(i).getRoleId());
		}
	}

	/*
	 * 获取部门及上级部门
	 */
	@Test
	public void getParDepartment() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Department department = new Department();
		department.setId(11L);
		List<Department> departmentlist = departmentService.findDepartmentByParams(department);
		assertNotNull(departmentlist);
		List<Department> list = new ArrayList<Department>();
		// list = departmentService.getParDepartment(departmentlist);
		if (null == departmentService.getParDepartment(departmentlist)) {
			System.out.println(" >>>Sorry not parDepartment");
		} else {
			list = departmentService.getParDepartment(departmentlist);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(">>>Pardepartment is : " + list.get(i).getParDept().getId());
			}
		}
	}

	/*
	 * 获取部门及下级部门
	 */
	@Test
	public void getSubDepartment() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Department department = new Department();
		department.setId(11L);
		List<Department> departmentlist = departmentService.findDepartmentByParams(department);
		List<Department> list = new ArrayList<Department>();
		list = departmentService.getSubDepartmentList(departmentlist);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(">>>Pardepartment is : " + list.get(i).getSubDept().get(i).getId());
		}
	}

	/*
	 * 逻辑删除部门
	 */
	@Test
	public void deleteDepartment() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Integer num = departmentService.deleteDepartment(73L);
		System.out.println(">>deleteDepartment num is : " + num);
	}

	/*
	 * 物理删除部门
	 */
	@Test
	public void deletePhysicalDepartment() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		Integer num = departmentService.deletePhysicalDepartment(74L);
		System.out.println(">>deleteDepartment num is : " + num);

	}

	@Test
	public void addDepartmentToRole() throws Exception {
		Department de = new Department();
		//de.setId(2215520224935946L);
		de.setName("[INFO] Downloading 11111111111111");


		Role role1 = new Role();
		role1.setId(793755202565206000L);
		//role1.setName("role1");

		Role role2 = new Role();
		role2.setName("role2");

		List<Role> roleList = new ArrayList<Role>();
		roleList.add(role1);
		roleList.add(role2);
		de.setList(roleList);

		Long num = departmentService.addDepartmentToRole(de);
		System.out.println(">>deleteDepartment num is : " + num);
	}

	@Test
	public void saveDepartmentRelation() throws Exception {
		DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

		Department de = new Department();
		// de.setId(2L);
		de.setName("表和字段的编码尽量继承数");

		Role role1 = new Role();
		role1.setName("表和字段的编码尽量继承数.111");

		Role role2 = new Role();
		role2.setName("表和字段的编码尽量继承数.222");

		List<Role> roleList = new ArrayList<Role>();
		roleList.add(role1);
		roleList.add(role2);
		de.setList(roleList);

		departmentService.saveDepartmentRelation(de);
	}

	@Test
	public void addDepartmentToRole2() throws Exception {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}

		List<Department> departList = new ArrayList<Department>(2);

		{
			Department de = new Department();
			// de.setId(2L);
			de.setName("GMT+08:00] Dubbo");

			Role role1 = new Role();
			role1.setName("INFO zookeeper.111");

			Role role2 = new Role();
			role2.setName("INFO zookeeper.222");

			List<Role> roleList = new ArrayList<Role>();
			roleList.add(role1);
			roleList.add(role2);
			de.setList(roleList);

			departList.add(de);
		}

		{
			Department de = new Department();
			// de.setId(2L);
			de.setName("tment num");

			Role role1 = new Role();
			role1.setName("INFO zookeeper.333");

			Role role2 = new Role();
			role2.setName("INFO zookeeper.444");

			List<Role> roleList = new ArrayList<Role>();
			roleList.add(role1);
			roleList.add(role2);
			de.setList(roleList);

			departList.add(de);
		}

		Integer num = departmentService.addDepartmentToRole(departList);
		System.out.println(">>deleteDepartment num is : " + num);
	}
}
