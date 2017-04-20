package com.pzj.menu.entity;

import static com.pzj.util.ServiceUtil.checkEmpty;
import static com.pzj.util.ServiceUtil.checkNull;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysMenu;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;

public class MenuBuilder extends CommonBuiler<SysMenu, Menu> {

    public static final MenuBuilder AMenuBuilder = new MenuBuilder();

    @Override
    public Menu convertFrom(SysMenu entity) {
        Menu menu = new Menu();
        menu.setCreateBy(entity.getCreateBy());
        menu.setCreateDate(entity.getCreateDate());
        menu.setDelFlag(entity.getDelFlag());
        menu.setHref(entity.getHref());
        menu.setIcon(entity.getIcon());
        menu.setId(entity.getId());
        menu.setIsActiviti(entity.getIsActiviti());
        menu.setIsShow(entity.getIsShow());
        menu.setName(entity.getName());
        menu.setParentId(entity.getParentId());
        menu.setParentIds(entity.getParentIds());
        menu.setPermission(entity.getPermission());
        menu.setPosition(entity.getPosition());
        menu.setRemarks(entity.getRemarks());
        menu.setSort(entity.getSort());
        menu.setStyle(entity.getStyle());
        menu.setTarget(entity.getTarget());
        menu.setUpdateBy(entity.getUpdateBy());
        menu.setUpdateDate(entity.getUpdateDate());
        menu.setDataSource(entity.getDataSource());
        menu.setSupplierId(entity.getSupplierId());
        menu.setCatalog(entity.getCatalog());

        return menu;
    }

    @Override
    public SysMenu convertTo(Menu entity) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setCreateBy(entity.getCreateBy());
        sysMenu.setCreateDate(entity.getCreateDate());
        sysMenu.setDelFlag(entity.getDelFlag());
        sysMenu.setHref(entity.getHref());
        sysMenu.setIcon(entity.getIcon());
        sysMenu.setId(entity.getId());
        sysMenu.setIsActiviti(entity.getIsActiviti());
        sysMenu.setIsShow(entity.getIsShow());
        sysMenu.setName(entity.getName());
        sysMenu.setParentId(entity.getParentId());
        sysMenu.setParentIds(entity.getParentIds());
        sysMenu.setPermission(entity.getPermission());
        sysMenu.setPosition(entity.getPosition());
        sysMenu.setRemarks(entity.getRemarks());
        sysMenu.setSort(entity.getSort());
        sysMenu.setStyle(entity.getStyle());
        sysMenu.setTarget(entity.getTarget());
        sysMenu.setUpdateBy(entity.getUpdateBy());
        sysMenu.setUpdateDate(entity.getUpdateDate());
        sysMenu.setDataSource(entity.getDataSource());
        sysMenu.setSupplierId(entity.getSupplierId());
        sysMenu.setCatalog(entity.getCatalog());
        return sysMenu;
    }

    @Override
    protected void validtionValueWhenCreate(Menu entity, CommonCheck check)
            throws ServiceException {
        checkNull(entity, "Menu不能为null");

        checkEmpty(entity.getName(), "Menu.Name不能为空");
        checkEmpty(entity.getParentId(), "Menu.ParentId不能为空");
        checkEmpty(entity.getParentIds(), "Menu.ParentIds不能为空");
        checkEmpty(entity.getIsShow(), "Menu.IsShow不能为空");
        checkEmpty(entity.getDelFlag(), "Menu.getDelFlag不能为空");
    }

    @Override
    protected void customValueWhenCreate(Menu entity) {
        if (null == entity.getCreateDate()) {
            entity.setCreateDate(new Date());
        }
        if (StringUtils.isEmpty(entity.getDelFlag())) {
            entity.setDelFlag("1");
        }
        if (StringUtils.isBlank(entity.getParentId())) {
            entity.setParentId("0");
        }
        if (StringUtils.isBlank(entity.getParentIds())) {
            entity.setParentIds("0");
        }
        if (StringUtils.isBlank(entity.getIsShow())) {
            entity.setIsShow("1");
        }
        if (null == entity.getSort()) {
            entity.setSort(0);
        }
    }

    @Override
    protected void customValueWhenModify(Menu entity) {
        // TODO Auto-generated method stub
        
    }

}
