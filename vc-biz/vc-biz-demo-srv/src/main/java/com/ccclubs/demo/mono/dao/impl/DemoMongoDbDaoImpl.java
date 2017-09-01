package com.ccclubs.demo.mono.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.ccclubs.demo.mod.DemoEntity;
import com.ccclubs.demo.mono.dao.DemoMongoDbDao;
@Component
public class DemoMongoDbDaoImpl implements DemoMongoDbDao {
    @Autowired
    private MongoTemplate mongoTemplate;
	@Override
	public void saveDemo(DemoEntity demo) {
		mongoTemplate.save(demo);
	}
	@Override
	public DemoEntity findDemoByMyName(String myName) {
		Query query=new Query(Criteria.where("myName").is(myName));
		DemoEntity demo =  mongoTemplate.findOne(query , DemoEntity.class);
		return demo;
	}

}
