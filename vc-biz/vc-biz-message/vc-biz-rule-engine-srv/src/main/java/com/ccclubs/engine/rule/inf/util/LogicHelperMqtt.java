package com.ccclubs.engine.rule.inf.util;


import com.alibaba.fastjson.JSONObject;
import com.ccclubs.common.aop.Timer;
import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.core.util.TerminalUtils;
import com.ccclubs.frm.spring.constant.KafkaConst;
import com.ccclubs.helper.MachineMapping;
import com.ccclubs.protocol.dto.mqtt.MQTT_66;
import com.ccclubs.protocol.dto.mqtt.MQTT_68_03;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.mqtt.can.CanStatusZotye;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.dto.StateDTO;
import com.ccclubs.pub.orm.model.CsCan;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_RECENT_STATES;

/**
 * Created by qsxiaogang on 2017/7/2.
 */
@Component
public class LogicHelperMqtt {

    private static Logger logger = LoggerFactory.getLogger(LogicHelperMqtt.class);

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private KafkaTemplate kafkaTemplate;

    @Value("${" + KafkaConst.KAFKA_TOPIC_CAN + "}")
    String kafkaTopicCsCan;

    @Value("${" + KafkaConst.KAFKA_TOPIC_CAN_EXP + "}")
    String kafkaTopicCsCanExp;

    @Value("${" + KafkaConst.KAFKA_TOPIC_MQTT_STATE + "}")
    String kafkaTopicCsState;

    @Value("${" + KafkaConst.KAFKA_TOPIC_MQTT_STATE_EXP + "}")
    String kafkaTopicCsStateExp;

    @Resource
    private TerminalUtils terminalUtils;

    @Resource
    UpdateStateService updateStateService;


    @Resource
    UpdateCanService updateCanService;

    /**
     * 保存状态数据
     */
    @Timer
    public void saveStatusData(final MachineMapping mapping, final MqMessage message,
                               final MQTT_66 mqtt_66) {
        CsMachine csMachine = new CsMachine();
        csMachine.setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
        csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
        csMachine.setCsmNumber(mapping.getNumber());

        CsVehicle csVehicle = new CsVehicle();
        if (mapping.getCar() == null) {
            csVehicle = null;
        } else {
            csVehicle.setCsvId(mapping.getCar().intValue());
        }

        final CsState csState = terminalUtils.setCsStatus(csVehicle, csMachine);
        // 加入Vin add by jhy 2018.5.8
        csState.setCssVin(mapping.getVin());
        csState.setIccid(mapping.getIccid());
        csState.setMobile(mapping.getMobile());
        csState.setCssTeNo(mapping.getTeno());
        csState.setCssNumber(message.getCarNumber());
        csState.setCssAddTime(new Date());
        csState.setCssRented(String.valueOf(mqtt_66.getCarStatus() & 0xFF));
        csState.setCssRfid(mqtt_66.getRfid());
        csState.setCssSpeed(new BigDecimal(mqtt_66.getSpeed()));
        csState.setCssMotor(mqtt_66.getRpm() & 0xFFFF);
        csState.setCssPower(mqtt_66.getBattery() & 0xFFFF);
        csState.setCssMileage(new BigDecimal(mqtt_66.getMiles()));
        csState.setCssEngine((byte) mqtt_66.getEngineStatus());
        csState.setCssKey((byte) mqtt_66.getKeyStatus());
        //目前档位信息不对，暂时不用
        // csState.setCssGear(mqtt_66.getGear());
        csState.setCssOrder(message.getTransId());
        csState.setCssWarn(mqtt_66.getAlarmType() & 0xFFFF);
        csState.setCssTemperature(new BigDecimal(mqtt_66.getTemperature() & 0xFF));
        csState.setCssCsq((short) (mqtt_66.getCsq() & 0xFF));
        csState.setCssCurrentTime(new Date(mqtt_66.getTime()));
        csState.setCssRfidDte(mqtt_66.getRfidDte());
        // 插件由于升级，而车辆未启动，会采集不到累计里程 add at 2018-03-02 by qsxiaogang
        if ((mqtt_66.getObdMiles() & 0xFFFFFFFF) > 0) {
            csState.setCssObdMile(new BigDecimal(mqtt_66.getObdMiles() & 0xFFFFFFFF));
        }
        csState.setCssEngineT(new BigDecimal(mqtt_66.getEngineTemperature() & 0xFF));

        if (MQTT_66.MODEL_STATUS_OIL == message.getFucCode()) {
            // 汽油车
            csState.setCssEndurance(BigDecimal.ZERO);
            csState.setCssOil(new BigDecimal(mqtt_66.getEndurance() & 0xFFFF));
        } else {
            // 电动车
            csState.setCssEndurance(new BigDecimal(mqtt_66.getEndurance() & 0xFFFF));
            csState.setCssOil(BigDecimal.ZERO);
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
        csState.setCssDir(new BigDecimal(mqtt_66.getHeading() & 0xFFFF));

        csState.setCssNetType(mqtt_66.getNetType());
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
            // 需要更新的当前状态加入等待队列
            ListOperations opsForList = redisTemplate.opsForList();
            opsForList.leftPush(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, csState);
            // 发送历史状态到kafka
            if (StringUtils.empty(mapping.getVin())) {
                kafkaTemplate.send(kafkaTopicCsStateExp, JSONObject.toJSONString(csState));
            } else {
                kafkaTemplate.send(kafkaTopicCsState, JSONObject.toJSONString(csState));
            }

        } else {
            csState.setCssLongitude(AccurateOperationUtils
                    .add(mqtt_66.getLongitude(), mqtt_66.getLongitudeDecimal() * 0.000001).setScale(6,
                            BigDecimal.ROUND_HALF_UP));
            csState.setCssLatitude(AccurateOperationUtils
                    .add(mqtt_66.getLatitude(), mqtt_66.getLatitudeDecimal() * 0.000001).setScale(6,
                            BigDecimal.ROUND_HALF_UP));

            // 写入当前状态
            updateStateService.insert(csState);
            // 发送历史状态到kafka
            if (StringUtils.empty(mapping.getVin())) {
                kafkaTemplate.send(kafkaTopicCsStateExp, JSONObject.toJSONString(csState));
            } else {
                kafkaTemplate.send(kafkaTopicCsState, JSONObject.toJSONString(csState));
            }
        }

        //保存长安状态历史数据30条至redis
        setRentStatesToRedis(csState, csMachine);
    }


