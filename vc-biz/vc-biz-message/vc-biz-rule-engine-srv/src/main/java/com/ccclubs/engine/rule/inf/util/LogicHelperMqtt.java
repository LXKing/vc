package com.ccclubs.engine.rule.inf.util;


import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_RECENT_STATES;
import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_RT_STATES;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.core.util.TerminalUtils;
import com.ccclubs.frm.spring.constant.KafkaConst;
import com.ccclubs.helper.MachineMapping;
import com.ccclubs.protocol.dto.mqtt.MQTT_66;
import com.ccclubs.protocol.dto.mqtt.MQTT_68_03;
import com.ccclubs.protocol.dto.mqtt.MachineAdditional_HighPrecisionGPS;
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
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by qsxiaogang on 2017/7/2.
 *
 * @author qsxiaogang
 * @date 2017/7/2
 */
@Component
public class LogicHelperMqtt {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(LogicHelperMqtt.class);

    /**
     * redis 模板
     */
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * kafka 模板
     */
    @Resource
    private KafkaTemplate kafkaTemplate;

    /**
     * 历史CAN数据
     */
    @Value("${" + KafkaConst.KAFKA_TOPIC_CAN + "}")
    String kafkaTopicCsCan;

    /**
     * can-exp
     */
    @Value("${" + KafkaConst.KAFKA_TOPIC_CAN_EXP + "}")
    String kafkaTopicCsCanExp;

    /**
     * MQTT状态数据
     */
    @Value("${" + KafkaConst.KAFKA_TOPIC_MQTT_STATE + "}")
    String kafkaTopicCsState;

    /**
     * mqtt-exp
     */
    @Value("${" + KafkaConst.KAFKA_TOPIC_MQTT_STATE_EXP + "}")
    String kafkaTopicCsStateExp;

    /**
     * 终端工具类
     */
    @Resource
    private TerminalUtils terminalUtils;

    /**
     * 状态更新服务
     */
    @Resource
    UpdateStateService updateStateService;


    /**
     * can状态更新服务
     */
    @Resource
    UpdateCanService updateCanService;

