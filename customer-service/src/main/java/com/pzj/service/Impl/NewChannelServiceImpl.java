package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.pzj.core.customer.channel.*;
import com.pzj.core.customer.profile.CustomerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.channel.mq.ChannelMqMessage;
import com.pzj.core.customer.channel.mq.ModifyChannel;
import com.pzj.core.customer.commons.exception.CustomerException;
import com.pzj.core.customer.commons.exception.CustomerExceptionCode;
import com.pzj.core.customer.profile.CustomerQueryService;
import com.pzj.core.customer.profile.QueryCustomerRequest;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;
import com.pzj.framework.toolkit.Check;

/**
 * Created by Administrator on 2017-2-17.
 */
@Service("newChannelService")
public class NewChannelServiceImpl implements ChannelService {
	private static final Logger logger = LoggerFactory.getLogger(NewChannelServiceImpl.class);
	@Resource
	private ChannelServiceImpl channelService;

	@Resource
	private UserServiceImpl userService;

	@Resource
	private CustomerQueryService customerQueryService;

	@Resource
	private ChannelMqMessage channelMqMessage;

	@Resource
	private ChannelQueryEngine channelQueryEngine;

	@Resource
	private ChannelMessageEngine channelMessageEngine;

	@Override
	public Result<Long> createChannel(final CreateChannelRequest channel) {
		return RpcCaller.call(new RpcCaller<Long>() {
			@Override
			public Long call() {
				if (channel == null) {
					throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
				}
				if (channel.getName() == null) {
					throw new CustomerException(CustomerExceptionCode.CHANNEL_NULL_NAME);
				}
				if (channel.getCreateBy() == null) {
					throw new CustomerException(CustomerExceptionCode.OPERATOR_NULL);
				}

				SysUser createByUser = userService.getById(channel.getCreateBy());
				if (createByUser == null) {
					throw new CustomerException(CustomerExceptionCode.OPERATOR_NOT_EXIST);
				}
				if (!GlobalParam.FLAG.start().equals(createByUser.getAccountState())) {
					throw new CustomerException(CustomerExceptionCode.OPERATOR_DISABLE);
				}

				Long ownerId = CustomerUtil.ownerId(createByUser);

				SysChannel createChannel = new SysChannel();

				createChannel.setSupplierId(ownerId);
				createChannel.setDataSource(createByUser.getUserSource());
				createChannel.setChannelType(UserGlobalDict.ChannelGlobalDict.directStrategy());
				createChannel.setDelFlag(GlobalParam.FLAG.start().toString());
				createChannel.setCreateDate(new Date());
				createChannel.setCreateBy(String.valueOf(channel.getCreateBy()));
				createChannel.setName(channel.getName());

				Long insert = channelService.insert(createChannel);
				if (insert > 0) {
					return createChannel.getId();
				}
				return null;
			}
		});
	}

	@Override
	public Result<Boolean> modifyChannel(final ModifyChannelRequest channel) {
		return RpcCaller.call(new RpcCaller<Boolean>() {
			@Override
			public Boolean call() {

				if (channel == null) {
					throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
				}
				if (channel.getName() == null) {
					throw new CustomerException(CustomerExceptionCode.CHANNEL_NULL_NAME);
				}
				if (channel.getUpdateBy() == null) {
					throw new CustomerException(CustomerExceptionCode.OPERATOR_NULL);
				}

				SysUser updateByUser = userService.getById(channel.getUpdateBy());
				if (updateByUser == null) {
					throw new CustomerException(CustomerExceptionCode.OPERATOR_NOT_EXIST);
				}
				if (!GlobalParam.FLAG.start().equals(updateByUser.getAccountState())) {
					throw new CustomerException(CustomerExceptionCode.OPERATOR_DISABLE);
				}

				SysChannel sysChannel = channelService.getById(channel.getId());
				if (sysChannel == null) {
					throw new CustomerException(CustomerExceptionCode.CHANNEL_NOT_EXIST);
				}
				if ("2".equals(sysChannel.getDelFlag())) {
					throw new CustomerException(CustomerExceptionCode.CHANNEL_DELETED);
				}

				if (!updateByUser.getSupplierId().equals(sysChannel.getSupplierId())) {
					throw new CustomerException(CustomerExceptionCode.OPERATOR_SUPPLIER_MISMATCH);
				}

				SysChannel updateChannel = new SysChannel();

				updateChannel.setId(channel.getId());
				updateChannel.setName(channel.getName());
				updateChannel.setUpdateBy(String.valueOf(channel.getUpdateBy()));
				updateChannel.setUpdateDate(new Date());

				Integer update = channelService.updateByPrimaryKey(updateChannel);

				return update == 1;
			}
		});
	}

