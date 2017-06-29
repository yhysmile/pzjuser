package com.pzj.core.customer.common.matches;

/**
 * Created by Administrator on 2016-12-29.
 */
public class CommonMatches {
	private static final String phoneNumExp = "^1[3|4|5|7|8][0-9]\\d{8}$";

	public static boolean checkPhone(String phoneNum) {
		return phoneNum != null && phoneNum.matches(phoneNumExp);
	}
}
