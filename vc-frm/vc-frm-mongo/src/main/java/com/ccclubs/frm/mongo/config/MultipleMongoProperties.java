package com.ccclubs.frm.mongo.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * mongo多数据源
 *
 * @author jianghaiyang
 * @create 2018-01-09
 **/
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MultipleMongoProperties {
    private MongoProperties history = new MongoProperties();
    private MongoProperties remote = new MongoProperties();

    public MongoProperties getHistory() {
        return history;
    }

    public void setHistory(MongoProperties history) {
        this.history = history;
    }

    public MongoProperties getRemote() {
        return remote;
    }

    public void setRemote(MongoProperties remote) {
        this.remote = remote;
    }
}
