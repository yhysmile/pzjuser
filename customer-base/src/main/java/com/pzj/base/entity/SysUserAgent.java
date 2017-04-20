package com.pzj.base.entity;

import com.pzj.base.common.BaseEntity;

/**
 * 用户与代理代关系
 */
public class SysUserAgent extends BaseEntity {

    private static final long serialVersionUID = -5796932847232091748L;
    private Long              id;
    private Long              userId;
    private Long              agentId;

    public SysUserAgent() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