    /**
     * 保存状态数据 Timer: 该方法受时间记录
     */
    //@Timer
    public void saveStatusData(final MachineMapping mapping, final MqMessage message,
            final MQTT_66 mqtt_66) {
        // 车机对象
        CsMachine csMachine = new CsMachine();
        // 设置access
        csMachine.setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
        // 设置域名
        csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
        // 设置车机号
        csMachine.setCsmNumber(mapping.getNumber());

        // 车辆信息
        CsVehicle csVehicle = new CsVehicle();
        // 车辆映射中是否车辆为空
        if (mapping.getCar() == null) {
            // 为空
            csVehicle = null;
        } else {
            // 不为空
            // 设置csvId
            csVehicle.setCsvId(mapping.getCar().intValue());
        }

        // 车机状态
        final CsState csState = terminalUtils.setCsStatus(csVehicle, csMachine);
        // 加入Vin add by jhy 2018.5.8
        csState.setCssVin(mapping.getVin());
        // 设置iccid
        csState.setIccid(mapping.getIccid());
        // 设置电话号码
        csState.setMobile(mapping.getMobile());
        // 设置终端号
        csState.setCssTeNo(mapping.getTeno());
        // 设置车机号
        csState.setCssNumber(message.getCarNumber());
        // 设置添加时间
        csState.setCssAddTime(new Date());
        // 设置租赁状态
        csState.setCssRented(String.valueOf(mqtt_66.getCarStatus() & 0xFF));
        // 设置rfid
        csState.setCssRfid(mqtt_66.getRfid());
        // 设置速度
        csState.setCssSpeed(new BigDecimal(mqtt_66.getSpeed()));
        // 设置motor
        csState.setCssMotor(mqtt_66.getRpm() & 0xFFFF);
        // 设置css能量
        csState.setCssPower(mqtt_66.getBattery() & 0xFFFF);
        // 设置CssMileage
        csState.setCssMileage(new BigDecimal(mqtt_66.getMiles()));
        // 设置CssEngine
        csState.setCssEngine((byte) mqtt_66.getEngineStatus());
        // 设置CssKey
        csState.setCssKey((byte) mqtt_66.getKeyStatus());
        //目前档位信息不对，暂时不用 fixme todo
        // csState.setCssGear(mqtt_66.getGear());
        csState.setCssOrder(message.getTransId());
        // 设置css报警
        csState.setCssWarn(mqtt_66.getAlarmType() & 0xFFFF);
        // 设置温度
        csState.setCssTemperature(new BigDecimal(mqtt_66.getTemperature() & 0xFF));
        // 设置CssCsq
        csState.setCssCsq((short) (mqtt_66.getCsq() & 0xFF));
        //设置css当前时间
        csState.setCssCurrentTime(new Date(mqtt_66.getTime()));
        // 设置CssRfidDte
        csState.setCssRfidDte(mqtt_66.getRfidDte());
        // 插件由于升级，而车辆未启动，会采集不到累计里程 add at 2018-03-02 by qsxiaogang
        if ((mqtt_66.getObdMiles() & 0xFFFFFFFF) > 0) {
            csState.setCssObdMile(new BigDecimal(mqtt_66.getObdMiles() & 0xFFFFFFFF));
        }
        /**
         * 更新CssEngineT
         */
        csState.setCssEngineT(new BigDecimal(mqtt_66.getEngineTemperature() & 0xFF));

        // 判断OTL|OTL|OTZ
        if (MQTT_66.MODEL_STATUS_OIL == message.getFucCode()) {
            // 汽油车
            csState.setCssEndurance(BigDecimal.ZERO);
            // 设置cssoil
            csState.setCssOil(new BigDecimal(mqtt_66.getEndurance() & 0xFFFF));
        } else {
            // 电动车
            csState.setCssEndurance(new BigDecimal(mqtt_66.getEndurance() & 0xFFFF));
            // 设置cssoil
            csState.setCssOil(BigDecimal.ZERO);
        }
        // 设置ev电池
        csState.setCssEvBattery((byte) (mqtt_66.getSoc() & 0xFF));
        // 设置充电状态
        csState.setCssCharging((byte) (mqtt_66.getCharging() & 0xFF));
        // 设置Circular
        csState.setCssCircular((byte) mqtt_66.getAirConditionerCircular());
        // 设置CssPtc
        csState.setCssPtc((byte) mqtt_66.getAirConditionerPtc());
        // 设置CssCompres
        csState.setCssCompres((byte) mqtt_66.getAirConditionerCompres());
        // 设置CssFan
        csState.setCssFan((byte) mqtt_66.getAirConditionerFan());
        // 设置CssSaving
        csState.setCssSaving((byte) mqtt_66.getSavingModel());
        // 设置CssDoor
        csState.setCssDoor(String.valueOf(mqtt_66.getDoorStatus()));
        // 设置CssMoData
        csState.setCssMoData(message.getHexString());
        // 设置CssDir
        csState.setCssDir(new BigDecimal(mqtt_66.getHeading() & 0xFFFF));

        // 设置CssNetType
        csState.setCssNetType(mqtt_66.getNetType());
        // 设置CssBaseLac
        csState.setCssBaseLac(mqtt_66.getBaseLAC());
        // 设置CssBaseCi
        csState.setCssBaseCi(mqtt_66.getBaseCI());

        // 设置CssGpsValid
        csState.setCssGpsValid((byte) (mqtt_66.getSatelliteEffective() & 0xFF));
        // 设置CssGpsCn
        csState.setCssGpsCn((short) (mqtt_66.getCn() & 0xFF));
        // 设置CssGpsCount
        csState.setCssGpsCount((short) (mqtt_66.getSatelliteCount() & 0xFF));

        /**
         * 根据mapping中的状态，判断
         */
        if (mapping.getState() != null) {
            csState.setCssId(mapping.getState().intValue());
            /**
             * 校验经纬度是否合法
             */
            if (ProtocolTools
                    .isValid(mqtt_66.getLongitude() + mqtt_66.getLongitudeDecimal() * 0.000001,
                            mqtt_66.getLatitude() + mqtt_66.getLatitudeDecimal()
                                    * 0.000001)) {
                csState.setCssLongitude(AccurateOperationUtils
                        .add(mqtt_66.getLongitude(), mqtt_66.getLongitudeDecimal() * 0.000001)
                        .setScale(6,
                                BigDecimal.ROUND_HALF_UP));
                csState.setCssLatitude(AccurateOperationUtils
                        .add(mqtt_66.getLatitude(), mqtt_66.getLatitudeDecimal() * 0.000001)
                        .setScale(6,
                                BigDecimal.ROUND_HALF_UP));
            }
            // 需要更新的当前状态加入等待队列
            ListOperations opsForList = redisTemplate.opsForList();
            /**
             * 向 redis 中 lpush 数 据
             */
            opsForList.leftPush(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, csState);
            // 发送历史状态到kafka
            if (StringUtils.empty(mapping.getVin())) {
                // 直接发送
                kafkaTemplate.send(kafkaTopicCsStateExp, JSONObject.toJSONString(csState));
            } else {
                // 也是直接发送
                kafkaTemplate.send(kafkaTopicCsState, JSONObject.toJSONString(csState));
            }
        } else {
            /**
             * 如果 state==null 设置经纬度后，插入当前状态
             */
            csState.setCssLongitude(AccurateOperationUtils
                    .add(mqtt_66.getLongitude(), mqtt_66.getLongitudeDecimal() * 0.000001)
                    .setScale(6,
                            BigDecimal.ROUND_HALF_UP));
            csState.setCssLatitude(AccurateOperationUtils
                    .add(mqtt_66.getLatitude(), mqtt_66.getLatitudeDecimal() * 0.000001).setScale(6,
                            BigDecimal.ROUND_HALF_UP));

            // 写入当前状态
            updateStateService.insert(csState);
            // 发送历史状态到kafka
            if (StringUtils.empty(mapping.getVin())) {
                // 发送
                kafkaTemplate.send(kafkaTopicCsStateExp, JSONObject.toJSONString(csState));
            } else {
                // 发送
                kafkaTemplate.send(kafkaTopicCsState, JSONObject.toJSONString(csState));
            }
        }
        //实时状态->redis
        redisTemplate.opsForHash().put(REDIS_KEY_RT_STATES, csState.getCssNumber(), csState);
        //保存长安状态历史数据30条至redis
        setRentStatesToRedis(csState, csMachine);
    }

