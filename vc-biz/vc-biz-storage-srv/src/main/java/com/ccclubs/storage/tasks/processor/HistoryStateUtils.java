package com.ccclubs.storage.tasks.processor;


import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.storage.impl.PhoenixStorageService;
import com.ccclubs.storage.inf.BaseHbaseStorageInf;
import com.ccclubs.storage.tasks.model.CsHistoryState;
import com.ccclubs.pub.orm.model.CsState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qsxiaogang
 * @create 2017-09-25
 **/
@Component
public class HistoryStateUtils extends ConvertUtils implements BaseHbaseStorageInf<CsState> {

  /*排除问题的代码请记得及时清理。
  private static Set<String> csNumberSet=new HashSet(){{
    add("T6792320");
    add("T6710126");
    add("T67D1205");
    add("T67E2300");
    add("T67D1110");
    add("GB005403");
    add("T6402162");
  }};*/


  @Autowired
  private PhoenixStorageService phoenixStorageService;


  private static final Logger logger = LoggerFactory.getLogger(HistoryStateUtils.class);

  //private static final Logger loggerBusiness = VehicleControlLogger.getLogger();

  @Override
  public void saveHistoryData(CsState csState) {


    CsHistoryState historyState = new CsHistoryState();

    historyState.setCshsAccess(csState.getCssAccess().intValue());
    historyState.setCshsHost(csState.getCssHost().intValue());
    historyState.setCshsCar(csState.getCssCar());
    historyState.setCshsGear(csState.getCssGear().intValue());
    historyState.setCshsNumber(csState.getCssNumber());
    historyState.setCshsWarn(csState.getCssWarn());
    historyState.setCshsPower(csState.getCssPower());
    historyState.setCshsLongitude(csState.getCssLongitude());
    historyState.setCshsLatitude(csState.getCssLatitude());
    historyState.setCshsCsq(csState.getCssCsq());
    historyState.setCshsCurrentTime(csState.getCssCurrentTime().getTime());
    historyState.setCshsDir(csState.getCssDir().toString());
    historyState.setCshsAddTime(System.currentTimeMillis());
    historyState.setCshsMileage(csState.getCssMileage().intValue());
    historyState.setCshsOrder(csState.getCssOrder());
    historyState.setCshsTemperature(csState.getCssTemperature().shortValue());
    historyState.setCshsEngineT(csState.getCssEngineT().intValue());
    historyState.setCshsOil(csState.getCssOil().toString());
    historyState.setCshsRented(csState.getCssRented());
    historyState.setCshsPower(csState.getCssPower());
    historyState.setCshsFuelMileage(csState.getCssFuelMileage().toString());
    historyState.setCshsElectricMileage(csState.getCssElectricMileage().toString());

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

    historyState.setCshsObdMile(csState.getCssObdMile().intValue());
    historyState.setCshsSpeed(csState.getCssSpeed().shortValue());
    historyState.setCshsEndurance(csState.getCssEndurance().toString());
    historyState.setCshsMotor(csState.getCssMotor());
    historyState.setCshsEvBattery(csState.getCssEvBattery());
    historyState.setCshsCharging(csState.getCssCharging());
    historyState.setCshsMoData(csState.getCssMoData());

    historyState.setCshsGpsValid(csState.getCssGpsValid());
    historyState.setCshsGpsCn(csState.getCssGpsCn());
    historyState.setCshsGpsCount(csState.getCssGpsCount());

    // 需要更新的当前状态加入等待队列
//    ListOperations opsForList = redisTemplate.opsForList();
//    opsForList.leftPush(RedisConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE, csState);
  }


  @Override
  public void saveHistoryDataToHbase(List<CsState> csStateList){
    logger.debug("即将转换一批历史数据到csState");
    List<CarState> carStateHistoryList=dealCsStateListToCarStateHistoryLsit(csStateList);
    if(null==carStateHistoryList||carStateHistoryList.size()<1){
      logger.warn("carStateHistoryList is null! nothing history state date saved");
      return ;
    }
    logger.debug("现在正在准备写入一批CsState");

    phoenixStorageService.saveOrUpdate(carStateHistoryList);
    logger.debug("现在已经写入一批CsState");

  }


  @Override
  public void saveHistoryDataToHbase(CsState csState) {
//    CarState csStateHistory=dealCsStateToCarStateHistory(csState);
  }


