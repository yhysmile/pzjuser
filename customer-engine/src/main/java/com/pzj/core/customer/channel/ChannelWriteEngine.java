package com.pzj.core.customer.channel;

import com.pzj.core.customer.dao.SysChannelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017-4-10.
 */
@Component
public class ChannelWriteEngine {
    private static final Logger logger = LoggerFactory.getLogger(ChannelWriteEngine.class);

    @Resource
    protected SysChannelMapper channelMapper;

}
