/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.service.Impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.commons.utils.CheckUtils;
import com.pzj.core.customer.commons.PageBean;
import com.pzj.core.customer.commons.exception.CustomerExceptionCode;
import com.pzj.core.customer.profile.CustomerQueryService;
import com.pzj.core.customer.profile.CustomerService;
import com.pzj.core.customer.profile.QueryCustomerLessInfoRequest;
import com.pzj.core.customer.profile.QueryCustomerLessInfoResponse;
import com.pzj.core.customer.profile.QueryCustomerRequest;
import com.pzj.core.customer.profile.QueryCustomerResponse;
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

	@Override
	public Result<QueryResult<QueryCustomerResponse>> queryMasterCustomerOfDistributor(QueryCustomerRequest param,
			PageBean page) {
		Result<QueryResult<QueryCustomerResponse>> result = new Result<QueryResult<QueryCustomerResponse>>();
		if (param == null || param.getId() == null) {
			result.setErrorCode(CustomerExceptionCode.PARAMETER_EMPTY.getCode());
			result.setErrorMsg(CustomerExceptionCode.PARAMETER_EMPTY.getMsg());
			logger.error("query master rel reseller by page param error! request:{}", JSONConverter.toJson(param));
			return result;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("query master rel reseller by page,request param:{}", JSONConverter.toJson(param));
		}
		//调用引擎查询分页结果
		result.setData(customerQueryService.queryMasterOfCustomer(param, page));

		if (logger.isDebugEnabled()) {
			logger.debug("query master rel reseller by page,result:{}", JSONConverter.toJson(param));
		}
		return result;
	}

	@Override
	public Result<QueryResult<QueryCustomerLessInfoResponse>> queryCustomerLessInfo(
			final QueryCustomerLessInfoRequest param, final PageBean page) {
		Result<QueryResult<QueryCustomerLessInfoResponse>> result = RpcCaller
				.call(new RpcCaller<QueryResult<QueryCustomerLessInfoResponse>>() {

					@Override
					public QueryResult<QueryCustomerLessInfoResponse> call() {
						return customerQueryService.queryCustomerLessInfo(param, page);
					}
				});

		return result;
	}

	@Override
	public Result<QueryResult<QueryCustomerResponse>> queryCustomerFreeJoin(QueryCustomerRequest customerRequest,
			PageBean pageBean, Integer querType) {
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
			return new Result<QueryResult<QueryCustomerResponse>>();
		}
		customerRequest.setQuerType(querType);
		QueryResult<QueryCustomerResponse> result = customerQueryService.queryResellerListByPage(customerRequest,
				pageBean);
		return new Result<QueryResult<QueryCustomerResponse>>(result);
	}

}
