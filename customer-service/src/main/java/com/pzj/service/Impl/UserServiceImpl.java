package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.core.customer.channel.mq.ChannelMqMessage;
import com.pzj.core.customer.profile.mq.CreateCustomer;
import com.pzj.core.customer.profile.mq.CustomerMqMessage;
import com.pzj.core.customer.profile.mq.ModifyCustomer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.pzj.base.common.BaseDataSourceEntity;
import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.common.global.UserGlobalParam.UserMapKeyParam;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.entity.SysMenu;
import com.pzj.base.entity.SysOffice;
import com.pzj.base.entity.SysRole;
import com.pzj.base.entity.SysRoleOfficeUserKey;
import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.SysUserDraft;
import com.pzj.base.entity.SysUserMenuKey;
import com.pzj.base.entity.SysUserMicroshop;
import com.pzj.base.entity.SysUserOfficeKey;
import com.pzj.base.entity.SysUserRelation;
import com.pzj.base.entity.SysUserRoleKey;
import com.pzj.base.entity.query.SysUserDraftQuery;
import com.pzj.base.entity.query.User;
import com.pzj.base.service.sys.IChannelService;
import com.pzj.base.service.sys.ILabelRelationService;
import com.pzj.base.service.sys.ILabelService;
import com.pzj.base.service.sys.IMenuService;
import com.pzj.base.service.sys.IOfficeService;
import com.pzj.base.service.sys.IRoleAuthOfficeService;
import com.pzj.base.service.sys.IRoleService;
import com.pzj.base.service.sys.ISysUserRelationService;
import com.pzj.base.service.sys.IUserAuthMenuService;
import com.pzj.base.service.sys.IUserAuthOfficeService;
import com.pzj.base.service.sys.IUserAuthRoleService;
import com.pzj.base.service.sys.IUserDraftService;
import com.pzj.base.service.sys.IUserService;
import com.pzj.common.error.UserErrorCode;
import com.pzj.core.customer.utils.UserConfig;
import com.pzj.core.customer.dao.SysUserMapper;
import com.pzj.framework.context.Result;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl extends BaseUserServiceImpl<SysUser, SysUserMapper> implements IUserService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserConfig userConfig;

	@Autowired
	private IOfficeService officeService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IMenuService menuService;

	@Autowired
	private ILabelService labelService;

	@Autowired
	private IChannelService channelService;

	@Autowired
	private IUserAuthOfficeService userAuthOfficeService;

	@Autowired
	private IUserAuthRoleService userAuthRoleService;

	@Autowired
	private IUserAuthMenuService userAuthMenuService;

	@Autowired
	private IRoleAuthOfficeService roleAuthOfficeService;

	@Autowired
	private ILabelRelationService labelRelationService;

	@Autowired
	private ISysUserRelationService sysUserRelationService;

	@Autowired
	private IUserDraftService userDraftService;

	@Autowired
	private UserMicroshopServiceImpl userMicroshopService;

	@Autowired
	private CustomerMqMessage customerMqMessage;

	@Resource
	private ChannelMqMessage channelMqMessage;

	Set<Integer> auditCheckTypes = new HashSet<>(2);

	public UserServiceImpl() {
		auditCheckTypes.add(UserGlobalDict.UserCheckType.USER_AUDIT);
		auditCheckTypes.add(UserGlobalDict.UserCheckType.QUALIFICATION_AUDIT);
	}

	public int countByParams(SysUser param) {
		Map<String, Object> params = new HashMap<>(1);
		params.put("bParam", param);
		return mapper.countByParamMap(params);
	}

	@Override
	public Integer delete(Long id) {
		if (id == null) {
			String msg = "id不可以为空";
			logger.error(msg);
			return null;
		}

		SysUser user = mapper.selectByPrimaryKey(id);
		if (user != null){
			SysUser updateUser = new SysUser();
			updateUser.setId(user.getId());
			updateUser.setAccountState(GlobalParam.FLAG.del());
			return updateByPrimaryKey(updateUser);
		}
		return 0;
	}

	@Override
	public SysUser getById(Long id) {
		if (id == null) {
			String msg = "id不可以为空";
			logger.error(msg);
			return null;
		}
		SysUser sysUser = mapper.selectByPrimaryKey(id);

		if (sysUser != null && (sysUser.getName() == null || sysUser.getName().trim().length() == 0)){
			sysUser.setName(sysUser.getCorporater());
		}
		return sysUser;
	}


	@Override
	public List<SysUser> findListByParams(SysUser entity) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bParam", entity);
		List<SysUser> listBean = mapper.queryByParamMap(params);

		if (listBean !=null){
			for (SysUser user : listBean){
				if (user != null && (user.getName() == null || user.getName().trim().length() == 0)){
					user.setName(user.getCorporater());
				}
			}
		}

		return listBean;
	}


	@Override
	public Long insert(SysUser entity) {
		Long id = super.insert(entity);

		// 增加判断条件，查看用户是否输入登陆名 或 密码
		// 若未输入 将用户的id设为登陆名 默认密码为123456
		if (null == entity.getLoginName()) {
			entity.setLoginName(id.toString());
		}
		if (null == entity.getLoginPasswd()) {
			entity.setLoginPasswd("123456");
		}
		if (entity.getIsRoot() != null && entity.getIsRoot().equals("1")){
			List<Long> ids = new ArrayList<>(1);
			ids.add(entity.getId());
			CreateCustomer createCustomer = new CreateCustomer();
			createCustomer.setCustomerIds(ids);
			createCustomer.setSupplierId(entity.getSupplierId());
			if (entity.getCreateBy() != null){
				createCustomer.setOperatorId(Long.valueOf(entity.getCreateBy()));
			}
			createCustomer.setOperatingDate(entity.getCreateDate());
			customerMqMessage.sendCreateCustomerMsg(createCustomer);
		}

		savePassword(entity);
		return id;
	}


	@Override
	public Integer updateByPrimaryKey(SysUser entity) {
		Integer num = 0;
		if (entity == null || entity.getId() == null) {
			String msg = "操作数据不可以为空";
			logger.error(msg);
			return num;
		}
		logger.info("更新对象：{}", entity);

		if (entity.getAccountState() == null){
			num = mapper.updateByPrimaryKey(entity);
		} else {
			SysUser user = mapper.selectByPrimaryKey(entity.getId());

			if (user == null){
				return num;
			}

			num = mapper.updateByPrimaryKey(entity);

			if (user.getIsRoot() != null && user.getIsRoot().equals("1")){
				if (num > 0 && (user.getAccountState() == null || !user.getAccountState().equals(entity.getAccountState()))){
					ModifyCustomer modifyCustomer = new ModifyCustomer(entity.getId());
					modifyCustomer.setOldStatus(user.getAccountState());
					modifyCustomer.setNewStaus(entity.getAccountState());
					if (entity.getUpdateBy() != null) {
						modifyCustomer.setOperatorId(Long.valueOf(entity.getUpdateBy()));
					}
					modifyCustomer.setOperatingDate(entity.getUpdateDate());
					customerMqMessage.sendCustomerStateMsg(modifyCustomer);
				}
			}
		}

		return num;
	}

	/**
	 * 增加财务用户，使用两次加密后的密码
	 */
	@Override
	public Long insertFinancialSysUser(SysUser entity) {
		if (entity.getId() == null) {
			Long id = super.insert(entity);
			savePasswordFinancial(entity);
			return id;
		} else {
			updateByPrimaryKey(entity);
			return entity.getId();
		}
	}

	/**
	 * 财务用户更新密码
	 * 
	 * @param entity
	 *            用户信息
	 */
	private void savePasswordFinancial(SysUser entity) {
		String genPassword = PasswordGenerateUtil.generatePasswordTwice(entity.getId(), entity.getLoginName(),
				entity.getLoginPasswd());
		entity.setLoginPasswd(genPassword);
		updateByPrimaryKey(entity);
	}

	/**
	 * 普通用户更密码
	 * 
	 * @param entity
	 */
	private void savePassword(SysUser entity) {
		String genPassword = PasswordGenerateUtil.generatePassword(entity.getId(), entity.getLoginName(),
				entity.getLoginPasswd());
		entity.setLoginPasswd(genPassword);
		updateByPrimaryKey(entity);
	}

	/**
	 * @param mark
	 *            用于区分是否为财务用户
	 */
	@Override
	public SysUser addUserAndAuth(SysUser user, List<SysOffice> officeList, List<SysRole> officeRoleList,
			List<SysRole> userRoleList, List<SysMenu> sysMenuList, List<SysChannel> channelList, List<Long> ticketList,
			String mark) {
		/*
		 * 1. 创建或更新用户； 2. 创建或更新标签，维护标签与用户的关系； 3. 创建或更新菜单，维护菜单与用户的关系； 4.
		 * 创建或更新部门，维护部门与用户的关系； 5. 创建或更新角色，维护角色与用户的关系； 6. 维护用户与部门与角色的关系； 7.
		 * 维护用户与售票点的关系；
		 */

		Long userId = null;

		if (user == null) {
			logger.error("方法[UserService.addUserAndAuth],参数user不可以为空");
			return user;
		}

		try {
			// 1. 创建或更新用户
			if ("financial".equals(mark)) {
				// 创建财务用户
				insertFinancialSysUser(user);
			} else {
				// 创建普通用户
				insertOrUpdate(user);
			}
			userId = user.getId();
			if (null != userId && userId > 0) {
				// XXX 以下2～5中有相同的步骤，获取用户id的连接字符串，相同重复的代码，可优化共用一个！

				// 2. 创建或更新渠道，维护渠道与用户的关系
				if (channelList != null) {
					saveUserAndChannel(user, channelList, false, false);
				}

				// 3. 创建或更新菜单，维护菜单与用户的关系
				if (sysMenuList != null) {
					saveUserAndMenu(user, sysMenuList, false);
				}

				// 4. 创建或更新部门，维护部门与用户的关系
				if (officeList != null) {
					saveUserAndOffice(user, officeList, false); // 这里出错
				}

				// 5. 创建或更新角色，维护角色与用户的关系
				boolean copyRoleMenu = (sysMenuList == null && officeRoleList == null && userRoleList != null);
				if (userRoleList != null) {
					saveUserAndRole(user, userRoleList, false, copyRoleMenu);
				}

				// 6. 维护用户与部门与角色的关系
				if (null != officeRoleList && null != officeList) {
					roleService.insertOrUpdateBatch(officeRoleList);

					// 6.2 保存[用户与部门与角色的关系]
					updateUserOR(user, officeList, officeRoleList);
				}

				// 7. 维护用户与售票点的关系
				if (null != ticketList) {
					labelRelationService.saveUserTicket(userId, ticketList);
				}

				List<SysUserRelation> userRelationList = user.getUserRelationList();
				saveUserRelatin(userId, userRelationList);
			}

			SysUser result = getById(userId);
			return result;
		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	private void saveUserRelatin(Long userId, List<SysUserRelation> userRelationList) {
		if (CollectionUtils.isEmpty(userRelationList))
			return;

		boolean isMaster = false;

		Iterator<SysUserRelation> iterator = userRelationList.iterator();
		while (iterator.hasNext()) {
			SysUserRelation userRelation = iterator.next();
			if (StringUtils.isBlank(userRelation.getRelType()))
				iterator.remove();
			if (userRelation.getUserId() == null) {
				userRelation.setUserId(userId);
				isMaster = true;
			} else if (userRelation.getRelUserId() == null)
				userRelation.setRelUserId(userId);
		}
		if (CollectionUtils.isNotEmpty(userRelationList)) {
			Map<String, String> relationIds = sysUserRelationService.getRelationIds(userRelationList);
			if (isMaster)
				relationIds.remove(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY);
			sysUserRelationService.updateAuthBatch(relationIds, userRelationList);
		}
	}

	@Override
	public Long saveUserAndOffice(SysUser user, List<SysOffice> records, boolean isNeedUpdate) {
		/*
		 * 1. 如果isNeedUpdate为true，则更新用户； 2. 创建或更新部门； 3.
		 * 维护用户与部门的关系，创建新关系删除无效的旧关系；
		 */

		// 返回值，受影响的行数
		Long num = 0l;
		try {
			if (user == null) {
				logger.error("方法[UserService.saveUserAndOffice],参数user不可以为空");
				return num;
			}
			if (user.getId() == null || user.getId() < 1) {
				logger.error("方法[UserService.saveUserAndOffice],参数user的id属性不可以为空");
				return num;
			}
			// 1. 更新用户
			if (isNeedUpdate) {
				num += updateByPrimaryKey(user);
			}

			if (null != records) {
				// 2. 创建或更新部门
				num += officeService.insertOrUpdateBatch(records);

				// 3. 维护用户与部门的关系，创建新关系删除无效的旧关系；
				// 3.1 创建关系集合
				List<SysUserOfficeKey> relationList = new ArrayList<SysUserOfficeKey>();
				// 循环菜单集合，创建用户与部门的关系
				for (SysOffice record : records) {
					Long officeId = record.getId();
					if (officeId != null) {
						// 创建关系
						SysUserOfficeKey key = new SysUserOfficeKey();
						key.setUserId(String.valueOf(user.getId())); // 设置关系中的用户id
						key.setOfficeId(String.valueOf(officeId)); // 设置关系中的部门id
						// 将关系保存到关系集合
						relationList.add(key);
					}
				}

				// 3.2 获取所有用户的id的连接字符串的map
				List<SysUser> userList = new ArrayList<SysUser>();
				userList.add(user);
				Map<String, String> idsMap = getMapIds(userList);

				// 3.3 创建新关系删除无效的旧关系
				num += userAuthOfficeService.updateAuthBatch(idsMap, relationList);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public Long saveUserAndRole(SysUser user, List<SysRole> records, boolean isNeedUpdate) {
		return saveUserAndRole(user, records, isNeedUpdate, true);
	}

	public Long saveUserAndRole(SysUser user, List<SysRole> records, boolean isNeedUpdate, boolean copeRoleMenu) {
		/*
		 * 1. 如果isNeedUpdate为true，则更新用户； 2. 创建或更新角色； 3.
		 * 维护用户与角色的关系，创建新关系删除无效的旧关系。
		 */

		// 返回值，受影响的行数
		Long num = 0l;
		try {
			if (user == null) {
				logger.error("方法[UserService.saveUserAndRole],参数user不可以为空");
				return num;
			}
			if (user.getId() == null || user.getId() < 1) {
				logger.error("方法[UserService.saveUserAndRole],参数user的id属性不可以为空");
				return num;
			}

			// 1. 更新用户
			if (isNeedUpdate) {
				num += updateByPrimaryKey(user);
			}

			if (null != records) {
				// 2. 创建或更新角色
				num += roleService.insertOrUpdateBatch(records);

				// 3. 维护用户与角色的关系，创建新关系删除无效的旧关系
				// 3.1 创建关系集合
				List<SysUserRoleKey> relationList = new ArrayList<>();
				// 循环角色集合，创建用户与角色的关系
				for (SysRole record : records) {
					Long roleId = record.getId();
					if (roleId != null) {
						// 创建关系
						SysUserRoleKey key = new SysUserRoleKey();
						key.setUserId(String.valueOf(user.getId())); // 设置关系中的用户id
						key.setRoleId(String.valueOf(roleId)); // 设置关系中的角色id
						key.setDataSource(record.getDataSource());
						// 将关系保存到关系集合
						relationList.add(key);
					}
				}

				// 3.2 获取所有用户的id的连接字符串的map
				List<SysUser> userList = new ArrayList<>(1);
				userList.add(user);
				Map<String, String> idsMap = getMapIds(userList, records);

				// 3.3 创建新关系删除无效的旧关系
				num += userAuthRoleService.updateAuthBatch(idsMap, relationList, copeRoleMenu);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;

	}

	@Override
	public Long saveUserAndMenu(SysUser user, List<SysMenu> records, boolean isNeedUpdate) {
		/*
		 * 1. 如果isNeedUpdate为true，则更新用户； 2. 创建或更新菜单； 3.
		 * 维护用户与菜单的关系，创建新关系删除无效的旧关系。
		 */

		// 返回值，受影响的行数
		Long num = 0l;

		try {
			if (user == null) {
				logger.error("方法[UserService.saveUserAndMenu],参数user不可以为空");
				return num;
			}
			if (user.getId() == null || user.getId() < 1) {
				logger.error("方法[UserService.saveUserAndMenu],参数user的id属性不可以为空");
				return num;
			}

			// 1. 更新用户
			if (isNeedUpdate) {
				num += updateByPrimaryKey(user);
			}

			if (records != null) {
				// 2. 创建或更新菜单
				num += menuService.insertOrUpdateBatch(records);

				// 3. 维护用户与菜单的关系，创建新关系删除无效的旧关系
				// 3.1 创建关系集合
				List<SysUserMenuKey> relationList = new ArrayList<SysUserMenuKey>();
				// 循环菜单集合，创建用户与标签的关系
				for (SysMenu record : records) {
					Long menuId = record.getId();
					if (menuId != null) {
						// 创建关系
						SysUserMenuKey key = new SysUserMenuKey();
						key.setUserId(String.valueOf(user.getId())); // 设置关系中的用户id
						key.setMenuId(String.valueOf(menuId)); // 设置关系中的菜单id
						String dataSource = record.getDataSource();
						if (StringUtils.isBlank(dataSource))
							key.setDataSource(user.getUserSource());
						else
							key.setDataSource(dataSource);

						// 将关系保存到关系集合
						relationList.add(key);
					}
				}

				// 3.2 获取所有用户的id的连接字符串的map
				List<SysUser> userList = new ArrayList<>();
				userList.add(user);
				Map<String, String> idsMap = getMapIds(userList, relationList);

				// 3.3 创建新关系删除无效的旧关系
				num += userAuthMenuService.updateAuthBatch(idsMap, relationList);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public Long saveUserAndChannel(SysUser user, List<SysChannel> records, boolean isNeedUpdateUser,
			boolean isNeedUpdateChannel) {
		/*
		 * 1. 如果isNeedUpdate为true，则更新用户； 2. 创建或更新渠道； 3.
		 * 维护用户与渠道的关系，创建新关系删除无效的旧关系。
		 */

		// 返回值，受影响的行数
		Long num = 0l;
		try {
			if (user == null) {
				logger.error("方法[UserService.saveUserAndChannel],参数user不可以为空");
				return num;
			}
			if (user.getId() == null || user.getId() < 1) {
				logger.error("方法[UserService.saveUserAndChannel],参数user的id属性不可以为空");
				return num;
			}
			if (records == null) {
				logger.error("方法[UserService.saveUserAndChannel],参数records不可以为空");
				return num;
			}

			// 1. 更新用户
			if (isNeedUpdateUser) {
				num += updateByPrimaryKey(user);
			}
			// 2. 创建或更新渠道
			if (isNeedUpdateChannel) {
				num += channelService.insertOrUpdateBatch(records);
			}

			// 3. 维护用户与渠道的关系，创建新关系删除无效的旧关系
			// 3.1 创建关系集合
			List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
			String userId = String.valueOf(user.getId());
			// 循环渠道集合，创建用户与渠道的关系
			for (SysChannel record : records) {

				Long id = record.getId();
				if (id != null) {
					// 创建关系
					SysLabelRelationKey key = new SysLabelRelationKey();

					key.setObjId(String.valueOf(id)); // 设置关系中的渠道id
					key.setRelId(userId); // 设置关系中的用户id

					key.setRelType(ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE); // 设置关系类型为“渠道与用户”的关系
					// 将关系保存到关系集合
					key.setsId(record.getSupplierId());
					relationList.add(key);
				}
			}

			// XXX
			Map<String, String> idsMap = new HashMap<>(2);
			idsMap.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, user.getId().toString());
			idsMap.put(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY,
					UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
			idsMap.put("needCompatibleDirectChannel", "false");

			// 3.3 创建新关系删除无效的旧关系
			num += labelRelationService.updateAuthBatch(idsMap, relationList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public Long saveBatchUserAndCommonInfo(List<SysUser> users, Map<String, List<SysUser>> records, String type,
			boolean isNeedUpdateUser) {
		/*
		 * 1. 如果isNeedUpdate为true，则更新用户； 2. 创建或更新常用信息； 3.
		 * 维护用户与常用信息的关系，创建新关系删除无效的旧关系。
		 */

		// 返回值，受影响的行数
		Long num = 0l;
		try {
			if (users == null) {
				logger.error("方法[UserService.saveBatchUserAndCommonInfo],参数user不可以为空");
				return num;
			}
			if (records == null) {
				logger.error("方法[UserService.saveBatchUserAndCommonInfo],参数records不可以为空");
				return num;
			}
			// 1. 更新用户
			if (isNeedUpdateUser) {
				num += insertOrUpdateBatch(users);
			}

			// 3. 维护用户与常用信息的关系，创建新关系删除无效的旧关系
			// 3.1 创建关系集合
			List<SysUserRelation> relationList = new ArrayList<SysUserRelation>();
			// 循环常用信息集合，创建用户与常用信息的关系
			for (SysUser user : users) {
				Long userId = user.getId();
				if (userId == null) {
					continue;
				}
				String syscode = user.getSysCode();
				List<SysUser> comInfo = records.get(syscode);
				if (comInfo == null) {
					continue;
				}
				for (SysUser record : comInfo) {
					Long id = record.getId();
					if (id != null) {
						// 创建关系
						SysUserRelation key = new SysUserRelation();
						key.setUserId(userId);// 设置关系中的用户id
						key.setRelUserId(id); // 设置关系中的常用信息Id
						key.setRelType(type); // 设置关系类型为“渠道与用户”的关系
						// 将关系保存到关系集合
						relationList.add(key);
					}
				}
			}
			Map<String, String> idsMap = getMapIds(users);
			if (idsMap != null) {
				// XXX 这里的userIds有什么用？
				// 从map中获取所有用户的id的连接字符串
				idsMap.put(UserGlobalParam.UserMapKeyParam.RELT_MAP_KEY, type);

				// 3.3 创建新关系删除无效的旧关系
				num += sysUserRelationService.updateAuthBatch(idsMap, relationList);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public Long saveBatchUserAndChannel(List<SysUser> users, Map<String, List<SysChannel>> records,
			boolean isNeedUpdateUser, boolean isNeedUpdateChannel) {

		/*
		 * 1. 如果isNeedUpdate为true，则更新用户； 2. 创建或更新渠道； 3.
		 * 维护用户与渠道的关系，创建新关系删除无效的旧关系。
		 */

		// 返回值，受影响的行数
		Long num = 0l;
		try {
			if (users == null) {
				logger.error("方法[UserService.saveBatchUserAndChannel],参数user不可以为空");
				return num;
			}
			if (records == null) {
				logger.error("方法[UserService.saveBatchUserAndChannel],参数records不可以为空");
				return num;
			}

			// 1. 更新用户
			if (isNeedUpdateUser) {
				num += insertOrUpdateBatch(users);
			}
			// 2. 创建或更新渠道
			List<SysChannel> allList = channelService.map2Alllist(records);
			if (isNeedUpdateChannel) {
				num += channelService.insertOrUpdateBatch(allList);
			}

			// 3. 维护用户与渠道的关系，创建新关系删除无效的旧关系
			// 3.1 创建关系集合
			List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
			// 循环渠道集合，创建用户与渠道的关系
			for (SysUser user : users) {
				Long userId = user.getId();
				if (userId == null) {
					continue;
				}
				String userId_ = String.valueOf(userId);
				String syscode = user.getSysCode();
				List<SysChannel> channels = records.get(syscode);
				if (channels == null) {
					continue;
				}
				for (SysChannel record : channels) {
					Long id = record.getId();
					if (id != null) {
						// 创建关系
						SysLabelRelationKey key = new SysLabelRelationKey();
						key.setObjId(String.valueOf(id)); // 设置关系中的渠道id
						key.setRelId(userId_); // 设置关系中的用户id
						key.setRelType(ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE); // 设置关系类型为“渠道与用户”的关系
						// 将关系保存到关系集合
						key.setsId(record.getSupplierId());
						relationList.add(key);
					}
				}
			}
			Map<String, String> idsMap = getMapIds(users);
			if (idsMap != null) {
				// XXX 这里的userIds有什么用？
				// 从map中获取所有用户的id的连接字符串
				String userIds = idsMap.get(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY);

				idsMap.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, userIds);
				idsMap.put(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY,
						UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);

				// 3.3 创建新关系删除无效的旧关系
				num += labelRelationService.updateAuthBatch(idsMap, relationList);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public Long saveUserAndLabel(SysUser user, List<SysLabel> records, boolean isNeedUpdate) {
		/*
		 * 1. 如果isNeedUpdate为true，则更新用户； 2. 创建或更新标签； 3.
		 * 维护用户与标签的关系，创建新关系删除无效的旧关系。
		 */

		// 返回值，受影响的行数
		Long num = 0l;
		try {
			if (user == null) {
				logger.error("方法[UserService.saveUserAndChannel],参数user不可以为空");
				return num;
			}
			if (user.getId() == null || user.getId() < 1) {
				logger.error("方法[UserService.saveUserAndChannel],参数user的id属性不可以为空");
				return num;
			}
			if (records == null) {
				logger.error("方法[UserService.saveUserAndChannel],参数records不可以为空");
				return num;
			}

			// 1. 更新用户
			if (isNeedUpdate) {
				num += updateByPrimaryKey(user);
			}

			// 2. 创建或更新标签
			num += labelService.insertOrUpdateBatch(records);

			// 3. 维护用户与标签的关系，创建新关系删除无效的旧关系
			// 3.1 创建关系集合
			List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
			// 循环标签集合，创建用户与标签的关系
			for (SysLabel record : records) {
				Long labelId = record.getId();
				if (labelId != null) {
					// 创建关系
					SysLabelRelationKey key = new SysLabelRelationKey();
					key.setObjId(String.valueOf(user.getId())); // 设置关系中的用户id
					key.setRelId(String.valueOf(labelId)); // 设置关系中的标签id
					key.setRelType(ChannelMapKeyParam.USER_LABEL_RELATION_TYPE); // 设置关系类型为“用户与标签”的关系
					// 将关系保存到关系集合
					relationList.add(key);
				}
			}

			// XXX
			// 创建了一个List，被下面第3行的getMapIds方法使用，是为了用户id的连接字符串，但这里写死的只有一个用户，所以实际结果同user.getId().toString()是一样的！
			List<SysUser> userList = new ArrayList<SysUser>();
			userList.add(user);

			// 3.2 获取所有用户的id的连接字符串的map
			Map<String, String> idsMap = getMapIds(userList);
			if (idsMap != null) {
				// XXX 这里的userIds有什么用？
				// 从map中获取所有用户的id的连接字符串
				String userIds = idsMap.get(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY);

				// XXX 这里的newIdsMap没有在其它地方使用，有什么用？
				Map<String, String> newIdsMap = new HashMap<String, String>(1);
				newIdsMap.put(UserGlobalParam.ChannelMapKeyParam.OBJ_MAP_KEY, userIds);

				// 3.3 创建新关系删除无效的旧关系
				num += labelRelationService.updateAuthBatch(idsMap, relationList);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public Long updateUserOR(SysUser user, List<SysOffice> officeList, Map<String, List<SysRole>> roleMap) {
		/*
		 * 1. 保存用户与部门之间的关系 2. 保存用户与部门与角色之间的关系
		 */
		Long num = 0l;
		try {
			if (user == null) {
				logger.error("方法[UserService.updateUserOR],参数user不可以为空");
				return num;
			}
			Long userId = user.getId();
			if (userId == null || userId < 0) {
				logger.error("方法[UserService.updateUserOR],参数user的userId不可以为空");
				return num;
			}
			if (officeList == null) {
				logger.error("方法[UserService.updateUserOR],参数officeList不可以为空");
				return num;
			}
			if (roleMap == null) {
				logger.error("方法[UserService.updateUserOR],参数roleMap不可以为空");
				return num;
			}

			String userId_ = String.valueOf(userId);
			// 创建[用户与部门关系]集合
			List<SysUserOfficeKey> userOfficeList = new ArrayList<SysUserOfficeKey>();
			// 创建[用户与部门与角色关系]集合
			List<SysRoleOfficeUserKey> updateList = new ArrayList<SysRoleOfficeUserKey>();

			/*
			 * 这里有一个双层循环，第一层循环部门，建立[用户与部门关系]，第二层循环每个部门的角色，建立[用户与部门与角色关系]。
			 */

			// 循环部门集合
			for (SysOffice office : officeList) {
				Long officeId = office.getId();
				if (officeId == null || officeId < 1)
					continue;
				String officeId_ = String.valueOf(officeId);

				// 根据部门id（officeId_）从roleMap中找到部门的角色集合
				List<SysRole> roleList = roleMap.get(officeId_);
				if (roleList != null) {
					// 创建[用户与部门关系]对象
					SysUserOfficeKey userOffice = new SysUserOfficeKey();
					userOffice.setUserId(userId_); // 设置用户id
					userOffice.setOfficeId(officeId_); // 设置部门id
					// 将关系对象添加到[用户与部门关系]集合中
					userOfficeList.add(userOffice);

					// 循环角色集合
					for (SysRole role : roleList) {
						Long roleId = role.getId();
						if (roleId == null || roleId < 1)
							continue;

						String roleId_ = String.valueOf(roleId);
						// 创建[用户与部门与角色关系]对象
						SysRoleOfficeUserKey key = new SysRoleOfficeUserKey();
						key.setOfficeId(officeId_); // 设置部门id
						key.setRoleId(roleId_); // 设置角色id
						key.setUserId(userId_); // 设置用户id
						// 将关系对象添加到[用户与部门与角色关系]集合中
						updateList.add(key);
					}
				}

			}
			//
			Map<String, String> idsMap = userAuthOfficeService.getRelationIds(userOfficeList);
			// 保存[用户与部门与角色关系]的集合
			num = roleAuthOfficeService.updateAuthBatch(idsMap, updateList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	private Long updateUserOR(SysUser user, List<SysOffice> officeList, List<SysRole> officeRoleList) {
		/*
		 * 1. 保存用户与部门之间的关系 2. 保存用户与部门与角色之间的关系
		 */
		Long num = 0l;
		try {
			if (user == null || officeRoleList == null || officeRoleList == null) {
				return num;
			}
			Long userId = user.getId();
			if (userId == null || userId < 0) {
				return num;
			}

			String userId_ = String.valueOf(userId);
			// 创建[用户与部门关系]集合
			List<SysUserOfficeKey> userOfficeList = new ArrayList<>(officeList.size());
			// 创建[用户与部门与角色关系]集合
			List<SysRoleOfficeUserKey> updateList = new ArrayList<>(officeRoleList.size());

			for (Iterator<SysOffice> iterator = officeList.iterator(); iterator.hasNext();) {
				SysOffice sysOffice = iterator.next();

				Long officeId = sysOffice.getId();
				if (officeId == null || officeId < 1)
					continue;

				SysUserOfficeKey key = new SysUserOfficeKey();
				key.setUserId(userId_);
				key.setOfficeId(sysOffice.getId().toString());
				userOfficeList.add(key);
			}

			for (Iterator<SysRole> iterator = officeRoleList.iterator(); iterator.hasNext();) {
				SysRole sysRole = iterator.next();
				BaseEntity sysOffice = sysRole.getParentRef();

				Long roleId = sysRole.getId();
				if (roleId == null || sysOffice == null || roleId < 1)
					continue;

				SysRoleOfficeUserKey key = new SysRoleOfficeUserKey();
				key.setOfficeId(sysOffice.getId().toString()); // 设置部门id
				key.setRoleId(sysRole.getId().toString()); // 设置角色id
				key.setUserId(userId_); // 设置用户id
				// 将关系对象添加到[用户与部门与角色关系]集合中
				updateList.add(key);
			}

			Map<String, String> idsMap = userAuthOfficeService.getRelationIds(userOfficeList);
			// 保存[用户与部门与角色关系]的集合
			num = roleAuthOfficeService.updateAuthBatch(idsMap, updateList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public Long delUserAndAuth(Long userId) {
		Long delNum = 0l;
		try {
			if (userId == null || userId < 0) {
				logger.error("方法[UserService.delUserAndAuth],参数userId不可以为空");
				return delNum;
			}

			delNum += delete(userId);

			String userId_ = String.valueOf(userId);
			// 删除用户与部门之间的关系
			SysUserOfficeKey userOffice = new SysUserOfficeKey();
			userOffice.setUserId(userId_);
			List<SysUserOfficeKey> userOfficeList = new ArrayList<SysUserOfficeKey>();
			userOfficeList.add(userOffice);
			delNum += userAuthOfficeService.delAuthBatch(userOfficeList);

			// 删除用户与角色之间的关系
			SysUserRoleKey userRole = new SysUserRoleKey();
			userRole.setUserId(userId_);
			List<SysUserRoleKey> userRoleList = new ArrayList<SysUserRoleKey>();
			userRoleList.add(userRole);
			delNum += userAuthRoleService.delAuthBatch(userRoleList);

			// 删除用户与菜单之间的关系
			SysUserMenuKey userMenu = new SysUserMenuKey();
			userMenu.setUserId(userId_);
			List<SysUserMenuKey> userMenuList = new ArrayList<SysUserMenuKey>();
			userMenuList.add(userMenu);
			delNum += userAuthMenuService.delAuthBatch(userMenuList);

			// 删除用户部门角色的关系
			SysRoleOfficeUserKey roleOffice = new SysRoleOfficeUserKey();
			roleOffice.setUserId(userId_);
			List<SysRoleOfficeUserKey> roleOfficeList = new ArrayList<SysRoleOfficeUserKey>();
			roleOfficeList.add(roleOffice);
			delNum += roleAuthOfficeService.delAuthBatch(roleOfficeList);

			// 删除用户与渠道的关系
			SysLabelRelationKey channelUser = new SysLabelRelationKey();
			channelUser.setRelId(userId_);
			channelUser.setRelType(ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
			List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
			relationList.add(channelUser);
			delNum += labelRelationService.delAuthBatch(relationList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return delNum;
	}

	@Override
	public Integer getCount(SysUser user) {
		Integer num = 0;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("bParam", user);
			num = mapper.countByParamMap(params);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public Map<String, String> getMapIds(List<SysUser> records) {
		if (records == null || records.isEmpty()) {
			return null;
		}
		// XXX 不太明白为什么要用这个map，而且只往其中保存了一个数据，不能将数据直接返回吗？
		Map<String, String> map = new HashMap<String, String>(1);

		String userIds = getUserIds(records);

		// 将所有用户的id的连接字符串保存入map中
		map.put(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY, userIds);
		map.put(UserMapKeyParam.DATASOURCES_KEY, userIds);
		return map;
	}

	private String getUserIds(List<SysUser> records) {
		// 以,为分隔，连接所有用户的id
		StringBuffer buff = new StringBuffer();

		// 循环用户列表，连接用户id
		for (BaseEntity record : records) {
			Long id = record.getId();
			if (id != null && (buff.indexOf(id + ",") < 0)) {
				buff.append(id).append(",");
			}
		}
		return buff.substring(0, buff.length() - 1);
	}

	public <T extends BaseDataSourceEntity> Map<String, String> getMapIds(List<SysUser> records, List<T> roleList) {
		if (records == null || records.isEmpty()) {
			return null;
		}
		Map<String, String> map = new HashMap<>(2);

		// 将所有用户的id的连接字符串保存入map中
		map.put(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY, getUserIds(records));
		map.put(UserGlobalParam.UserMapKeyParam.DATASOURCES_KEY, getDataSources(records, roleList));

		return map;
	}

	private <T extends BaseDataSourceEntity> String getDataSources(List<SysUser> userList, List<T> roleList) {
		// 以,为分隔，连接所有的DataSource
		StringBuffer buff = new StringBuffer();

		HashSet<String> dataSourceSet = new HashSet<>();

		// 循环角色列表，连接DataSource
		for (T record : roleList) {
			String dataSource = record.getDataSource();
			if (!StringUtils.isBlank(dataSource)) {
				dataSourceSet.add(dataSource);
			}
		}
		if (dataSourceSet.size() == 0) {
			// 循环用户列表，连接用户UserSource
			for (SysUser record : userList) {
				String userSource = record.getUserSource();
				if (!StringUtils.isBlank(userSource)) {
					dataSourceSet.add(userSource);
				}
			}
		}
		for (String dataSource : dataSourceSet) {
			buff.append(dataSource).append(",");
		}
		if (buff.length() > 1)
			return buff.substring(0, buff.length() - 1);
		return null;
	}

	@Override
	public PageList<SysUser> queryPageByObjId(PageModel pager, SysUser user, Long objId, String refType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", user);
		params.put("idParam", objId);
		params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, refType);

		CompatibleDirectChannelHelper.compatibleDirectChannelUserParamForObject(params);

		List<SysUser> listBean = mapper.findListByObjID(params);
		Integer count = mapper.countByObjID(params);
		PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
		PageList<SysUser> pagelist = null;
		pagelist = new PageList<SysUser>(listBean, pageObj);
		return pagelist;
	}

	/**
	 * 
	 */
	@Override
	public PageList<SysUser> queryPageByRefId(PageModel pager, SysUser user, Long refId, String refType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", user);
		params.put("idParam", refId);
		params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, refType);

		Integer count = mapper.countByRefID(params);
		List<SysUser> listBean = mapper.findListByRefID(params);

		PageList<SysUser> pagelist = new PageList<SysUser>(listBean, pager, count);
		return pagelist;
	}

	@Override
	public PageList<SysUser> findByUserOfficeRole(PageModel pager, SysUser user, List<Long> officeIds,
			List<Long> roleIds) {
		try {
			List<SysUser> sysRoleList = null;
			int count = mapper.countByUserOfficeRole(user, officeIds, roleIds);
			if (count > 0) {
				sysRoleList = mapper.selectByUserOfficeRole(user, officeIds, roleIds, pager);
			}

			PageList<SysUser> pagelist = new PageList<SysUser>(sysRoleList, pager, count);
			return pagelist;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public PageList<SysUser> findByRole(Integer start, Integer size, SysRole role) {
		try {
			PageModel pager = new PageModel(start, size);

			List<SysUser> sysRoleList = null;
			int count = mapper.countByRole(role);

			if (count > 0) {
				sysRoleList = mapper.findByRole(pager, role);
			}

			PageList<SysUser> pagelist = new PageList<SysUser>(sysRoleList, pager, count);
			return pagelist;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/*@Override
	public List<ProductScenicRelation> findScenicRelationByUserIds(List<Long> userIdList) {
		try {
			if (userIdList == null) {
				return null;
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put(UserMapKeyParam.USER_MAP_KEY, userIdList);
			params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, GlobalParam.SUPPILER_TBL);
			List<ProductScenicRelation> list = mapper.findScenicRelationByUserIds(params);
			return list;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}*/

	@Override
	public SysUser saveUser(SysUser user) {
		int i = updateByPrimaryKey(user);
		if (i > 0) {
			SysUser result = getById(user.getId());
			return result;
		}
		return user;
	}

	@Override
	public List<SysUser> findCustomerAllInfoByParams(SysUser userParam) {
		if (null == userParam) {
			return null;
		}

		// 根据条件查询用户
		List<SysUser> userResult = findListByParams(userParam);

		if (null != userResult && !userResult.isEmpty()) {
			@SuppressWarnings("deprecation")
			String dataSource = userParam.getUserSource();
			String userId = userParam.getId() != null ? userParam.getId().toString() : null;

			Map<String, SysUser> userResultMap = userResultMap(userResult);

			// 根据条件查询用户相关的角色
			findeUserRole(dataSource, userId, userResultMap);

			// 根据条件查询用户相关的菜单
			findUserMenu(dataSource, userId, userResultMap);
		}
		return userResult;
	}

	/**
	 * 根据平台dataSource、用户主键userId，查询用户关联的角色
	 * 
	 * @param dataSource
	 *            平台
	 * @param userId
	 *            用户主键
	 * @param userResultMap
	 */
	private void findUserMenu(String dataSource, String userId, Map<String, SysUser> userResultMap) {
		SysUserMenuKey userMenuParam = new SysUserMenuKey();
		userMenuParam.setUserId(userId);
		SysMenu menuParam = new SysMenu();
		menuParam.setDataSource(dataSource);

		List<SysUserMenuKey> menuResult = userAuthMenuService.findMenuByRelationMenu(userMenuParam, menuParam);

		for (Iterator<SysUserMenuKey> iterator = menuResult.iterator(); iterator.hasNext();) {
			SysUserMenuKey userMenuKey = iterator.next();
			SysUser user = userResultMap.get(userMenuKey.getUserId());
			if (null != user) {
				user.setMenuList(userMenuKey.getMenus());
			}
		}
	}

	/**
	 * 根据平台dataSource、用户主键userId，查询用户关联的菜单
	 * 
	 * @param dataSource
	 *            平台
	 * @param userId
	 *            用户主键
	 * @param userResultMap
	 */
	private void findeUserRole(String dataSource, String userId, Map<String, SysUser> userResultMap) {
		SysUserRoleKey userRoleParam = new SysUserRoleKey();
		userRoleParam.setUserId(userId);
		SysRole roleParam = new SysRole();
		roleParam.setDataSource(dataSource);

		List<SysUserRoleKey> roleReuslt = userAuthRoleService.findRoleByRelationRole(userRoleParam, roleParam);

		for (Iterator<SysUserRoleKey> iterator = roleReuslt.iterator(); iterator.hasNext();) {
			SysUserRoleKey userRoleKey = iterator.next();
			SysUser user = userResultMap.get(userRoleKey.getUserId());
			if (null != user) {
				user.setRoleList(userRoleKey.getRoles());
			}
		}
	}

	private Map<String, SysUser> userResultMap(List<SysUser> userList) {
		HashMap<String, SysUser> userResultMap = new HashMap<>(userList.size());
		for (Iterator<SysUser> iterator = userList.iterator(); iterator.hasNext();) {
			SysUser sysUser = iterator.next();
			if (null != sysUser && null != sysUser.getId()) {
				userResultMap.put(sysUser.getId().toString(), sysUser);
			}
		}
		return userResultMap;
	}

	/*@Override
	public List<ProductSalesTool> findWdIdByUserIds(List<SysUser> records) {
		try {
			if (records == null) {
				return null;
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put(UserMapKeyParam.USER_MAP_KEY, records);
			params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, SalesTool.user());
			List<ProductSalesTool> list = mapper.findWdIdByUserIds(params);
			return list;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}*/

	@Override
	public PageList<SysUser> queryPageByUR(PageModel pager, SysUser user, SysRole role) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("pParam", pager);
			params.put("bParam", user);
			params.put("role", role);
			List<SysUser> listBean = this.mapper.findListByUR(params);
			Integer count = Integer.valueOf(this.mapper.countByUR(params));
			PageBean pageObj = new PageBean(Long.valueOf(count.toString()).longValue(), pager);

			PageList<SysUser> pagelist = new PageList<SysUser>(listBean, pageObj);

			return pagelist;
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public Long findSupplierId(String dataSource) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("dataSource", dataSource);
			Long supplierId = mapper.findSupplierId(params);
			return supplierId;
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/*@Override
	public PageList<SysUser> querySupplierByProduct(PageModel pager, SysUser user) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", user);
		List<SysUser> listBean = mapper.selectSupplierByProduct(params);
		Integer count = mapper.countSupplierByProduct(params);
		PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
		PageList<SysUser> pagelist = null;
		pagelist = new PageList<SysUser>(listBean, pageObj);
		return pagelist;
	}*/

	@Override
	public PageList<SysUser> findRefCustomerByRelation(SysUserRelation relation, SysUser user, boolean isFindMaster,
			PageModel pm) {
		if (user == null)
			return null;

		int count = mapper.countRefCustomerByRelation(relation, user, isFindMaster);
		List<SysUser> sysUserList = null;
		if (count > 0) {
			sysUserList = mapper.selectRefCustomerByRelation(relation, user, isFindMaster, pm);
		}

		PageList<SysUser> result = new PageList<>(sysUserList, pm, count);
		return result;
	}

	@Override
	public PageList<SysUser> findUserExclusiveUserRelation(User master, SysUser user, PageModel page) {
		if (user == null || master == null)
			return null;

		int count = mapper.countUserExclusiveUserRelation(master, user);
		List<SysUser> sysUserList = null;
		if (count > 0) {
			sysUserList = mapper.selectUserExclusiveUserRelation(master, user, page);
		}

		PageList<SysUser> result = new PageList<>(sysUserList, page, count);
		return result;
	}

	/*@Override
	public PageList<SysUser> findUserForPMS(SysUser user, SysRole role, PageModel page) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bParam", user);
		map.put("role", role);
		int count = mapper.countForPMS(map);
		List<SysUser> sysUserList = null;
		if (count > 0) {
			map.put("page", page);
			sysUserList = mapper.selectListForPMS(map);
		}

		PageList<SysUser> result = new PageList<>(sysUserList, page, count);
		return result;
	}*/

	/*@Override
	public PageList<SysUser> findUserWithScenic(SysUser user, ProductScenic scenic, PageModel page) {
		int count = mapper.countUserWithScenic(user, scenic);
		List<SysUser> sysUserList = null;
		if (count > 0) {
			sysUserList = mapper.selectUserWithScenic(user, scenic, page);
		}
		PageList<SysUser> result = new PageList<>(sysUserList, page, count);
		return result;
	}*/

	/**
	 * 根据供应商ID维护渠道与用户的关系
	 * 
	 * @param user
	 *            用户相关信息
	 * @param records
	 *            用户将要绑定的渠道
	 * @return
	 */
	@Override
	public Long updateUserAndChannelRel(SysUser user, List<SysChannel> records) {
		Long num = 0l;
		try {
			if (user == null) {
				logger.error("方法[UserService.updateUserAndChannelRel],参数user不可以为空");
				return num;
			}
			if (user.getId() == null || user.getId() < 1) {
				logger.error("方法[UserService.updateUserAndChannelRel],参数user的id属性不可以为空");
				return num;
			}
			if (records == null) {
				logger.error("方法[UserService.saveUserAndChannel],参数records不可以为空");
				return num;
			}
			// 更新用户的相关信息
			num += updateByPrimaryKey(user);
			// 3. 维护用户与渠道的关系，创建新关系删除无效的旧关系
			// 3.1 创建关系集合
			List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
			String userId = String.valueOf(user.getId());
			// 循环渠道集合，创建用户与渠道的关系
			for (SysChannel record : records) {
				Long id = record.getId();
				if (id != null) {
					// 创建关系
					SysLabelRelationKey key = new SysLabelRelationKey();
					// 设置关系中的渠道id
					key.setObjId(String.valueOf(id));
					// 设置关系中的用户id
					key.setRelId(userId);
					// 设置关系类型为“渠道与用户”的关系
					key.setRelType(ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
					key.setsId(record.getSupplierId());
					// 将关系保存到关系集合
					relationList.add(key);
				}
			}
			// 封装查询参数，用户id 及 绑定类型
			Map<String, String> idsMap = new HashMap<>(2);
			idsMap.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, user.getId().toString());
			idsMap.put(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY,
					UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
			// 3.3 创建新关系删除无效的旧关系
			num += labelRelationService.updateAuthBatch(idsMap, relationList, records.get(0).getSupplierId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public SysUser addUserAndAuthBySupplierId(SysUser user, List<SysOffice> officeList, List<SysRole> officeRoleList,
			List<SysRole> userRoleList, List<SysMenu> sysMenuList, List<SysChannel> channelList, List<Long> ticketList,
			String mark) {
		Long userId = null;
		if (user == null) {
			logger.error("方法[UserService.addUserAndAuth],参数user不可以为空");
			return user;
		}
		try {
			// 1. 创建或更新用户
			if ("financial".equals(mark)) {
				// 创建财务用户
				insertFinancialSysUser(user);
			} else {
				// 创建普通用户
				insertOrUpdate(user);
			}
			userId = user.getId();
			if (null != userId && userId > 0) {
				// XXX 以下2～5中有相同的步骤，获取用户id的连接字符串，相同重复的代码，可优化共用一个！
				// 2. 创建或更新渠道，维护渠道与用户的关系
				if (channelList != null) {
					updateUserAndChannelRel(user, channelList);
				}
				// 3. 创建或更新菜单，维护菜单与用户的关系
				if (sysMenuList != null) {
					saveUserAndMenu(user, sysMenuList, false);
				}
				// 4. 创建或更新部门，维护部门与用户的关系
				if (officeList != null) {
					saveUserAndOffice(user, officeList, false); // 这里出错
				}
				// 5. 创建或更新角色，维护角色与用户的关系
				boolean copyRoleMenu = (sysMenuList == null && officeRoleList == null && userRoleList != null);
				if (userRoleList != null) {
					saveUserAndRole(user, userRoleList, false, copyRoleMenu);
				}
				// 6. 维护用户与部门与角色的关系
				if (null != officeRoleList && null != officeList) {
					roleService.insertOrUpdateBatch(officeRoleList);
					// 6.2 保存[用户与部门与角色的关系]
					updateUserOR(user, officeList, officeRoleList);
				}
				// 7. 维护用户与售票点的关系
				if (null != ticketList) {
					labelRelationService.saveUserTicket(userId, ticketList);
				}
			}
			SysUser result = getById(userId);
			return result;
		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public Long saveBatchUserAndChannelBySupplierIds(List<SysUser> users, Map<String, List<SysChannel>> records,
			boolean isNeedUpdateUser, boolean isNeedUpdateChannel) {
		Long num = 0l;
		try {
			if (users == null) {
				logger.error("方法[UserService.saveBatchUserAndChannel],参数user不可以为空");
				return num;
			}
			if (records == null) {
				logger.error("方法[UserService.saveBatchUserAndChannel],参数records不可以为空");
				return num;
			}
			if (isNeedUpdateUser) {
				//	num += insertOrUpdateBatch(users);
			}
			List<SysChannel> allList = this.mapToAlllist(records);
			if (isNeedUpdateChannel) {
				num += channelService.insertOrUpdateBatch(allList);
			}
			List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
			Set<Long> supplierIds = new HashSet<Long>();
			for (SysUser user : users) {
				Long userId = user.getId();
				if (userId == null) {
					continue;
				}
				String userId_ = String.valueOf(userId);
				String syscode = String.valueOf(user.getId());
				List<SysChannel> channels = records.get(syscode);
				if (channels == null) {
					continue;
				}
				for (SysChannel record : channels) {
					Long id = record.getId();
					if (id != null) {
						SysLabelRelationKey key = new SysLabelRelationKey();
						key.setObjId(String.valueOf(id)); // 设置关系中的渠道id
						key.setRelId(userId_); // 设置关系中的用户id
						key.setRelType(ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE); // 设置关系类型为“渠道与用户”的关系
						key.setsId(record.getSupplierId());
						relationList.add(key);
						supplierIds.add(record.getSupplierId());
					}
				}
			}
			Map<String, String> idsMap = getMapIds(users);
			if (idsMap != null) {
				// 从map中获取所有用户的id的连接字符串
				String userIds = idsMap.get(UserGlobalParam.UserMapKeyParam.USER_MAP_KEY);
				idsMap.put(UserGlobalParam.ChannelMapKeyParam.REF_MAP_KEY, userIds);
				idsMap.put(UserGlobalParam.ChannelMapKeyParam.RELATION_TYPE_KEY,
						UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
				// 3.3 创建新关系删除无效的旧关系
				num += labelRelationService.updateAuthBatchBySupplierIds(idsMap, relationList, new ArrayList<Long>(
						supplierIds));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	public List<SysChannel> mapToAlllist(Map<String, List<SysChannel>> records) {
		if (records == null || records.isEmpty()) {
			return null;
		}
		List<SysChannel> returnList = new ArrayList<>();
		for (Entry<String, List<SysChannel>> record : records.entrySet()) {
			List<SysChannel> list = record.getValue();
			if (list == null || list.isEmpty()) {
				continue;
			}
			for (SysChannel entity : list) {
				returnList.add(entity);
			}
		}
		return returnList;
	}

	@Override
	public PageList<SysUser> queryChannelUnbundledDirectsDistributor(Long channelId, SysUser distributorParam,
			PageModel pageModel) {
		if (channelId == null)
			return null;

		SysChannel sysChannel = channelService.getById(channelId);
		if (sysChannel == null && sysChannel.getSupplierId() == null)
			return null;

		// 获取未绑定的直签分销商ID集合
		List<Long> distributorIds = queryChannelUnbundledDirectsDistributorIds(channelId, sysChannel.getSupplierId());

		if (distributorParam == null) {
			distributorParam = new SysUser();
		}

		if (CollectionUtils.isNotEmpty(distributorIds)) {
			distributorParam.setQueryIdList(distributorIds);

			PageList<SysUser> sysUserPageList = queryPageByParamMap(pageModel, distributorParam);
			return sysUserPageList;
		}

		return new PageList<>(null, pageModel, 0);
	}

	/**
	 * 查询渠道未绑定直签分销商的ID集合
	 * @param channelId
	 * @param supplierId
	 * @return
	 */
	private List<Long> queryChannelUnbundledDirectsDistributorIds(Long channelId, Long supplierId) {
		List<SysUserRelation> supplierDistributorRelations = null;
		List<SysLabelRelationKey> channelUserRelations = null;

		SysUserRelation userRelationParam = new SysUserRelation();
		userRelationParam.setUserId(supplierId);
		userRelationParam.setRelType(UserGlobalDict.UserRelation.SUPPLIER_DIRECTS_RESELLER);
		supplierDistributorRelations = sysUserRelationService.findListByParams(userRelationParam);

		if (CollectionUtils.isEmpty(supplierDistributorRelations)) {
			return null;
		}

		SysLabelRelationKey sysLabelRelationKeyParam = new SysLabelRelationKey();
		sysLabelRelationKeyParam.setObjId(channelId.toString());
		sysLabelRelationKeyParam.setRelType(ChannelMapKeyParam.DIRECT_CHANNEL_USER_TYPE);
		channelUserRelations = labelRelationService.findListByParams(sysLabelRelationKeyParam);

		List<Long> distributorIds = new ArrayList<>(supplierDistributorRelations.size());

		for (SysUserRelation sysUserRelation : supplierDistributorRelations) {
			Long relUserId = sysUserRelation.getRelUserId();
			if (relUserId != null && !distributorIds.contains(relUserId)) {
				distributorIds.add(relUserId);
			}
		}

		if (CollectionUtils.isNotEmpty(channelUserRelations)) {
			for (SysLabelRelationKey sysLabelRelationKey : channelUserRelations) {
				distributorIds.remove(Long.valueOf(sysLabelRelationKey.getRelId()));
			}
		}

		return distributorIds;
	}

	@Override
	public PageList<SysUser> queryPendingAuditedUser(SysUser userParam, PageModel pageModel) {
		if (userParam == null) {
			userParam = new SysUser();
		}

		List<Integer> checkUsers = Arrays.asList(UserGlobalDict.UserCheckType.USER_AUDIT,
				UserGlobalDict.UserCheckType.QUALIFICATION_AUDIT);
		userParam.setCheckTypeQuery(checkUsers);

		PageList<SysUser> userPageList = this.queryPageByParamMap(pageModel, userParam);

		List<SysUser> resultList = userPageList.getResultList();

		if (CollectionUtils.isNotEmpty(resultList)) {
			Set<Long> userIds = new HashSet<>(resultList.size());
			HashMap<Long, SysUser> userHashMap = new HashMap<>();
			for (SysUser user : resultList) {
				userIds.add(user.getId());
				userHashMap.put(user.getId(), user);
			}

			SysUserDraftQuery draftQuery = new SysUserDraftQuery();
			draftQuery.setUserIds(userIds);
			draftQuery.setCheckTypes(auditCheckTypes);

			List<SysUserDraft> drafts = userDraftService.findListByParams(draftQuery);

			if (CollectionUtils.isNotEmpty(drafts)) {

				for (SysUserDraft draft : drafts) {
					SysUser user = userHashMap.get(draft.getUserId());
					if (user == null)
						continue;

					SysUser draftUser = JSON.parseObject(draft.getDraftData(), SysUser.class);
					user.setBusinessQualification(draftUser.getBusinessQualification());
				}
			}

		}

		return userPageList;
	}

	@Override
	public Result auditPassUser(Long userId, Long checkUserId) {
		return auditUser(userId, checkUserId, UserGlobalDict.passStatus(), null);
	}

	@Override
	public Result auditRejectUser(Long userId, Long checkUserId, String reasonsForRefusal) {
		return auditUser(userId, checkUserId, UserGlobalDict.rejustStatus(), reasonsForRefusal);
	}

	private Result auditUser(Long userId, Long checkUserId, String checkStatus, String reasonsForRefusal) {
		Result result = new Result();
		result.setData(false);
		SysUser user_s = this.getById(userId);

		if (user_s == null) {
			UserErrorCode.setResultError(result, UserErrorCode.User_Null);
			return result;
		}
		if (user_s.getCheckType() != null && user_s.getCheckType() == UserGlobalDict.UserCheckType.NOT_CHECK) {
			UserErrorCode.setResultError(result, UserErrorCode.User_Not_Need_Audit);
			return result;
		}

		Date currentDate = new Date();
		Integer passStatus = Integer.valueOf(checkStatus);

		SysUserDraftQuery draftParam = new SysUserDraftQuery();
		List<SysUserDraft> drafts = userDraftService.findListByParams(draftParam);
		if (CollectionUtils.isNotEmpty(drafts)) {
			// 需要处理下草稿
			if (UserGlobalDict.passStatus() == checkStatus) {
				// 如果执行的审核通过操作，修改草稿也为拒绝
				try {
					SysUserDraft draft = drafts.get(0);
					String draftData = draft.getDraftData();
					if (StringUtils.isNotBlank(draftData)) {
						SysUser sysUser = JSON.parseObject(draftData, SysUser.class);
						user_s.setBusinessQualification(sysUser.getBusinessQualification());
						user_s.setQualificationAudit(UserGlobalDict.QualificationAudit.PASS);
					}
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			} else {
				// 如果执行的审核拒绝操作，修改草稿也为拒绝
				user_s.setQualificationAudit(UserGlobalDict.QualificationAudit.REJECTED);
			}

			for (SysUserDraft draft : drafts) {
				draft.setDraftData(null);
				draft.setCheckType(null);
				draft.setCreateBy(null);
				draft.setCreateDate(null);
				draft.setUserId(null);
				draft.setCheckDate(currentDate);
				draft.setReasonsForRefusal(reasonsForRefusal);
				draft.setCheckUserId(checkUserId);
				draft.setCheckStatus(passStatus);
			}

			// 更新草稿
			userDraftService.updateBatchByPrimaryKey(drafts);
		}

		SysUser updUser = new SysUser();
		updUser.setId(userId);
		updUser.setCheckType(UserGlobalDict.UserCheckType.NOT_CHECK);
		updUser.setCheckUserId(checkUserId);
		updUser.setCheckDate(currentDate);
		updUser.setCheckStatus(checkStatus);
		updUser.setReasonRejection(reasonsForRefusal);

		this.updateByPrimaryKey(updUser);

		result.setData(true);
		return result;
	}

	@Override
	public Result modifyUserReAudit(SysUser sysUser) {
		Result result = checkModifyUserReAudit(sysUser);
		if (!result.isOk()) {
			return result;
		}

		SysUser up = modifyUserToQualificationAudit(sysUser);
		Integer integer = this.updateByPrimaryKey(up);
		if (integer != 1)
			return result;

		SysUserDraft sysUserDraft = createSysUserDraft(sysUser);
		userDraftService.insert(sysUserDraft);

		return result;
	}

	private Result checkModifyUserReAudit(SysUser sysUser) {
		Result result = new Result();

		if (sysUser == null) {
			UserErrorCode.setResultError(result, UserErrorCode.User_Null);
			return result;
		}

		Long sysUserId = sysUser.getId();
		if (sysUserId == null) {
			UserErrorCode.setResultError(result, UserErrorCode.User_Id_Null);
			return result;
		}
		String updateBy = sysUser.getUpdateBy();
		if (updateBy == null) {
			UserErrorCode.setResultError(result, UserErrorCode.User_UpdateBy_Null);
			return result;
		}

		SysUser user_s = this.getById(sysUserId);

		if (user_s == null) {
			UserErrorCode.setResultError(result, UserErrorCode.User_Not_Exist);
			return result;
		}

		if (user_s.getCheckType() != null && user_s.getCheckType() != UserGlobalDict.UserCheckType.NOT_CHECK) {
			UserErrorCode.setResultError(result, UserErrorCode.User_Not_Need_Audit);
			return result;
		}
		if (user_s.getQualificationAudit() != null
				&& user_s.getQualificationAudit() == UserGlobalDict.QualificationAudit.PENDING) {
			UserErrorCode.setResultError(result, UserErrorCode.User_Not_Need_QualificationAudit);
			return result;
		}
		return result;
	}

	private SysUser modifyUserToQualificationAudit(SysUser sysUser) {
		SysUser up = new SysUser();
		up.setId(sysUser.getId());
		up.setCheckType(UserGlobalDict.UserCheckType.QUALIFICATION_AUDIT);
		up.setQualificationAudit(UserGlobalDict.QualificationAudit.PENDING);
		return up;
	}

	private SysUserDraft createSysUserDraft(SysUser sysUser) {
		sysUser.setId(null);
		sysUser.setSupplierId(null);
		sysUser.setUpdateBy(null);
		sysUser.setUpdateDate(null);
		sysUser.setCreateBy(null);
		sysUser.setCreateDate(null);
		sysUser.setCheckType(null);
		sysUser.setCheckStatus(null);
		sysUser.setCheckDate(null);

		SysUserDraft sysUserDraft = new SysUserDraft();
		sysUserDraft.setUserId(sysUser.getId());
		sysUserDraft.setCreateBy(Long.valueOf(sysUser.getUpdateBy()));
		sysUserDraft.setCreateDate(new Date());
		sysUserDraft.setCheckType(UserGlobalDict.UserCheckType.QUALIFICATION_AUDIT);
		sysUserDraft.setCheckStatus(Integer.valueOf(UserGlobalDict.checkStatus()));

		sysUserDraft.setDraftData(JSON.toJSONString(sysUser));
		return sysUserDraft;
	}

	@Override
	public Result<Boolean> checkUserPass(Long userId, Long checkUserId) {
		return checkUser(userId, checkUserId, null, UserGlobalDict.passStatus());
	}

	private Result<Boolean> checkUser(Long userId, Long checkUserId, String reasonsForRefusal, String checkStatus) {
		Result<Boolean> result = new Result<>();

		SysUser user = getById(userId);

		if (user == null) {
			UserErrorCode.setResultError(result, UserErrorCode.User_Not_Exist);
			return result;
		}

		if (user.getCheckStatus() == null || UserGlobalDict.passStatus().equals(user.getCheckStatus())
				|| user.getCheckType() == null || UserGlobalDict.UserCheckType.USER_AUDIT != user.getCheckType()) {
			UserErrorCode.setResultError(result, UserErrorCode.User_Not_Need_Audit);
			return result;
		}

		SysUser updUser = new SysUser();
		updUser.setId(userId);
		updUser.setCheckStatus(checkStatus);
		updUser.setCheckDate(new Date());
		updUser.setCheckUserId(checkUserId);
		if (UserGlobalDict.passStatus().equals(checkStatus)) {
			updUser.setCheckType(UserGlobalDict.UserCheckType.NOT_CHECK);
		}
		updUser.setReasonRejection(reasonsForRefusal);

		updateByPrimaryKey(updUser);
		result.setData(true);

		if (UserGlobalDict.passStatus().equals(checkStatus)) {
			SysUserMicroshop userMicroshop = new SysUserMicroshop();
			userMicroshop.setUserId(userId);
			userMicroshop.setAvatar(userConfig.getMicroshopDefaultAvatar());
			userMicroshop.setName(userConfig.getMicroshopDefaultName());
			userMicroshop.setIntro(userConfig.getMicroshopDefaultIntro());
			userMicroshop.setCreateDate(new Date());
			userMicroshopService.insert(userMicroshop);
		}

		customerMqMessage.sendUserCheckMsg(updUser);

		return result;
	}

	@Override
	public Result<Boolean> checkUserReject(Long userId, Long checkUserId, String reasonsForRefusal) {
		return checkUser(userId, checkUserId, reasonsForRefusal, UserGlobalDict.rejustStatus());
	}

	@Override
	public Result<Boolean> unbundingSupplierAndDirctSingDistributors(Long supplierId, Long distributorsId) {
		Result<Boolean> result = new Result<>(false);

		if (supplierId == null || distributorsId == null) {
			UserErrorCode.setResultError(result, UserErrorCode.User_Id_Null);
			result.setErrorMsg("供应商ID或分销商不能为空");
			return result;
		}

		SysUserRelation rel = new SysUserRelation();
		rel.setUserId(supplierId);
		rel.setRelUserId(distributorsId);
		rel.setRelType(UserGlobalDict.UserRelation.SUPPLIER_DIRECTS_RESELLER);

		List<SysUserRelation> rels = new ArrayList<>(1);
		rels.add(rel);

		sysUserRelationService.delAuthBatch(rels);

		SysLabelRelationKey labelRelationKey = new SysLabelRelationKey();
		labelRelationKey.setRelId(distributorsId.toString());
		labelRelationKey.setRelType(UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
		labelRelationKey.setsId(supplierId);

		List<SysLabelRelationKey> labelRelationKeys = new ArrayList<>(1);
		labelRelationKeys.add(labelRelationKey);

		labelRelationService.delAuthBatch(labelRelationKeys);
		result.setData(true);
		return result;
	}

	@Override
	public List<SysUser> findUserByIds(List<Long> ids) {
		SysUser param = new SysUser();
		param.setQueryIdList(ids);
		List<SysUser> result = super.findListByParams(param);

		if (result != null && result.size() > 0) {
			List<SysUser> users = new ArrayList<>(result.size());
			for (SysUser user : result) {
				SysUser u = new SysUser();
				u.setId(user.getId());
				u.setName(user.getName());
				u.setLoginName(user.getLoginName());
				users.add(u);
			}
			return users;
		}

		return null;
	}

	@Override
	public List<SysUser> findUserByRefereeInfo(Long customerId, String refereeInfo, Integer accountState) {
		SysUser sysUser = new SysUser();
		sysUser.setSupplierId(customerId);
		sysUser.setRefereeInfo(refereeInfo);
		sysUser.setAccountState(accountState);
		List<SysUser> referees = mapper.findUserByRefereeInfo(sysUser);
		return referees;
	}
}