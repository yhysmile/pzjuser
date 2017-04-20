package com.pzj.core.customer.utils;

public enum UserCheckStatusEnum {

	REGIST_NOT_COMPLETE("0", "注册未完成"), AUDIT_PASS("1", "审核通过"), RE_AUDIT("2", "审核拒绝，重新提交"), WAITING_AUDIT("3",
			"注册完成待审核");

	private String checkStatus;
	private String desc;

	private UserCheckStatusEnum(String checkStatus, String desc) {
		this.checkStatus = checkStatus;
		this.desc = desc;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public String getDesc() {
		return desc;
	}

}
