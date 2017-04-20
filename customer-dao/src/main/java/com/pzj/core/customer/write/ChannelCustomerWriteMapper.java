package com.pzj.core.customer.write;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.core.customer.channel.ChannelCustomerEntity;

import java.util.List;

/**
 * Created by Administrator on 2017-4-14.
 */
@MyBatisDao
public interface ChannelCustomerWriteMapper {
    List<ChannelCustomerEntity> selectByChannelId(Long channelId);

    List<ChannelCustomerEntity> selectByCustomerId(Long customerId);

    List<ChannelCustomerEntity> selectByChannelIds(List<Long> channelIds);

    List<ChannelCustomerEntity> selectByCustomerIds(List<Long> customerIds);

    List<ChannelCustomerEntity> selectByChannelIdAndCustomerId(List<ChannelCustomerEntity> params);
}
