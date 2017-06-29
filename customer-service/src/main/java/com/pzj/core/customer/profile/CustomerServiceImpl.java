/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.profile;

import javax.annotation.Resource;

import com.pzj.common.service.RpcCaller;
import com.pzj.core.customer.utils.QueryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.commons.utils.CheckUtils;
import com.pzj.core.customer.commons.PageBean;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.entity.QueryResult;

/**
 * 
 * @author Administrator
 * @version $Id: CustomerServiceImpl.java, v 0.1 2017年4月6日 下午3:04:10 Administrator Exp $
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Resource
	private CustomerQueryService customerQueryService;
	@Resource
	private CustomerCreateEngine customerCreateEngine;

	@Override
	public Result<QueryResult<QueryCustomerResponse>> queryMasterCustomerOfDistributor(final QueryCustomerRequest param,
																					   final PageBean page) {
		logger.info("查询分销商绑定的SaaS用户参数：{}，分页：{}", JSONConverter.toJson(param), JSONConverter.toJson(page));

		Result<QueryResult<QueryCustomerResponse>> result = new RpcCaller<QueryResult<QueryCustomerResponse>>(){

			@Override
			public QueryResult<QueryCustomerResponse> call() {
				PageBean pageBeanParam = QueryUtil.defaultPageBean(page);
				return customerQueryService.queryMasterOfCustomer(param, pageBeanParam);
			}
		}.args(param, page).run();

		logger.info("查询分销商绑定的SaaS用户结果：{}", JSONConverter.toJson(result));

		return result;
	}

	@Override
	public Result<QueryResult<QueryCustomerLessInfoResponse>> queryCustomerLessInfo(final QueryCustomerLessInfoRequest param,
																					final PageBean page) {

		Result<QueryResult<QueryCustomerLessInfoResponse>> result = new RpcCaller<QueryResult<QueryCustomerLessInfoResponse>>(){
			@Override
			public QueryResult<QueryCustomerLessInfoResponse> call() {
				return customerQueryService.queryCustomerLessInfo(param, page);
			}
		}.args(param, page).run();

		return result;
	}

	@Override
	public Result<QueryResult<QueryCustomerResponse>> queryCustomerFreeJoin(QueryCustomerRequest customerRequest,
																			PageBean pageBean,
																			Integer querType) {
		if (logger.isDebugEnabled()) {
			logger.debug("The parameters of the query customer.customer:{},operType:{}",
					JSONConverter.toJson(customerRequest), querType);
		}
		if (CheckUtils.isNull(customerRequest)) {
			logger.warn("参数不合法,参数信息为:{}", customerRequest);
			new Result<>(CustomerExceptionCode.PARAMETER_EMPTY.getCode(),
					CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
		}

		if (CheckUtils.isNull(querType)
				|| (querType != GlobalParam.QueryType.exists && querType != GlobalParam.QueryType.not_exists)) {
			logger.warn("操作类型不合法,操作类型值为:{}", querType);
			new Result<>(CustomerExceptionCode.ILLEGAL_OPERATION.getCode(),
					CustomerExceptionCode.ILLEGAL_OPERATION.getMsg());
		}
		if ((CheckUtils.isNull(customerRequest.getUserIds()) || customerRequest.getUserIds().size() == 0)
				&& querType == GlobalParam.QueryType.exists) {
			return new Result<>();
		}
		customerRequest.setQuerType(querType);
		QueryResult<QueryCustomerResponse> result = customerQueryService.queryResellerListByPage(customerRequest,
				pageBean);
		return new Result<>(result);
	}

	@Override
	public Result<Long> createSaasCustomer(final CreateSaasCustomerRequest createSaasCustomerRequest) {
		final Result<Long> result = new RpcCaller<Long>(){

			@Override
			public Long call() {
				return customerCreateEngine.createSaasCustomer(createSaasCustomerRequest).getUserId();
			}
		}.run();
		return result;
	}

}
