package com.pzj.base.service.sys;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.*;
import com.pzj.base.entity.query.User;
import com.pzj.framework.context.Result;

/**
 * 用户接口
 *
 * @author zhangdianliang
 */
public interface IUserService extends IBaseUserService<SysUser> {

    /**
     * 添加用户及用户部门关系信息，用户角色关系信息，用户菜单关系信息,用户标签关系信息
     *
     * @param user           用户
     * @param officeList     用户关联的部门集合
     * @param officeRoleList 部门关联的角色集合
     * @param userRoleList   用户关联的菜单集合
     * @param sysMenuList    用户关联的菜单集合
     * @param channelList    用户关联的渠道集合
     * @param ticketList     用户关联的售票点集合
     * @param mark     		   用于区分是否为财务用户
     * @return 保存后的用户
     */
    SysUser addUserAndAuth(SysUser user, List<SysOffice> officeList,
                           List<SysRole> officeRoleList, List<SysRole> userRoleList,
                           List<SysMenu> sysMenuList, List<SysChannel> channelList, 
                           List<Long> ticketList ,String mark);

    SysUser saveUser(SysUser user);

    /**
     * 保存用户与角色
     * <p/>
     * 如果isNeedUpdate为true，则更新用户
     * 创建或更新角色
     * 维护用户与角色的关系，创建新关系删除无效的旧关系
     *
     * @param user         用户
     * @param roles        角色列表
     * @param isNeedUpdate 是否需要更新用户实体
     * @return 受影响的行数
     */
    Long saveUserAndRole(SysUser user, List<SysRole> roles,
                         boolean isNeedUpdate);

    /**
     * 保存用户与菜单
     * <p/>
     * 如果isNeedUpdate为true，则更新用户
     * 创建或更新菜单
     * 维护用户与菜单的关系，创建新关系删除无效的旧关系
     *
     * @param user         用户
     * @param menus        菜单列表
     * @param isNeedUpdate 是否需要更新用户实体
     * @return 受影响的行数
     */
    Long saveUserAndMenu(SysUser user, List<SysMenu> menus,
                         boolean isNeedUpdate);

    /**
     * 保存用户与部门
     * <p/>
     * 如果isNeedUpdate为true，则更新用户
     * 创建或更新部门
     * 维护用户与部门的关系，创建新关系删除无效的旧关系
     *
     * @param user         用户对象
     * @param officeList   部门实体列表
     * @param isNeedUpdate 是否需要更新用户实体
     * @return 受影响的行数
     */

    Long saveUserAndOffice(SysUser user, List<SysOffice> officeList,
                           boolean isNeedUpdate);

    /**
     * 保存用户与标签
     * <p/>
     * 如果isNeedUpdate为true，则更新用户
     * 创建或更新标签
     * 维护用户与标签的关系，创建新关系删除无效的旧关系
     *
     * @param user         用户对象
     * @param records      标签实体列表
     * @param isNeedUpdate 是否需要更新用户实体
     * @return 受影响的行数
     */
    Long saveUserAndLabel(SysUser user, List<SysLabel> records,
                          boolean isNeedUpdate);

    /**
     * 保存用户与部门、用户与部门与角色的关系
     * <p/>
     * 保存用户与部门之间的关系
     * 保存用户与部门与角色之间的关系
     * <p/>
     * <p/>
     * 本方法只保存关系，所以使用本方法之前，相关的用户、部门、角色应该已保存入数据库中，并各自有id。
     *
     * @param user       用户实体
     * @param officeList 部门列表
     * @param roleMap    部门对应的角色列表。其中key为部门id，value为角色集合
     * @return 受影响的行数
     */
    Long updateUserOR(SysUser user, List<SysOffice> officeList,
                      Map<String, List<SysRole>> roleMap);

    /**
     * 批量保存用户和渠道，及用户和渠道的关联关系
     *
     * @param users
     * @param records
     * @param isNeedUpdateUser
     * @param isNeedUpdateChannel
     * @return
     */
    Long saveBatchUserAndChannel(List<SysUser> users,
                                 Map<String, List<SysChannel>> records, boolean isNeedUpdateUser,
                                 boolean isNeedUpdateChannel);

    /**
     * 批量保存用户和常用信息的关联关系
     *
     * @param users
     * @param records
     * @param type
     * @param isNeedUpdateUser
     * @return
     */
    Long saveBatchUserAndCommonInfo(List<SysUser> users,
                                    Map<String, List<SysUser>> records, String type,
                                    boolean isNeedUpdateUser);

    /**
     * 物理删除用户及部门，菜单，角色关系信息
     *
     * @param userId 用户主键
     * @return 影响行数
     */
    Long delUserAndAuth(Long userId);

    /**
     * 获取当前数据库的用户个数
     *
     * @return 用户条数
     */
    Integer getCount(SysUser user);

    /**
     * 创建用户id的连接字符串
     * <p/>
     * 连接字符串以“,”号分分隔。
     *
     * @param records
     * @return
     */
    Map<String, String> getMapIds(List<SysUser> records);

    /**
     * 通过关系表中的objId获取用户分页集合
     */
    PageList<SysUser> queryPageByObjId(PageModel pager, SysUser user,
                                       Long objId, String refType);

    /**
     * 通过关系表中的refId获取用户分页集合
     */
    PageList<SysUser> queryPageByRefId(PageModel pager, SysUser user,
                                       Long refId, String refType);

