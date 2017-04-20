/**    
 * 文件名：FileUtils.java    
 *    
 * 版本信息：    
 * 日期：2014-9-5    
 * Copyright 足下 Corporation 2014     
 * 版权所有    
 *    
 */
package com.pzj.base.common.utils;

/**
 * 
 * 项目名称：service.base.jar 类名称：FileUtils 类描述： 创建人：石月 创建时间：2014-9-5 上午11:16:10
 * 修改人：wushu 修改时间：2014-9-5 上午11:16:10 修改备注：
 * 
 * @version
 * 
 */
public class FileUtils {

	/**
	 * 根据文件流读取图片文件真实类型
	 * 
	 * @param is
	 * @return
	 */
	public static String getTypeByStream(byte[] file) {
		byte[] b = new byte[4];
		if (file.length > 4) {
			b[0] = file[0];
			b[1] = file[1];
			b[2] = file[2];
			b[3] = file[3];
		} else {
			return null;
		}
		String type = bytesToHexString(b).toUpperCase();
		// System.out.println(type);
		if (type.contains("FFD8FF")) {
			return "jpg";
		} else if (type.contains("89504E47")) {
			return "png";
		} else if (type.contains("47494638")) {
			return "gif";
		} else if (type.contains("49492A00")) {
			return "tif";
		} else if (type.contains("424D")) {
			return "bmp";
		} else {
			return null;
		}
	}

	/**
	 * byte数组转换成16进制字符串
	 * 
	 * @param src
	 * @return
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
}
