package com.pzj.customer.service;

import static com.pzj.customer.entity.CustomerBuilder.ACustomerBuilder;
import static com.pzj.customer.entity.CustomerRelationBuilder.ACustomerRelationBuilder;
import static com.pzj.department.entity.DepartmentBuilder.ADepartmentBuilder;

import java.lang.reflect.Modifier;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pzj.cache.UserCacheService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.ServiceException;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.GlobalParam.ExceptionCode;
import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.global.UserGlobalParam.UserMapKeyParam;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.*;
import com.pzj.base.entity.query.User;
import com.pzj.base.service.sys.IOfficeService;
import com.pzj.base.service.sys.IRoleService;
import com.pzj.base.service.sys.IUserService;
import com.pzj.base.service.sys.cache.UserRedisService;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.customer.entity.Customer;
import com.pzj.customer.entity.CustomerBuilder;
import com.pzj.customer.entity.CustomerRelation;
import com.pzj.department.entity.Department;
import com.pzj.department.entity.OfficeAndRole;
import com.pzj.menu.entity.Menu;
import com.pzj.role.entity.Role;
import com.pzj.util.ServiceUtil;

/**
 * 系统用户接口实现
 * 
 * @author huxiaona
 * @email huxiaona@mftour.cn
 * @date 2015-8-27 上午11:09:38
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final CustomerBuilder customerBuilder = new CustomerBuilder();

	@Autowired
	private IUserService iuserService = null;

	@Autowired
	private IOfficeService iofficeService = null;

	@Autowired
	private IRoleService iroleService = null;

	@Autowired
	private UserRedisService userRedisService = null;

	@Autowired
	private CustomerUtil customerUtil = null;

	@Autowired
	private UserCacheService cacheService = null;

	/**
	 * <h3>创建用户</h3>
	 * <p>
	 * 只是处理新用户
	 * 
	 * @param customer
	 *            用户实体
	 * @return 用户的Id
	 * 
	 */
	@Override
	public Long createCustomer(Customer customer) throws Exception {

		/*
		 * 处理内容主要分为5步： 1. 将Customer转换为SysUser； 2. 将LabelVO转换为SysLabel； 3.
		 * 将Department转换为SysOffice； 4. 将Role转换为SysRole； 5. 将Menu转换为SysMenu； 6.
		 * 将转换后的数据传递给远程方法，保存到数据库中。
		 */
		final String mark = "customer";
		if (customer == null)
			return null;

		try {
			SysUser result = saveCustomerAll(customer, mark);

			if (null == result)
				return null;

			Long userId = result.getId();
			customer.setId(userId);

			return userId;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 创建财务用户(只是处理新用户的基本信息，不做关联)
	 * 
	 * @param customer
	 *            用户实体
	 * @return 用户的Id
	 * 
	 */
	@Override
	public Long createCustomerForFinancial(Customer customer) throws Exception {
		final String mark = "financial";
		// 验证用户是否为空
		if (customer == null)
			return null;
		try {
			// 将API端数据转换成底层的数据，并传递给远程方法，保存到数据库中。
			SysUser sysUserDB = saveCustomerAll(customer, mark);
			if (null == sysUserDB)
				return null;
			customer.setId(sysUserDB.getId());
			return sysUserDB.getId();
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 编辑保存用户
	 * 
	 * @param customer
	 *            用户实体
	 */
	@Override
	public Integer saveCustomer(Customer customer) throws Exception {
		try {

			if (customer == null || customer.getId() == null) {
				return 0;
			}

			// 转化
			SysUser user = Customer.changeTSysUser(customer);
			user.setLoginPasswd(null);

			SysUser result = iuserService.saveUser(user);

			if (null != result) {
				updateCustomerCache(customer, result);
				return 1;
			}

			return 0;

		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	

	/**
	 * 修改密码
	 * 
	 * @param customer
	 */
	@Override
	public int saveCustomerPassword(Customer customer) throws Exception {
		final int times = 1;
		return savePassword(customer, times);
	}

	/**
	 * 修改财务用户的密码（用户需持有id）
	 * 
	 * @param customer
	 * 
	 */
	@Override
	public int saveCustomerPasswordForFinancial(Customer customer)
			throws Exception {
		final int times = 2;
		return savePassword(customer, times);
	}

	public int savePassword(Customer customer, int times) throws Exception {
		Long id = null;
		if (customer == null) {
			return 0;
		}
		id = customer.getId();
		if (id == null || id < 1) {
			return 0;
		}
		String loginName = customer.getLoginName();
		String loginPasswd = customer.getLoginPasswd();
		SysUser result = null;
		SysUser user = Customer.createNewSysUser(customer, true);
		if (StringUtils.isNotBlank(loginName)
				&& StringUtils.isNotBlank(loginPasswd)) {
			// 生成密码
			String genPassword;
			if (1 == times) {
				genPassword = PasswordGenerateUtil.generatePassword(id,
						loginName, loginPasswd);
			} else {
				genPassword = PasswordGenerateUtil.generatePasswordTwice(id,
						loginName, loginPasswd);
			}
			user.setLoginPasswd(genPassword);
		}
		result = iuserService.saveUser(user);
		if (null != result) {
			updateCustomerCache(customer, result);
			return 1;
		}
		return 0;
	}

	/**
	 * 更新用户部门
	 * 
	 * @param customer
	 *            用户实体
	 * @return 更新条数
	 * @throws Exception
	 */
	@Override
	public Integer saveCustomerDepartment(Customer customer) throws Exception {
		try {
			Long num = 0L;
			if (customer != null && customer.getId() != null) {

				SysUser user = Customer.changeTSysUser(customer);

				List<SysOffice> sysOffices = extractSysOfficeList(customer);

				num = iuserService.saveUserAndOffice(user, sysOffices, true);

				if (num > 0) {
					updateCustomerCache(customer);
				}
			}
			return Integer.valueOf(num.toString());
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 更新用户角色
	 * 
	 * @param customer
	 *            用户实体
	 * @return 更新条数
	 * @throws Exception
	 */
	@Override
	public Integer saveCustomerRole(Customer customer) throws Exception {
		try {
			Long num = 0L;
			if (customer != null && customer.getId() != null) {

				SysUser user = Customer.changeTSysUser(customer);

				List<SysRole> sysRoles = extractSysRoleList(customer);

				num = iuserService.saveUserAndRole(user, sysRoles, true);

				if (num > 0) {
					updateCustomerCache(customer);
				}
			}
			return Integer.valueOf(num.toString());
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 更新用户菜单
	 * 
	 * @param customer
	 *            用户实体
	 * @return 更新条数
	 * @throws Exception
	 * 
	 */
	@Override
	public Integer saveCustomerMenu(Customer customer) throws Exception {
		try {
			Long num = 0L;
			if (customer != null && customer.getId() != null) {

				SysUser user = Customer.changeTSysUser(customer);

				List<SysMenu> sysMenus = extractSysMenuList(customer);

				num = iuserService.saveUserAndMenu(user, sysMenus, true);

				if (num > 0) {
					updateCustomerCache(customer);
				}
			}

			return Integer.valueOf(num.toString());
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 更新用户部门角色关联关系
	 * 
	 * @param customer
	 *            用户实体
	 * @return 更新条数
	 * @throws Exception
	 */
	@Override
	public Integer saveCustomerDR(Customer customer) throws Exception {
		try {
			Long num = 0L;
			if (customer == null) {
				return 0;
			}
			SysUser user = Customer.changeTSysUser(customer);
			List<Department> departmentList = customer.getDepartmentList();

			List<SysOffice> officeList = null;
			Map<String, List<SysRole>> roleMap = null;

			if (departmentList != null && !departmentList.isEmpty()) {
				officeList = new ArrayList<SysOffice>();
				roleMap = new HashMap<String, List<SysRole>>();
				for (Department department : departmentList) {
					Long departmentId = department.getId();
					if (departmentId != null && departmentId > 0) {
						officeList
								.add(Department.changeTDepartment(department));
						List<Role> roles = department.getList();
						List<SysRole> sysRoles = null;
						if (roles != null && !roles.isEmpty()) {
							sysRoles = Role.cList2SList(roles);
							roleMap.put(String.valueOf(departmentId), sysRoles);
						}
					}

				}
				num = iuserService.updateUserOR(user, officeList, roleMap);

				if (num > 0) {
					updateCustomerCache(customer);
				}
			}

			return Integer.valueOf(num.toString());
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public Integer saveCustomerChannel(Customer customer) throws Exception {
		try {
			if (customer == null) {
				return 0;
			}

			SysUser user = Customer.changeTSysUser(customer);

			List<SysChannel> syschannelList = extractSysChanelList(customer);

			Long num = iuserService.saveUserAndChannel(user, syschannelList,
					true, true);

			if (num > 0) {
				updateCustomerCache(customer);
			}

			return Integer.valueOf(num.toString());
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public Integer updateCustomerChannelWithSupplier(Customer customer)
			throws Exception {
		return null;
	}

	@Override
	@Deprecated
	public boolean compilePasswordMd5(String password, String md5Password) {
		return false;
	}

	@Override
	public boolean compilePasswordMd5(Long userId, String loginName,
			String password, String md5Password) {
		if (userId == null || StringUtils.isBlank(loginName)
				|| StringUtils.isBlank(password)
				|| StringUtils.isBlank(md5Password)) {
			return false;
		}
		try {
			String newMd5Password = PasswordGenerateUtil.generatePassword(
					userId, loginName, password);
			return md5Password.equals(newMd5Password);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 根据主键id获取角色信息
	 * 
	 * @param userId
	 *            用户主键id
	 * @return customer 用户实体
	 */
	@Override
	public Customer getCustomerById(Long userId) throws Exception {
		try {
			if (userId == null || userId < 1)
				return null;

			SysUser findUser = iuserService.getById(userId);

			if (findUser != null) {
				Customer customer = customerBuilder.buildSource(findUser);
				return customer;
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public List<Customer> getCustomerListByIds(List<Long> ids) throws Exception {
		try {
			if (ids == null || ids.isEmpty())
				return null;

			List<Customer> customer = customerUtil.getUserListByIdList(ids);

			return customer;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 查询用户列表，支持多参数
	 * 
	 * @param customer
	 *            用户实体
	 * @return 分页对象
	 */
	@Override
	public List<Customer> findCustomerByParams(Customer customer)
			throws Exception {
		return findCustomerByParams(customer, true);
	}

	@Override
	public List<Customer> findCustomerByParams(Customer customer,
			boolean needLike) throws Exception {
		try {
			List<SysUser> users = null;
			List<Customer> customers = null;

			// 验证
			SysUser user = null;
			if (customer != null) {
				user = findByUserOfficeRoleOfUser(customer, needLike);
			}

			users = iuserService.findListByParams(user);

			// 转换
			if (users != null && (!users.isEmpty())) {
				customers = Customer.sList2CList(users);
			}
			return customers;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 分页查询用户列表，支持多参数
	 * 
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            每页显示记录数
	 * @param customer
	 *            用户实体
	 * @return 分页对象
	 */

	@Override
	public PageList<Customer> findCustomerPageByParams(Integer pageNo,
			Integer pageSize, Customer customer) throws Exception {
		PageModel pm = new PageModel(pageNo, pageSize);
		return findCustomerPageByParams(pm, customer);
	}

	@Override
	public PageList<Customer> findCustomerPageByParams(PageModel pm,
			Customer customer) throws Exception {
		try {
			PageList<SysUser> pageList = null;

			// 验证
			SysUser user = null;
			if (customer != null) {
				user = findByUserOfficeRoleOfUser(customer, true);
			}
			// 查询
			checkQeueryParams(user);
			pageList = iuserService.queryPageByParamMap(pm, user);

			// 转换
			List<Customer> customers = null;
			if (pageList != null && (!pageList.isEmpty())) {
				List<SysUser> users = pageList.getResultList();
				customers = Customer.sList2CList(users);
			}
			PageList<Customer> result = new PageList<Customer>();
			result.setResultList(customers);
			result.setPageBean(pageList.getPageBean());
			return result;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 查询用户列表，用户的部门列表，用户的角色列表，用户的菜单列表，用户部门角色关联关系列表，支持多参数
	 * 
	 * @param customer
	 *            用户实体
	 * @param customer
	 *            用户状态（1：正常，0：禁用）
	 * @return 分页对象
	 */
	@Override
	public List<Customer> findCustomerAuthByParams(Customer customer)
			throws Exception {
		try {
			List<SysUser> users = null;
			List<Customer> customers = null;

			// 验证
			SysUser user = null;
			if (customer != null) {
				user = findByUserOfficeRoleOfUser(customer, true);
			}
			// 查询
			checkQeueryParams(user);
			users = iuserService.findListByParams(user);

			// 转换
			if (users != null && (!users.isEmpty())) {
				customers = Customer.sList2CList(users);

				// 给用户封装角色，部门，菜单
				customerUtil.setCustomerAuthorityList(customers);
			}

			return customers;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 分页查询用户列表，用户的部门列表，用户的角色列表，用户的菜单列表，用户部门角色关联关系列表，支持多参数
	 * 
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            每页显示记录数
	 * @param customer
	 *            用户实体
	 * @return 分页对象
	 */
	@Override
	public PageList<Customer> findCustomerAuthPageByParams(Integer pageNo,
			Integer pageSize, Customer customer) throws Exception {
		try {
			PageList<SysUser> pageList = null;

			// 验证
			SysUser user = null;
			if (customer != null) {
				user = findByUserOfficeRoleOfUser(customer, true);
			}
			// 查询
			checkQeueryParams(user);
			PageModel pm = new PageModel(pageNo, pageSize);
			pageList = iuserService.queryPageByParamMap(pm, user);

			// 转换
			List<Customer> customers = null;
			if (pageList != null && (!pageList.isEmpty())) {
				List<SysUser> users = pageList.getResultList();
				customers = Customer.sList2CList(users);

				// 给用户封装角色，部门，菜单
				customerUtil.setCustomerAuthorityList(customers);
			}
			PageList<Customer> result = new PageList<Customer>();
			result.setResultList(customers);
			result.setPageBean(pageList.getPageBean());
			return result;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public List<Customer> findCustomerAllInfoByParams(Customer customerParam)
			throws Exception {
		try {
			if (null == customerParam)
				return null;

			SysUser userParam = Customer.changeTSysUser(customerParam);

			// 验证
			checkQeueryParams(userParam);

			// 返回结果
			List<Customer> customersResult = null;

			// 查询用户
			List<SysUser> sysUserResult = iuserService
					.findCustomerAllInfoByParams(userParam);

			if (null != sysUserResult && !sysUserResult.isEmpty()) {
				// 转换
				customersResult = ACustomerBuilder
						.buildSourceAll(sysUserResult);

				// 用户封装部门列表
				customerUtil.setCustomerOfficeList(customersResult);

				// 用户封装用户部门角色关系列表
				customerUtil.setCustomerDCRList(customersResult);

				// 用户封装渠道列表
				customerUtil.setCustomerChannelList(customersResult);
			}

			return customersResult;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public List<Customer> findCustomerDRByCustomer(Customer customer)
			throws Exception {

		SysUser sysUserParam = Customer.changeTSysUser(customer);

		List<SysUser> sysUserList = iuserService.findListByParams(sysUserParam);

		List<Customer> customerList = ACustomerBuilder.buildSource(sysUserList);

		customerUtil.setCustomerDepartmentRole(customerList,
				customer.getCommonFlag01());

		// 封装用户关联的售票点ID集合
		customerUtil.setCustomerTicketList(customerList);

		return customerList;
	}

	/**
	 * 给用户封装对应部门列表
	 * 
	 * @param customers
	 *            用户列表
	 * 
	 */
	@Override
	public List<Customer> getCustomerDepartmentList(List<Customer> customers)
			throws Exception {
		try {
			if (customers == null || customers.isEmpty()) {
				return null;
			}

			// 查询用户
			String ids = customerUtil.getUserIds(customers);
			customers = customerUtil.getUserListByUserIds(ids);
			if (customers != null && !customers.isEmpty()) {
				customerUtil.setCustomerOfficeList(customers);

			}
			return customers;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 给用户封装对应角色列表
	 * 
	 * @param customers
	 *            用户列表
	 */
	@Override
	public List<Customer> getCustomerRoleList(List<Customer> customers)
			throws Exception {

		Customer customer = new Customer();
		customer.setAccountState(1);
		try {
			if (customers == null || customers.isEmpty()) {
				return null;
			}

			// 查询用户
			String ids = customerUtil.getUserIds(customers);
			customers = customerUtil.getUserListByUserIds(ids);
			if (customers != null && !customers.isEmpty()) {
				customerUtil.setCustomerRoleList(customers);

			}
			return customers;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public List<Customer> getCustomerRoleList(List<Customer> customers,
			Customer customersParam) throws Exception {
		try {
			if (customers == null || customers.isEmpty()) {
				return null;
			}

			String delFlag = null;
			if (null != customersParam)
				if (null != customersParam.getAccountState())
					delFlag = customersParam.getAccountState().toString();

			// 查询用户
			String ids = customerUtil.getUserIds(customers);
			customers = customerUtil.getUserListByUserIds(ids, delFlag);
			if (customers != null && !customers.isEmpty()) {
				customerUtil.setCustomerRoleList(customers);

			}
			return customers;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 给用户封装对应菜单列表
	 * 
	 * @param customers
	 *            用户列表
	 */
	@Override
	public List<Customer> getCustomerMenuList(List<Customer> customers)
			throws Exception {
		try {
			if (customers == null || customers.isEmpty()) {
				return null;
			}

			// 查询用户
			String ids = customerUtil.getUserIds(customers);
			customers = customerUtil.getUserListByUserIds(ids);
			if (customers != null && !customers.isEmpty()) {
				customerUtil.setCustomerMenuList(customers);

			}
			return customers;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 给用户封装对应用户部门角色关系列表
	 * 
	 * @param customers
	 *            用户列表
	 */
	@Override
	public List<Customer> getCustomerDRList(List<Customer> customers)
			throws Exception {
		try {
			if (customers == null || customers.isEmpty()) {
				return null;
			}

			// 查询用户
			String ids = customerUtil.getUserIds(customers);
			customers = customerUtil.getUserListByUserIds(ids);
			if (customers != null && !customers.isEmpty()) {
				customerUtil.setCustomerDCRList(customers);

			}
			return customers;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 给用户封装对应渠道列表
	 * 
	 * @param customers
	 *            用户列表
	 */
	@Override
	public List<Customer> getCustomerChannelList(List<Customer> customers)
			throws Exception {
		try {
			if (customers == null || customers.isEmpty()) {
				return null;
			}

			// 查询用户
			String ids = customerUtil.getUserIds(customers);
			customers = customerUtil.getUserListByUserIds(ids);
			if (customers != null && !customers.isEmpty()) {
				customerUtil.setCustomerChannelList(customers);

			}
			return customers;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 给用户封装对应部门，角色，菜单，用户部门角色关系，渠道列表
	 * 
	 * @param customers
	 *            用户列表
	 */
	@Override
	public List<Customer> getCustomerAuthList(List<Customer> customers)
			throws Exception {
		try {
			if (customers == null || customers.isEmpty()) {
				return null;
			}

			// 查询用户
			String ids = customerUtil.getUserIds(customers);
			customers = customerUtil.getUserListByUserIds(ids);
			if (customers != null && !customers.isEmpty()) {
				customerUtil.setCustomerAuthorityList(customers);

			}
			return customers;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 用户登录
	 * 
	 */
	@Override
	public Customer login(String loginName, String password) throws Exception {
		// 用于区分加密方法时使用，非空非空格
		final String mark = null;
		try {
			verifyLogin(loginName, password);

			List<SysUser> users = findLoginUser(loginName, null);
			Customer customer = doLogin(password, users, mark);

			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			throw e;
		}
	}

	public Customer loginForWechat(String opendid){
		Customer customer = null;
		try {
			SysUser userParam = new SysUser();
			userParam.setWxOpenid(opendid);
			List<SysUser> users = iuserService.findListByParams(userParam);
			if (users != null && users.size() == 1){
				customer = Customer.sysUser2Customer(users.get(0));
				List<Customer> customers = new ArrayList<>(0);
				customers.add(customer);
				customerUtil.setCustomerAuthorityList(customers);

				// 用户设置Token
				setCustomerToken(customer, TokenGenerater.OPENID);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return customer;
	}

	/**
	 * 财务用户登录
	 * 
	 * @param loginName
	 *            用户登录名称
	 * @param password
	 *            用户登录密码
	 */
	@Override
	public Customer loginForFinancial(String loginName, String password)
			throws Exception {
		// 用于区分加密方法时使用
		final String mark = "financial";
		try {
			verifyLogin(loginName, password);
			List<SysUser> users = findLoginUser(loginName, null);
			Customer customer = doLogin(password, users, mark);
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public Customer login(String loginName, String password, String dataSource)
			throws Exception {
		try {
			verifyLogin(loginName, password);

			List<SysUser> users = findLoginUser(loginName, dataSource);
			Customer customer = doLogin(password, users, StringUtils.EMPTY);

			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			throw e;
		}
	}

	public Customer login(String loginName, String password, String dataSource,
			String verifyMode) throws Exception {
		try {
			verifyLogin(loginName, password);

			// 查询用户
			Customer customer = null;
			List<SysUser> users = findLoginUser(loginName, dataSource);
			customer = doLogin(password, users, verifyMode);

			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			throw e;
		}
	}

	private void verifyLogin(String loginName, String password)
			throws ServiceException {
		if (StringUtils.isBlank(loginName)) {
			ServiceUtil.throwServiceException(ExceptionCode.UserNameIsNull,
					"用户名不能为null");
		}
		if (StringUtils.isBlank(password)) {
			ServiceUtil.throwServiceException(
					ExceptionCode.UserLoginPasswdIsNull, "密码不能为null");
		}
	}

	/**
	 * 
	 * @param loginName
	 * @param dataSource
	 * @return
	 */
	private List<SysUser> findLoginUser(String loginName, String dataSource) {
		// 查询用户
		SysUser user = new SysUser();
		user.setLoginName(loginName);
		if (StringUtils.isNotBlank(dataSource)) {
			user.setUserSource(dataSource);
		}
		List<SysUser> users = iuserService.findCustomerAllInfoByParams(user);
		return users;
	}

	/**
	 * 登录操作，验证密码、设置缓存、返回用户对象
	 * 
	 * @param password
	 * @param users
	 * @return
	 * @throws Exception
	 */
	private Customer doLogin(String password, List<SysUser> users,
			String verifyMode) throws Exception {
		SysUser user = null;
		Customer customer = null;
		if (users != null && !users.isEmpty()) {
			user = users.get(0);
			// 判断密码是否一致
			String newGenPassword = null;
			if (StringUtils.isNotBlank(verifyMode)) {
				newGenPassword = PasswordGenerateUtil.generatePasswordTwice(
						user.getId(), user.getLoginName(), password);
			} else {
				newGenPassword = PasswordGenerateUtil.generatePassword(
						user.getId(), user.getLoginName(), password);
			}

			if (!newGenPassword.equals(user.getLoginPasswd())) {
				String oldGenPassword = Customer.generdatePassword(password);

				if (oldGenPassword.equals(user.getLoginPasswd())) {
					user.setLoginPasswd(newGenPassword);
					iuserService.updateByPrimaryKey(user);
				} else {
					return customer;
				}
			}

			customer = Customer.sysUser2Customer(user);
			List<Customer> customers = new ArrayList<Customer>();
			customers.add(customer);
			customerUtil.setCustomerAuthorityList(customers);

			// 用户设置Token
			setCustomerToken(customer);

			//每次登陆成功都需要更新最后登陆时间
			user.setLastLoginTime(new Date());
			iuserService.updateByPrimaryKey(user);
		}
		return customer;
	}

	@Override
	public PageList<Customer> findByUserOfficeRole(Integer start, Integer size,
			Customer customer) throws Exception {
		try {
			SysUser sysUser = null;
			List<Long> officeIds = null;
			List<Long> roleIds = null;
			if (customer != null) {
				sysUser = findByUserOfficeRoleOfUser(customer, true);
				try {
					// 文档早期时，岗位id保存在commonFlag01上，部门id要保存在commonFlag02上。
					if (StringUtils.isNotBlank(customer.getCommonFlag02())) {
						officeIds = new ArrayList<>(1);
						officeIds.add(Long.valueOf(customer.getCommonFlag02()));
					}
					if (StringUtils.isNotBlank(customer.getCommonFlag01())) {
						roleIds = new ArrayList<>(1);
						roleIds.add(Long.valueOf(customer.getCommonFlag01()));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// 查询
			PageModel pm = new PageModel(start, size);
			PageList<SysUser> sysUserList = iuserService.findByUserOfficeRole(
					pm, sysUser, officeIds, roleIds);

			PageList<Customer> result = new PageList<Customer>();
			result.setPageBean(sysUserList.getPageBean());

			if (sysUserList == null || sysUserList.isEmpty()) {
				result.setResultList(new ArrayList<Customer>());
				return result;
			}

			// 转化
			List<Customer> roleList = Customer.sList2CList(sysUserList
					.getResultList());

			result.setResultList(roleList);
			return result;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public PageList<Customer> findByUserOfficeRole2(Integer start,
			Integer size, Customer customer) throws Exception {
		try {
			SysUser sysUser = null;
			List<Long> officeIds = null;
			List<Long> roleIds = null;
			if (customer != null) {
				sysUser = findByUserOfficeRoleOfUser(customer, true);
				// 通过customer.getCommonFlag01的名称查询部门
				officeIds = findByUserOfficeRoleOfOfficeIds(customer);
				// 通过customer.getCommonFlag02的名称查询角色
				roleIds = findByUserOfficeRoleOfRoleIds(customer);
			}

			// 查询
			PageModel pm = new PageModel(start, size);
			PageList<SysUser> sysUserList = iuserService.findByUserOfficeRole(
					pm, sysUser, officeIds, roleIds);

			PageList<Customer> result = new PageList<Customer>();
			result.setPageBean(sysUserList.getPageBean());

			if (sysUserList == null || sysUserList.isEmpty()) {
				result.setResultList(new ArrayList<Customer>());
				return result;
			}

			// 转化
			List<Customer> roleList = Customer.sList2CList(sysUserList
					.getResultList());

			result.setResultList(roleList);
			return result;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	private SysUser findByUserOfficeRoleOfUser(Customer customer,
			boolean needLike) throws Exception {
		SysUser sysUser = Customer.changeTSysUser(customer);

		if (null != sysUser && needLike) {
			buildParam(sysUser);
		}

		return sysUser;
	}

	public void buildParam(SysUser sysUser) {
		if (StringUtils.isNotBlank(sysUser.getLoginName())) {
			sysUser.setLoginName(sysUser.getLoginName() + "%");
		}
		if (StringUtils.isNotBlank(sysUser.getName())) {
			sysUser.setName(sysUser.getName() + "%");
		}
		if (StringUtils.isNotBlank(sysUser.getOperChargerMobile())) {
			sysUser.setOperChargerMobile(sysUser.getOperChargerMobile() + "%");
		}
		if (StringUtils.isNotBlank(sysUser.getOperChargerPhone())) {
			sysUser.setOperChargerPhone(sysUser.getOperChargerPhone() + "%");
		}
		if (StringUtils.isNotBlank(sysUser.getCheckUserName())) {
			sysUser.setCheckUserName(sysUser.getCheckUserName() + "%");
		}
		if (StringUtils.isNotBlank(sysUser.getCheckUserName())) {
			sysUser.setCheckUserName(sysUser.getCheckUserName() + "%");
		}
		if (StringUtils.isNotBlank(sysUser.getCorporaterCredentials())) {
			sysUser.setCorporaterCredentials(sysUser.getCorporaterCredentials()
					+ "%");
		}
	}

	public void buildParam2(SysUser sysUser) {
		if (StringUtils.isNotBlank(sysUser.getCorporater())) {
			sysUser.setCorporater(sysUser.getCorporater() + "%");
		}
		if (StringUtils.isNotBlank(sysUser.getCorporaterMobile())) {
			sysUser.setCorporaterMobile(sysUser.getCorporaterMobile() + "%");
		}
		if (StringUtils.isNotBlank(sysUser.getCorporaterCredentials())) {
			sysUser.setCorporaterCredentials(sysUser.getCorporaterCredentials()
					+ "%");
		}
		if (StringUtils.isNotBlank(sysUser.getBusinessCertificate())) {
			sysUser.setBusinessCertificate(sysUser.getBusinessCertificate()
					+ "%");
		}
	}

	private SysUser findByUserOfficeRoleOfUser2(Customer customer)
			throws Exception {
		SysUser sysUser = Customer.changeTSysUser(customer);

		if (null != sysUser && customer.isNeedLike()) {
			buildParam(sysUser);
		}

		return sysUser;
	}

	private List<Long> findByUserOfficeRoleOfRoleIds(Customer customer) {
		if (StringUtils.isBlank(customer.getCommonFlag02())) {
			return null;
		}

		SysRole sysRoleParam = new SysRole();
		List<Long> roleIds = null;
		sysRoleParam.setName(customer.getCommonFlag02() + "%");
		List<SysRole> sysRoleResult = iroleService
				.findListByParams(sysRoleParam);
		if (null != sysRoleResult && !sysRoleResult.isEmpty()) {
			roleIds = new ArrayList<>(sysRoleResult.size());
			for (Iterator<SysRole> iterator = sysRoleResult.iterator(); iterator
					.hasNext();) {
				SysRole sysRole = iterator.next();
				if (null != sysRole && null != sysRole.getId()) {
					roleIds.add(sysRole.getId());
				}
			}
		} else {
			roleIds = new ArrayList<>(0);
			roleIds.add(-11L);
		}
		return roleIds;
	}

	private List<Long> findByUserOfficeRoleOfOfficeIds(Customer customer) {
		if (StringUtils.isBlank(customer.getCommonFlag01()))
			return null;
		List<Long> officeIds = null;
		SysOffice sysOfficeParam = new SysOffice();
		sysOfficeParam.setName(customer.getCommonFlag01() + "%");
		List<SysOffice> sysOfficeResult = iofficeService
				.findListByParams(sysOfficeParam);
		if (null != sysOfficeResult && !sysOfficeResult.isEmpty()) {
			officeIds = new ArrayList<>(sysOfficeResult.size());
			for (Iterator<SysOffice> iterator = sysOfficeResult.iterator(); iterator
					.hasNext();) {
				SysOffice sysOffice = iterator.next();
				if (null != sysOffice && null != sysOffice.getId()) {
					officeIds.add(sysOffice.getId());
				}
			}
		} else {
			officeIds = new ArrayList<>(1);
			officeIds.add(-11L);
		}
		return officeIds;
	}

	/**
	 * 逻辑删除用户
	 * 
	 */
	@Override
	public Integer deleteCustomer(Long userid) throws Exception {
		try {
			if (userid == null || userid < 0)
				return 0;
			SysUser user = new SysUser();
			user.setAccountState(GlobalParam.FLAG.del());
			user.setId(userid);
			int num = iuserService.updateByPrimaryKey(user);

			return num;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}

	}

	/**
	 * 物理删除用户
	 * 
	 */
	@Override
	public Integer deletePhysicalCustomer(Long userid) throws Exception {
		try {
			if (userid == null || userid < 0)
				return 0;
			int num = iuserService.delete(userid);
			return num;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public Integer saveCustomerAndAuth(Customer customer) throws Exception {
		if (customer == null)
			return 0;

		SysUser result = saveCustomerAll(customer, null);

		if (null != result) {
			updateCustomerCache(customer, result);
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 更新用户信息到缓存中
	 * 
	 * @param customer
	 * @param result
	 * @throws Exception
	 */
	private void updateCustomerCache(Customer customer, SysUser result)
			throws Exception {
		if (null != result && null != customer) {
			// 获取当前的token值。
			String oldtoken = customer.getToken();

			if (null == oldtoken) {
				return;
			}

			// 将最新的SysUser转换成Customer类型
			Customer newcustomer = Customer.sysUser2Customer(result);

			List<Customer> customersList = new ArrayList<>(1);
			customersList.add(newcustomer);
			customerUtil.setCustomerAuthorityList(customersList);

			// 计算最新的token值（当用户修改了密码时将会token值会变为新的值）
			String newtoken = customerUtil.genTokenKey(newcustomer);// 生成token

			// 将token保存到新的customer上
			newcustomer.setToken(newtoken);

			// 将新用户对象序列化成JSON字符串
			String jsonStirng = JSON.toJSONString(newcustomer);
			if (newtoken.equals(oldtoken)) {
				// 通过token存入用户信息到缓存
				userRedisService.put(UserMapKeyParam.USER_KEY + oldtoken,
						jsonStirng, 0L);
			} else {
				// 将新token保存到旧的customer上
				customer.setToken(newtoken);
				// 从缓存中删除旧token的值
				userRedisService.delKey(UserMapKeyParam.USER_KEY + oldtoken);
				// 将新token和数据保存到缓存中
				userRedisService.put(UserMapKeyParam.USER_KEY + newtoken,
						jsonStirng, 0L);
			}

		}
	}

	private void updateCustomerCache(Customer customer) throws Exception {
		SysUser sysUser = iuserService.getById(customer.getId());
		updateCustomerCache(customer, sysUser);
	}

	@Override
	public Integer updateBatchCustomerPrimaryKey(List<Long> ids,
			int accountState) {
		Integer num = 0;
		try {
			if (ids == null || ids.isEmpty()) {
				logger.error("接口方法[CustomerService.updateBatchCustomerPrimaryKey],参数ids不能为空");
				return num;
			}
			List<SysUser> list = new ArrayList<SysUser>();
			for (Long id : ids) {
				if (id == null || id < 1) {
					continue;
				}
				SysUser bean = new SysUser();
				bean.setId(id);
				bean.setAccountState(accountState);
				list.add(bean);
			}
			num = iuserService.updateBatchByPrimaryKey(list);

		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}

		return num;
	}

	private enum TokenGenerater {

		GENERAL {
			@Override
			String genTokenKey(CustomerUtil customerUtil ,Customer customer) {
				return customerUtil.genTokenKey(customer);
			}
		},

		OPENID {
			@Override
			String genTokenKey(CustomerUtil customerUtil, Customer customer) {
				return customerUtil.genTokenKeyFromOpenid(customer);
			}
		}

		;


		abstract String genTokenKey(CustomerUtil customerUtil, Customer customer);
	}

	/***
	 * 生成用户Token
	 * 
	 * @throws Exception
	 */
	private void setCustomerToken(Customer customer) throws Exception {
		setCustomerToken(customer, TokenGenerater.GENERAL);
	}

	/***
	 * 生成用户Token
	 *
	 * @throws Exception
	 */
	private void setCustomerToken(Customer customer, TokenGenerater tokenGenerater) throws Exception {
		if (customer == null) {
			return;
		}
		if (StringUtils.isBlank(customer.getLoginName())) {
			return;
		}
		if (StringUtils.isBlank(customer.getLoginPasswd())) {
			return;
		}

		String token = tokenGenerater.genTokenKey(customerUtil, customer); // 生成token
		customer.setToken(token);
		String jsonStirng = JSON.toJSONString(customer);
		logger.info("jsonStirng:" + jsonStirng);

		// 通过token存入用户信息到缓存
		userRedisService.put(UserMapKeyParam.USER_KEY + token, jsonStirng, 0L);

		customer.setToken(token);

	}

	@Override
	public Long updateBatchCustomerChannel(List<Customer> customers)
			throws Exception {
		Long num = 0l;
		try {
			if (customers == null || customers.isEmpty()) {
				logger.error("接口方法[CustomerService.updateBatchCustomerChannel],参数customers不能为空");
				return num;
			}
			Map<String, List<SysChannel>> records = new HashMap<String, List<SysChannel>>();
			List<SysUser> users = new ArrayList<SysUser>();
			for (Customer customer : customers) {
				List<ChannelVo> channelList = customer.getChannelVoList();
				if (channelList == null) {
					continue;
				}
				SysUser user = Customer.changeTSysUser(customer);
				String sysCode = user.getSysCode();
				users.add(user);
				records.put(sysCode, ChannelVo.cList2SList(channelList));

			}
			num = iuserService.saveBatchUserAndChannel(users, records, true,
					false);
			return num;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}

	}

	@Override
	public Long updateBatchCustomerCommonInfo(List<Customer> customers,
			String type) throws Exception {

		Long num = 0l;
		try {
			if (customers == null || customers.isEmpty()) {
				logger.error("接口方法[CustomerService.updateBatchCustomerCommonInfo],参数customers不能为空");
				return num;
			}
			Map<String, List<SysUser>> records = new HashMap<String, List<SysUser>>();
			List<SysUser> users = new ArrayList<SysUser>();
			for (Customer customer : customers) {
				List<Customer> commonList = customer.getCommonInfoList();
				if (commonList == null) {
					continue;
				}
				SysUser user = Customer.changeTSysUser(customer);
				String sysCode = user.getSysCode();
				users.add(user);
				records.put(sysCode, Customer.cList2SList(commonList));

			}
			num = iuserService.saveBatchUserAndCommonInfo(users, records, type,
					false);
			return num;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public PageList<Customer> queryPageByChannelId(PageModel pager,
			Customer vo, Long channelId) throws Exception {

		PageList<Customer> list = new PageList<Customer>();
		try {
			if (channelId == null || channelId < 1) {
				logger.error("接口方法[CustomerService.queryPageByChannelId],参数channelId不能为空");
				return list;
			}
			SysUser sysBean = Customer.changeTSysUser(vo);
			PageList<SysUser> pageList = iuserService
					.queryPageByObjId(
							pager,
							sysBean,
							channelId,
							UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);

			List<Customer> voList = null;
			if (pageList != null && (!pageList.isEmpty())) {
				List<SysUser> records = pageList.getResultList();
				voList = Customer.sList2CList(records);
			}
			list.setResultList(voList);
			list.setPageBean(pageList.getPageBean());

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}

		return list;
	}

	/*@Override
	public PageList<Customer> findCustomerScenicPageByParams(PageModel page,
			Customer customer) throws Exception {
		try {
			PageList<SysUser> pageList = null;

			// 验证
			SysUser user = null;
			if (customer != null) {
				user = findByUserOfficeRoleOfUser(customer, true);
			}
			// 查询
			pageList = iuserService.queryPageByParamMap(page, user);

			// 转换
			List<Customer> customers = null;
			if (pageList != null && (!pageList.isEmpty())) {
				List<SysUser> users = pageList.getResultList();
				customers = Customer.sList2CList(users);

				// 封装用户关联的景区主键Id集合
				customerUtil.setCustomerScenicIdList(customers);
			}
			PageList<Customer> result = new PageList<Customer>();
			result.setResultList(customers);
			result.setPageBean(pageList.getPageBean());
			return result;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}*/

	/*@Override
	public PageList<Customer> findCustomerWDPageByParams(PageModel page,
			Customer customer) throws Exception {

		try {
			PageList<SysUser> pageList = null;

			// 验证
			SysUser user = null;
			if (customer != null) {
				user = findByUserOfficeRoleOfUser(customer, true);
			}
			// 查询
			pageList = iuserService.queryPageByParamMap(page, user);

			// 转换
			List<Customer> customers = null;
			if (pageList != null && (!pageList.isEmpty())) {
				List<SysUser> users = pageList.getResultList();
				customers = Customer.sList2CList(users);

				// 封装用户关联的微店主键Id集合
				customerUtil.setCustomerWdIdList(customers);
			}
			PageList<Customer> result = new PageList<Customer>();
			result.setResultList(customers);
			result.setPageBean(pageList.getPageBean());
			return result;
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}*/

	@Override
	public PageList<Customer> findCustomerByCRInfo(PageModel page,
			Customer customer, Role role) throws Exception {
		try {
			PageList pageList = null;

			SysUser user = null;
			if (customer != null) {
				user = findByUserOfficeRoleOfUser2(customer);
			}
			SysRole sysRole = null;
			if (role != null) {
				sysRole = Role.changeTSysRole(role);
			}

			pageList = this.iuserService.queryPageByUR(page, user, sysRole);

			List customers = null;
			if ((pageList != null) && (!(pageList.isEmpty()))) {
				List users = pageList.getResultList();
				customers = Customer.sList2CList(users);
			}
			PageList result = new PageList();
			result.setResultList(customers);
			result.setPageBean(pageList.getPageBean());
			return result;
		} catch (Exception e) {
			this.logger.error(e.toString());
			throw e;
		}
	}

	@Override
	public List<Customer> findCustomerByLoginName(String loginName,
			String datasource) throws Exception {
		List<Customer> customers = null;
		try {
			if (StringUtils.isBlank(loginName)) {
				return customers;
			}
			SysUser user = new SysUser();
			user.setLoginName(loginName);
			user.setUserSource(datasource);

			PageList pageList = iuserService.queryPageByParamMap(null, user);

			if ((pageList != null) && (!(pageList.isEmpty()))) {
				List<SysUser> users = pageList.getResultList();
				customers = Customer.sList2CList(users);
			}

			return customers;
		} catch (Exception e) {
			this.logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 根据用户信息分平台查询用户基础信息（完整查询）
	 * 
	 * @param customer
	 * @param datasource
	 *            数据所属平台系统（分库）
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Customer> findCustomerByCompleteParam(Customer customer,
			String datasource) throws Exception {
		List<Customer> customers = null;
		try {
			if (customer == null) {
				return customers;
			}
			SysUser user = Customer.changeTSysUser(customer);
			user.setLoginPasswd(null);

			PageList pageList = iuserService.queryPageByParamMap(null, user);

			if ((pageList != null) && (!(pageList.isEmpty()))) {
				List<SysUser> users = pageList.getResultList();
				customers = Customer.sList2CList(users);
			}

			return customers;
		} catch (Exception e) {
			this.logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 提取用户的Menu集合。
	 * 
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	private List<SysMenu> extractSysMenuList(Customer customer)
			throws Exception {
		// 获取用户关联的菜单
		List<Menu> menuList = customer.getMenuList();
		if (menuList != null && !menuList.isEmpty()) {
			// 转换为SysMenu类型
			return Menu.cList2SList(menuList);
		} else if (menuList != null) {
			return new ArrayList<>();
		} else {
			return null;
		}
	}

	/**
	 * 提取用户的Role集合。
	 * 
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	private List<SysRole> extractSysRoleList(Customer customer)
			throws Exception {
		// 获取用户关联的角色
		List<Role> roleList = customer.getRoleList();
		if (roleList != null && !roleList.isEmpty()) {
			// 转换为SysRole类型
			return Role.cList2SList(roleList);
		} else if (roleList != null) {
			return new ArrayList<>(0);
		} else {
			return null;
		}
	}

	/**
	 * 提取用户的部门集合。
	 * 
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	private List<SysOffice> extractSysOfficeList(Customer customer)
			throws Exception {
		// 获取用户关联的部门
		List<Department> departmentList = customer.getDepartmentList();
		if (departmentList != null && !departmentList.isEmpty()) {
			// 转换为SysOffice类型
			return Department.cList2SList(departmentList);
		} else if (departmentList != null) {
			return new ArrayList<>(0);
		} else {
			return null;
		}
	}

	/**
	 * 从Customer中提取出SysChannel集合。
	 * 
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	private List<SysChannel> extractSysChanelList(Customer customer)
			throws Exception {
		// 获取用户关联的渠道
		List<ChannelVo> channelList = customer.getChannelVoList();
		if (channelList != null && !channelList.isEmpty()) {
			// 转换为SysChannel类型
			return ChannelVo.cList2SList(channelList);
		} else if (channelList != null) {
			return new ArrayList<>(0);
		} else {
			return null;
		}
	}

	@Override
	public Long getSupplierId() {

		return GlobalParam.SUPPILER;
	}

	@Override
	public PageList<Customer> findRefCustomerByRelation(
			CustomerRelation relation, Customer customer, PageModel pageModel)
			throws Exception {
		return findRefCustomerByRelation(relation, customer, false, pageModel);
	}

	private PageList<Customer> findRefCustomerByRelation(
			CustomerRelation relation, Customer customer, boolean isFindMaster, PageModel pageModel)
			throws Exception {
		if (null == relation)
			return null;

		SysUserRelation sysRelation = ACustomerRelationBuilder
				.buildNewOrExisted(relation);

		SysUser user = null;
		if (null != customer)
			user = findByUserOfficeRoleOfUser(customer, true);

		PageList<SysUser> sysUserList = iuserService.findRefCustomerByRelation(
				sysRelation, user, isFindMaster, pageModel);

		if (null != sysUserList) {
			PageList<Customer> result = new PageList<>();
			result.setPageBean(sysUserList.getPageBean());

			List<SysUser> resultList = sysUserList.getResultList();
			if (null != resultList) {
				List<Customer> userList = Customer.sList2CList(resultList);
				result.setResultList(userList);

				customerUtil.setCustomerChannelList(userList);
			}

			return result;
		}

		return null;
	}

	@Override
	public PageList<Customer> findMasCustomerByRelation(
			CustomerRelation relation, Customer customer, PageModel pageModel)
			throws Exception {
		return findRefCustomerByRelation(relation, customer, true, pageModel);
	}

	public void checkQeueryParams(SysUser user) {
		if (null == user) {
			return;
		}

		if (!StringUtils.isEmpty(user.getName())) {
			user.setName(user.getName() + '%');
		}
	}

	/**
	 * 判断用户Token是否有效
	 */
	@Override
	@Deprecated
	public boolean isTokenValid(String token) throws Exception {
		return customerUtil.isTokenValid(token);
	}

	/**
	 * 查询一个用户所属的主帐户
	 * <p/>
	 * 如果参数中传递了supplierId，则以这个supplier查询主帐户，如果没有则根据id查询出用户，
	 * 如果这个用户不是主帐户，就根据这个用户的supplieId查询出主帐户，最后查询出主帐户的角色。
	 * <p/>
	 * 只需要传递supplierId或id即可。
	 * 
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	public Customer getSupplierCustomerBySub(Customer customer)
			throws Exception {
		if (null == customer)
			return null;

		Long supplierId = customer.getSupplierId();
		Long id = customer.getId();
		SysUser user = null;
		if (null == supplierId) {
			if (null == id)
				return null;

			user = iuserService.getById(id);
			if (null == user || null == (supplierId = user.getSupplierId()))
				return null;
			id = user.getId();
		}

		if (null == user || !supplierId.equals(id))
			user = iuserService.getById(supplierId);

		if (null == user)
			return null;
		Customer result = Customer.sysUser2Customer(user);

		customerUtil.setCustomerRoleList(result);

		return result;
	}

	@Override
	public PageList<Customer> findCustomerExclusiveMasterCustomer(
			Customer master, Customer customer, PageModel page)
			throws Exception {
		if (customer == null || master == null)
			return null;

		User masterParam = new User();
		Customer.changeTSysUser(master, masterParam);
		masterParam.setInclusiveRelationUser(master.getInclusiveRelationUser());
		masterParam.setWhereIsAnd(master.getWhereIsAnd());

		SysUser customerParam = Customer.changeTSysUser(customer);

		PageList<SysUser> userList = iuserService
				.findUserExclusiveUserRelation(masterParam, customerParam, page);

		PageList<Customer> result = convertToCustomerPageList(userList);

		return result;
	}

	private PageList<Customer> convertToCustomerPageList(
			PageList<SysUser> userList) {
		if (null != userList) {
			PageList<Customer> result = new PageList<>();
			result.setPageBean(userList.getPageBean());

			List<SysUser> resultList = userList.getResultList();
			if (null != resultList) {
				List<Customer> customerList = ACustomerBuilder.buildSource(resultList);
				result.setResultList(customerList);
			}

			return result;
		}
		return null;
	}

	/*@Override
	public PageList<Customer> findCustomerForPMS(PageModel page,
			PMSCustomerQueryVo queryParam, Role queryRole) throws Exception {

		try {
			PageList<SysUser> pageList = null;

			SysUser queryUser = null;
			if (queryParam != null) {
				queryUser = PMSCustomerQueryBuilder.builder
						.changeQueryTSysUser(queryParam);
			}

			// 设置用户：客栈类型
			SysRole innRole = null;
			if (queryRole != null) {
				innRole = RoleBuilder.ARoleBuilder.convertTo(queryRole);
			}

			pageList = this.iuserService.findUserForPMS(queryUser, innRole,
					page);

			List<Customer> customers = new ArrayList<Customer>();
			if ((pageList != null) && (!(pageList.isEmpty()))) {
				List<SysUser> users = pageList.getResultList();
				customers = Customer.sList2CList(users);
			}
			PageList<Customer> result = new PageList<Customer>();
			result.setResultList(customers);
			result.setPageBean(pageList.getPageBean());
			return result;
		} catch (Exception e) {
			this.logger.error(e.toString());
			throw e;
		}

	}*/

	/*@Override
	public PageList<Customer> findCustonerWithScenic(Customer customer,
			Scenic scenic, PageModel pm) throws Exception {
		SysUser userParam = null;
		ProductScenic scenicParam = null;

		if (customer != null) {
			userParam = ACustomerBuilder.convertTo(customer);
			buildParam(userParam);
		}
		if (scenic != null) {
			scenicParam = AScenicBuilder.convertTo(scenic);
			if (scenicParam.getName() != null)
				scenicParam.setName(scenicParam.getName() + "%");
		}

		PageList<SysUser> userList = iuserService.findUserWithScenic(userParam,
				scenicParam, pm);

		return convertToCustomerPageList(userList);
	}*/

	@Override
	public Integer saveCustomerChannelBySupplyieId(Customer customer) throws Exception {
		try {
			if (customer == null) {
				return 0;
			}
			
			SysUser user = Customer.changeTSysUser(customer);

			List<SysChannel> syschannelList = extractSysChanelList(customer);

			Long num = iuserService.updateUserAndChannelRel(user, syschannelList);

			if (num > 0) {
				updateCustomerCache(customer);
			}
			return Integer.valueOf(num.toString());
		} catch (Exception e) {
			logger.error(e.toString());
			throw e;
		}
	}

	/**
	 * 保存用户的所有信息。
	 * 
	 * @param customer
	 * @param mark
	 *            用于区分是否为财务用户
	 * @return
	 * @throws Exception
	 */
	private SysUser saveCustomerAll(Customer customer, String mark)
			throws Exception {
		// 1.将Customer转化为SysUser，并对数据进行一些处理
		SysUser user = Customer.createNewSysUser(customer, true);

		// 2.渠道转换
		List<SysChannel> sysChannelList = extractSysChanelList(customer);

		OfficeAndRole ora = ADepartmentBuilder.buildOfficeAndRole(customer
				.getDepartmentList());

		// 3.部门转换
		List<SysOffice> sysOfficeList = ora.sysOfficeList;

		// 4.角色转换
		List<SysRole> sysOfficeRoleList = ora.sysRoleList;

		// 5.角色转换
		List<SysRole> sysUserRoleList = extractSysRoleList(customer);

		// 6.菜单转换
		List<SysMenu> sysMenuList = extractSysMenuList(customer);

		// 7.售票点
		List<Long> tickList = customer.getSalePointList();

		// 8.传递数据给远程，保存到数据库中，返回用户的id
		SysUser result = iuserService.addUserAndAuth(user, sysOfficeList,
				sysOfficeRoleList, sysUserRoleList, sysMenuList,
				sysChannelList, tickList, mark);

		return result;
	}
	@Override
	public Integer saveCustomerAndAuthBySupplyieId(Customer customer) throws Exception {
		if (customer == null)
			return 0;
		SysUser result = saveCustomerAllBySupplierId(customer, null);
		if (null != result) {
			updateCustomerCache(customer, result);
			return 1;
		} else {
			return 0;
		}
	}
	
	private SysUser saveCustomerAllBySupplierId(Customer customer, String mark)
			throws Exception {
		// 1.将Customer转化为SysUser，并对数据进行一些处理
		SysUser user = Customer.createNewSysUser(customer, true);
		// 2.渠道转换
		List<SysChannel> sysChannelList = extractSysChanelList(customer);
		OfficeAndRole ora = ADepartmentBuilder.buildOfficeAndRole(customer
				.getDepartmentList());
		// 3.部门转换
		List<SysOffice> sysOfficeList = ora.sysOfficeList;
		// 4.角色转换
		List<SysRole> sysOfficeRoleList = ora.sysRoleList;
		// 5.角色转换
		List<SysRole> sysUserRoleList = extractSysRoleList(customer);
		// 6.菜单转换
		List<SysMenu> sysMenuList = extractSysMenuList(customer);
		// 7.售票点
		List<Long> tickList = customer.getSalePointList();
		// 8.传递数据给远程，保存到数据库中，返回用户的id
		SysUser result = iuserService.addUserAndAuthBySupplierId(user, sysOfficeList,
				sysOfficeRoleList, sysUserRoleList, sysMenuList,
				sysChannelList, tickList, mark);
		return result;
	}


	@Override
	public Long updateBatchCustomerChannelBySupplierIds(List<Customer> customers) throws Exception {
		Long num = 0l;
		try {
			if (customers == null || customers.isEmpty()) {
				logger.error("接口方法[CustomerService.updateBatchCustomerChannel],参数customers不能为空");
				return num;
			}
			Map<String, List<SysChannel>> records = new HashMap<String, List<SysChannel>>();
			List<SysUser> users = new ArrayList<SysUser>();
			for (Customer customer : customers) {
				List<ChannelVo> channelList = customer.getChannelVoList();
				if (channelList == null) {
					continue;
				}
				SysUser user = Customer.changeTSysUser(customer);
				String sysCode = String.valueOf(user.getId());
				users.add(user);
				records.put(sysCode, ChannelVo.cList2SList(channelList));

			}
			num = iuserService.saveBatchUserAndChannelBySupplierIds(users, records, true,false);
			return num;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw e;
		}

	}

	@Override
	public PageList<Customer> queryChannelUnbundledDirectsDistributor(Long channelId, Customer distributorParam, PageModel pageModel) {
		if (channelId == null){
			logger.error("接口方法[CustomerService.queryChannelUnbundledDirectsDistributor],参数channelId不能为空");
			return null;
		}

		SysUser user = ACustomerBuilder.convertTo(distributorParam);

		PageList<SysUser> userList = iuserService.queryChannelUnbundledDirectsDistributor(channelId, user, pageModel);

		return convertToCustomerPageList(userList);
	}

	@Override
	public boolean unbindCustomerWithWechatAndLogout(String token) {
		try {
			Customer cutomer = cacheService.getUserToken(token);

			if (cutomer != null){
				Long id = cutomer.getId();
				if (id == null){
					return false;
				}

				cacheService.delToken(token);

				SysUser sysUser = new SysUser();
				sysUser.setId(id);
				sysUser.setWxOpenid("");

				iuserService.updateByPrimaryKey(sysUser);
			}


		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

}