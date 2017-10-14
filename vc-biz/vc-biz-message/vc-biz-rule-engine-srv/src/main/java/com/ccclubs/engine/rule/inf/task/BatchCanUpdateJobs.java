package com.ccclubs.engine.rule.inf.task;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.BatchProperties;
import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.common.utils.EnvironmentUtils;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsCan;
import com.ccclubs.pub.orm.model.CsState;
import java.util.List;
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
 * {@link CsState} 状态数据定时任务<br/> 包含当前CAN状态批量更新
 **/
@Component
public class BatchCanUpdateJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory.getLogger(BatchCanUpdateJobs.class);

  @Autowired
  UpdateCanService updateCanService;

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
    logger.debug(" BatchCanUpdateJobs start. {}");
    Long startTime = System.currentTimeMillis();
    if (StringUtils.empty(WAIT_QUEUE_NAME)) {
      WAIT_QUEUE_NAME = getWaiteQueueName();
      if (StringUtils.empty(WAIT_QUEUE_NAME)) {
        logger.error(" host ip not found. WAIT_QUEUE_NAME is null");
        return;
      }
    }
    //取出队列中所有等待更新的数据
    Long canListSrcSize = redisTemplate.opsForList()
        .size(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE);
    if (canListSrcSize > 0) {
      long redisListStartTime = System.currentTimeMillis();
      while (System.currentTimeMillis() - redisListStartTime < batchProperties
          .getUpdateMaxDurTime()) {
        Long canListWaitSize = redisTemplate.opsForList().size(WAIT_QUEUE_NAME);
        if (canListWaitSize > batchProperties.getUpdateBatchSize()) {
          break;
        }
        //取出队列中 等待写入的数据
        redisTemplate.opsForList()
            .rightPopAndLeftPush(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE,
                WAIT_QUEUE_NAME);
      }
    }

    logger.debug(" foeach redis list time {} ", System.currentTimeMillis() - startTime);

    // 等待更新的队列
    List<CsCan> canListWait = redisTemplate.opsForList()
        .range(WAIT_QUEUE_NAME, 0, -1);

    if (canListWait.size() > 0) {
      try {
        updateCanService.batchUpdate(canListWait);
        // 删除
        redisTemplate.delete(WAIT_QUEUE_NAME);
        logger.info("current batch update size : {} ,time {}", canListWait.size(),
            System.currentTimeMillis() - startTime);
      } catch (Exception ex) {
        ex.printStackTrace();
        logger.error("batch update current canList error. error list content : {}",
            JSON.toJSONString(canListWait));
      }
    }
  }

  private String getWaiteQueueName() {
    String hostIp = environmentUtils.getCurrentIp();
    if (!StringUtils.empty(hostIp)) {
      return RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE + ":" +
          environmentUtils.getCurrentIp().replaceAll("\\.", "#");
    }
    return hostIp;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
