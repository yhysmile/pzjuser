package com.pzj.customer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pzj.authority.entity.DepartmentAuthCustomerRole;
import com.pzj.authority.service.AuthorityUtil;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.common.global.UserGlobalParam.UserMapKeyParam;
import com.pzj.base.common.security.MD5Utils;
import com.pzj.base.entity.*;
import com.pzj.base.service.sys.ILabelRelationService;
import com.pzj.base.service.sys.IUserService;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.channel.service.impl.ChannelVoUtil;
import com.pzj.customer.entity.Customer;
import com.pzj.department.entity.Department;
import com.pzj.department.entity.DepartmentBuilder;
import com.pzj.department.service.DepartmentUtil;
import com.pzj.framework.toolkit.Check;
import com.pzj.menu.entity.Menu;
import com.pzj.menu.service.MenuUtil;
import com.pzj.role.entity.Role;
import com.pzj.role.service.RoleUtil;

@Component
public class CustomerUtil {

    @Autowired
    private IUserService iuserService = null;

    @Autowired
    private ILabelRelationService labelRelationService = null;

    @Autowired
    private AuthorityUtil authorityUtil = null;

    @Autowired
    private DepartmentUtil departmentUtil;

    @Autowired
    private MenuUtil menuUtil;

    @Autowired
    private RoleUtil roleUtil;

    @Autowired
    private ChannelVoUtil channelVoUtil;

    public String getNewSysCode() {
        SysUser sysUser = new SysUser();
        Integer countNum = iuserService.getCount(sysUser);
        return String.format("%04d", countNum);
    }

    /**
     * 根据用户Ids获取用户列表
     *
     * @throws Exception
     */
    public List<Customer> getUserListByUserIds(String userIds)
            throws Exception {
        return getUserListByUserIds(userIds, "1");
    }

    public List<Customer> getUserListByUserIds(String userIds, String delFlag)
            throws Exception {
        Map<String, String> idsMap = new HashMap<>();
        idsMap.put(UserMapKeyParam.USER_MAP_KEY, userIds);
        if (null != delFlag){
            idsMap.put(UserMapKeyParam.DELE_MAP_KEY, delFlag);
        }
        List<Customer> customers = null;
        List<SysUser> users = iuserService.findByIds(idsMap);
        if (users != null && !users.isEmpty()) {
            customers = Customer.sList2CList(users);
        }
        return customers;
    }

    /**
     * 根据用户Ids集合获取用户列表
     *
     * @throws Exception
     */
    public List<Customer> getUserListByIdList(List<Long> ids)
            throws Exception {
        Map<String, Object> idsMap = new HashMap<>();
        idsMap.put(UserMapKeyParam.USER_MAP_KEY, ids);
        idsMap.put(UserMapKeyParam.DELE_MAP_KEY, "1");
        List<Customer> customers = null;
        List<SysUser> users = iuserService.findByIdList(idsMap);
        if (users != null && !users.isEmpty()) {
            customers = Customer.sList2CList(users);
        }
        return customers;
    }

    /**
     * 遍历用户列表，拼接用户Ids
     *
     */
    public String getUserIds(List<Customer> customers) {

        if (customers == null || customers.isEmpty()) {
            return "";
        }
        StringBuffer buff = new StringBuffer();
        for (Customer customer : customers) {
            if (null == customer)
                continue;

            Long id = customer.getId();
            if (id != null) {
                buff.append(id).append(",");
            }
        }
        if (buff.length() > 0) {
            return buff.substring(0, buff.length() - 1);
        } else {
            return "";
        }
    }

    /**
     * 遍历用户列表，用户Id集合
     *
     */
    public List<Long> getUserIdList(List<Customer> customers) {

        if (customers == null || customers.isEmpty()) {
            return null;
        }
        List<Long> idList = new ArrayList<>();
        StringBuffer buff = new StringBuffer();
        for (Customer customer : customers) {
            Long id = customer.getId();
            if (id != null && (buff.indexOf(id + ",") < 0)) {
                buff.append(id).append(",");
                idList.add(id);
            }

        }
        return idList;
    }

