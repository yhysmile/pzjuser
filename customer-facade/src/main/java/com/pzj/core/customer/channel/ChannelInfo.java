package com.pzj.core.customer.channel;

import java.io.Serializable;

/**
 * Created by mf-pc on 2017/6/20.
 */
public class ChannelInfo implements Serializable {
    //渠道id
    private Long channelId;
    //渠道所属供应商id
    private Long supplierId;

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
