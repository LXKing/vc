package com.ccclubs.engine.rule.inf.util;

import com.ccclubs.common.aop.Timer;
import com.ccclubs.protocol.dto.mqtt.MQTT_66;
import com.ccclubs.protocol.dto.mqtt.MQTT_68_03;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.transform.TerminalStatus;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsState;
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
    public static TerminalStatus transform2TerminalStatus(CsMachine csMachine, String vin,
        MQTT_66 mqtt_66,
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
        terminalStatus.setCssDoor(mqtt_66.getDoorStatus());
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
        terminalStatus.setCssNumber(StringUtils.empty(csMachine.getCsmTeNo()) ? ""
            : csMachine.getCsmTeNo().trim().toUpperCase());
        terminalStatus.setCssObdMile(mqtt_66.getObdMiles() & 0xFFFFFFFF);
        terminalStatus.setCssMileage(mqtt_66.getMiles() & 0xFFFFFFFF);
        terminalStatus.setCssOrder(message.getTransId());
        terminalStatus.setCssPower(mqtt_66.getBattery() & 0xFFFF);
        terminalStatus.setCssPtc(mqtt_66.getAirConditionerPtc());
        terminalStatus.setCssRented(mqtt_66.getCarStatus() & 0xFF);
        terminalStatus.setCssGpsCount(mqtt_66.getSatelliteCount() & 0xFF);
        terminalStatus.setCssGpsValid(mqtt_66.getSatelliteEffective() & 0xFF);
        terminalStatus.setCssSaving(mqtt_66.getSavingModel());
        terminalStatus.setCssSpeed(mqtt_66.getSpeed());
        terminalStatus.setCssTemperature(mqtt_66.getTemperature() & 0xFF);
//    terminalStatus.setCssVehicleSleepTime(mqtt_66.getVehicleSleepTime() & 0xFFFF);
//    terminalStatus.setCssVehicleStatus(mqtt_66.getVehicleStartStatus() & 0xFF);
//    terminalStatus.setCssVehicleStaus(mqtt_66.getVehicleStartStatus() & 0xFF);
//    terminalStatus.setCssGear(mqtt_66.getGear());
        // add at 2017-09-05 添加终端版本信息推送
        terminalStatus.setTerminalSupplier(
            csMachine.getCsmTeType() == null ? 0 : csMachine.getCsmTeType().intValue());
        terminalStatus.setHardwareVersion(
            StringUtils.empty(csMachine.getCsmV2()) ? 0 : Integer.parseInt(csMachine.getCsmV2()));
        terminalStatus.setSoftwareI(
            StringUtils.empty(csMachine.getCsmTlV1()) ? 0 : Integer.parseInt(csMachine.getCsmTlV1()));
        terminalStatus.setSoftwareII(0);
        terminalStatus.setPluginVersion(csMachine.getCsmTlV2() == null ? 0 : csMachine.getCsmTlV2());

        return terminalStatus;
    }


    /**
     * 新版本状态数据推送
     */
    public static TerminalStatus transform2TerminalStatus(CsMachine csMachine, String vin,
        MQTT_68_03 mqtt_68_03,
        MqMessage message) {
        TerminalStatus terminalStatus = new TerminalStatus();
        terminalStatus.setCssVin(vin);
//    terminalStatus.setCssNetType(mqtt_68_03.getNetType() & 0xFF);
        terminalStatus.setCssBaseCI(mqtt_68_03.getCcclubs_60().getBaseCI());
        terminalStatus.setCssBaseLAC(mqtt_68_03.getCcclubs_60().getBaseLAC());
        terminalStatus.setCssCurrentTime(mqtt_68_03.getTime());
        terminalStatus.setCssCharging(mqtt_68_03.getCcclubs_60().getTriggerChargeStatus());

        int airConditioner = mqtt_68_03.getCcclubs_60().getAirConditionerCircular();
        if (airConditioner == 0) {
            terminalStatus.setCssCircular(0);
            terminalStatus.setCssFan(0);
            terminalStatus.setCssCompres(0);
            terminalStatus.setCssPtc(0);
        } else {
            terminalStatus.setCssCircular(ProtocolTools.getAirConditionerCircular(airConditioner));
            terminalStatus.setCssFan(ProtocolTools.getAirConditionerFan(airConditioner));
            terminalStatus.setCssCompres(ProtocolTools.getAirConditionerCompres(airConditioner));
            terminalStatus.setCssPtc(ProtocolTools.getAirConditionerPtc(airConditioner));
        }

        terminalStatus.setCssCsq(mqtt_68_03.getCsq());
        terminalStatus.setCssGpsCn(mqtt_68_03.getCn());
        terminalStatus.setCssDir(mqtt_68_03.getHeading());
        terminalStatus.setCssDoor(mqtt_68_03.getDoorStatusWithMask());
        //FIXME 数据库字段设计为 Decimal
        terminalStatus.setCssOil(mqtt_68_03.getCcclubs_60().getOil().intValue());
        //FIXME 数据库字段设计为 Decimal
        terminalStatus.setCssEndurance(mqtt_68_03.getCcclubs_60().getEndurance().intValue());
        terminalStatus.setCssEngineT(mqtt_68_03.getTankTemperature());
        terminalStatus.setCssEvBattery(mqtt_68_03.getCcclubs_60().getSoc());

        BigDecimal latitude = AccurateOperationUtils.mul(mqtt_68_03.getLatitude(), 0.000001);

        BigDecimal longitude = AccurateOperationUtils.mul(mqtt_68_03.getLongitude(), 0.000001);

        terminalStatus.setCssLatitude(latitude.setScale(6, BigDecimal.ROUND_HALF_UP));
        terminalStatus.setCssLongitude(longitude.setScale(6, BigDecimal.ROUND_HALF_UP));
        terminalStatus.setCssMotor(mqtt_68_03.getRpm());
        terminalStatus.setCssNumber(StringUtils.empty(csMachine.getCsmTeNo()) ? ""
            : csMachine.getCsmTeNo().trim().toUpperCase());
        //FIXME 数据库字段设计为 Decimal
        terminalStatus.setCssObdMile(mqtt_68_03.getObdMile().intValue());
        terminalStatus.setCssMileage(mqtt_68_03.getCcclubs_60().getTradeMiles().intValue());
        terminalStatus.setCssOrder(message.getTransId());
        terminalStatus.setCssPower(mqtt_68_03.getBattery());

        terminalStatus.setCssRented(mqtt_68_03.getCcclubs_60().getTradeStatus());
        terminalStatus.setCssGpsCount(mqtt_68_03.getSatelliteCount());
        terminalStatus.setCssGpsValid(mqtt_68_03.getGpsValid());
        terminalStatus.setCssSaving(mqtt_68_03.getVehicleWorkingStatus());
        //FIXME 数据库字段设计为 Decimal
        terminalStatus.setCssSpeed(mqtt_68_03.getSpeed().intValue());
        terminalStatus.setCssTemperature(mqtt_68_03.getTerminalTemperature());
//    terminalStatus.setCssVehicleSleepTime(mqtt_68_03.getVehicleSleepTime() & 0xFFFF);
//    terminalStatus.setCssVehicleStatus(mqtt_66.getVehicleStartStatus() & 0xFF);
//    terminalStatus.setCssVehicleStaus(mqtt_66.getVehicleStartStatus() & 0xFF);
        terminalStatus.setCssGear(mqtt_68_03.getGearStatus());
        terminalStatus.setCssEngine(mqtt_68_03.getEngineStatus());
        terminalStatus.setCssLock(mqtt_68_03.getDoorLockStatusWithMask());
        terminalStatus.setCssLight(mqtt_68_03.getLightStatusWithMask());
        // add at 2017-09-05 添加终端版本信息推送
        terminalStatus.setTerminalSupplier(
            csMachine.getCsmTeType() == null ? 0 : csMachine.getCsmTeType().intValue());
        terminalStatus.setHardwareVersion(
            StringUtils.empty(csMachine.getCsmV2()) ? 0 : Integer.parseInt(csMachine.getCsmV2()));
        terminalStatus.setSoftwareI(
            StringUtils.empty(csMachine.getCsmTlV1()) ? 0 : Integer.parseInt(csMachine.getCsmTlV1()));
        terminalStatus.setSoftwareII(0);
        terminalStatus.setPluginVersion(csMachine.getCsmTlV2() == null ? 0 : csMachine.getCsmTlV2());
        terminalStatus.setAutopilot(mqtt_68_03.getCcclubs_60().getAutopilot());
        terminalStatus.setHandbrake(mqtt_68_03.getCcclubs_60().getHandbrake());
        return terminalStatus;
    }

    /**
     * 把状态数据转换成对外输出的JSON数据
     */
    public static TerminalStatus transform2TerminalStatus(CsMachine csMachine, String vin,
        CsState csState) {
        TerminalStatus terminalStatus = new TerminalStatus();
        terminalStatus.setCssVin(vin);
        terminalStatus
            .setCssNetType(csState.getCssNetType() == null ? 0 : csState.getCssNetType().intValue());
        terminalStatus.setCssBaseCI(csState.getCssBaseCi() == null ? 0 : csState.getCssBaseCi());
        terminalStatus.setCssBaseLAC(csState.getCssBaseLac() == null ? 0 : csState.getCssBaseLac());
        terminalStatus
            .setCssCurrentTime(csState.getCssCurrentTime().getTime());
        terminalStatus.setCssCharging(csState.getCssCharging()&0xFF);
        terminalStatus.setCssCircular(csState.getCssCircular()&0xFF);
        terminalStatus.setCssGpsCn(csState.getCssGpsCn()&0xFFFF);
        terminalStatus.setCssCompres(csState.getCssCompres()&0xFF);
        terminalStatus.setCssCsq(csState.getCssCsq()&0xFFFF);
        terminalStatus.setCssDir(StringUtils.empty(csState.getCssDir())?0:Integer.parseInt(csState.getCssDir()));
        terminalStatus.setCssDoor(StringUtils.empty(csState.getCssDoor())?0:Integer.parseInt(csState.getCssDoor()));
        // TODO:燃油量
        terminalStatus.setCssOil(StringUtils.empty(csState.getCssOil())?0:Integer.parseInt(csState.getCssOil()));
        terminalStatus.setCssEndurance(StringUtils.empty(csState.getCssEndurance())?0:Integer.parseInt(csState.getCssEndurance()));
        terminalStatus.setCssEngineT(csState.getCssEngineT());
        terminalStatus.setCssEvBattery(csState.getCssEvBattery()&0xFF);
        terminalStatus.setCssFan(csState.getCssFan()&0xFF);

        terminalStatus.setCssLatitude(csState.getCssLatitude().setScale(6, BigDecimal.ROUND_HALF_UP));
        terminalStatus.setCssLongitude(csState.getCssLongitude().setScale(6, BigDecimal.ROUND_HALF_UP));
        terminalStatus.setCssMotor(csState.getCssMotor());
        terminalStatus.setCssNumber(StringUtils.empty(csMachine.getCsmTeNo()) ? ""
            : csMachine.getCsmTeNo().trim().toUpperCase());
        terminalStatus.setCssObdMile(csState.getCssObdMile());
        terminalStatus.setCssMileage(csState.getCssMileage());
        terminalStatus.setCssOrder(csState.getCssOrder());
        terminalStatus.setCssPower(csState.getCssPower());
        terminalStatus.setCssPtc(csState.getCssPtc()&0xFF);
        terminalStatus.setCssRented(StringUtils.empty(csState.getCssRented())?0:Integer.parseInt(csState.getCssRented()));
        terminalStatus.setCssGpsCount(csState.getCssGpsCount().intValue());
        terminalStatus.setCssGpsValid(csState.getCssGpsValid()&0xFF);
        terminalStatus.setCssSaving(csState.getCssSaving()&0xFF);
        terminalStatus.setCssSpeed(csState.getCssSpeed()&0xFF);
        terminalStatus.setCssTemperature(csState.getCssTemperature()&0xFF);
//    terminalStatus.setCssVehicleSleepTime(0);
//    terminalStatus.setCssVehicleStatus(mqtt_66.getVehicleStartStatus() & 0xFF);
//    terminalStatus.setCssVehicleStaus(mqtt_66.getVehicleStartStatus() & 0xFF);
//    terminalStatus.setCssGear(mqtt_66.getGear());
        // add at 2017-09-05 添加终端版本信息推送
        terminalStatus.setTerminalSupplier(
            csMachine.getCsmTeType() == null ? 0 : csMachine.getCsmTeType().intValue());
        terminalStatus.setHardwareVersion(
            StringUtils.empty(csMachine.getCsmV2()) ? 0 : Integer.parseInt(csMachine.getCsmV2()));
        terminalStatus.setSoftwareI(
            StringUtils.empty(csMachine.getCsmTlV1()) ? 0 : Integer.parseInt(csMachine.getCsmTlV1()));
        terminalStatus.setSoftwareII(0);
        terminalStatus.setPluginVersion(csMachine.getCsmTlV2() == null ? 0 : csMachine.getCsmTlV2());
        terminalStatus.setHandbrake(csState.getCssHandbrake());
        terminalStatus.setAutopilot(csState.getCssAutopilot());
        return terminalStatus;
    }
}