	@Override
	public Result<Boolean> deleteChannel(final Long id, final Long operator) {
		return RpcCaller.call(new RpcCaller<Boolean>() {
			@Override
			public Boolean call() {
				if (id == null || operator == null) {
					throw new CustomerException(CustomerExceptionCode.CHANNEL_NULL_ID);
				}

				SysChannel sysChannel = channelService.getById(id);
				if (sysChannel == null || "2".equals(sysChannel.getDelFlag())) {
					throw new CustomerException(CustomerExceptionCode.CHANNEL_DELETED);
				}

				SysUser sysUser = userService.getById(operator);
				if (sysUser == null) {
					throw new CustomerException(CustomerExceptionCode.OPERATOR_NOT_EXIST);
				}
				if (!sysUser.getSupplierId().equals(sysChannel.getSupplierId())) {
					throw new CustomerException(CustomerExceptionCode.OPERATOR_SUPPLIER_MISMATCH);
				}

				SysChannel updateChannel = new SysChannel();

				updateChannel.setId(id);
				updateChannel.setDelFlag(GlobalParam.FLAG.del().toString());
				updateChannel.setUpdateBy(String.valueOf(operator));
				updateChannel.setUpdateDate(new Date());

				Integer update = channelService.updateByPrimaryKey(updateChannel);
				if (update >= 1) {
					sendModifyChannel(id, Integer.valueOf(sysChannel.getDelFlag()), operator);
				}
				return update == 1;
			}
		});
	}

	private void sendModifyChannel(Long channelId, Integer oldState, Long operatorId) {
		channelMessageEngine.sendChannelStatusChange(channelId, oldState, GlobalParam.FLAG.del(), operatorId);
	}

	@Override
	public Result<QueryResult<QueryChannelResponse>> queryChannelsUserJoin(final QueryChannelRequest channelRequest,
																		   final QueryCustomerRequest customerRequest,
																		   final PageModel pageModel,
																		   final List<Long> tmpDelIds,
																		   final List<Long> tmpAddIds) {
		logOfIntoSenate(channelRequest, customerRequest, tmpDelIds, tmpAddIds);

		Result<QueryResult<QueryChannelResponse>> result = new RpcCaller<QueryResult<QueryChannelResponse>>(){

			@Override
			public QueryResult<QueryChannelResponse> call() {
				return channelQueryEngine.queryChannelsUserJoin(channelRequest, customerRequest, pageModel, tmpDelIds, tmpAddIds);
			}
		}.run();

		logOfOutOfSenate(result);

		return result;
	}

	@Override
	public Result<QueryResult<QueryChannelResponse>> queryChannelsUserNotJoin(final QueryChannelRequest channelRequest,
																			  final QueryCustomerRequest customerRequest,
																			  final PageModel pageModel,
																			  final List<Long> tmpAddIds,
																			  final List<Long> tmpDelIds) {
		logOfIntoSenate(channelRequest, customerRequest, tmpDelIds, tmpAddIds);

		Result<QueryResult<QueryChannelResponse>> result = new RpcCaller<QueryResult<QueryChannelResponse>>(){

			@Override
			public QueryResult<QueryChannelResponse> call() {
				return channelQueryEngine.queryChannelsUserNotJoin(channelRequest, customerRequest, pageModel, tmpDelIds, tmpAddIds);
			}
		}.run();

		logOfOutOfSenate(result);

		return result;

	}

	@Override
	public Result<Boolean> modifyUserOwnedChannel(Long customerId, List<Long> addChannelIds, List<Long> delChannelIds,
			Long operId) {
		if (customerId == null || customerId < 0 || operId == null || operId < 0
				|| (Check.NuNObject(addChannelIds) && Check.NuNObject(delChannelIds))) {
			logger.warn("参数不合法，customerId is " + customerId + "addChannelIds is +"
					+ JSONConverter.toJson(addChannelIds) + "delChannelIds is " + JSONConverter.toJson(delChannelIds)
					+ "operId is " + operId);
			return new Result<>();
		}
		try {
			SysUser sysUser = userService.getById(operId);
			if (Check.NuNObject(sysUser)) {
				logger.warn("操作人信息为空，操作人id:{}", operId);
				new Result<>(CustomerExceptionCode.OPER_DATA_NULL.getCode(),
						CustomerExceptionCode.OPER_DATA_NULL.getMsg());
			}
			List<Long> addChannelIdsBak;
			if (addChannelIds != null){
				addChannelIdsBak = new ArrayList<>(addChannelIds);
			} else {
				addChannelIdsBak = Collections.EMPTY_LIST;
			}
			Result<Boolean> booleanResult = channelService.modifyChannelUserOwned(customerId, addChannelIds,
					delChannelIds, operId, sysUser.getSupplierId(), null);

			if (booleanResult.getData()){
				channelMessageEngine.sendMsg2(customerId, addChannelIdsBak, delChannelIds, operId);
			}
			return booleanResult;

		} catch (CustomerException cusEx) {
			logger.error(
					"管理渠道用户关联关系出错,customerId is " + customerId + "addChannelIds is +"
							+ JSONConverter.toJson(addChannelIds) + "delChannelIds is "
							+ JSONConverter.toJson(delChannelIds) + "operId is " + operId, cusEx);
			return new Result<>(cusEx.getCode(), cusEx.getMessage());
		} catch (Exception e) {
			logger.error("管理渠道用户关联关系出错", e);
			return new Result<>(CustomerExceptionCode.ERROR.getCode(), CustomerExceptionCode.ERROR.getMsg());
		}
	}

