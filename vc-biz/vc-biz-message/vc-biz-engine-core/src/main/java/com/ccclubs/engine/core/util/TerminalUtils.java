package com.ccclubs.engine.core.util;


import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.mongodb.orm.dao.CsLoggerDao;
import com.ccclubs.mongodb.orm.model.CsAlarm;
import com.ccclubs.mongodb.orm.model.CsHistoryCan;
import com.ccclubs.mongodb.orm.model.CsHistoryState;
import com.ccclubs.mongodb.orm.model.CsLogger;
import com.ccclubs.protocol.dto.jt808.JT_0900_can;
import com.ccclubs.protocol.dto.jt808.JT_0900_can_item;
import com.ccclubs.protocol.dto.mqtt.CCCLUBS_60;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.mqtt.can.CanDataTypeI;
import com.ccclubs.protocol.dto.mqtt.can.CanStatusZotye;
import com.ccclubs.protocol.util.*;
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
import java.util.Date;


@Component
public class TerminalUtils {

    private static Logger logger = LoggerFactory.getLogger(TerminalUtils.class);

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    QueryTerminalService queryTerminalService;

    @Resource
    QueryVehicleService queryVehicleService;

    @Autowired
    CsLoggerDao csLoggerDao;

    /**
     * 通过车机号，手机号，VIN码 获取 MachineMapping
     */
    public MachineMapping getMapping(String keyPart, String info) {

        HashOperations ops = redisTemplate.opsForHash();
        final MachineMapping mapping = (MachineMapping) ops.get(keyPart, info);
        return mapping;
    }

    /**
     * 通过车机号，手机号，VIN码 获取 CsMachine
     */
    public CsMachine getMappingMachine(String keyPart, String info) {
        MachineMapping mapping = getMapping(keyPart, info);
        if (mapping == null) {
            return null;
        }
        CsMachine machine = queryTerminalService.queryCsMachineById(mapping.machine.intValue());
        return machine;
    }

    /**
     * 通过车机号，手机号，VIN码 获取 CsVehicle
     */
    public CsVehicle getMappingVehicle(String keyPart, String info) {
        MachineMapping mapping = getMapping(keyPart, info);
        if (mapping == null) {
            return null;
        }
        if (mapping.getCar() == null) {
            return null;
        }
        CsVehicle vehicle = queryVehicleService.queryVehicleById(mapping.getCar().intValue());
        return vehicle;
    }

    /**
     * 通过车机号查找对应的设备信息
     *
     * @param carNumber 车机号
     * @return CsMachine
     */
    public CsMachine getCsMachineByNumber(String keyPart, final String carNumber) {
        return getMappingMachine(keyPart, carNumber);
    }

    /**
     * 通过车机号查找对应的设备信息
     *
     * @param vin VIN码
     * @return CsVehicle
     */
    public CsVehicle getCsVehicleByVin(String keyPart, final String vin) {
        return getMappingVehicle(keyPart, vin);
    }

    /**
     * 通过手机号查找对应的设备信息
     *
     * @param simNo 手机号
     * @return CsMachine
     */
    public CsMachine getCsMachineBySim(String keyPart, final String simNo) {
        return getMappingMachine(keyPart, simNo);
    }

    /**
     * 通过终端号查找对应的设备信息
     *
     * @param terNo 终端号
     * @return CsMachine
     */
    public CsMachine getCsMachineByTerno(final String terNo) {
        CsMachine machine = queryTerminalService.queryTerminalByTeNo(terNo);
        return machine;
    }

    /**
     * 通过CsMachineId获取关联车辆
     *
     * @param csmId csMachineId 车机id
     * @return CsMachine
     */
    public CsVehicle getCsVehicle(final long csmId) {
        CsVehicle vehicle = queryVehicleService.queryVehicleByMachine(((Long) csmId).intValue());
        return vehicle;
    }

