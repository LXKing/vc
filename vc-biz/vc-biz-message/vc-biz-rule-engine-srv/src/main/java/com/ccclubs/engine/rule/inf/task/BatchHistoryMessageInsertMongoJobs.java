package com.ccclubs.engine.rule.inf.task;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.BatchProperties;
import com.ccclubs.common.utils.EnvironmentUtils;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.mongo.orm.dao.CsMessageDao;
import com.ccclubs.mongo.orm.model.CsMessage;
import com.ccclubs.protocol.util.StringUtils;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * {@link com.ccclubs.mongo.orm.model.CsMessage} 国标状态数据定时任务<br/> 历史状态数据写入
 **/
@Component
public class BatchHistoryMessageInsertMongoJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory
      .getLogger(BatchHistoryMessageInsertMongoJobs.class);

  @Resource
  private CsMessageDao csMessageDao;

  @Autowired
  RedisTemplate redisTemplate;

  @Autowired
  EnvironmentUtils environmentUtils;

  protected static ApplicationContext context;

  private String WAIT_QUEUE_NAME;

  @Autowired
  BatchProperties batchProperties;

  /**
   * 扫描请求队列
   */
  @Scheduled(fixedRate = 1000)
  public void fixedRateJob() {
    logger.debug(" BatchHistoryMessageInsertMongoJobs start. {}");
    Long startTime = System.currentTimeMillis();
    if (StringUtils.empty(WAIT_QUEUE_NAME)) {
      WAIT_QUEUE_NAME = getWaiteQueueName();
      if (StringUtils.empty(WAIT_QUEUE_NAME)) {
        logger.error(" host ip not found. WAIT_QUEUE_NAME is null");
        return;
      }
    }
    //取出队列中所有等待更新的数据
    List<CsMessage> messageListSrc = redisTemplate.opsForList()
        .range(RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_QUEUE, 0, -1);
    if (messageListSrc.size() > 0) {
      long redisListStartTime = System.currentTimeMillis();
      while (System.currentTimeMillis() - redisListStartTime < batchProperties
          .getHbaseInsertMaxDurTime()) {
        Long messageListWaitSize = redisTemplate.opsForList().size(WAIT_QUEUE_NAME);
        if (messageListWaitSize > batchProperties.getMongoInsertBatchSize()) {
          break;
        }
        //取出队列中 等待写入的数据
        redisTemplate.opsForList()
            .rightPopAndLeftPush(RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_QUEUE,
                WAIT_QUEUE_NAME);
        try {
          Thread.sleep(5L);
        } catch (InterruptedException e) {
          logger.error(e.getMessage(), e);
        }
      }
    }

    logger.debug(" foeach redis list time {} ", System.currentTimeMillis() - startTime);

    // 等待更新的队列
    List<CsMessage> messageListWait = redisTemplate.opsForList()
        .range(WAIT_QUEUE_NAME, 0, -1);

    if (messageListWait.size() > 0) {
      try {
        csMessageDao.batchInsert(messageListWait);
        // 删除
        redisTemplate.delete(WAIT_QUEUE_NAME);
        logger.info("history batch CsMessage insert size : {} ,time {}", messageListWait.size(),
            System.currentTimeMillis() - startTime);
      } catch (Exception ex) {
        ex.printStackTrace();
        logger.error("batch insert history CsMessage error. error list content : {}",
            JSON.toJSONString(messageListWait));
      }
    }
  }

  private String getWaiteQueueName() {
    String hostIp = environmentUtils.getCurrentIp();
    if (!StringUtils.empty(hostIp)) {
      return RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_QUEUE + ":" +
          environmentUtils.getCurrentIp().replaceAll("\\.", "#");
    }
    return hostIp;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
