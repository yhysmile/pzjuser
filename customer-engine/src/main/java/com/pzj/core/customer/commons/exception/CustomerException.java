package com.pzj.core.customer.commons.exception;

import com.pzj.framework.exception.ServiceException;

/**
 * Created by Administrator on 2017-2-16.
 */
public class CustomerException extends ServiceException {

	private final int code;

	public CustomerException() {
		super(CustomerExceptionCode.ERROR.getMsg());
		this.code = CustomerExceptionCode.ERROR.getCode();
	}

	public CustomerException(CustomerExceptionCode customerExceptionCode) {
		super(customerExceptionCode.getMsg());
		this.code = customerExceptionCode.getCode();
	}

	public CustomerException(CustomerExceptionCode customerExceptionCode, String message) {
		super(message);
		this.code = customerExceptionCode.getCode();
	}

	public CustomerException(int code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * @param cause
	 */
	public CustomerException(Throwable cause) {
		super(cause.getMessage(), cause);
		this.code = CustomerExceptionCode.ERROR.getCode();
	}

	public Integer getCode() {
		return code;
	}
}
