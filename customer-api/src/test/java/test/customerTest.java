package test;

import static org.junit.Assert.*;

import java.util.*;

import com.pzj.customer.service.CustomerUtil;
import com.pzj.framework.context.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUser;
import com.pzj.base.service.sys.IUserService;
import com.pzj.cache.UserCacheService;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.customer.entity.Customer;
import com.pzj.customer.entity.CustomerSettlement;
import com.pzj.customer.entity.pms.PMSCustomerQueryVo;
import com.pzj.customer.service.CustomerService;
import com.pzj.department.entity.Department;
import com.pzj.menu.entity.Menu;
import com.pzj.role.entity.Role;
import com.pzj.util.JsonDataUtil;
import com.pzj.util.KeyValueVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class customerTest {

    @Autowired
    private CustomerService customerService = null;

    @Autowired
    UserCacheService userCacheService = null;

    @Autowired
    private CustomerUtil customerUtil = null;

    @Autowired
    IUserService serviceInstance = null;

    @Test
    public void genPassword() {
        String password = PasswordGenerateUtil.generatePassword(100000L, "130623198112302111", "123456");
        System.out.println("password = " + password);
        System.out.println();

    }

    @Test
    public void createCustomerByPMS() throws Exception {
        Customer customer = new Customer();
        customer.setName("pms测试客栈");
        customer.setLoginName("abcfff98");
        customer.setLoginPasswd("abc123");
        customer.setUserType("一般用户");
        customer.setSysCode("1");
        customer.setTwoDimensionCode("2222222222222222222222222222");
        customer.setAccountState(1);
        customer.setLeaderFlag(1);
        customer.setSort(1);
        List<KeyValueVo> keyList = new ArrayList<KeyValueVo>();
        KeyValueVo vo1 = new KeyValueVo();
        vo1.setKey("电冰箱");
        vo1.setValue("电冰箱");
        keyList.add(vo1);

        KeyValueVo vo2 = new KeyValueVo();
        vo2.setKey("电话");
        vo2.setValue("电话");
        keyList.add(vo2);

        KeyValueVo vo3 = new KeyValueVo();
        vo3.setKey("空调");
        vo3.setValue("空调");
        keyList.add(vo3);
        customer.setHotelFacility(keyList);

        Long id = customerService.createCustomer(customer);
        System.out.println(id);

    }

    @Test
    public void queryCustomerByPMS() throws Exception {
        PMSCustomerQueryVo customer = new PMSCustomerQueryVo();
        List<KeyValueVo> keyList = new ArrayList<KeyValueVo>();
        KeyValueVo vo1 = new KeyValueVo();
        vo1.setKey("电冰箱");
        vo1.setValue("电冰箱");
        keyList.add(vo1);

        KeyValueVo vo3 = new KeyValueVo();
        vo3.setKey("空调");
        vo3.setValue("空调");
        keyList.add(vo3);
        customer.setHotelFacility(keyList);
        /*
         * PageList<Customer> list = customerService.findCustomerForPMS(null,
         * customer); assertNotNull(list);
         */
    }

    /*
     * 创建用户
     */
    @Test
    public void createCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setLoginPasswd("abc12");
        //customer.setId(2216619746563726L);
        /*customer.setName("高效分页解决方案集1212");
        customer.setLoginName("abcfff98");
        customer.setLoginPasswd("abc123");
        customer.setUserType("一般用户");
        customer.setTwoDimensionCode("2222222222222222222222222222");
        customer.setSysCode("1");
        customer.setAccountState(1);
        customer.setLeaderFlag(1);
        customer.setSort(1);*/

        /*Department department = new Department();
        department.setName("nn_10161400");
        department.setAreaId("4");
        department.setType("1");
        department.setGrade("4");
        department.setDelFlag("1");
        department.setParentId("1");
        department.setParentIds("1");
        department.setDataSource("ffff");
        List<Department> departmentlist = new ArrayList<Department>();
        departmentlist.add(department);
        customer.setDepartmentList(departmentlist);*/

        Role role1 = new Role();
        role1.setId(2216619736563739L);
        /*role.setName("nn_10161400");
        role.setCreateBy("admin2");
        role.setUpdateBy("admin2");
        role.setDelFlag("1");*/
        role1.setDataSource("15");

        Role role2 = new Role();
        role2.setId(2216619736563738L);
        /*role.setName("nn_10161400");
        role.setCreateBy("admin2");
        role.setUpdateBy("admin2");
        role.setDelFlag("1");*/
        role2.setDataSource("1");

        Role role3 = new Role();
        role3.setDataSource("78");
        role3.setId(2215520224936095L);

        List<Role> rolelist = new ArrayList<>();
        rolelist.add(role1);
        rolelist.add(role2);
        //rolelist.add(role3);
        customer.setRoleList(rolelist);

        customer.setUserSource("15");
        //customer.setRoleList(Collections.EMPTY_LIST);

        Menu menu = new Menu();
        menu.setId(1234L);
        menu.setDataSource("13");
        /*menu.setName("1");
        menu.setHref("/aa");
        menu.setTarget("t");
        menu.setIcon("c");
        menu.setSort(2);
        menu.setIsShow("2");
        menu.setIsActiviti("2");
        menu.setParentId("2");
        menu.setParentIds("2,1");
        menu.setRemarks("test");
        menu.setPosition("test");
        menu.setStyle("test");
        menu.setPermission("fdsaf:fdsaf:fdsafa");
        menu.setDelFlag("2");
        menu.setCreateBy("1");
        menu.setUpdateBy("1");*/
        List<Menu> menulist = new ArrayList<Menu>();
        menulist.add(menu);
        customer.setMenuList(menulist);

        Long id = customerService.createCustomer(customer);
        assertNotNull(customer.getId());
        assertEquals(String.valueOf(id), String.valueOf(customer.getId()));
        System.out.println(">>>> createCustomer id is : " + id);
    }

    @Test
    public void saveCustomerAndAuth5() throws Exception {
        Customer customer = JsonDataUtil.readObjectFromClasspath("/testData/saveCustomerAndAuth.json",Customer.class);
        Integer num = customerService.saveCustomerAndAuth(customer);
        System.out.println(">>>>saveCustomerAndAuth num is : " + num);
    }

    @Test
    public void createCustomer0() throws Exception {
        Customer customer = new Customer();
        customer.setName("test_code_user1");
        customer.setLoginName("test_code_user1");
        customer.setLoginPasswd("123456");
        customer.setUserSource("cxc");
        customer.setUserType("2");
        customer.setCheckStatus("1");
        customer.setAccountState(123);
        customer.setIsRoot("2");
        customer.setSupplierId(344L);
        customer.setInvitationCode("test_code");

        Long id = customerService.createCustomer(customer);
        assertNotNull(customer.getId());
        assertEquals(String.valueOf(id), String.valueOf(customer.getId()));
        System.out.println(">>>> createCustomer id is : " + id);
    }

    @Test
    public void createCustomerLogin() throws Exception {
        Long customerId = 2215520224936980L;
        String username = "asd82345";
        String password = "abc82345";
        String dataSource = "5";

        Customer c = new Customer();
        // c.setId(customerId);
        c.setLoginName(username);
        c.setLoginPasswd(password);
        c.setUserSource(dataSource);
        c.setName("afdasf");

        customerService.createCustomer(c);

        Customer result = customerService.login(username, password, dataSource);
        assertNotNull(result);
    }

    @Test
    public void saveCustomerPasswordLogin() throws Exception {
        Long customerId = 2216619736763776L;
        String username = "1221212";
        String password = "123456";
        String dataSource = "5";

        Customer c = new Customer();
        c.setId(customerId);
        c.setLoginName(username);
        c.setLoginPasswd(password);
        c.setUserSource(dataSource);
        c.setName("afdasf");


        customerService.saveCustomerPassword(c);

        Customer result = customerService.login(username, password, dataSource);
        assertNotNull(result);
    }

    @Test
    public void
    saveCustomerAndAuth1() throws Exception {
        Customer customer = new Customer();
        // customer.setId(2216619736563739L);
        customer.setName("qqqq6666");
        customer.setLoginName("cvcvxcv");
        customer.setLoginPasswd("xcvcxv");
        customer.setUserSource("cxc");
        customer.setUserType("2");
        customer.setCheckStatus("1");
        customer.setAccountState(123);
        customer.setIsRoot("2");
        customer.setSupplierId(344L);
        customer.setInvitationCode("invitationCode");

        CustomerSettlement settlement = new CustomerSettlement();
        settlement.setAccountingUnit(13131L);
        settlement.setAccountingUnitName("12312312312312312");
        settlement.setCurrencyType(33);
        settlement.setSupplierBillingMode(3421);
        settlement.setSupplierBrokeragePeriod(4234);
        settlement.setSupplierCreditPayMode(5234);
        settlement.setSupplierPlatformPayMode(45324);
        settlement.setSupplierServiceFeePeriod(89243);
        settlement.setSupplierTradeServiceFee(54234.32423);
        settlement.setSupplierTradeServiceFeeType(354);
        settlement.setSupplierTradeServiceRemark("532347845afas");
        settlement.setSupplierBillingMode(623);

        customer.setSettlement(settlement);

        customerService.saveCustomerAndAuth(customer);
        assertNotNull(customer.getId());
    }

    @Test
    public void saveCustomerAndAuth2() throws Exception {
        Customer customer = new Customer();
        customer.setId(3585148721823745L);
        customer.setUserType("6");
        customer.setResellerType("5");

        List<ChannelVo> channelList = new ArrayList<>();
        {
            ChannelVo channel = new ChannelVo();
            channel.setId(2216619736563714L);
            channel.setSupplierId(123456789L);
        }
        customer.setChannelVoList(channelList);

        customerService.saveCustomerAndAuth(customer);
        assertNotNull(customer.getId());
    }

    /*
     * 编辑保存用户
     */
    @Test
    public void saveCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setLoginPasswd("nn_10161400");
        customer.setCity("beijing");

        Integer num = customerService.saveCustomerAndAuth(customer);
        System.out.println(">>>>saveCustomer num is : " + num);
    }

    @Test
    public void saveCustomerPassword() throws Exception {
        Customer customer = new Customer();
        customer.setId(2216619736763776L);
        customer.setLoginName("1221212");
        customer.setLoginPasswd("qwerty");
        customer.setToken("65e73b3dca72503f20914c936c1698a3");

/*        customer.setUserType("学生");
        customer.setSysCode("1");
        customer.setAccountState(1);
        customer.setLeaderFlag(1);
        customer.setSort(1);
        customer.setAccountState(2);
        customer.setCity("beijing");*/

        int num = customerService.saveCustomerPassword(customer);
        System.out.println(">>>>saveCustomer num is : " + num);
    }

    @Test
    public void saveCustomerAndAuthd() throws Exception {
        Customer customer = new Customer();
        // customer.setId(110L);
        customer.setName("原来是他们开发的");
        customer.setLoginName("nn_10161400");
        customer.setLoginPasswd("nn_10161400");
        customer.setUserType("学生");
        customer.setSysCode("1");
        customer.setAccountState(1);
        customer.setLeaderFlag(1);
        customer.setSort(1);
        customer.setAccountState(2);
        customer.setCity("beijing");

        List<Role> roles = new ArrayList<Role>();
        {
            Role role = new Role();
            role.setName("奇葩验证码");
            // role.setId(35L);
            role.setCreateBy("admin22");
            role.setUpdateBy("admin22");
            role.setDelFlag("1");
            role.setRemarks("333");
            roles.add(role);
        }
        {
            Role role = new Role();
            role.setName("难度逆天");
            // role.setId(35L);
            role.setCreateBy("admin22");
            role.setUpdateBy("admin22");
            role.setDelFlag("1");
            role.setRemarks("333");
            roles.add(role);
        }

        customer.setRoleList(roles);

        /*
         * Department department = new Department(); department.setId(100L);
         * List<Department> departmentlist = new ArrayList<Department>(1);
         * departmentlist.add(department);
         * customer.setDepartmentList(departmentlist);
         * 
         * Menu menu = new Menu(); menu.setId(481L); List<Menu> menulist = new
         * ArrayList<Menu>(); menulist.add(menu);
         * customer.setMenuList(menulist);
         */

        Integer num = customerService.saveCustomerAndAuth(customer);
        System.out.println(">>>>saveCustomer num is : " + num);
    }

    /*
     * 更新用户菜单
     */
    @Test
    public void saveCustomerMenu() throws Exception {
        Customer customer = new Customer();
        customer.setId(2215520224935961L);
        customer.setName("测试用户");
        customer.setLoginName("nn_10161400");
        customer.setLoginPasswd("nn_10161400");

        Menu menu = new Menu();
        menu.setName("nn_test");
        menu.setCreateBy("admin");
        menu.setUpdateBy("admin");
        menu.setSort(2);
        menu.setIsShow("2");
        menu.setIsActiviti("2");
        menu.setParentId("2");
        menu.setParentIds("2,1");
        menu.setRemarks("test");
        menu.setPosition("test");
        menu.setStyle("test");
        menu.setPermission("fdsaf:fdsaf:fdsafa");
        menu.setDelFlag("2");
        menu.setCreateBy("1");
        menu.setUpdateBy("1");
        List<Menu> menus = new ArrayList<Menu>();
        menus.add(menu);

        customer.setMenuList(menus);
        Integer num = customerService.saveCustomerMenu(customer);
        System.out.println(">>>>saveCustomerMenu num is : " + num);

    }

    /*
     * 更新用户角色
     */
    @Test
    public void saveCustomerRole() throws Exception {
        Customer customer = new Customer();
        // customer.setId(2215520224935961L);
        customer.setName("原来是他们开发的");
        customer.setLoginName("nn_10161400");
        customer.setLoginPasswd("nn_10161400");

        List<Role> roles = new ArrayList<Role>();
        {
            Role role = new Role();
            role.setName("奇葩验证码");
            // role.setId(35L);
            role.setCreateBy("admin22");
            role.setUpdateBy("admin22");
            role.setDelFlag("1");
            role.setRemarks("333");
            roles.add(role);
        }
        {
            Role role = new Role();
            role.setName("难度逆天");
            // role.setId(35L);
            role.setCreateBy("admin22");
            role.setUpdateBy("admin22");
            role.setDelFlag("1");
            role.setRemarks("333");
            roles.add(role);
        }

        customer.setRoleList(roles);

        Integer num = customerService.saveCustomerRole(customer);
        System.out.println(">>>>saveCustomerRole num is : " + num);
    }

    /*
     * 更新用户角色
     */
    @Test
    public void saveCustomerDepartment() throws Exception {
        Customer customer = new Customer();
        customer.setId(110L);
        customer.setName("测试用户");
        customer.setLoginName("nn_10161400");
        customer.setLoginPasswd("nn_10161400");

        Department department = new Department();
        department.setName("test_test");
        department.setId(100L);
        department.setAreaId("1");
        department.setType("1");
        department.setGrade("1");
        department.setCreateBy("111");
        department.setCreateDate(new Date(System.currentTimeMillis()));
        department.setParentId("111");
        department.setParentIds("111");
        department.setDelFlag("1");
        List<Department> departmentlist = new ArrayList<Department>();
        departmentlist.add(department);

        customer.setDepartmentList(departmentlist);

        Integer num = customerService.saveCustomerDepartment(customer);
        System.out.println(">>>>saveCustomerDepartment num is : " + num);
    }

    /*
     * 更新用户角色
     */
    @Test
    public void saveCustomerDR() throws Exception {
        Customer customer = new Customer();
        customer.setId(110L);
        customer.setName("nn_10161500");
        customer.setLoginName("nn_10161500");
        customer.setLoginPasswd("nn_10161500");

        Department department = new Department();
        department.setId(100L);
        // department.setName("sssss-test");
        // department.setAreaId("2");
        // department.setType("2");
        // department.setGrade("2");
        List<Department> departmentlist = new ArrayList<Department>();
        departmentlist.add(department);

        Role role = new Role();
        role.setId(310l);
        role.setName("nn_10161400");
        role.setCreateBy("admin");
        // role.setUpdateBy("admin");
        List<Role> roleslist = new ArrayList<Role>();
        roleslist.add(role);

        department.setList(roleslist);
        customer.setDepartmentList(departmentlist);

        Integer num = customerService.saveCustomerDR(customer);
        System.out.println(">>>>saveCustomerDR num is : " + num);
    }

    /*
     * 获取用户信息
     */
    @Test
    public void getCustomerById() throws Exception {
        Long id = 2216619736763776L;
        Customer customer = customerService.getCustomerById(id);
        assertNotNull(customer);
        System.out.println(">>>>getName is : " + customer.getName());
        System.out.println(">>>>getOperChargerMobile is : " + customer.getOperChargerMobile());
    }

    @Test
    public void findByUserOfficeRole() throws Exception {
        Integer start = 1;
        Integer size = 20;
        Customer customer = new Customer();

        PageList<Customer> result = customerService.findByUserOfficeRole(start, size, customer);
        assertNotNull(result);
        assertNotNull(result.getResultList());
    }

    @Test
    public void findByUserOfficeRole3() throws Exception {
        Integer start = 1;
        Integer size = 20;
        Customer customer = new Customer();
        // customer.setCommonFlag01("技1");
        // customer.setCommonFlag02("zxp");
        // customer.setName("rachar");
        customer.setLoginName("rachar");

        PageList<Customer> result = customerService.findByUserOfficeRole2(start, size, customer);
        assertNotNull(result);
        assertNotNull(result.getResultList());
    }

    /*
     * 获取用户列表
     */
    @Test
    public void findCustomerByParams() throws Exception {
        Customer customer = new Customer();
        // customer.setId(48L);
        //customer.setOperChargerMobile("18581359701");
        //customer.setInvitationCode("invitationCode");
        //customer.setCheckStatus("1");
        customer.setCheckStatusQuery(Arrays.asList("1","2"));
        List<Customer> customerlist = customerService.findCustomerByParams(customer);
        assertNotNull(customerlist);
        System.out.println(">>> size : " + customerlist.size());
        for (int i = 0; i < customerlist.size(); i++) {
            System.out.println(">>>>findCustomerByParams is : " + customerlist.get(i).getName());
        }
    }

    @Test
    public void findCustomerAuthByParams() throws Exception {
        Customer customer = new Customer();
        customer.setId(2216619736563718L);
        // customer.setId(2215520224935937L);
        //customer.setLoginName("demo");

        List<Customer> customerlist = customerService.findCustomerAuthByParams(customer);
        assertNotNull(customerlist);
        Customer customer1 = customerlist.get(0);
        List<ChannelVo> channelVoList = customer1.getChannelVoList();
        assertNotNull(customer1);
    }

    @Test
    public void getCustomerChannelList() throws Exception {
        Customer customer = new Customer();
        customer.setId(2216619736563718L);

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        List<Customer> customerChannelList = customerService.getCustomerChannelList(customerList);
        System.out.println(customerChannelList);
    }

    /*
     * 分页获取用户列表
     */
    @Test
    public void findCustomerPageByParams() throws Exception {
        Customer customer = new Customer();
        customer.setCheckStatus("1");
        customer.setIsRoot("1");
        customer.setUserType("6");
        // customer.setId(48L);
        PageList<Customer> customerlist = customerService.findCustomerPageByParams(33, 20, customer);
        assertNotNull(customerlist);
        for (int i = 0; i < 1; i++) {
            System.out.println(">>>>findCustomerByParams is : " + customerlist.get(i).getName());
        }

    }

    /*
     * 分页获取用户及关系列表
     */
    @Test
    public void findCustomerAuthPageByParams() throws Exception {
        Customer customer = new Customer();
        // customer.setId(110L);
        PageList<Customer> customerlist = customerService.findCustomerAuthPageByParams(1, 2, customer);
        assertNotNull(customerlist);
        List<Customer> resultList = customerlist.getResultList();
        assertNotNull(resultList);
        for (int i = 0; i < 1; i++) {
            System.out.println(">>>>findCustomerByParams is : " + customerlist.get(i).getName() + ", departmentid is : " + customerlist.get(i).getDcrList().get(i).getDepartmentId() + ", userid is : "
                    + customerlist.get(i).getDcrList().get(i).getUserId() + ", roleid is : " + customerlist.get(i).getDcrList().get(i).getRoleId() + ", menulist is : "
                    + customerlist.get(i).getMenuList().get(i).getId());
        }
    }

    /*
     * 获取用户部门
     */
    @Test
    public void getCustomerDepartmentList() throws Exception {
        Long id = 308L;

        Customer customer = new Customer();
        customer.setId(id);
        List<Customer> cl = new ArrayList<Customer>();
        cl.add(customer);
        List<Customer> customerlist = customerService.getCustomerDepartmentList(cl);
        assertNotNull(customerlist);
        for (int i = 0; i < customerlist.size(); i++) {
            System.out.println(">>>>getCustomerDepartmentList is : " + customerlist.get(i).getDepartmentList().get(i).getName());
        }
    }

    /*
     * 获取用户角色
     */
    @Test
    public void getCustomerRoleList() throws Exception {
        Customer customer = new Customer();
        customer.setId(2216619736569688L);
        List<Customer> cl = new ArrayList<Customer>();
        cl.add(customer);

        Customer customerParam = new Customer();
        customerParam.setAccountState(0);

        List<Customer> customerlist = customerService.getCustomerRoleList(cl, customerParam);
        assertNotNull(customerlist);
        for (int i = 0; i < customerlist.size(); i++) {
            System.out.println(">>>>getCustomerRoleList is : " + customerlist.get(i).getRoleList().get(i).getName());
        }
    }

    /*
     * 获取用户菜单
     */
    @Test
    public void getCusrtomerMenuList() throws Exception {
        Customer customer = new Customer();
        customer.setId(1234567890L);
        List<Customer> cl = new ArrayList<Customer>();
        cl.add(customer);
        List<Customer> customerlist = customerService.getCustomerMenuList(cl);
        assertNotNull(customerlist);
        for (int i = 0; i < customerlist.size(); i++) {
            System.out.println(">>>>getCusrtomerMenuList is : " + customerlist.get(i).getMenuList().get(i).getName());
        }
    }

    /*
     * 获取用户菜单
     */
    @Test
    public void getCusrtomerDRList() throws Exception {
        Customer customer = new Customer();
        customer.setId(110L);
        List<Customer> cl = new ArrayList<Customer>();
        cl.add(customer);
        List<Customer> customerlist = customerService.getCustomerDRList(cl);
        assertNotNull(customerlist);
        for (int i = 0; i < customerlist.size(); i++) {
            System.out.println(">>>>getCusrtomerDRList departmentid is : " + customerlist.get(i).getDcrList().get(i).getDepartmentId() + ", userid is : "
                    + customerlist.get(i).getDcrList().get(i).getUserId() + ", roleid is : " + customerlist.get(i).getDcrList().get(i).getRoleId());
        }
    }

    /*
     * 获取用户及用户部门角色菜单
     */
    @Test
    public void getCustomerAuthList() throws Exception {
        Customer customer = new Customer();
        customer.setId(110L);
        List<Customer> cl = new ArrayList<Customer>();
        cl.add(customer);
        List<Customer> customerlist = customerService.getCustomerAuthList(cl);
        assertNotNull(customerlist);
        for (int i = 0; i < customerlist.size(); i++) {
            System.out.println(">>>>getCustomerAuthList departmentid is : " + customerlist.get(i).getDcrList().get(i).getDepartmentId() + ", userid is : "
                    + customerlist.get(i).getDcrList().get(i).getUserId() + ", roleid is : " + customerlist.get(i).getDcrList().get(i).getRoleId() + ", menulist is : "
                    + customerlist.get(i).getMenuList().get(i).getId());
        }

    }

    /*
     * 逻辑删除用户
     */
    @Test
    public void deleteCustomer() throws Exception {
        Integer num = customerService.deleteCustomer(110L);
        System.out.println(">>>>deleteCustomer num is : " + num);
    }

    /*
     * 物理删除用户
     */
    @Test
    public void deletePhysicalCustomer() throws Exception {
        Integer num = customerService.deletePhysicalCustomer(46L);
        System.out.println(">>>>deletePhysicalCustomer num is : " + num);
    }

    /*
     * 用户登录
     */
    @Test
    public void login() throws Exception {
        Customer customer = customerService.login("wuliqing", "g7bplv");
        assertNotNull(customer);
        /*for (int i = 0; i < customer.getDepartmentList().size(); i++) {
            System.out.println(">>>>login DepartmentList is : " + customer.getDepartmentList().get(i).getName());
        }
        for (int i = 0; i < customer.getRoleList().size(); i++) {
            System.out.println(">>>>login RoleList is : " + customer.getRoleList().get(i).getName());
        }
        for (int i = 0; i < customer.getDcrList().size(); i++) {
            System.out.println(">>>>login getDcrList is : " + customer.getDcrList().toArray());
        }*/
    }
    /*
     * 用户登录
     */
    @Test
    public void loginForWechat() throws Exception {
        Customer customer = customerService.loginForWechat("o1B2XuJDDySgE9EjkwQd_K78clUY");
        assertNotNull(customer);
        /*for (int i = 0; i < customer.getDepartmentList().size(); i++) {
            System.out.println(">>>>login DepartmentList is : " + customer.getDepartmentList().get(i).getName());
        }
        for (int i = 0; i < customer.getRoleList().size(); i++) {
            System.out.println(">>>>login RoleList is : " + customer.getRoleList().get(i).getName());
        }
        for (int i = 0; i < customer.getDcrList().size(); i++) {
            System.out.println(">>>>login getDcrList is : " + customer.getDcrList().toArray());
        }*/
    }

    @Test
    public void aaa() throws Exception {

        Customer c = new Customer();
        c.setId(13L);
        c.setParentId(0L);
        c.setLoginName("fffff");
        c.setLoginPasswd("aaaa");
        c.setSysCode("1");
        c.setUserType("2");
        c.setAccountState(1);
        c.setName("fff");
        c.setLeaderFlag(1);
        c.setSort(1);

        Menu menu = new Menu();
        menu.setId(498L);
        List<Menu> menuList = new ArrayList<Menu>();
        menuList.add(menu);

        c.setMenuList(menuList);

        Role role = new Role();
        role.setId(313L);
        List<Role> roleList = new ArrayList<Role>();
        roleList.add(role);

        c.setRoleList(roleList);

        Department department = new Department();
        department.setId(106L);
        List<Department> departmetnList = new ArrayList<Department>();
        departmetnList.add(department);

        c.setDepartmentList(departmetnList);

        customerService.saveCustomerAndAuth(c);
    }

    @Test
    public void compilePasswordMd5() {

        String password = "abc";
        String md5Password = "900150983cd24fb0d6963f7d28e17f72";

        boolean equals = customerService.compilePasswordMd5(password, md5Password);
        assertTrue(equals);
    }

    @Test
    public void updateBatchCustomerChannel() throws Exception {

        List<Customer> cusList = new ArrayList<Customer>();
        {
            Customer customer = new Customer();
            customer.setId(2216619736566924L);
            customer.setTwoDimensionCode("3333333333333333333333333333333333333");
            customer.setName("测试用户");
            customer.setLoginName("test_nn");
            customer.setLoginPasswd("test_nn");
            customer.setUserType("一般用户");
            customer.setSysCode("1");
            customer.setAccountState(1);
            customer.setLeaderFlag(1);
            customer.setSort(1);
            customer.setCreateDate(new Date(System.currentTimeMillis()));
            customer.setOperChargerMobile("12222222222");
            customer.setOperChargerPhone("12222222222");
            customer.setOperChargerFax("22222");
            customer.setOperChargerEmail("test@mytour.com");
            customer.setLastLoginTime(new Date(System.currentTimeMillis()));
            customer.setProvince("河北省");
            customer.setCity("beijing");
            customer.setCounty("beijing");

            ChannelVo vo = new ChannelVo();
            vo.setId(516L);

            ChannelVo vo2 = new ChannelVo();
            vo2.setId(517L);

            List<ChannelVo> clist = new ArrayList<ChannelVo>();
            clist.add(vo);
            clist.add(vo2);

            customer.setChannelVoList(clist);
            cusList.add(customer);
        }

        {
            Customer customer = new Customer();
            customer.setId(80L);
            customer.setName("测试用户");
            customer.setLoginName("test_nn");
            customer.setLoginPasswd("test_nn");
            customer.setUserType("一般用户");
            customer.setSysCode("1");
            customer.setAccountState(1);
            customer.setLeaderFlag(1);
            customer.setSort(1);
            customer.setCreateDate(new Date(System.currentTimeMillis()));
            customer.setOperChargerMobile("12222222222");
            customer.setOperChargerPhone("12222222222");
            customer.setOperChargerFax("22222");
            customer.setOperChargerEmail("test@mytour.com");
            customer.setLastLoginTime(new Date(System.currentTimeMillis()));
            customer.setProvince("河北省");
            customer.setCity("beijing");
            customer.setCounty("beijing");

            ChannelVo vo = new ChannelVo();
            vo.setId(516L);

            ChannelVo vo2 = new ChannelVo();
            vo2.setId(517L);

            List<ChannelVo> clist = new ArrayList<ChannelVo>();
            clist.add(vo);
            clist.add(vo2);

            customer.setChannelVoList(clist);
            cusList.add(customer);
        }

        Long id = customerService.updateBatchCustomerChannel(cusList);
        System.out.println(">>>> createCustomer id is : " + id);
    }

    @Test
    public void saveCustomerChannel() throws Exception {
        Customer customer = new Customer();
        customer.setId(47L);
        customer.setName("测试用户");
        customer.setLoginName("test_nn");
        customer.setLoginPasswd("test_nn");
        customer.setUserType("一般用户");
        customer.setSysCode("1");
        customer.setAccountState(1);
        customer.setLeaderFlag(1);
        customer.setSort(1);
        customer.setCreateDate(new Date(System.currentTimeMillis()));
        customer.setOperChargerMobile("12222222222");
        customer.setOperChargerPhone("12222222222");
        customer.setOperChargerFax("22222");
        customer.setOperChargerEmail("test@mytour.com");
        customer.setLastLoginTime(new Date(System.currentTimeMillis()));
        customer.setProvince("河北省");
        customer.setCity("beijing");
        customer.setCounty("beijing");

        ChannelVo vo = new ChannelVo();
        vo.setId(516L);

        ChannelVo vo2 = new ChannelVo();
        vo2.setId(517L);

        List<ChannelVo> clist = new ArrayList<ChannelVo>();
        clist.add(vo);
        clist.add(vo2);

        customer.setChannelVoList(clist);

        Integer id = customerService.saveCustomerChannel(customer);
        System.out.println(">>>> createCustomer id is : " + id);
    }

    @Test
    public void saveCustomerAndAuthd2() throws Exception {
        Customer customer = new Customer();
        customer.setName("藤原佐为");
        customer.setLoginName("FUJIWARANOSAI");
        customer.setLoginPasswd("FUJIWARANOSAI");
        customer.setUserType("长发，穿狩衣，戴乌纱帽");
        customer.setSysCode("1");
        customer.setAccountState(1);
        customer.setLeaderFlag(1);
        customer.setSort(1);
        customer.setAccountState(2);
        customer.setCity("beijing");

        List<Role> roleList = new ArrayList<Role>(2);
        {
            Role role = new Role();
            role.setName("长发");
            roleList.add(role);
        }
        {
            Role role = new Role();
            role.setName("穿狩衣");
            roleList.add(role);
        }
        {
            Role role = new Role();
            role.setName("戴乌纱帽");
            roleList.add(role);
        }
        customer.setRoleList(roleList);

        List<Department> departmentlist = new ArrayList<Department>(1);
        {
            Department department = new Department();
            department.setName("围棋00A1");
            departmentlist.add(department);

            List<Role> roleLista = new ArrayList<Role>(2);
            {
                Role role = new Role();
                role.setName("围棋00A1长发");
                roleLista.add(role);
            }
            {
                Role role = new Role();
                role.setName("围棋00A1穿狩衣");
                roleLista.add(role);
            }
            department.setList(roleLista);
        }
        {
            Department department = new Department();
            department.setName("围棋11B2");
            departmentlist.add(department);

            List<Role> roleLista = new ArrayList<Role>(2);
            {
                Role role = new Role();
                role.setName("围棋00A1长发");
                roleLista.add(role);
            }
            {
                Role role = new Role();
                role.setName("围棋00A1穿狩衣");
                roleLista.add(role);
            }
            department.setList(roleLista);
        }
        customer.setDepartmentList(departmentlist);

        Integer num = customerService.saveCustomerAndAuth(customer);
        System.out.println(">>>>saveCustomer num is : " + num);
    }

    @Test
    public void getUserToken() throws Exception {
        Customer admin = customerService.login("admin", "123456", "4");

        assertNotNull(admin);

        String token = admin.getToken();

        assertNotNull(token);

        Customer userToken = userCacheService.getUserToken(token);

        assertNotNull(userToken);

    }

    @Test
    public void findCustomerDRByCustomer() throws Exception {
        Customer customerParam = new Customer();
        customerParam.setLoginName("demo");

        List<Customer> customerList = customerService.findCustomerDRByCustomer(customerParam);

        assertNotNull(customerList);

        for (Customer customer : customerList) {
            assertNotNull(customer);
            assertNotNull(customer.getDcrList());

            System.out.println("\tCustomer的名称是：" + customer.getName() + "  ID 是：" + customer.getId());

            List<Department> departmentList = customer.getDepartmentList();
            assertNotNull(departmentList);

            for (Department department : departmentList) {
                assertNotNull(department);

                System.out.println("\t\tDepartment的名称是：" + department.getName() + "  ID 是：" + department.getId());

                List<Role> rolelist = department.getList();
                assertNotNull(rolelist);

                for (Role role : rolelist) {
                    assertNotNull(role);
                    System.out.println("\t\t\tRole的名称是：" + role.getName() + "  ID 是：" + role.getId());
                }

            }

        }
    }

    @Test
    public void findCustomerExclusiveMasterCustomer() throws Exception {
        Customer masterParam = new Customer();
        //masterParam.setId(2216619736569576L);
        masterParam.setWhereIsAnd(false);
        masterParam.setInclusiveRelationUser(false);

        Customer customerParam = new Customer();

        String querystr = "18011520296";

        customerParam.setLoginName(querystr); // 登录名

        PageModel page = new PageModel();
        page.setPageNo(1);
        page.setPageSize(10);

        PageList<Customer> customerList = customerService.findCustomerExclusiveMasterCustomer(masterParam, customerParam, page);

        assertNotNull(customerList);

        List<Customer> resultList = customerList.getResultList();
        assertNotNull(resultList);
        System.out.println(resultList.get(0).getTwoDimensionCode());
        assertNotNull(resultList);
        assertTrue(resultList.size() > 0);

    }

    @Test
    public void findCustomerExclusiveMasterCustomer131() throws Exception {
        HashMap map = new HashMap();
        map.put("userIds", "2216619736566924");
        List<SysUser> byIds = serviceInstance.findByIds(map);
        System.out.println(byIds.size());
        System.out.println(byIds.get(0).getTwoDimensionCode());
    }

    @Test
    public void AA(){
        Result<Boolean> result = serviceInstance.auditPassUser(3214145760002049L, 3214145760002049L);
    }

    @Test
    public void genToken(){
        Customer customer = new Customer();
        customer.setId(3341321513730049L);
        customer.setLoginName("lgh123");
        //customer.setLoginName("123456");
        customer.setLoginName("98be5d6166604b2563357e4825b831fc");

        String token = customerUtil.genTokenKey(customer);
        System.out.println(token);
    }

    @Test
    public void getCustomerFromToken() throws Exception {
        Customer cust = userCacheService.getUserToken("4dd1bf5396bfc53b4bc7f5bf67234b6d");
        System.out.println(cust.getToken());
    }
}