    /**
     * 设置当前状态 CsaAccess ，CsaHost，CsaCar
     */
    public CsAlarm setCsAlarm(CsVehicle csVehicle, CsMachine csMachine) {
        CsAlarm csAlarm = new CsAlarm();
        if (csVehicle == null) {
            csAlarm.setCsaAccess(csMachine.getCsmAccess() == null ? 0 : csMachine.getCsmAccess());
            csAlarm.setCsaHost(csMachine.getCsmHost() == null ? 0 : csMachine.getCsmHost());
            csAlarm.setCsaCar(0);
        } else {
            csAlarm.setCsaAccess(csMachine.getCsmAccess());
            csAlarm.setCsaHost(csMachine.getCsmHost());
            csAlarm.setCsaCar(csVehicle.getCsvId());
        }
        return csAlarm;
    }

    /**
     * 设置当前状态 CssAccess ，CssHost，CssCar
     */
    public CsState setCsStatus(CsVehicle csVehicle, CsMachine csMachine) {
        CsState csState = new CsState();
        if (csVehicle == null) {
            csState.setCssAccess(csMachine.getCsmAccess() == null ? (short) 0 : csMachine.getCsmAccess().shortValue());
            csState.setCssHost(csMachine.getCsmHost() == null ? (short) 0 : csMachine.getCsmHost().shortValue());
            csState.setCssCar(0);
        } else {
            csState.setCssAccess(csMachine.getCsmAccess().shortValue());
            csState.setCssHost(csMachine.getCsmHost().shortValue());
            csState.setCssCar(csVehicle.getCsvId());
        }
        return csState;
    }

    /**
     * 设置历史状态 CshsAccess ，CshsHost，CshsCar
     */
    public CsHistoryState setCsHistoryStatus(CsVehicle csVehicle, CsMachine csMachine) {
        CsHistoryState historyState = new CsHistoryState();
        if (csVehicle == null) {
            historyState.setCshsAccess(csMachine.getCsmAccess() == null ? 0 : csMachine.getCsmAccess());
            historyState.setCshsHost(csMachine.getCsmHost() == null ? 0 : csMachine.getCsmHost());
            historyState.setCshsCar(0);
        } else {
            historyState.setCshsAccess(csMachine.getCsmAccess());
            historyState.setCshsHost(csMachine.getCsmHost());
            historyState.setCshsCar(csVehicle.getCsvId());
        }
        return historyState;
    }

    /**
     * 设置CAN状态 CscAccess ，CscHost，CscCar
     */
    public CsCan setCsCan(CsVehicle csVehicle, CsMachine csMachine) {
        CsCan csCan = new CsCan();
        if (csVehicle == null) {
            csCan.setCscAccess(csMachine.getCsmAccess() == null ? 0 : csMachine.getCsmAccess());
            csCan.setCscHost(csMachine.getCsmHost() == null ? 0 : csMachine.getCsmHost());
            csCan.setCscCar(0);
            csCan.setCscModel((short) 0);
        } else {
            csCan.setCscAccess(csMachine.getCsmAccess());
            csCan.setCscHost(csMachine.getCsmHost());
            csCan.setCscCar(csVehicle.getCsvId());
            // TODO:后期需要关联 车型
            csCan.setCscModel((short) 0);
        }
        return csCan;
    }

    /**
     * 设置历史CAN状态 CshcAccess ，CshcHost，CshcCar
     */
    public CsHistoryCan setCsHistoryCan(CsVehicle csVehicle, CsMachine csMachine) {
        CsHistoryCan csCan = new CsHistoryCan();
        if (csVehicle == null) {
            csCan.setCshcAccess(csMachine.getCsmAccess() == null ? 0 : csMachine.getCsmAccess());
            csCan.setCshcHost(csMachine.getCsmHost() == null ? 0 : csMachine.getCsmHost());
            csCan.setCshcCar(0);
            csCan.setCshcModel((short) 0);
        } else {
            csCan.setCshcAccess(csMachine.getCsmAccess());
            csCan.setCshcHost(csMachine.getCsmHost());
            csCan.setCshcCar(csVehicle.getCsvId());
            // TODO:后期需要关联 车型
            csCan.setCshcModel((short) 0);
        }
        return csCan;
    }

