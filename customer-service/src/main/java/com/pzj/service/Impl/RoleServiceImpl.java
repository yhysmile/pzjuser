package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysMenu;
import com.pzj.base.entity.SysOffice;
import com.pzj.base.entity.SysRole;
import com.pzj.base.entity.SysRoleMenuKey;
import com.pzj.base.entity.SysRoleOfficeUserKey;
import com.pzj.base.entity.SysUserRoleKey;
import com.pzj.base.service.sys.IMenuService;
import com.pzj.base.service.sys.IRoleAuthMenuService;
import com.pzj.base.service.sys.IRoleAuthOfficeService;
import com.pzj.base.service.sys.IRoleService;
import com.pzj.base.service.sys.IUserAuthRoleService;
import com.pzj.core.customer.dao.SysRoleMapper;

@Service("roleService")
public class RoleServiceImpl extends BaseUserServiceImpl<SysRole, SysRoleMapper> implements IRoleService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IRoleAuthMenuService roleAuthMenuService;

    @Autowired
    private IUserAuthRoleService userAuthRoleService;

    @Autowired
    private IRoleAuthOfficeService roleAuthOfficeService;

    @Autowired
    private IMenuService menuService;

    public Long saveRoleAndAuth(SysRole role, List<SysMenu> menuList, boolean isRoleNeedSave, boolean syncOtherRelation) throws Exception {
        try {
            if (role == null) {
                logger.error("方法[RoleService.saveRoleAndAuth],参数role不可以为空");
                return null;
            }

            if (isRoleNeedSave) {
                insertOrUpdate(role);
            }

            if (null != menuList) {
                menuService.insertOrUpdateBatch(menuList);
                
                List<SysRoleMenuKey> relationRecords = resolveRoleAndMenuRelation(role.getId(), menuList);
                
                List<SysRole> roleList = new ArrayList<SysRole>(1);
                roleList.add(role);
                Map<String, String> idsMap = getMapIds(roleList);
                roleAuthMenuService.updateAuthBatch(idsMap, relationRecords, syncOtherRelation);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return role.getId();
    }

    public Long saveRoleAndAuth(List<SysRole> rolesList, List<SysMenu> menuList) {
        Long num = 0l;
        try {
            if (null == rolesList) {
                logger.error("方法[RoleService.saveRoleAndAuth],参数rolesList不可以为空");
                return num;
            }
            
            num += insertOrUpdateBatch(rolesList);

            if (null != menuList) {
                menuService.insertOrUpdateBatch(menuList);
                
                List<SysRoleMenuKey> relationList = resolveRoleAndMenuRelation(null, menuList);

                Map<String, String> idsMap = getMapIds(rolesList);
                num = roleAuthMenuService.updateAuthBatch(idsMap, relationList);
            }
            

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    /**
     * <h3>解析Role与Menu的关系</h3>
     * <p>
     * <ul>
     * <li>如果roleId不为null，将menuList中每个Menu与这个roleId关联创建关系并返回；</li>
     * <li>如果roleId为null，则获取每个Menu的ParentRef属性，它的类型是BaseEntity，如果这个对象有id值，则以这个对象的id与Menu关联创建关系并返回；</li>
     * </ul>
     * 使用时，可以使用ParentRef属性中是不同Role对象，这样Menu可以与不同的Role建立关系。
     * <p>
     * @param roleId Role对象的id
     * @param menuList Menu集合
     * @return
     */
    private List<SysRoleMenuKey> resolveRoleAndMenuRelation(Long roleId, List<SysMenu> menuList) {
        List<SysRoleMenuKey> relationList = new ArrayList<SysRoleMenuKey>();
        String parentIdString = roleId != null ? String.valueOf(roleId) : null;
        for (SysMenu menu : menuList) {
            // 获取Menu的id。
            Long menuId = null;
            if(null == menu || (menuId = menu.getId()) == null || menuId < 1)
                continue;

            // 获取Role的id。
            Long parentId = null;
            BaseEntity parent = menu.getParentRef();
            if(null == parentIdString){
                if(null == parent || (parentId = parent.getId()) == null || parentId < 1)
                    continue;
                parentIdString = parentId.toString();
            }
            
            // 创建SysRoleMenuKey并保存到集合中。
            SysRoleMenuKey key = new SysRoleMenuKey();
            key.setRoleId(parentIdString);
            key.setMenuId(menuId.toString());
            relationList.add(key);
        }
        return relationList;
    }

    public Long delRoleAndAuth(Long roleId, boolean syncUserMenu) {
        Long delNum = 0l;

        try {
            if (roleId == null || roleId < 0) {
                logger.error("方法[RoleService.delRoleAndAuth],参数roleId不可以为空");
                return delNum;
            }
            delNum += delete(roleId);

            String roleId_ = String.valueOf(roleId);

            // 获取角色与用户的关系
            List<SysUserRoleKey> userRoleList = new ArrayList<SysUserRoleKey>();
            SysUserRoleKey userRole = new SysUserRoleKey();
            userRole.setRoleId(roleId_);
            userRoleList.add(userRole);
            delNum += userAuthRoleService.delAuthBatch(userRoleList);

            // 删除角色与菜单的关系
            List<SysRoleMenuKey> roleMenuList = new ArrayList<SysRoleMenuKey>();
            SysRoleMenuKey roleMenu = new SysRoleMenuKey();
            roleMenu.setRoleId(roleId_);
            roleMenuList.add(roleMenu);
            delNum += roleAuthMenuService.delAuthBatch(roleMenuList, syncUserMenu);

            // 删除角色与部门的关系
            List<SysRoleOfficeUserKey> roleOfficeList = new ArrayList<SysRoleOfficeUserKey>();
            SysRoleOfficeUserKey roleOffice = new SysRoleOfficeUserKey();
            roleOffice.setRoleId(roleId_);
            roleOfficeList.add(roleOffice);
            delNum += roleAuthOfficeService.delAuthBatch(roleOfficeList);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return delNum;
    }

    public Map<String, String> getMapIds(List<SysRole> records) {

        if (records == null || records.isEmpty()) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>(1);
        StringBuffer buff = new StringBuffer();
        for (BaseEntity record : records) {
            Long id = record.getId();
            if (id != null) {
                buff.append(id).append(",");
            }
        }
        map.put(UserGlobalParam.UserMapKeyParam.ROLE_MAP_KEY, buff.substring(0, buff.length() - 1));
        return map;
    }

    @Override
    public PageList<SysRole> findByDempartmentRole(Integer start, Integer size, SysRole role) {
        try {
            PageModel pager = new PageModel(start, size);

            List<SysRole> sysRoleList = null;
            int count = mapper.countByOfficeRole(role);
            if (count > 0) {
                sysRoleList = mapper.findByOfficeRole(role, pager);
            }

            PageList<SysRole> pagelist = new PageList<SysRole>(sysRoleList, pager, count);
            return pagelist;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<SysRole> findByDempartment(SysOffice office) throws Exception {
        List<SysRole> sysRoleList = null;
        try {
            sysRoleList = mapper.findByOffice(office);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return sysRoleList;
    }
}
