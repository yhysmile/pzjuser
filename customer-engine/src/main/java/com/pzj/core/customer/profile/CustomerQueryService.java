package com.pzj.core.customer.profile;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.pzj.core.customer.entitys.ChannelResellerQueryParam;
import com.pzj.core.customer.entitys.CustomerQuery;
import com.pzj.core.customer.entitys.PageEntity;
import com.pzj.core.customer.entitys.CustomerEntity;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.commons.utils.CheckUtils;
import com.pzj.core.customer.commons.ChannelResellerQueryModel;
import com.pzj.core.customer.commons.PageBean;
import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.read.CustomerReadMapper;
import com.pzj.core.customer.utils.QueryUtil;
import com.pzj.core.customer.utils.UserConstants;
import com.pzj.core.customer.utils.UserRelationEnum;
import com.pzj.core.customer.utils.UserRootEnum;
import com.pzj.framework.entity.QueryResult;

@Service("customerQueryService")
public class CustomerQueryService {
	@Resource
	private CustomerReadMapper customerReadMapper;

	public QueryResult<QueryCustomerResponse> queryResellerListByPage(QueryCustomerRequest param, PageBean page) {
		if (param == null){
			throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
		}
		if (param.getSupplierId() == null){
			throw new CustomerException(CustomerExceptionCode.SUPPLIER_ID_NULL);
		}

		int count = 0;
		List<QueryCustomerResponse> queryCustomerResponses = null;
		CustomerQuery customerQuery = null;

		customerQuery = CustomerModelConvert.convertToCustomerQuery(param);
		count = customerReadMapper.countResellerBaseInfoPage(customerQuery);

		if (count > 0) {
			PageEntity pageEntity = QueryUtil.convertToPageEntity(page);
			List<CustomerEntity> resellers = customerReadMapper.selectResellerBaseInfoList(customerQuery, pageEntity);
			queryCustomerResponses = CustomerModelConvert.convertToQueryCustomerResponse(resellers);
		}

		QueryResult<QueryCustomerResponse> queryResult = QueryUtil.result(page, count, queryCustomerResponses);
		return queryResult;
	}

	public Long checkUserMobileMate(String name, String phone) {
		Long userId = customerReadMapper.judgeUserNameMate(name, phone);
		return userId;
	}

	public QueryCustomerResponse queryUserById(Long id) {
		CustomerEntity reseller = customerReadMapper.selectUserBaseInfoById(id);

		return CustomerModelConvert.convertToQueryCustomerResponse(reseller);
	}

	public QueryCustomerResponse queryUserByInviteCode(String inviteCode) {
		List<CustomerEntity> resellers = customerReadMapper.selectUserBaseByInviteCode(inviteCode);

		if (resellers == null || resellers.size() == 0) {
			return null;
		}

		if (resellers.size() > 1) {
			CustomerExceptionCode code = CustomerExceptionCode.SALESMAN_REFEREE_CODE_MULTIPLE;
			String message = code.getTemplateMessage(inviteCode);
			throw new CustomerException(code, message);
		}

		return CustomerModelConvert.convertToQueryCustomerResponse(resellers.get(0));
	}

	public QueryResult<QueryCustomerResponse> queryChannelUserListByPage(ChannelResellerQueryModel requestModel,
			PageBean page) {
		if (null == page) {
			page = new PageBean();
		}

		ChannelResellerQueryParam channelReseller = initChannelUserParam(requestModel);
		channelReseller.setRelType(UserConstants.DIRECT_CHANNEL_USER_TYPE);
		PageEntity pageEntity = new PageEntity(page.getCurrentPage(), page.getPageSize());
		List<CustomerEntity> customerEntities = customerReadMapper.selectChannelUsers(channelReseller, pageEntity);
		List<QueryCustomerResponse> sysUsers = CustomerModelConvert.convertToQueryCustomerResponse(customerEntities);
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
		List<CustomerEntity> customerEntities = customerReadMapper.selectRootUsers(rootReseller, pageEntity);
		List<QueryCustomerResponse> sysUsers = CustomerModelConvert.convertToQueryCustomerResponse(customerEntities);
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
		List<CustomerEntity> customerEntities = customerReadMapper.selectChannelRelUsers(channelRelUser, pageEntity);
		List<QueryCustomerResponse> sysUsers = CustomerModelConvert.convertToQueryCustomerResponse(customerEntities);
		if (sysUsers == null) {
			return null;
		}
		List<Long> countIds = customerReadMapper.countChannelRelUsers(channelRelUser);
		int count = computorTotalCount(channelRelUser, countIds, customerEntities);

		QueryResult<QueryCustomerResponse> queryResult = new QueryResult<QueryCustomerResponse>(page.getCurrentPage(),
				page.getPageSize());
		queryResult.setRecords(sysUsers);
		queryResult.setTotal(count);
		return queryResult;
	}

