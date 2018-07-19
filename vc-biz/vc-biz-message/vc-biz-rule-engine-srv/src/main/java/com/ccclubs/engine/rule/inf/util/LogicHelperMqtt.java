/*
 * Copyright 2012 The ccclubs_iot_platform Project
 *
 * The ccclubs_iot_platform Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * the structure of the project is underline-
 *
 * --vc-biz
 *   --vc-biz-command-inf
 *     1.各个协议下发命令的命令结构，定义发送命令的接口
 *   --vc-biz-command-srv
 *     1.各个协议下命令发送的具体实现
 *       参数校验
 *       校验车辆与终端绑定关系是否正常
 *       检查终端是否在线
 *         查询指令结构体定义
 *         保存记录
 *         发送指令
 *         确认结果
 *   --vc-biz-common-srv
 *     1.切面定义
 *     2.公共的一些服务类实现
 *     3.公共工具类
 *   --vc-biz-influxdb-inf
 *     1.用于实时数据监控分析的接口定义
 *   --vc-biz-influx-srv
 *     1.用于实时数据监控分析的接口实现
 *   --vc-biz-message
 *     --vc-biz-cmd-engine-inf
 *       1.mqAckService接口定义
 *       2.mqMessageSender接口定义
 *     --vc-biz-cmd-engine-srv
 *     --vc-biz-engine-core
 *       各种工具类
 *     --vc-biz-gateway
 *       1.各个协议对应网关的实现
 *         消息编解码的实现
 *       2.解码后的消息处理
 *     --vc-biz-rule-engine-inf
 *     --vc-biz-rule-engine-srv
 *     --vc-biz-upgrade-inf
 *       1.终端升级相关数据模型和接口定义
 *     --vc-biz-upgrade-srv
 *       1.终端升级服务接口的实现
 *   --vc-biz-mongo-inf
 *     1.mongo服务接口的定义，历史数据模型
 *   --vc-biz-mongo-orm
 *     1.mongo数据查询接口实现
 *     2.部分接口声明
 *   --vc-biz-mongo-srv
 *     1.mongo服务接口实现
 *       CsLoggerService
 *       CsRemoteService
 *       CsVehicleExpService
 *   --vc-biz-phoenix-inf
 *   --vc-biz-phoenix-orm
 *   --vc-biz-phoenix-srv
 *   --vc-biz-protocol-inf
 *     1.各种协议的dto的实体
 *     2.各种协议的数据包抽象接口声明
 *     3.相关工具类
 *   --vc-biz-protocol-srv
 *     1.对应各种协议中的各类型的消息包实体的组装
 *     2.相应事件的数据包实体组装
 *   --vc-biz-pub-model
 *     1.公共的一些数据库中的数据模型
 *   --vc-biz-pub-orm
 *     1.公共的一些数据库的模型对应的Mapper
 *         这些 *Mapper.java和*Mapper.xml是有MybatisGenerator生成的
 *   --vc-biz-quota-inf
 *     1.一些指标类接口的定义
 *   --vc-biz-quota-model
 *     1.一些业务表的实体声明
 *         // 下面列出所有实体的对应的表和表意义
 *   --vc-biz-quota-orm
 *   --vc-biz-quota-srv
 *     1.指标类接口实现
 *   --vc-biz-storage-inf
 *   --vc-biz-storage-srv
 *   --vc-biz-terminal-inf
 *     1.终端信息查询等dto定义（xxInput）
 *     2.查询终端自身配置信息等接口声明
 *   --vc-biz-terminal-srv
 *     1.终端信息接口实现类
 *   --vc-biz-usr-orm
 *     1.用户组等用户信息查询实体和Mapper
 *   --vc-biz-vehicle-inf
 *   --vc-biz-vehicle-srv
 *     1.机车绑定信息等机车类接口实现
 * --vc-env
 *    --一些连接等等配置信息集合
 *
 * --vc-frm
 *   1.对于整个框架中的摸个模块提供框架（配置等的）支持
 *   --vc-frm-cache
 *   --vc-frm-core
 *   --vc-frm-dubbox
 *   --vc-frm-encryp
 *   --vc-frm-influxdb
 *   --vc-frm-logger
 *   --vc-frm-mongo
 *   --vc-frm-mqtt
 *   --vc-frm-mybatis
 *   --vc-frm-ons
 *   --vc-frm-phoenix
 *   --vc-frm-redis
 *   --vc-frm-spring
 *   --vc-frm-swagger
 *   --vc-frm-test
 *   --vc-frm-token
 *   --vc-frm-validation
 *
 * --vc-web
 *   1.暴露各个服务接口
 *   2.提供各个模块应用启动类
 *   --vc-web-cfg
 *     1.SpringCloud的配置中心支持
 *   --vc-web-command-api
 *     1.对外暴露指令接口服务
 *   --vc-web-command-srv
 *   --vc-web-front
 *     1.管理后台系统
 *   --vc-web-message
 *     1.cmd engine start class
 *     2.提供了各种各样的启动类
 *   --vc-web-phoenix-api
 *   --vc-web-phoenix-srv
 *   --vc-web-quota-api
 *   --vc-web-quota-srv
 *   --vc-web-vtsearch-api
 *   --vc-web-vtsearch-srv
 */

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
     * 保存状态数据
     */
    @Timer
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
        // 设置css号码
        csState.setCssNumber(message.getCarNumber());
        // 设置添加时间
        csState.setCssAddTime(new Date());
        // 设置cssrented
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
        //目前档位信息不对，暂时不用
        // csState.setCssGear(mqtt_66.getGear());
        csState.setCssOrder(message.getTransId());
        // 设置css报警
        csState.setCssWarn(mqtt_66.getAlarmType() & 0xFFFF);
        // 设置温度
        csState.setCssTemperature(new BigDecimal(mqtt_66.getTemperature() & 0xFF));
        // 设置CssCsq
        csState.setCssCsq((short) (mqtt_66.getCsq() & 0xFF));
        /**
         * 设置css当前时间
         */
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
             * 校验经纬度
             * 是否合法
             */
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
            /**
             * 向
             * redis
             * 中
             * lpush
             * 数
             * 据
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
             * 如果
             *      state==null
             * 设置经纬度后，插入当前状态
             */
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
        /**
         * 保存状态信息
         */
        if (mqtt_68_03 == null || mqtt_68_03.getCcclubs_60() == null) {
            // 直接返回
            return;
        }
        // 构造一个新的车机对象
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
        return stateDTO;
    }
}