    /**
     * 车机基础信息
     */
    public CsMachine setUpdateMapBaseInfo(CCCLUBS_60 terminalInfo, CsMachine csMachine) {
        CsMachine csMachineNew = new CsMachine();
        //终端序列号
        if (StringUtils.notEmpty(terminalInfo.getCfxId()) && !terminalInfo.getCfxId()
                .equals(csMachine.getCsmTeNo())) {
            csMachineNew.setCsmTeNo(terminalInfo.getCfxId());
        }
        //适配车型
        if (terminalInfo.getModel() != null) {
            if (csMachine.getCsmSuit() == null) {
                csMachineNew.setCsmSuit(terminalInfo.getModel());
            } else if (terminalInfo.getModel().intValue() != csMachine.getCsmSuit().intValue()) {
                csMachineNew.setCsmSuit(terminalInfo.getModel());
            }
        }
        //0:车厘子 1:中导 2:慧翰 3:通领
        if (csMachine.getCsmTeType() != null && 3 == csMachine.getCsmTeType().intValue()) {
            // 通领硬件版本
            if (terminalInfo.getVersion() != null && !String.valueOf(terminalInfo.getVersion())
                    .equals(csMachine.getCsmV2())) {
                csMachineNew.setCsmV2(String.valueOf(terminalInfo.getVersion()));
            }

            //通领主版本
            if (!StringUtils.empty(terminalInfo.getSoftwareVersionI()) && !terminalInfo.getSoftwareVersionI()
                    .equals(csMachine.getCsmTlV1())) {
                csMachineNew.setCsmTlV1(terminalInfo.getSoftwareVersionI());
            }
            //插件版本
            if (terminalInfo.getSoftwareVersionII() != null) {
                if (csMachine.getCsmTlV2() == null
                        || terminalInfo.getSoftwareVersionII().intValue() != csMachine.getCsmTlV2()
                        .intValue()) {
                    csMachineNew.setCsmTlV2(terminalInfo.getSoftwareVersionII());
                }
            }
        }

        //0:车厘子 1:中导 2:慧翰 3:通领
        if (csMachine.getCsmTeType() != null && 1 == csMachine.getCsmTeType().intValue()) {
            // 中导硬件版本
            if (terminalInfo.getZHardWareVersion() != null && !String
                    .valueOf(terminalInfo.getZHardWareVersion())
                    .equals(csMachine.getCsmV2())) {
                csMachineNew.setCsmV2(String.valueOf(terminalInfo.getZHardWareVersion()));
            }

            //中导主版本
            if (!StringUtils.empty(terminalInfo.getZSoftWareVersion()) && !terminalInfo.getZSoftWareVersion()
                    .equals(csMachine.getCsmTlV1())) {
                csMachineNew.setCsmTlV1(terminalInfo.getZSoftWareVersion());
            }
            //插件版本
            if (terminalInfo.getZPluginVersion() != null) {
                if (csMachine.getCsmTlV2() == null
                        || terminalInfo.getZPluginVersion().intValue() != csMachine.getCsmTlV2()) {
                    csMachineNew.setCsmTlV2(terminalInfo.getZPluginVersion());
                }
            }
        }

        //0:车厘子 1:中导 2:慧翰 3:通领
        if (csMachine.getCsmTeType() != null && 0 == csMachine.getCsmTeType().intValue()) {
            // 富士康硬件版本
            if (terminalInfo.getFVersion() != null && !Tools
                    .ToHexString((short) terminalInfo.getFVersion().intValue())
                    .equals(csMachine.getCsmV2())) {
                csMachineNew.setCsmV2(Tools.ToHexString((short) terminalInfo.getFVersion().intValue()));
            }

            // 富士康软件版本
            if (terminalInfo.getFIapVersion() != null && terminalInfo.getFAppVersion() != null) {
                String softVersion =
                        Tools.ToHexString((short) terminalInfo.getFIapVersion().intValue()) + Tools
                                .ToHexString((short) terminalInfo.getFAppVersion().intValue());
                if (!softVersion.equals(csMachine.getCsmV2())) {
                    csMachineNew.setCsmV1(softVersion);
                }
            }
        }

        // 插枪还车
        String functions = StringUtils.empty(csMachine.getCsmFunctions()) ? "" : csMachine.getCsmFunctions();
        if (terminalInfo.getPlugGun() != null) {
            // 修改为插枪还车
            if (terminalInfo.getPlugGun() == 1 && !functions.contains("#2#")) {
                functions = StringUtils.empty(functions) ? "#2#" : functions + ",#2#";
                csMachineNew.setCsmFunctions(functions);
            } else if (terminalInfo.getPlugGun() == 0 && functions.contains("#2#")) {
                functions = functions.replaceAll(",#2#", "").replaceAll("#2#,", "").replaceAll("#2#", "");
                csMachineNew.setCsmFunctions(functions);
            }
        }

        // 必须有蓝牙版本，mac地址，蓝牙密钥，并且mac地址不为 000000000000
        if (terminalInfo.getBleVersion() != null && (!StringUtils.empty(terminalInfo.getMacAddress()) || !StringUtils
                .empty(terminalInfo.getBleKey())) && !"000000000000"
                .equals(terminalInfo.getMacAddress())) {
            // 没有设置蓝牙功能，加上
            if (!functions.contains("#1#")) {
                functions = StringUtils.empty(functions) ? "#1#" : functions + ",#1#";
                csMachineNew.setCsmFunctions(functions);
            }
        } else {
            // 设置了蓝牙功能，去掉
            if (functions.contains("#1#")) {
                functions = functions.replaceAll(",#1#", "").replaceAll("#1#,", "").replaceAll("#1#", "");
                csMachineNew.setCsmFunctions(functions);
            }
        }

        //蓝牙版本
        if (terminalInfo.getBleVersion() != null) {
            if (csMachine.getCsmBluetoothVersion() == null
                    || terminalInfo.getBleVersion().intValue() != csMachine.getCsmBluetoothVersion()
                    .intValue()) {
                csMachineNew.setCsmBluetoothVersion(terminalInfo.getBleVersion());
            }
        }
        //蓝牙MAC地址
        if (!StringUtils.empty(terminalInfo.getMacAddress()) && !terminalInfo.getMacAddress()
                .equals(csMachine.getCsmBluetoothMac())) {
            csMachineNew.setCsmBluetoothMac(terminalInfo.getMacAddress());
        }
        // 蓝牙密钥
        if (!StringUtils.empty(terminalInfo.getBleKey()) && !terminalInfo.getBleKey().trim()
                .equals(csMachine.getCsmBluetoothPsd())) {
            csMachineNew.setCsmBluetoothPsd(terminalInfo.getBleKey().trim());
        }

        //终端网络类型
        if (terminalInfo.getNetworkType() != null) {
            if (csMachine.getCsmNetType() == null) {
                csMachineNew.setCsmNetType(terminalInfo.getNetworkType().byteValue());
            } else if (terminalInfo.getNetworkType().intValue() != csMachine.getCsmNetType()
                    .intValue()) {
                csMachineNew.setCsmNetType(terminalInfo.getNetworkType().byteValue());
            }
        }
        //终端协议
        if (terminalInfo.getProtocol() != null) {
            if (csMachine.getCsmProType() == null || terminalInfo.getProtocol().intValue() != csMachine
                    .getCsmProType().intValue()) {
                csMachineNew.setCsmProType(terminalInfo.getProtocol().byteValue());
            }
        }
        //ICCID
        if (!StringUtils.empty(terminalInfo.getIccid()) && !terminalInfo.getIccid()
                .equals(csMachine.getCsmIccid())) {
            csMachineNew.setCsmIccid(terminalInfo.getIccid());
        }

        //车机屏当前版本
        if (terminalInfo.getMediaCurrentVersion() != null && !String
                .valueOf(terminalInfo.getMediaCurrentVersion()).equals(csMachine.getCsmV3())) {
            csMachineNew.setCsmV3(String.valueOf(terminalInfo.getMediaCurrentVersion()));
        }
        //车机屏最新版本
        if (terminalInfo.getMediaNewVersion() != null && !String
                .valueOf(terminalInfo.getMediaNewVersion()).equals(csMachine.getCsmV3To())) {
            csMachineNew.setCsmV3To(String.valueOf(terminalInfo.getMediaNewVersion()));
        }
        //CAN波特率
        if (terminalInfo.getCanBaudRate() != null) {
            if (csMachine.getCsmBaudRate() == null
                    || terminalInfo.getCanBaudRate().intValue() != csMachine.getCsmBaudRate()
                    .intValue()) {
                csMachineNew.setCsmBaudRate(terminalInfo.getCanBaudRate());
            }
        }
        return csMachineNew;
    }