    /**
     * 获取用户列表拥有的所有角色列表
     *
     * @throws Exception
     *
     */
    public List<Role> getRoleListByCustomerList(List<Customer> customers)
            throws Exception {
        List<Role> roles = null;

        if (customers != null && !customers.isEmpty()) {
            String userIds = getUserIds(customers);
            List<SysUserRoleKey> userRoleList = authorityUtil
                    .getCustomerRoleList(userIds, null);
            if (userRoleList != null && !userRoleList.isEmpty()) {
                Map<String, String> userRoleIdsMap = authorityUtil.getCustomerRoleIds(userRoleList);
                String roleIds = userRoleIdsMap.get("roleIds");

                roles = roleUtil.getRoleListByRoleIds(roleIds);
            }
        }
        return roles;
    }

    /**
     * 获取用户列表拥有的所有菜单列表
     *
     */
    public List<Menu> getMenuListByCustomerList(List<Customer> customers)
            throws Exception {

        List<Menu> menus = null;
        if (customers != null && !customers.isEmpty()) {
            String userIds = getUserIds(customers);
            List<SysUserMenuKey> userMenuList = authorityUtil.getCustomerMenuList(userIds, null);
            if (userMenuList != null && !userMenuList.isEmpty()) {
                Map<String, String> userMenuIdsMap = authorityUtil.getCustomerMenuIds(userMenuList);
                String menuIds = userMenuIdsMap.get("menuIds");
                menus = menuUtil.getMenuListByMenuIds(menuIds);
            }
        }
        return menus;
    }

    /**
     * 获取用户列表拥有的所有部门列表
     *
     */
    public List<Department> getDepartmentListByCustomerList(
            List<Customer> customers) throws Exception {

        List<Department> departs = null;
        if (customers != null && !customers.isEmpty()) {
            String userIds = getUserIds(customers);
            List<SysUserOfficeKey> userofficeList = authorityUtil.getCustomerDepartmentList(userIds, null);
            if (userofficeList != null && !userofficeList.isEmpty()) {

                Map<String, String> userofficeIdsMap = authorityUtil.getCustomerDepartmentIds(userofficeList);
                String officeIds = userofficeIdsMap.get("officeIds");
                departs = departmentUtil.getDeptListByIds(officeIds);

            }
        }
        return departs;
    }

    /**
     * 给用户封装对应的有效角色列表
     *
     * @throws Exception
     *
     */
    public void setCustomerRoleList(List<Customer> customers)
            throws Exception {
        if (customers != null && !customers.isEmpty()) {
            String userIds = getUserIds(customers);
            List<SysUserRoleKey> userRoleList = authorityUtil.getCustomerRoleList(userIds, null);
            if (userRoleList != null && !userRoleList.isEmpty()) {
                Map<String, String> userRoleIdsMap = authorityUtil.getCustomerRoleIds(userRoleList);
                String roleIds = userRoleIdsMap.get("roleIds");

                List<Role> roles = roleUtil.getRoleListByRoleIds(roleIds);
                if (roles != null && !roles.isEmpty()) {
                    for (Customer customer : customers) {
                        List<Role> roleList = new ArrayList<>();
                        String userId = String.valueOf(customer.getId());
                        for (SysUserRoleKey userRole : userRoleList) {
                            if (userId.equals(userRole.getUserId())) {
                                for (Role role : roles) {
                                    if (userRole.getRoleId().equals(
                                            String.valueOf(role.getId()))) {
                                        roleList.add(role);
                                    }
                                }
                            }

                        }
                        customer.setRoleList(roleList);

                    }
                }

            }

        }

    }

    public void setCustomerRoleList(Customer customer) throws Exception {
        if (null == customer)
            return;

        String userIds = customer.getId().toString();

        List<SysUserRoleKey> userRoleList = authorityUtil.getCustomerRoleList(
                userIds, null);
        if (userRoleList == null || userRoleList.isEmpty())
            return;

        Map<String, String> userRoleIdsMap = authorityUtil
                .getCustomerRoleIds(userRoleList);
        String roleIds = userRoleIdsMap.get("roleIds");

        List<Role> roles = roleUtil.getRoleListByRoleIds(roleIds);
        if (roles != null && !roles.isEmpty())
            customer.setRoleList(roles);
    }

