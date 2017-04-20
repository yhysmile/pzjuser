package com.pzj.core.customer.channel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.pzj.framework.context.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysUser;
import com.pzj.commons.utils.CheckUtils;
import com.pzj.core.customer.commons.exception.CustomerException;
import com.pzj.core.customer.commons.exception.CustomerExceptionCode;
import com.pzj.core.customer.dao.SysChannelMapper;
import com.pzj.core.customer.profile.ChannelUsers;
import com.pzj.core.customer.profile.QueryCustomerRequest;
import com.pzj.core.customer.utils.ModelConvert;
import com.pzj.core.customer.utils.QueryUtil;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;
import com.pzj.framework.toolkit.Check;

/**
 * Created by Administrator on 2017-4-10.
 */
@Component
public class ChannelQueryEngine {
	private static final Logger logger = LoggerFactory.getLogger(ChannelQueryEngine.class);

	@Resource
	protected SysChannelMapper channelMapper;

	public QueryResult<QueryChannelResponse> queryChannelFreeJoin(QueryChannelRequest channelRequest,
                                                                  QueryCustomerRequest customerRequest,
                                                                  PageModel pageModel,
                                                                  Integer operType) {

        queryChannelFreeJoinCheck(channelRequest, operType);

		//模型转换
        SysUser distributorParam = ChannelModelConvert.convertToSysUser(customerRequest);

        SysChannel channelParam = ChannelModelConvert.convertToSysChannel(channelRequest);

        int count;
		List<SysChannel> channelList = null;

		if (operType == GlobalParam.QueryType.exists) {
			channelParam.setQueryIds(channelRequest.getChannelIds());
			if (CheckUtils.isNull(channelRequest.getChannelIds()) || channelRequest.getChannelIds().size() == 0) {
				return null;
			}
			count = channelMapper.countChannelContainUser(channelParam, distributorParam);
			if (count > 0) {
                channelList = channelMapper.selectChannelContainUser(channelParam, distributorParam, pageModel);
			}
		} else {
            count = channelMapper.countChannelContainNotUser(channelParam, distributorParam, channelRequest.getChannelIds());
			if (count > 0) {
                channelList = channelMapper.queryChannelsUserNotJoin(channelParam, distributorParam, pageModel, channelRequest.getChannelIds());
			}
		}

		List<QueryChannelResponse> channelResponses = ChannelModelConvert.convertToQueryChannelResponse(channelList);

        queryUserForChannel(channelResponses);

        QueryResult<QueryChannelResponse> queryResult = QueryUtil.result(pageModel, count, channelResponses);
		return queryResult;
	}

	private void queryChannelFreeJoinCheck(QueryChannelRequest channelRequest, Integer operType) {
		if (CheckUtils.isNull(channelRequest)) {
			throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
		}
		if (CheckUtils.isNull(operType) || !GlobalParam.QueryType.check(operType)) {
			logger.warn("操作类型不合法,操作类型值为:{}", operType);
			throw new CustomerException(CustomerExceptionCode.OPERATOR_NULL);
		}
	}

