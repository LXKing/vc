package com.ccclubs.frm.mongo.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.util.StringUtils;

/**
 * 多数据源mongo
 *
 * @author jianghaiyang
 * @create 2018-01-09
 **/
@Configuration
@EnableConfigurationProperties({MultipleMongoProperties.class})
public class MultipleMongoConfig {

    @Autowired
    private MultipleMongoProperties mongoProperties;

    @Primary
    @Bean(name = HistoryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate primaryMongoTemplate() throws Exception {
        return new MongoTemplate(historyFactory(this.mongoProperties.getHistory()));
    }

    @Bean
    @Qualifier(RemoteMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate secondaryMongoTemplate() throws Exception {
        return new MongoTemplate(remoteFactory(this.mongoProperties.getRemote()));
    }

    @Bean
    @Primary
    public MongoDbFactory historyFactory(MongoProperties mongo) throws Exception {
        if (!StringUtils.isEmpty(mongo.getHost()) && !StringUtils.isEmpty(mongo.getPort())
                && !StringUtils.isEmpty(mongo.getDatabase())) {
            return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                    mongo.getDatabase());
        } else {
            return new SimpleMongoDbFactory(new MongoClientURI(mongo.getUri()));
        }
    }

    @Bean
    public MongoDbFactory remoteFactory(MongoProperties mongo) throws Exception {
        if (!StringUtils.isEmpty(mongo.getHost()) && !StringUtils.isEmpty(mongo.getPort())
                && !StringUtils.isEmpty(mongo.getDatabase())) {
            return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                    mongo.getDatabase());
        } else {
            return new SimpleMongoDbFactory(new MongoClientURI(mongo.getUri()));
        }
    }
}
