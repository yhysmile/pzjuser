package com.pzj.menu.entity;

import static com.pzj.menu.entity.MenuBuilder.AMenuBuilder;
import static com.pzj.util.ServiceUtil.checkEmpty;
import static com.pzj.util.ServiceUtil.checkLengthMax;
import static com.pzj.util.ServiceUtil.checkNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.common.ServiceException;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.SysMenu;
import com.pzj.util.CommonEntity;

/**
 * 菜单信息实体类
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-8-27 下午3:40:59
 */
public class Menu extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1655112114467437348L;

    /** 名称 */
    private String name;

    /** 地址 */
    private String href;

    /** 父id */
    private String parentId;

    /** 所有父级编号 */
    private String parentIds;

    /** 打开方式 */
    private String target;

    /** 图标 */
    private String icon;

    /** 排序（升序） */
    private Integer sort;

    /** 是否在菜单中显示 */
    private String isShow;

    /** 是否同步工作流 */
    private String isActiviti;

    /** 权限标识 */
    private String permission;

    /** 创建者 */
    private String createBy;

    /** 更新者 */
    private String updateBy;

    /** 备注信息 */
    private String remarks;

    /** 位置 */
    private String position;

    /** 样式 */
    private String style;

    /** 数据源 */
    private String dataSource;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 分类
     */
    private String catalog;

    /**
     * 获取名称
     * 
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     * 
     * @param name
     *            名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取地址
     * 
     * @return href 地址
     */
    public String getHref() {
        return href;
    }

    /**
     * 设置地址
     * 
     * @param href
     *            地址
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 获取父id
     * 
     * @return parentId 父id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父id
     * 
     * @param parentId
     *            父id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取所有父级编号
     * 
     * @return parentIds 所有父级编号
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置所有父级编号
     * 
     * @param parentIds
     *            所有父级编号
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * 获取打开方式
     * 
     * @return target 打开方式
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置打开方式
     * 
     * @param target
     *            打开方式
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 获取图标
     * 
     * @return icon 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     * 
     * @param icon
     *            图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取排序（升序）
     * 
     * @return sort 排序（升序）
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序（升序）
     * 
     * @param sort
     *            排序（升序）
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否在菜单中显示
     * 
     * @return isShow 是否在菜单中显示
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 设置是否在菜单中显示
     * 
     * @param isShow
     *            是否在菜单中显示
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取是否同步工作流
     * 
     * @return isActiviti 是否同步工作流
     */
    public String getIsActiviti() {
        return isActiviti;
    }

    /**
     * 设置是否同步工作流
     * 
     * @param isActiviti
     *            是否同步工作流
     */
    public void setIsActiviti(String isActiviti) {
        this.isActiviti = isActiviti;
    }

    /**
     * 获取权限标识
     * 
     * @return ermission 权限标识
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限标识
     * 
     * @param ermission
     *            权限标识
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取创建者
     * 
     * @return createBy 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     * 
     * @param createBy
     *            创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取更新者
     * 
     * @return updateBy 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     * 
     * @param updateBy
     *            更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取备注信息
     * 
     * @return remarks 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     * 
     * @param remarks
     *            备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取位置
     * 
     * @return position 位置
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置位置
     * 
     * @param position
     *            位置
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取样式
     * 
     * @return style 样式
     */
    public String getStyle() {
        return style;
    }

    /**
     * 设置样式
     * 
     * @param style
     *            样式
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * 设置数据源
     * 
     * @return
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 获取数据源
     * 
     * @param dataSource
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取供应商ID
     * 
     * @return supplierId 供应商ID
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * 设置供应商ID
     * 
     * @param supplierId
     *            供应商ID
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * 仅转化对应关系
     * 
     * @param customer
     * @return
     * @throws Exception
     */
    public static SysMenu changeTSysMenu(Menu menu) throws Exception {
        return AMenuBuilder.convertTo(menu);
    }

    public static SysMenu createNewSysMenu(Menu menu) throws Exception {
        checkNull(menu, "Menu不能为null");
        if (null == menu.getId()) {
            // 设置默认参数
            setDefaultData(menu);

            // 验证
            validData(menu);

            // 转换
            return changeTSysMenu(menu);
        } else {
            // 转换
            return changeTSysMenu(menu);
        }

    }

    public static Menu sysMenu2Menu(SysMenu sysMenu) throws Exception {
        return AMenuBuilder.convertFrom(sysMenu);
    }

    public static List<SysMenu> cList2SList(List<Menu> menuList)
            throws Exception {
        List<SysMenu> sysMenuList = null;
        if (menuList != null) {
            sysMenuList = new ArrayList<SysMenu>();
            for (Menu menu : menuList) {
                Long menuId = menu.getId();
                SysMenu sysMenu = null;
                if (menuId == null || menuId < 1) {
                    sysMenu = createNewSysMenu(menu);
                } else {
                    sysMenu = changeTSysMenu(menu);
                }
                sysMenuList.add(sysMenu);
            }
        }
        return sysMenuList;
    }

    public static List<SysMenu> cList2SList(List<Menu> menuList,
            MenuForeachHandle handle) throws Exception {
        List<SysMenu> sysMenuList = null;
        if (menuList != null) {
            sysMenuList = new ArrayList<SysMenu>();
            for (Menu menu : menuList) {
                Long menuId = menu.getId();
                SysMenu sysMenu = null;
                if (menuId == null || menuId < 1) {
                    sysMenu = createNewSysMenu(menu);
                } else {
                    sysMenu = changeTSysMenu(menu);
                }
                handle.handle(sysMenu, menu);
                sysMenuList.add(sysMenu);
            }
        }
        return sysMenuList;
    }

    public static List<Menu> sList2CList(List<SysMenu> sysMenuList)
            throws Exception {
        List<Menu> menuList = null;
        if (sysMenuList != null) {
            menuList = new ArrayList<Menu>();
            for (SysMenu sysMenu : sysMenuList) {
                Menu menu = sysMenu2Menu(sysMenu);
                menuList.add(menu);
            }
        }
        return menuList;
    }

    /**
     * 验证数据
     * 
     * @param menu
     * @throws ServiceException
     */
    public static void validData(Menu menu) throws ServiceException {
        checkNull(menu, "Menu不能为null");

        checkEmpty(menu.getName(), "Menu.Name不能为空");
        checkEmpty(menu.getParentId(), "Menu.ParentId不能为空");
        checkEmpty(menu.getParentIds(), "Menu.ParentIds不能为空");
        checkEmpty(menu.getIsShow(), "Menu.IsShow不能为空");
        checkEmpty(menu.getDelFlag(), "Menu.getDelFlag不能为空");
        checkNull(menu.getSupplierId(), "menu.SupplierId不能为null");
    }

    public static void validDataAll(Menu menu) throws ServiceException {
        validData(menu);

        checkLengthMax(menu.getName(), 100, "Menu.Name超过最大长度，最大为100");
        checkLengthMax(menu.getHref(), 255, "Menu.Name超过最大长度，最大为255");
        checkLengthMax(menu.getParentId(), 64, "Menu.Name超过最大长度，最大为64");
        checkLengthMax(menu.getParentIds(), 2000, "Menu.Name超过最大长度，最大为2000");
        checkLengthMax(menu.getTarget(), 20, "Menu.Name超过最大长度，最大为20");
        checkLengthMax(menu.getIcon(), 100, "Menu.Name超过最大长度，最大为100");
        checkLengthMax(menu.getIsShow(), 1, "Menu.Name超过最大长度，最大为1");
        checkLengthMax(menu.getIsActiviti(), 1, "Menu.Name超过最大长度，最大为1");
        checkLengthMax(menu.getPermission(), 200, "Menu.Name超过最大长度，最大为200");
        checkLengthMax(menu.getCreateBy(), 64, "Menu.Name超过最大长度，最大为64");
        checkLengthMax(menu.getUpdateBy(), 64, "Menu.Name超过最大长度，最大为64");
        checkLengthMax(menu.getRemarks(), 255, "Menu.Name超过最大长度，最大为255");
        checkLengthMax(menu.getDelFlag(), 1, "Menu.Name超过最大长度，最大为1");
        checkLengthMax(menu.getPosition(), 255, "Menu.Name超过最大长度，最大为255");
        checkLengthMax(menu.getStyle(), 255, "Menu.Name超过最大长度，最大为255");
    }

    protected static void setDefaultData(Menu menu) {
        if (null == menu.getCreateDate()) {
            menu.setCreateDate(new Date());
        }
        if (StringUtils.isEmpty(menu.getDelFlag())) {
            menu.setDelFlag("1");
        }
        if (StringUtils.isBlank(menu.getParentId())) {
            menu.setParentId("0");
        }
        if (StringUtils.isBlank(menu.getParentIds())) {
            menu.setParentIds("0");
        }
        if (StringUtils.isBlank(menu.getIsShow())) {
            menu.setIsShow("1");
        }
        if (null == menu.getSort()) {
            menu.setSort(0);
        }
        if (null == menu.getSupplierId()) {
            menu.setSupplierId(GlobalParam.SUPPILER);
        }

    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
