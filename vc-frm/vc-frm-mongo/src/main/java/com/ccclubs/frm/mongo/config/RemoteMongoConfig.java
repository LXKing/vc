package com.ccclubs.frm.mongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 指令记录mongo
 *
 * @author jianghaiyang
 * @create 2018-01-09
 **/
@Configuration
@EnableMongoRepositories(basePackages = {"com.ccclubs.mongo.orm.repository.remote"},
        mongoTemplateRef = RemoteMongoConfig.MONGO_TEMPLATE)
public class RemoteMongoConfig {
    protected static final String MONGO_TEMPLATE = "remoteMongoTemplate";
}
