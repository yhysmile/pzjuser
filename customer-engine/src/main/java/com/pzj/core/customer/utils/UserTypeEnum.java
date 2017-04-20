package com.pzj.core.customer.utils;

public enum UserTypeEnum {
	COMMON(1, "普通用户"), RESELLER(6, "分销商"), OTA(8, "OTA "), PZJ(9, "票之家"), MF(10, "魔方用户"), AGENT(11, "代理商"), SALESMAN(
			12, "销售人员");
	private Integer id;
	private String value;

	private UserTypeEnum(Integer id, String value) {
		this.id = id;
		this.value = value;
	}

	public static UserTypeEnum getUserTypeEnumById(Integer id) {
		if (id == null) {
			return null;
		}
		UserTypeEnum[] userTypes = UserTypeEnum.values();
		for (UserTypeEnum userType : userTypes) {
			if (userType.getId().intValue() == id.intValue()) {
				return userType;
			}
		}
		return null;
	}

	public Integer getId() {
		return id;
	}

	public String getValue() {
		return value;
	}
}
