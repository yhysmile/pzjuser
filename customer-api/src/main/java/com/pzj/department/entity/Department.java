package com.pzj.department.entity;

import static com.pzj.util.ServiceUtil.checkEmpty;
import static com.pzj.util.ServiceUtil.checkLengthMax;
import static com.pzj.util.ServiceUtil.checkNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pzj.authority.entity.DepartmentAuthCustomerRole;
import com.pzj.base.common.ServiceException;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.SysOffice;
import com.pzj.customer.entity.Customer;
import com.pzj.role.entity.Role;
import com.pzj.util.CommonEntity;

/**
 * 部门
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-8-27 下午5:35:01
 */
public class Department extends CommonEntity implements Serializable {

    private static final long serialVersionUID = -3339090246276757300L;

    /** 父级编号 */
    private String parentId;

    /** 所有父级编号 */
    private String parentIds;

    /** 归属区域 */
    private String areaId;

    /** 区域编码 */
    private String code;

    /** 机构名称 */
    private String name;

    /** 机构类型 */
    private String type;

    /** 机构等级 */
    private String grade;

    /** 联系地址 */
    private String address;

    /** 邮政编码 */
    private String zipCode;

    /** 负责人 */
    private String master;

    /** 电话 */
    private String phone;

    /** 传真 */
    private String fax;

    /** 邮箱 */
    private String email;

    /** 创建者 */
    private String createBy;

    /** 更新者 */
    private String updateBy;

    /** 备注信息 */
    private String remarks;

    /**
     * 审核状态
     */
    private String auditStatus;

    /** 数据源 */
    private String dataSource;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /** 部门角色列表 */
    private List<Role> list;
    /** 部门用户列表 */
    private List<Customer> clist;

    /** 部门的上级部门 */
    private Department parDept;

    /** 部门的所有下级部门列表 */
    private List<Department> subDept;

    /** 部门的所有《部门用户角色》关系列表 */
    private List<DepartmentAuthCustomerRole> dcrList;

    /**
     * 获取部门的所有用户菜单关系列表
     * 
     * @return dcrList 部门的所有用户菜单关系列表
     */
    public List<DepartmentAuthCustomerRole> getDcrList() {
        return dcrList;
    }

    /**
     * 设置部门的所有《部门与用户与角色》列表
     * 
     * @param dcrList
     *            部门的所有用户菜单关系列表
     */
    public void setDcrList(List<DepartmentAuthCustomerRole> dcrList) {
        this.dcrList = dcrList;
    }

    /**
     * 获取部门的上级部门列表
     * 
     * @return parDept 部门的上级部门列表
     */
    public Department getParDept() {
        return parDept;
    }

    /**
     * 设置部门的上级部门列表
     * 
     * @param parDept
     *            部门的上级部门列表
     */
    public void setParDept(Department parDept) {
        this.parDept = parDept;
    }

    /**
     * 获取部门的所有下级部门列表
     * 
     * @return subDept 部门的所有下级部门列表
     */
    public List<Department> getSubDept() {
        return subDept;
    }

    /**
     * 设置部门的所有下级部门列表
     * 
     * @param subDept
     *            部门的所有下级部门列表
     */
    public void setSubDept(List<Department> subDept) {
        this.subDept = subDept;
    }

    public Department() {
        super();
    }

    /**
     * 获取父级编号
     * 
     * @return parentId 父级编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级编号
     * 
     * @param parentId
     *            父级编号
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
     * 获取归属区域
     * 
     * @return areaId 归属区域
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 设置归属区域
     * 
     * @param areaId
     *            归属区域
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取区域编码
     * 
     * @return code 区域编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置区域编码
     * 
     * @param code
     *            区域编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取机构名称
     * 
     * @return name 机构名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置机构名称
     * 
     * @param name
     *            机构名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取机构类型
     * 
     * @return type 机构类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置机构类型
     * 
     * @param type
     *            机构类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取机构等级
     * 
     * @return grade 机构等级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 设置机构等级
     * 
     * @param grade
     *            机构等级
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 获取联系地址
     * 
     * @return address 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置联系地址
     * 
     * @param address
     *            联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取邮政编码
     * 
     * @return zipCode 邮政编码
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮政编码
     * 
     * @param zipCode
     *            邮政编码
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 获取负责人
     * 
     * @return master 负责人
     */
    public String getMaster() {
        return master;
    }

    /**
     * 设置负责人
     * 
     * @param master
     *            负责人
     */
    public void setMaster(String master) {
        this.master = master;
    }

