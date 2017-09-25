package com.ccclubs.engine.rule.inf.util;

import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.mongo.orm.model.CsHistoryState;
import com.ccclubs.pub.orm.model.CsState;
import java.util.Date;
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
}
