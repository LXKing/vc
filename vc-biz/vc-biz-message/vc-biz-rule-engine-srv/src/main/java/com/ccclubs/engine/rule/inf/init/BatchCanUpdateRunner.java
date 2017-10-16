package com.ccclubs.engine.rule.inf.init;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.BatchProperties;
import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.common.utils.EnvironmentUtils;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.pub.orm.model.CsCan;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * CsCan 当前CAN状态数据更新
 *
 * @author qsxiaogang
 * @create 2017-10-14
 **/
@Component
@Order(2)
public class BatchCanUpdateRunner implements CommandLineRunner {

  @Autowired
  RedisTemplate redisTemplate;
  @Autowired
  UpdateCanService updateCanService;

  @Autowired
  EnvironmentUtils environmentUtils;
  @Autowired
  BatchProperties batchProperties;

  private static final Logger logger = LoggerFactory.getLogger(BatchCanUpdateRunner.class);

  @SuppressWarnings("unchecked")
  @Override
  public void run(String... strings) throws Exception {
    ExecutorService fixedThreadPool = Executors
        .newFixedThreadPool(batchProperties.getUpdateThreads());
    fixedThreadPool.execute(() -> {
      while (true) {
        logger.debug("BatchCanUpdateRunner start. {}");
        List<CsCan> waitList = new ArrayList();
        try {
          Long startTime = System.currentTimeMillis();
          //取出队列中所有等待更新的数据
          Long canListSrcSize = redisTemplate.opsForList()
              .size(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE);
          if (canListSrcSize > 0) {
            long redisListStartTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - redisListStartTime < batchProperties
                .getUpdateMaxDurTime()) {
              int canListWaitSize = waitList.size();
              if (canListWaitSize > batchProperties.getUpdateBatchSize()) {
                break;
              }
              //取出队列中 等待写入的数据
              Object item = redisTemplate.opsForList()
                  .rightPop(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE);
              if (null == item) {
                break;
              } else {
                waitList.add((CsCan) item);
              }
            }
          }

          // 等待更新的队列
          logger
              .debug("size:{},time:{},foreach redis list ", System.currentTimeMillis() - startTime,
                  waitList.size());

          if (waitList.size() > 0) {
            updateCanService.batchUpdate(waitList);
            logger.info("size:{},time:{} BatchCanUpdateRunner batch update  ", waitList.size(),
                System.currentTimeMillis() - startTime);
          }
        } catch (Exception ex) {
          ex.printStackTrace();
          logger.error(ex.getMessage());
          if (waitList.size() > 0) {
            logger.error("batch update current stateList error. error list content : {}",
                JSON.toJSONString(waitList));
          }
        } finally {
          waitList = null;
        }
      }
    });
  }
}
