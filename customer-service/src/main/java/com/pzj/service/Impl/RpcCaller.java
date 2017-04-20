package com.pzj.service.Impl;

import java.io.Serializable;

import com.pzj.framework.entity.QueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.framework.context.Result;

/**
 * Created by Administrator on 2017-1-12.
 */
public abstract class RpcCaller<T extends Serializable> {
	private static Logger logger = LoggerFactory.getLogger(RpcCaller.class);

	public abstract T call();

	public static <T extends Serializable> Result<T> call(RpcCaller<T> rpcCaller) {
		Result<T> result = new Result<>();
		try {
			result.setData(rpcCaller.call());
		} catch (CustomerException e) {
			catchCustomerException(result, e);
		} catch (Throwable throwable) {
			catchThrowable(result, throwable);
		}
		return result;
	}

	public static <T extends Serializable> void catchCustomerException(Result<T> result, CustomerException e) {
		result.setErrorCode(e.getCode());
		result.setErrorMsg(e.getMessage());
		logger.error(e.getMessage(), e);
	}

	public static <T extends Serializable> void catchThrowable(Result<T> result, Throwable throwable) {
		result.setErrorCode(CustomerExceptionCode.ERROR.getCode());
		result.setErrorMsg(CustomerExceptionCode.ERROR.getMsg());
		logger.error(throwable.getMessage(), throwable);
	}

	public static <T extends Serializable> void catchThrowableAndCustomerException(Result<T> result, Throwable throwable) {
		if (throwable instanceof CustomerException){
			catchCustomerException(result, (CustomerException)throwable);
		} else {
			catchThrowable(result, throwable);
		}
	}
}