	@Override
	public Result<Boolean> modifyChannelOwnedUser(Long channelId, List<Long> addCustomerIds, List<Long> delCustomerIds, Long operId) {
		if (channelId == null || channelId < 0 || operId == null || operId < 0
				|| (Check.NuNObject(addCustomerIds) && Check.NuNObject(delCustomerIds))) {
			logger.warn("参数不合法，channelId is " + channelId + "addCustomerIds is +"
					+ JSONConverter.toJson(addCustomerIds) + "delCustomerIds is "
					+ JSONConverter.toJson(delCustomerIds) + "operId is " + operId);
			return new Result<>();
		}
		try {
			SysUser sysUser = userService.getById(operId);
			if (Check.NuNObject(sysUser)) {
				logger.warn("操作人信息为空，操作人id:{}", operId);
				CustomerExceptionCode code = CustomerExceptionCode.OPER_DATA_NULL;
				new Result<>(code.getCode(), code.getMsg());
			}

			List<Long> addCustomerIdsBak;
			if (addCustomerIds != null){
				addCustomerIdsBak = new ArrayList<>(addCustomerIds);
			} else {
				addCustomerIdsBak = Collections.EMPTY_LIST;
			}
			Result<Boolean> booleanResult = channelService.modifyChannelUserOwned(channelId, addCustomerIds,
					delCustomerIds, operId, sysUser.getSupplierId(),
					UserGlobalParam.ChannelMapKeyParam.DIRECT_CHANNEL_USER_TYPE);

			if (booleanResult.getData()){
				channelMessageEngine.sendMsg1(channelId, addCustomerIdsBak, delCustomerIds, operId);
			}

			return booleanResult;
		} catch (CustomerException customerE) {
			return new Result<>(customerE.getCode(), customerE.getMessage());
		} catch (Exception e) {
			return new Result<>(CustomerExceptionCode.ERROR.getCode(), CustomerExceptionCode.ERROR.getMsg());
		}
	}

	@Override
	public Result<QueryChannelResponse> queryChannelDetailByChannelId(Long channelId) {
		if (channelId == null) {
			logger.warn("渠道id不合法,渠道id为:{}", channelId);
			new Result<>(CustomerExceptionCode.PARAMETER_EMPTY.getCode(),
					CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
		}
		SysChannel sysChannel = channelService.getById(channelId);
		if (Check.NuNObject(sysChannel)) {
			return new Result<>(new QueryChannelResponse());
		}
		QueryChannelResponse channelResponse = new QueryChannelResponse(sysChannel.getId(), sysChannel.getName(),
				sysChannel.getCreateDate());
		return new Result<>(channelResponse);
	}

	@Override
	public Result<QueryChannelRelationResponse> queryChannelRelationByChannelId(List<Long> channelIds) {
		Result<QueryChannelRelationResponse> result = new Result<QueryChannelRelationResponse>();
		if (channelIds == null || channelIds.isEmpty()) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query channel rel user param error! request:{}", JSONConverter.toJson(channelIds));
			return result;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("query channel rel user.request param:{}", JSONConverter.toJson(channelIds));
		}

		QueryChannelRelationResponse response = customerQueryService.queryUserIdsByChannelIds(channelIds);
		result.setData(response);

		logOfOutOfSenate(result);

		return result;
	}

	@Override
	public Result<QueryResult<QueryChannelResponse>> queryChannelFreeJoin(final QueryChannelRequest channelRequest,
																		  final QueryCustomerRequest customerRequest,
																		  final PageModel pageModel,
																		  final Integer operType) {

		logOfIntoSenate(channelRequest, customerRequest, operType);

		Result<QueryResult<QueryChannelResponse>> result = new RpcCaller<QueryResult<QueryChannelResponse>>(){

			@Override
			public QueryResult<QueryChannelResponse> call() {
				return channelQueryEngine.queryChannelFreeJoin(channelRequest, customerRequest, pageModel, operType);
			}

		}.run();

		logOfOutOfSenate(result);

		return result;
	}

	private void logOfIntoSenate(QueryChannelRequest channelRequest, QueryCustomerRequest customerRequest, List<Long> tmpAddIds, List<Long> tmpDelIds){
		if (logger.isDebugEnabled()) {
			logger.debug("渠道查询条件:{}", JSONConverter.toJson(channelRequest));
			logger.debug("用户查询条件:{}", JSONConverter.toJson(customerRequest));
			logger.debug("tmpDelIds:{},tmpAddIds:{}", JSONConverter.toJson(tmpDelIds), JSONConverter.toJson(tmpAddIds));
		}
	}

	private void logOfIntoSenate(QueryChannelRequest channelRequest, QueryCustomerRequest customerRequest,  Integer operType){
		if (logger.isDebugEnabled()) {
			logger.debug("The parameters of the query channel. channel:{},customer:{},operType:{}",
					JSONConverter.toJson(channelRequest), JSONConverter.toJson(customerRequest), operType);
		}
	}

	private void logOfOutOfSenate(Object result){
		if (logger.isDebugEnabled()) {
			logger.debug("执行结果 :{}", JSONConverter.toJson(result));
		}
	}
}
