package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.entity.SysOffice;
import com.pzj.base.entity.SysRole;
import com.pzj.base.entity.SysRoleOfficeUserKey;
import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.SysUserOfficeKey;
import com.pzj.base.entity.SysUserRoleKey;
import com.pzj.base.service.sys.IOfficeService;
import com.pzj.base.service.sys.IRoleAuthOfficeService;
import com.pzj.base.service.sys.IRoleService;
import com.pzj.base.service.sys.IUserAuthOfficeService;
import com.pzj.base.service.sys.IUserAuthRoleService;
import com.pzj.base.service.sys.IUserService;
import com.pzj.dao.SysOfficeMapper;

@Service("officeService")
public class OfficeServiceImpl extends
        BaseUserServiceImpl<SysOffice, SysOfficeMapper> implements
        IOfficeService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserAuthOfficeService userAuthOfficeService;

    @Autowired
    private IRoleAuthOfficeService roleAuthOfficeService;

    @Autowired
    private IUserAuthRoleService userAuthRoleService;

    public Long addOfficeAndAuth(SysOffice office, List<SysUser> userList,
            List<SysRole> sysRoleList) {
        /*
        1. 创建或更新部门；
        2. 创建或更新用户，维护部门与用户关系；
        3. 如果存在用户为真，创建或更新角色，维护部门与用户与角色关系；
        4. 如果存在用户为假，创建或更新角色，维护部门与角色关系；
         */

        Long officeId = 0l;
        try {
            if (office == null) {
                logger.error("方法[OfficeService.addOfficeAndAuth],参数office不可以为空");
                return officeId;
            }
            // 新建或更新部门
            insertOrUpdate(office);

            officeId = office.getId();
            if (null == officeId || officeId < 1) {
                return null;
            }
            
            // 新建部门用户及关系
            Boolean isCanRelation = false;
            if (userList != null) {
                saveOfficeAndUser(office, userList, false);
                isCanRelation = true;
            }

            // 添加部门用户角色关系
            if (sysRoleList != null) {
                if (isCanRelation) {
                    // 批量新建或更新角色
                    roleService.insertOrUpdateBatch(sysRoleList);
                    
                    // 添加用户与部门与角色关系
                    Map<String, List<SysRole>> roleMap = new HashMap<String, List<SysRole>>();
                    for (SysUser user : userList) {
                        Long userId = user.getId();
                        if (userId == null || userId < 1)
                            continue;
                        roleMap.put(String.valueOf(userId), sysRoleList);
                    }
                    updateOfficeOR(office, userList, roleMap);
                } else {
                    saveOfficeAndRole(office, sysRoleList, false);
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return officeId;
    }

    public Long addOfficeAndUser(SysOffice office, List<SysUser> userList,
            Map<String, List<SysRole>> sysRoleMap) {
        /*
        1. 创建或更新部门；
        2. 创建或更新用户，维护部门与用户关系；
        3. 创建或更新角色，维护用户与角色关系；
        4. 维护部门与用户与角色关系；
         */

        Long officeId = 0l;
        try {
            if (office == null) {
                logger.error("方法[OfficeService.addOfficeAndAuth],参数office不可以为空");
                return officeId;
            }
            // 新建或更新部门
            insertOrUpdate(office);

            officeId = office.getId();
            if (null == officeId || officeId < 1) {
                return officeId;
            }
            if (userList == null) {
                return officeId;
            }

            // 添加部门用户及关系
            saveOfficeAndUser(office, userList, false); // 可能与
                                                        // insertOrUpdate(office)重复，重复更新部门
            if (sysRoleMap == null) {
                return officeId;
            }

            // 添加角色begin
            List<SysRole> sysRoleList = new ArrayList<SysRole>();
            for (Map.Entry<String, List<SysRole>> entry : sysRoleMap.entrySet()) {
                List<SysRole> list = entry.getValue();
                if (list != null) {
                    sysRoleList.addAll(list);
                }

            }
            roleService.insertOrUpdateBatch(sysRoleList);
            // 添加角色end

            // 添加用户角色关系begin
            List<SysUserRoleKey> urList = new ArrayList<SysUserRoleKey>();
            for (SysUser user : userList) {
                String sysCode = user.getSysCode();
                List<SysRole> roleList = sysRoleMap.get(sysCode);
                if (roleList != null) {
                    Long userId = user.getId();
                    for (SysRole role : roleList) {
                        Long roleId = role.getId();
                        if (null != roleId) {
                            SysUserRoleKey key = new SysUserRoleKey();
                            key.setRoleId(String.valueOf(roleId));
                            key.setUserId(String.valueOf(userId));
                            urList.add(key);
                        }
                    }
                }
            }

            Map<String, String> userIds = userService.getMapIds(userList);

            userAuthRoleService.updateAuthBatch(userIds, urList);
            // 添加用户角色关系end

            // 添加用户部门角色关系
            updateOfficeOR(office, userList, sysRoleMap);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return officeId;
    }

    public Long saveOfficeAndUser(SysOffice office, List<SysUser> userList, boolean isNeedUpdate) {
        Long num = 0l;
        try {
            if (office == null) {
                logger.error("方法[OfficeService.saveOfficeAndUser],参数office不可以为空");
                return num;
            }
            Long officeId = office.getId();
            if (officeId == null || officeId < 1) {
                logger.error("方法[OfficeService.saveOfficeAndUser],参数office的id属性不可以为空");
                return num;
            }
            // 更新用户
            if (isNeedUpdate) {
                num += insertOrUpdate(office);
            }
            
            if (null != userList) {

                // 新建或更新用户
                userService.insertOrUpdateBatch(userList);

                // 创建用户与部门关系集合
                List<SysUserOfficeKey> relationList = resolveUserOfficeRelation(officeId, userList);
                
                List<SysOffice> officeList = new ArrayList<SysOffice>();
                officeList.add(office);
                Map<String, String> idsMap = getMapIds(officeList);
                
                userAuthOfficeService.updateAuthBatch(idsMap, relationList);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;

    }

    private List<SysUserOfficeKey> resolveUserOfficeRelation(Long officeId, List<SysUser> userList){
        List<SysUserOfficeKey> relationList = new ArrayList<SysUserOfficeKey>(userList.size());
        String parentIdString = officeId != null ? String.valueOf(officeId) : null;
        for (SysUser user : userList) {
            Long userId = null;
            if(null == user || (userId = user.getId()) == null || userId < 1)
                continue;

            Long parentId = officeId;
            BaseEntity parent = user.getParentRef();
            if(null == parentIdString){
                if(null == user || (parentId = parent.getId()) == null || parentId < 1)
                    continue;
                parentIdString = parentId.toString();
            }

            SysUserOfficeKey key = new SysUserOfficeKey();
            key.setOfficeId(parentId.toString());
            key.setUserId(userId.toString());
            relationList.add(key);
        }
        return relationList;
    }

    public Long saveOfficeAndRole(SysOffice office, List<SysRole> roleList,
            boolean isNeedUpdate) {
        Long num = 0l;
        try {
            if (office == null) {
                logger.error("方法[OfficeService.saveOfficeAndRole],参数office不可以为空");
                return num;
            }
            // 更新用户
            if (isNeedUpdate) {
                num += insertOrUpdate(office);
            }


            if (null != roleList) {
                // 新建或更新角色
                roleService.insertOrUpdateBatch(roleList);
                
                // 更新用户部门关系
                List<SysRoleOfficeUserKey> relationList = resolveRoleOfficeRelation(office.getId(), roleList);


                List<SysOffice> officeList = new ArrayList<SysOffice>();
                officeList.add(office);
                Map<String, String> idsMap = getMapIds(officeList);
                roleAuthOfficeService.updateAuthBatch(idsMap, relationList);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;

    }

    public Long saveBatchOfficeAndRole(List<SysOffice> office,
            Map<String, List<SysRole>> records, boolean isNeedUpdate) {
        Long num = 0l;
        try {
            if (office == null) {
                logger.error("方法[OfficeService.saveOfficeAndRole],参数office不可以为空");
                return num;
            }
            // 更新部门
            if (isNeedUpdate) {
                num += updateBatchByPrimaryKey(office);
            }
            // 获取所有角色
            if (records != null) {
                List<SysRole> allRoleList = new ArrayList<SysRole>();
                for (Map.Entry<String, List<SysRole>> entry : records
                        .entrySet()) {
                    List<SysRole> value = entry.getValue();
                    if (value != null) {
                        allRoleList.addAll(value);
                    }
                }
                // 新建或更新角色
                num += roleService.insertOrUpdateBatch(allRoleList);

                List<SysRoleOfficeUserKey> relationList = new ArrayList<SysRoleOfficeUserKey>();
                for (Map.Entry<String, List<SysRole>> entry : records
                        .entrySet()) {
                    List<SysRole> value = entry.getValue();
                    String officeId_ = entry.getKey();
                    if (value != null) {
                        for (SysRole record : value) {
                            Long roleId = record.getId();
                            if (roleId != null) {
                                SysRoleOfficeUserKey key = new SysRoleOfficeUserKey();
                                key.setOfficeId(officeId_);
                                key.setRoleId(String.valueOf(roleId));
                                relationList.add(key);
                            }
                        }

                    }

                }
                // 更新用户部门关系
                Map<String, String> idsMap = getMapIds(office);
                num += roleAuthOfficeService.updateAuthBatch(idsMap, relationList);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;

    }

    /**
     * 
     * @param office
     *            部门实体
     * @param userList
     *            用户实体列表
     * @param roleMap
     *            用户对应的角色集合
     * @return
     */
    public Long updateOfficeOR(SysOffice office, List<SysUser> userList,
            Map<String, List<SysRole>> roleMap) {
        Long num = 0l;
        try {
            if (office == null) {
                logger.error("方法[OfficeService.updateOfficeOR],参数office不可以为空");
                return num;
            }
            Long officeId = office.getId();
            if (officeId == null || officeId < 0) {
                logger.error("方法[OfficeService.updateOfficeOR],参数office的officeId不可以为空");
                return num;
            }
            if (userList == null) {
                logger.error("方法[OfficeService.updateOfficeOR],参数userList不可以为空");
                return num;
            }
            if (roleMap == null) {
                logger.error("方法[OfficeService.updateOfficeOR],参数roleMap不可以为空");
                return num;
            }

            List<SysUserOfficeKey> userOfficeList = new ArrayList<SysUserOfficeKey>();
            List<SysRoleOfficeUserKey> updateList = new ArrayList<SysRoleOfficeUserKey>();

            for (Iterator<SysUser> iterator = userList.iterator(); iterator
                    .hasNext();) {
                SysUser sysUser = iterator.next();

                String syscode = sysUser.getSysCode();
                if (StringUtils.isEmpty(syscode)) {
                    logger.error("方法[OfficeService.updateOfficeOR],参数List<SysUser> userList中的SysUser的sysCode不可以为空");
                    return num;
                }

                String officeId_ = String.valueOf(officeId);

                for (SysUser user : userList) {
                    Long userId = user.getId();
                    if (userId == null || userId < 1)
                        continue;
                    String userId_ = String.valueOf(userId);
                    List<SysRole> roleList = roleMap.get(syscode);
                    if (roleList != null) {
                        SysUserOfficeKey userOffice = new SysUserOfficeKey();
                        userOffice.setUserId(userId_);
                        userOffice.setOfficeId(officeId_);
                        userOfficeList.add(userOffice);
                        for (SysRole role : roleList) {
                            Long roleId = role.getId();
                            if (roleId == null || roleId < 1)
                                continue;
                            String roleId_ = String.valueOf(roleId);
                            SysRoleOfficeUserKey key = new SysRoleOfficeUserKey();
                            key.setOfficeId(officeId_);
                            key.setRoleId(roleId_);
                            key.setUserId(userId_);
                            updateList.add(key);
                        }
                    }

                }
            }

            Map<String, String> idsMap = userAuthOfficeService.getRelationIds(userOfficeList);
            num = roleAuthOfficeService.updateAuthBatch(idsMap, updateList);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    public Long delOfficeAndAuth(Long officeId) {
        Long delNum = 0l;
        try {
            if (officeId == null || officeId < 0) {
                logger.error("方法[OfficeService.delOfficeAndAuth],参数officeId不可以为空");
                return delNum;
            }

            delNum += delete(officeId);

            String officeId_ = String.valueOf(officeId);
            // 删除用户与部门之间的关系
            SysUserOfficeKey userOffice = new SysUserOfficeKey();
            userOffice.setOfficeId(officeId_);
            List<SysUserOfficeKey> userOfficeList = new ArrayList<SysUserOfficeKey>();
            userOfficeList.add(userOffice);
            delNum += userAuthOfficeService.delAuthBatch(userOfficeList);

            // 删除用户部门角色的关系
            SysRoleOfficeUserKey roleOffice = new SysRoleOfficeUserKey();
            roleOffice.setOfficeId(officeId_);
            List<SysRoleOfficeUserKey> roleOfficeList = new ArrayList<SysRoleOfficeUserKey>();
            roleOfficeList.add(roleOffice);
            delNum += roleAuthOfficeService.delAuthBatch(roleOfficeList);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return delNum;

    }

    /**
     * 根据父部门Ids
     * 
     */
    public List<SysOffice> findSysOfficeKeyByPids(Map<String, String> pidMap) {
        List<SysOffice> sysOfficeList = null;
        try {
            sysOfficeList = mapper.findByPidsMap(pidMap);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return sysOfficeList;
    }

    public Map<String, String> getMapIds(List<SysOffice> records) {

        if (records == null || records.isEmpty()) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        StringBuffer buff = new StringBuffer();
        for (BaseEntity record : records) {
            Long id = record.getId();
            if (id != null) {
                buff.append(id).append(",");
            }
        }
        map.put(UserGlobalParam.UserMapKeyParam.DEPT_MAP_KEY, buff.substring(0, buff.length() - 1));
        return map;
    }

    @Override
    public Long addOfficeAndUser(SysOffice office, List<SysRole> officeRoles, List<SysUser> officeUsers, Map<String, List<SysRole>> officeUserRoles) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long saveBatchOfficeAndRole(List<SysOffice> officeList, List<SysRole> roleList) {
        Long i = 0L;
        
        if (null != officeList) {
            i += insertOrUpdateBatch(officeList);
        }
        
        if (null != roleList) {
            i += roleService.insertOrUpdateBatch(roleList);

            List<SysRoleOfficeUserKey> relationList = resolveRoleOfficeRelation(null, roleList);
            
            // 更新用户部门关系
            Map<String, String> idsMap = getMapIds(officeList);
            i += roleAuthOfficeService.updateAuthBatch(idsMap, relationList);
        }

        return i;
    }

    private List<SysRoleOfficeUserKey> resolveRoleOfficeRelation(Long officeId, List<SysRole> roleList) {
        List<SysRoleOfficeUserKey> relationList = new ArrayList<SysRoleOfficeUserKey>(roleList.size());
        String parentIdString = officeId != null ? String.valueOf(officeId) : null;

        for (SysRole role : roleList) {
            Long roleId = null;
            if(null == role || (roleId = role.getId()) == null || roleId < 1)
                continue;

            Long parentId = null;
            BaseEntity parent = role.getParentRef();
            if (null == parentIdString) {
                if(null == parent || (parentId = parent.getId()) == null || parentId < 1)
                    continue;
                parentIdString = parentId.toString();
            }
           

            SysRoleOfficeUserKey key = new SysRoleOfficeUserKey();
            key.setOfficeId(parentIdString);
            key.setRoleId(roleId.toString());
            relationList.add(key);
        }
        return relationList;
    }
    /**
	 * 根据部门及岗位的信息查询 部门及相应岗位的信息（其中用户的的信息为null）
	 * 
	 * @param office
	 *            部门相关信息 
	 * @param role
	 * 			      岗位相关信息
	 * @return 符合条件的部门 含有岗位属性
	 */
	public List<SysOffice> findByOfficeAndRole(SysOffice office, SysRole role) {
		return mapper.findByOfficeAndRole(office, role);
	}
}
