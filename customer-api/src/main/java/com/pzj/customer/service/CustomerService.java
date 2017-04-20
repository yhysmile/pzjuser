package com.pzj.customer.service;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.customer.entity.Customer;
import com.pzj.customer.entity.CustomerRelation;
import com.pzj.role.entity.Role;

/**
 * 系统用户接口
 * 
 * @author huxiaona
 * @email huxiaona@mftour.cn
 * @date 2015-8-27 上午11:09:38
 */
public interface CustomerService {
	/**
	 *
	 * @api {interface} com.pzj.customer.service.CustomerService createCustomer 接口
	 * @apiGroup Customer Service
	 * @apiVersion 2.0.0
	 * @apiDescription
	 * <h3>
	 * 创建用户
	 * </h3>
	 * <p>
	 * </p>
	 * 
	 * @param customer
	 *            用户实体
	 */
	Long createCustomer(Customer customer) throws Exception;

	/**
	 * 创建财务用户 （只处理新用户的基本信息，不做关联）
	 * 
	 * @param customer
	 *            用户实体
	 * @return 用户的Id
	 */
	Long createCustomerForFinancial(Customer customer) throws Exception;

	/**
	 * 编辑保存用户
	 * 
	 * @param customer
	 *            用户实体
	 */
	Integer saveCustomer(Customer customer) throws Exception;

	/**
	 * 编辑保存用户及所有的关系
	 * 
	 * @param customer
	 *            用户实体
	 */
	Integer saveCustomerAndAuth(Customer customer) throws Exception;

	/**
	 * 更新用户菜单
	 * 
	 * @param customer
	 *            用户实体
	 * @return 更新条数
	 * @throws Exception
	 * 
	 */
	Integer saveCustomerMenu(Customer customer) throws Exception;

	/**
	 * 更新用户信息，并且加密密码。
	 * 
	 * @param customer
	 *            用户实体
	 * @return 更新条数
	 * @throws Exception
	 * 
	 */
	int saveCustomerPassword(Customer customer) throws Exception;

	/**
	 * 更新财务用户信息，并且加密密码。
	 * 
	 * @param customer
	 *            用户实体
	 * @return 更新条数
	 * @throws Exception
	 * 
	 */
	int saveCustomerPasswordForFinancial(Customer customer) throws Exception;

	/**
	 * 更新用户角色
	 * 
	 * @param customer
	 *            用户实体
	 * @return 更新条数
	 * @throws Exception
	 */
	Integer saveCustomerRole(Customer customer) throws Exception;

	/**
	 * 更新用户部门
	 * 
	 * @param customer
	 *            用户实体
	 * @return 更新条数
	 * @throws Exception
	 */
	Integer saveCustomerDepartment(Customer customer) throws Exception;

	/**
	 * 更新用户部门角色关联关系
	 * 
	 * @param customer
	 *            用户实体
	 * @return 更新条数
	 * @throws Exception
	 */
	Integer saveCustomerDR(Customer customer) throws Exception;

	/**
	 * 更新用户渠道关联关系
	 * 
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	Integer saveCustomerChannel(Customer customer) throws Exception;

	/**
	 * 批量改变用户状态
	 * 
	 * @param ids
	 *            string类型，list（id）集合 * @return
	 */
	Integer updateBatchCustomerPrimaryKey(List<Long> ids, int accountState);

	/**
	 * 批量更新用户与渠道的关联关系
	 */
	Long updateBatchCustomerChannel(List<Customer> customers) throws Exception;

	/**
	 * 批量更新用户与常用信息的关联关系
	 * 
	 * @param customers
	 * @param type
	 * @return
	 * @throws Exception
	 */
	Long updateBatchCustomerCommonInfo(List<Customer> customers, String type) throws Exception;

	/**
	 * 根据条件查询用户及用户的所有信息
	 * 
	 * 如果customerParam中指定了平台usersource，则相应地只查询与usersource相同datasouce的Role和Menu。
	 * 
	 * 与findCustomerAuthByParams的区别就在于datasouce此处，
	 * 这个方法会将所有datasouce关联的Role和Menu都查询出来。 customerParam
	 * 
	 * @param customerParam
	 * @return
	 * @throws Exception
	 */
	List<Customer> findCustomerAllInfoByParams(Customer customerParam) throws Exception;

	/**
	 * 查询用户列表，支持多参数
	 * 
	 * @param customer
	 *            用户实体
	 * @return 分页对象
	 */
	List<Customer> findCustomerByParams(Customer customer) throws Exception;

	PageList<Customer> findCustomerPageByParams(PageModel pm, Customer customer) throws Exception;

	/**
	 * 查询用户列表，用户的部门列表，用户的角色列表，用户的菜单列表，用户部门角色关联关系列表，支持多参数
	 * 
	 * @param customer
	 *            用户实体
	 * @return 分页对象
	 */
	List<Customer> findCustomerAuthByParams(Customer customer) throws Exception;

