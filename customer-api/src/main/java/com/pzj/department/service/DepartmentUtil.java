package com.pzj.department.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pzj.authority.entity.DepartmentAuthCustomerRole;
import com.pzj.authority.service.AuthorityUtil;
import com.pzj.base.common.global.UserGlobalParam.UserMapKeyParam;
import com.pzj.base.entity.SysOffice;
import com.pzj.base.entity.SysRoleOfficeUserKey;
import com.pzj.base.entity.SysUserOfficeKey;
import com.pzj.base.service.sys.IOfficeService;
import com.pzj.customer.entity.Customer;
import com.pzj.customer.service.CustomerUtil;
import com.pzj.department.entity.Department;

@Component
public class DepartmentUtil {

    @Autowired
    private IOfficeService officeService;

    @Autowired
    private AuthorityUtil authorityUtil;

    @Autowired
    private CustomerUtil customerUtil;

    /**
     * 根据对象id拼接字符串，以,分割
     * 
     * 将集合中的部门的ID，以“,”分割连接成字符串
     * 
     * @param deptList
     * @return
     */
    public String getDeptIds(List<Department> deptList) {

        if (deptList == null || deptList.isEmpty()) {
            return StringUtils.EMPTY;
        }
        StringBuffer buff = new StringBuffer();
        for (Department dept : deptList) {
            Long id = dept.getId();
            if (id != null) {
                buff.append(id).append(",");
            }

        }
        return buff.substring(0, buff.length() - 1);
    }

    public String getDeptIdsOfString(List<String> deptList) {

        if (deptList == null || deptList.isEmpty()) {
            return StringUtils.EMPTY;
        }
        StringBuffer buff = new StringBuffer();
        for (String deptId : deptList) {
            if (deptId != null) {
                buff.append(deptId).append(",");
            }

        }
        return buff.substring(0, buff.length() - 1);
    }

    public String getDeptIdsOfLong(List<Long> deptList) {

        if (deptList == null || deptList.isEmpty()) {
            return StringUtils.EMPTY;
        }
        StringBuffer buff = new StringBuffer();
        for (Long deptId : deptList) {
            if (deptId != null) {
                buff.append(deptId).append(",");
            }

        }
        return buff.substring(0, buff.length() - 1);
    }

    /**
     * 根据部门id获取对应的对象列表
     * 
     * @param deptIds
     * @return
     * @throws Exception
     */
    public List<Department> getDeptListByIds(String deptIds)
            throws Exception {
        Map<String, String> idsMap = new HashMap<String, String>();
        idsMap.put(UserMapKeyParam.DEPT_MAP_KEY, deptIds);
        idsMap.put(UserMapKeyParam.DELE_MAP_KEY, "1");
        List<Department> departments = null;
        // 根据多个id。获取多个部门
        List<SysOffice> offices = officeService.findByIds(idsMap);
        if (offices != null && !offices.isEmpty()) {
            // 转换成Department类型的集合
            departments = Department.sList2CList(offices);
        }

        return departments;
    }

    /**
     * 根据部门列表获取下属的所有用户
     * 
     * @param deptList
     * @return
     * @throws Exception
     */
    public List<Customer> getCustomerListByIds(List<Department> deptList)
            throws Exception {
        List<Customer> customers = null;

        if (deptList != null && !deptList.isEmpty()) {
            String deptIds = getDeptIds(deptList);
            List<SysUserOfficeKey> userOfficeKeyList = authorityUtil
                    .getCustomerDepartmentList(null, deptIds);

            if (userOfficeKeyList != null && !userOfficeKeyList.isEmpty()) {
                Map<String, String> userOfficeIdsMap = authorityUtil
                        .getCustomerDepartmentIds(userOfficeKeyList);
                String userIds = userOfficeIdsMap.get("userIds");
                customers = customerUtil.getUserListByUserIds(userIds);
            }
        }

        return customers;
    }

    /**
     * 给部门封装对应的部门，用户与角色关系列表
     * 
     * @throws Exception
     * 
     */
    public void setDeptDCRList(List<Department> deptList)
            throws Exception {
        if (deptList != null && !deptList.isEmpty()) {
            // 获取部门集合的ID字符串
            String deptIds = getDeptIds(deptList);

            // 查询《角色-部门-用户之间》关系
            List<SysRoleOfficeUserKey> roleOfficeList = authorityUtil
                    .getRoleOfficeList(null, deptIds, null);

            if (roleOfficeList != null && !roleOfficeList.isEmpty()) {
                // 循环部门列表
                for (Department department : deptList) {
                    // 一个部门的ID
                    String deptId = String.valueOf(department.getId());

                    // 当前部门的《部门用户角色》列表
                    List<DepartmentAuthCustomerRole> dcrList = new ArrayList<DepartmentAuthCustomerRole>();

                    // 循环《角色-部门-用户之间》关系列表，找到当前 部门的ID 的关系
                    for (SysRoleOfficeUserKey rouKey : roleOfficeList) {
                        if (deptId.equals(rouKey.getOfficeId())) {
                            // 转换关系
                            DepartmentAuthCustomerRole dcrKey = DepartmentAuthCustomerRole
                                    .changeTDepartmentAuthCustomerRole(rouKey);
                            dcrList.add(dcrKey);
                        }
                    }

                    // 当前部门设置自己的《部门用户角色》列表
                    department.setDcrList(dcrList);
                }
            }

        }
    }

