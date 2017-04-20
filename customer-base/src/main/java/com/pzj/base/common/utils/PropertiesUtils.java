/**    
 * 文件名：PropertiesUtils.java    
 *    
 * 版本信息：    
 * 日期：2014-6-13    
 * Copyright 足下 Corporation 2014     
 * 版权所有    
 *    
 */
package com.pzj.base.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * 项目名称：service.product.jersey 类名称：PropertiesUtils 类描述： 创建人：石月 创建时间：2014-6-13
 * 下午6:00:19 修改人：wushu 修改时间：2014-6-13 下午6:00:19 修改备注：
 * 
 * @version
 * 
 */
public class PropertiesUtils {

	private static String url;// 开放的URL

	private static int port;// 开放的端口
	static {
		InputStream is = ClassLoader
				.getSystemResourceAsStream("jersey.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
			url = properties.getProperty("jersey.url", "http://127.0.0.1/");
			port = Integer.parseInt(properties.getProperty("jersey.port",
					"9998"));
			if (!url.startsWith("http://")) {
				url = "http://" + url;
			}
			if (!url.endsWith("/")) {
				url = url + "/";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getUrl() {
		return url;
	}

	public static int getPort() {
		return port;
	}

}
