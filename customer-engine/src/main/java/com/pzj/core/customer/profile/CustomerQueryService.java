package com.pzj.core.customer.profile;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.core.customer.commons.ChannelResellerQueryModel;
import com.pzj.core.customer.read.CustomerReadMapper;
import com.pzj.core.customer.utils.UserConfig;
import com.pzj.core.customer.utils.UserConstants;
import com.pzj.core.customer.utils.UserRelationEnum;
import com.pzj.core.customer.utils.UserRootEnum;
import com.pzj.core.smp.delivery.IShortMessageService;
import com.pzj.core.smp.delivery.MessageBean;
import com.pzj.core.smp.delivery.MessageHead;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;

@Service("customerQueryService")
public class CustomerQueryService {
	private final Logger logger = LoggerFactory.getLogger(CustomerQueryService.class);
	@Resource
	private CustomerReadMapper customerReadMapper;
	@Resource
	private IShortMessageService shortMessageService;
	@Resource(name = "userConfig")
	private UserConfig userConfig;

	public QueryResult<QueryCustomerResponse> queryResellerListByPage(QueryCustomerRequest param, PageBean page) {
		ResellerEntity resellerEntity = initResellerEntity(param);
		//初始化分页对象
		if (null == page) {
			page = new PageBean();
		}
		List<QueryCustomerResponse> sysUsers = null;
		PageEntity pageEntity = new PageEntity(page.getCurrentPage(), page.getPageSize());
		List<ResellerEntity> resellers = customerReadMapper.queryResellerBaseInfoList(resellerEntity, pageEntity);
		sysUsers = initSysUsers(resellers);
		if (sysUsers == null) {
			return null;
		}
		Integer count = customerReadMapper.countResellerBaseInfoPage(resellerEntity);

		QueryResult<QueryCustomerResponse> queryResult = new QueryResult<QueryCustomerResponse>(page.getCurrentPage(),
				page.getPageSize());
		queryResult.setRecords(sysUsers);
		queryResult.setTotal(count);
		return queryResult;
	}

	public Long checkUserMobileMate(String name, String phone) {
		Long userId = customerReadMapper.judgeUserNameMate(name, phone);
		return userId;
	}

	public QueryCustomerResponse queryUserById(Long id) {

		ResellerEntity reseller = customerReadMapper.queryUserBaseInfoById(id);

		return initSysUser(reseller);
	}

	public QueryCustomerResponse queryUserByInviteCode(String inviteCode) {
		List<ResellerEntity> resellers = customerReadMapper.queryUserBaseByInviteCode(inviteCode);

		if (resellers == null || resellers.size() == 0){
			return null;
		}

		if (resellers.size() > 1){
			CustomerExceptionCode code = CustomerExceptionCode.SALESMAN_REFEREE_CODE_MULTIPLE;
			String message = code.getTemplateMessage(inviteCode);
			throw new CustomerException(code, message);
		}

		return initSysUser(resellers.get(0));
	}

	public QueryResult<QueryCustomerResponse> queryChannelUserListByPage(ChannelResellerQueryModel requestModel,
			PageBean page) {
		if (null == page) {
			page = new PageBean();
		}

		ChannelResellerQueryParam channelReseller = initChannelUserParam(requestModel);
		channelReseller.setRelType(UserConstants.DIRECT_CHANNEL_USER_TYPE);
		PageEntity pageEntity = new PageEntity(page.getCurrentPage(), page.getPageSize());
		List<ResellerEntity> resellerEntitys = customerReadMapper.queryChannelUsers(channelReseller, pageEntity);
		List<QueryCustomerResponse> sysUsers = initSysUsers(resellerEntitys);
		if (sysUsers == null) {
			return null;
		}
		Integer count = customerReadMapper.countChannelUsers(channelReseller);

		QueryResult<QueryCustomerResponse> queryResult = new QueryResult<QueryCustomerResponse>(page.getCurrentPage(),
				page.getPageSize());
		queryResult.setRecords(sysUsers);
		queryResult.setTotal(count);
		return queryResult;
	}

	public QueryResult<QueryCustomerResponse> queryRootUserListByPage(ChannelResellerQueryModel requestModel,
			PageBean page) {
		if (null == page) {
			page = new PageBean();
		}

		ChannelResellerQueryParam rootReseller = initChannelUserParam(requestModel);
		rootReseller.setRelType(UserRelationEnum.SUPPLIER_DIRECT_RESELLER.getId());
		PageEntity pageEntity = new PageEntity(page.getCurrentPage(), page.getPageSize());
		List<ResellerEntity> resellerEntitys = customerReadMapper.queryRootUsers(rootReseller, pageEntity);
		List<QueryCustomerResponse> sysUsers = initSysUsers(resellerEntitys);
		if (sysUsers == null) {
			return null;
		}
		Integer count = customerReadMapper.countRootUsers(rootReseller);

		QueryResult<QueryCustomerResponse> queryResult = new QueryResult<QueryCustomerResponse>(page.getCurrentPage(),
				page.getPageSize());
		queryResult.setRecords(sysUsers);
		queryResult.setTotal(count);
		return queryResult;
	}

