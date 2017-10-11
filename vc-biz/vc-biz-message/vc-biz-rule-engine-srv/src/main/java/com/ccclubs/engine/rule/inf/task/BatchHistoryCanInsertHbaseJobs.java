package com.ccclubs.engine.rule.inf.task;

import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.mongo.orm.model.CsHistoryCan;
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
 * {@link CsState} 状态数据定时任务<br/> 包含当前状态批量更新，历史状态数据批量写入
 **/
@Component
public class BatchHistoryCanInsertHbaseJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory
      .getLogger(BatchHistoryCanInsertHbaseJobs.class);

  @Autowired
  RedisTemplate redisTemplate;
  @Autowired
  UpdateCanService updateCanService;

  protected static ApplicationContext context;

  /**
   * 扫描请求队列
   */
  @Scheduled(fixedRate = 10 * 1000)
  public void fixedRateJob() {
    //取出队列中 等待写入的数据
    List<CsHistoryCan> canList = redisTemplate.opsForList()
        .range(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE, 0, -1);
    if (canList.size() > 0) {
      logger.info("本次批量写入Hbase数量为： {}", canList.size());
      //TODO：HBase批量写入
      updateCanService.batchInsertHistory(canList);
      // 删除
      for (CsHistoryCan item : canList) {
        redisTemplate.opsForList()
            .remove(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE, 0, item);
      }
    }
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
