package com.pzj.core.customer.channel;

import com.pzj.core.customer.write.ChannelWriteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-4-10.
 */
@Component
public class ChannelWriteEngine {
    private static final Logger logger = LoggerFactory.getLogger(ChannelWriteEngine.class);

    @Resource
    protected ChannelWriteMapper channelWriteMapper;

    /**
     * 根据主账号id，查询其创建的所有渠道，且渠道状态是可用的。
     * @param masterId 主账号id
     * @return
     */
    public List<ChannelEntity> queryActivateChannelByMasterId(Long masterId){
        ChannelQuery channelQuery = new ChannelQuery();
        channelQuery.setStatus("1");
        channelQuery.setMasterId(masterId);

        List<ChannelEntity> channelEntities = channelWriteMapper.selectByParam(channelQuery);

        return channelEntities;
    }
}
