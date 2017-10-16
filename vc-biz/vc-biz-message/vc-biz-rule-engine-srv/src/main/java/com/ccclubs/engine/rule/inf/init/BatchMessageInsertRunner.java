package com.ccclubs.engine.rule.inf.init;

import com.ccclubs.common.BatchProperties;
import com.ccclubs.common.utils.EnvironmentUtils;
import com.ccclubs.mongo.orm.dao.CsMessageDao;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * CsMessage国标状态数据定时任务
 *
 * @author qsxiaogang
 * @create 2017-10-14
 **/
@Component
@Order(2)
public class BatchMessageInsertRunner implements CommandLineRunner {

  @Autowired
  RedisTemplate redisTemplate;
  @Resource
  private CsMessageDao csMessageDao;

  @Autowired
  EnvironmentUtils environmentUtils;
  @Autowired
  BatchProperties batchProperties;

  private static final Logger logger = LoggerFactory.getLogger(BatchStateUpdateRunner.class);

  @SuppressWarnings("unchecked")
  @Override
  public void run(String... strings) throws Exception {
//    while (true) {
//      try {
//        logger.debug(" BatchHistoryMessageInsertMongoRunner start. {}");
//        Long startTime = System.currentTimeMillis();
//        if (StringUtils.empty(WAIT_QUEUE_NAME)) {
//          WAIT_QUEUE_NAME = environmentUtils
//              .getWaiteQueueName(RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_QUEUE);
//          if (StringUtils.empty(WAIT_QUEUE_NAME)) {
//            logger.error(" host ip not found. WAIT_QUEUE_NAME is null");
//            return;
//          }
//        }
//        //取出队列中所有等待更新的数据
//        List<CsMessage> messageListSrc = redisTemplate.opsForList()
//            .range(RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_QUEUE, 0, -1);
//        if (messageListSrc.size() > 0) {
//          long redisListStartTime = System.currentTimeMillis();
//          while (System.currentTimeMillis() - redisListStartTime < batchProperties
//              .getHbaseInsertMaxDurTime()) {
//            Long messageListWaitSize = redisTemplate.opsForList().size(WAIT_QUEUE_NAME);
//            if (messageListWaitSize > batchProperties.getMongoInsertBatchSize()) {
//              break;
//            }
//            //取出队列中 等待写入的数据
//            redisTemplate.opsForList()
//                .rightPopAndLeftPush(
//                    RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_QUEUE,
//                    WAIT_QUEUE_NAME);
//            try {
//              Thread.sleep(5L);
//            } catch (InterruptedException e) {
//              logger.error(e.getMessage(), e);
//            }
//          }
//        }
//
//        logger.debug(" foeach redis list time {} ", System.currentTimeMillis() - startTime);
//
//        // 等待更新的队列
//        List<CsMessage> messageListWait = redisTemplate.opsForList()
//            .range(WAIT_QUEUE_NAME, 0, -1);
//
//        if (messageListWait.size() > 0) {
//          try {
//            csMessageDao.batchInsert(messageListWait);
//            // 删除
//            redisTemplate.delete(WAIT_QUEUE_NAME);
//            logger.info("history batch CsMessage insert size : {} ,time {}", messageListWait.size(),
//                System.currentTimeMillis() - startTime);
//          } catch (Exception ex) {
//            ex.printStackTrace();
//            logger.error("batch insert history CsMessage error. error list content : {}",
//                JSON.toJSONString(messageListWait));
//          }
//        }
//      } catch (Exception ex) {
//        ex.printStackTrace();
//        logger.error(ex.getMessage());
//      }
//    }
  }
}

