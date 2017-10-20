package com.ccclubs.engine.rule.inf.util;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.hbase.vo.model.CarCanHistory;
import com.ccclubs.mongo.orm.model.CsHistoryCan;
import com.ccclubs.pub.orm.model.CsCan;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

  @Value("${ccclubs.data.batch.hbaseSrv.host:127.0.0.1}")
  private String ip;
  @Value("${ccclubs.data.batch.hbaseSrv.port:8080}")
  private String port;

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
    updateCanService.insertHis(canHistoryData);
    ListOperations opsForList = redisTemplate.opsForList();
    opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE, csCan);
  }

  public void saveHistoryDataToHbase(CsCan csCan){
    CarCanHistory carCanHistory=dealCsCanToCarCanHistory(csCan);
    String objectJson = JSON.toJSONString(carCanHistory);
    //concurrentLinkedQueue.add(objectJson);
    logger.info("deal can data json is done:" + objectJson);
    String url="http://"+ip+":"+port+"/carhistory/can";
    HttpClientUtil.doPostJson(url, objectJson);
    logger.info("send post for can !");
  }

  public void saveHistoryDataToHbase(List<CsCan> csCanList){
    if (null==csCanList||csCanList.size()<1){
      logger.warn("csCanList is null!");
      return;
    }
    List<CarCanHistory> carCanHistoryList=dealCsCanListToCarCanHistoryList(csCanList);
    String objectJson = JSON.toJSONString(carCanHistoryList);
    //concurrentLinkedQueue.add(objectJson);
    logger.info("deal can list json is done:" + objectJson);
    String url="http://"+ip+":"+port+"/carhistory/cans";
    HttpClientUtil.doPostJson(url, objectJson);
    logger.info("send post for can list !");
  }

  public List<CarCanHistory> dealCsCanListToCarCanHistoryList(List<CsCan> csCanList){
    if (null==csCanList||csCanList.size()<1){
      return null;
    }
    List<CarCanHistory> carCanHistoryList=new ArrayList<>();
    for (CsCan csCan:csCanList){
      carCanHistoryList.add(dealCsCanToCarCanHistory(csCan));
    }
    return carCanHistoryList;
  }

  public CarCanHistory dealCsCanToCarCanHistory(CsCan csCan){
    if (null==csCan){return null;}
    CarCanHistory carCanHistory=new CarCanHistory();
    carCanHistory.setAdd_time(csCan.getCscAddTime().getTime());
    carCanHistory.setCs_number(csCan.getCscNumber());
    //carCanHistory.setCs_vin();
    carCanHistory.setCan_data(csCan.getCscData());
    carCanHistory.setCurrent_time(csCan.getCscUploadTime().getTime());
//    carCanHistory.setBegin_time();
//    carCanHistory.setEnd_time();
    return carCanHistory;
  }


}