    /**
     * 长安出行车机触发信息
     */
    public CsState setUpdateMapTriggerInfo(CCCLUBS_60 terminalInfo) {
        CsState csState = new CsState();
        //终端当前时间
        if (terminalInfo.getCurrentTime() != null) {
            csState.setCssCurrentTime(
                    new Date(ProtocolTools.transformToServerTime(terminalInfo.getCurrentTime())));
        }
        //发动机状态
        if (terminalInfo.getTriggerEngineStatus() != null) {
            csState.setCssEngine(terminalInfo.getTriggerEngineStatus().byteValue());
        }
        //钥匙状态
        if (terminalInfo.getTriggerKeyStatus() != null) {
            csState.setCssKey(terminalInfo.getTriggerKeyStatus().byteValue());
        }
        //挡位状态
        if (terminalInfo.getTriggerGearStatus() != null) {
            csState.setCssGear(terminalInfo.getTriggerGearStatus().byteValue());
        }
        //灯状态
        if (terminalInfo.getTriggerLightStatus() != null) {
            csState.setCssLight(terminalInfo.getTriggerLightStatus());
        }
        //锁状态
        if (terminalInfo.getTriggerDoorLockStatus() != null) {
            csState.setCssLock(terminalInfo.getTriggerDoorLockStatus());
        }
        //充电状态
        if (terminalInfo.getTriggerChargeStatus() != null) {
            csState.setCssCharging(terminalInfo.getTriggerChargeStatus().byteValue());
        }
        //门状态
        if (terminalInfo.getTriggerMergeDoorStatus() != null) {
            csState.setCssDoor(StringUtils.zerofill(Integer.toBinaryString(terminalInfo.getTriggerMergeDoorStatus() & 0xFF), 8));
        }
        return csState;
    }