    /**
     * 保存新版本状态数据
     */
    //@Timer
    public void saveStatusData(MachineMapping mapping, final MqMessage message,
            final MQTT_68_03 mqtt_68_03) {
        /**
         * 保存状态信息
         */
        if (mqtt_68_03 == null || mqtt_68_03.getCcclubs_60() == null) {
            // 直接返回
            return;
        }
        // 构造一个新的车机对象
        CsMachine csMachine = new CsMachine();
        // 设置CsmAccess
        csMachine.setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
        // 设置域名
        csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
        // 设置车机号
        csMachine.setCsmNumber(mapping.getNumber());
        // 构造车辆对象
        CsVehicle csVehicle = new CsVehicle();
        /**
         * 如果 car == null 车辆对象也设置为空
         */
        if (mapping.getCar() == null) {
            csVehicle = null;
        } else {
            // 设置CsvId
            csVehicle.setCsvId(mapping.getCar().intValue());
        }
        // 从工具类中构建车辆状态详情
        final CsState csState = terminalUtils.setCsStatus(csVehicle, csMachine);
        // 加入Vin add by jhy 2018.5.8
        csState.setCssVin(mapping.getVin());
        // 设置Iccid
        csState.setIccid(mapping.getIccid());
        // 设置电话
        csState.setMobile(mapping.getMobile());
        // 设置终端号
        csState.setCssTeNo(mapping.getTeno());
        // 设置车机号
        csState.setCssNumber(message.getCarNumber());
        // 设置添加时间
        csState.setCssAddTime(new Date());
        // 设置CssRented
        csState.setCssRented(String.valueOf(mqtt_68_03.getCcclubs_60().getTradeStatus()));
        // 设置CssRfid
        csState.setCssRfid(mqtt_68_03.getCcclubs_60().getTradeInitCard());
        // 设置速度
        csState.setCssSpeed(mqtt_68_03.getSpeed());
        // 设置发动机
        csState.setCssMotor(mqtt_68_03.getRpm());
        // 设置电量
        csState.setCssPower(mqtt_68_03.getBattery());
        // 设置里程
        csState.setCssMileage(mqtt_68_03.getCcclubs_60().getTradeMiles());
        // 设置驱动机
        csState.setCssEngine((byte) mqtt_68_03.getEngineStatus());
        // 设置CssKey
        csState.setCssKey((byte) mqtt_68_03.getKeyStatus());
        // 设置CssGear
        csState.setCssGear((byte) mqtt_68_03.getGearStatus());
        // 设置CssOrder
        csState.setCssOrder(message.getTransId());
        // 设置告警级别
        csState.setCssWarn(mqtt_68_03.getCcclubs_60().getAlarm());
        // 设置温度
        csState.setCssTemperature(new BigDecimal(mqtt_68_03.getTerminalTemperature()));
        // 设置CssCsq
        csState.setCssCsq((short) mqtt_68_03.getCsq());
        // 设置当前时间
        csState.setCssCurrentTime(new Date(mqtt_68_03.getTime()));
        // 设置CssRfidDte
        csState.setCssRfidDte(mqtt_68_03.getCcclubs_60().getTradeTakeCard());
        // 插件由于升级，而车辆未启动，会采集不到累计里程 add at 2018-03-02 by qsxiaogang
        if (mqtt_68_03.getObdMile().doubleValue() > 0) {
            // 设置OBD里程数
            csState.setCssObdMile(mqtt_68_03.getObdMile());
        }
        // 设置CssEngineT
        csState.setCssEngineT(new BigDecimal(mqtt_68_03.getTankTemperature()));
        // 设置CssEndurance
        csState.setCssEndurance(mqtt_68_03.getCcclubs_60().getEndurance());
        // 设置CssOil
        csState.setCssOil(mqtt_68_03.getCcclubs_60().getOil());
        // 设置Ev电池
        csState.setCssEvBattery(mqtt_68_03.getCcclubs_60().getSoc().byteValue());
        // 设置充电
        csState.setCssCharging(mqtt_68_03.getCcclubs_60().getTriggerChargeStatus().byteValue());
        /**
         * 根据 特定条件 设置 空调控制器
         */
        int airConditioner = mqtt_68_03.getCcclubs_60().getAirConditionerCircular();
        if (airConditioner == 0) {
            /**
             * 如果为0 设置一些相关参数 CssCircular CssPtc CssCompres CssFan
             */
            csState.setCssCircular((byte) 0);
            csState.setCssPtc((byte) 0);
            csState.setCssCompres((byte) 0);
            csState.setCssFan((byte) 0);
        } else {
            /**
             * 如果不为0 从协议工具类中设置
             */
            csState.setCssCircular((byte) ProtocolTools.getAirConditionerCircular(airConditioner));
            csState.setCssPtc((byte) ProtocolTools.getAirConditionerPtc(airConditioner));
            csState.setCssCompres((byte) ProtocolTools.getAirConditionerCompres(airConditioner));
            csState.setCssFan((byte) ProtocolTools.getAirConditionerFan(airConditioner));
        }
        /**
         * 设置CssSaving
         */
        csState.setCssSaving((byte) mqtt_68_03.getVehicleWorkingStatus());
        /**
         * 设置开门
         */
        csState.setCssDoor(String.valueOf(mqtt_68_03.getDoorStatusWithMask()));
        /**
         * 设置光照
         */
        csState.setCssLight(mqtt_68_03.getLightStatusWithMask());
        /**
         * 设置CssMoData
         */
        csState.setCssMoData(message.getHexString());
        /**
         * 设置dir
         */
        csState.setCssDir(new BigDecimal(mqtt_68_03.getHeading()));

        // csState.setCssNetType((long) mqtt_66.getNetType());
        csState.setCssBaseLac(mqtt_68_03.getCcclubs_60().getBaseLAC());
        /**
         * 设置CssBaseCi
         */
        csState.setCssBaseCi(mqtt_68_03.getCcclubs_60().getBaseCI());

        /**
         * 设置CssGpsValid
         */
        csState.setCssGpsValid((byte) mqtt_68_03.getGpsValid());
        /**
         * 设置CssGpsCn
         */
        csState.setCssGpsCn((short) mqtt_68_03.getCn());
        /**
         * 设置CssGpsCount
         */
        csState.setCssGpsCount((short) mqtt_68_03.getSatelliteCount());
        /**
         * 设置CssAutopilot
         */
        csState.setCssAutopilot(mqtt_68_03.getCcclubs_60().getAutopilot());
        /**
         * 设置CssHandbrake
         */
        csState.setCssHandbrake(mqtt_68_03.getCcclubs_60().getHandbrake());
        /**
         *  高精度经纬度【车辆自身经纬度】
         */
        MachineAdditional_HighPrecisionGPS highPrecisionGPS = mqtt_68_03.getCcclubs_60()
                .getHighPrecisionGPS();
        if (highPrecisionGPS != null) {
            csState.setAcuLatitude(highPrecisionGPS.getLatitudeDecimal());
            csState.setAcuLongitude(highPrecisionGPS.getLongitudeDecimal());
            csState.setAcuVehicleAdState(highPrecisionGPS.getAcuVehicleAdState());
            csState.setVrtVehicleStart(highPrecisionGPS.getVrtVehicleStart());
        }
        /**
         * 首先检查state是否存在,存在即更新，不存在不更新
         */
        if (mapping.getState() != null) {
            csState.setCssId(mapping.getState().intValue());
            /**
             * 校 验 经 纬 度
             */
            if (ProtocolTools
                    .isValid(mqtt_68_03.getLongitude() * 0.000001,
                            mqtt_68_03.getLatitude() * 0.000001)) {
                csState.setCssLongitude(AccurateOperationUtils
                        .mul(mqtt_68_03.getLongitude(), 0.000001)
                        .setScale(6, BigDecimal.ROUND_HALF_UP)
                );
                csState.setCssLatitude(AccurateOperationUtils
                        .mul(mqtt_68_03.getLatitude(), 0.000001)
                        .setScale(6, BigDecimal.ROUND_HALF_UP)
                );
            }
            // 需要更新的当前状态加入等待队列
            ListOperations opsForList = redisTemplate.opsForList();
            opsForList.leftPush(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, csState);
            // 发送历史状态到kafka
            if (StringUtils.empty(mapping.getVin())) {
                /**
                 * 发送
                 */
                kafkaTemplate.send(kafkaTopicCsStateExp, JSONObject.toJSONString(csState));
            } else {
                /**
                 * 发送
                 */
                kafkaTemplate.send(kafkaTopicCsState, JSONObject.toJSONString(csState));
            }
        } else {
            /**
             * 设置经度
             */
            csState.setCssLongitude(AccurateOperationUtils
                    .add(mqtt_68_03.getLongitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP)
            );
            /**
             * 设置纬度
             */
            csState.setCssLatitude(AccurateOperationUtils
                    .add(mqtt_68_03.getLatitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP)
            );
            // 写入当前状态
            updateStateService.insert(csState);
            // 发送历史状态到kafka
            if (StringUtils.empty(mapping.getVin())) {
                /**
                 * 发送到kafka
                 */
                kafkaTemplate.send(kafkaTopicCsStateExp, JSONObject.toJSONString(csState));
            } else {
                /**
                 * 发送到kafka
                 */
                kafkaTemplate.send(kafkaTopicCsState, JSONObject.toJSONString(csState));
            }
        }
        //实时状态->redis
        redisTemplate.opsForHash().put(REDIS_KEY_RT_STATES, csState.getCssNumber(), csState);
        //保存长安状态历史数据30条至redis
        setRentStatesToRedis(csState, csMachine);
    }

