package com.pzj.core.customer.channel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017-4-1.
 */
public class QueryChannelFreeRequest implements Serializable{
    /**
     * 查询包含的id
     */
    private List<Long> includeIds;

    /**
     * 查询排除的id
     */
    private List<Long> excludeIds;

    public List<Long> getIncludeIds() {
        return includeIds;
    }

    public void setIncludeIds(List<Long> includeIds) {
        this.includeIds = includeIds;
    }

    public List<Long> getExcludeIds() {
        return excludeIds;
    }

    public void setExcludeIds(List<Long> excludeIds) {
        this.excludeIds = excludeIds;
    }
}
