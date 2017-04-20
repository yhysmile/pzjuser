package com.pzj.role.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysMenu;
import com.pzj.base.entity.SysOffice;
import com.pzj.base.entity.SysRole;
import com.pzj.department.entity.Department;
import com.pzj.menu.entity.Menu;
import com.pzj.menu.entity.MenuForeachHandle;
import com.pzj.role.entity.Role;
import com.pzj.role.entity.RoleForeachHandle;
import com.pzj.util.CommonServiceImpl;

@Service
public class RoleServiceImpl extends CommonServiceImpl implements RoleService {
    @Autowired
    private RoleUtil roleUtil = null;

    private static class RoleAndMenuBean {
        public List<SysMenu> sysMenuList;
        public List<SysRole> sysRoleList;
    }

    protected Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    public Long createRole(Role role) throws Exception {
        return saveRoleMenuSyncOther(role, false);
    }

    /**
     * 物理删除角色，删除角色与用户，部门，菜单的关系
     * 
     * @param roleId
     *            角色主键id
     * @return
     */
    public Integer deletePhysicalRole(Long roleId) throws Exception {
        return deletePhysicalRoleSyncOther(roleId, false);
    }

    public Integer deletePhysicalRoleSyncOther(Long roleId) throws Exception {
        return deletePhysicalRoleSyncOther(roleId, true);
    }

