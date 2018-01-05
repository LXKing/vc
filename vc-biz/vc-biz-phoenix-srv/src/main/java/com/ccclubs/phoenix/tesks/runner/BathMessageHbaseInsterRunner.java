package com.ccclubs.phoenix.tesks.runner;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.BatchProperties;
import com.ccclubs.phoenix.tesks.processor.HistoryMessageUtils;
import com.ccclubs.phoenix.tesks.util.RedisConstant;
import com.ccclubs.pub.orm.dto.CsMessage;
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


/**
 * 国标状态数据写Hbase定时任务
 *
 * @author Alban
 * @create 2017-12-07
 **/
@Component
@Order(2)
public class BathMessageHbaseInsterRunner implements CommandLineRunner {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private HistoryMessageUtils historyMessageUtils;

    @Autowired
    BatchProperties batchProperties;

    private static final Logger logger = LoggerFactory.getLogger(BathMessageHbaseInsterRunner.class);

    @SuppressWarnings("unchecked")
    @Override
    public void run(String... strings) throws Exception {
        ExecutorService fixedThreadPool = Executors
                .newFixedThreadPool(batchProperties.getUpdateThreads());
        fixedThreadPool.execute(() -> {
            while (true) {
                logger.debug("BatchMessageInsertRunner start. {}");
                List<CsMessage> waitList = new ArrayList();
                try {
                    Long startTime = System.currentTimeMillis();
                    //取出队列中所有等待更新的数据
                    Long messageListSrcSize = redisTemplate.opsForList()
                            .size(RedisConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_HBASE_QUEUE);
                    if (messageListSrcSize > 0) {
                        long redisListStartTime = System.currentTimeMillis();
                        while (System.currentTimeMillis() - redisListStartTime < batchProperties
                                .getMongoInsertMaxDurTime()) {
                            int stateListWaitSize = waitList.size();
                            if (stateListWaitSize > batchProperties.getMongoInsertBatchSize()) {
                                break;
                            }
                            //取出队列中 等待写入的数据
                            Object item = redisTemplate.opsForList()
                                    .rightPop(RedisConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_HBASE_QUEUE);
                            if (null == item) {
                                break;
                            } else {
                                waitList.add((CsMessage) item);
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
                        logger.info("取出Gb数据，开始准备存储");
                        historyMessageUtils.saveHistoryGbDataToHbase(waitList);
                        logger.debug("size:{},time:{} BatchMessage hbase InsertRunner batch insert  ", waitList.size(),
                                System.currentTimeMillis() - startTime);

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    logger.error(ex.getMessage());
                    if (waitList.size() > 0) {
                        logger.error("batch insert  hbase current stateList error. error list content : {}",
                                JSON.toJSONString(waitList));
                    }
                }
            }
        });
    }
}
