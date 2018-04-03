/*
package com.ccclubs.storage.tasks.runner;

import com.alibaba.fastjson.JSON;
import com.ccclubs.storage.tasks.processor.HistoryCanUtils;
import com.ccclubs.storage.tasks.util.BatchProperties;
import com.ccclubs.storage.tasks.util.RedisConstant;
import com.ccclubs.pub.orm.model.CsCan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

*/
/**
 * CsCan 当前状态数据更新
 *
 * @author Alban
 * @create 2017-10-14
 **//*

@Component
@Order(2)
@Deprecated
public class BatchHistoryCanHbaseRunner implements CommandLineRunner {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    HistoryCanUtils historyCanUtils;

    @Autowired
    BatchProperties batchProperties;

    private static final Logger logger = LoggerFactory.getLogger(BatchHistoryCanHbaseRunner.class);

    @Override
    public void run(String... strings) throws Exception {
        ExecutorService fixedThreadPool = Executors
                .newFixedThreadPool(batchProperties.getHbaseInsertThreads());
        fixedThreadPool.execute(() -> {
            while (true) {
                logger.debug("BatchHistoryCanHbaseRunner start. {}");
                List<CsCan> waitList = new ArrayList();
                try {
                    Long startTime = System.currentTimeMillis();
                    //取出队列中所有等待更新的数据
                    Long canListSrcSize = redisTemplate.opsForList()
                            .size(RedisConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE);
                    if (canListSrcSize > 0) {
                        long redisListStartTime = System.currentTimeMillis();
                        while (System.currentTimeMillis() - redisListStartTime < batchProperties
                                .getHbaseInsertMaxDurTime()) {
                            int stateListWaitSize = waitList.size();
                            if (stateListWaitSize > batchProperties.getHbaseInsertBatchSize()) {
                                break;
                            }
                            //取出队列中 等待写入的数据
                            Object item = redisTemplate.opsForList()
                                    .rightPop(RedisConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE);
                            if (null == item) {
                                break;
                            } else {
                                waitList.add((CsCan) item);
                            }
                        }
                    } else {
                        Thread.sleep(500L);
                        continue;
                    }

                    // 等待更新的队列
                    logger.debug("size:{},time:{} check from redis list ", waitList.size(),
                            System.currentTimeMillis() - startTime);

                    if (waitList.size() > 0) {
                        logger.info("取出Can数据，开始准备存储");
                        logger.debug("BatchHistoryCanHbaseRunner is runned:"+waitList.toString());
                        historyCanUtils.saveHistoryDataToHbase(waitList);
                        logger.debug("size:{},time:{} BatchHistoryCanHbaseRunner batch insert  ",
                                waitList.size(),
                                System.currentTimeMillis() - startTime);

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    logger.error(ex.getMessage());
                    if (waitList.size() > 0) {
                        logger.error("batch insert current canList error. error list content : {}",
                                JSON.toJSONString(waitList));
                    }
                }
            }
        });
    }
}
*/
