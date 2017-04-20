package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.channel.ChannelService;
import com.pzj.core.customer.channel.CreateChannelRequest;
import com.pzj.core.customer.channel.ModifyChannelRequest;
import com.pzj.core.customer.channel.QueryChannelRequest;
import com.pzj.core.customer.channel.QueryChannelResponse;
import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.profile.QueryCustomerRequest;
import com.pzj.core.customer.utils.ModelConvert;
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

	@Override
	public Result<Long> createChannel(final CreateChannelRequest channel) {
		return RpcCaller.call(new RpcCaller<Long>() {
			@Override
			public Long call() {
				if (channel == null) {
					throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
				}
				if (channel.getName() == null) {
					throw new CustomerException(CustomerExceptionCode.CHANNEL_NAME_NULL);
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
					throw new CustomerException(CustomerExceptionCode.CHANNEL_NAME_NULL);
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
					throw new CustomerException(CustomerExceptionCode.CHANNEL_ID_NULL);
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
				return update == 1;
			}
		});
	}

	@Override
	public Result<QueryResult<QueryChannelResponse>> queryChannelsUserJoin(QueryChannelRequest channelRequest,
			QueryCustomerRequest customerRequest, PageModel pageModel, List<Long> tmpDelIds, List<Long> tmpAddIds) {

		if ((customerRequest == null || customerRequest.getId() == null || customerRequest.getId() < 0)
				&& (channelRequest == null || channelRequest.getSupplierId() == null || channelRequest.getSupplierId() < 0)) {
			logger.warn("参数不合法，分销商id为{}，供应商id为{}", customerRequest == null ? null : customerRequest.getId(),
					channelRequest == null ? null : channelRequest.getSupplierId());
			return new Result<>(CustomerExceptionCode.PARAMETER_EMPTY.getCode(),
					CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
		}
		if (logger.isDebugEnabled()) {
			if (channelRequest != null) {
				logger.debug("渠道查询条件:{}", JSONConverter.toJson(channelRequest));
			}
			logger.debug("用户查询条件:{}", JSONConverter.toJson(customerRequest));
			logger.debug("tmpDelIds:{},tmpAddIds:{}", JSONConverter.toJson(tmpDelIds), JSONConverter.toJson(tmpAddIds));
		}

		//如果参数为null，那么设为空对象，保证下面模型转换不报错
		if (Check.NuNObject(customerRequest)) {
			customerRequest = new QueryCustomerRequest();
		}
		if (Check.NuNObject(channelRequest)) {
			channelRequest = new QueryChannelRequest();
		}
		//模型转换
		SysUser sysUser = new SysUser(customerRequest.getCorporaterMobile(), customerRequest.getCorporater(),
				customerRequest.getName(), customerRequest.getId());
		sysUser.setNameOrNormal(customerRequest.getNameOrNormal());
		SysChannel sysChannel = new SysChannel(channelRequest.getSupplierId(), channelRequest.getId(),
				channelRequest.getName(), channelRequest.getCreateDate(), channelRequest.getCreateEndDate(),
				GlobalParam.FLAG.start());
		try {
			Result<QueryResult<SysChannel>> channelPageList = channelService.queryChannelContainUser(sysChannel,
					sysUser, pageModel, tmpDelIds, tmpAddIds);
			if (logger.isDebugEnabled()) {
				logger.debug("用户已关联的渠道,用户id:{},渠道信息:{}", customerRequest.getId(), JSONConverter.toJson(channelPageList));
			}

			QueryResult<QueryChannelResponse> queryResult = new QueryResult<QueryChannelResponse>(pageModel == null ? 1
					: pageModel.getPageNo(), pageModel == null ? 20 : pageModel.getPageSize());
			List<QueryChannelResponse> channelResponses = new ArrayList<QueryChannelResponse>();
			if (channelPageList.getErrorCode() == new Result<>().getErrorCode() && channelPageList.getData() != null
					&& channelPageList.getData().getRecords() != null) {
				channelResponses = ModelConvert.convertChannelResponses(channelPageList.getData().getRecords());
				queryResult.setRecords(channelResponses);
			}

			queryResult.setTotal(channelPageList.getData().getTotal());
			Result<QueryResult<QueryChannelResponse>> result = new Result<QueryResult<QueryChannelResponse>>(
					channelPageList.getErrorCode(), channelPageList.getErrorMsg());
			result.setData(queryResult);
			return result;
		} catch (CustomerException cusExcep) {
			logger.error(
					"查询渠道出错,渠道参数:" + JSONConverter.toJson(channelRequest) + ",用户参数:"
							+ JSONConverter.toJson(customerRequest) + ",临时增加参数:" + JSONConverter.toJson(tmpAddIds)
							+ ",临时删除参数:" + JSONConverter.toJson(tmpDelIds), cusExcep);
			return new Result<>(cusExcep.getCode(), cusExcep.getMessage());
		} catch (Exception e) {
			logger.error(
					"查询渠道运行出错,渠道参数:" + JSONConverter.toJson(channelRequest) + ",用户参数:"
							+ JSONConverter.toJson(customerRequest) + ",临时增加参数:" + JSONConverter.toJson(tmpAddIds)
							+ ",临时删除参数:" + JSONConverter.toJson(tmpDelIds), e);
			return new Result<>(CustomerExceptionCode.ERROR.getCode(), CustomerExceptionCode.ERROR.getMsg());
		}
	}

	@Override
	public Result<QueryResult<QueryChannelResponse>> queryChannelsUserNotJoin(QueryChannelRequest channelRequest,
			QueryCustomerRequest customerRequest, PageModel pageModel, List<Long> tmpAddIds, List<Long> tmpDelIds) {

		//查询用户未关联的渠道
		//分页参数为null，查询出所有的已加入渠道,所以查询参数为null
		if (customerRequest == null || customerRequest.getId() == null || customerRequest.getId() < 0) {
			logger.warn("用户id不合法，分销商id为{}", customerRequest == null ? null : customerRequest.getId());
			return new Result<>(CustomerExceptionCode.PARAMETER_EMPTY.getCode(),
					CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
		}
		if (channelRequest == null || channelRequest.getSupplierId() == null || channelRequest.getSupplierId() < 0) {
			logger.warn("供应商id不合法，供应商id为{}", channelRequest == null ? null : channelRequest.getSupplierId());
			return new Result<>(CustomerExceptionCode.PARAMETER_EMPTY.getCode(),
					CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("渠道查询条件:{}", JSONConverter.toJson(channelRequest));
		}
		//第一步，查询出已经关联的，参数只有用户id，要查询用户关联的所有的
		try {
			QueryCustomerRequest customerParam = new QueryCustomerRequest();
			customerParam.setId(customerRequest.getId());
			Result<QueryResult<QueryChannelResponse>> channelPageList = queryChannelsUserJoin(
					new QueryChannelRequest(), customerParam, null, tmpAddIds, tmpDelIds);
			List<Long> channelIds = new ArrayList<>();
			if (channelPageList.getErrorCode() == new Result<>().getErrorCode() && channelPageList.getData() != null
					&& channelPageList.getData().getRecords() != null) {
				for (QueryChannelResponse channel : channelPageList.getData().getRecords()) {
					channelIds.add(channel.getId());
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug("用户已关联的渠道ids:{}", JSONConverter.toJson(channelIds));
			}

			//模型转换
			SysUser distributorParam = new SysUser(customerRequest.getCorporaterMobile(),
					customerRequest.getCorporater(), customerRequest.getName(), customerRequest.getId());
			distributorParam.setNameOrNormal(customerRequest.getNameOrNormal());
			SysChannel channelParam = new SysChannel(channelRequest.getSupplierId(), channelRequest.getId(),
					channelRequest.getName(), channelRequest.getCreateDate(), channelRequest.getCreateEndDate(),
					GlobalParam.FLAG.start());

			Result<QueryResult<SysChannel>> notJoinChannels = channelService.queryChannelsUserNotJoin(channelParam,
					distributorParam, pageModel, channelIds);

			QueryResult<QueryChannelResponse> queryResult = new QueryResult<QueryChannelResponse>(
					pageModel.getPageNo(), pageModel.getPageSize());
			List<QueryChannelResponse> channelResponses = new ArrayList<>();
			if (notJoinChannels.getErrorCode() == new Result<>().getErrorCode() && notJoinChannels.getData() != null
					&& notJoinChannels.getData().getRecords() != null) {

				channelResponses = ModelConvert.convertChannelResponses(notJoinChannels.getData().getRecords());
				queryResult.setRecords(channelResponses);
			}

			queryResult.setTotal(notJoinChannels.getData().getTotal());
			Result<QueryResult<QueryChannelResponse>> result = new Result<QueryResult<QueryChannelResponse>>(
					channelPageList.getErrorCode(), channelPageList.getErrorMsg());
			result.setData(queryResult);
			return result;
		} catch (CustomerException cusExcep) {
			logger.error(
					"查询未关联的渠道出错,渠道参数:" + JSONConverter.toJson(channelRequest) + ",用户参数:"
							+ JSONConverter.toJson(customerRequest) + ",临时增加参数:" + JSONConverter.toJson(tmpAddIds)
							+ ",临时删除参数:" + JSONConverter.toJson(tmpDelIds), cusExcep);
			return new Result<>(cusExcep.getCode(), cusExcep.getMessage());
		} catch (Exception e) {
			logger.error(
					"查询渠道运行出错,渠道参数:" + JSONConverter.toJson(channelRequest) + ",用户参数:"
							+ JSONConverter.toJson(customerRequest) + ",临时增加参数:" + JSONConverter.toJson(tmpAddIds)
							+ ",临时删除参数:" + JSONConverter.toJson(tmpDelIds), e);
			return new Result<>(CustomerExceptionCode.ERROR.getCode(), CustomerExceptionCode.ERROR.getMsg());
		}
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
			Result<Boolean> booleanResult = channelService.modifyChannelUserOwned(customerId, addChannelIds,
					delChannelIds, operId, sysUser.getSupplierId(), null);

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
	public Result<Boolean> modifyChannelOwnedUser(Long channelId, List<Long> addCustomerIds, List<Long> delCustomerIds,
			Long operId) {
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
				new Result<>(CustomerExceptionCode.OPER_DATA_NULL.getCode(),
						CustomerExceptionCode.OPER_DATA_NULL.getMsg());
			}
			Result<Boolean> booleanResult = channelService.modifyChannelUserOwned(channelId, addCustomerIds,
					delCustomerIds, operId, sysUser.getSupplierId(),
					UserGlobalParam.ChannelMapKeyParam.DIRECT_CHANNEL_USER_TYPE);

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
}