  public List<CarState> dealCsStateListToCarStateHistoryLsit(List<CsState> csStateList){
    if(null==csStateList||csStateList.size()<1){
      logger.warn("csStateList is null!");
      return null;
    }
    List<CarState> carStateHistoryList=new ArrayList<>();
    for (int i=0;i<csStateList.size();i++){
      carStateHistoryList.add(dealCsStateToCarStateHistory(csStateList.get(i)));
    }
    return  carStateHistoryList;
  }


  public CarState dealCsStateToCarStateHistory(CsState csState){
    if (null == csState) {
      return null;
    }

    CarState csStateHistory = new CarState();

    if (null==csState.getCssAddTime()){
      csStateHistory.setAdd_time(System.currentTimeMillis());
    }else {
      csStateHistory.setAdd_time(csState.getCssAddTime().getTime());
    }
    csStateHistory.setCs_number(csState.getCssNumber());

    //csStateHistory.setCs_host(convertToLong(csState.getCssHost()));
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
    csStateHistory.setDirection_angle(csState.getCssDir().floatValue());
    csStateHistory.setDoor_status(convertToInterger(csState.getCssDoor()));
    csStateHistory.setElec_miles(csState.getCssElectricMileage().floatValue());
    csStateHistory.setEndur_miles(csState.getCssEndurance().floatValue());
    csStateHistory.setGear(convertToInterger(csState.getCssGear()));
    csStateHistory.setEngine_status(convertToInterger(csState.getCssEngine()));
    csStateHistory.setEv_battery(convertToFloat(csState.getCssEvBattery()));
    csStateHistory.setFan_mode(convertToInterger(csState.getCssFan()));
    csStateHistory.setFuel_miles(csState.getCssFuelMileage().floatValue());
    csStateHistory.setKey_status(convertToInterger(csState.getCssKey()));
    csStateHistory.setLight_status(csState.getCssLight());
    csStateHistory.setLock_status(csState.getCssLock());
    csStateHistory.setNet_strength(convertToInterger(csState.getCssCsq()));
    csStateHistory.setNet_type(convertToString(csState.getCssNetType()));
    if(null==csState.getCssObdMile()){
      csStateHistory.setObd_miles(0f);
    }else {
      csStateHistory.setObd_miles(csState.getCssObdMile().floatValue());
    }
    csStateHistory.setOil_cost(csState.getCssOil().floatValue());
    csStateHistory.setPtc_status(convertToInterger(csState.getCssPtc()));
    csStateHistory.setRent_flg(convertToInterger(csState.getCssRented()));
    csStateHistory.setRfid(csState.getCssRfid());
    csStateHistory.setSaving_mode(convertToInterger(csState.getCssSaving()));
    csStateHistory.setSpeed(csState.getCssSpeed().floatValue());
    csStateHistory.setUser_rfid(csState.getCssRfidDte());
    //csStateHistory.setRelate_car(convertToLong(csState.getCssCar()));
    csStateHistory.setPower_reserve(convertToFloat(csState.getCssPower()));
    csStateHistory.setMotor_speed(convertToFloat(csState.getCssMotor()));
    csStateHistory.setLongitude(convertToDouble(csState.getCssLongitude()));
    csStateHistory.setLatitude(convertToDouble(csState.getCssLatitude()));
    csStateHistory.setEngine_tempe(csState.getCssEngineT().floatValue());
    csStateHistory.setTempe(csState.getCssTemperature().floatValue());
    csStateHistory.setTotal_miles(csState.getCssMileage().floatValue());
    csStateHistory.setGps_num(convertToInterger(csState.getCssGpsCount()));
    csStateHistory.setGps_strength(convertToInterger(csState.getCssGpsCn()));
    csStateHistory.setGps_valid(convertToInterger(csState.getCssGpsValid()));
    csStateHistory.setWarn_code(convertToString(csState.getCssWarn()));

    csStateHistory.setAutopilot_status(csState.getCssAutopilot());
    csStateHistory.setHandbrake_status(csState.getCssHandbrake());
    /*if (csNumberSet.contains(csStateHistory.getCs_number())){
      loggerBusiness.info(JSON.toJSONString(csStateHistory));
    }*/
    return  csStateHistory;
  }



}
