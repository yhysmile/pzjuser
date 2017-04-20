package com.pzj.base.service.sys;

import java.util.List;
import java.util.Map;

import com.pzj.base.entity.SysOffice;
import com.pzj.base.entity.SysRole;
import com.pzj.base.entity.SysUser;

/**
 * 部门接口
 * 
 * @author huxiaona
 * @email huxiaona@mftour.cn
 * @date 2015-9-11 上午11:05:54
 */
public interface IOfficeService extends IBaseUserService<SysOffice> {

	/**
	 * 添加部门信息,部门角色关联信息,部门用户关联信息，部门角色或部门角色用户关联信息
	 * 
	 * @param office
	 *            部门对象
	 * @param sysRoleList
	 *            部门下的角色列表
	 * 
	 * @param userList
	 *            部门下的用户列表
	 * 
	 * @param userRoleMap
	 *            部门下的角色信息
	 * 
	 * @return 部门主键
	 */
	public Long addOfficeAndAuth(SysOffice office, List<SysUser> userList,
			List<SysRole> sysRoleList);

	/**
	 * 添加部门信息,部门用户关联信息，部门用户角色关联信息
	 * 
	 * @param office
	 *            部门对象
	 * 
	 * @param userList
	 *            部门下的用户列表
	 * 
	 * @param sysRoleMap
	 *            用户下的角色信息
	 * 
	 * @return 部门主键
	 */
	public Long addOfficeAndUser(SysOffice office, List<SysUser> userList,
			Map<String, List<SysRole>> sysRoleMap);
	
	/**
     * <ul>
     * <li>创建或更新部门（office）；</li>
     * <li>创建或更新角色，维护部门与角色关系（officeRoles）；</li>
     * <li>创建或更新用户，维护部门与用户关系（officeUsers）；</li>
     * <li>创建或师尊角色，维护用户与角色关系（officeUserRoles）；</li>
     * <li>维护部门与用户与角色关系（officeUserRoles）；</li>
     * </ul>
	 * @param office
	 * @param officeRoles
	 * @param officeUsers
	 * @param officeUserRoles
	 * @return
	 */
	public Long addOfficeAndUser(SysOffice office, List<SysRole> officeRoles, List<SysUser> officeUsers,
            Map<String, List<SysRole>> officeUserRoles);

	/**
	 * 根据父级部门Ids查询部门列表
	 * 
	 * @param pidMap
	 *            部门父Ids，删除标识
	 * 
	 */
	public List<SysOffice> findSysOfficeKeyByPids(Map<String, String> pidMap);

	/**
	 * 编辑保存部门及部门用户关系信息
	 * 
	 * @param office
	 *            部门
	 * @param users
	 *            用户列表
	 * @param isNeedUpdate
	 *            是否需要更新部门实体
	 * @return
	 */
	public Long saveOfficeAndUser(SysOffice office, List<SysUser> users,
			boolean isNeedUpdate);

	/**
	 * 编辑保存部门及部门角色关系信息
	 * <p/>
	 * 添加或更新（存在ID时更新）部门信息；
	 * 如果角色信息不存在（角色没有ID），则添加角色信息；
	 * 关联部门与角色。
	 * @param office
	 *            部门
	 * @param records
	 *            角色列表
	 * @param isNeedUpdate
	 *            是否需要更新部门实体
	 * @return
	 */
	public Long saveOfficeAndRole(SysOffice office, List<SysRole> records,
			boolean isNeedUpdate);

	/**
	 * 批量编辑保存部门及部门角色关系信息
	 * 
	 * @param office
	 *            部门
	 * @param records
	 *            角色列表
	 * @param isNeedUpdate
	 *            是否需要更新部门实体
	 * @return
	 */
	public Long saveBatchOfficeAndRole(List<SysOffice> office,
			Map<String, List<SysRole>> records, boolean isNeedUpdate);

	/**
	 * 更新用户角色部门之间的关联关系
	 * 
	 * @param office
	 *            部门实体
	 * 
	 * @param userList
	 *            用户列表
	 * 
	 * @param roleMap
	 *            用户对应的角色列表
	 * 
	 * @return 更新条数
	 */
	public Long updateOfficeOR(SysOffice office, List<SysUser> userList,
			Map<String, List<SysRole>> roleMap);

	/**
	 * 物理删除部门及用户，角色关系信息
	 * 
	 * @param userId
	 *            用户主键
	 * @return 影响行数
	 */
	public Long delOfficeAndAuth(Long officeId);

    public Long saveBatchOfficeAndRole(List<SysOffice> officeList, List<SysRole> roleList);

    /**
	 * 根据部门及岗位的信息查询 部门及相应岗位的信息（其中用户的的信息为null）
	 * 
	 * @param office
	 *            部门相关信息 
	 * @param role
	 * 			      岗位相关信息
	 * @return 符合条件的部门 含有岗位属性
	 */
    public List<SysOffice> findByOfficeAndRole(SysOffice office,SysRole role);
}
