package com.ccclubs.admin.task.jobs;

import com.ccclubs.mongo.orm.model.history.CsVehicleExp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 清理mongo数据
 *
 * @author jianghaiyang
 * @create 2018-03-08
 **/
@Service
public class ExpDataCleanJob implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ExpDataCleanJob.class);

    @Resource(name = "historyMongoTemplate")
    MongoTemplate historyMongoTemplate;

    @Override
    public void run() {
        logger.info("车辆异常数据开始清理...");
        Query query = new Query();
        // 清空mongo异常数据
        historyMongoTemplate.remove(query, CsVehicleExp.class);
        logger.info("车辆异常数据清理完成.");

    }
}
