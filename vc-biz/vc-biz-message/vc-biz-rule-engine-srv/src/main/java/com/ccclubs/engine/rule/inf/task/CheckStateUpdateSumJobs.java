package com.ccclubs.engine.rule.inf.task;

import com.ccclubs.common.BatchProperties;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.pub.orm.model.CsState;
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
 * {@link CsState} 状态数据定时任务<br/> 检查队列大小，防止溢出
 **/
@Component
public class CheckStateUpdateSumJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory.getLogger(CheckStateUpdateSumJobs.class);

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
    logger.debug("CheckStateUpdateSumJobs start.");
    //检查队列中所有等待更新总数
    long startTime = System.currentTimeMillis();
    Long stateListSrcSize = redisTemplate.opsForList()
        .size(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE);
    if (stateListSrcSize > batchProperties.getUpdateQueueMax()) {
      redisTemplate.opsForList()
          .trim(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, 0,
              batchProperties.getUpdateQueueMax());
    }
    logger.debug("time {} , CheckStateUpdateSumJobs time consuming.",
        System.currentTimeMillis() - startTime);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
