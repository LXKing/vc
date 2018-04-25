//package com.ccclubs.engine.rule.inf.task;
//
//import com.ccclubs.common.BatchProperties;
//import com.ccclubs.engine.core.util.RuleEngineConstant;
//import com.ccclubs.pub.orm.model.CsCan;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * {@link CsCan} 状态数据定时任务<br/> 检查队列大小，防止溢出
// **/
//@Component
//public class CheckCanUpdateSumJobs implements ApplicationContextAware {
//
//  private static final Logger logger = LoggerFactory.getLogger(CheckCanUpdateSumJobs.class);
//
//  @Autowired
//  RedisTemplate redisTemplate;
//
//  protected static ApplicationContext context;
//
//  @Autowired
//  BatchProperties batchProperties;
//
//  /**
//   * 每20分钟检查一次队列大小
//   */
//  @Scheduled(fixedRate = 60 * 1000)
//  public void fixedRateJob() {
//    logger.debug("CheckCanUpdateSumJobs start.");
//    //检查队列中所有等待更新总数
//    long startTime = System.currentTimeMillis();
//    Long stateListSrcSize = redisTemplate.opsForList()
//        .size(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE);
//    if (stateListSrcSize > batchProperties.getUpdateQueueMax()) {
//      redisTemplate.opsForList()
//          .trim(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE, 0,
//              batchProperties.getUpdateQueueMax());
//    }
//    logger.debug("time {} , CheckCanUpdateSumJobs time consuming.",
//        System.currentTimeMillis() - startTime);
//  }
//
//  @Override
//  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//    this.context = applicationContext;
//  }
//}
