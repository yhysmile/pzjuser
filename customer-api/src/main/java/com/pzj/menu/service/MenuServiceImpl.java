package com.pzj.menu.service;

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
import com.pzj.base.entity.SysMenu;
import com.pzj.base.service.sys.IMenuService;
import com.pzj.menu.entity.Menu;
import com.pzj.menu.entity.MenuBuilder;

@Service
public class MenuServiceImpl implements MenuService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IMenuService imenuService = null;

    private MenuBuilder menuBuilder = new MenuBuilder();

    public Long createMenu(Menu menu) throws Exception {
        try {
            if (menu == null)
                return null;
            SysMenu sysMenu = Menu.createNewSysMenu(menu);
            Long menuId = imenuService.insert(sysMenu);
            menu.setId(menuId);
            return menuId;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    public Integer saveMenu(Menu menu) throws Exception {
        try {
            if (menu == null)
                return 0;
            SysMenu sysMenu = Menu.createNewSysMenu(menu);
            Long menuId = imenuService.insertOrUpdate(sysMenu);
            menu.setId(menuId);
            
            if (menuId > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    public Menu getMenuById(Long id) throws Exception {
        try {
            Menu menu = null;
            if (id == null || id < 1) {
                return null;
            }
            SysMenu sysMenu = imenuService.getById(id);
            if (sysMenu != null) {
                menu = Menu.sysMenu2Menu(sysMenu);
            }
            return menu;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    public List<Menu> findMenuByParams(Menu menu) throws Exception {
        try {
            List<SysMenu> sysMenuList = null;
            List<Menu> menuList = null;

            SysMenu sysMenu = null;
            if (menu != null) {
                sysMenu = Menu.changeTSysMenu(menu);
            }

            // 查询
            sysMenuList = imenuService.findListByParams(sysMenu);

            // 转化
            if (sysMenuList != null && !sysMenuList.isEmpty()) {
                menuList = Menu.sList2CList(sysMenuList);
            }

            return menuList;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }

    }

    public PageList<Menu> findMenuPageByParams(Integer pageNo, Integer pageSize, Menu menu) throws Exception {
        try {
            PageList<SysMenu> menuPageList = null;

            SysMenu sysMenu = null;
            if (menu != null) {
                sysMenu = Menu.changeTSysMenu(menu);
            }

            // 查询
            PageModel pm = new PageModel(pageNo, pageSize);
            menuPageList = imenuService.queryPageByParamMap(pm, sysMenu);

            PageList<Menu> result = new PageList<Menu>();
            result.setPageBean(menuPageList.getPageBean());

            if (menuPageList == null || menuPageList.isEmpty()) {
                result.setResultList(new ArrayList<Menu>());
                return result;
            }

            // 转化
            List<SysMenu> sysMenuList = menuPageList.getResultList();
            List<Menu> menuList = Menu.sList2CList(sysMenuList);

            result.setResultList(menuList);

            return result;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }

    }

    public Integer deleteMenu(Long menuId) throws Exception {
        try {
            if (menuId == null || menuId == 0)
                return 0;
            SysMenu sysMenu = new SysMenu();
            sysMenu.setId(menuId);
            sysMenu.setDelFlag(String.valueOf(GlobalParam.FLAG.del()));
            return Integer.valueOf(String.valueOf(imenuService.updateByPrimaryKey(sysMenu)));
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    public Integer deletePhysicalMenu(Long menuId) throws Exception {
        try {
            if (menuId == null || menuId == 0)
                return 0;

            return imenuService.delete(menuId);
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    public Map<String, Object> findParentAndChild(Long menuId) throws Exception {
        if (null == menuId) {
            return null;
        }

        SysMenu currentMenu = imenuService.getById(menuId);

        if (null == currentMenu) {
            return null;
        }

        SysMenu parentMenu = null;
        List<SysMenu> childMenu = null;

        String parentId = currentMenu.getParentId();
        if (parentId != null && !parentId.equals('0')) {
            parentMenu = imenuService.getById(Long.valueOf(parentId));
        }

        SysMenu menu = new SysMenu();
        menu.setParentId(currentMenu.getId().toString());
        childMenu = imenuService.findListByParams(menu);

        HashMap<String, Object> result = new HashMap<String, Object>(2);
        
        if (null != parentMenu) {
            result.put("parent", Menu.sysMenu2Menu(parentMenu));
        }
        if (null != childMenu) {
            result.put("childs", Menu.sList2CList(childMenu));
        }

        return result;

    }

    @Override
    public Long createMenu(List<Menu> menuList) throws Exception {
        if (null == menuList || menuList.isEmpty()) {
            return null;
        }
        
        List<SysMenu> sysMenList = menuBuilder.buildNew(menuList);
        
        Long i = imenuService.insertBatch(sysMenList);
        return i;
    }

    @Override
    public Integer saveMenu(List<Menu> menuList) throws Exception {
        if (null == menuList || menuList.isEmpty()) {
            return null;
        }
        
        List<SysMenu> sysMenList = menuBuilder.buildExisted(menuList);
        
        Integer i = imenuService.updateBatchByPrimaryKey(sysMenList);
        return i;
    }

}
