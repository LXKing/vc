package com.ccclubs.demo.inf.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.demo.cache.DemoCache;
import com.ccclubs.demo.inf.DemoCacheInf;

@Service(version = "1.0.0")
public class DemoCacheInfImpl implements DemoCacheInf {
	@Resource
	private DemoCache demoCache;

	@Override
	public String sayCacheDemo(String cache) {
		demoCache.insert("ca");
		String ca = demoCache.getId("ca");
		return ca;
	}

}