    /**
     * 保存CAN数据
     */
    //@Timer
    public void saveCanData(final MachineMapping mapping, MqMessage mqMessage,
            CanStatusZotye canZotye) {
        /**
         * 构造车机对象
         */
        CsMachine csMachine = new CsMachine();
        /**
         * 设置CsmAccess
         */
        csMachine.setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
        /**
         * 设置域名
         */
        csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
        /**
         * 设置车机号
         */
        csMachine.setCsmNumber(mapping.getNumber());
        /**
         * 设置车辆对象
         */
        CsVehicle csVehicle = new CsVehicle();
        /**
         * 设置CsvId
         */
        if (mapping.getCar() == null) {
            csVehicle = null;
        } else {
            csVehicle.setCsvId(mapping.getCar().intValue());
        }

        /**
         * 设置CAN数据
         */
        CsCan canData = terminalUtils.setCsCan(csVehicle, csMachine);
        // 加入Vin add by jhy 2018.5.8
        canData.setCscVin(mapping.getVin());
        /**
         * 设置Iccid
         */
        canData.setIccid(mapping.getIccid());
        /**
         * 设置电话号码
         */
        canData.setMobile(mapping.getMobile());
        /**
         * 设置终端号码
         */
        canData.setTeNo(mapping.getTeno());
        /**
         * 设置添加时间
         */
        canData.setCscAddTime(new Date());
        /**
         * 设置车机号
         */
        canData.setCscNumber(mqMessage.getCarNumber());
        /**
         * 设置车机数据
         */
        canData.setCscData(mqMessage.getHexString());
        /**
         * 设置车机发动机
         */
        canData.setCscModel((short) (canZotye.mSubfuc & 0xFF));
        /**
         * 设置CscType
         */
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
            /**
             * kafka发送
             */
            kafkaTemplate.send(kafkaTopicCsCanExp, JSONObject.toJSONString(canData));
        } else {
            /**
             * kafka发送
             */
            kafkaTemplate.send(kafkaTopicCsCan, JSONObject.toJSONString(canData));
        }
    }

    /**
     * 向redis 中设置 运行状态
     */
    private void setRentStatesToRedis(CsState csState, CsMachine csMachine) {
        if (csState.getCssAccess() == 3 || csState.getCssAccess() == 4
                || csState.getCssAccess() == 5) {
            /**
             * 如果CssAccess为
             * 3：
             * 4：
             * 5：
             */
            StateDTO stateDTO = getStateDTO(csState);
            redisTemplate.opsForList()
                    .leftPush(REDIS_KEY_RECENT_STATES + csMachine.getCsmNumber(), stateDTO);
            /**
             * 获取队列长度
             */
            Long queueSize = redisTemplate.opsForList()
                    .size(REDIS_KEY_RECENT_STATES + csMachine.getCsmNumber());
            if (queueSize >= 30) {
                /**
                 * 如果长度大于30，做裁剪
                 */
                redisTemplate.opsForList()
                        .trim(REDIS_KEY_RECENT_STATES + csMachine.getCsmNumber(), 0, 29);
            }
        }
    }

    /**
     * 根据车机状态 获取状态dto
     */
    private StateDTO getStateDTO(CsState csState) {
        // 构建dto对象
        StateDTO stateDTO = new StateDTO();
        /**
         * 设置当前时间
         */
        stateDTO.setCurrentTime(csState.getCssCurrentTime());
        /**
         * 设置obd里程数
         */
        stateDTO.setObdMile(csState.getCssObdMile());
        /**
         * 设置Mileage
         */
        stateDTO.setMileage(csState.getCssMileage());
        /**
         * 设置速度
         */
        stateDTO.setSpeed(csState.getCssSpeed());
        /**
         * 设置转速
         */
        stateDTO.setRotateSpeed(csState.getCssMotor());
        /**
         * 设置FuelQuantity
         */
        stateDTO.setFuelQuantity(csState.getCssOil());
        /**
         * 设置电量
         */
        stateDTO.setPower(csState.getCssPower());
        /**
         * 设置Soc
         */
        stateDTO.setSoc(csState.getCssEvBattery());
        /**
         * 设置充电
         */
        stateDTO.setCharging(csState.getCssCharging());
        /**
         * 设置FuelMileage
         */
        stateDTO.setFuelMileage(csState.getCssFuelMileage());
        /**
         * 设置ElectricMileage
         */
        stateDTO.setElectricMileage(csState.getCssElectricMileage());
        /**
         * 设置Endurance
         */
        stateDTO.setEndurance(csState.getCssEndurance());
        /**
         * 设置温度值
         */
        stateDTO.setTemperature(csState.getCssTemperature());
        /**
         * 设置Csq
         */
        stateDTO.setCsq(csState.getCssCsq());
        /**
         * 设置经度
         */
        stateDTO.setLongitude(csState.getCssLongitude());
        /**
         * 设置纬度
         */
        stateDTO.setLatitude(csState.getCssLatitude());
        /**
         * 设置GPS验证
         */
        stateDTO.setGpsValid(csState.getCssGpsValid());
        /**
         * 设置GpsCn
         */
        stateDTO.setGpsCn(csState.getCssGpsCn());
        /**
         * 设置GpsCount
         */
        stateDTO.setGpsCount(csState.getCssGpsCount());
        /**
         * 设置DirAngle
         */
        stateDTO.setDirAngle(csState.getCssDir());
        /**
         * 设置Circular
         */
        stateDTO.setCircular(csState.getCssCircular());
        /**
         * 设置Ptc
         */
        stateDTO.setPtc(csState.getCssPtc());
        /**
         * 设置Compress
         */
        stateDTO.setCompress(csState.getCssCompres());
        /**
         * 设置Fan
         */
        stateDTO.setFan(csState.getCssFan());
        /**
         * 设置Saving
         */
        stateDTO.setSaving(csState.getCssSaving());
        /**
         * 设置开门
         */
        stateDTO.setDoor(csState.getCssDoor());
        /**
         * 设置驱动机
         */
        stateDTO.setEngine(csState.getCssEngine());
        /**
         * 设置Key
         */
        stateDTO.setKey(csState.getCssKey());
        /**
         * 设置Gear
         */
        stateDTO.setGear(csState.getCssGear());
        /**
         * 设置Light
         */
        stateDTO.setLight(csState.getCssLight());
        /**
         * 设置锁
         */
        stateDTO.setLock(csState.getCssLock());
        /**
         * 设置网络类型
         */
        stateDTO.setNetType(csState.getCssNetType());
        /**
         * 设置基本Lac
         */
        stateDTO.setBaseLac(csState.getCssBaseLac());
        /**
         * 设置基本Ci
         */
        stateDTO.setBaseCi(csState.getCssBaseCi());
        /**
         * 设置Order
         */
        stateDTO.setOrder(csState.getCssOrder());
        /**
         * 设置Autopilot
         */
        stateDTO.setAutopilot(csState.getCssAutopilot());
        /**
         * 设置Handbrake
         */
        stateDTO.setHandbrake(csState.getCssHandbrake());
        stateDTO.setSourceHex(csState.getCssMoData());
        return stateDTO;
    }
}
