package com.pzj.core.customer.utils;

public enum UserRelationStatusEnum {
	AVAILABLE(1, "可用"), DISABLED(0, "不可用");

	private int status;
	private String desc;

	private UserRelationStatusEnum(int status, String desc) {
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
