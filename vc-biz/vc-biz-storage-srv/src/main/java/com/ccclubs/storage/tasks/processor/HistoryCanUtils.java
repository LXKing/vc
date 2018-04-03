package com.ccclubs.storage.tasks.processor;

import com.ccclubs.phoenix.orm.model.CarCan;
import com.ccclubs.pub.orm.model.CsCan;
import com.ccclubs.storage.impl.PhoenixStorageService;
import com.ccclubs.storage.inf.BaseHbaseStorageInf;
import com.ccclubs.storage.tasks.model.CsHistoryCan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qsxiaogang
 * @create 2017-10-11
 **/
@Component
public class HistoryCanUtils extends ConvertUtils implements BaseHbaseStorageInf<CsCan> {

  private static Logger logger = LoggerFactory.getLogger(HistoryCanUtils.class);

  @Autowired
  private PhoenixStorageService phoenixStorageService;


  @Override
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

//    ListOperations opsForList = redisTemplate.opsForList();
//    opsForList.leftPush(RedisConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE, csCan);
  }

  @Override
  public void saveHistoryDataToHbase(CsCan csCan){
    CarCan carCanHistory=dealCsCanToCarCanHistory(csCan);

  }

  @Override
  public void saveHistoryDataToHbase(List<CsCan> csCanList){
    logger.debug("准备转换can数据");
    if (null==csCanList||csCanList.size()<1){
      logger.warn("csCanList is null!");
      return;
    }
    List<CarCan> carCanHistoryList=dealCsCanListToCarCanHistoryList(csCanList);
    logger.debug("即将存储can数据");
    phoenixStorageService.saveOrUpdate(carCanHistoryList);
    logger.debug("存储can数据完成");

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