    private Integer deletePhysicalRoleSyncOther(Long roleId, boolean syncOther) throws Exception {
        try {
            if (roleId == null || roleId == 0)
                return 0;
            
            iroleService.delRoleAndAuth(roleId, syncOther);
    
            return iroleService.delete(roleId);
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    /**
     * 逻辑删除角色
     * 
     * @param roleId
     *            角色主键id
     * @return
     */
    public Integer deleteRole(Long roleId) throws Exception {
        try {
            if (roleId == null || roleId == 0)
                return 0;
            SysRole sysRole = new SysRole();
            sysRole.setId(roleId);
            sysRole.setDelFlag(String.valueOf(GlobalParam.FLAG.del()));
    
            int i = iroleService.updateByPrimaryKey(sysRole);
            return i;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    /**
     * 根据部门ID查询部门的角色
     * 
     * @param department
     * @return
     * @throws Exception
     */
    public List<Role> findByDempartment(Department department) throws Exception {
        if (null == department || null == department.getId()) {
            return null;
        }
    
        SysOffice sysoffice = Department.changeTDepartment(department);
        sysoffice.setParentId("");
        List<SysRole> sysofficeList = iroleService.findByDempartment(sysoffice);
    
        List<Role> result = Role.sList2CList(sysofficeList);
    
        return result;
    }

    /**
     * 根据部门名称和角色名称查询角色
     * 
     * 参数role中可以设置角色名name、部门名alias查询角色。
     * 
     * 查询时通过部门信息中的name，部门与角色的关联，以及角色信息中的name，查询符合条件的角色信息，返回的角色信息中的alias为部门名称。
     * 
     * 
     * @param role
     * @return
     */
    @Override
    public PageList<Role> findByDempartmentRole(Integer start, Integer size, Role role) throws Exception {
        /*
         * if (null == role || StringUtils.isEmpty(role.getDataSource())) { return null; }
         */
        if (null == role) {
            return null;
        }
    
        if (!StringUtils.isEmpty(role.getAlias())) {
            role.setAlias(role.getAlias() + "%");
        }
    
        if (!StringUtils.isEmpty(role.getName())) {
            role.setName(role.getName() + "%");
        }
    
        // ad
        SysRole sysrole = Role.changeTSysRole(role);
    
        PageList<SysRole> sysroleList = iroleService.findByDempartmentRole(start, size, sysrole);
    
        PageList<Role> result = new PageList<Role>();
    
        if (sysroleList == null || sysroleList.isEmpty()) {
            result.setResultList(new ArrayList<Role>(0));
            return result;
        } else {
            result.setPageBean(sysroleList.getPageBean());
            List<Role> rs = Role.sList2CList(sysroleList.getResultList());
            result.setResultList(rs);
        }
    
        return result;
    }

    public List<Role> findRoleAuthByParams(Role role) throws Exception {
        try {
            List<SysRole> sysRoles = null;
            List<Role> roles = null;
    
            SysRole sysRole = null;
            if (role != null) {
                sysRole = Role.changeTSysRole(role);
            }
    
            // 查询
            sysRoles = iroleService.findListByParams(sysRole);
    
            if (sysRoles != null && !sysRoles.isEmpty()) {
                roles = Role.sList2CList(sysRoles);
                roleUtil.setRoleMenuList(roles);
    
            }
            return roles;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    public PageList<Role> findRoleAuthPageByParams(Integer pageNo, Integer pageSize, Role role) throws Exception {
        try {
            PageList<SysRole> rolePageList = null;
    
            SysRole sysRole = null;
            if (role != null) {
                sysRole = Role.changeTSysRole(role);
            }
    
            // 查询
            PageModel pm = new PageModel(pageNo, pageSize);
            rolePageList = iroleService.queryPageByParamMap(pm, sysRole);
    
            PageList<Role> result = new PageList<Role>();
            result.setPageBean(rolePageList.getPageBean());
    
            if (rolePageList == null || rolePageList.isEmpty()) {
                result.setResultList(new ArrayList<Role>());
                return result;
            }
    
            // 转化
            List<Role> roleList = Role.sList2CList(rolePageList.getResultList());
    
            // 给角色列表封装菜单
            roleUtil.setRoleMenuList(roleList);
    
            result.setResultList(roleList);
            return result;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    public List<Role> findRoleByParams(Role role) throws Exception {
        try {
            List<SysRole> sysRoles = null;
            List<Role> roles = null;
    
            SysRole sysRole = null;
            if (role != null) {
                sysRole = Role.changeTSysRole(role);
            }
    
            // 查询
            sysRoles = iroleService.findListByParams(sysRole);
    
            if (sysRoles != null && !sysRoles.isEmpty()) {
                roles = Role.sList2CList(sysRoles);
    
            }
            return roles;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    public PageList<Role> findRolePageByParams(Integer pageNo, Integer pageSize, Role role) throws Exception {
        try {
            PageList<SysRole> rolePageList = null;
            List<Role> roleList = null;
    
            SysRole sysRole = null;
            if (role != null) {
                sysRole = Role.changeTSysRole(role);
            }
    
            // 查询
            PageModel pm = new PageModel(pageNo, pageSize);
            rolePageList = iroleService.queryPageByParamMap(pm, sysRole);
    
            PageList<Role> result = new PageList<Role>();
            result.setPageBean(rolePageList.getPageBean());
    
            if (rolePageList == null || rolePageList.isEmpty()) {
                result.setResultList(new ArrayList<Role>());
                return result;
            }
    
            // 转化
            roleList = Role.sList2CList(rolePageList.getResultList());
    
            result.setResultList(roleList);
            return result;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    public Role getRoleById(Long roleId) throws Exception {
        try {
            Role role = null;
            if (roleId == null || roleId < 1) {
                return null;
            }
            SysRole sysRole = iroleService.getById(roleId);
            if (sysRole != null) {
                role = Role.sysRole2Role(sysRole);
            }
            return role;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }

    }

    /**
     * 该角色及角色的菜单列表
     * 
     * @param roles
     *            角色主键Id
     * 
     * @return 角色实体
     */
    public List<Role> getRoleMenuList(List<Role> roles) throws Exception {
        try {
            if (roles == null || roles.isEmpty()) {
                return null;
            }

            // 查询角色
            String roleIds = roleUtil.getRoleIds(roles);
            roles = roleUtil.getRoleListByRoleIds(roleIds);

            if (roles != null && !roles.isEmpty()) {
                roleUtil.setRoleMenuList(roles);
            }

            return roles;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    private RoleAndMenuBean resolveRoleAndMenuBean(List<Role> roleList) throws Exception{
        int size = 0;
        
        for (Iterator<Role> iterator = roleList.iterator(); iterator.hasNext();) {
            Role role = iterator.next();
            List<Menu> list = role.getMlist();
            size += (null != list?list.size():0);
        }

        final List<SysMenu> sysMenuList = new ArrayList<SysMenu>(size);
        
        List<SysRole> sysRoleList = Role.cList2SList(roleList, new RoleForeachHandle() {
            
            @Override
            public void handle(final SysRole sysRole, Role role) {
                try {
                    List<SysMenu> mlist = Menu.cList2SList(role.getMlist(), new MenuForeachHandle() {
                        
                        @Override
                        public void handle(SysMenu sysMenu, Menu menu) {
                            sysMenu.setParentRef(sysRole);
                        }
                    });
                    sysMenuList.addAll(mlist);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
        
        RoleAndMenuBean ret = new RoleAndMenuBean();
        ret.sysMenuList = sysMenuList;
        ret.sysRoleList = sysRoleList;
        
        return ret;
    }

    public Long saveRole(Role role) throws Exception {
        return saveRoleMenuSyncOther(role, false);
    }

    @Override
    public int saveRoleMenu(List<Role> roleList) throws Exception {
        try {
            if (roleList == null || roleList.size() < 1) {
                return 0;
            }
            
            RoleAndMenuBean rm = resolveRoleAndMenuBean(roleList);
    
            iroleService.saveRoleAndAuth(rm.sysRoleList, rm.sysMenuList);
    
            return 0;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    public Long saveRoleMenu(Role role) throws Exception {
        return saveRoleMenuSyncOther(role, false);
    }

    @Override
    public Long saveRoleMenuSyncOther(Role role) throws Exception {
        return saveRoleMenuSyncOther(role, true);
    }
    
    private Long saveRoleMenuSyncOther(Role role, boolean syncOtherRelation) throws Exception {
        try {
            if (role == null)
                return null;

            SysRole saveRole = null;
            
            if (role.getId() == null) {
                saveRole = Role.createNewSysRole(role);
            } else {
                saveRole =Role.changeTSysRole(role);
            }
            
            // 获取前台角色的菜单列表
            List<SysMenu> saveMenuList = null;
            List<Menu> menuList = role.getMlist();
            
            if (null != menuList) {
                saveMenuList = new ArrayList<>(menuList.size());
                if (saveMenuList.size() == 0){
                    for (Iterator<Menu> iterator = menuList.iterator(); iterator.hasNext();) {
                        Menu menu = iterator.next();
                        SysMenu sysmenu = null;
                        if (menu.getId() == null) {
                            sysmenu = Menu.createNewSysMenu(menu);
                        } else {
                            sysmenu = Menu.changeTSysMenu(menu);
                        }
                        sysmenu.setParentRef(saveRole);
                        saveMenuList.add(sysmenu);
                    }
                }
            }

            Long num = iroleService.saveRoleAndAuth(saveRole, saveMenuList, true, syncOtherRelation);
            role.setId(num);
            return num;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }
}