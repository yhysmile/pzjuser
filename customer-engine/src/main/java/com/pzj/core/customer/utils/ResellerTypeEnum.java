package com.pzj.core.customer.utils;

public enum ResellerTypeEnum {
	RESELLER(2, "分销商-旅行社"), TRAVELDEPT(3, "分销商-旅行社部门 "), GUIDE(4, "分销商-导游 "), BUSSINESS(5, "分销商-商户"), OTA(8, "分销商-OTA");
	private Integer id;
	private String value;

	private ResellerTypeEnum(Integer id, String value) {
		this.id = id;
		this.value = value;
	}

	public static ResellerTypeEnum getResellerTypeEnumById(Integer id) {
		if (id == null) {
			return null;
		}
		ResellerTypeEnum[] resellerTypes = ResellerTypeEnum.values();
		for (ResellerTypeEnum resellerType : resellerTypes) {
			if (resellerType.getId().intValue() == id.intValue()) {
				return resellerType;
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
