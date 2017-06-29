package com.pzj.service.Impl;

import java.util.List;
import java.util.Map;

import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.dao.SysUserMapper;
import com.pzj.core.customer.utils.UserConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.entity.SysMenu;
import com.pzj.base.service.sys.IMenuService;
import com.pzj.core.customer.dao.SysMenuMapper;

import javax.annotation.Resource;

@Service("menuService")
public class MenuServiceImpl extends
        BaseUserServiceImpl<SysMenu, SysMenuMapper> implements IMenuService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserConfig userConfig;

    @Resource
    private SysUserMapper userMapper = null;

    @Autowired
    private SysMenuMapper menuMapper;

    /**
     * 根据主键集合串Ids查询菜单列表
     * 
     * @param IdsMap
     *            菜单Ids
     * 
     */
    public List<SysMenu> findSysMenuKeyByIds(Map<String, String> IdsMap) {
        List<SysMenu> sysMenuList = null;
        try {
            sysMenuList = menuMapper.findByIdsMap(IdsMap);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return sysMenuList;
    }

    @Override
    public List<SysMenu> findMenuOfUser(Long userId) {
        List<SysMenu> menus = menuMapper.selectByUser(userId);

        if (menus != null && !menus.isEmpty()){
            SysUser user = userMapper.selectByPrimaryKey(userId);

            if (user == null){
                return null;
            }

            String token = user.getBieeToken();

            if (token == null){
                return null;
            }

            for (SysMenu menu : menus){
                String catalog = menu.getCatalog();
                if (catalog != null && "10".equals(catalog)){
                    String href = menu.getHref();
                    logger.info("old : " + href);
                    href = href.replace("${biServerAddress}", userConfig.getBiServerAddress())
                            .replace("${userId}", userId.toString())
                            .replace("${token}", token);
                    logger.info("new : " + href);
                    menu.setHref(href);
                }
            }
        }

        return menus;
    }


}
