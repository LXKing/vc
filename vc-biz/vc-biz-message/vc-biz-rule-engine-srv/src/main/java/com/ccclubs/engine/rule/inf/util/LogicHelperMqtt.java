package com.ccclubs.engine.rule.inf.util;


import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.engine.core.util.MachineMapping;
import com.ccclubs.engine.core.util.RedisHelper;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.core.util.TerminalUtils;
import com.ccclubs.mongo.orm.dao.CsAlarmDao;
import com.ccclubs.mongo.orm.model.CsAlarm;
import com.ccclubs.mongo.orm.model.CsHistoryCan;
import com.ccclubs.mongo.orm.model.CsHistoryState;
import com.ccclubs.protocol.dto.mqtt.MQTT_43;
import com.ccclubs.protocol.dto.mqtt.MQTT_66;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.mqtt.can.CanStatusZotye;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsCan;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qsxiaogang on 2017/7/2.
 */
@Component
public class LogicHelperMqtt {

    private static Logger logger = LoggerFactory.getLogger(LogicHelperMqtt.class);

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private TerminalUtils terminalUtils;

    @Resource
    UpdateStateService updateStateService;

    @Resource
    UpdateCanService updateCanService;

    @Autowired
    CsAlarmDao csAlarmDao;

    @Resource
    RedisHelper redisHelper;