    /**
     * 新版本
     */
    public CsState setUpdateMapTriggerInfoNew(CCCLUBS_60 terminalInfo) {
        CsState csState = new CsState();
        //终端当前时间
        if (terminalInfo.getCurrentTime() != null) {
            csState.setCssCurrentTime(
                    new Date(ProtocolTools.transformToServerTime(terminalInfo.getCurrentTime())));
        }
        //发动机状态
        if (terminalInfo.getTriggerEngineStatus() != null) {
            csState.setCssEngine(terminalInfo.getTriggerEngineStatus().byteValue());
        }
        //钥匙状态
        if (terminalInfo.getTriggerKeyStatus() != null) {
            csState.setCssKey(terminalInfo.getTriggerKeyStatus().byteValue());
        }
        //挡位状态
        if (terminalInfo.getTriggerGearStatus() != null) {
            csState.setCssGear(terminalInfo.getTriggerGearStatus().byteValue());
        }
        //灯状态
        if (terminalInfo.getTriggerLightStatusWithMask() != null) {
            csState.setCssLight(terminalInfo.getTriggerLightStatusWithMask());
        }
        //锁状态
        if (terminalInfo.getTriggerDoorLockStatusWithMask() != null) {
            csState.setCssLock(terminalInfo.getTriggerDoorLockStatusWithMask() & 0xFFFF);
        }
        //充电状态
        if (terminalInfo.getTriggerChargeStatus() != null) {
            csState.setCssCharging(terminalInfo.getTriggerChargeStatus().byteValue());
        }
        //门状态 fixme
        if (terminalInfo.getTriggerMergeDoorStatusWithMask() != null) {
            csState.setCssDoor(String.valueOf(terminalInfo.getTriggerMergeDoorStatusWithMask() & 0xFFFF));
        }
        return csState;
    }

