package com.ccclubs.engine.rule.inf.task;

import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.mongo.orm.model.CsHistoryCan;
import com.ccclubs.mongo.orm.model.CsHistoryState;
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
 * {@link CsHistoryState} 状态数据定时任务<br/> 历史状态数据写入
 **/
@Component
public class BatchHistoryCanInsertMongoJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory
      .getLogger(BatchHistoryCanInsertMongoJobs.class);

  @Autowired
  UpdateCanService updateCanService;

  @Autowired
  RedisTemplate redisTemplate;

  protected static ApplicationContext context;

  /**
   * 扫描请求队列
   */
  @Scheduled(fixedRate = 5)
  public void fixedRateJob() {
    //取出队列中 等待写入的数据
    Object history = redisTemplate.opsForList()
        .rightPop(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_INSERT_QUEUE);
    if (null != history) {
      CsHistoryCan csHistoryCan = (CsHistoryCan) history;

      updateCanService.insertHis(csHistoryCan);
    }
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
