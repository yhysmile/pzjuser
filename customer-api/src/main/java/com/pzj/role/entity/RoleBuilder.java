package com.pzj.role.entity;

import static com.pzj.util.ServiceUtil.checkEmpty;
import static com.pzj.util.ServiceUtil.checkNull;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.common.ServiceException;
import com.pzj.base.common.global.UserGlobalDict.RoleType;
import com.pzj.base.entity.SysRole;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;

public class RoleBuilder extends CommonBuiler<SysRole, Role> {
    public static final RoleBuilder ARoleBuilder = new RoleBuilder();

    @Override
    public Role convertFrom(SysRole entity) {
        Role role = new Role();
        role.setCreateBy(entity.getCreateBy());
        role.setCreateDate(entity.getCreateDate());
        role.setDataScope(entity.getDataScope());
        role.setDelFlag(entity.getDelFlag());
        role.setId(entity.getId());
        role.setName(entity.getName());
        role.setRemarks(entity.getRemarks());
        role.setUpdateBy(entity.getUpdateBy());
        role.setUpdateDate(entity.getUpdateDate());
        role.setDataSource(entity.getDataSource());
        role.setAlias(entity.getAlias());
        role.setBinding(entity.getBingding());
        role.setType(entity.getType());
        role.setOfficeId(entity.getOfficeId());
        role.setSupplierId(entity.getSupplierId());
        role.setNeedBingdingRole(entity.getNeedBingdingRole());
        return role;
    }

    @Override
    public SysRole convertTo(Role role) {
        SysRole sysRole = new SysRole();
        sysRole.setCreateBy(role.getCreateBy());
        sysRole.setCreateDate(role.getCreateDate());
        sysRole.setDataScope(role.getDataScope());
        sysRole.setDelFlag(role.getDelFlag());
        sysRole.setId(role.getId());
        sysRole.setName(role.getName());
        sysRole.setRemarks(role.getRemarks());
        sysRole.setUpdateBy(role.getUpdateBy());
        sysRole.setUpdateDate(role.getUpdateDate());
        sysRole.setDataSource(role.getDataSource());
        sysRole.setAlias(role.getAlias());
        sysRole.setBingding(role.getBinding());
        sysRole.setType(role.getType());
        sysRole.setOfficeId(role.getOfficeId());
        sysRole.setSupplierId(role.getSupplierId());
        sysRole.setNeedBingdingRole(role.getNeedBingdingRole());
        sysRole.setQueryDataScope(role.getQueryDataScope());
        return sysRole;
    }

    @Override
    protected void validtionValueWhenCreate(Role role, CommonCheck check) throws ServiceException {
        checkNull(role, "Role不能为null");
        checkEmpty(role.getName(), "Role.Name不能为空");
        checkEmpty(role.getDelFlag(), "Role.DelFlag不能为空");
    }

    @Override
    protected void customValueWhenCreate(Role role) {
        if (null == role.getCreateDate()) {
            role.setCreateDate(new Date());
        }
        if (StringUtils.isEmpty(role.getDelFlag())) {
            role.setDelFlag("1");
        }
        if (StringUtils.isEmpty(role.getType())) {
            role.setType(RoleType.GENERAL);
        }
    }

    @Override
    protected void customValueWhenModify(Role entity) {

    }

}
