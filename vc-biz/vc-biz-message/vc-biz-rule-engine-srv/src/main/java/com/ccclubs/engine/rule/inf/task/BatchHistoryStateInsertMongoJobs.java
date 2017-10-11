package com.ccclubs.engine.rule.inf.task;

import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.engine.core.util.RuleEngineConstant;
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
public class BatchHistoryStateInsertMongoJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory
      .getLogger(BatchHistoryStateInsertMongoJobs.class);

  @Autowired
  UpdateStateService updateStateService;

  @Autowired
  RedisTemplate redisTemplate;

  protected static ApplicationContext context;

  /**
   * 扫描请求队列
   */
  @Scheduled(fixedRate = 50)
  public void fixedRateJob() {
    //取出队列中 等待写入的数据
    Object history = redisTemplate.opsForList()
        .rightPop(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_INSERT_QUEUE);
    if (null != history) {
      CsHistoryState csHistoryState = (CsHistoryState) history;

      updateStateService.insertHis(csHistoryState);
    }

//    //取出队列中 等待写入的数据
//    List<CsHistoryState> stateList = redisTemplate.opsForList()
//        .range(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE, 0, -1);
//    if (stateList.size() > 0) {
//      logger.info("本次批量写入Hbase数量为： {}", stateList.size());
//      //TODO：HBase批量写入
//      updateStateService.batchInsertHistory(stateList);
//      // 删除
//      for (CsHistoryState item : stateList) {
//        redisTemplate.opsForList()
//            .remove(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE, 0, item);
//      }
//    }
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
