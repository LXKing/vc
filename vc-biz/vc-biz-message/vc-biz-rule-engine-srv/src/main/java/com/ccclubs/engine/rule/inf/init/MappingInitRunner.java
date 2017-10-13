package com.ccclubs.engine.rule.inf.init;

import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.mongo.orm.model.CsHistoryCan;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 计数器初始化
 *
 * @author jianghaiyang
 * @create 2017-08-15
 **/
@Component
@Order(1)
public class MappingInitRunner implements CommandLineRunner {

  @Autowired
  RedisTemplate redisTemplate;

  @Autowired
  JdbcTemplate jdbcTemplate;

  private int threadCnt = 5;

  @SuppressWarnings("unchecked")
  @Override
  public void run(String... strings) throws Exception {

  }
}