    /**
     * 获取电话
     * 
     * @return phone 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     * 
     * @param phone
     *            电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取传真
     * 
     * @return fax 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真
     * 
     * @param fax
     *            传真
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 获取邮箱
     * 
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     * 
     * @param email
     *            邮箱
     */
    public void setEmail(String email) {
        this.email = email;
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
     * 获取审核状态
     * 
     * @return
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态
     * 
     * @param auditStatus
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取部门角色列表
     * 
     * @return list 部门角色列表
     */
    public List<Role> getList() {
        return list;
    }

    /**
     * 设置部门角色列表
     * 
     * @param list
     *            部门角色列表
     */
    public void setList(List<Role> list) {
        this.list = list;
    }

    /**
     * 获取部门用户列表
     * 
     * @return clist 部门用户列表
     */
    public List<Customer> getClist() {
        return clist;
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
     * 设置部门用户列表
     * 
     * @param clist
     *            部门用户列表
     */
    public void setClist(List<Customer> clist) {
        this.clist = clist;
    }

    public static SysOffice createNewDepartment(Department department)
            throws Exception {
        checkNull(department, "Department不能为null");
        if (null == department.getId()) {
            // 设置默认参数
            setDefaultData(department);

            // 验证
            validData(department);
        }

        // 转化
        return changeTDepartment(department);
    }

    public static SysOffice changeTDepartment(Department de) throws Exception {

        SysOffice sysOffice = new SysOffice();
        sysOffice.setAddress(de.getAddress());
        sysOffice.setAreaId(de.getAreaId());
        sysOffice.setCode(de.getCode());
        sysOffice.setCreateBy(de.getCreateBy());
        sysOffice.setCreateDate(de.getCreateDate());
        sysOffice.setDelFlag(de.getDelFlag());
        sysOffice.setEmail(de.getEmail());
        sysOffice.setFax(de.getFax());
        sysOffice.setGrade(de.getGrade());
        sysOffice.setId(de.getId());
        sysOffice.setMaster(de.getMaster());
        sysOffice.setName(de.getName());
        sysOffice.setParentId(de.getParentId());
        sysOffice.setParentIds(de.getParentIds());
        sysOffice.setPhone(de.getPhone());
        sysOffice.setRemarks(de.getRemarks());
        sysOffice.setType(de.getType());
        sysOffice.setUpdateBy(de.getUpdateBy());
        sysOffice.setUpdateDate(de.getUpdateDate());
        sysOffice.setZipCode(de.getZipCode());
        sysOffice.setAuditStatus(de.getAuditStatus());
        sysOffice.setDataSource(de.getDataSource());
        sysOffice.setSupplierId(de.getSupplierId());

        return sysOffice;
    }

    public static Department sysOffice2Department(SysOffice sysOffice)
            throws Exception {
        Department department = new Department();

        department.setAddress(sysOffice.getAddress());
        department.setAreaId(sysOffice.getAreaId());
        department.setCode(sysOffice.getCode());
        department.setCreateBy(sysOffice.getCreateBy());
        department.setCreateDate(sysOffice.getCreateDate());
        department.setDelFlag(sysOffice.getDelFlag());
        department.setEmail(sysOffice.getEmail());
        department.setFax(sysOffice.getFax());
        department.setGrade(sysOffice.getGrade());
        department.setId(sysOffice.getId());
        department.setMaster(sysOffice.getMaster());
        department.setName(sysOffice.getName());
        department.setParentId(sysOffice.getParentId());
        department.setParentIds(sysOffice.getParentIds());
        department.setPhone(sysOffice.getPhone());
        department.setRemarks(sysOffice.getRemarks());
        department.setType(sysOffice.getType());
        department.setUpdateBy(sysOffice.getUpdateBy());
        department.setUpdateDate(sysOffice.getUpdateDate());
        department.setZipCode(sysOffice.getZipCode());

        department.setAuditStatus(sysOffice.getAuditStatus());
        department.setDataSource(sysOffice.getDataSource());

        department.setSupplierId(sysOffice.getSupplierId());

        return department;
    }

    public static List<SysOffice> cList2SList(List<Department> departmentList)
            throws Exception {
        List<SysOffice> sysOfficeList = null;
        if (departmentList != null) {
            sysOfficeList = new ArrayList<SysOffice>(departmentList.size());
            for (Department department : departmentList) {
                Long deptId = department.getId();
                SysOffice sysOffice = null;
                if (deptId == null || deptId < 1) {
                    sysOffice = Department.createNewDepartment(department);
                } else {
                    sysOffice = Department.changeTDepartment(department);
                }
                sysOfficeList.add(sysOffice);
            }
        }
        return sysOfficeList;
    }

    public static List<SysOffice> cList2SList(List<Department> departmentList,
            DepartmentForeachHandle foreach) throws Exception {
        List<SysOffice> sysOfficeList = null;
        if (departmentList != null) {
            sysOfficeList = new ArrayList<SysOffice>(departmentList.size());
            for (Department department : departmentList) {
                Long deptId = department.getId();
                SysOffice sysOffice = null;
                if (deptId == null || deptId < 1) {
                    sysOffice = Department.createNewDepartment(department);
                } else {
                    sysOffice = Department.changeTDepartment(department);
                }

                foreach.handle(sysOffice, department);

                sysOfficeList.add(sysOffice);
            }
        }
        return sysOfficeList;
    }

    public static List<Department> sList2CList(List<SysOffice> sysOfficeList)
            throws Exception {
        List<Department> departmentList = null;
        if (sysOfficeList != null) {
            departmentList = new ArrayList<Department>();
            for (SysOffice sysOffice : sysOfficeList) {
                Department department = sysOffice2Department(sysOffice);
                departmentList.add(department);
            }
        }
        return departmentList;
    }

    public static void validData(Department department) throws ServiceException {
        // 数据验证
        checkNull(department, "Department不能为null");
        checkEmpty(department.getParentId(), "Department.ParentId不能为空");
        checkEmpty(department.getParentIds(), "Department.ParentIds不能为空");
        checkEmpty(department.getName(), "Department.Name不能为空");
        checkEmpty(department.getDelFlag(), "Department.DelFlag不能为空");
        checkNull(department.getSupplierId(), "Department.SupplierId不能为null");
    }

    public static void validDataAll(Department department)
            throws ServiceException {
        validData(department);

        checkLengthMax(department.getParentId(), 64,
                "Department.ParentId超过最大长度，最大为64");
        checkLengthMax(department.getParentIds(), 1000,
                "Department.ParentIds超过最大长度，最大为1000");
        checkLengthMax(department.getAreaId(), 64, "Department.AreaId超过最大长度，最大为64");
        checkLengthMax(department.getCode(), 100, "Department.Code超过最大长度，最大为100");
        checkLengthMax(department.getName(), 100, "Department.Name超过最大长度，最大为100");
        checkLengthMax(department.getType(), 1, "Department.DelFlag超过最大长度，最大为1");
        checkLengthMax(department.getGrade(), 1, "Department.DelFlag超过最大长度，最大为1");
        checkLengthMax(department.getAddress(), 255,
                "Department.DelFlag超过最大长度，最大为255");
        checkLengthMax(department.getZipCode(), 100,
                "Department.DelFlag超过最大长度，最大为100");
        checkLengthMax(department.getMaster(), 100,
                "Department.DelFlag超过最大长度，最大为100");
        checkLengthMax(department.getPhone(), 200,
                "Department.DelFlag超过最大长度，最大为200");
        checkLengthMax(department.getFax(), 200, "Department.DelFlag超过最大长度，最大为200");
        checkLengthMax(department.getEmail(), 200,
                "Department.DelFlag超过最大长度，最大为200");
        checkLengthMax(department.getCreateBy(), 64,
                "Department.DelFlag超过最大长度，最大为64");
        checkLengthMax(department.getUpdateBy(), 64,
                "Department.DelFlag超过最大长度，最大为64");
        checkLengthMax(department.getRemarks(), 255,
                "Department.DelFlag超过最大长度，最大为255");
        checkLengthMax(department.getDelFlag(), 1, "Department.DelFlag超过最大长度，最大为1");
    }

    protected static void setDefaultData(Department department) {
        // 数据默认值注入
        if (StringUtils.isEmpty(department.getDelFlag())) {
            department.setDelFlag("1");
        }

        if (StringUtils.isBlank(department.getParentId())) {
            department.setParentId("0");
        }

        if (StringUtils.isBlank(department.getParentIds())) {
            department.setParentIds("0");
        }
        if (null == department.getCreateDate()) {
            department.setCreateDate(new Date());
        }
        if (null == department.getSupplierId()) {
            department.setSupplierId(GlobalParam.SUPPILER);
        }
    }

}
