package com.pzj.role.entity;

import static com.pzj.role.entity.RoleBuilder.ARoleBuilder;
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
import com.pzj.base.common.global.UserGlobalDict.RoleType;
import com.pzj.base.entity.SysRole;
import com.pzj.menu.entity.Menu;
import com.pzj.util.CommonEntity;

public class Role extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 6188757952589249324L;

    /** 归属机构 */
    private String officeId;

    /** 角色名称 */
    private String name;

    /**
     * 角色类型
     */
    private String type;

    /** 数据范围 */
    private String dataScope;

    /** 创建者 */
    private String createBy;

    /** 更新者 */
    private String updateBy;

    /** 备注信息 */
    private String remarks;

    /** 角色菜单列表 */
    private List<Menu> mlist;

    /** 数据源 */
    private String dataSource;

    /**
     * 别名
     */
    private String alias;

    /**
     * <h3>是否绑定检票点</h3>
     * <p>
     * 使用当量：RoleBingType.BindingNo、RoleBingType.BindingYes
     * </p>
     */
    private Integer binding;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 是否需要查询被绑定的岗位
     * <p/>
     * 默认查询不绑定（isBingding为0）的岗位，设置为ture时刚也查询出isBingding为1的Role，
     * 用于findByDempartmentRole接口
     */
    private Boolean needBingdingRole;

    /**
     * 查询参数，查询数据范围
     */
    private List<String> queryDataScope;

    /**
     * 获取
     * 
     * @return queryDataScope
     */
    public List<String> getQueryDataScope() {
        return queryDataScope;
    }

    /**
     * 设置
     * 
     * @param queryDataScope
     */
    public void setQueryDataScope(List<String> queryDataScope) {
        this.queryDataScope = queryDataScope;
    }

    public Role() {
        super();
    }

    /**
     * 获取归属机构
     * 
     * @return officeId 归属机构
     */
    public String getOfficeId() {
        return officeId;
    }

    /**
     * 设置归属机构
     * 
     * @param officeId
     *            归属机构
     */
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取角色名称
     * 
     * @return name 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     * 
     * @param name
     *            角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色类型
     * 
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * 设置角色类型
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取数据范围
     * 
     * @return dataScope 数据范围
     */
    public String getDataScope() {
        return dataScope;
    }

    /**
     * 设置数据范围
     * 
     * @param dataScope
     *            数据范围
     */
    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
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
     * 获取角色菜单列表
     * 
     * @return mlist 角色菜单列表
     */
    public List<Menu> getMlist() {
        return mlist;
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
     * 获取别名
     * 
     * @return
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置别名
     * 
     * @param alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 获取是否绑定检票点
     * <p>
     * 使用当量：RoleBingType.BindingNo、RoleBingType.BindingYes
     * <p>
     * 
     * @return isBinding <h3>是否绑定检票点<h3>
     *         <p>
     *         使用当量：RoleBingType.BindingNo、RoleBingType.BindingYes
     *         <p>
     */
    public Integer getBinding() {
        return binding;
    }

    /**
     * 设置是否绑定检票点
     * <p>
     * 使用当量：RoleBingType.BindingNo、RoleBingType.BindingYes
     * <p>
     * 
     * @param isBinding
     *            <h3>是否绑定检票点<h3>
     *            <p>
     *            使用当量：RoleBingType.BindingNo、RoleBingType.BindingYes
     *            <p>
     */
    public void setBinding(Integer binding) {
        this.binding = binding;
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
     * 设置角色菜单列表
     * 
     * @param mlist
     *            角色菜单列表
     */
    public void setMlist(List<Menu> mlist) {
        this.mlist = mlist;
    }

    public static SysRole changeTSysRole(Role role) throws Exception {
        return ARoleBuilder.convertTo(role);
    }

    public static SysRole createNewSysRole(Role role) throws Exception {
        checkNull(role, "Role不能为null");
        if (null == role.getId()) {
            // 设置默认参数
            setDefaultData(role);

            // 验证
            validData(role);

            // 转换
            return changeTSysRole(role);
        } else {
            // 转换
            return changeTSysRole(role);
        }

    }

    public static Role sysRole2Role(SysRole sysRole) throws Exception {
        return ARoleBuilder.convertFrom(sysRole);
    }

    public static List<SysRole> cList2SList(List<Role> roleList) throws Exception {
        List<SysRole> sysRoleList = null;
        if (roleList != null) {
            sysRoleList = new ArrayList<SysRole>();
            for (Role role : roleList) {
                Long roleId = role.getId();
                SysRole sysRole = null;
                if (roleId == null || roleId < 1) {
                    sysRole = createNewSysRole(role);
                } else {
                    sysRole = changeTSysRole(role);
                }

                sysRoleList.add(sysRole);
            }
        }
        return sysRoleList;
    }

    public static List<SysRole> cList2SList(List<Role> roleList, RoleForeachHandle foreach) throws Exception {
        List<SysRole> sysRoleList = null;
        if (roleList != null) {
            sysRoleList = new ArrayList<SysRole>();
            for (Role role : roleList) {
                Long roleId = role.getId();
                SysRole sysRole = null;
                if (roleId == null || roleId < 1) {
                    sysRole = createNewSysRole(role);
                } else {
                    sysRole = changeTSysRole(role);
                }

                foreach.handle(sysRole, role);

                sysRoleList.add(sysRole);
            }
        }
        return sysRoleList;
    }

    public static List<Role> sList2CList(List<SysRole> sysRoleList) throws Exception {
        List<Role> roleList = null;
        if (sysRoleList != null) {
            roleList = new ArrayList<Role>();
            for (SysRole sysRole : sysRoleList) {
                Role role = sysRole2Role(sysRole);
                roleList.add(role);
            }
        }
        return roleList;
    }

    /**
     * @param role
     * @throws ServiceException
     */
    public static void validData(Role role) throws ServiceException {
        checkNull(role, "Role不能为null");
        checkEmpty(role.getName(), "Role.Name不能为空");
        checkEmpty(role.getDelFlag(), "Role.DelFlag不能为空");
        checkNull(role.getSupplierId(), "Role.SupplierId不能为null");
    }

    public static void validDataAll(Role role) throws ServiceException {
        validData(role);
        checkLengthMax(role.getName(), 100, "Role.Name超过最大长度，最大为100");
        checkLengthMax(role.getDataScope(), 1, "Role.DataScope超过最大长度，最大为1");
        checkLengthMax(role.getCreateBy(), 64, "Role.CreateBy超过最大长度，最大为64");
        checkLengthMax(role.getUpdateBy(), 64, "Role.UpdateBy超过最大长度，最大为64");
        checkLengthMax(role.getRemarks(), 255, "Role.Remarks超过最大长度，最大为255");
        checkLengthMax(role.getDelFlag(), 1, "Role.DelFlag超过最大长度，最大为1");
    }

    protected static void setDefaultData(Role role) {
        if (null == role.getCreateDate()) {
            role.setCreateDate(new Date());
        }
        if (StringUtils.isEmpty(role.getDelFlag())) {
            role.setDelFlag("1");
        }
        if (StringUtils.isEmpty(role.getType())) {
            role.setType(RoleType.GENERAL);
        }
        if (null == role.getSupplierId()) {
            role.setSupplierId(GlobalParam.SUPPILER);
        }
    }

    public Boolean getNeedBingdingRole() {
        return needBingdingRole;
    }

    public void setNeedBingdingRole(Boolean needBingdingRole) {
        this.needBingdingRole = needBingdingRole;
    }
}
