package com.ccclubs.frm.mongodb.config;

import com.ccclubs.frm.mongodb.listener.SaveMongoEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by qsxiaogang on 2017/7/5.
 */
@Configuration
public class MongoConfig {

  @Bean
  public SaveMongoEventListener getMongoEventListener() {
    return new SaveMongoEventListener();
  }

}
