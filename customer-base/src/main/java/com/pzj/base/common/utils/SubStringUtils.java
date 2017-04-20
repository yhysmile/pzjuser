package com.pzj.base.common.utils;

public class SubStringUtils {

	/**
	 * 将字符串首字母转换成大写
	 * 
	 */
	public static String captureName(String name) {
		char[] cs = name.toCharArray();
		if (Character.isLowerCase(name.charAt(0)))
			cs[0] -= 32;
		return String.valueOf(cs);
	}
}
