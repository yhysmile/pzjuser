package com.pzj.core.customer.channel;

import java.util.List;

/**
 * Created by Administrator on 2017-4-14.
 */
public class ChannelDistributorQuery extends ChannelDistributorEntity {

    private List<Long> channelIds;

    private List<Long> distributorIds;

    public List<Long> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<Long> channelIds) {
        this.channelIds = channelIds;
    }

    public List<Long> getDistributorIds() {
        return distributorIds;
    }

    public void setDistributorIds(List<Long> distributorIds) {
        this.distributorIds = distributorIds;
    }
}