    /**
     * 给部门封装对应的有效用户列表
     * 
     * @throws Exception
     * 
     */
    public void setDeptCustList(List<Department> deptList)
            throws Exception {

        if (deptList != null && !deptList.isEmpty()) {
            String deptIds = getDeptIds(deptList);

            List<SysUserOfficeKey> userOfficeKeyList = authorityUtil
                    .getCustomerDepartmentList(null, deptIds);
            if (userOfficeKeyList != null && !userOfficeKeyList.isEmpty()) {
                Map<String, String> userOfficeIdsMap = authorityUtil
                        .getCustomerDepartmentIds(userOfficeKeyList);
                String userIds = userOfficeIdsMap.get("userIds");

                List<Customer> users = customerUtil
                        .getUserListByUserIds(userIds);
                if (users != null && !users.isEmpty()) {
                    for (Department dept : deptList) {
                        List<Customer> custList = new ArrayList<Customer>();
                        String deptId = String.valueOf(dept.getId());

                        for (SysUserOfficeKey key : userOfficeKeyList) {
                            if (deptId.equals(key.getOfficeId())) {
                                for (Customer cust : users) {
                                    if (key.getUserId().equals(
                                            String.valueOf(cust.getId()))) {
                                        custList.add(cust);
                                    }
                                }
                            }

                        }
                        dept.setClist(custList);

                    }
                }
            }
        }
    }

    /**
     * 将用户列表封装到对应的部门列表里
     * 
     */
    public void setCustomerListTDepartmentList(
            List<Department> deptList, List<Customer> customers)
            throws Exception {

        if (deptList != null && !deptList.isEmpty()) {
            String deptIds = getDeptIds(deptList);

            List<SysUserOfficeKey> userOfficeKeyList = authorityUtil
                    .getCustomerDepartmentList(null, deptIds);
            if (userOfficeKeyList != null && !userOfficeKeyList.isEmpty()) {

                if (customers != null && !customers.isEmpty()) {
                    for (Department dept : deptList) {
                        List<Customer> custList = new ArrayList<Customer>();
                        String deptId = String.valueOf(dept.getId());

                        for (SysUserOfficeKey key : userOfficeKeyList) {
                            if (deptId.equals(key.getOfficeId())) {
                                for (Customer cust : customers) {
                                    if (key.getUserId().equals(
                                            String.valueOf(cust.getId()))) {
                                        custList.add(cust);
                                    }
                                }
                            }

                        }
                        dept.setClist(custList);
                    }
                }
            }
        }
    }

    /**
     * 将部门列表转化为Map<id,department>
     * 
     * 
     */
    public Map<String, Department> getDeparmentMap(
            List<Department> departments) throws Exception {
        Map<String, Department> map = null;
        if (departments != null && !departments.isEmpty()) {
            map = new HashMap<String, Department>();
            for (Department department : departments) {
                Long id = department.getId();
                if (id != null) {
                    map.put(String.valueOf(id), department);
                }

            }
        }
        return map;
    }

    /**
     * 根据部门对象拼接部门父Id字符串，以,分割
     * 
     * @param deptList
     * @return
     */
    public String getDeptPIDs(List<Department> deptList)
            throws Exception {

        if (deptList == null || deptList.isEmpty()) {
            return StringUtils.EMPTY;
        }
        StringBuffer buff = new StringBuffer();
        for (Department dept : deptList) {
            buff.append(dept.getParentId()).append(",");
        }
        return buff.substring(0, buff.length() - 1);
    }

    /**
     * 设置部门的上级部门
     * 
     * @throws Exception
     * 
     */
    public void setDepartmentPAR(List<Department> curDepts)
            throws Exception {
        if (curDepts == null || curDepts.isEmpty()) {
            return;
        }
        String ids = getDeptIds(curDepts);
        if (StringUtils.isNoneBlank(ids)) {
            if (curDepts != null && !curDepts.isEmpty()) {
                String pids = getDeptPIDs(curDepts);
                List<Department> pList = getDeptListByIds(pids);
                if (pList != null && !pList.isEmpty()) {
                    Map<String, Department> map = getDeparmentMap(pList);
                    // 构造部门上级部门
                    for (Department dept : curDepts) {
                        String pid = dept.getParentId();
                        if (map.containsKey(pid)) {
                            dept.setParDept(map.get(pid));
                            continue;
                        }
                    }
                }
            }
        }

    }

    /**
     * 设置部门的下级部门列表
     * 
     */
    public void setDepartmentSUB(List<Department> curDepts)
            throws Exception {
        if (curDepts == null || curDepts.isEmpty()) {
            return;
        }

        String ids = getDeptIds(curDepts);
        Map<String, String> map = new HashMap<String, String>(2);
        map.put(UserMapKeyParam.DEPT_MAP_KEY, ids);
        map.put(UserMapKeyParam.DELE_MAP_KEY, "1");
        List<SysOffice> subOffices = officeService.findSysOfficeKeyByPids(map);

        // 构造部门下级部门
        if (subOffices != null && !subOffices.isEmpty()) {
            for (Department dept : curDepts) {
                Long deptId = dept.getId();
                if (deptId != null) {
                    String deptId_ = String.valueOf(deptId);
                    List<Department> subDepts = new ArrayList<Department>();
                    for (SysOffice subDept : subOffices) {
                        if (deptId_.equals(subDept.getParentId())) {
                            subDepts.add(Department
                                    .sysOffice2Department(subDept));
                        }
                    }
                    dept.setSubDept(subDepts);
                }
            }
        }
    }

    /**
     * 给用户封装对应的有效部门列表，角色列表，菜单列表
     * 
     * @throws Exception
     * 
     */
    public void setDepartmentAuthorityList(List<Department> departments)
            throws Exception {
        if (departments != null && !departments.isEmpty()) {

            // 部门封装用户列表
            setDeptCustList(departments);

            // 部门封装用户部门角色关系列表
            setDeptDCRList(departments);

        }

    }
}
