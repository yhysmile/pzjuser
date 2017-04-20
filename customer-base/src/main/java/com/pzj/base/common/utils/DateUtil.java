package com.pzj.base.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 日期Util类
 * 
 * @author zhangdianliang
 */
public class DateUtil {

	private static String defaultDatePattern = "yyyy-MM-dd";

	/**
	 * 获得默认模式 date pattern
	 */
	public static String getDatePattern() {
		return defaultDatePattern;
	}

	/**
	 * 返回预设Format的当前日期字符串
	 */
	public static String getToday() {
		Date today = new Date();
		return format(today);
	}

	/**
	 * 使用预设Format格式化Date成字符串
	 */
	public static String format(Date date) {
		return date == null ? "" : format(date, getDatePattern());
	}

	/**
	 * 使用参数Format格式化Date成字符串
	 */
	public static String format(Date date, String pattern) {
		return date == null ? "" : new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 得到当前�?
	 * 
	 * @return
	 */
	public static String getCurYear() {
		String defaultDatePattern = "yyyy";
		Date today = new Date();
		return format(today, defaultDatePattern);
	}

	/**
	 * 得到指定时间的年
	 * 
	 * @param date
	 * @return
	 */
	public static String getYear(Date date) {
		String defaultDatePattern = "yyyy";
		return format(date, defaultDatePattern);
	}

	/**
	 * 得到指定时间的月
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonth(Date date) {
		String defaultDatePattern = "MM";
		return format(date, defaultDatePattern);
	}

	/**
	 * 得到指定时间的日
	 * 
	 * @param date
	 * @return
	 */
	public static String getDay(Date date) {
		String defaultDatePattern = "dd";
		return format(date, defaultDatePattern);
	}

	/**
	 * 使用预设格式将字符串转为Date
	 */
	public static Date parse(String strDate) throws ParseException {
		return StringUtils.isEmpty(strDate) ? null : parse(strDate,
				getDatePattern());
	}

	/**
	 * 使用参数Format将字符串转为Date
	 */
	public static Date parse(String strDate, String pattern)
			throws ParseException {
		return StringUtils.isEmpty(strDate) ? null : new SimpleDateFormat(
				pattern).parse(strDate);
	}

	/**
	 * 在日期上增加数个整月
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加数个天数
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, n);
		return cal.getTime();
	}
}