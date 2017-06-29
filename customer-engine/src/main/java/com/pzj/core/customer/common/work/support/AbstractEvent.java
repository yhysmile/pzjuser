package com.pzj.core.customer.common.work.support;

import com.pzj.core.customer.common.work.Event;

/**
 * Created by Administrator on 2017-6-12.
 */
public class AbstractEvent implements Event {
    private String requestId;
    @Override
    public String getRequestId() {
        return requestId;
    }

    @Override
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
