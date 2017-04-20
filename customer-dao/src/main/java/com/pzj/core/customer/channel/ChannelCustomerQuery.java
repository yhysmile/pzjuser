package com.pzj.core.customer.channel;

import java.util.List;

/**
 * Created by Administrator on 2017-4-14.
 */
public class ChannelCustomerQuery extends ChannelCustomerEntity {

    private List<Long> channelIds;

    private List<Long> customerIds;

    public List<Long> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<Long> channelIds) {
        this.channelIds = channelIds;
    }

    public List<Long> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<Long> customerIds) {
        this.customerIds = customerIds;
    }
}
