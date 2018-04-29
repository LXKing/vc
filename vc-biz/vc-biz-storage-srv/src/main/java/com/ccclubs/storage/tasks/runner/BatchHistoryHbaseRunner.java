//package com.ccclubs.storage.tasks.runner;
//
//import com.alibaba.fastjson.JSON;
//import com.ccclubs.storage.inf.BaseHbaseStorageInf;
//import com.ccclubs.storage.tasks.util.BatchProperties;
//import com.google.common.util.concurrent.ThreadFactoryBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.*;
//
///**
// * Created with IntelliJ IDEA2017.
// *
// * @Author: Alban
// * @Date: 2018/3/30
// * @Time: 11:46
// * @Description: 死循环读取redis，然后通过Phoenix存储数据到HBASE的类。
// * 这是一个通用的类只要存储服务实现了{@link BaseHbaseStorageInf}接口即可。
// */
//@Component
//public class BatchHistoryHbaseRunner  {//implements CommandLineRunner
//
//    private static final Logger logger = LoggerFactory.getLogger(BatchHistoryHbaseRunner.class);
//
//    @Autowired
//    RedisTemplate redisTemplate;
//    @Autowired
//    BatchProperties batchProperties;
//    @Autowired
//    InsertToHbaseMap insertToHbaseMap;
//
//
//    private ExecutorService createThreadPool() {
//
//        int corePoolSize = batchProperties.getHbaseInsertThreads();
//        int maxPoolSize = 100;
//        long keepAlive = 10 * 1000;
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("SaveToPhoenix-pool-%d").build();
//        return new ThreadPoolExecutor(
//                corePoolSize,
//                maxPoolSize,
//                keepAlive,
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(2048),
//                namedThreadFactory,
//                handler);
//
//    }
//
//    public void run(String... strings) throws Exception {
//        ExecutorService executorService = createThreadPool();
//        Set<String> keySet = insertToHbaseMap.getInstance().keySet();
//
//        for (String key : keySet
//                ) {
//            executorService.execute(
//                    () -> {
//                        BaseHbaseStorageInf baseHbaseStorageInf=insertToHbaseMap.getInstance().get(key);
//                        executeBody(key, baseHbaseStorageInf);
//                    }
//            );
//        }
//
//    }
//
//    private void executeBody(String key, BaseHbaseStorageInf baseHistoryUtilsInf) {
//        while (true) {
//            logger.debug("BatchHistoryHbaseRunner start. {}");
//            List waitList = new ArrayList();
//
//                Long startTime = System.currentTimeMillis();
//                //取出队列中所有等待更新的数据
//                Long canListSrcSize = redisTemplate.opsForList().size(key);
//
//                if (canListSrcSize > 0) {
//                    long redisListStartTime = System.currentTimeMillis();
//                    while (System.currentTimeMillis() - redisListStartTime < batchProperties
//                            .getHbaseInsertMaxDurTime()) {
//                        int stateListWaitSize = waitList.size();
//                        if (stateListWaitSize > batchProperties.getHbaseInsertBatchSize()) {
//                            break;
//                        }
//                        //取出队列中 等待写入的数据
//                        Object item = redisTemplate.opsForList().rightPop(key);
//                        if (null == item) {
//                            break;
//                        } else {
//                            waitList.add(item);
//                        }
//                    }//while
//                } else {
//                    try {
//                        Thread.sleep(1000L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    continue;
//                }
//
//                // 等待更新的队列
//                logger.debug("size:{},time:{} check from redis list ", waitList.size(),
//                        System.currentTimeMillis() - startTime);
//            try {
//                if (waitList.size() > 0) {
//                    logger.debug("Start storage Hbase:" + key + "\n" + "BatchHistoryHbaseRunner is runned:" + waitList.toString());
//                    baseHistoryUtilsInf.saveHistoryDataToHbase(waitList);
//                    logger.debug("size:{},time:{} BatchHistoryHbaseRunner batch insert  ",
//                            waitList.size(),
//                            System.currentTimeMillis() - startTime);
//                }
//
//            } catch (Exception ex) {
//                //ex.printStackTrace();
//                logger.error(ex.getMessage());
//                if (null != waitList && waitList.size() > 0) {
//                    logger.error("batch insert current error. error list content : {}",
//                            JSON.toJSONString(waitList));
//                }
//            }//catch
//        }//while(true)
//    }
//
//
//}
