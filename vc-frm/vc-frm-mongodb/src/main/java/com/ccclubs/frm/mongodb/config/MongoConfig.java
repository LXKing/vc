package com.ccclubs.frm.mongodb.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
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
import org.springframework.util.StringUtils;

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
    if (!StringUtils.isEmpty(mongo.getHost()) && !StringUtils.isEmpty(mongo.getPort())
        && !StringUtils.isEmpty(mongo.getDatabase())) {
      return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
          mongo.getDatabase());
    } else {
      return new SimpleMongoDbFactory(new MongoClientURI(mongo.getUri()));
    }
  }

  @Bean
  public MongoDbFactory gbStandardFactory(GbStandardMongoProperties mongo) throws Exception {
    if (!StringUtils.isEmpty(mongo.getHost()) && !StringUtils.isEmpty(mongo.getPort())
        && !StringUtils.isEmpty(mongo.getDatabase())) {
      return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
          mongo.getDatabase());
    } else {
      return new SimpleMongoDbFactory(new MongoClientURI(mongo.getUri()));
    }
  }
}
