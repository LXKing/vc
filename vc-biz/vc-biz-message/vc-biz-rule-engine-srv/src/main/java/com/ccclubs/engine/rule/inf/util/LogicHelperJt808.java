package com.ccclubs.engine.rule.inf.util;

import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_RECENT_STATES;
import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_RT_STATES;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.common.query.QueryCanService;
import com.ccclubs.common.query.QueryStateService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.core.util.TerminalUtils;
import com.ccclubs.frm.spring.constant.KafkaConst;
import com.ccclubs.frm.spring.util.UuidUtil;
import com.ccclubs.helper.MachineMapping;
import com.ccclubs.protocol.dto.jt808.JT_0200;
import com.ccclubs.protocol.dto.jt808.JT_0900_can;
import com.ccclubs.protocol.dto.jt808.JT_0900_can_item;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.mqtt.can.CanDataTypeI;
import com.ccclubs.protocol.dto.mqtt.can.CanStatusZotye;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.pub.orm.dto.Jt808PositionData;
import com.ccclubs.pub.orm.dto.StateDTO;
import com.ccclubs.pub.orm.dto.TboxLog;
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
 * 消息解析、入库帮助类
 *
 * @author jhy
 */
@Component
public class LogicHelperJt808 {

    private static Logger logger = LoggerFactory.getLogger(LogicHelperJt808.class);

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private KafkaTemplate kafkaTemplate;

    /**
     * 历史can数据topic
     */
    @Value("${" + KafkaConst.KAFKA_TOPIC_CAN + "}")
    String kafkaTopicCsCan;

    /**
     * 历史can-exp
     */
    @Value("${" + KafkaConst.KAFKA_TOPIC_CAN_EXP + "}")
    String kafkaTopicCsCanExp;

    /**
     * 位置数据
     */
    @Value("${" + KafkaConst.KAFKA_TOPIC_JT_POSITION + "}")
    String kafkaTopicJt808Position;

    /**
     * 位置数据exp
     */
    @Value("${" + KafkaConst.KAFKA_TOPIC_JT_POSITION_EXP + "}")
    String kafkaTopicJt808PositionExp;

    @Value("${" + KafkaConst.KAFKA_TOPIC_TBOX_LOG + ":topic_tbox_log}")
    String tboxLogTopic;

    @Value("${" + KafkaConst.KAFKA_TOPIC_TBOX_LOG_EXP + ":topic_tbox_log_exp}")
    String tboxLogTopicExp;

    @Resource
    private TerminalUtils terminalUtils;

    /**
     * 车机状态更新
     */
    @Resource
    private UpdateStateService updateStateService;

    @Resource
    UpdateCanService updateCanService;

    @Resource
    QueryVehicleService queryVehicleService;

    /**
     * CAN查询
     */
    @Resource
    QueryCanService queryCanService;

    /**
     * 状态查询
     */
    @Resource
    QueryStateService queryStateService;

    @Resource
    QueryTerminalService queryTerminalService;