    /**
     * 保存状态数据
     */
    public void saveStatusData(final MqMessage message, final MQTT_66 mqtt_66) {

        HashOperations ops = redisTemplate.opsForHash();
        final MachineMapping mapping = (MachineMapping) ops.get(RuleEngineConstant.REDIS_KEY_CARNUM, message.getCarNumber());
        if (mapping == null) {
            logger.error("系统中不存在车机：" + message.getCarNumber());
            return;
        }
        if (mapping.getMachine() == null || mapping.getAccess() == null || StringUtils
                .empty(mapping.getNumber())) {
            logger.error("系统中不存在车机：" + message.getCarNumber());
            return;
        }
        CsMachine csMachine = new CsMachine();
        csMachine.setCsmAccess(mapping.getAccess());
        csMachine.setCsmHost(mapping.getHost().intValue());
        csMachine.setCsmNumber(mapping.getNumber());

        CsVehicle csVehicle = new CsVehicle();
        if (mapping.getCar() == null) {
            csVehicle = null;
        } else {
            csVehicle.setCsvId(mapping.getCar().intValue());
        }

        final CsHistoryState historyState = terminalUtils.setCsHistoryStatus(csVehicle, csMachine);

        final CsState csState = terminalUtils.setCsStatus(csVehicle, csMachine);

        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                csState.setCssNumber(message.getCarNumber());
                csState.setCssAddTime(new Date());
                csState.setCssRented(String.valueOf(mqtt_66.getCarStatus() & 0xFF));
                csState.setCssRfid(mqtt_66.getRfid());
                csState.setCssSpeed((short) mqtt_66.getSpeed());
                csState.setCssMotor(mqtt_66.getRpm() & 0xFFFF);
                csState.setCssPower(mqtt_66.getBattery() & 0xFFFF);
                csState.setCssMileage(mqtt_66.getMiles());
                csState.setCssEngine((byte) mqtt_66.getEngineStatus());
                csState.setCssKey((byte) mqtt_66.getKeyStatus());
                //目前档位信息不对，暂时不用
//        csState.setCssGear(mqtt_66.getGear());

                csState.setCssOrder(message.getTransId());
                csState.setCssWarn(mqtt_66.getAlarmType() & 0xFFFF);
                csState.setCssTemperature((short) (mqtt_66.getTemperature() & 0xFF));
                csState.setCssCsq((short) (mqtt_66.getCsq() & 0xFF));
                csState.setCssCurrentTime(new Date(mqtt_66.getTime()));
                csState.setCssRfidDte(mqtt_66.getRfidDte());
                csState.setCssObdMile(mqtt_66.getObdMiles() & 0xFFFFFFFF);
                csState.setCssEngineT(mqtt_66.getEngineTemperature() & 0xFF);

                if (MQTT_66.MODEL_STATUS_OIL == message.getFucCode()) {
                    // 汽油车
                    csState.setCssEndurance("0");
                    csState.setCssOil(String.valueOf(mqtt_66.getEndurance() & 0xFFFF));
                } else {
                    // 电动车
                    csState.setCssEndurance(String.valueOf(mqtt_66.getEndurance() & 0xFFFF));
                    csState.setCssOil("0");
                }
                csState.setCssEvBattery((byte) (mqtt_66.getSoc() & 0xFF));
                csState.setCssCharging((byte) (mqtt_66.getCharging() & 0xFF));
                csState.setCssCircular((byte) mqtt_66.getAirConditionerCircular());
                csState.setCssPtc((byte) mqtt_66.getAirConditionerPtc());
                csState.setCssCompres((byte) mqtt_66.getAirConditionerCompres());
                csState.setCssFan((byte) mqtt_66.getAirConditionerFan());
                csState.setCssSaving((byte) mqtt_66.getSavingModel());
                csState.setCssDoor(String.valueOf(mqtt_66.getDoorStatus()));
                csState.setCssMoData(message.getHexString());
                csState.setCssDir(String.valueOf(mqtt_66.getHeading() & 0xFFFF));

                csState.setCssNetType((byte) mqtt_66.getNetType());
                csState.setCssBaseLac(mqtt_66.getBaseLAC());
                csState.setCssBaseCi(mqtt_66.getBaseCI());

                csState.setCssGpsValid((byte) (mqtt_66.getSatelliteEffective() & 0xFF));
                csState.setCssGpsCn((short) (mqtt_66.getCn() & 0xFF));
                csState.setCssGpsCount((short) (mqtt_66.getSatelliteCount() & 0xFF));

                if (mapping.getState() != null) {
                    csState.setCssId(mapping.getState().intValue());
                    if (ProtocolTools
                            .isValid(mqtt_66.getLongitude() + mqtt_66.getLongitudeDecimal() * 0.000001,
                                    mqtt_66.getLatitude() + mqtt_66.getLatitudeDecimal()
                                            * 0.000001)) {
                        csState.setCssLongitude(AccurateOperationUtils
                                .add(mqtt_66.getLongitude(), mqtt_66.getLongitudeDecimal() * 0.000001).setScale(6,
                                        BigDecimal.ROUND_HALF_UP));
                        csState.setCssLatitude(AccurateOperationUtils
                                .add(mqtt_66.getLatitude(), mqtt_66.getLatitudeDecimal() * 0.000001).setScale(6,
                                        BigDecimal.ROUND_HALF_UP));
                    }
                    updateStateService.update(csState);
                } else {
                    csState.setCssLongitude(AccurateOperationUtils
                            .add(mqtt_66.getLongitude(), mqtt_66.getLongitudeDecimal() * 0.000001).setScale(6,
                                    BigDecimal.ROUND_HALF_UP));
                    csState.setCssLatitude(AccurateOperationUtils
                            .add(mqtt_66.getLatitude(), mqtt_66.getLatitudeDecimal() * 0.000001).setScale(6,
                                    BigDecimal.ROUND_HALF_UP));
                    updateStateService.insert(csState);
                }
            }
        });

        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                historyState.setCshsNumber(message.getCarNumber());
                historyState.setCshsAddTime(new Date());
                historyState.setCshsRented(Byte.toString(mqtt_66.getCarStatus()));
                historyState.setCshsRfid(mqtt_66.getRfid());
                historyState.setCshsSpeed(Integer.toString(mqtt_66.getSpeed()));
                historyState.setCshsMotor(Integer.toString(mqtt_66.getRpm()));
                historyState.setCshsPower(Short.toString(mqtt_66.getBattery()));
                historyState.setCshsMileage(Integer.toString(mqtt_66.getMiles()));
                historyState.setCshsLongitude(String.valueOf(AccurateOperationUtils
                        .add(mqtt_66.getLongitude(), mqtt_66.getLongitudeDecimal() * 0.000001).setScale(6,
                                BigDecimal.ROUND_HALF_UP)));
                historyState.setCshsLatitude(String.valueOf(AccurateOperationUtils
                        .add(mqtt_66.getLatitude(), mqtt_66.getLatitudeDecimal() * 0.000001).setScale(6,
                                BigDecimal.ROUND_HALF_UP)));

                historyState.setCshsOrder(Long.toString(message.getTransId()));
                historyState.setCshsWarn(Short.toString(mqtt_66.getAlarmType()));
                historyState.setCshsTemperature(Integer.toString(mqtt_66.getTemperature() & 0xFF));
                historyState.setCshsCsq(Byte.toString(mqtt_66.getCsq()));
                historyState
                        .setCshsCurrentTime(new Date(mqtt_66.getTime()));
                historyState.setCshsRfidDte(mqtt_66.getRfidDte());
                historyState.setCshsObdMile(Integer.toString(mqtt_66.getObdMiles()));
                historyState.setCshsEngineT(Integer.toString(mqtt_66.getEngineTemperature() & 0xFF));
                if (MQTT_66.MODEL_STATUS_OIL == message.getFucCode()) {
                    // 汽油车
                    historyState.setCshsEndurance("0");
                    historyState.setCshsOil(String.valueOf(mqtt_66.getEndurance()));
                } else {
                    // 电动车
                    historyState.setCshsEndurance(String.valueOf(mqtt_66.getEndurance()));
                    historyState.setCshsOil("0");
                }
                historyState.setCshsEvBattery(Byte.toString(mqtt_66.getSoc()));
                historyState.setCshsCharging(Byte.toString(mqtt_66.getCharging()));
                historyState.setCshsCircular(Integer.toString(mqtt_66.getAirConditionerCircular()));
                historyState.setCshsPtc(Integer.toString(mqtt_66.getAirConditionerPtc()));
                historyState.setCshsCompres(Integer.toString(mqtt_66.getAirConditionerCompres()));
                historyState.setCshsFan(Integer.toString(mqtt_66.getAirConditionerFan()));
                historyState.setCshsSaving(Integer.toString(mqtt_66.getSavingModel()));
                historyState
                        .setCshsDoor(Integer.toString(mqtt_66.getDoorStatus()));
                historyState.setCshsMoData(message.getHexString());
                historyState.setCshsDir(Integer.toString(mqtt_66.getHeading()));
                historyState.setCshsNetType((long) mqtt_66.getNetType());
                historyState.setCshsBaseLac(Integer.toString(mqtt_66.getBaseLAC()));
                historyState.setCshsBaseCi(Integer.toString(mqtt_66.getBaseCI()));

                historyState.setCshsGpsValid(mqtt_66.getSatelliteEffective() & 0xFF);
                historyState.setCshsGpsCn(mqtt_66.getCn() & 0xFF);
                historyState.setCshsGpsCount(mqtt_66.getSatelliteCount() & 0xFF);

                historyState.setCshsEngine((long) mqtt_66.getEngineStatus());
                historyState.setCshsKey((long) mqtt_66.getKeyStatus());
                updateStateService.insertHis(historyState);
            }
        });
    }

    /**
     * 保存CAN数据
     */
    public void saveCanData(MqMessage mqMessage, CanStatusZotye canZotye) {
        HashOperations ops = redisTemplate.opsForHash();
        final MachineMapping mapping = (MachineMapping) ops.get(RuleEngineConstant.REDIS_KEY_CARNUM, mqMessage.getCarNumber());
        if (mapping == null) {
            redisHelper.setNotExist(mqMessage.getCarNumber(), true);
            return;
        }

        if (mapping.getMachine() == null || mapping.getAccess() == null || StringUtils
                .empty(mapping.getNumber())) {
            return;
        }
        CsMachine csMachine = new CsMachine();
        csMachine.setCsmAccess(mapping.getAccess());
        csMachine.setCsmHost(mapping.getHost() == null ? null : mapping.getHost().intValue());
        csMachine.setCsmNumber(mapping.getNumber());

        CsVehicle csVehicle = new CsVehicle();
        if (mapping.getCar() == null) {
            csVehicle = null;
        } else {
            csVehicle.setCsvId(mapping.getCar().intValue());
        }

        CsCan canData = terminalUtils.setCsCan(csVehicle, csMachine);

        canData.setCscAddTime(new Date());
        canData.setCscNumber(mqMessage.getCarNumber());
        canData.setCscData(mqMessage.getHexString());
        canData.setCscModel((short) (canZotye.mSubfuc & 0xFF));
        canData.setCscType((short) (canZotye.mCanType & 0xff));
        // new Date(carStatus.mTime * 1000l + SYSTEM.MACHINE_TIME)
        canData.setCscUploadTime(new Date(ProtocolTools.transformToServerTime(canZotye.mTime)));
        canData.setCscOrder(canZotye.mOrderId);
//    String errorInfo = CanHelperFactory.parseCanErrorData(mqMessage.getHexString());
        //TODO:依据车型进行CAN数据解析
//    canData.setCscFault(errorInfo);
        if (mapping.getCan() != null) {
            canData.setCscId(mapping.getCan());
            updateCanService.update(canData);
        } else {
            updateCanService.insert(canData);
        }

        CsHistoryCan canHistoryData = terminalUtils.setCsHistoryCan(csVehicle, csMachine);

        canHistoryData.setCshcAddTime(new Date());
        canHistoryData.setCshcNumber(canZotye.mCarNum);
        canHistoryData.setCshcData(mqMessage.getHexString());
        canHistoryData.setCshcModel((short) (canZotye.mSubfuc & 0xff));
        canHistoryData.setCshcType((short) (canZotye.mCanType & 0xff));
        // new Date(carStatus.mTime * 1000l + SYSTEM.MACHINE_TIME)
        canHistoryData.setCshcUploadTime(new Date(ProtocolTools.transformToServerTime(canZotye.mTime)));
        canHistoryData.setCshcOrder(canZotye.mOrderId);
        canHistoryData.setCshcFault("");
        updateCanService.insertHis(canHistoryData);
    }

    /**
     * 保存报警数据
     */
    public void saveAlarmData(MqMessage mqMessage, MQTT_43 mqtt_43) {
        final CsMachine csMachine = terminalUtils
                .getCsMachineByNumber(RuleEngineConstant.REDIS_KEY_CARNUM, mqMessage.getCarNumber().toUpperCase());
        if (csMachine == null || StringUtils.empty(csMachine.getCsmNumber())) {
            // TODO:记录系统中不存在的车机
            return;
        }
        final CsVehicle csVehicle = terminalUtils.getCsVehicle(csMachine.getCsmId());

        CsAlarm alarm = terminalUtils.setCsAlarm(csVehicle, csMachine);

        alarm.setCsaAddTime(new Date());
        alarm.setCsaNumber(mqMessage.getCarNumber().toUpperCase());
        alarm.setCsaInfo(String.valueOf(mqtt_43.getAlarmType()));
        alarm.setCsaOrder("0");
        csAlarmDao.save(alarm);
    }

}
