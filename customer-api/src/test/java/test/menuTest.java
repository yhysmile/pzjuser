package test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.menu.service.MenuUtil;
import org.junit.Test;

import com.pzj.base.common.utils.PageList;
import com.pzj.menu.entity.Menu;
import com.pzj.menu.service.MenuService;
import com.pzj.menu.service.MenuServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class menuTest {

    @Autowired
    private MenuService menuService = new MenuServiceImpl();

    @Autowired
    private MenuUtil menuUtil;

    /*
     * 创建菜单
     */
    @Test
    public void createMenu() throws Exception {

        String ss = menuUtil.toString();

        Menu menu = new Menu();
        menu.setName("测试菜单");
        menu.setHref("/ddd/ddd");
        menu.setTarget("t");
        menu.setIcon("ddd");
        menu.setSort(1);
        menu.setIsShow("1");
        menu.setIsActiviti("1");
        menu.setParentId("0");
        menu.setParentIds("0,1");
        menu.setRemarks("ghjkluio");
        menu.setPosition("jfidsaf");
        menu.setStyle("fdsafdsa");
        menu.setPermission("fdsaf:fdsaf:fdsafa");
        menu.setDelFlag("0");
        menu.setCreateDate(new Date(System.currentTimeMillis()));

        menu.setCreateBy("1");
        menu.setUpdateBy("1");
        Long id = menuService.createMenu(menu);
        System.out.println(">>>createmenu id is : " + id);
    }

    /*
     * 保存菜单
     */
    @Test
    public void saveMenu() throws Exception {
        Menu menu = new Menu();
        menu.setName("test_444");
        menu.setId(3L);
        menu.setHref("222");
        menu.setTarget("222");
        menu.setIcon("222");
        menu.setSort(2);
        menu.setIsShow("2");
        menu.setIsActiviti("2");
        menu.setParentId("2");
        menu.setParentIds("2,1");
        menu.setRemarks("222");
        menu.setPosition("222");
        menu.setStyle("222");
        menu.setPermission("222");
        menu.setDelFlag("1");

        menu.setCreateBy("2");
        menu.setUpdateBy("2");
        Integer num = menuService.saveMenu(menu);
        System.out.println(">>>>save menu num is : " + num);
    }

    /*
     * 根据菜单id获取菜单
     */
    @Test
    public void getMenuById() throws Exception {
        Menu menu = menuService.getMenuById(3000L);
        assertNotNull(menu);
        System.out.println(">>>>getMenubyId is : " + menu.getName());
        System.out.println(JSON.toJSONString(menu));

    }

    /*
     * 获取菜单列表
     */
    @Test
    public void findMenuByParams() throws Exception {
        Menu menu = new Menu();
        menu.setId(4L);
        List<Menu> menulist = menuService.findMenuByParams(menu);
        assertNotNull(menulist);
        for (int i = 0; i < menulist.size(); i++) {
            System.out.println(">>>findMenuByParams is : " + menulist.get(i).getName());
        }
    }

    /*
     * 分页获取菜单列表
     */
    @Test
    public void findMenuPageByParams() throws Exception {
        Menu menu = new Menu();
        // menu.setId(4L);
        PageList<Menu> menulist = menuService.findMenuPageByParams(1, 10, menu);
        assertNotNull(menulist);
        for (int i = 0; i < 1; i++) {
            System.out.println(">>>findMenuPageByParams is : " + menulist.get(i).getName());
        }
    }
 
    /*
     * 逻辑删除菜单
     */
    @Test
    public void deleteMenu() throws Exception {
        Integer num = menuService.deleteMenu(3L);
        System.out.println(">>> deleteNemu num is : " + num);
    }

    /*
     * 物理删除菜单
     */
    @Test
    public void deletePhysicalMenu() throws Exception {
        Integer num = menuService.deletePhysicalMenu(5L);
        System.out.println(">>> deletePhysicalMenu num is : " + num);
    }
    
    @Test
    public void findParentAndChild() throws Exception {
        Long menu = 518L;
        Map<String, Object> result = menuService.findParentAndChild(menu);
        System.out.println(">>> deletePhysicalMenu num is : " + result);
    }
    
    @Test
    public void createMenuList() throws Exception {
        List<Menu> menuList = new ArrayList<Menu>();
        
        {
            Menu menu = new Menu();
            menu.setName("个税改革：减轻工薪阶层个税负担");
            menu.setHref("/ddd/ddd");
            menu.setTarget("t");
            menu.setIcon("ddd");
            menu.setSort(1);
            menu.setIsShow("1");
            menuList.add(menu);
        }
        {
            Menu menu = new Menu();
            menu.setName("大众拒绝赔偿欧洲\"作弊\"车车主 理由奇葩");
            menu.setHref("/ddd/ddd");
            menu.setTarget("t");
            menu.setIcon("ddd");
            menu.setSort(1);
            menu.setIsShow("1");
            menuList.add(menu);
        }
        
        Long result = menuService.createMenu(menuList );
        System.out.println("\r\n\t\t>>> createMenu num is : " + result);
    }
    
    @Test
    public void saveMenuList() throws Exception {
        List<Menu> menuList = new ArrayList<Menu>();
        
        {
            Menu menu = new Menu();
            menu.setId(7L);
            menu.setName("个税改革：减轻工薪阶层个税负担");
            menu.setHref("/ddd/ddd");
            menu.setTarget("t");
            menu.setIcon("ddd");
            menu.setSort(1);
            menu.setIsShow("1");
            menuList.add(menu);
        }
        {
            Menu menu = new Menu();
            menu.setId(8L);
            menu.setName("大众拒绝赔偿欧洲\"作弊\"车车主 理由奇葩");
            menu.setHref("/ddd/ddd");
            menu.setTarget("t");
            menu.setIcon("ddd");
            menu.setSort(1);
            menu.setIsShow("1");
            menuList.add(menu);
        }
        
        Integer result = menuService.saveMenu(menuList );
        System.out.println("\r\n\t\t>>> createMenu num is : " + result);
    }
}
