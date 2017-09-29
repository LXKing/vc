package com.ccclubs.engine.rule.inf.util;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.hbase.vo.model.CarStateHistory;
import com.ccclubs.mongo.orm.model.CsHistoryState;
import com.ccclubs.pub.orm.model.CsState;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author qsxiaogang
 * @create 2017-09-25
 **/
@Component
public class HistoryStateUtils {
  @Resource
  UpdateStateService updateStateService;

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
    CarStateHistory csStateHistory=new CarStateHistory();

    csStateHistory.setAdd_time(new Date().getTime());
    csStateHistory.setCs_number(csState.getCssNumber());
    csStateHistory.setCs_host(csState.getCssHost().longValue());
    csStateHistory.setCs_access(csState.getCssAccess().intValue());
    csStateHistory.setBase_ci(String.valueOf(csState.getCssBaseCi()));
    csStateHistory.setBase_lac(String.valueOf(csState.getCssBaseLac()));
    csStateHistory.setCharging_status(csState.getCssCharging().intValue());
    csStateHistory.setCircular_mode(Integer.valueOf(csState.getCssCircular()));
    csStateHistory.setCompre_status(csState.getCssCompres().intValue());
    csStateHistory.setCur_order(String.valueOf(csState.getCssOrder()));
    csStateHistory.setCurrent_time(csState.getCssCurrentTime().getTime());
    csStateHistory.setDirection_angle(Float.valueOf(csState.getCssDir()));
    csStateHistory.setDoor_status(Integer.valueOf(csState.getCssDoor()));
    csStateHistory.setElec_miles(Float.valueOf(csState.getCssElectricMileage()));
    csStateHistory.setEndur_miles(Float.valueOf(csState.getCssEndurance()));
    csStateHistory.setEngine_status(csState.getCssEngine().intValue());
    csStateHistory.setEv_battery(csState.getCssEvBattery().floatValue());
    csStateHistory.setFan_mode(csState.getCssFan().intValue());
    csStateHistory.setFuel_miles(Float.valueOf(csState.getCssFuelMileage()));
    csStateHistory.setKey_status(csState.getCssKey().intValue());
    csStateHistory.setLight_status(csState.getCssLight());
    csStateHistory.setLock_status(csState.getCssLock());
    csStateHistory.setNet_strength(csState.getCssCsq().intValue());
    csStateHistory.setNet_type(String.valueOf(csState.getCssNetType()));
    csStateHistory.setObd_miles(csState.getCssObdMile().floatValue());
    csStateHistory.setOil_cost(Float.valueOf(csState.getCssOil()));
    csStateHistory.setPtc_status(Integer.valueOf(csState.getCssPtc()));
    csStateHistory.setRent_flg(Integer.valueOf(csState.getCssRented()));
    csStateHistory.setRfid(csState.getCssRfid());
    csStateHistory.setSaving_mode(csState.getCssSaving().intValue());
    csStateHistory.setSpeed(csState.getCssSpeed().floatValue());
    csStateHistory.setUser_rfid(csState.getCssRfidDte());
    csStateHistory.setRelate_car(csState.getCssCar().longValue());
    csStateHistory.setPower_reserve(csState.getCssPower().floatValue());
    csStateHistory.setMotor_speed(csState.getCssMotor().floatValue());
    csStateHistory.setLongitude(csState.getCssLongitude().doubleValue());
    csStateHistory.setLatitude(csState.getCssLatitude().doubleValue());
    csStateHistory.setEngine_tempe(Float.valueOf(csState.getCssEngineT()));
    csStateHistory.setTempe(Float.valueOf(csState.getCssTemperature()));
    csStateHistory.setTotal_miles(Float.valueOf(csState.getCssMileage()));
    csStateHistory.setGps_num(Integer.valueOf(csState.getCssGpsCount()));
    csStateHistory.setGps_strength(Integer.valueOf(csState.getCssGpsCn()));
    csStateHistory.setGps_valid(Integer.valueOf(csState.getCssGpsValid()));
    csStateHistory.setWarn_code(String.valueOf(csState.getCssWarn()));

    String objectJson=JSON.toJSONString(csStateHistory);
    //concurrentLinkedQueue.add(objectJson);
    HttpClientUtil.doPostJson("http://120.26.164.203:8080/carhistory/states",objectJson);

  }

}