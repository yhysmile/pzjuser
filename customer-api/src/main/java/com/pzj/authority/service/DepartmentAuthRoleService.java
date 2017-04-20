package com.pzj.authority.service;

import java.util.List;

import com.pzj.authority.entity.DepartmentAuthCustomerRole;

/**
 * 角色与部门关联关系接口
 * 
 * @author huxiaona
 * @email huxiaona@mftour.cn
 * @date 2015-9-21 上午11:26:40
 */
public interface DepartmentAuthRoleService {

    /**
     * 配置角色与部门关联关系权限
     * 
     * @param list
     *            角色部门关联关系的集合
     * @throws Exception
     */
    void createDepartmentAuthRole(List<DepartmentAuthCustomerRole> list)
            throws Exception;

    /**
     * 编辑保存角色拥有的部门权限
     * 
     * @param list
     *            角色部门关联关系的集合
     * @throws Exception
     */
    void saveDepartmentAuthRole(List<DepartmentAuthCustomerRole> list)
            throws Exception;

}
