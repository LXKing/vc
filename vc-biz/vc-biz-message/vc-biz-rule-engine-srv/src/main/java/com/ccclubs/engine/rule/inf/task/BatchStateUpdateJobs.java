package com.ccclubs.engine.rule.inf.task;

import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.engine.core.util.RuleEngineConstant;
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
 * {@link com.ccclubs.pub.orm.model.CsState} 状态数据定时任务<br/> 包含当前状态批量更新
 **/
@Component
public class BatchStateUpdateJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory.getLogger(BatchStateUpdateJobs.class);

  @Autowired
  UpdateStateService updateStateService;

  @Autowired
  RedisTemplate redisTemplate;

  protected static ApplicationContext context;

  /**
   * 扫描请求队列
   */
  @Scheduled(fixedRate = 1000)
  public void fixedRateJob() {
    //取出队列中所有等待更新的数据
    List<CsState> stateList = redisTemplate.opsForList()
        .range(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, 0, -1);
    if (stateList.size() > 0) {
      logger.info("本次批量更新数量为： {}", stateList.size());
      updateStateService.batchUpdate(stateList);
      // 删除
      for (CsState item : stateList) {
        redisTemplate.opsForList()
            .remove(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, 0, item);
      }
    }
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
