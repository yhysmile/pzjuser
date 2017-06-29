package com.pzj.core.customer.read;

import com.pzj.core.customer.channel.ChannelDistributorEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-4-14.
 */
public interface ChannelDistributorReadMapper {
    List<ChannelDistributorEntity> selectByChannelId(Long channelId);

    List<ChannelDistributorEntity> selectByChannelIds(List<Long> channelIds);

    List<ChannelDistributorEntity> selectByDiDistributorIds(List<Long> distributorIds);
}
