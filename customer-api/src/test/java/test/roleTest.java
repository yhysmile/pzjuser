package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.pzj.base.common.global.UserGlobalDict.RoleType;
import com.pzj.base.common.utils.PageList;
import com.pzj.menu.entity.Menu;
import com.pzj.role.entity.Role;
import com.pzj.role.service.RoleService;
import com.pzj.role.service.RoleServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class roleTest {

    @Autowired
    private RoleService roleService = null;

    @Test
    public void querCustomeasdasdasd() throws Exception {
        Role r = new Role();
        r.setName("测试角色");

        PageList<Role> res = roleService.findByDempartmentRole(0, 20, r);

        assertNotNull(res);

        System.out.println("数量：：" + res.getResultList().size());
    }

    /*
     * 创建角色
     */
    @Test
    public void createRole() throws Exception {
        Role role = new Role();
 
        role.setName("qqqqq测试角色");
        // role.setType(RoleType.SUPPLIER);
        role.setCreateBy("admin2");
        role.setUpdateBy("admin2");
        role.setDelFlag("1");
        role.setCreateDate(new Date(System.currentTimeMillis()));
        role.setRemarks("111");
        role.setDataScope("1");

        Menu menu = new Menu();
        //menu.setId(1L);
        menu.setName("1ffffffffffffff");
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
        menu.setUpdateBy("1");
        List<Menu> menulist = new ArrayList<Menu>();
        menulist.add(menu);
        role.setMlist(menulist);
        
        Long id = roleService.createRole(role);
        System.out.println(">>>>createrole id is : " + id);
    }

    /*
     * 编辑保存角色
     */
    @Test
    public void saveRole() throws Exception {
        Role role = new Role();
        role.setId(2215520224936268L);
        role.setName("高级JAVA工程师");
        role.setType(RoleType.SUPPLIER);
        role.setCreateBy("admin222");
        role.setUpdateBy("admin222");
        role.setDelFlag("1");
        role.setRemarks("2222");
        
        List<Menu> menulist = new ArrayList<Menu>();

        {
            Menu menu = new Menu();
            menu.setId(499L);
            menu.setName("高级JAVA工程师工程师");
            menu.setHref("/aa");
            menu.setTarget("aa");
            menu.setIcon("aa");
            menu.setSort(2);
            menu.setIsShow("1");
            menu.setIsActiviti("1");
            menu.setParentId("1");
            menu.setParentIds("1,1");
            menu.setRemarks("test");
            menu.setPosition("test");
            menu.setStyle("test");
            menu.setPermission("fdsaf:fdsaf:fdsafa");
            menu.setDelFlag("1");
            menu.setCreateBy("1");
            menu.setUpdateBy("1");
            menulist.add(menu);
        }
        
        {
            Menu menu = new Menu();
            menu.setId(498L);
            menu.setName("高级JAVA工程师JAVA");
            menu.setHref("/aa");
            menu.setTarget("aa");
            menu.setIcon("aa");
            menu.setSort(2);
            menu.setIsShow("1");
            menu.setIsActiviti("1");
            menu.setParentId("1");
            menu.setParentIds("1,1");
            menu.setRemarks("test");
            menu.setPosition("test");
            menu.setStyle("test");
            menu.setPermission("fdsaf:fdsaf:fdsafa");
            menu.setDelFlag("1");
            menu.setCreateBy("1");
            menu.setUpdateBy("1");
            menulist.add(menu);
        }
        
        {
            Menu menu = new Menu();
            menu.setId(499L);
            menu.setName("高级JAVA工程师C++");
            menu.setHref("/aa");
            menu.setTarget("aa");
            menu.setIcon("aa");
            menu.setSort(2);
            menu.setIsShow("1");
            menu.setIsActiviti("1");
            menu.setParentId("1");
            menu.setParentIds("1,1");
            menu.setRemarks("test");
            menu.setPosition("test");
            menu.setStyle("test");
            menu.setPermission("fdsaf:fdsaf:fdsafa");
            menu.setDelFlag("1");
            menu.setCreateBy("1");
            menu.setUpdateBy("1");
            menulist.add(menu);
        }
        role.setMlist(menulist);
        
        Long id = roleService.saveRole(role);
        System.out.println(">>>>saverole id is : " + id);
    }

    /*
     * 编辑保存角色
     */
    @Test
    public void saveRoleMenu() throws Exception {

        Role role = new Role();
        role.setId(2215520224935937L);
        role.setName("往来邮件");
        role.setCreateBy("admin22");
        role.setUpdateBy("admin22");


        Menu menu1 = new Menu();
        menu1.setId(551L);

        Menu menu2 = new Menu();
        menu2.setId(552L);
        
        Menu menu3 = new Menu();
        menu3.setId(553L);
        
        List<Menu> menulist = new ArrayList<Menu>();
        menulist.add(menu1);
        menulist.add(menu2);
        menulist.add(menu3);
        
        role.setMlist(menulist);
        
        Long id = roleService.saveRoleMenu(role);
        System.out.println(">>>> saveRolemenu id is : " + id);
    }

    /*
     * 获取角色
     */
    @Test
    public void getRoleById() throws Exception {
        Long roleId = 310L;
        Role role = roleService.getRoleById(roleId);
        assertNotNull(role);
        assertNotNull(role.getMlist());
        
        System.out.println(">>>>getRoleById is : " + role.getName());
    }

    /*
     * 获取角色列表
     */
    @Test
    public void findRoleByParams() throws Exception {
        Role role = new Role();
        //role.setId(35L);
        role.setType(RoleType.SUPPLIER);
        List<Role> rolelist = roleService.findRoleByParams(role);
        assertNotNull(rolelist);
        for (int i = 0; i < rolelist.size(); i++) {
            System.out.println(">>>>findRoleByParams is : " + rolelist.get(i).getName());
        }
    }

    /*
     * 获取角色及关系列表
     */
    @Test
    public void findRoleAuthByParams() throws Exception {
        Role role = new Role();
        role.setId(573L);
        //role.setType(RoleType.SUPPLIER);
        List<Role> rolelist = roleService.findRoleAuthByParams(role);
        assertNotNull(rolelist);
        assertEquals(rolelist.size(), 2);
        /*for (int i = 0; i < rolelist.size(); i++) {
            System.out.println(">>>>findRoleAuthByParams is : " + rolelist.get(i).getName() + ", menulist is : " + rolelist.get(i).getMlist().get(i).getName());
        }*/
    }

    /*
     * 分页获取角色列表
     */
    @Test
    public void findRolePageByParams() throws Exception {
        Role role = new Role();
        role.setId(35L);
        PageList<Role> rolelist = roleService.findRolePageByParams(0, 1, role);
        assertNotNull(rolelist);
        for (int i = 0; i < 1; i++) {
            System.out.println(">>>>findRolePageByParams is : " + rolelist.get(i).getName());
        }
    }

    /*
     * 分页获取角色及关系列表
     */
    @Test
    public void findRoleAuthPageByParams() throws Exception {
        Role role = new Role();
        role.setId(314L);
        PageList<Role> rolelist = roleService.findRoleAuthPageByParams(0, 1, role);
        assertNotNull(rolelist);
        for (int i = 0; i < 1; i++) {
            System.out.println(">>>>findRoleAuthPageByParams is : " + rolelist.get(i).getName() + ", menulist is : "
                    + rolelist.get(i).getMlist().get(i).getName());
        }
    }

    /*
     * 获取角色菜单
     */
    @Test
    public void getRoleMenuList() throws Exception {
        Role role = new Role();
        role.setId(314L);
        List<Role> rl = new ArrayList<Role>();
        rl.add(role);
        List<Role> rolelist = roleService.getRoleMenuList(rl);
        assertNotNull(rolelist);
        for (int i = 0; i < rolelist.size(); i++) {
            System.out.println(">>>>getRoleMenuList is : " + rolelist.get(i).getName() + ", menulist is : " + rolelist.get(i).getMlist().get(i).getName());
        }
    }

    /*
     * 逻辑删除角色
     */
    @Test
    public void deleteRole() throws Exception {
        Integer num = roleService.deleteRole(2L);
        System.out.println(">>>>deleteRole num is : " + num);
    }

    /*
     * 物理删除角色
     */
    @Test
    public void deletePhysicalRole() throws Exception {
        Integer num = roleService.deletePhysicalRole(35L);
        System.out.println(">>>>deletePhysicalRole num is : " + num);
    }
    
    @Test
    public void findByDempartmentRole() throws Exception {
        Role role = new Role();
        //role.setName("nn");
        role.setSupplierId(2216619741564208L);
        role.setCreateBy("2216619741564208");
        PageList<Role> num = roleService.findByDempartmentRole(1, 50, role);
        System.out.println(">>>>deletePhysicalRole num is : " + num);
    }
    
    @Test
    public void saveRoleMenuSyncOther() throws Exception {
        Role role = new Role();
        //role.setId(2215520224937086L);
        role.setName("cxvxcvcxxcvxvcx");
        
        List<Menu> menulist = new ArrayList<Menu>();

        {
            Menu menu = new Menu();
            menu.setName("法人为宋超工程师123");
            menu.setHref("/aa");
            menulist.add(menu);
        }
        
        {
            Menu menu = new Menu();
            menu.setName("微触科技前身师JAVA456");
            menu.setHref("/aa");
            menulist.add(menu);
        }
        
        {
            Menu menu = new Menu();
            menu.setName("在获得投资师C++789");
            menu.setHref("/aa");
            menulist.add(menu);
        }
        role.setMlist(menulist);
        
        roleService.saveRoleMenuSyncOther(role);

        //roleService.saveRole(role);
    }

}
