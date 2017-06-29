package com.pzj.core.customer.write;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.core.customer.channel.ChannelEntity;
import com.pzj.core.customer.channel.ChannelQuery;

import java.util.List;

/**
 * Created by Administrator on 2017-4-14.
 */
@MyBatisDao
public interface ChannelWriteMapper {

    ChannelEntity selectById(Long id);

    List<ChannelEntity> selectByIds(List<Long> ids);

    List<ChannelEntity> selectByParam(ChannelQuery channelQuery);
}