    /**
     * 给用户封装对应的景区主键集合
     *
     * @throws Exception
     *
     */
    /*public void setCustomerScenicIdList(List<Customer> customers)
            throws Exception {
        if (customers != null && !customers.isEmpty()) {
            List<Long> idList = getUserIdList(customers);
            List<ProductScenicRelation> relationList = iuserService
                    .findScenicRelationByUserIds(idList);
            if (relationList != null && !relationList.isEmpty()) {
                for (Customer customer : customers) {
                    Long id = customer.getId();
                    if (id == null)
                        continue;
                    List<Long> scenicIds = new ArrayList<>();
                    for (ProductScenicRelation relation : relationList) {
                        Long relId = relation.getRelId();
                        Long scenicId = relation.getScenicId();
                        if (relId == null)
                            continue;
                        if (scenicId == null)
                            continue;
                        if (id.equals(relId)) {
                            scenicIds.add(scenicId);
                        }
                    }
                    customer.setScenicList(scenicIds);
                }
            }

        }

    }*/

    /**
     * 给用户封装对应的景区主键集合
     *
     * @throws Exception
     *
     */
    /*public void setCustomerWdIdList(List<Customer> customers)
            throws Exception {
        if (customers != null && !customers.isEmpty()) {
            List<SysUser> userList = new ArrayList<>();
            StringBuffer buff = new StringBuffer();
            for (Customer bean : customers) {
                String loginName = bean.getLoginName();
                if (StringUtils.isNotBlank(loginName)
                        && buff.indexOf(loginName + ",") < 0) {
                    userList.add(Customer.changeTSysUser(bean));
                    buff.append(loginName).append(",");
                }
            }

            List<ProductSalesTool> relationList = iuserService
                    .findWdIdByUserIds(userList);
            if (relationList != null && !relationList.isEmpty()) {
                for (Customer customer : customers) {
                    String loginName = customer.getLoginName();
                    if (StringUtils.isBlank(loginName))
                        continue;
                    List<Long> wdids = new ArrayList<>();
                    for (ProductSalesTool tool : relationList) {
                        if (tool.getId() == null)
                            continue;
                        String toolName = tool.getToolName();
                        if (StringUtils.isBlank(toolName))
                            continue;
                        if (loginName.equals(toolName)) {
                            wdids.add(tool.getId());
                        }
                    }
                    customer.setWdList(wdids);
                }
            }

        }

    }*/

    /**
     * 判断用户登录名是否唯一
     */
    public Integer validCustomerName(String customerId, String loginName) {
        Integer num = 0;
        return num;
    }

    /**
     * 给用户封装对应的有效菜单列表
     *
     * @throws Exception
     *
     */
    public void setCustomerMenuList(List<Customer> customers)
            throws Exception {
        if (customers != null && !customers.isEmpty()) {
            String userIds = getUserIds(customers);
            List<SysUserMenuKey> userMenuList = authorityUtil
                    .getCustomerMenuList(userIds, null);
            if (userMenuList != null && !userMenuList.isEmpty()) {
                Map<String, String> userMenuIdsMap = authorityUtil
                        .getCustomerMenuIds(userMenuList);
                String menuIds = userMenuIdsMap.get("menuIds");
                List<Menu> menus = menuUtil.getMenuListByMenuIds(menuIds);
                if (menus != null && !menus.isEmpty()) {
                    for (Customer customer : customers) {

                        List<Menu> menuList = new ArrayList<>();
                        String userId = String.valueOf(customer.getId());
                        for (SysUserMenuKey userMenu : userMenuList) {

                            if (userId.equals(userMenu.getUserId())) {
                                for (Menu menu : menus) {
                                    if (userMenu.getMenuId().equals(
                                            String.valueOf(menu.getId()))) {
                                        menuList.add(menu);
                                    }
                                }
                            }

                        }
                        customer.setMenuList(menuList);
                    }
                }
            }
        }
    }

