package com.pzj.common.service;

import java.io.Serializable;

import com.pzj.framework.converter.JSONConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.framework.context.Result;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by Administrator on 2017-1-12.
 */
public abstract class RpcCaller<T extends Serializable> {
	private static Logger logger = LoggerFactory.getLogger(RpcCaller.class);

	public abstract T call();

	private Object[] args = null;

	public final RpcCaller<T> args(Object ... args){
		this.args = args;
		return this;
	}

	public final Result<T> run() {
		return call(this);
	}

	public final Result<T> runWithTransaction(PlatformTransactionManager platformTransactionManager) {
		return runWithTransaction(platformTransactionManager, TransactionDefinition.PROPAGATION_REQUIRED);
	}

	public final Result<T> runWithTransaction(PlatformTransactionManager platformTransactionManager, int transactionDefinition) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(transactionDefinition);

		TransactionStatus transaction = platformTransactionManager.getTransaction(def);

		Result<T> result = call(this);

		if (result.isOk()){
			platformTransactionManager.commit(transaction);
		} else {
			platformTransactionManager.rollback(transaction);
		}

		return result;
	}

	public static <T extends Serializable> Result<T> call(RpcCaller<T> rpcCaller) {
		Result<T> result = new Result<>();
		try {
			result.setData(rpcCaller.call());
		} catch (CustomerException e) {
			catchCustomerException(result, e);
			if (rpcCaller.args != null){
				logger.error(e.getMessage() + " 入参：{}" , JSONConverter.toJson(rpcCaller.args));
			}
			logger.error(e.getMessage(), e);
		} catch (Throwable t) {
			catchThrowable(result);
			if (rpcCaller.args != null){
				logger.error(t.getMessage() + " 入参：{}" , JSONConverter.toJson(rpcCaller.args));
			}
			logger.error(t.getMessage(), t);
		}
		return result;
	}

	public static <T extends Serializable> void catchCustomerException(Result<T> result, CustomerException e) {
		result.setErrorCode(e.getCode());
		result.setErrorMsg(e.getMessage());
	}

	public static <T extends Serializable> void catchThrowable(Result<T> result) {
		result.setErrorCode(CustomerExceptionCode.ERROR.getCode());
		result.setErrorMsg(CustomerExceptionCode.ERROR.getMsg());
	}

	public static <T extends Serializable> void catchThrowableAndCustomerException(Result<T> result, Throwable throwable) {
		if (throwable instanceof CustomerException){
			catchCustomerException(result, (CustomerException)throwable);
		} else {
			catchThrowable(result);
		}
	}
}
