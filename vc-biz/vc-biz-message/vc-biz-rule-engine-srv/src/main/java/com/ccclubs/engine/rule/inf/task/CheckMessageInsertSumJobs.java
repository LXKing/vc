package com.ccclubs.engine.rule.inf.task;

import com.ccclubs.common.BatchProperties;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.mongo.orm.model.CsMessage;
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
 * {@link CsMessage} 状态数据定时任务<br/> 检查队列大小，防止溢出
 **/
@Component
public class CheckMessageInsertSumJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory.getLogger(CheckMessageInsertSumJobs.class);

  @Autowired
  RedisTemplate redisTemplate;

  protected static ApplicationContext context;

  @Autowired
  BatchProperties batchProperties;

  /**
   * 每分钟检查一次队列大小
   */
  @Scheduled(fixedRate = 60 * 1000)
  public void fixedRateJob() {
    logger.debug("CheckMessageInsertSumJobs start.");
    //检查队列中所有等待更新总数
    long startTime = System.currentTimeMillis();
    Long stateListSrcSize = redisTemplate.opsForList()
        .size(RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_QUEUE);
    if (stateListSrcSize > batchProperties.getMongoInsertQueueMax()) {
      redisTemplate.opsForList()
          .trim(RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_QUEUE, 0,
              batchProperties.getUpdateQueueMax());
    }
    logger.info("time {} , CheckMessageInsertSumJobs time consuming.",
        System.currentTimeMillis() - startTime);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
