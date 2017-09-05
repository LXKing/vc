package com.ccclubs.engine.rule.inf.util;

import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.common.query.QueryCanService;
import com.ccclubs.common.query.QueryStateService;
import com.ccclubs.engine.core.util.MachineMapping;
import com.ccclubs.engine.core.util.RedisHelper;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.core.util.TerminalUtils;
import com.ccclubs.mongo.orm.model.CsHistoryCan;
import com.ccclubs.mongo.orm.model.CsHistoryState;
import com.ccclubs.protocol.dto.jt808.*;
import com.ccclubs.protocol.dto.mqtt.can.CanDataTypeI;
import com.ccclubs.protocol.dto.mqtt.can.CanStatusZotye;
import com.ccclubs.protocol.util.*;
import com.ccclubs.pub.orm.model.CsCan;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Component
public class LogicHelperJt808 {

    private static Logger logger = LoggerFactory.getLogger(LogicHelperJt808.class);

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private TerminalUtils terminalUtils;

    @Resource
    UpdateStateService updateStateService;

    @Resource
    UpdateCanService updateCanService;

    @Resource
    QueryStateService queryStateService;

    @Resource
    QueryCanService queryCanService;
    @Resource
    RedisHelper redisHelper;

    /**
     * 保存状态数据
     *
     * @param message 上传
     * @param jvi     0x0200数据
     */
    public void saveStatusData(final T808Message message, final JT_0200 jvi) {
        try {
            HashOperations ops = redisTemplate.opsForHash();
            MachineMapping mapping = (MachineMapping) ops.get(RuleEngineConstant.REDIS_KEY_VIN, message.getSimNo());
            if (mapping == null || mapping.getMachine() == null || StringUtils.empty(mapping.getNumber())) {
                return;
            }
            CsMachine csMachine = new CsMachine();
            csMachine.setCsmAccess(mapping.getAccess().intValue());
            csMachine.setCsmHost(mapping.getHost().intValue());
            csMachine.setCsmNumber(mapping.getNumber());

            CsVehicle csVehicle = new CsVehicle();
            if (mapping.getCar() == null) {
                csVehicle = null;
            } else {
                csVehicle.setCsvId(mapping.getCar().intValue());
            }

            CsState csState = terminalUtils.setCsStatus(csVehicle, csMachine);

            csState.setCssNumber(csMachine.getCsmNumber());
            csState.setCssCsq(jvi.getCsq());
            csState.setCssCurrentTime(StringUtils.date(jvi.getTime(), ConstantUtils.TIME_FORMAT));
            csState.setCssDir("0");
            csState.setCssAddTime(new Date());
            csState.setCssGpsValid(jvi.isValid() ? (byte) 1 : (byte) 0);
            // 保存的 消息体
            csState.setCssMoData(message.getPacketDescr());

            CsState newState;
            if (mapping.getState() != null) {
                csState.setCssId(mapping.getState().intValue());
                if (ProtocolTools.isValid(jvi.getLongitude(), jvi.getLatitude())) {
                    BigDecimal bigDecimalLong = AccurateOperationUtils.mul(jvi.getLongitude(), 0.000001);
                    csState.setCssLongitude(bigDecimalLong.setScale(6, BigDecimal.ROUND_HALF_UP));
                    BigDecimal bigDecimalLat = AccurateOperationUtils.mul(jvi.getLatitude(), 0.000001);
                    csState.setCssLatitude(bigDecimalLat.setScale(6, BigDecimal.ROUND_HALF_UP));
                }
                // TODO: 依据系统车型解析出CAN数据对应的SOC，OBD里程
                Can2State can2State = (Can2State) ops.get(RuleEngineConstant.REDIS_KEY_CAN2STATE, message.getSimNo());
                if (can2State != null) {
                    if (can2State.getSoc() != 0) {
                        csState.setCssEvBattery((byte) can2State.getSoc());
                    }
                    if (can2State.getObdMiles() != 0) {
                        csState.setCssObdMile(can2State.getObdMiles());
                    }
                }
                updateStateService.update(csState);

                newState = queryStateService.queryStateById(mapping.getState().intValue());
            } else {
                // 808 原始0200数据，以下业务数据不做更新
                csState.setCssOrder(0l);
                csState.setCssWarn(0);
                csState.setCssPower(0);
                csState.setCssMileage(0);
                csState.setCssTemperature((short) 0);
                csState.setCssEngineT(0);
                csState.setCssOil("0");
                csState.setCssRented("0");
                csState.setCssPower(0);
                csState.setCssFuelMileage("0");
                csState.setCssElectricMileage("0");

                csState.setCssCircular((byte) 0);
                csState.setCssPtc((byte) 0);
                csState.setCssCompres((byte) 0);
                csState.setCssFan((byte) 0);
                csState.setCssSaving((byte) 0);
                csState.setCssDoor("0");

                // TODO:依据车型Can解析
                csState.setCssEvBattery((byte) 0);
                csState.setCssObdMile(0);
                csState.setCssSpeed((short) (jvi.getSpeed() * 0.1));
                csState.setCssMotor(0);
                csState.setCssEndurance("0");
                csState.setCssCharging((byte) 0);

                csState.setCssNetType((byte) 0);
                csState.setCssBaseLac(0);
                csState.setCssBaseCi(0);

                csState.setCssLongitude(AccurateOperationUtils.mul(jvi.getLongitude(), 0.000001));
                csState.setCssLatitude(AccurateOperationUtils.mul(jvi.getLatitude(), 0.000001));

                newState = updateStateService.insert(csState);
            }

            if (newState != null) {
                saveHistoryData(newState);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

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

    /**
     * 保存CAN数据
     *
     * @param message 上传
     * @param canData 0x0900 透传数据
     */
    public void saveCanData(final T808Message message, final JT_0900_can canData) {
        try {
            HashOperations ops = redisTemplate.opsForHash();
            MachineMapping mapping = (MachineMapping) ops.get(RuleEngineConstant.REDIS_KEY_SIMNO, message.getSimNo());
            if (mapping == null || mapping.getMachine() == null || StringUtils.empty(mapping.getNumber())) {
                redisHelper.setNotExist(message.getSimNo(), true);
                return;
            }
            CsMachine csMachine = new CsMachine();
            csMachine.setCsmAccess(mapping.getAccess() == null ? null : mapping.getAccess().intValue());
            csMachine.setCsmHost(mapping.getHost() == null ? null : mapping.getHost().intValue());
            csMachine.setCsmNumber(mapping.getNumber());

            CsVehicle csVehicle = new CsVehicle();
            if (mapping.getCar() == null) {
                csVehicle = null;
            } else {
                csVehicle.setCsvId(mapping.getCar() == null ? null : mapping.getCar().intValue());
            }

            CsCan csCan = terminalUtils.setCsCan(csVehicle, csMachine);

            CanStatusZotye zotyeStatus = new CanStatusZotye();
            zotyeStatus.mCanNum = canData.getCount();
            zotyeStatus.mCanType = 0x01;
            zotyeStatus.mCarNum = csMachine.getCsmNumber();
            zotyeStatus.mFucCode = 0x69;
            zotyeStatus.mOrderId = 0;
            zotyeStatus.mSubfuc = 0x05;
            zotyeStatus.mTime = ProtocolTools
                    .transformToTerminalTime(StringUtils.date(canData.getTime(), ConstantUtils.TIME_FORMAT));

            MyBuffer buff = new MyBuffer();
            buff.put(zotyeStatus.getBytes());

            int soc = 0;
            int obdMiles = 0;

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
                if (mapping.getAccess() != null && mapping.getAccess() != 3 && mapping.getAccess() != 4
                        && mapping.getAccess() != 5) {
                    if (canDataTypeI.mCanId == 0x302) {
                        soc = canDataTypeI.mCanData5;
                    } else if (canDataTypeI.mCanId == 0x380) {
                        obdMiles =
                                (canDataTypeI.mCanData3 & 0xff) * 65536 + (canDataTypeI.mCanData4 & 0xff) * 256 + (
                                        canDataTypeI.mCanData5 & 0xff);
                    }
                }
            }

            // 通过 can 更新 soc，obdmiles
            if (mapping.getState() != null && (soc != 0 || obdMiles != 0)) {
                Can2State can2StateRedis = (Can2State) ops.get(RuleEngineConstant.REDIS_KEY_CAN2STATE, message.getSimNo());
                if (can2StateRedis != null) {
                    if (soc != 0) {
                        can2StateRedis.setSoc(soc);
                    }
                    if (obdMiles != 0) {
                        can2StateRedis.setObdMiles(obdMiles);
                    }
                } else {
                    can2StateRedis = new Can2State();
                    can2StateRedis.setObdMiles(0);
                    can2StateRedis.setSoc(0);
                }
                ops.put(RuleEngineConstant.REDIS_KEY_CAN2STATE, message.getSimNo(), can2StateRedis);//Can2State.class,
            }

            final String hexString = Tools.ToHexString(buff.array());

            csCan.setCscAddTime(new Date());
            csCan.setCscNumber(csMachine.getCsmNumber());
            csCan.setCscData(hexString);
            csCan.setCscType((short) 1);
            csCan.setCscUploadTime(StringUtils.date(canData.getTime(), ConstantUtils.TIME_FORMAT));
            csCan.setCscOrder(0l);

            final String errorInfo = "";// CanHelperFactory.parseCanErrorData(canDataStr);
            csCan.setCscFault(errorInfo);

            CsCan csCanNew;
            if (mapping.getCan() != null) {
                csCan.setCscId(mapping.getCan());
                updateCanService.update(csCan);
                csCanNew = queryCanService.queryCanById(mapping.getCan());
            } else {
                csCanNew = updateCanService.insert(csCan);
            }
            if (csCanNew != null) {
                saveHistoryCan(csCanNew, null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存补发CAN数据
     *
     * @param message 上传
     * @param canData 0x0900 透传数据
     */
    public void saveCanData(final T808Message message, final JT_0900_can canData,
                            final String type) {
        try {
            ValueOperations<String, Object> ops = redisTemplate.opsForValue();
            MachineMapping mapping = (MachineMapping) ops.get(message.getSimNo());
            if (mapping == null || mapping.getMachine() == null || StringUtils.empty(mapping.getNumber())) {
                redisHelper.setNotExist(message.getSimNo(), true);
                return;
            }

            CanStatusZotye zotyeStatus = new CanStatusZotye();
            zotyeStatus.mCanNum = canData.getCount();
            zotyeStatus.mCanType = 0x01;
            zotyeStatus.mCarNum = mapping.getNumber();
            zotyeStatus.mFucCode = 0x69;
            zotyeStatus.mOrderId = 0;
            zotyeStatus.mSubfuc = 0x05;
            zotyeStatus.mTime = (int) (((new Date()).getTime() - ConstantUtils.MACHINE_TIME) / 1000);

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

            CsCan csCanNew;
            if (mapping.getCan() != null) {
                csCanNew = queryCanService.queryCanById(mapping.getCan());
            } else {
                return;
            }
            if (csCanNew != null) {
                // 设置上传时间，原始数据
                csCanNew.setCscUploadTime(StringUtils.date(canData.getTime(), ConstantUtils.TIME_FORMAT));
                csCanNew.setCscData(hexString);
                saveHistoryCan(csCanNew, type);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 历史状态数据保存
     */
    private void saveHistoryCan(CsCan csCan, String type) {

        CsHistoryCan csHistoryCan = new CsHistoryCan();

//    csHistoryCan.setCshcAccess(csCan.getCscAccess());
//    csHistoryCan.setCshcHost(csCan.getCscHost());
//    csHistoryCan.setCshcCar(csCan.getCscCar());
//    csHistoryCan.setCshcModel(csCan.getCscModel());

        csHistoryCan.setCshcAddTime(new Date());
        csHistoryCan.setCshcNumber(csCan.getCscNumber().trim());
        csHistoryCan.setCshcData(csCan.getCscData());
        csHistoryCan.setCshcType(csCan.getCscType());
        csHistoryCan.setCshcUploadTime(csCan.getCscUploadTime());
        csHistoryCan.setCshcOrder(csCan.getCscOrder());

        csHistoryCan.setCshcFault(csCan.getCscFault());
        updateCanService.insertHis(csHistoryCan);
    }

    public static String getClassName(Class modelClass) {
        return modelClass.getName().replaceAll("[^\\.]*\\.", "");
    }
}
