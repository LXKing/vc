package com.ccclubs.frm.mongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 历史数据mongo
 *
 * @author jianghaiyang
 * @create 2018-01-09
 **/
@Configuration
@EnableMongoRepositories(basePackages = {"com.ccclubs.mongo.orm.repository.history"},
        mongoTemplateRef = HistoryMongoConfig.MONGO_TEMPLATE)
public class HistoryMongoConfig {
    protected static final String MONGO_TEMPLATE = "historyMongoTemplate";
}
