/**
 * ApplicationUtil.java
 * com.vko.controllers.util
 * Copyright (c) 2014
 */

package com.pzj.base.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.alibaba.dubbo.container.spring.SpringContainer;

/**
 * 静态调用applicationContext
 * <p>
 */
public class ApplicationUtil implements ApplicationContextAware {

    private static ApplicationContext context ;

    public static void setApplication(ApplicationContext context) {
        ApplicationUtil.context = context;
    }

    public static <T> T getBean(Class<T> cls) {
        return context.getBean(cls);
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> cls) {
        return context.getBean(name, cls);
    }

    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
