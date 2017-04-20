package com.pzj.customer.entity;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysUserAgent;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;

import static com.pzj.util.ServiceUtil.checkNull;

/**
 * Created by Administrator on 2016-3-30.
 */
public class CustomerAgentBuilder extends CommonBuiler<SysUserAgent, CustomerAgent> {
    public final static CustomerAgentBuilder ACustomerAgentBuilder = new CustomerAgentBuilder();

    @Override
    public CustomerAgent convertFrom(SysUserAgent entity) {
        CustomerAgent customerAgent = new CustomerAgent();
        customerAgent.setId(entity.getId());
        customerAgent.setUserId(entity.getUserId());
        customerAgent.setAgentId(entity.getAgentId());
        return customerAgent;
    }

    @Override
    public SysUserAgent convertTo(CustomerAgent entity) {
        SysUserAgent userAgent = new SysUserAgent();
        userAgent.setId(entity.getId());
        userAgent.setUserId(entity.getUserId());
        userAgent.setAgentId(entity.getAgentId());
        return userAgent;
    }

    @Override
    protected void validtionValueWhenCreate(CustomerAgent entity, CommonCheck check) throws ServiceException {
        checkNull(entity, "CustomerAgent不能为null");
        checkNull(entity.getUserId(), "CustomerAgent.UserId不能为null");
        checkNull(entity.getAgentId(), "CustomerAgent.AgentId不能为null");
    }

    @Override
    protected void customValueWhenCreate(CustomerAgent entity) {
    }

    @Override
    protected void customValueWhenModify(CustomerAgent entity) {

    }
}
