package com.pzj.dao;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysRole;
import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.SysUserRelation;
import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface SysUserMapper extends BaseUserMapper<SysUser> {

    List<SysUser> findByIdsMap(Map<String, String> map);

    List<SysUser> findByIdList(Map<String, Object> map);

    List<SysUser> findListByObjID(Map<String, Object> params);

    int countByObjID(Map<String, Object> params);

    List<SysUser> findListByRefID(Map<String, Object> params);

    int countByRefID(Map<String, Object> params);

    List<SysUser> findByRole(PageModel pager, SysRole role);

    int countByRole(SysRole role);

    List<SysUser> selectByUserOfficeRole(SysUser user, List<Long> officeIds,
            List<Long> roleIds, PageModel pager);

    int countByUserOfficeRole(SysUser params, List<Long> officeIds,
            List<Long> roleIds);

    List<SysUser> findByRole2(PageModel pager, SysRole role);

    /*List<ProductScenicRelation> findScenicRelationByUserIds(
            Map<String, Object> params);*/

//    List<ProductSalesTool> findWdIdByUserIds(Map<String, Object> params);

    List<SysUser> findListByUR(Map<String, Object> params);

    int countByUR(Map<String, Object> params);

    Long findSupplierId(Map<String, Object> params);
    
    /**
     * 查询跟产品关联的用户（供应商列表）
     * @param params
     * @return
     */
//    List<SysUser> selectSupplierByProduct(Map<String, Object> params);
    
    /**
     * 查询跟产品关联的用户（供应商列表）
     * @param params
     * @return
     */
//    int countSupplierByProduct(Map<String, Object> params);

    /**
     * 根据用户与用户的关联查询被关联的用户
     *
     * @param relation
     * @param user
     * @param pageModel
     * @return
     */
    List<SysUser> selectRefCustomerByRelation(SysUserRelation relation, SysUser user,@Param("isFindMaster") boolean isFindMaster, PageModel pageModel);

    /**
     * 计算用户与用户的关联查询被关联的用户的数量
     * @param relation
     * @param user
     * @return
     */
    int countRefCustomerByRelation(SysUserRelation relation, SysUser user,@Param("isFindMaster") boolean isFindMaster);

    /**
     * 计算{@link #selectUserExclusiveUserRelation}查询数据的总数，用于分页。
     * <p/>
     * 根据用户与用户关联的关系，排他查询没有关联的用户。
     * @param master
     * @param user
     * @return
     */
    int countUserExclusiveUserRelation(@Param("master") SysUser master, @Param("bParam") SysUser user);

    /**
     * 根据用户与用户关联的关系，排他查询没有关联的用户。
     * @param master 关联的主用户
     * @param user 被关联的用户
     * @param page
     * @return
     */
    List<SysUser> selectUserExclusiveUserRelation(@Param("master") SysUser master, @Param("bParam") SysUser user, @Param("page") PageModel page);


    /**
     * 根据客栈信息查询分销端客栈信息，按照客栈的产品审核时间排序
     * @param user
     * @param page
     * @param role
     * @return
     */

//    List<SysUser> selectListForPMS(Map<String, Object> params);


    /**
     * 根据客栈信息查询分销端客栈信息，按照客栈的产品审核时间排序
     * @param params
     * @return
     */

    int countForPMS(Map<String, Object> params);

    /**
     * 根据用户与景区，查询用户
     * @param user
     * @param scenic
     * @return
     */
//    List<SysUser> selectUserWithScenic(@Param("bParam") SysUser user, @Param("scenic") ProductScenic scenic, @Param("page") PageModel page);

    /**
     * 计算{@link #selectUserWithScenic}查询数据的总数，用于分页。
     * @param user
     * @param scenic
     * @return
     */
//    int countUserWithScenic(@Param("bParam") SysUser user, @Param("scenic") ProductScenic scenic);

	/**
     * 根据用户id及推荐人关键字信息查询推荐人信息
     * @param sysUser
     * @return
     */
    List<SysUser> findUserByRefereeInfo(@Param(value = "sysUser") SysUser sysUser);
}