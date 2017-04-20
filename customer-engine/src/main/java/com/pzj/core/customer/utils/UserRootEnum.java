package com.pzj.core.customer.utils;

public enum UserRootEnum {
	/** 是否是主帐号（1：主帐号，0：子账号）  */
	ROOT_USER("1", "主账号"), CHILD_USER("0", "子账号");

	private String key;
	private String desc;

	private UserRootEnum(String key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	public static Boolean checkIsRoot(String key) {
		if (key == null) {
			return Boolean.FALSE;
		}
		if (ROOT_USER.getKey().equals(key.trim())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public String getKey() {
		return key;
	}

	public String getDesc() {
		return desc;
	}

}