	/**
	 * 查询用户列表，用户的景区列表
	 * @@@
	 * @param page
	 *            用户实体
	 * @param customer
	 *            用户状态（1：正常，0：禁用）
	 * @return 分页对象
	 */
//	PageList<Customer> findCustomerScenicPageByParams(PageModel page, Customer customer) throws Exception;

	/**
	 * 查询用户列表，用户的微店列表
	 *
	 * @param customer
	 *            用户实体
	 * 
	 * @return 分页对象
	 */
//	PageList<Customer> findCustomerWDPageByParams(PageModel page, Customer customer) throws Exception;

	/**
	 * 根据用户和角色多参数查询用户
	 * 
	 */
	PageList<Customer> findCustomerByCRInfo(PageModel page, Customer customer, Role role) throws Exception;

	List<Customer> findCustomerDRByCustomer(Customer customer) throws Exception;

	/**
	 * 根据用户名分平台查询用户基础信息（完整查询）
	 * 
	 * @param loginName
	 * @param datasource
	 * @return
	 * @throws Exception
	 */
	List<Customer> findCustomerByLoginName(String loginName, String datasource) throws Exception;

	/**
	 * 根据用户信息分平台查询用户基础信息（完整查询）
	 * 
	 * @param customer
	 * @param datasource
	 * @return
	 * @throws Exception
	 */
	List<Customer> findCustomerByCompleteParam(Customer customer, String datasource) throws Exception;

	List<Customer> findCustomerByParams(Customer customer, boolean needLike) throws Exception;

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
	PageList<Customer> findCustomerPageByParams(Integer pageNo, Integer pageSize, Customer customer) throws Exception;

	/**
	 * 查询用户列表，用户的部门列表，用户的角色列表，用户的菜单列表，用户部门角色关联关系列表，支持多参数
	 * 
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            每页显示记录数
	 * @param customer
	 *            用户实体
	 * @param customer
	 *            用户状态（1：正常，0：禁用）
	 * @return 分页对象
	 */
	PageList<Customer> findCustomerAuthPageByParams(Integer pageNo, Integer pageSize, Customer customer)
			throws Exception;

	PageList<Customer> findByUserOfficeRole(Integer start, Integer size, Customer customer) throws Exception;

	PageList<Customer> findByUserOfficeRole2(Integer start, Integer size, Customer customer) throws Exception;

	/**
	 * 根据渠道Id和标签多参数分页查询分销商列表
	 * 
	 */
	PageList<Customer> queryPageByChannelId(PageModel pager, Customer vo, Long channelId) throws Exception;

	/**
	 * 根据主键id获取角色信息
	 * 
	 * @param id
	 *            用户主键id
	 * @return
	 */
	Customer getCustomerById(Long id) throws Exception;

	/**
	 * 根据主键id集合获取用户信息
	 * 
	 * @param ids
	 *            用户主键id集合
	 * @return
	 */
	List<Customer> getCustomerListByIds(List<Long> ids) throws Exception;

	/**
	 * 获取用户及用户下的部门列表
	 * 
	 * @param customers
	 *            用户列表
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Customer> getCustomerDepartmentList(List<Customer> customers) throws Exception;

	/**
	 * 获取用户及用户下的角色列表
	 * 
	 * @param customers
	 *            用户列表
	 * @return
	 * @throws Exception
	 */
	List<Customer> getCustomerRoleList(List<Customer> customers) throws Exception;

	/**
	 * 获取用户及用户下的角色列表
	 * 
	 * @param customers
	 *            用户列表
	 * @param customersParam
	 *            过滤条件，目前只有accountSatte有效
	 * @return
	 * @throws Exception
	 */
	List<Customer> getCustomerRoleList(List<Customer> customers, Customer customersParam) throws Exception;

	/**
	 * 获取用户及用户下的菜单列表
	 * 
	 * @param customers
	 *            用户列表
	 * @return
	 * @throws Exception
	 * 
	 */
	List<Customer> getCustomerMenuList(List<Customer> customers) throws Exception;

	/**
	 * 获取用户及用户部门角色关系列表
	 * 
	 * @param customers
	 *            用户列表
	 * @return
	 * @throws Exception
	 * 
	 */
	List<Customer> getCustomerDRList(List<Customer> customers) throws Exception;

	/**
	 * 获取用户及用户下的渠道列表
	 * 
	 * @param customers
	 *            用户列表
	 * @return
	 * @throws Exception
	 */
	List<Customer> getCustomerChannelList(List<Customer> customers) throws Exception;

	/**
	 * 获取用户及用户下的部门列表，角色列表，权限列表及用户部门角色关系列表
	 * 
	 * @param customers
	 *            用户主键Id
	 * @return
	 * @throws Exception
	 */
	List<Customer> getCustomerAuthList(List<Customer> customers) throws Exception;

	/**
	 * 逻辑删除用户
	 * 
	 * @param customerId
	 *            用户主键id
	 * @return
	 */
	Integer deleteCustomer(Long customerId) throws Exception;

