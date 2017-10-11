package com.ccclubs.engine.rule.inf.task;

import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.mongo.orm.dao.CsMessageDao;
import com.ccclubs.mongo.orm.model.CsMessage;
import java.util.List;
import javax.annotation.Resource;
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
 * {@link com.ccclubs.mongo.orm.model.CsMessage} 国标状态数据定时任务<br/> 历史状态数据写入
 **/
@Component
public class BatchHistoryMessageInsertMongoJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory
      .getLogger(BatchHistoryMessageInsertMongoJobs.class);

  @Resource
  private CsMessageDao csMessageDao;

  @Autowired
  RedisTemplate redisTemplate;

  protected static ApplicationContext context;

  /**
   * 扫描等待队列
   */
  @Scheduled(fixedRate = 1000)
  public void fixedRateJob() {
    //取出队列中 等待写入的数据
    List<CsMessage> messageList = redisTemplate.opsForList()
        .range(RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_QUEUE, 0, -1);
    if (messageList.size() > 0) {
      logger.info("本次批量写入mongodb数量为： {}", messageList.size());
      //TODO：HBase批量写入
      csMessageDao.batchInsert(messageList);
      // 删除
      for (CsMessage item : messageList) {
        redisTemplate.opsForList()
            .remove(RuleEngineConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_QUEUE, 0, item);
      }
    }
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
