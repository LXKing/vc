package com.ccclubs.engine.rule.inf.util;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.hbase.vo.model.CarStateHistory;
import com.ccclubs.mongo.orm.model.CsHistoryState;
import com.ccclubs.pub.orm.model.CsState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author qsxiaogang
 * @create 2017-09-25
 **/
@Component
public class HistoryStateUtils extends ConvertUtils {

  @Resource
  private RedisTemplate redisTemplate;
  @Autowired
  UpdateStateService updateStateService;

  @Value("${ccclubs.data.batch.hbaseSrv.host:127.0.0.1}")
  private String ip;
  @Value("${ccclubs.data.batch.hbaseSrv.port:8080}")
  private String port;

  private static Logger logger = LoggerFactory.getLogger(HistoryStateUtils.class);
  //private static ConcurrentLinkedQueue concurrentLinkedQueue=new ConcurrentLinkedQueue();

  public void saveHistoryData(CsState csState) {
    // TODO:需要判断是否使用Hbase进行存储
//    if ()
//    saveHistoryDataToHbase(csState);
//    return;

    CsHistoryState historyState = new CsHistoryState();

    historyState.setCshsAccess(csState.getCssAccess().intValue());
    historyState.setCshsHost(csState.getCssHost().intValue());
    historyState.setCshsCar(csState.getCssCar());

    historyState.setCshsNumber(csState.getCssNumber());
    historyState.setCshsWarn(csState.getCssWarn());
    historyState.setCshsPower(csState.getCssPower());
    historyState.setCshsLongitude(csState.getCssLongitude());
    historyState.setCshsLatitude(csState.getCssLatitude());
    historyState.setCshsCsq(csState.getCssCsq());
    historyState.setCshsCurrentTime(csState.getCssCurrentTime().getTime());
    historyState.setCshsDir(csState.getCssDir());
    historyState.setCshsAddTime(System.currentTimeMillis());
    historyState.setCshsMileage(csState.getCssMileage());
    historyState.setCshsOrder(csState.getCssOrder());
    historyState.setCshsTemperature(csState.getCssTemperature());
    historyState.setCshsEngineT(csState.getCssEngineT());
    historyState.setCshsOil(csState.getCssOil());
    historyState.setCshsRented(csState.getCssRented());
    historyState.setCshsPower(csState.getCssPower());
    historyState.setCshsFuelMileage(csState.getCssFuelMileage());
    historyState.setCshsElectricMileage(csState.getCssElectricMileage());

    historyState.setCshsCircular(csState.getCssCircular());
    historyState.setCshsPtc(csState.getCssPtc());
    historyState.setCshsCompres(csState.getCssCompres());
    historyState.setCshsFan(csState.getCssFan());
    historyState.setCshsSaving(csState.getCssSaving());
    historyState.setCshsDoor(String.valueOf(csState.getCssDoor()));

    historyState.setCshsEngine(csState.getCssEngine());
    historyState.setCshsKey(csState.getCssKey());
    historyState.setCshsLight(csState.getCssLight());
    historyState.setCshsLock(csState.getCssLock());

    // TODO:依据车型Can解析
    historyState.setCshsObdMile(csState.getCssObdMile());
    historyState.setCshsSpeed(csState.getCssSpeed());
    historyState.setCshsEndurance(csState.getCssEndurance());
    historyState.setCshsMotor(csState.getCssMotor());
    historyState.setCshsEvBattery(csState.getCssEvBattery());
    historyState.setCshsCharging(csState.getCssCharging());
    historyState.setCshsMoData(csState.getCssMoData());

    historyState.setCshsGpsValid(csState.getCssGpsValid());
    historyState.setCshsGpsCn(csState.getCssGpsCn());
    historyState.setCshsGpsCount(csState.getCssGpsCount());

    // 需要更新的当前状态加入等待队列
    ListOperations opsForList = redisTemplate.opsForList();
//    opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_INSERT_QUEUE, historyState);
    updateStateService.insertHis(historyState);
    opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE, csState);
  }


  public void saveHistoryDataToHbase(List<CsState> csStateList){
    List<CarStateHistory> carStateHistoryList=dealCsStateListToCarStateHistoryLsit(csStateList);
    if(null==carStateHistoryList||carStateHistoryList.size()<1){
      logger.warn("carStateHistoryList is null! nothing history state date saved");
      return ;
    }
    String sourceJson = JSON.toJSONString(csStateList);
    String objectJson = JSON.toJSONString(carStateHistoryList);
    logger.debug("source: {} ,target: {}",sourceJson,objectJson);
    //concurrentLinkedQueue.add(objectJson);
    logger.debug("deal csState list json done:" + objectJson);
    String url="http://"+ip+":"+port+"/carhistory/states";
    HttpClientUtil.doPostJson(url, objectJson);
    logger.debug("send post for csStateList !");

  }


  public void saveHistoryDataToHbase(CsState csState) {

    CarStateHistory csStateHistory=dealCsStateToCarStateHistory(csState);
    String objectJson = JSON.toJSONString(csStateHistory);
    //concurrentLinkedQueue.add(objectJson);
    logger.debug("deal csState data json done:" + objectJson);
    String url="http://"+ip+":"+port+"/carhistory/state";
    HttpClientUtil.doPostJson(url, objectJson);
    logger.debug("send post for csState !");
  }


  public List<CarStateHistory> dealCsStateListToCarStateHistoryLsit(List<CsState> csStateList){
    if(null==csStateList||csStateList.size()<1){
      logger.warn("csStateList is null!");
      return null;
    }
    List<CarStateHistory> carStateHistoryList=new ArrayList<>();
    for (int i=0;i<csStateList.size();i++){
      carStateHistoryList.add(dealCsStateToCarStateHistory(csStateList.get(i)));
    }
    return  carStateHistoryList;
  }


  public CarStateHistory dealCsStateToCarStateHistory(CsState csState){
    if (null == csState) {
      return null;
    }

    CarStateHistory csStateHistory = new CarStateHistory();

    csStateHistory.setAdd_time(System.currentTimeMillis());
    csStateHistory.setCs_number(csState.getCssNumber());

    csStateHistory.setCs_host(convertToLong(csState.getCssHost()));
    csStateHistory.setCs_access(convertToInterger(csState.getCssAccess()));
    csStateHistory.setBase_ci(convertToString(csState.getCssBaseCi()));
    csStateHistory.setBase_lac(convertToString(csState.getCssBaseLac()));
    csStateHistory.setCharging_status(convertToInterger(csState.getCssCharging()));
    csStateHistory.setCircular_mode(convertToInterger(csState.getCssCircular()));
    csStateHistory.setCompre_status(convertToInterger(csState.getCssCompres()));
    csStateHistory.setCur_order(convertToString(csState.getCssOrder()));
    if (null != csState.getCssCurrentTime()) {
      csStateHistory.setCurrent_time(csState.getCssCurrentTime().getTime());
    }
    csStateHistory.setDirection_angle(convertToFloat(csState.getCssDir()));
    csStateHistory.setDoor_status(convertToInterger(csState.getCssDoor()));
    csStateHistory.setElec_miles(convertToFloat(csState.getCssElectricMileage()));
    csStateHistory.setEndur_miles(convertToFloat(csState.getCssEndurance()));

    csStateHistory.setEngine_status(convertToInterger(csState.getCssEngine()));
    csStateHistory.setEv_battery(convertToFloat(csState.getCssEvBattery()));
    csStateHistory.setFan_mode(convertToInterger(csState.getCssFan()));
    csStateHistory.setFuel_miles(convertToFloat(csState.getCssFuelMileage()));
    csStateHistory.setKey_status(convertToInterger(csState.getCssKey()));
    csStateHistory.setLight_status(csState.getCssLight());
    csStateHistory.setLock_status(csState.getCssLock());
    csStateHistory.setNet_strength(convertToInterger(csState.getCssCsq()));
    csStateHistory.setNet_type(convertToString(csState.getCssNetType()));
    csStateHistory.setObd_miles(convertToFloat(csState.getCssObdMile()));
    csStateHistory.setOil_cost(convertToFloat(csState.getCssOil()));
    csStateHistory.setPtc_status(convertToInterger(csState.getCssPtc()));
    csStateHistory.setRent_flg(convertToInterger(csState.getCssRented()));
    csStateHistory.setRfid(csState.getCssRfid());
    csStateHistory.setSaving_mode(convertToInterger(csState.getCssSaving()));
    csStateHistory.setSpeed(convertToFloat(csState.getCssSpeed()));
    csStateHistory.setUser_rfid(csState.getCssRfidDte());
    csStateHistory.setRelate_car(convertToLong(csState.getCssCar()));
    csStateHistory.setPower_reserve(convertToFloat(csState.getCssPower()));
    csStateHistory.setMotor_speed(convertToFloat(csState.getCssMotor()));
    csStateHistory.setLongitude(convertToDouble(csState.getCssLongitude()));
    csStateHistory.setLatitude(convertToDouble(csState.getCssLatitude()));
    csStateHistory.setEngine_tempe(convertToFloat(csState.getCssEngineT()));
    csStateHistory.setTempe(convertToFloat(csState.getCssTemperature()));
    csStateHistory.setTotal_miles(convertToFloat(csState.getCssMileage()));
    csStateHistory.setGps_num(convertToInterger(csState.getCssGpsCount()));
    csStateHistory.setGps_strength(convertToInterger(csState.getCssGpsCn()));
    csStateHistory.setGps_valid(convertToInterger(csState.getCssGpsValid()));
    csStateHistory.setWarn_code(convertToString(csState.getCssWarn()));

    return  csStateHistory;
  }



}