    /**
     * 终端属性信息格式化成json字符串
     */
    public String getFormatString(CCCLUBS_60 terminalInfo, MqMessage mqMessage) {
        if (mqMessage == null || terminalInfo == null) {
            return "";
        }
        final StringBuilder sb = new StringBuilder("(");
        sb.append("\"carNumber\":\"")
                .append(StringUtils.or(mqMessage.getCarNumber(), ""));
        sb.append("\",\"cfxId\":\"")
                .append(StringUtils.or(terminalInfo.getCfxId(), ""));
        sb.append("\",\"simNo\":\"")
                .append(StringUtils.or(terminalInfo.getSimNo(), ""));
        sb.append("\",\"vin\":\"")
                .append(StringUtils.or(terminalInfo.getVin(), ""));
        sb.append("\",\"model\":\"")
                .append(terminalInfo.getModel());
        sb.append("\",\"version\":\"")
                .append(terminalInfo.getVersion());
        sb.append("\",\"softwareVersionI\":\"")
                .append(terminalInfo.getSoftwareVersionI());
        sb.append("\",\"softwareVersionII\":\"")
                .append(terminalInfo.getSoftwareVersionII());
        sb.append("\",\"bleVersion\":\"")
                .append(terminalInfo.getBleVersion());
        sb.append("\",\"networkType\":\"")
                .append(terminalInfo.getNetworkType());
        sb.append("\",\"protocol\":\"")
                .append(terminalInfo.getProtocol());
        sb.append("\",\"iccid\":\"")
                .append(terminalInfo.getIccid());
        sb.append("\",\"macAddress\":\"")
                .append(StringUtils.or(terminalInfo.getMacAddress(), ""));
        sb.append("\",\"mediaCurrentVersion\":\"")
                .append(terminalInfo.getMediaCurrentVersion());
        sb.append("\",\"mediaNewVersion\":\"")
                .append(terminalInfo.getMediaNewVersion());
//    sb.append("\",\"serverName\":\"")
//        .append(StringUtils.or(terminalInfo.getServerName(), ""));
        sb.append("\",\"port\":\"")
                .append(terminalInfo.getPort());
        sb.append("\",\"canBaudRate\":\"")
                .append(terminalInfo.getCanBaudRate());
        sb.append("\")");
        return sb.toString();
    }

    /**
     * 记录业务数据
     *
     * @param carNumber 车机号
     * @param content   主要内容
     * @param hexString 原始十六进制数据
     * @param order     订单号
     */
    public void processTerminalLog(String carNumber, String content, String hexString,
                                   Long order) {
        try {
//      logger.info("收到来自 " + carNumber + "的 " + content + " ，原始数据：" + hexString);
            CsLogger csLogger = new CsLogger();
            csLogger.setCslNumber(carNumber);
            csLogger.setCslOrder(order);
            csLogger.setCslLog(content);
            csLogger.setCslData(hexString);
            csLogger.setCslAddTime(new Date().getTime());
            csLogger.setCslStatus((short) 1);
            csLoggerDao.save(csLogger);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();

        }
    }

    public String getCanData(final String number, final JT_0900_can canData) {
        try {
            CanStatusZotye zotyeStatus = new CanStatusZotye();
            zotyeStatus.mCanNum = canData.getCount();
            zotyeStatus.mCanType = 0x01;
            zotyeStatus.mCarNum = number;
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

            return Tools.ToHexString(buff.array());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return "";
        }
    }
}
