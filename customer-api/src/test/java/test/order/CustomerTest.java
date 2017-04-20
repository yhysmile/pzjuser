package test.order;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.pzj.base.common.BaseVO;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.channel.service.impl.ChannelServiceImpl;
import com.pzj.customer.entity.Customer;
import com.pzj.customer.entity.CustomerRelation;
import com.pzj.customer.service.CustomerServiceImpl;
import com.pzj.department.entity.Department;
import com.pzj.department.service.DepartmentServiceImpl;
import com.pzj.label.entity.LabelVo;
import com.pzj.label.service.impl.LabelServiceimpl;
import com.pzj.log.entity.OperatorLog;
import com.pzj.log.service.OperatorLogServiceImpl;
import com.pzj.menu.entity.Menu;
import com.pzj.menu.service.MenuServiceImpl;
import com.pzj.role.entity.Role;
import com.pzj.role.service.RoleServiceImpl;
import com.pzj.util.CommonEntity;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用于测试分页查询默认按ID倒序
 * 
 * Created by Administrator on 2015-12-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class CustomerTest {
    @Autowired
    CustomerServiceImpl customerService = null;
    @Test
    public void findByUserOfficeRole2() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;

        PageList<Customer> result = customerService.findByUserOfficeRole2(
                start, size, param);

        compareCommonEntityOrder(result);
    }

    private void compareCommonEntityOrder(PageList<?> result) {
        assertNotNull(result);

        List<?> customerList = result.getResultList();
        assertNotNull(customerList);

        int size = customerList.size();
        for (int i = 1; i < size; i++) {
            CommonEntity entityA = (CommonEntity) customerList.get(i - 1);
            CommonEntity entityB = (CommonEntity) customerList.get(i);
            Long aId = entityA.getId();
            Long bId = entityB.getId();
            assertTrue(aId > bId);
        }
    }

    @Test
    public void findCustomerAuthPageByParams() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;

        PageList<Customer> result = customerService
                .findCustomerAuthPageByParams(start, size, param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findCustomerByCRInfo() throws Exception {
        Customer param = new Customer();
        param.setLoginName("");
        param.setSupplierId(2216619741563734L);
        param.setIsRoot("0");
        param.setCorporaterMobile("");
        param.setNeedLike(true);

        Integer start = 1;
        Integer size = 10;

        PageModel pm = new PageModel(start, size);

        Role role = new Role();
        role.setId(2216619741563715L);

        PageList<Customer> result = customerService.findCustomerByCRInfo(pm,
                param, role);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findCustomerPageByParams() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;

        PageList<Customer> result = customerService.findCustomerPageByParams(
                start, size, param);

        compareCommonEntityOrder(result);
    }

    /*@Test
    public void findCustomerScenicPageByParams() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<Customer> result = customerService
                .findCustomerScenicPageByParams(pm, param);

        compareCommonEntityOrder(result);
    }*/
/*
    @Test
    public void findCustomerWDPageByParams() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<Customer> result = customerService.findCustomerWDPageByParams(
                pm, param);

        compareCommonEntityOrder(result);
    }*/

    @Test
    public void findRefCustomerByRelation() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


        Customer param = new Customer();
        param.setCreateDate(sdf.parse("2017-01-04 00:00:00.0"));
        param.setCreateDateEnd(sdf.parse("2017-01-04 23:59:59"));
        //param.setName("王小小");
        //param.setCorporaterCredentials("11010119921201");

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);
        CustomerRelation relation = new CustomerRelation();
        //relation.setRelUserId(2216619746563733L);
        relation.setRelType("6");
        relation.setUserId(3306769055481857L);

        PageList<Customer> result = customerService.findRefCustomerByRelation(
                relation, param, null);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findMasCustomerByRelation() throws Exception {
        Customer param = new Customer();
        //param.setCorporaterCredentials("11010119921201");

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);
        CustomerRelation relation = new CustomerRelation();
        relation.setRelUserId(2216619736563714L);
        //relation.setRelType("5");

        PageList<Customer> result = customerService.findMasCustomerByRelation(
                relation, param, null);

        compareCommonEntityOrder(result);
    }

    @Test
    public void queryPageByChannelId() throws Exception {
        Customer param = new Customer();

        PageModel pm = new PageModel(1, 20);

        PageList<Customer> result = customerService.queryPageByChannelId(pm,
                param, 3308131610787840L);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findMenuPageByParams() throws Exception {
        MenuServiceImpl menuService = new MenuServiceImpl();

        Menu param = new Menu();

        Integer start = 1;
        Integer size = 10;

        PageList<Menu> result = menuService.findMenuPageByParams(start, size,
                param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findByDempartmentRole() throws Exception {
        RoleServiceImpl roleService = new RoleServiceImpl();

        Role param = new Role();

        Integer start = 1;
        Integer size = 10;

        PageList<Role> result = roleService.findByDempartmentRole(start, size,
                param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findRoleAuthPageByParams() throws Exception {
        RoleServiceImpl roleService = new RoleServiceImpl();

        Role param = new Role();

        Integer start = 1;
        Integer size = 10;

        PageList<Role> result = roleService.findRoleAuthPageByParams(start,
                size, param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findRolePageByParams() throws Exception {
        RoleServiceImpl roleService = new RoleServiceImpl();

        Role param = new Role();

        Integer start = 1;
        Integer size = 10;

        PageList<Role> result = roleService.findRolePageByParams(start, size,
                param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findDepartmentAuthPageByParams() throws Exception {
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

        Department param = new Department();

        Integer start = 1;
        Integer size = 10;

        PageList<Department> result = departmentService
                .findDepartmentAuthPageByParams(start, size, param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findDepartmentPageByParams() throws Exception {
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

        Department param = new Department();

        Integer start = 1;
        Integer size = 10;

        PageList<Department> result = departmentService
                .findDepartmentPageByParams(start, size, param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void queryPageByParamMap() throws Exception {
        LabelServiceimpl labelServiceimpl = new LabelServiceimpl();

        LabelVo param = new LabelVo();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<LabelVo> result = labelServiceimpl.queryPageByParamMap(pm,
                param);
        compareCommonEntityOrder(result);
    }


    @Test
    public void findOperatorLogByParams() throws Exception {
        OperatorLogServiceImpl operatorLogService = new OperatorLogServiceImpl();

        OperatorLog param = new OperatorLog();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<OperatorLog> result = operatorLogService
                .findOperatorLogByParams(start, size, param);
        compareCommonEntityOrder(result);
    }

    @Test
    public void ChannelVoqueryPageByParamMap() throws Exception {
        ChannelServiceImpl channelService = new ChannelServiceImpl();

        ChannelVo param = new ChannelVo();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<ChannelVo> result = channelService.queryPageByParamMap(pm,
                param);
        compareBaseVoOrder(result);
    }

    private void compareBaseVoOrder(PageList<?> result) {
        assertNotNull(result);

        List<?> customerList = result.getResultList();
        assertNotNull(customerList);

        int size = customerList.size();
        for (int i = 1; i < size; i++) {
            BaseVO entityA = (BaseVO) customerList.get(i - 1);
            BaseVO entityB = (BaseVO) customerList.get(i);
            Long aId = entityA.getId();
            Long bId = entityB.getId();
            assertTrue(aId > bId);
        }
    }
}
