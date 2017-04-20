package com.pzj.core.customer.utils;

public enum UserStatusEnum {

	AVAILABLE(1, "正常"), DISABLE(0, "禁用"), DELETE(2, "删除");

	private int status;
	private String desc;

	private UserStatusEnum(int status, String desc) {
		this.status = status;
		this.desc = desc;
	}

	public int getStatus() {
		return status;
	}

	public String getDesc() {
		return desc;
	}

}
