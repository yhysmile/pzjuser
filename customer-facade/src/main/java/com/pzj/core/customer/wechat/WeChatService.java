package com.pzj.core.customer.wechat;

/**
 * Created by Administrator on 2017-6-8.
 */
public interface WeChatService {
    /**
     * 解绑微信
     *
     * @param token
     * @return
     */
    boolean unbindCustomerWechatByToken(String token);
}
