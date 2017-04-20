package com.pzj.util;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.common.ServiceException;
import com.pzj.base.common.global.GlobalParam.ExceptionCode;

public class ServiceUtil {
	public static void checkNull(Object exp, String LengthDesc) throws ServiceException {
		if (null == exp) {
			throwServiceException(ExceptionCode.IsNull, LengthDesc);
		}
	}
	
	public static void checkEmpty(String exp, String LengthDesc) throws ServiceException {
		if (StringUtils.isEmpty(exp)) {
			throwServiceException(ExceptionCode.IsEmpty, LengthDesc);
		}
	}
	
	public static void checkLengthMax(String exp, int max, String LengthDesc) throws ServiceException {
		if (!StringUtils.isEmpty(exp)) {
			checkLengthNotNull(exp, max, LengthDesc);
		}
	}

	public static void checkLengthMin(String exp, int min, String LengthDesc) throws ServiceException {
		if (!StringUtils.isEmpty(exp)) {
			if (exp.length() < min) {
				throwServiceException(ExceptionCode.IsLong, LengthDesc);
			}
		}
	}
	
	public static void checkLengthNotNull(String exp, int length, String LengthDesc) throws ServiceException {
		if (exp.length() < length) {
			throwServiceException(ExceptionCode.IsLong, LengthDesc);
		}
	}
	
	public static void checkEmptyAndLength(final CharSequence cs, String emptyDesc, int length, String LengthDesc) throws ServiceException {
		if (StringUtils.isEmpty(cs)) {
			throwServiceException(ExceptionCode.IsEmpty, emptyDesc);
		} else if (cs.length() <= length) {
			throwServiceException(ExceptionCode.IsLong, LengthDesc);
		}
	}

	public static void throwServiceException(int code, String desc) throws ServiceException {
		throw new ServiceException(code, desc);
	}
}