    /**
     * 保存状态数据,只有JT_0200位置数据
     * <p>
     * 1.不发kafka[topic_mqtt_state]，以免影响大数据分析的数据准确性
     * <p>
     * 2.不在redis存储实时状态数据，以免影响业务平台调用api:getRealTimeState
     * <p>
     * 3.不存储最近30条状态数据,只有位置数据,基本上无法用来做实时计算分析
     *
     * @param message 上传
     * @param jvi     0x0200数据
     */
    //@Timer
    public void saveStatusData(final MachineMapping mapping, final T808Message message,
            final JT_0200 jvi) {
        try {
            // 根据Mapping 设置 车机对象
            CsMachine csMachine = new CsMachine();
            csMachine
                    .setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
            csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
            csMachine.setCsmNumber(mapping.getNumber());

            CsVehicle csVehicle = new CsVehicle();
            if (mapping.getCar() == null) {
                csVehicle = null;
            } else {
                csVehicle.setCsvId(mapping.getCar().intValue());
            }

            if (mapping.getState() != null) {
                CsState csState = terminalUtils.setCsStatus(csVehicle, csMachine);
                // 设置 CAR
                // 加入Vin add by jhy 2018.5.8
                csState.setCssVin(mapping.getVin());
                csState.setCssCar(mapping.getCar() == null ? 0 : mapping.getCar().intValue());
                csState.setCssCsq(jvi.getCsq());
                csState.setCssCurrentTime(
                        StringUtils.date(jvi.getTime(), ConstantUtils.TIME_FORMAT));
                csState.setCssAddTime(new Date());
                csState.setCssGpsValid(jvi.isValid() ? (byte) 1 : (byte) 0);
                // 保存的 消息体
                csState.setCssMoData(message.getPacketDescr());

                csState.setCssId(mapping.getState().intValue());
                if (ProtocolTools.isValid(jvi.getLongitude(), jvi.getLatitude())) {
                    BigDecimal bigDecimalLong = AccurateOperationUtils
                            .mul(jvi.getLongitude(), 0.000001);
                    csState.setCssLongitude(bigDecimalLong.setScale(6, BigDecimal.ROUND_HALF_UP));
                    BigDecimal bigDecimalLat = AccurateOperationUtils
                            .mul(jvi.getLatitude(), 0.000001);
                    csState.setCssLatitude(bigDecimalLat.setScale(6, BigDecimal.ROUND_HALF_UP));
                }

                // 需要更新的当前状态加入等待队列
                ListOperations opsForList = redisTemplate.opsForList();
                opsForList.leftPush(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, csState);

            } else {
                // 车机状态为空
                // 808 原始0200数据，以下业务数据不做更新
                CsState csStateInsert = terminalUtils.setCsStatus(csVehicle, csMachine);
                csStateInsert.setCssVin(mapping.getVin());
                csStateInsert.setCssNumber(mapping.getNumber());
                csStateInsert.setCssCsq(jvi.getCsq());
                csStateInsert.setCssCurrentTime(
                        StringUtils.date(jvi.getTime(), ConstantUtils.TIME_FORMAT));
                csStateInsert.setCssAddTime(new Date());
                csStateInsert.setCssGpsValid(jvi.isValid() ? (byte) 1 : (byte) 0);
                // 保存的 消息体
                csStateInsert.setCssMoData(message.getPacketDescr());
                csStateInsert.setCssOrder(0L);
                csStateInsert.setCssWarn(0);
                csStateInsert.setCssPower(0);
                csStateInsert.setCssMileage(BigDecimal.ZERO);
                csStateInsert.setCssTemperature(BigDecimal.ZERO);
                csStateInsert.setCssEngineT(BigDecimal.ZERO);
                csStateInsert.setCssOil(BigDecimal.ZERO);
                csStateInsert.setCssRented("0");
                csStateInsert.setCssPower(0);
                csStateInsert.setCssFuelMileage(BigDecimal.ZERO);
                csStateInsert.setCssElectricMileage(BigDecimal.ZERO);

                csStateInsert.setCssCircular((byte) 0);
                csStateInsert.setCssPtc((byte) 0);
                csStateInsert.setCssCompres((byte) 0);
                csStateInsert.setCssFan((byte) 0);
                csStateInsert.setCssSaving((byte) 0);
                csStateInsert.setCssDoor("0");

                // TODO:依据车型Can解析
                csStateInsert.setCssEvBattery((byte) 0);
                csStateInsert.setCssObdMile(BigDecimal.ZERO);
                csStateInsert.setCssSpeed(BigDecimal.ZERO);
                csStateInsert.setCssMotor(0);
                csStateInsert.setCssEndurance(BigDecimal.ZERO);
                csStateInsert.setCssCharging((byte) 0);
                csStateInsert.setCssNetType((byte) 0);
                csStateInsert.setCssBaseLac(0);
                csStateInsert.setCssBaseCi(0);

                csStateInsert
                        .setCssLongitude(AccurateOperationUtils.mul(jvi.getLongitude(), 0.000001));
                csStateInsert
                        .setCssLatitude(AccurateOperationUtils.mul(jvi.getLatitude(), 0.000001));

                updateStateService.insert(csStateInsert);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 保存Geo数据 发kafka[topic_jt_position]
     *
     * @param message 上传
     * @param jvi     0x0200数据
     */
    //@Timer
    public void saveGeoData(final MachineMapping mapping, final T808Message message,
            final JT_0200 jvi) {
        try {
            CsVehicle csVehicle = new CsVehicle();
            if (mapping.getCar() == null) {
                csVehicle = null;
            } else {
                csVehicle.setCsvId(mapping.getCar().intValue());
            }
            // 组装位置数据 add by jhy 2018.5.9
            Jt808PositionData jt808PositionData = new Jt808PositionData();
            jt808PositionData.setVin(mapping.getVin());
            jt808PositionData
                    .setAccess(mapping.getAccess() == null ? null : mapping.getAccess().intValue());
            jt808PositionData.setTeNumber(mapping.getNumber());
            jt808PositionData.setTeNo(mapping.getTeno());
            jt808PositionData.setIccid(mapping.getIccid());
            jt808PositionData.setMobile(mapping.getMobile());
            jt808PositionData.setAlarmFlag(jvi.getAlarmFlag());
            jt808PositionData.setAltitude(new BigDecimal(jvi.getAltitude()));
            jt808PositionData.setCourse(new BigDecimal(jvi.getCourse()));
            jt808PositionData.setCurrentTime(jvi.getTime() == null ? System.currentTimeMillis() :
                    StringUtils.date(jvi.getTime(), ConstantUtils.TIME_FORMAT).getTime());
            jt808PositionData.setGpsValid(jvi.isValid() ? 1 : 0);
            if (ProtocolTools.isValid(jvi.getLongitude(), jvi.getLatitude())) {
                BigDecimal bigDecimalLong = AccurateOperationUtils
                        .mul(jvi.getLongitude(), 0.000001);
                jt808PositionData
                        .setLongitude(bigDecimalLong.setScale(6, BigDecimal.ROUND_HALF_UP));
                BigDecimal bigDecimalLat = AccurateOperationUtils.mul(jvi.getLatitude(), 0.000001);
                jt808PositionData.setLatitude(bigDecimalLat.setScale(6, BigDecimal.ROUND_HALF_UP));
            }
            jt808PositionData.setNetStrength(jvi.getCsq());
            jt808PositionData.setSourceHex(message.getPacketDescr());
            jt808PositionData.setGpsSpeed(new BigDecimal(jvi.getSpeed()));
            jt808PositionData.setStatus(jvi.getStatus());
            // 发送808历史位置数据到kafka
            if (StringUtils.empty(mapping.getVin())) {
                kafkaTemplate.send(kafkaTopicJt808PositionExp,
                        JSONObject.toJSONString(jt808PositionData));
            } else {
                kafkaTemplate
                        .send(kafkaTopicJt808Position, JSONObject.toJSONString(jt808PositionData));
            }

            //808数据且未安装分时租赁插件的,位置数据更新实时状态redis
            CsMachine csMachine = queryTerminalService
                    .queryCsMachineByCarNumber(mapping.getNumber());
            if (csMachine != null && (csMachine.getCsmTlV2() == null
                    || csMachine.getCsmTlV2() == 0)) {
                CsState state = new CsState();
                state.setCssTeNo(csMachine.getCsmTeNo());
                state.setMobile(csMachine.getCsmMobile());
                state.setIccid(csMachine.getCsmIccid());
                state.setCssAccess(csMachine.getCsmAccess().shortValue());
                state.setCssCurrentTime(new Date(jt808PositionData.getCurrentTime()));
                state.setCssLatitude(jt808PositionData.getLatitude());
                state.setCssLongitude(jt808PositionData.getLongitude());
                state.setCssCsq(jvi.getCsq());
                state.setCssGpsValid(jt808PositionData.getGpsValid().byteValue());
                state.setCssSpeed(jt808PositionData.getGpsSpeed());
                state.setCssMoData(message.getPacketDescr());
                redisTemplate.opsForHash().put(REDIS_KEY_RT_STATES, mapping.getNumber(), state);
            }
            //保存长安状态历史数据30条至redis
            if (mapping.getAccess() == 3 || mapping.getAccess() == 4 || mapping.getAccess() == 5) {
                if (csMachine != null && (csMachine.getCsmTlV2() == null
                        || csMachine.getCsmTlV2() == 0)) {
                    StateDTO stateDTO = new StateDTO();
                    stateDTO.setCurrentTime(new Date(jt808PositionData.getCurrentTime()));
                    stateDTO.setLatitude(jt808PositionData.getLatitude());
                    stateDTO.setLongitude(jt808PositionData.getLongitude());
                    stateDTO.setCsq(jvi.getCsq());
                    stateDTO.setGpsValid(jt808PositionData.getGpsValid().byteValue());
                    stateDTO.setSpeed(jt808PositionData.getGpsSpeed());
                    stateDTO.setSourceHex(message.getPacketDescr());
                    redisTemplate.opsForList()
                            .leftPush(REDIS_KEY_RECENT_STATES + mapping.getNumber(), stateDTO);
                    Long queueSize = redisTemplate.opsForList()
                            .size(REDIS_KEY_RECENT_STATES + mapping.getNumber());
                    if (queueSize >= 30) {
                        redisTemplate.opsForList()
                                .trim(REDIS_KEY_RECENT_STATES + mapping.getNumber(), 0, 29);
                    }
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 保存CAN数据
     *
     * @param message 上传
     * @param canData 0x0900 透传数据
     */
    //@Timer
    public void saveCanData(MachineMapping mapping, final T808Message message,
            final JT_0900_can canData) {
        try {
            CsMachine csMachine = new CsMachine();
            csMachine
                    .setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
            csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
            csMachine.setCsmNumber(mapping.getNumber());

            CsVehicle csVehicle = new CsVehicle();
            if (mapping.getCar() == null) {
                csVehicle = null;
            } else {
                csVehicle.setCsvId(mapping.getCar() == null ? null : mapping.getCar().intValue());
            }

            // 设置CAN状态
            CsCan csCan = terminalUtils.setCsCan(csVehicle, csMachine);

            CanStatusZotye zotyeStatus = new CanStatusZotye();
            zotyeStatus.mCanNum = canData.getCount();
            zotyeStatus.mCanType = 0x01;
            zotyeStatus.mCarNum = csMachine.getCsmNumber();
            zotyeStatus.mFucCode = 0x69;
            zotyeStatus.mOrderId = 0;
            zotyeStatus.mSubfuc = 0x05;
            zotyeStatus.mTime = ProtocolTools
                    .transformToTerminalTime(
                            StringUtils.date(canData.getTime(), ConstantUtils.TIME_FORMAT));

            MyBuffer buff = new MyBuffer();
            buff.put(zotyeStatus.getBytes());

            int soc = 0;
            int obdMiles = 0;
            int speed = 0;

            // 遍历0900CAN数据
            for (JT_0900_can_item item : canData.getCanList()) {
                CanDataTypeI canDataTypeI = new CanDataTypeI();
                canDataTypeI.mCanLength = 0x08;
                canDataTypeI.mCanData1 = item.getmCanData1();
                canDataTypeI.mCanData2 = item.getmCanData2();
                canDataTypeI.mCanData3 = item.getmCanData3();
                canDataTypeI.mCanData4 = item.getmCanData4();
                canDataTypeI.mCanData5 = item.getmCanData5();
                canDataTypeI.mCanData6 = item.getmCanData6();
                canDataTypeI.mCanData7 = item.getmCanData7();
                canDataTypeI.mCanData8 = item.getmCanData8();
                canDataTypeI.mCanId = item.getCanId();
                buff.put(canDataTypeI.getBytes());

                // FIXME 不上长安出行，需要转换obd里程
                if (mapping.getAccess() != null && mapping.getAccess() != 3
                        && mapping.getAccess() != 4
                        && mapping.getAccess() != 5) {
                    if (canDataTypeI.mCanId == 0x302) {
                        soc = canDataTypeI.mCanData5;
                    } else if (canDataTypeI.mCanId == 0x380) {
                        obdMiles =
                                (canDataTypeI.mCanData3 & 0xff) * 65536
                                        + (canDataTypeI.mCanData4 & 0xff) * 256 + (
                                        canDataTypeI.mCanData5 & 0xff);
                    } else if (canDataTypeI.mCanId == 0x300) {
                        speed = (canDataTypeI.mCanData2 & 0xff);
                    }
                }
            }

            // 从buffer中获取原始16进制字符串
            final String hexString = Tools.ToHexString(buff.array());

            csCan.setCscVin(mapping.getVin());
            csCan.setCscAddTime(new Date());
            csCan.setCscNumber(csMachine.getCsmNumber());
            csCan.setCscData(hexString);
            csCan.setCscType((short) 1);
            csCan.setCscUploadTime(StringUtils.date(canData.getTime(), ConstantUtils.TIME_FORMAT));
            csCan.setCscOrder(0L);

            final String errorInfo = "";
            // CanHelperFactory.parseCanErrorData(canDataStr);
            csCan.setCscFault(errorInfo);

            if (mapping.getCan() != null) {
                csCan.setCscId(mapping.getCan());
                // 需要更新的当前CAN数据加入等待队列
                ListOperations opsForList = redisTemplate.opsForList();
                opsForList.leftPush(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE, csCan);
            } else {
                // 更新CAN
                updateCanService.insert(csCan);
            }

            // kafka发送can历史状态
            if (StringUtils.empty(mapping.getVin())) {
                kafkaTemplate.send(kafkaTopicCsCanExp, JSONObject.toJSONString(csCan));
            } else {
                kafkaTemplate.send(kafkaTopicCsCan, JSONObject.toJSONString(csCan));
            }

            // 众泰E200车型不包含分时租赁插件的终端需要更新obd里程跟SOC
            if (mapping.getAccess() != null && mapping.getAccess() != 3 && mapping.getAccess() != 4
                    && mapping.getAccess() != 5) {
                csMachine = terminalUtils.getMappingMachine(mapping);
                // 不含分时租赁插件的808终端 通过 can 更新 soc，obdmiles，speed
                if (!(csMachine.getCsmTlV2() != null && csMachine.getCsmTlV2() > 0)) {
                    if (mapping.getState() != null) {
                        CsState csState = queryStateService
                                .queryStateByIdFor808(mapping.getState().intValue());
                        if (soc != csState.getCssEvBattery()
                                || obdMiles != csState.getCssObdMile().intValue()
                                || speed != csState.getCssSpeed().intValue()) {
                            CsState csStateNew = new CsState();
                            csStateNew.setCssId(mapping.getState().intValue());
                            if (obdMiles != 0) {
                                csStateNew.setCssObdMile(new BigDecimal(obdMiles));
                            }
                            if (soc != 0) {
                                csStateNew.setCssEvBattery((byte) soc);
                            }
                            if (speed != csState.getCssSpeed().intValue()) {
                                csStateNew.setCssSpeed(new BigDecimal(speed));
                            }
                            csStateNew.setCssAddTime(new Date());
                            csStateNew.setCssCurrentTime(
                                    StringUtils.date(canData.getTime(), ConstantUtils.TIME_FORMAT));

                            updateStateService.updateFor808(csStateNew);
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

    /**
     * 保存补发CAN数据
     *
     * @param message 上传
     * @param canData 0x0900 透传数据
     */
    //@Timer
    public void saveCanData(MachineMapping mapping, final T808Message message,
            final JT_0900_can canData,
            final String type) {
        try {
            //long startTime = System.nanoTime();

            CanStatusZotye zotyeStatus = new CanStatusZotye();
            zotyeStatus.mCanNum = canData.getCount();
            zotyeStatus.mCanType = 0x01;
            zotyeStatus.mCarNum = mapping.getNumber();
            zotyeStatus.mFucCode = 0x69;
            zotyeStatus.mOrderId = 0;
            zotyeStatus.mSubfuc = 0x05;
            zotyeStatus.mTime = (int) (((new Date()).getTime() - ConstantUtils.MACHINE_TIME)
                    / 1000);

            MyBuffer buff = new MyBuffer();
            buff.put(zotyeStatus.getBytes());

            for (JT_0900_can_item item : canData.getCanList()) {
                CanDataTypeI canDataTypeI = new CanDataTypeI();
                canDataTypeI.mCanLength = 0x08;
                canDataTypeI.mCanData1 = item.getmCanData1();
                canDataTypeI.mCanData2 = item.getmCanData2();
                canDataTypeI.mCanData3 = item.getmCanData3();
                canDataTypeI.mCanData4 = item.getmCanData4();
                canDataTypeI.mCanData5 = item.getmCanData5();
                canDataTypeI.mCanData6 = item.getmCanData6();
                canDataTypeI.mCanData7 = item.getmCanData7();
                canDataTypeI.mCanData8 = item.getmCanData8();
                canDataTypeI.mCanId = item.getCanId();
                buff.put(canDataTypeI.getBytes());
            }

            final String hexString = Tools.ToHexString(buff.array());

            /*logger.info("saveCanData()2 init csCan time {} 微秒",
                    System.nanoTime() - startTime);*/

            CsCan csCanNew;
            if (mapping.getCan() != null) {
                // 获取车机号，access，host，car 等信息
                //startTime = System.nanoTime();
                csCanNew = queryCanService.queryCanById(mapping.getCan());
                /*logger.info("saveCanData()2 queryCanService.queryCanById time {} 微秒",
                        System.nanoTime() - startTime);*/
            } else {
                return;
            }
            if (csCanNew != null) {
                // 设置上传时间，原始数据
                //startTime = System.nanoTime();
                csCanNew.setCscVin(mapping.getVin());
                csCanNew.setCscUploadTime(
                        StringUtils.date(canData.getTime(), ConstantUtils.TIME_FORMAT));
                csCanNew.setCscData(hexString);
                // 处理can历史状态
                if (StringUtils.empty(mapping.getVin())) {
                    kafkaTemplate.send(kafkaTopicCsCanExp, JSONObject.toJSONString(csCanNew));
                } else {
                    kafkaTemplate.send(kafkaTopicCsCan, JSONObject.toJSONString(csCanNew));
                }

                /*logger.info("saveCanData()2 historyCanUtils.saveHistoryData time {} 微秒",
                        System.nanoTime() - startTime);*/
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 记录业务数据
     *
     * @param carNumber 车机号
     * @param content   主要内容
     * @param hexString 原始十六进制数据
     * @param order     订单号
     */
    public void transferTboxLog(String carNumber, String content, String hexString,
            Long order) {
        try {
            Long addTime = System.currentTimeMillis();
            //转发到kafka，存储HBASE
            TboxLog dto = new TboxLog();
            dto.setAddTime(addTime);
            dto.setLogInfo(content);
            dto.setOrderNo(order);
            dto.setTeNumber(carNumber);
            dto.setSourceHex(hexString);
            dto.setUuid(UuidUtil.getUuid());
            CsMachine csMachine = queryTerminalService.queryCsMachineByCarNumber(carNumber);
            if (csMachine == null) {
                csMachine = queryTerminalService.queryCsMachineBySimNo(carNumber);
                dto.setTeNumber(csMachine.getCsmNumber());
            }
            if (csMachine == null) {
                logger.error("车机号在系统中不存在,车机号[{}]", carNumber);
                dto.setAccess(0);
                kafkaTemplate.send(tboxLogTopicExp, JSONObject.toJSONString(dto));
            } else {
                CsVehicle csVehicle = queryVehicleService
                        .queryVehicleByMachineFromCache(csMachine.getCsmId());
                dto.setAccess(csMachine.getCsmAccess());
                if (csVehicle == null) {
                    kafkaTemplate.send(tboxLogTopicExp, JSONObject.toJSONString(dto));
                } else {
                    dto.setVin(csVehicle.getCsvVin());
                    kafkaTemplate.send(tboxLogTopic, JSONObject.toJSONString(dto));
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
