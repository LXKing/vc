package com.ccclubs.storage.tasks.processor;


import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.storage.impl.PhoenixStorageService;
import com.ccclubs.storage.inf.BaseHbaseStorageInf;
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
    if(null!=csState.getCssDir()) {
      csStateHistory.setDirection_angle(csState.getCssDir().floatValue());
    }
    if(null!=csState.getCssFuelMileage()) {
      csStateHistory.setFuel_miles(csState.getCssFuelMileage().floatValue());
    }
    if(null!=csState.getCssElectricMileage())
    {
      csStateHistory.setElec_miles(csState.getCssElectricMileage().floatValue());
    }
    if(null!=csState.getCssEndurance()) {
      csStateHistory.setEndur_miles(csState.getCssEndurance().floatValue());
    }
    if(null!=csState.getCssOil()) {
      csStateHistory.setOil_cost(csState.getCssOil().floatValue());
    }
    if(null!=csState.getCssSpeed()) {
      csStateHistory.setSpeed(csState.getCssSpeed().floatValue());
    }
    if(null!=csState.getCssEngineT()) {
      csStateHistory.setEngine_tempe(csState.getCssEngineT().floatValue());
    }
    if(null!=csState.getCssTemperature()) {
      csStateHistory.setTempe(csState.getCssTemperature().floatValue());
    }
    if(null!=csState.getCssMileage()) {
      csStateHistory.setTotal_miles(csState.getCssMileage().floatValue());
    }


    csStateHistory.setGear(convertToInterger(csState.getCssGear()));
    csStateHistory.setEngine_status(convertToInterger(csState.getCssEngine()));
    csStateHistory.setEv_battery(convertToFloat(csState.getCssEvBattery()));
    csStateHistory.setFan_mode(convertToInterger(csState.getCssFan()));
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
    csStateHistory.setDoor_status(convertToInterger(csState.getCssDoor()));
    csStateHistory.setPtc_status(convertToInterger(csState.getCssPtc()));
    csStateHistory.setRent_flg(convertToInterger(csState.getCssRented()));
    csStateHistory.setRfid(csState.getCssRfid());
    csStateHistory.setSaving_mode(convertToInterger(csState.getCssSaving()));

    csStateHistory.setUser_rfid(csState.getCssRfidDte());
    //csStateHistory.setRelate_car(convertToLong(csState.getCssCar()));
    csStateHistory.setPower_reserve(convertToFloat(csState.getCssPower()));
    csStateHistory.setMotor_speed(convertToFloat(csState.getCssMotor()));
    csStateHistory.setLongitude(convertToDouble(csState.getCssLongitude()));
    csStateHistory.setLatitude(convertToDouble(csState.getCssLatitude()));

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
