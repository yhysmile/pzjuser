package com.pzj.customer.service;

import com.pzj.base.common.ServiceException;
import com.pzj.customer.entity.Customer;
import com.pzj.customer.entity.CustomerAgent;

import java.util.List;

/**
 * <h3>
 *     用户与代理人关系服务
 * </h3>
 * Created by Administrator on 2016-3-30.
 */
public interface CustomerAgentService {

    /**
     * @api {interface} com.pzj.customer.service.CustomerAgentService#saveCustomerAgent saveCustomerAgent 接口
     * @apiGroup Customer Agent Service
     * @apiVersion 2.0.0
     * @apiDescription
     * <h3>
     * 保存用户与代理人的关系
     * </h3>
     * <p>
     *     CustomerAgent的userId和agentId不能为null。
     * </p>
     * @apiParam {CustomerAgent} customerAgent 用户代理关系
     * @param customerAgent
     * @throws ServiceException
     */
    void saveCustomerAgent(CustomerAgent customerAgent) throws ServiceException;

    /**
     * @api {interface} com.pzj.customer.service.CustomerAgentService#deleteCustomerAgent deleteCustomerAgent 接口
     * @apiGroup Customer Agent Service
     * @apiVersion 2.0.0
     * @apiDescription
     * <h3>
     *     删除用户与代理人关系
     * </h3>
     * <p>
     *     通过设置CustomerAgent中的userId或agentId，删除某个用户与所有代理的多个关系、某个代理人与所有用户的多个关系、某个用户与某个代理人的单个关系。
     * </p>
     * @apiParam {CustomerAgent} customerAgent 用户代理关系
     * @param customerAgent
     * @throws ServiceException
     */
    void deleteCustomerAgent(CustomerAgent customerAgent) throws ServiceException;

    /**
     * @api {interface} com.pzj.customer.service.CustomerAgentService#findAgentByUserId findAgentByUserId 接口
     * @apiGroup Customer Agent Service
     * @apiVersion 2.0.0
     * @apiDescription
     * <h3>
     *     根据用户ID查询关联的代理商信息
     * </h3>
     * <p>
     *     通过用户id，查询其有关的代理商信息。
     * </p>
     * @apiParam {Long} userId 用户id
     * @apiSuccess (result) {ListCustomer} result 代理商信息
     *
     */
    List<Customer> findAgentByUserId(Long userId);
}