	/**
	 * 物理删除用户
	 * 
	 * @param customerId
	 *            用户主键id
	 * @return
	 */
	Integer deletePhysicalCustomer(Long customerId) throws Exception;

	/**
	 * 用户登录
	 * 
	 * @param loginName
	 *            用户登录名称
	 * @param password
	 *            用户登录密码
	 * @return
	 * @throws Exception
	 */
	Customer login(String loginName, String password) throws Exception;

	/**
	 * 微信用户登录
	 *
	 * @param openid
	 *            微信的openid
	 * @return
	 * @throws Exception
	 */
	Customer loginForWechat(String openid);

	/**
	 * 财务用户登录
	 * 
	 * @param loginName
	 *            用户登录名称
	 * @param password
	 *            用户登录密码
	 * @return
	 * @throws Exception
	 */
	Customer loginForFinancial(String loginName, String password) throws Exception;

	Customer login(String loginName, String password, String dataSource) throws Exception;

	// public List<Customer> findCustomerByRole(Integer start, Integer size,
	// Role role);

	/**
	 * 判断用户Token是否过期
	 * 
	 */
	boolean isTokenValid(String token) throws Exception;

	/**
	 * 验证密码,密码直接MD5加密
	 * 
	 * @param password
	 * @param md5Password
	 * @return
	 */
	boolean compilePasswordMd5(String password, String md5Password);

	/**
	 * 验证密码，密码的加密方式按照景区的逻辑处理
	 * 
	 * @param userId
	 * @param loginName
	 * @param password
	 * @param md5Password
	 * @return
	 */
	boolean compilePasswordMd5(Long userId, String loginName, String password, String md5Password);

	/**
	 * 获取系统供应商Id
	 */
	Long getSupplierId();

	/**
	 * 根据用户与用户的关联查询被关联的用户
	 * 
	 * @param referenceCustomer
	 * @return
	 */
	PageList<Customer> findRefCustomerByRelation(CustomerRelation relation, Customer referenceCustomer, PageModel pageModel)
			throws Exception;

	/**
	 * 根据用户与用户的关联查询主用户
	 *
	 * @param relation
	 * @return
	 */
	PageList<Customer> findMasCustomerByRelation(CustomerRelation relation, Customer masterCustomer, PageModel pageModel)
			throws Exception;

	/**
	 * A,B两个用户创建了关联关系，查询出建立或没建立过关联关系的其它用户。
	 * 
	 * @param master
	 *            主用户，比如分销商
	 * @param customer
	 *            被关联的用户，比如导游
	 * @param page
	 * @return
	 * @throws Exception
	 */
	PageList<Customer> findCustomerExclusiveMasterCustomer(Customer master, Customer customer, PageModel page)
			throws Exception;

	/**
	 * pms接口 查询某个分销商可购买的客栈分页列表
	 * @@@
	 * @param page
	 * @param queryParam
	 * @param customerId
	 *            分销商Id
	 * @return
	 */
	/*public PageList<Customer> findCustomerForPMS(PageModel page, PMSCustomerQueryVo queryParam, Role queryRole)
			throws Exception;*/

	/**
	 * 根据用户与景区，查询用户
	 * @@@
	 * @param customer
	 * @param scenic
	 * @param pm
	 * @return
	 * @throws Exception
	 */
//	PageList<Customer> findCustonerWithScenic(Customer customer, Scenic scenic, PageModel pm) throws Exception;

	/**
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	Integer updateCustomerChannelWithSupplier(Customer customer) throws Exception;
	/**
	 * 根据供应商的id来维护用户的相应关系（大平台）
	 * @version 1.0.1
	 * @describe 此次为解决平台审核时，渠道互斥的问题
	 * @param customer
	 *            用户实体
	 */
	Integer saveCustomerAndAuthBySupplyieId(Customer customer) throws Exception;

	/**
	 * 根据供应商的id来维护用户的相应关系(分销端,更新用户渠道信息时使用)
	 * @version 1.0.1
	 * @describe 此次为解决平台审核时，渠道互斥的问题
	 * @param customer
	 *            用户实体
	 */
	Integer saveCustomerChannelBySupplyieId(Customer customer) throws Exception;
	
	/**
	 * 批量更新用户与渠道的关联关系(解决互斥的问题)
	 */
	Long updateBatchCustomerChannelBySupplierIds(List<Customer> customers) throws Exception;

	/**
	 * 查询渠道未绑定的直签分销商
	 * @param channelId
	 * @param distributorParam
	 * @param pageModel
	 * @return
	 */
	PageList<Customer> queryChannelUnbundledDirectsDistributor(Long channelId, Customer distributorParam, PageModel pageModel);

	/**
	 * 解绑微信，同时执行退出
	 * @param token
	 * @return
     */
	boolean unbindCustomerWithWechatAndLogout(String token);
}