    /**
     * 保存新版本状态数据
     */
    @Timer
    public void saveStatusData(MachineMapping mapping, final MqMessage message,
                               final MQTT_68_03 mqtt_68_03) {
        if (mqtt_68_03 == null || mqtt_68_03.getCcclubs_60() == null) {
            return;
        }
        CsMachine csMachine = new CsMachine();
        csMachine.setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
        csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
        csMachine.setCsmNumber(mapping.getNumber());

        CsVehicle csVehicle = new CsVehicle();
        if (mapping.getCar() == null) {
            csVehicle = null;
        } else {
            csVehicle.setCsvId(mapping.getCar().intValue());
        }
        final CsState csState = terminalUtils.setCsStatus(csVehicle, csMachine);
        // 加入Vin add by jhy 2018.5.8
        csState.setCssVin(mapping.getVin());
        csState.setIccid(mapping.getIccid());
        csState.setMobile(mapping.getMobile());
        csState.setCssTeNo(mapping.getTeno());
        csState.setCssNumber(message.getCarNumber());
        csState.setCssAddTime(new Date());
        csState.setCssRented(String.valueOf(mqtt_68_03.getCcclubs_60().getTradeStatus()));
        csState.setCssRfid(mqtt_68_03.getCcclubs_60().getTradeInitCard());
        csState.setCssSpeed(mqtt_68_03.getSpeed());
        csState.setCssMotor(mqtt_68_03.getRpm());
        csState.setCssPower(mqtt_68_03.getBattery());
        csState.setCssMileage(mqtt_68_03.getCcclubs_60().getTradeMiles());
        csState.setCssEngine((byte) mqtt_68_03.getEngineStatus());
        csState.setCssKey((byte) mqtt_68_03.getKeyStatus());
        csState.setCssGear((byte) mqtt_68_03.getGearStatus());

        csState.setCssOrder(message.getTransId());
        csState.setCssWarn(mqtt_68_03.getCcclubs_60().getAlarm());
        csState.setCssTemperature(new BigDecimal(mqtt_68_03.getTerminalTemperature()));
        csState.setCssCsq((short) mqtt_68_03.getCsq());
        csState.setCssCurrentTime(new Date(mqtt_68_03.getTime()));
        csState.setCssRfidDte(mqtt_68_03.getCcclubs_60().getTradeTakeCard());
        // 插件由于升级，而车辆未启动，会采集不到累计里程 add at 2018-03-02 by qsxiaogang
        if (mqtt_68_03.getObdMile().doubleValue() > 0) {
            csState.setCssObdMile(mqtt_68_03.getObdMile());
        }
        csState.setCssEngineT(new BigDecimal(mqtt_68_03.getTankTemperature()));
        csState.setCssEndurance(mqtt_68_03.getCcclubs_60().getEndurance());
        csState.setCssOil(mqtt_68_03.getCcclubs_60().getOil());
        csState.setCssEvBattery(mqtt_68_03.getCcclubs_60().getSoc().byteValue());
        csState.setCssCharging(mqtt_68_03.getCcclubs_60().getTriggerChargeStatus().byteValue());
        int airConditioner = mqtt_68_03.getCcclubs_60().getAirConditionerCircular();
        if (airConditioner == 0) {
            csState.setCssCircular((byte) 0);
            csState.setCssPtc((byte) 0);
            csState.setCssCompres((byte) 0);
            csState.setCssFan((byte) 0);
        } else {
            csState.setCssCircular((byte) ProtocolTools.getAirConditionerCircular(airConditioner));
            csState.setCssPtc((byte) ProtocolTools.getAirConditionerPtc(airConditioner));
            csState.setCssCompres((byte) ProtocolTools.getAirConditionerCompres(airConditioner));
            csState.setCssFan((byte) ProtocolTools.getAirConditionerFan(airConditioner));
        }
        csState.setCssSaving((byte) mqtt_68_03.getVehicleWorkingStatus());
        csState.setCssDoor(String.valueOf(mqtt_68_03.getDoorStatusWithMask()));
        csState.setCssLight(mqtt_68_03.getLightStatusWithMask());
        csState.setCssMoData(message.getHexString());
        csState.setCssDir(new BigDecimal(mqtt_68_03.getHeading()));

        // csState.setCssNetType((long) mqtt_66.getNetType());
        csState.setCssBaseLac(mqtt_68_03.getCcclubs_60().getBaseLAC());
        csState.setCssBaseCi(mqtt_68_03.getCcclubs_60().getBaseCI());

        csState.setCssGpsValid((byte) mqtt_68_03.getGpsValid());
        csState.setCssGpsCn((short) mqtt_68_03.getCn());
        csState.setCssGpsCount((short) mqtt_68_03.getSatelliteCount());
        csState.setCssAutopilot(mqtt_68_03.getCcclubs_60().getAutopilot());
        csState.setCssHandbrake(mqtt_68_03.getCcclubs_60().getHandbrake());

        if (mapping.getState() != null) {
            csState.setCssId(mapping.getState().intValue());
            if (ProtocolTools
                    .isValid(mqtt_68_03.getLongitude() * 0.000001, mqtt_68_03.getLatitude() * 0.000001)) {
                csState.setCssLongitude(AccurateOperationUtils
                        .mul(mqtt_68_03.getLongitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP)
                );
                csState.setCssLatitude(AccurateOperationUtils
                        .mul(mqtt_68_03.getLatitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP)
                );
            }
            // 需要更新的当前状态加入等待队列
            ListOperations opsForList = redisTemplate.opsForList();
            opsForList.leftPush(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, csState);
            // 发送历史状态到kafka
            if (StringUtils.empty(mapping.getVin())) {
                kafkaTemplate.send(kafkaTopicCsStateExp, JSONObject.toJSONString(csState));
            } else {
                kafkaTemplate.send(kafkaTopicCsState, JSONObject.toJSONString(csState));
            }

        } else {
            csState.setCssLongitude(AccurateOperationUtils
                    .add(mqtt_68_03.getLongitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP)
            );
            csState.setCssLatitude(AccurateOperationUtils
                    .add(mqtt_68_03.getLatitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP)
            );
            // 写入当前状态
            updateStateService.insert(csState);
            // 发送历史状态到kafka
            if (StringUtils.empty(mapping.getVin())) {
                kafkaTemplate.send(kafkaTopicCsStateExp, JSONObject.toJSONString(csState));
            } else {
                kafkaTemplate.send(kafkaTopicCsState, JSONObject.toJSONString(csState));
            }
        }

        //保存长安状态历史数据30条至redis
        setRentStatesToRedis(csState, csMachine);
    }

