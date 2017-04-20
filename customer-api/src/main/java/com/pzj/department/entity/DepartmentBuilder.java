package com.pzj.department.entity;

import static com.pzj.util.ServiceUtil.checkEmpty;
import static com.pzj.util.ServiceUtil.checkNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysOffice;
import com.pzj.base.entity.SysRole;
import com.pzj.role.entity.Role;
import com.pzj.role.entity.RoleForeachHandle;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;

public class DepartmentBuilder extends CommonBuiler<SysOffice, Department> {
    public final static DepartmentBuilder ADepartmentBuilder = new DepartmentBuilder();

    @Override
    public Department convertFrom(SysOffice ss) {
        Department ee = new Department();
        ee.setAddress(ss.getAddress());
        ee.setAreaId(ss.getAreaId());
        ee.setCode(ss.getCode());
        ee.setCreateBy(ss.getCreateBy());
        ee.setCreateDate(ss.getCreateDate());
        ee.setDelFlag(ss.getDelFlag());
        ee.setEmail(ss.getEmail());
        ee.setFax(ss.getFax());
        ee.setGrade(ss.getGrade());
        ee.setId(ss.getId());
        ee.setMaster(ss.getMaster());
        ee.setName(ss.getName());
        ee.setParentId(ss.getParentId());
        ee.setParentIds(ss.getParentIds());
        ee.setPhone(ss.getPhone());
        ee.setRemarks(ss.getRemarks());
        ee.setType(ss.getType());
        ee.setUpdateBy(ss.getUpdateBy());
        ee.setUpdateDate(ss.getUpdateDate());
        ee.setZipCode(ss.getZipCode());
        ee.setAuditStatus(ss.getAuditStatus());
        ee.setDataSource(ss.getDataSource());
        ee.setSupplierId(ss.getSupplierId());

        return ee;
    }

    @Override
    public SysOffice convertTo(Department ss) {
        SysOffice ee = new SysOffice();
        ee.setAddress(ss.getAddress());
        ee.setAreaId(ss.getAreaId());
        ee.setCode(ss.getCode());
        ee.setCreateBy(ss.getCreateBy());
        ee.setCreateDate(ss.getCreateDate());
        ee.setDelFlag(ss.getDelFlag());
        ee.setEmail(ss.getEmail());
        ee.setFax(ss.getFax());
        ee.setGrade(ss.getGrade());
        ee.setId(ss.getId());
        ee.setMaster(ss.getMaster());
        ee.setName(ss.getName());
        ee.setParentId(ss.getParentId());
        ee.setParentIds(ss.getParentIds());
        ee.setPhone(ss.getPhone());
        ee.setRemarks(ss.getRemarks());
        ee.setType(ss.getType());
        ee.setUpdateBy(ss.getUpdateBy());
        ee.setUpdateDate(ss.getUpdateDate());
        ee.setZipCode(ss.getZipCode());
        ee.setAuditStatus(ss.getAuditStatus());
        ee.setDataSource(ss.getDataSource());
        ee.setSupplierId(ss.getSupplierId());

        return ee;
    }

    @Override
    protected void validtionValueWhenCreate(Department entity, CommonCheck check)
            throws ServiceException {
        checkNull(entity, "Department不能为null");
        checkEmpty(entity.getParentId(), "Department.ParentId不能为空");
        checkEmpty(entity.getParentIds(), "Department.ParentIds不能为空");
        checkEmpty(entity.getName(), "Department.Name不能为空");
        checkEmpty(entity.getDelFlag(), "Department.DelFlag不能为空");
    }

    @Override
    protected void customValueWhenCreate(Department entity) {
        if (StringUtils.isEmpty(entity.getDelFlag())) {
            entity.setDelFlag("1");
        }

        if (StringUtils.isBlank(entity.getParentId())) {
            entity.setParentId("0");
        }

        if (StringUtils.isBlank(entity.getParentIds())) {
            entity.setParentIds("0");
        }
    }

    public OfficeAndRole buildOfficeAndRole(List<Department> departments) throws Exception {
        OfficeAndRole oar = new OfficeAndRole();
        if (null == departments)
            return oar;

        // 所有部门的角色的数量
        int size = 0;

        // 循环每个部门累计角色数量
        for (Iterator<Department> iterator = departments.iterator(); iterator.hasNext();) {
            Department department = iterator.next();
            List<Role> list = department.getList();
            // 累计角色数量
            size += (null != list ? list.size() : 0);
        }

        // 创建SysRole的集合
        final List<SysRole> sysRoleList = new ArrayList<SysRole>(size);
        // 转换Department集合为SysOffice的集合
        List<SysOffice> sysOfficeList = Department.cList2SList(departments, new DepartmentForeachHandle() {

            // 当每循环出Department并转换为SysOffice时，转换Department的Role集合
            @Override
            public void handle(final SysOffice sysOffice, Department department) {
                try {
                    // 转换Department的Role集合为SysRole集合
                    List<SysRole> sysroleList = Role.cList2SList(department.getList(), new RoleForeachHandle() {

                        // 当每循环出Role并转换为SysRole时，将SysRole与SysOffice关联起来
                        @Override
                        public void handle(SysRole sysRole, Role role) {
                            sysRole.setParentRef(sysOffice);
                        }
                    });
                    if (null != sysroleList) {
                        sysRoleList.addAll(sysroleList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        oar.sysOfficeList = sysOfficeList;
        oar.sysRoleList = sysRoleList;

        return oar;
    }

    @Override
    protected void customValueWhenModify(Department entity) {
        // TODO Auto-generated method stub
        
    }

    public Department copy(Department ss){
        Department ee = new Department();
        ee.setAddress(ss.getAddress());
        ee.setAreaId(ss.getAreaId());
        ee.setCode(ss.getCode());
        ee.setCreateBy(ss.getCreateBy());
        ee.setCreateDate(ss.getCreateDate());
        ee.setDelFlag(ss.getDelFlag());
        ee.setEmail(ss.getEmail());
        ee.setFax(ss.getFax());
        ee.setGrade(ss.getGrade());
        ee.setId(ss.getId());
        ee.setMaster(ss.getMaster());
        ee.setName(ss.getName());
        ee.setParentId(ss.getParentId());
        ee.setParentIds(ss.getParentIds());
        ee.setPhone(ss.getPhone());
        ee.setRemarks(ss.getRemarks());
        ee.setType(ss.getType());
        ee.setUpdateBy(ss.getUpdateBy());
        ee.setUpdateDate(ss.getUpdateDate());
        ee.setZipCode(ss.getZipCode());
        ee.setAuditStatus(ss.getAuditStatus());
        ee.setDataSource(ss.getDataSource());
        ee.setSupplierId(ss.getSupplierId());
        return  ee;
    }
}
