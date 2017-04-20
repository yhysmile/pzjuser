package com.pzj.customer.entity;

import com.pzj.util.CommonEntity;

import java.io.Serializable;

/**
 * 用户与代理商关系
 * Created by Administrator on 2016-3-30.
 */
public class CustomerAgent extends CommonEntity implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 代理商ID
     */
    private Long agentId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }
}