    /**
     * 保存CAN数据
     */
    @Timer
    public void saveCanData(final MachineMapping mapping, MqMessage mqMessage,
                            CanStatusZotye canZotye) {
        CsMachine csMachine = new CsMachine();
        csMachine.setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
        csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
        csMachine.setCsmNumber(mapping.getNumber());

        CsVehicle csVehicle = new CsVehicle();
        if (mapping.getCar() == null) {
            csVehicle = null;
        } else {
            csVehicle.setCsvId(mapping.getCar().intValue());
        }

        CsCan canData = terminalUtils.setCsCan(csVehicle, csMachine);
        // 加入Vin add by jhy 2018.5.8
        canData.setCscVin(mapping.getVin());
        canData.setIccid(mapping.getIccid());
        canData.setMobile(mapping.getMobile());
        canData.setTeNo(mapping.getTeno());
        canData.setCscAddTime(new Date());
        canData.setCscNumber(mqMessage.getCarNumber());
        canData.setCscData(mqMessage.getHexString());
        canData.setCscModel((short) (canZotye.mSubfuc & 0xFF));
        canData.setCscType((short) (canZotye.mCanType & 0xff));
        // new Date(carStatus.mTime * 1000l + SYSTEM.MACHINE_TIME)
        canData.setCscUploadTime(new Date(ProtocolTools.transformToServerTime(canZotye.mTime)));
        canData.setCscOrder(canZotye.mOrderId);
        // String errorInfo = CanHelperFactory.parseCanErrorData(mqMessage.getHexString());
        //TODO:依据车型进行CAN数据解析
        // canData.setCscFault(errorInfo);
        if (mapping.getCan() != null) {
            canData.setCscId(mapping.getCan());
            // 需要更新的当前状态加入等待队列
            ListOperations opsForList = redisTemplate.opsForList();
            opsForList.leftPush(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE, canData);
        } else {
            updateCanService.insert(canData);
        }
        // 发送kafka处理can历史状态
        if (StringUtils.empty(mapping.getVin())) {
            kafkaTemplate.send(kafkaTopicCsCanExp, JSONObject.toJSONString(canData));
        } else {
            kafkaTemplate.send(kafkaTopicCsCan, JSONObject.toJSONString(canData));
        }
    }

