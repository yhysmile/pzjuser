package com.pzj.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.SysUserAgent;
import com.pzj.base.service.sys.ISysUserAgentService;
import com.pzj.customer.entity.Customer;
import com.pzj.customer.entity.CustomerAgent;
import com.pzj.customer.entity.CustomerAgentBuilder;
import com.pzj.customer.entity.CustomerBuilder;

/**
 * Created by Administrator on 2016-3-30.
 */
@Service
public class CustomerAgentServiceImpl implements CustomerAgentService {
    @Autowired
    private ISysUserAgentService userAgentService;

    @Override
    public void saveCustomerAgent(CustomerAgent customerAgent) throws ServiceException {
        if (customerAgent == null)
            return;

        List<SysUserAgent> userAgentList = createNewUserAgentsList(customerAgent);

        userAgentService.saveUserAgent(userAgentList);
    }

    @Override
    public void deleteCustomerAgent(CustomerAgent customerAgent) throws ServiceException {
        if (customerAgent == null)
            return;

        List<SysUserAgent> userAgentList = createNewUserAgentsList(customerAgent);

        userAgentService.deleteBatchSelective(userAgentList);
    }

    /**
     * 将一个CustomerAgent包装成集合。
     * @param customerAgent
     * @return
     * @throws ServiceException
     */
    private List<SysUserAgent> createNewUserAgentsList(CustomerAgent customerAgent) throws ServiceException {
        SysUserAgent userAgent = CustomerAgentBuilder.ACustomerAgentBuilder.buildNew(customerAgent);

        List<SysUserAgent> userAgentList = new ArrayList<>(1);
        userAgentList.add(userAgent);
        return userAgentList;
    }

    @Override
    public List<Customer> findAgentByUserId(Long userId){
        if (userId == null)
            return null;

        SysUserAgent usag = new SysUserAgent();
        usag.setUserId(userId);

        List<SysUser> sysUserList = userAgentService.findAgentByParams(usag, null);
        if(sysUserList == null || sysUserList.isEmpty()){
        	return null;
        }

        List<Customer> customer = CustomerBuilder.ACustomerBuilder.buildSource(sysUserList);
        return customer;
    }
}
