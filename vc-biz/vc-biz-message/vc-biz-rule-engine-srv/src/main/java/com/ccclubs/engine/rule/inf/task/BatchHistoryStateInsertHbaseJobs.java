package com.ccclubs.engine.rule.inf.task;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.BatchProperties;
import com.ccclubs.common.utils.EnvironmentUtils;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.mongo.orm.model.CsHistoryState;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsState;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * {@link CsState} 状态数据定时任务<br/> 包含当前状态批量更新，历史状态数据批量写入
 **/
@Component
public class BatchHistoryStateInsertHbaseJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory
      .getLogger(BatchHistoryStateInsertHbaseJobs.class);

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
//  @Scheduled(fixedRate = 15*1000)
  public void fixedRateJob() {
    logger.debug(" BatchHistoryStateInsertHbaseJobs start. {}");
    Long startTime = System.currentTimeMillis();
    if (StringUtils.empty(WAIT_QUEUE_NAME)) {
      WAIT_QUEUE_NAME = getWaiteQueueName();
      if (StringUtils.empty(WAIT_QUEUE_NAME)) {
        logger.error(" host ip not found. WAIT_QUEUE_NAME is null");
        return;
      }
    }
    //取出队列中所有等待更新的数据
    List<CsHistoryState> stateListSrc = redisTemplate.opsForList()
        .range(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE, 0, -1);
    if (stateListSrc.size() > 0) {
      long redisListStartTime = System.currentTimeMillis();
      while (redisTemplate.opsForList()
          .range(WAIT_QUEUE_NAME, 0, -1).size() < batchProperties.getUpdateBatchSize()
          && System.currentTimeMillis() - redisListStartTime < batchProperties
          .getUpdateMaxDurTime()) {
        //取出队列中 等待写入的数据
        redisTemplate.opsForList()
            .rightPopAndLeftPush(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE,
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
    List<CsHistoryState> stateListWait = redisTemplate.opsForList()
        .range(WAIT_QUEUE_NAME, 0, -1);

    if (stateListWait.size() > 0) {
      try {
        //通过hbase批量写入
//        updateStateService.batchInsertHistory(stateListWait);
        // 删除
        redisTemplate.delete(WAIT_QUEUE_NAME);
        logger.info("current batch insert hbase stateHistory size : {} ,time {}",
            stateListWait.size(),
            System.currentTimeMillis() - startTime);
      } catch (Exception ex) {
        ex.printStackTrace();
        logger.error("batch insert hbase history stateHistoryList error. error list content : {}",
            JSON.toJSONString(stateListWait));
      }
    }
  }

  private String getWaiteQueueName() {
    String hostIp = environmentUtils.getCurrentIp();
    if (!StringUtils.empty(hostIp)) {
      return RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE  + ":" +
          environmentUtils.getCurrentIp().replaceAll("\\.", "#");
    }
    return hostIp;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
