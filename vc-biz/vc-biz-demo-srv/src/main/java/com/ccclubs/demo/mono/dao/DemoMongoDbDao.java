package com.ccclubs.demo.mono.dao;

import com.ccclubs.demo.mod.DemoEntity;

public interface DemoMongoDbDao {
	void saveDemo(DemoEntity demo);
	DemoEntity findDemoByMyName(String myName);
}
