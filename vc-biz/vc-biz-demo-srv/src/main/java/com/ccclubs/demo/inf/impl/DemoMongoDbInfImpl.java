package com.ccclubs.demo.inf.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.demo.inf.DemoMongoDbInf;
import com.ccclubs.demo.mod.DemoEntity;
import com.ccclubs.demo.mono.dao.DemoMongoDbDao;

@Service(version = "1.0.0")
public class DemoMongoDbInfImpl implements DemoMongoDbInf {
	@Resource
	private DemoMongoDbDao demoMongoDbDao;

	@Override
	public String sayMongoDemo(DemoEntity mongo) {
		demoMongoDbDao.saveDemo(mongo);
		return mongo.getMyName();
	}

}
