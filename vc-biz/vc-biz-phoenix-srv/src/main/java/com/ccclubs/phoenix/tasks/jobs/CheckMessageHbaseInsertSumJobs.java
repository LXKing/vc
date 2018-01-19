package com.ccclubs.phoenix.tasks.jobs;


import com.ccclubs.phoenix.tasks.util.BatchProperties;
import com.ccclubs.phoenix.tasks.util.RedisConstant;
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
 * @author Alban
 *  状态数据定时任务<br/> 检查队列大小，防止溢出
 * @date 2017年12月7日
 **/
@Component
public class CheckMessageHbaseInsertSumJobs implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(CheckMessageHbaseInsertSumJobs.class);

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
        logger.debug("CheckMessageHbaseInsertSumJobs start.");
        //检查队列中所有等待更新总数
        long startTime = System.currentTimeMillis();
        Long stateListSrcSize = redisTemplate.opsForList()
                .size(RedisConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_HBASE_QUEUE);
        if (stateListSrcSize > batchProperties.getHbaseInsertQueueMax()) {
            redisTemplate.opsForList()
                    .trim(RedisConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_HBASE_QUEUE, 0,
                            batchProperties.getUpdateQueueMax());
        }
        logger.debug("time {} , CheckMessageHbaseInsertSumJobs time consuming.",
                System.currentTimeMillis() - startTime);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
