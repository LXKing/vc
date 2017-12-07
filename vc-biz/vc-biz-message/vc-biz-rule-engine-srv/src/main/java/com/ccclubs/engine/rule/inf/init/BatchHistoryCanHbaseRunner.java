package com.ccclubs.engine.rule.inf.init;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.BatchProperties;
import com.ccclubs.mongo.modify.UpdateCanService;
import com.ccclubs.mongo.modify.UpdateStateService;
import com.ccclubs.common.utils.EnvironmentUtils;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.rule.inf.util.HistoryCanUtils;
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

/**
 * CsCan 当前状态数据更新
 *
 * @author Alban
 * @create 2017-10-14
 **/
@Component
@Order(2)
public class BatchHistoryCanHbaseRunner implements CommandLineRunner {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UpdateCanService updateCanService;

    @Autowired
    HistoryCanUtils historyCanUtils;
    @Autowired
    EnvironmentUtils environmentUtils;
    @Autowired
    BatchProperties batchProperties;

    private static final Logger logger = LoggerFactory.getLogger(BatchHistoryCanHbaseRunner.class);

    @SuppressWarnings("unchecked")
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
                            .size(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE);
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
                                    .rightPop(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE);
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
                        logger.debug("BatchHistoryCanHbaseRunner is runned:"+waitList.toString());
                        //historyStateUtils.saveHistoryDataToHbase(waitList);
                        historyCanUtils.saveHistoryDataToHbase(waitList);
//            updateStateService.batchUpdate(waitList);
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
                } finally {
                    waitList = null;
                }
            }
        });
    }
}
