package com.ccclubs.engine.rule.inf.util;

import com.ccclubs.protocol.dto.mqtt.MQTT_66;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.transform.TerminalStatus;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by qsxiaogang on 2017/6/17.
 **/
@Component
public class TransformUtils {
    /**
     * 把状态数据转换成对外输出的JSON数据
     */
    public TerminalStatus transform2TerminalStatus(String teNo, String vin, MQTT_66 mqtt_66,
                                                          MqMessage message) {
        TerminalStatus terminalStatus = new TerminalStatus();
        terminalStatus.setCssVin(vin);
        terminalStatus.setCssNetType(mqtt_66.getNetType() & 0xFF);
        terminalStatus.setCssBaseCI(mqtt_66.getBaseCI());
        terminalStatus.setCssBaseLAC(mqtt_66.getBaseLAC());
        terminalStatus
                .setCssCurrentTime(mqtt_66.getTime());
        terminalStatus.setCssCharging(mqtt_66.getCharging() & 0xFF);
        terminalStatus.setCssCircular(mqtt_66.getAirConditionerCircular());
        terminalStatus.setCssGpsCn(mqtt_66.getCn() & 0xFF);
        terminalStatus.setCssCompres(mqtt_66.getAirConditionerCompres());
        terminalStatus.setCssCsq(mqtt_66.getCsq() & 0xFF);
        terminalStatus.setCssDir(mqtt_66.getHeading() & 0xFFFF);
        terminalStatus
                .setCssDoor(mqtt_66.getDoorStatus());
        // TODO:燃油量
        if (MQTT_66.MODEL_STATUS_ELECTRICITY == message.getFucCode()) {
            terminalStatus.setCssOil(0);
            terminalStatus.setCssEndurance(mqtt_66.getEndurance() & 0xFFFF);
        } else {
            terminalStatus.setCssOil(mqtt_66.getEndurance() & 0xFFFF);
            terminalStatus.setCssEndurance(0);
        }
        terminalStatus.setCssEngineT(mqtt_66.getEngineTemperature() & 0xFF);
        terminalStatus.setCssEvBattery(mqtt_66.getSoc() & 0xFF);
        terminalStatus.setCssFan(mqtt_66.getAirConditionerFan());
//    terminalStatus.setCssGPSValid((int) mqtt_66.getGpsValid());

        BigDecimal bigDecimalLatitude = AccurateOperationUtils
                .add(mqtt_66.getLatitude(), mqtt_66.getLatitudeDecimal() * 0.000001);

        BigDecimal bigDecimalLongitude = AccurateOperationUtils
                .add(mqtt_66.getLongitude(), mqtt_66.getLongitudeDecimal() * 0.000001);

        terminalStatus.setCssLatitude(bigDecimalLatitude.setScale(6, BigDecimal.ROUND_HALF_UP));
        terminalStatus
                .setCssLongitude(bigDecimalLongitude.setScale(6, BigDecimal.ROUND_HALF_UP));
        terminalStatus.setCssMotor(mqtt_66.getRpm() & 0xFFFF);
        terminalStatus.setCssNumber(teNo.trim().toUpperCase());
        terminalStatus.setCssObdMile(mqtt_66.getObdMiles() & 0xFFFFFFFF);
        terminalStatus.setCssOrder(message.getTransId());
        terminalStatus.setCssPower(mqtt_66.getBattery() & 0xFFFF);
        terminalStatus.setCssPtc(mqtt_66.getAirConditionerPtc());
        terminalStatus.setCssRented(mqtt_66.getCarStatus() & 0xFF);
        terminalStatus.setCssGpsCount(mqtt_66.getSatelliteCount() & 0xFF);
        terminalStatus.setCssGPSValid(mqtt_66.getSatelliteEffective() & 0xFF);
        terminalStatus.setCssSaving(mqtt_66.getSavingModel());
        terminalStatus.setCssSpeed(mqtt_66.getSpeed());
        terminalStatus.setCssTemperature(mqtt_66.getTemperature() & 0xFF);
        terminalStatus.setCssVehicleSleepTime(mqtt_66.getVehicleSleepTime() & 0xFFFF);
        terminalStatus.setCssVehicleStatus(mqtt_66.getVehicleStartStatus() & 0xFF);
        terminalStatus.setCssVehicleStaus(mqtt_66.getVehicleStartStatus() & 0xFF);
//    terminalStatus.setCssGear(mqtt_66.getGear());

        return terminalStatus;
    }
}
