package com.ccclubs.frm.mongodb.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by qsxiaogang on 2017/7/5.
 */
@Configuration
@EnableConfigurationProperties({GbStandardMongoProperties.class, MongoProperties.class})
@EnableMongoAuditing
public class MongoConfig {

  @Autowired
  MongoProperties properties;
  @Autowired
  GbStandardMongoProperties gbStandardMongoProperties;

  @Autowired
  Environment environment;

  @Primary
  @Bean(name = "mongoTemplate")
  public MongoTemplate primaryMongoTemplate() throws Exception {
    return new MongoTemplate(primaryFactory(properties));
  }

  @Bean(name = "gbStandardMongoTemplate")
  @Qualifier(value = "gbStandardMongoTemplate")
  public MongoTemplate gbStandardMongoTemplate() throws Exception {
    return new MongoTemplate(gbStandardFactory(gbStandardMongoProperties));
  }

  @Bean
  @Primary
  public MongoDbFactory primaryFactory(MongoProperties mongo) throws Exception {
    return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
        mongo.getDatabase());
  }

  @Bean
  public MongoDbFactory gbStandardFactory(GbStandardMongoProperties mongo) throws Exception {
    return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
        mongo.getDatabase());
  }
}