	private void queryUserForChannel(List<QueryChannelResponse> channelResponses) {
        if (channelResponses == null){
            return;
        }

		List<Long> queryChildIds = new ArrayList<>(channelResponses.size());
		Map<Long, QueryChannelResponse> channelsMap = new HashMap<>();
        if (channelResponses != null){
            for (QueryChannelResponse chResponse : channelResponses) {
                queryChildIds.add(chResponse.getId());
                channelsMap.put(chResponse.getId(), chResponse);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("The map of channelId-channel mappings.{}", JSONConverter.toJson(channelsMap));
        }

        if (queryChildIds.isEmpty()){
            return;
        }

        SysChannel quyerChannelUser = new SysChannel();
        quyerChannelUser.setQueryIds(queryChildIds);
        List<ChannelUsers> channelUsers = channelMapper.queryChannelUsers(quyerChannelUser);
        for (ChannelUsers cu : channelUsers) {
            QueryChannelResponse channelResponse = channelsMap.get(cu.getChannelId());
            if (CheckUtils.isNotNull(channelResponse)) {
                setUserInfo(channelResponse, cu);
            }
        }
    }

	private void setUserInfo(QueryChannelResponse channelResponse, ChannelUsers cu) {
		channelResponse.setUserNames(CheckUtils.isNotNull(cu.getUserNames()) ? cu.getUserNames() : "");
		if (CheckUtils.isNotNull(cu.getUserIds())) {
			List<Long> userIds = new ArrayList<Long>();
			for (String userId : Arrays.asList(cu.getUserIds().split(","))) {
				userIds.add(CheckUtils.isNotNull(userId) ? Long.valueOf(userId) : null);
			}
			channelResponse.setUserIds(userIds);
		}
	}

    private void queryChannelsUserNotJoinCheck(QueryChannelRequest channelRequest, QueryCustomerRequest customerRequest){
        if (channelRequest == null){
            CustomerExceptionCode code = CustomerExceptionCode.PARAMETER_EMPTY;
            throw new CustomerException(code.getCode(), "渠道参数不能为空。");
        }
        if (channelRequest.getSupplierId() == null || channelRequest.getSupplierId() < 0){
            throw new CustomerException(CustomerExceptionCode.CHANNEL_NULL_SUPPLIER);
        }
    }


    public QueryResult<QueryChannelResponse> queryChannelsUserNotJoin(QueryChannelRequest channelRequest,
                                                                      QueryCustomerRequest customerRequest,
                                                                      PageModel pageModel,
                                                                      List<Long> tmpAddIds,
                                                                      List<Long> tmpDelIds) {
        queryChannelsUserNotJoinCheck(channelRequest, customerRequest);

        QueryCustomerRequest customerParam = new QueryCustomerRequest();
        customerParam.setId(customerRequest.getId());

        // TODO 这里是查询用户已加入的渠道的id，不需要使用queryChannelsUserJoin这么复杂的查询，直接单表查sys_label_relation表就够了。
        QueryResult<QueryChannelResponse> queryChannelsUserJoinResult = queryChannelsUserJoin(channelRequest, customerRequest, pageModel, tmpDelIds, tmpAddIds);


        List<Long> channelIds = new ArrayList<>();
        if (queryChannelsUserJoinResult != null){
            List<QueryChannelResponse> records = queryChannelsUserJoinResult.getRecords();
            if (records != null && !records.isEmpty()){
                for (QueryChannelResponse channel : records) {
                    channelIds.add(channel.getId());
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("用户已关联的渠道ids:{}", JSONConverter.toJson(channelIds));
        }

        //模型转换
        SysUser distributorParam = ChannelModelConvert.convertToSysUser(customerRequest);
        SysChannel channelParam = ChannelModelConvert.convertToSysChannel(channelRequest);
        channelParam.setDelFlag("1");

        //查询满足渠道条件的所有渠道，并且not in 已经关联的
        int count = 0;
        List<SysChannel> channelList = channelMapper.queryChannelsUserNotJoin(channelParam, null, null, channelIds);

        if (Check.NuNObject(channelList) || channelList.size() == 0) {
            //用户未关联的渠道id集合，满足渠道查询条件的
            List<Long> notJoinIds = new ArrayList<>();
            for (SysChannel sysCh : channelList) {
                notJoinIds.add(sysCh.getId());
            }

            //查询满足用户查询条件的的渠道，查询所有的，所以用户id为null，且去除已关联的，取第一步的交集
            SysChannel paramCh = new SysChannel();
            paramCh.setQueryIds(notJoinIds);
            distributorParam.setId(null);


            count = channelMapper.countChannelContainNotUser(paramCh, distributorParam, channelIds);
            if (count > 0) {
                channelList = channelMapper.queryChannelsUserNotJoin(paramCh, distributorParam, pageModel, channelIds);
            }
        }

        List<QueryChannelResponse> queryChannelResponses = ChannelModelConvert.convertToQueryChannelResponse(channelList);

        QueryResult<QueryChannelResponse> queryResult = QueryUtil.result(pageModel, count, queryChannelResponses);

        return queryResult;
    }


    public QueryResult<QueryChannelResponse> queryChannelsUserJoin(QueryChannelRequest channelRequest,
                                                                   QueryCustomerRequest customerRequest,
                                                                   PageModel pageModel,
                                                                   List<Long> tmpDelIds,
                                                                   List<Long> tmpAddIds) {
        queryChannelsUserNotJoinCheck(channelRequest, customerRequest);

        //如果参数为null，那么设为空对象，保证下面模型转换不报错
        if (Check.NuNObject(customerRequest)) {
            customerRequest = new QueryCustomerRequest();
        }

        int count = 0;
        List<SysChannel> channelList = null;

        //模型转换
        final SysUser distributorParam = ChannelModelConvert.convertToSysUser(customerRequest);
        final SysChannel channelParam = ChannelModelConvert.convertToSysChannel(channelRequest);
        channelParam.setDelFlag("1");

        // 此处分2步处理：
        // 第一步 根据渠道参数和用户id查询用户所有的渠道
        List<Long> channelIds = channelIdsOfExisting(channelParam, distributorParam);
        // 第二步，根据用户参数 包含联系人，包含公司名称，包含用户手机，查询渠道信息，取第一步的交集，在结果集中操作临时生效的
        addAndDelChannelIds(tmpDelIds, tmpAddIds, channelIds);

        logChannelIdsOfExisting(distributorParam, channelIds);

        if (channelIds != null && !channelIds.isEmpty()) {
            channelParam.setQueryIds(channelIds);
            if (distributorParam != null){
                distributorParam.setId(null);
            }
            count = channelMapper.countChannelContainUser(channelParam, distributorParam);
            if (count > 0) {
                channelList = channelMapper.selectChannelContainUser(channelParam, distributorParam, pageModel);
            }
        }

        List<QueryChannelResponse> queryChannelResponses = ChannelModelConvert.convertToQueryChannelResponse(channelList);

        QueryResult<QueryChannelResponse> queryResult = QueryUtil.result(pageModel, count, queryChannelResponses);

        return queryResult;
    }

    private List<Long> channelIdsOfExisting(SysChannel channelParam, SysUser distributorParam) {
        List<Long> channelIds = queryChannelIdsOfExisting(channelParam, distributorParam);
        if (channelIds == null){
            channelIds = new ArrayList<>();
        }
        return channelIds;
    }

    private List<Long> queryChannelIdsOfExisting(SysChannel channelParam, SysUser distributorParam) {
        SysUser paramUser = null;
        if (distributorParam != null){
            paramUser = new SysUser();
            paramUser.setId(distributorParam.getId());
        }

		List<SysChannel> channelList = channelMapper.selectChannelContainUser(channelParam, paramUser, null);

		if (channelList == null || channelList.isEmpty()) {
			return null;
		}

		// 用户已关联的渠道id集合
		List<Long> channelIds = new ArrayList<>();
		for (SysChannel sysCh : channelList) {
			channelIds.add(sysCh.getId());
		}
		return channelIds;
	}

	private void addAndDelChannelIds(List<Long> tmpDelIds, List<Long> tmpAddIds, List<Long> channelIds) {
		if (!Check.NuNObject(tmpAddIds)) {
			channelIds.addAll(tmpAddIds);
		}
		if (!Check.NuNObject(tmpDelIds)) {
			channelIds.removeAll(tmpDelIds);
		}
	}

    private void logChannelIdsOfExisting(SysUser distributorParam, List<Long> channelIds) {
        if (logger.isDebugEnabled()) {
            Long id = null;

            if (distributorParam != null){
                id = distributorParam.getId();
            }

            logger.debug("用户：{}，已关联的渠道id集合：{}", id, JSONConverter.toJson(channelIds));
        }
    }

}