	public QueryResult<QueryCustomerResponse> queryChannelRelUserPage(ChannelResellerQueryModel requestModel,
			PageBean page) {
		if (null == page) {
			page = new PageBean();
		}
		ChannelResellerQueryParam channelRelUser = initChannelUserParam(requestModel);
		if (requestModel.getRootId() != null) {
			channelRelUser.setUserRelType(UserRelationEnum.SUPPLIER_DIRECT_RESELLER.getId());
		}
		if (requestModel.getChannelId() != null) {
			channelRelUser.setRelType(UserConstants.DIRECT_CHANNEL_USER_TYPE);
		}
		channelRelUser.setTempRelResellers(requestModel.getTempRelResellers());
		channelRelUser.setTempRemoveResellers(requestModel.getTempRemoveResellers());
		PageEntity pageEntity = new PageEntity(page.getCurrentPage(), page.getPageSize());
		List<ResellerEntity> resellerEntitys = customerReadMapper.queryChannelRelUsers(channelRelUser, pageEntity);
		List<QueryCustomerResponse> sysUsers = initSysUsers(resellerEntitys);
		if (sysUsers == null) {
			return null;
		}
		List<Long> countIds = customerReadMapper.countChannelRelUsers(channelRelUser);
		int count = computorTotalCount(channelRelUser, countIds, resellerEntitys);

		QueryResult<QueryCustomerResponse> queryResult = new QueryResult<QueryCustomerResponse>(page.getCurrentPage(),
				page.getPageSize());
		queryResult.setRecords(sysUsers);
		queryResult.setTotal(count);
		return queryResult;
	}

	private Integer computorTotalCount(ChannelResellerQueryParam channelRelUser, List<Long> countIds,
			List<ResellerEntity> resellerEntitys) {
		int count = countIds.size();
		List<Long> addResellers = channelRelUser.getTempRelResellers();
		if (addResellers != null && addResellers.size() > 0) {
			List<Long> allDelResellers = new ArrayList<Long>();
			List<Long> delResellers = channelRelUser.getTempRemoveResellers();
			if (delResellers != null && delResellers.size() > 0) {
				allDelResellers.addAll(delResellers);
			}
			if (countIds != null && countIds.size() > 0) {
				allDelResellers.addAll(countIds);
			}

			channelRelUser.setTempRemoveResellers(allDelResellers);
			int addNum = customerReadMapper.countResellerSum(channelRelUser);
			count += addNum;
		}

		return count;
	}

	public QueryResult<QueryCustomerResponse> queryChannelNotRelUserPage(ChannelResellerQueryModel requestModel,
			PageBean page) {
		if (null == page) {
			page = new PageBean();
		}
		ChannelResellerQueryParam channelRelUser = initChannelUserParam(requestModel);
		channelRelUser.setUserRelType(UserRelationEnum.SUPPLIER_DIRECT_RESELLER.getId());
		channelRelUser.setRelType(UserConstants.DIRECT_CHANNEL_USER_TYPE);
		channelRelUser.setTempRelResellers(requestModel.getTempRelResellers());
		channelRelUser.setTempRemoveResellers(requestModel.getTempRemoveResellers());

		PageEntity pageEntity = new PageEntity(page.getCurrentPage(), page.getPageSize());
		List<ResellerEntity> resellerEntitys = customerReadMapper.queryChannelNotRelUsers(channelRelUser, pageEntity);
		List<QueryCustomerResponse> sysUsers = initSysUsers(resellerEntitys);
		if (sysUsers == null) {
			return null;
		}
		List<Long> countIds = customerReadMapper.countChannelNotRelUsers(channelRelUser);
		int count = computorTotalCount(channelRelUser, countIds, resellerEntitys);

		QueryResult<QueryCustomerResponse> queryResult = new QueryResult<QueryCustomerResponse>(page.getCurrentPage(),
				page.getPageSize());
		queryResult.setRecords(sysUsers);
		queryResult.setTotal(count);
		return queryResult;
	}

