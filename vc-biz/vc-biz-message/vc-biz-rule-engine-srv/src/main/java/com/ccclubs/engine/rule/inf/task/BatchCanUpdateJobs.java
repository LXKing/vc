package com.ccclubs.engine.rule.inf.task;

import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.engine.core.util.RuleEngineConstant;
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
 * {@link CsState} 状态数据定时任务<br/> 包含当前状态批量更新
 **/
@Component
public class BatchCanUpdateJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory.getLogger(BatchCanUpdateJobs.class);

  @Autowired
  UpdateCanService updateCanService;

  @Autowired
  RedisTemplate redisTemplate;

  protected static ApplicationContext context;

  /**
   * 扫描请求队列
   */
  @Scheduled(fixedRate = 1000)
  public void fixedRateJob() {
    //取出队列中所有等待更新的数据
    List<CsCan> canList = redisTemplate.opsForList()
        .range(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE, 0, -1);
    if (canList.size() > 0) {
      logger.info("本次批量更新数量为： {}", canList.size());
      updateCanService.batchUpdate(canList);
      // 删除
      for (CsCan item : canList) {
        redisTemplate.opsForList()
            .remove(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE, 0, item);
      }
    }
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