    private void setRentStatesToRedis(CsState csState, CsMachine csMachine) {
        if (csState.getCssAccess() == 3 || csState.getCssAccess() == 4 || csState.getCssAccess() == 5) {
            StateDTO stateDTO = getStateDTO(csState);
            redisTemplate.opsForList()
                    .leftPush(REDIS_KEY_RECENT_STATES + csMachine.getCsmNumber(), stateDTO);
            Long queueSize = redisTemplate.opsForList()
                    .size(REDIS_KEY_RECENT_STATES + csMachine.getCsmNumber());
            if (queueSize >= 30) {
                redisTemplate.opsForList().trim(REDIS_KEY_RECENT_STATES + csMachine.getCsmNumber(), 0, 29);
            }
        }
    }

    private StateDTO getStateDTO(CsState csState) {
        StateDTO stateDTO = new StateDTO();
        stateDTO.setCurrentTime(csState.getCssCurrentTime());
        stateDTO.setObdMile(csState.getCssObdMile());
        stateDTO.setMileage(csState.getCssMileage());
        stateDTO.setSpeed(csState.getCssSpeed());
        stateDTO.setRotateSpeed(csState.getCssMotor());
        stateDTO.setFuelQuantity(csState.getCssOil());
        stateDTO.setPower(csState.getCssPower());
        stateDTO.setSoc(csState.getCssEvBattery());
        stateDTO.setCharging(csState.getCssCharging());
        stateDTO.setFuelMileage(csState.getCssFuelMileage());
        stateDTO.setElectricMileage(csState.getCssElectricMileage());
        stateDTO.setEndurance(csState.getCssEndurance());
        stateDTO.setTemperature(csState.getCssTemperature());
        stateDTO.setCsq(csState.getCssCsq());
        stateDTO.setLongitude(csState.getCssLongitude());
        stateDTO.setLatitude(csState.getCssLatitude());
        stateDTO.setGpsValid(csState.getCssGpsValid());
        stateDTO.setGpsCn(csState.getCssGpsCn());
        stateDTO.setGpsCount(csState.getCssGpsCount());
        stateDTO.setDirAngle(csState.getCssDir());
        stateDTO.setCircular(csState.getCssCircular());
        stateDTO.setPtc(csState.getCssPtc());
        stateDTO.setCompress(csState.getCssCompres());
        stateDTO.setFan(csState.getCssFan());
        stateDTO.setSaving(csState.getCssSaving());
        stateDTO.setDoor(csState.getCssDoor());
        stateDTO.setEngine(csState.getCssEngine());
        stateDTO.setKey(csState.getCssKey());
        stateDTO.setGear(csState.getCssGear());
        stateDTO.setLight(csState.getCssLight());
        stateDTO.setLock(csState.getCssLock());
        stateDTO.setNetType(csState.getCssNetType());
        stateDTO.setBaseLac(csState.getCssBaseLac());
        stateDTO.setBaseCi(csState.getCssBaseCi());
        stateDTO.setOrder(csState.getCssOrder());
        stateDTO.setAutopilot(csState.getCssAutopilot());
        stateDTO.setHandbrake(csState.getCssHandbrake());
        stateDTO.setSourceHex(csState.getCssMoData());
        return stateDTO;
    }
}
