package com.ccclubs.engine.rule.inf.util;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.hbase.vo.model.CarStateHistory;
import com.ccclubs.mongo.orm.model.CsHistoryState;
import com.ccclubs.pub.orm.model.CsState;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author qsxiaogang
 * @create 2017-09-25
 **/
@Component
public class HistoryStateUtils extends ConvertUtils{
  @Resource
  UpdateStateService updateStateService;
  private static Logger logger= LoggerFactory.getLogger(HistoryStateUtils.class);
  //private static ConcurrentLinkedQueue concurrentLinkedQueue=new ConcurrentLinkedQueue();

  public void saveHistoryData(CsState csState) {
    CsHistoryState historyState = new CsHistoryState();

    historyState.setCshsAccess(csState.getCssAccess().intValue());
    historyState.setCshsHost(csState.getCssHost().intValue());
    historyState.setCshsCar(csState.getCssCar().intValue());

    historyState.setCshsNumber(csState.getCssNumber());
    historyState.setCshsWarn(String.valueOf(csState.getCssWarn()));
    historyState.setCshsPower(String.valueOf(csState.getCssPower()));
    historyState.setCshsLongitude(String.valueOf(csState.getCssLongitude()));
    historyState.setCshsLatitude(String.valueOf(csState.getCssLatitude()));
    historyState.setCshsCsq(String.valueOf(csState.getCssCsq()));
    historyState.setCshsCurrentTime(csState.getCssCurrentTime());
    historyState.setCshsDir(String.valueOf(csState.getCssDir()));
    historyState.setCshsAddTime(new Date());
    historyState.setCshsMileage(String.valueOf(csState.getCssMileage()));
    historyState.setCshsOrder(String.valueOf(csState.getCssOrder()));
    historyState.setCshsTemperature(String.valueOf(csState.getCssTemperature()));
    historyState.setCshsEngineT(String.valueOf(csState.getCssEngineT()));
    historyState.setCshsOil(String.valueOf(csState.getCssOil()));
    historyState.setCshsRented(String.valueOf(csState.getCssRented()));
    historyState.setCshsPower(String.valueOf(csState.getCssPower()));
    historyState.setCshsFuelMileage(String.valueOf(csState.getCssFuelMileage()));
    historyState.setCshsElectricMileage(String.valueOf(csState.getCssElectricMileage()));

    historyState.setCshsCircular(String.valueOf(csState.getCssCircular()));
    historyState.setCshsPtc(String.valueOf(csState.getCssPtc()));
    historyState.setCshsCompres(String.valueOf(csState.getCssCompres()));
    historyState.setCshsFan(String.valueOf(csState.getCssFan()));
    historyState.setCshsSaving(String.valueOf(csState.getCssSaving()));
    historyState.setCshsDoor(String.valueOf(csState.getCssDoor()));

    historyState.setCshsEngine(csState.getCssEngine().longValue());
    historyState.setCshsKey(csState.getCssKey().longValue());
    historyState.setCshsLight(csState.getCssLight().longValue());
    historyState.setCshsLock(csState.getCssLock().longValue());

    // TODO:依据车型Can解析
    historyState.setCshsObdMile(String.valueOf(csState.getCssObdMile()));
    historyState.setCshsSpeed(String.valueOf(csState.getCssSpeed()));
    historyState.setCshsEndurance(String.valueOf(csState.getCssEndurance()));
    historyState.setCshsMotor(String.valueOf(csState.getCssMotor()));
    historyState.setCshsEvBattery(String.valueOf(csState.getCssEvBattery()));
    historyState.setCshsCharging(String.valueOf(csState.getCssCharging()));
    historyState.setCshsMoData(csState.getCssMoData());

    historyState.setCshsGpsValid(Integer.valueOf(csState.getCssGpsValid()));
    historyState.setCshsGpsCn(Integer.valueOf(csState.getCssGpsCn()));
    historyState.setCshsGpsCount(Integer.valueOf(csState.getCssGpsCount()));
    updateStateService.insertHis(historyState);
  }




  public void saveHistoryDataToHbase(CsState csState) {
    if (null==csState) return;

    CarStateHistory csStateHistory=new CarStateHistory();

    csStateHistory.setAdd_time(new Date().getTime());
    csStateHistory.setCs_number(csState.getCssNumber());

    csStateHistory.setCs_host(convertToLong(csState.getCssHost()));
    csStateHistory.setCs_access(convertToInterger(csState.getCssAccess()));
    csStateHistory.setBase_ci(convertToString(csState.getCssBaseCi()));
    csStateHistory.setBase_lac(convertToString(csState.getCssBaseLac()));
    csStateHistory.setCharging_status(convertToInterger(csState.getCssCharging()));
    csStateHistory.setCircular_mode(convertToInterger(csState.getCssCircular()));
    csStateHistory.setCompre_status(convertToInterger(csState.getCssCompres()));
    csStateHistory.setCur_order(convertToString(csState.getCssOrder()));
    if (null!=csState.getCssCurrentTime()){
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

    String objectJson=JSON.toJSONString(csStateHistory);
    //concurrentLinkedQueue.add(objectJson);
    logger.debug("deal json is ok!" +objectJson);
    HttpClientUtil.doPostJson("http://120.26.164.203:8080/carhistory/states",objectJson);
    logger.debug("send post !");
  }

}