	public Boolean sendSms(CreateCustomerRequest sysUser) {
		Long supplierId = sysUser.getSupplierId();
		String supplierName = "";
		if (supplierId != null && supplierId.longValue() > 0) {
			ResellerEntity resellerEntity = customerReadMapper.queryUserBaseInfoById(supplierId);
			if (null != resellerEntity) {
				supplierName = resellerEntity.getName();
				if (supplierName == null || "".equals(supplierName.trim())) {
					supplierName = resellerEntity.getCorporater();
				}
			}
		}
		String initPassword = sysUser.getUserPassword();
		String appUrl = userConfig.getAppDownload();
		String smContent = PasswordGenerateUtil.passwordNoticeMessage(supplierName, sysUser.getLoginName(),
				initPassword, appUrl);

		List<String> phones = new ArrayList<String>();
		phones.add(sysUser.getCorporaterMobile());

		MessageHead head = new MessageHead(UserConstants.SMP_USER_PASSWORD_KEY, "A", 3000L);
		MessageBean messageBean = new MessageBean(head, phones, smContent);
		logger.info("invoke send message,param:{}", JSONConverter.toJson(messageBean));

		Result<Boolean> result = shortMessageService.sendMessage(messageBean);

		return result.getData();
	}

	private ChannelResellerQueryParam initChannelUserParam(ChannelResellerQueryModel requestModel) {
		if (requestModel == null) {
			return null;
		}

		ChannelResellerQueryParam queryParam = new ChannelResellerQueryParam();
		queryParam.setChannelId(requestModel.getChannelId());
		queryParam.setRootId(requestModel.getRootId());
		queryParam.setLoginName(requestModel.getLoginName());
		queryParam.setName(requestModel.getName());
		queryParam.setConcat(requestModel.getConcat());
		queryParam.setMobile(requestModel.getMobile());
		queryParam.setAddress(requestModel.getAddress());
		queryParam.setProvince(requestModel.getProvince());
		queryParam.setCity(requestModel.getCity());
		queryParam.setCounty(requestModel.getCounty());
		queryParam.setResellerType(requestModel.getResellerType());
		queryParam.setBindSDate(requestModel.getBindSDate());
		queryParam.setBindEDate(requestModel.getBindEDate());
		queryParam.setIsRoot(UserRootEnum.ROOT_USER.getKey());
		queryParam.setRefereeId(requestModel.getRefereeId());
		return queryParam;
	}

	private ResellerEntity initResellerEntity(QueryCustomerRequest param) {
		if (param == null) {
			return null;
		}
		ResellerEntity resellerEntity = new ResellerEntity();
		resellerEntity.setLoginName(param.getLoginName());
		resellerEntity.setSupplierId(param.getSupplierId());
		resellerEntity.setCorporater(param.getCorporater());
		resellerEntity.setCorporaterMobile(param.getCorporaterMobile());
		resellerEntity.setName(param.getName());
		resellerEntity.setAddress(param.getAddress());
		resellerEntity.setUserRelType(UserRelationEnum.SUPPLIER_DIRECT_RESELLER.getId());
		resellerEntity.setIsRoot(UserRootEnum.ROOT_USER.getKey());
		if (param.getResellerType() != null) {
			resellerEntity.setResellerType(param.getResellerType().toString());
		}
		resellerEntity.setRefereeId(param.getRefereeId());
		resellerEntity.setCreateDate(param.getCreateDate());
		resellerEntity.setBindDateBegin(param.getBindDateBegin());
		resellerEntity.setBindDateEnd(param.getBindDateEnd());
		resellerEntity.setProvince(param.getProvince());
		resellerEntity.setCity(param.getCity());
		resellerEntity.setCounty(param.getCounty());
		return resellerEntity;
	}

	private ArrayList<QueryCustomerResponse> initSysUsers(List<ResellerEntity> resellers) {
		if (resellers == null || resellers.size() == 0) {
			return null;
		}
		ArrayList<QueryCustomerResponse> sysUsers = new ArrayList<QueryCustomerResponse>();
		for (ResellerEntity reseller : resellers) {

			sysUsers.add(initSysUser(reseller));
		}
		return sysUsers;
	}

	private QueryCustomerResponse initSysUser(ResellerEntity reseller) {
		if (reseller == null) {
			return null;
		}
		QueryCustomerResponse sysUser = new QueryCustomerResponse();
		sysUser.setId(reseller.getId());
		sysUser.setLoginName(reseller.getLoginName());
		sysUser.setSupplierId(reseller.getSupplierId());
		sysUser.setCorporater(reseller.getCorporater());
		sysUser.setCorporaterMobile(reseller.getCorporaterMobile());
		sysUser.setName(reseller.getName());
		sysUser.setAddress(reseller.getAddress());
		sysUser.setResellerType(reseller.getResellerType() == null ? null
				: Integer.parseInt(reseller.getResellerType()));
		sysUser.setCreateDate(reseller.getCreateDate());
		sysUser.setProvince(reseller.getProvince());
		sysUser.setCity(reseller.getCity());
		sysUser.setCounty(reseller.getCounty());

		if (reseller.getName() == null || reseller.getName().trim().length() == 0) {
			sysUser.setName(reseller.getCorporater());
		}
		return sysUser;
	}
}
