package com.pzj.core.customer.wechat;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-6-8.
 */
@Service("weChatService")
public class WeChatServiceImpl implements WeChatService {
    @Override
    public boolean unbindCustomerWechatByToken(String token) {
        return false;
    }
}