    /**
     * 给用户封装对应的有效部门列表
     *
     * @param customers
     *
     * @throws Exception
     *
     */
    public void setCustomerOfficeList(List<Customer> customers)
            throws Exception {
        if (customers == null || customers.isEmpty()) {
            return;
        }

        String userIds = getUserIds(customers);
        List<SysUserOfficeKey> userOfficeList = authorityUtil
                .getCustomerDepartmentList(userIds, null);
        if (userOfficeList == null || userOfficeList.isEmpty()) {
            return;
        }

        Map<String, String> userOfficeIdsMap = authorityUtil
                .getCustomerDepartmentIds(userOfficeList);
        String officeIds = userOfficeIdsMap.get("officeIds");
        List<Department> offices = departmentUtil.getDeptListByIds(officeIds);

        if (offices == null || offices.isEmpty()) {
            return;
        }

        for (Customer customer : customers) {
            List<Department> departList = new ArrayList<>();
            String userId = String.valueOf(customer.getId());
            for (SysUserOfficeKey userOffice : userOfficeList) {
                if (userId.equals(userOffice.getUserId())) {
                    for (Department depart : offices) {
                        if (userOffice.getOfficeId().equals(
                                String.valueOf(depart.getId()))) {
                            departList.add(depart);
                        }
                    }
                }

            }
            customer.setDepartmentList(departList);
        }
    }

