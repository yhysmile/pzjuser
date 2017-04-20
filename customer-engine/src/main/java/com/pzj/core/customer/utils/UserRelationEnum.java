package com.pzj.core.customer.utils;

public enum UserRelationEnum {
	SUPPLIER("1", "供应商"), DEPARTMENT("2", "部门"), GUIDE("3", "导游"), DISTRIBUTOR("4", "分销商"), SALESMAN_RESELLER("5",
			"销售人员绑定分销商"), SUPPLIER_DIRECT_RESELLER("6", "供应商绑定直签分销商");

	private String id;
	private String value;

	private UserRelationEnum(String id, String value) {
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

}
