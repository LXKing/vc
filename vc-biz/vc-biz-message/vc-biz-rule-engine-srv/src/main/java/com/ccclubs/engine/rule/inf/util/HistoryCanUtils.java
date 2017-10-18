package com.ccclubs.engine.rule.inf.util;

import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.mongo.orm.model.CsHistoryCan;
import com.ccclubs.pub.orm.model.CsCan;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author qsxiaogang
 * @create 2017-10-11
 **/
@Component
public class HistoryCanUtils {

  private static Logger logger = LoggerFactory.getLogger(HistoryCanUtils.class);
  @Resource
  private RedisTemplate redisTemplate;
  @Autowired
  UpdateCanService updateCanService;

  public void saveHistoryData(CsCan csCan) {

    CsHistoryCan canHistoryData = new CsHistoryCan();

    canHistoryData.setCshcAccess(csCan.getCscAccess());
    canHistoryData.setCshcHost(csCan.getCscHost());
    canHistoryData.setCshcCar(csCan.getCscCar());
    canHistoryData.setCshcAddTime(System.currentTimeMillis());
    canHistoryData.setCshcNumber(csCan.getCscNumber());
    canHistoryData.setCshcData(csCan.getCscData());
    canHistoryData.setCshcModel(csCan.getCscModel());
    canHistoryData.setCshcType(csCan.getCscType());
    // new Date(carStatus.mTime * 1000l + SYSTEM.MACHINE_TIME)
    canHistoryData.setCshcUploadTime(csCan.getCscUploadTime().getTime());
    canHistoryData.setCshcOrder(csCan.getCscOrder());
    canHistoryData.setCshcFault(csCan.getCscFault());

    // 需要更新的当前状态加入等待队列
//    ListOperations opsForList = redisTemplate.opsForList();
//    opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_INSERT_QUEUE, canHistoryData);
//    opsForList
//        .leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE, canHistoryData);
    Long startTime = System.currentTimeMillis();
    updateCanService.insertHis(canHistoryData);
    logger.info("mongo canHistoryData insert time {}",System.currentTimeMillis()-startTime);
  }

}