    PageList<SysUser> findByRole(Integer start, Integer size,
                                 SysRole role);

    PageList<SysUser> findByUserOfficeRole(PageModel pm, SysUser user,
                                           List<Long> officeIds, List<Long> roleIds);

    Long saveUserAndChannel(SysUser user, List<SysChannel> records,
                            boolean isNeedUpdateUser, boolean isNeedUpdateChannel);

//  @@@  List<ProductScenicRelation> findScenicRelationByUserIds(
//            List<Long> userIdList);

    List<SysUser> findCustomerAllInfoByParams(SysUser userParam);

//  @@@  List<ProductSalesTool> findWdIdByUserIds(List<SysUser> records);

    /**
     * 根据用户参数和角色参数分页查询用户信息
     *
     * @param pager 分页对象
     * @param user  用户实体
     * @param role  角色实体
     * @return
     */
    public PageList<SysUser> queryPageByUR(PageModel pager, SysUser user,
                                           SysRole role);

    /**
     * 获取供应商Id
     */
    Long findSupplierId(String dataSource);

    /**
     * @param pager
     * @param user
     * @return
     */
//  @@@  PageList<SysUser> querySupplierByProduct(PageModel pager, SysUser user);

    /**
     * 根据用户与用户的关联查询被关联的用户
     * @param pm
     * @param relation
     * @param user
     * @return
     */
    PageList<SysUser> findRefCustomerByRelation(SysUserRelation relation, SysUser user, boolean isFindMaster, PageModel pm);

    /**
     * 根据用户与用户关联的关系，排他查询没有关联的用户。
     * @param master 关联的主用户
     * @param user 被关联的用户
     * @param page
     * @return
     */
    PageList<SysUser> findUserExclusiveUserRelation(User master,SysUser user, PageModel page);
    /**
     * 增加财务用户
     * @param entity 关联的主用户
     * 
     * @return 用户id
     */
    Long insertFinancialSysUser(SysUser entity) ;

    /**
     * 根据用户参数和角色参数分页查询分销端的客栈信息
     *
     * @param page 分页对象
     * @param user  用户实体
     * @param role  角色实体
     * @return
     */
//  @@@  PageList<SysUser> findUserForPMS(SysUser user, SysRole role, PageModel page);

    /**
     * 根据用户与景区，查询用户
     * @param user
     * @param scenic
     * @param page
     * @return
     */
// @@@   PageList<SysUser> findUserWithScenic(SysUser user, ProductScenic scenic, PageModel page);
    
	/**
	 * 根据供应商的id来维护用户的相应关系
	 * @version 1.0.1
	 * @describe 此次为解决平台审核时，渠道互斥的问题
	 */
    SysUser addUserAndAuthBySupplierId(SysUser user, List<SysOffice> officeList, List<SysRole> officeRoleList, List<SysRole> userRoleList, List<SysMenu> sysMenuList, List<SysChannel> channelList,
            List<Long> ticketList, String mark) ;
    Long updateUserAndChannelRel(SysUser user, List<SysChannel> records);
    /**
     * @author DongChf
     * 解决用户批量更新时，与大平台渠道互斥的问题
     * @param users 用户
     * @param records 用户要维护的渠道集合
     * @param isNeedUpdateUser 是否需要更新用户
     * @param isNeedUpdateChannel 是否需要更细渠道信息
     * @return 影响的条数
     */
    Long saveBatchUserAndChannelBySupplierIds(List<SysUser> users,
            Map<String, List<SysChannel>> records, boolean isNeedUpdateUser,
            boolean isNeedUpdateChannel);

    /**
     * 查询渠道未绑定的直签分销商
     * @param channelId
     * @param distributorParam
     * @param pageModel
     * @return
     */
    PageList<SysUser> queryChannelUnbundledDirectsDistributor(Long channelId, SysUser distributorParam, PageModel pageModel);


    /**
     * 查询待审核用用户
     * @param userParam
     * @param pageModel
     * @return
     */
    PageList<SysUser> queryPendingAuditedUser(SysUser userParam, PageModel pageModel);

    /**
     * 资质审核通过用户
     * @param userId 被审核用户ID
     * @param auditUserId 审核人ID
     * @return
     */
    Result<Boolean> auditPassUser(Long userId, Long auditUserId);

    /**
     * 资质审核拒绝用户
     * @param userId 被审核用户ID
     * @param auditUserId 审核人ID
     * @param reasonsForRefusal 拒绝理由
     * @return
     */
    Result<Boolean> auditRejectUser(Long userId, Long auditUserId, String reasonsForRefusal);

    /**
     * 修改用户重新审核
     * @param sysUser
     */
    Result modifyUserReAudit(SysUser sysUser);

    /**
     * 用户审核通过
     * @param userId
     * @return
     */
    Result<Boolean> checkUserPass(Long userId, Long checkUserId);

    /**
     * 用户审核拒绝
     * @param userId
     * @return
     */
    Result<Boolean> checkUserReject(Long userId, Long auditUserId, String reasonsForRefusal);

    Result<Boolean> unbundingSupplierAndDirctSingDistributors(Long supplierId, Long distributorsId);

    List<SysUser> findUserByIds(List<Long> ids);

    List<SysUser> findUserByRefereeInfo(Long customerId, String refereeInfo,Integer accountState);
}
