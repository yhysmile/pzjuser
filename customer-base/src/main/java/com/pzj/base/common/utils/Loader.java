package com.pzj.base.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

 class Loader {

	private static Loader loader = new Loader();

	private Properties p = new Properties();

	private Loader() {
		try {
			InputStream in = ClassLoader
					.getSystemResourceAsStream("redis-manager-config.properties");
			p.load(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public final static Loader getInstance() {
		return loader;
	}

	public Object get(String key) {
		return p.get(key);
	}

}