    public void setCustomerChannelList(List<Customer> customers)
            throws Exception {
        if (customers == null || customers.isEmpty()) {
            return;
        }

        String userIds = getUserIds(customers);
        List<SysLabelRelationKey> relationList = authorityUtil.getRelationList(
                null, userIds, ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
        if (relationList == null || relationList.isEmpty()) {
            return;
        }

        Map<String, String> idsMap = authorityUtil.getRelationIds(relationList);
        String channelIds = idsMap.get(ChannelMapKeyParam.OBJ_MAP_KEY);
        List<ChannelVo> channels = channelVoUtil.getRecordListByIds(channelIds);

        if (channels == null || channels.isEmpty()) {
            return;
        }

        for (Customer customer : customers) {
            List<ChannelVo> list = new ArrayList<>();
            String userId = String.valueOf(customer.getId());
            for (SysLabelRelationKey bean : relationList) {
                if (userId.equals(bean.getRelId())) {
                    for (ChannelVo vo : channels) {
                        if (bean.getObjId().equals(String.valueOf(vo.getId()))) {
                            list.add(vo);
                        }
                    }
                }

            }
            customer.setChannelVoList(list);
        }
    }

    public void setCustomerChannel(Customer customer) throws Exception {
        if (customer == null) {
            return;
        }
        List<Customer> cList = new ArrayList<>();
        cList.add(customer);
        setCustomerChannelList(cList);
    }

    public Customer getCustomerChannelById(Long customerId)
            throws Exception {
        Customer bean = null;
        if (customerId == null) {
            return null;
        }
        List<Long> ids = new ArrayList<>();
        ids.add(customerId);
        List<Customer> cList = getUserListByIdList(ids);
        if (cList != null && !cList.isEmpty()) {
            setCustomerChannelList(cList);
            bean = cList.get(0);
        }
        return bean;

    }

    /**
     * 给用户封装对应的有效部门列表，角色列表，菜单列表
     *
     * @throws Exception
     *
     */
    public void setCustomerAuthorityList(List<Customer> customers)
            throws Exception {
        if (customers != null && !customers.isEmpty()) {

            // 用户封装部门列表
            setCustomerOfficeList(customers);

            // 用户封装角色列表
            setCustomerRoleList(customers);

            // 用户封装菜单列表
            setCustomerMenuList(customers);

            // 用户封装用户部门角色关系列表
            setCustomerDCRList(customers);

            // 用户封装渠道列表
            setCustomerChannelList(customers);

            // 封装用户关联的售票点ID集合
            setCustomerTicketList(customers);
        }

    }

    private List<Long> findTicketIdByCustomer(Long customerId) {
        SysLabelRelationKey relation = new SysLabelRelationKey();

        if (null != customerId)
            relation.setObjId(customerId.toString());

        relation.setRelType(UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_TICKET_TYPE);

        List<SysLabelRelationKey> relationList = labelRelationService
                .findListByParams(relation);

        if (null != relationList) {
            List<Long> result = new ArrayList<>(relationList.size());
            for (SysLabelRelationKey key : relationList) {
                if (null == key)
                    continue;
                if (null != key.getRelId())
                    result.add(Long.valueOf(key.getRelId()));
            }
            return result;
        }

        return null;
    }

    /**
     * 将部门列表封装到对应的用户列表里
     *
     */
    public void setDepartmentListTCustomerList(List<Customer> customers,
                                                      List<Department> deptList) {

        if (customers != null && !customers.isEmpty()) {
            String userIds = getUserIds(customers);
            List<SysUserOfficeKey> userOfficeList = authorityUtil
                    .getCustomerDepartmentList(userIds, null);
            if (userOfficeList != null && !userOfficeList.isEmpty()) {

                if (deptList != null && !deptList.isEmpty()) {
                    for (Customer customer : customers) {
                        List<Department> departList = new ArrayList<>();
                        String userId = String.valueOf(customer.getId());
                        for (SysUserOfficeKey userOffice : userOfficeList) {
                            if (userId.equals(userOffice.getUserId())) {
                                for (Department depart : deptList) {
                                    if (userOffice.getOfficeId().equals(
                                            String.valueOf(depart.getId()))) {
                                        departList.add(depart);
                                    }
                                }
                            }

                        }
                        customer.setDepartmentList(departList);

                    }
                }

            }

        }
    }

    /**
     * 将角色列表封装到对应的用户列表里
     *
     */
    public void setRoleListTCustomerList(List<Customer> customers,
                                                List<Role> roles) {

        if (customers != null && !customers.isEmpty()) {
            String userIds = getUserIds(customers);
            List<SysUserRoleKey> userRoleList = authorityUtil
                    .getCustomerRoleList(userIds, null);
            if (userRoleList != null && !userRoleList.isEmpty()) {

                if (roles != null && !roles.isEmpty()) {
                    for (Customer customer : customers) {
                        List<Role> roleList = new ArrayList<>();
                        String userId = String.valueOf(customer.getId());
                        for (SysUserRoleKey userRole : userRoleList) {
                            if (userId.equals(userRole.getUserId())) {
                                for (Role role : roles) {
                                    if (userRole.getRoleId().equals(
                                            String.valueOf(role.getId()))) {
                                        roleList.add(role);
                                    }
                                }
                            }

                        }
                        customer.setRoleList(roleList);

                    }
                }

            }

        }
    }

    /**
     * 将菜单列表封装到对应的用户列表里
     *
     */
    public void setMenuListTCustomerList(List<Customer> customers,
                                                List<Menu> menus) {

        if (customers != null && !customers.isEmpty()) {
            String userIds = getUserIds(customers);
            List<SysUserMenuKey> userMenuList = authorityUtil
                    .getCustomerMenuList(userIds, null);
            if (userMenuList != null && !userMenuList.isEmpty()) {
                if (menus != null && !menus.isEmpty()) {
                    for (Customer customer : customers) {

                        List<Menu> menuList = new ArrayList<>();
                        String userId = String.valueOf(customer.getId());
                        for (SysUserMenuKey userMenu : userMenuList) {

                            if (userId.equals(userMenu.getUserId())) {
                                for (Menu menu : menus) {
                                    if (userMenu.getMenuId().equals(
                                            String.valueOf(menu.getId()))) {
                                        menuList.add(menu);
                                    }
                                }
                            }

                        }
                        customer.setMenuList(menuList);
                    }
                }
            }
        }
    }

    /**
     * 给用户封装部门用户角色对应关系
     *
     * @throws Exception
     *
     */
    public void setCustomerDCRList(List<Customer> customerList)
            throws Exception {
        if (customerList != null && !customerList.isEmpty()) {
            String userIds = getUserIds(customerList);

            List<SysRoleOfficeUserKey> roleOfficeList = authorityUtil
                    .getRoleOfficeList(null, null, userIds);

            if (roleOfficeList != null && !roleOfficeList.isEmpty()) {
                for (Customer customer : customerList) {
                    String userId = String.valueOf(customer.getId());
                    List<DepartmentAuthCustomerRole> dcrList = new ArrayList<>();
                    for (SysRoleOfficeUserKey rouKey : roleOfficeList) {
                        if (userId.equals(rouKey.getUserId())) {
                            DepartmentAuthCustomerRole dcrKey = DepartmentAuthCustomerRole
                                    .changeTDepartmentAuthCustomerRole(rouKey);
                            dcrList.add(dcrKey);
                        }
                    }
                    customer.setDcrList(dcrList);
                }
            }

        }
    }

    public void setCustomerDepartmentRole(List<Customer> customerList)
            throws Exception {
        setCustomerDepartmentRole(customerList, null);
    }

    public void setCustomerTicketList(List<Customer> customerList) {
        if (Check.NuNCollections(customerList))
            return;

        for (Customer customer : customerList) {
            List<Long> ticketList = findTicketIdByCustomer(customer.getId());
            customer.setSalePointList(ticketList);
        }
    }

    public void setCustomerDepartmentRole(List<Customer> customerList,
                                                 String commonFlag01) throws Exception {
        if (customerList == null || customerList.isEmpty())
            return;

        setCustomerDCRList(customerList);

        List<String> departmentIdList = new ArrayList<>();
        List<String> roleIdList = new ArrayList<>();

        String delFlag = commonFlag01;
        if (delFlag == null)
            delFlag = "1";

        for (Customer customer : customerList) {
            List<DepartmentAuthCustomerRole> dcrList = customer.getDcrList();

            if (dcrList == null)
                continue;

            for (DepartmentAuthCustomerRole dcr : dcrList) {
                String departmentId = dcr.getDepartmentId();
                String roleId = dcr.getRoleId();

                if (!departmentIdList.contains(departmentId)) {
                    departmentIdList.add(departmentId);
                }
                if (!roleIdList.contains(roleId)) {
                    roleIdList.add(roleId);
                }
            }

        }

        String departmentIds = departmentUtil.getDeptIdsOfString(departmentIdList);
        List<Department> deptResult = departmentUtil.getDeptListByIds(departmentIds);
        String roleIds = roleUtil.getRoleIdsOfString(roleIdList);
        List<Role> roleResult = roleUtil.getRoleListByRoleIds(roleIds, delFlag);

        Map<String, Department> departmentMap = null;
        Map<String, Role> roleMap = null;
        if (deptResult != null) {
            departmentMap = new HashMap<>(deptResult.size());
            for (Department depart : deptResult) {
                departmentMap.put(depart.getId().toString(), depart);
            }
        }
        if (roleResult != null) {
            roleMap = new HashMap<>(roleResult.size());
            for (Role role : roleResult) {
                roleMap.put(role.getId().toString(), role);
            }
        }
        if (departmentMap != null) {
            for (Customer customer : customerList) {
                List<DepartmentAuthCustomerRole> dcrList = customer
                        .getDcrList();
                if (dcrList == null || dcrList.isEmpty()) {
                    continue;
                }
                List<Department> departmentList = customer.getDepartmentList();
                if (departmentList == null) {
                    departmentList = new ArrayList<>();
                    customer.setDepartmentList(departmentList);
                }

                Map<String, Department> customerDepartmentMap = new HashMap<>();

                for (DepartmentAuthCustomerRole dcr : dcrList) {
                    String departmentId = dcr.getDepartmentId();
                    String roleId = dcr.getRoleId();

                    Department department = customerDepartmentMap
                            .get(departmentId);
                    if (department == null) {
                        Department dep = departmentMap.get(departmentId);
                        department = DepartmentBuilder.ADepartmentBuilder.copy(dep);
                        departmentList.add(department);
                        customerDepartmentMap.put(departmentId, department);
                    }

                    if (roleMap != null) {
                        List<Role> roleList = department.getList();
                        if (roleList == null) {
                            roleList = new ArrayList<>();
                            department.setList(roleList);
                        }

                        Role role = roleMap.get(roleId);
                        if (null != role)
                            roleList.add(role);
                    }
                }
            }
        }
    }

    /**
     * 判断当前Token是否有效
     *
     * @throws Exception
     */
    public boolean isTokenValid(String token) throws Exception {

        // String sCustomer = (String) redisTemplate.opsForValue().get(token);
        // byte[] bytes = sCustomer.getBytes();
        // Customer returnCustomer = (Customer)
        // SerializeUtil.unserialize(bytes);
        // if (returnCustomer != null) {
        // return true;
        // }
        return false;

    }

    /**
     * md5生成token
     *
     * @param customer
     * @return
     */
    public String genTokenKey(Customer customer) {
        String key = customer.getId() + customer.getLoginName()
                + customer.getLoginPasswd();
        return MD5Utils.getMD5DigestHex(key);
    }

    /**
     * md5生成token
     *
     * @param customer
     * @return
     */
    public String genTokenKeyFromOpenid(Customer customer) {
        return MD5Utils.getMD5DigestHex(customer.getWxOpenid());
    }
}
