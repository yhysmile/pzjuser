package com.pzj.core.customer.commons;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017-2-17.
 */
public class ListResult<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int allTotal;

	/**
	 * 成功标识.
	 */
	private static final int OK = 10000;

	private int errorCode;

	private String errorMsg;

	private List<T> data;

	public ListResult() {
		this(OK, "ok");
	}

	public ListResult(List<T> data) {
		this();
		this.data = data;
	}

	public ListResult(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * 服务调用成功. 当为true时, 代表成功; 当为false时, 代表失败.
	 * @return
	 */
	public boolean isOk() {
		return errorCode == OK;
	}

	public ListResult<T> setErrorCode(final int errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public ListResult<T> setErrorMsg(final String errorMsg) {
		this.errorMsg = errorMsg;
		return this;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(final List<T> data) {
		this.data = data;
	}

	public int getAllTotal() {
		return allTotal;
	}

	public void setAllTotal(int allTotal) {
		this.allTotal = allTotal;
	}
}
