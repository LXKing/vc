package com.ccclubs.phoenix.tasks.processor;

import com.ccclubs.phoenix.inf.CarCanHistoryInf;
import com.ccclubs.phoenix.orm.model.CarCan;
import com.ccclubs.phoenix.tasks.model.CsHistoryCan;
import com.ccclubs.phoenix.tasks.util.RedisConstant;
import com.ccclubs.pub.orm.model.CsCan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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

//  @Reference(version = "1.0.0")
  @Autowired
  private CarCanHistoryInf carCanHistoryInf;
  /*@Value("${ccclubs.data.batch.hbaseSrv.host:127.0.0.1}")
  private String ip;
  @Value("${ccclubs.data.batch.hbaseSrv.port:8080}")
  private String port;
  @Value("${ccclubs.data.batch.hbaseSrv.urlRootPath:history}")
  private String urlRootPath;*/

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
//    opsForList.leftPush(RedisConstant.REDIS_KEY_HISTORY_CAN_INSERT_QUEUE, canHistoryData);
//    opsForList
//        .leftPush(RedisConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE, canHistoryData);
// add at 2017-12-20 历史数据不写 mongodb
//    updateCanService.insertHis(canHistoryData);
    ListOperations opsForList = redisTemplate.opsForList();
    opsForList.leftPush(RedisConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE, csCan);
  }

  public void saveHistoryDataToHbase(CsCan csCan){
    CarCan carCanHistory=dealCsCanToCarCanHistory(csCan);
    /*String objectJson = JSON.toJSONString(carCanHistory);
    //concurrentLinkedQueue.add(objectJson);
    logger.debug("deal can data json is done:" + objectJson);
    String url="http://"+ip+":"+port+"/"+urlRootPath+"/can";
    HttpClientUtil.doPostJson(url, objectJson);
    logger.debug("send post for can !");*/
  }

  public void saveHistoryDataToHbase(List<CsCan> csCanList){
    logger.info("准备转换can数据");
    if (null==csCanList||csCanList.size()<1){
      logger.warn("csCanList is null!");
      return;
    }
    List<CarCan> carCanHistoryList=dealCsCanListToCarCanHistoryList(csCanList);
    logger.info("即将存储can数据");
    carCanHistoryInf.saveOrUpdate(carCanHistoryList);
    logger.info("存储can数据完成");
    /*String objectJson = JSON.toJSONString(carCanHistoryList);
    //concurrentLinkedQueue.add(objectJson);
    logger.debug("deal can list json is done:" + objectJson);
    String url="http://"+ip+":"+port+"/"+urlRootPath+"/cans";
    HttpClientUtil.doPostJson(url, objectJson);
    logger.debug("send post for can list !");*/
  }

  public List<CarCan> dealCsCanListToCarCanHistoryList(List<CsCan> csCanList){
    if (null==csCanList||csCanList.size()<1){
      return null;
    }
    List<CarCan> carCanHistoryList=new ArrayList<>();
    for (CsCan csCan:csCanList){
      carCanHistoryList.add(dealCsCanToCarCanHistory(csCan));
    }
    return carCanHistoryList;
  }

  public CarCan dealCsCanToCarCanHistory(CsCan csCan){
    if (null==csCan){return null;}
    CarCan carCanHistory=new CarCan();

    carCanHistory.setAdd_time(csCan.getCscAddTime()==null?System.currentTimeMillis():csCan.getCscAddTime().getTime());
    carCanHistory.setCs_number(csCan.getCscNumber());
    //carCanHistory.setCs_vin();
    carCanHistory.setCan_data(csCan.getCscData());
    carCanHistory.setCurrent_time(csCan.getCscUploadTime().getTime());
//    carCanHistory.setBegin_time();
//    carCanHistory.setEnd_time();
    return carCanHistory;
  }


}
