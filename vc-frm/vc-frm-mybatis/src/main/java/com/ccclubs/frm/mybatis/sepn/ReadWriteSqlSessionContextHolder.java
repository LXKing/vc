package com.ccclubs.frm.mybatis.sepn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadWriteSqlSessionContextHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	private static Logger logger = LoggerFactory.getLogger(ReadWriteSqlSessionContextHolder.class);

	public static void setSessionFactoryKey(String dataSourceKey) {
		contextHolder.set(dataSourceKey);
	}

	public static String getDataSourceKey() {
		String key = contextHolder.get();
		logger.info("当前线程Thread:" + Thread.currentThread().getName() + " 当前的数据源 key is " + key);
		return key;
	}

}