	private Integer computorTotalCount(ChannelResellerQueryParam channelRelUser, List<Long> countIds,
			List<CustomerEntity> customerEntities) {
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

		PageEntity pageEntity = QueryUtil.convertToPageEntity(page);
		List<CustomerEntity> customerEntities = customerReadMapper.selectChannelNotRelUsers(channelRelUser, pageEntity);
		List<QueryCustomerResponse> sysUsers = CustomerModelConvert.convertToQueryCustomerResponse(customerEntities);
		if (sysUsers == null) {
			return null;
		}
		List<Long> countIds = customerReadMapper.countChannelNotRelUsers(channelRelUser);
		int count = computorTotalCount(channelRelUser, countIds, customerEntities);

		QueryResult<QueryCustomerResponse> queryResult = new QueryResult<QueryCustomerResponse>(page.getCurrentPage(),
				page.getPageSize());
		queryResult.setRecords(sysUsers);
		queryResult.setTotal(count);
		return queryResult;
	}

	public QueryResult<QueryCustomerResponse> queryMasterOfCustomer(QueryCustomerRequest param, PageBean page) {
		if (param == null){
			throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
		}
		if (param.getId() == null){
			throw new CustomerException(CustomerExceptionCode.CUSTOMER_NULL_ID);
		}

		int count = 0;
		ArrayList<QueryCustomerResponse> queryCustomerResponses = null;
		CustomerQuery customerQuery = null;

		customerQuery = CustomerModelConvert.convertToCustomerQuery(param);
		customerQuery.setUserType(UserGlobalDict.saasUserType());

		count = customerReadMapper.countResellerRelMaster(customerQuery);

		if (count > 0) {
			PageEntity pageEntity = QueryUtil.convertToPageEntity(page);
			List<CustomerEntity> customerEntities = customerReadMapper.selectResellerRelMaster(customerQuery, pageEntity);
			queryCustomerResponses = CustomerModelConvert.convertToQueryCustomerResponse(customerEntities);
		}

		QueryResult<QueryCustomerResponse> queryResult = QueryUtil.result(page, count, queryCustomerResponses);
		return queryResult;
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



	public QueryResult<QueryCustomerResponse> queryCustomerFreeJoin(QueryCustomerRequest param, PageBean page) {
		CustomerQuery customerEntity = CustomerModelConvert.convertToCustomerQuery(param);
		//初始化分页对象
		if (null == page) {
			page = new PageBean();
		}

		if ((CheckUtils.isNull(param.getUserIds()) || param.getUserIds().size() == 0)
				&& param.getQuerType() == GlobalParam.QueryType.exists) {
			return null;
		}
		List<QueryCustomerResponse> queryCustomerResponses = null;
		PageEntity pageEntity = new PageEntity(page.getCurrentPage(), page.getPageSize());
		Integer count = customerReadMapper.countQueryCustomerFreeJoin(customerEntity);

		if (count > 0) {
			List<CustomerEntity> resellers = customerReadMapper.selectCustomerFreeJoin(customerEntity, pageEntity);
			queryCustomerResponses = CustomerModelConvert.convertToQueryCustomerResponse(resellers);
		} else {
			return null;
		}

		QueryResult<QueryCustomerResponse> queryResult = QueryUtil.result(page, count, queryCustomerResponses);
		return queryResult;
	}

	public QueryResult<QueryCustomerLessInfoResponse> queryCustomerLessInfo(QueryCustomerLessInfoRequest param,
			PageBean page) {
		int count = 0;
		List<QueryCustomerLessInfoResponse> records = null;

		CustomerQuery userParam = CustomerModelConvert.convertToResellerQuery(param);

		if (userParam != null) {
			count = customerReadMapper.countCustomerLessInfo(userParam);
			if (count > 0) {
				PageEntity pageEntity = null;
				if (page != null){
					pageEntity = QueryUtil.convertToPageEntity(page);
				}
				List<CustomerEntity> resellerEntities = customerReadMapper.selectCustomerLessInfo(userParam, pageEntity);
				records = CustomerModelConvert.convertToQueryCustomerLessInfoResponse(resellerEntities);
			}
		}

		QueryResult<QueryCustomerLessInfoResponse> result = QueryUtil.result(page, count, records);

		return result;
	}
}
