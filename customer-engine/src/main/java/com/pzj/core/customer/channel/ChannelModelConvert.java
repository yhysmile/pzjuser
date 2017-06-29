package com.pzj.core.customer.channel;

import java.util.ArrayList;
import java.util.List;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.core.customer.profile.QueryCustomerRequest;
import com.pzj.core.customer.utils.ModelConvert;
import com.pzj.framework.context.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysUser;
import com.pzj.core.customer.profile.CreateCustomerRequest;
import com.pzj.core.customer.profile.QueryCustomerResponse;
import com.pzj.framework.toolkit.Check;

/**
 * Created by Administrator on 2017-2-16.
 * 模型转换
 */
public class ChannelModelConvert {
    public static SysUser convertToSysUser(QueryCustomerRequest customerRequest) {
        if (customerRequest == null){
            return null;
        }

        boolean hasData = false;
        SysUser user = new SysUser();

        if (customerRequest.getCorporaterMobile() != null){
            user.setCorporaterMobile(customerRequest.getCorporaterMobile());
            hasData = true;
        }

        if (customerRequest.getCorporater() != null){
            user.setCorporater(customerRequest.getCorporater());
            hasData = true;
        }

        if (customerRequest.getName() != null){
            user.setName(customerRequest.getName());
            hasData = true;
        }

        if (customerRequest.getId() != null){
            user.setId(customerRequest.getId());
            hasData = true;
        }

        if (customerRequest.getNameOrNormal() != null){
            user.setNameOrNormal(customerRequest.getNameOrNormal());
            hasData = true;
        }

        if (hasData){
            return user;
        }

        return null;
    }

    public static SysChannel convertToSysChannel(QueryChannelRequest channelRequest) {
        if (channelRequest == null){
            return null;
        }
        return new SysChannel(channelRequest.getSupplierId(), channelRequest.getId(), channelRequest.getName(),
                channelRequest.getCreateDate(), channelRequest.getCreateEndDate(), GlobalParam.FLAG.start());
    }

    public static QueryChannelResponse convertToQueryChannelResponse(SysChannel channel) {
        if (channel == null) {
            return new QueryChannelResponse();
        }
        QueryChannelResponse channelResponse = new QueryChannelResponse(channel.getId(), channel.getName(),
                channel.getCreateDate());
        return channelResponse;
    }

    public static List<QueryChannelResponse> convertToQueryChannelResponse(List<SysChannel> channels){
        if (channels == null || channels.isEmpty()){
            return null;
        }

        List<QueryChannelResponse> queryChannelResponses = new ArrayList<>(channels.size());

        for (SysChannel channel : channels){
            QueryChannelResponse queryChannelResponse = convertToQueryChannelResponse(channel);
            queryChannelResponses.add(queryChannelResponse);
        }

        return queryChannelResponses;
    }

    public static List<ChannelInfo> convertToChannelInfos(List<SysChannel> channels){
        List<ChannelInfo> channelInfos = new ArrayList<>();
        for (SysChannel sysChannel : channels){
            ChannelInfo channelInfo = new ChannelInfo();
            channelInfo.setChannelId(sysChannel.getId());
            channelInfo.setSupplierId(sysChannel.getSupplierId());
            channelInfos.add(channelInfo);
        }
        return channelInfos;
    }

}
