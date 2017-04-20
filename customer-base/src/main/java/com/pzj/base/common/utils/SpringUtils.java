package com.pzj.base.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 
 * 项目名称：service.product.redis 类名称：SpringUtils 类描述： 创建人：石月 创建时间：2014-6-14
 * 下午2:26:40 修改人：wushu 修改时间：2014-6-14 下午2:26:40 修改备注：
 * 
 * @version
 * 
 */
public class SpringUtils {

	private SpringUtils() {
		super();
	}

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext(
				"classpath*:/spring-context.xml");
	}
}
