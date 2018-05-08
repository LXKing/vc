package com.ccclubs.engine.core.util;


import com.ccclubs.common.query.QueryCanService;
import com.ccclubs.common.query.QueryStateService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.helper.MachineMapping;
import com.ccclubs.mongo.orm.dao.CsLoggerDao;
import com.ccclubs.mongo.orm.model.history.CsLogger;
import com.ccclubs.protocol.dto.jt808.JT_0900_can;
import com.ccclubs.protocol.dto.jt808.JT_0900_can_item;
import com.ccclubs.protocol.dto.mqtt.CCCLUBS_60;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.mqtt.can.CanDataTypeI;
import com.ccclubs.protocol.dto.mqtt.can.CanStatusZotye;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.pub.orm.model.CsCan;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.pub.orm.model.CsVehicle;

import java.util.Date;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.ccclubs.engine.core.util.RuleEngineConstant.MACHINEMAPPING_CARNUMBER;
import static com.ccclubs.engine.core.util.RuleEngineConstant.MACHINEMAPPING_SIMNO;
import static com.ccclubs.engine.core.util.RuleEngineConstant.MACHINEMAPPING_VIN;


@Component
public class TerminalUtils {

    private static Logger logger = LoggerFactory.getLogger(TerminalUtils.class);

    @Resource
    private RedisHelper redisHelper;

    @Resource
    QueryTerminalService queryTerminalService;

    @Resource
    QueryVehicleService queryVehicleService;

    @Resource
    QueryStateService queryStateService;

    @Resource
    QueryCanService queryCanService;

    @Autowired
    CsLoggerDao csLoggerDao;

    /**
     * 通过车机号，手机号，VIN码 获取 MachineMapping
     */
    public MachineMapping getMapping(String keyPart, String keyType) {
        MachineMapping machineMapping = redisHelper.getMappingOld(keyPart);
        if (machineMapping == null) {
            machineMapping = getMappingByDB(keyPart, keyType);
            redisHelper.setMappingOld(keyPart, machineMapping);
        }
        return machineMapping;
    }

    /**
     * 缓存不存在，查询DB
     * 通过车机号，手机号，VIN码 获取 MachineMapping
     * add by jhy 2018-04-24
     */
    public MachineMapping getMappingByDB(String param, String paramType) {
        CsMachine csMachine = null;
        switch (paramType) {
            case MACHINEMAPPING_SIMNO:
                csMachine = queryTerminalService.queryCsMachineBySimNo(param);
                break;
            case MACHINEMAPPING_CARNUMBER:
                csMachine = queryTerminalService.queryCsMachineByCarNumber(param);
                break;
            case MACHINEMAPPING_VIN:
                break;
            default:
                break;
        }

        if (csMachine == null) {
            return null;
        }
        CsVehicle csVehicle = queryVehicleService.queryVehicleByMachine(csMachine.getCsmId());
        if (csVehicle == null) {
            return null;
        }
        CsState csState = queryStateService.queryStateByVehicleId(csVehicle.getCsvId());
        if (csState == null) {
            return null;
        }
        CsCan csCan = queryCanService.getCsCanByCarNumber(csMachine.getCsmNumber());
        if (csCan == null) {
            return null;
        }
        MachineMapping machineMapping = new MachineMapping();
        machineMapping.setVin(csVehicle.getCsvVin());
        machineMapping.setNumber(csMachine.getCsmNumber());
        machineMapping.setTeno(csMachine.getCsmTeNo());
        machineMapping.setAccess(csVehicle.getCsvAccess().longValue());
        machineMapping.setCar(csVehicle.getCsvId().longValue());
        machineMapping.setCan(csCan.getCscId());
        machineMapping.setState(csState.getCssId().longValue());
        machineMapping.setHost(csVehicle.getCsvHost().longValue());
        machineMapping.setMachine(csMachine.getCsmId().longValue());
        // TODO 手机号可以为null ？
        machineMapping.setMobile(csMachine.getCsmMobile() == null ? "" : csMachine.getCsmMobile());
        return machineMapping;
    }

    public CsMachine getMappingMachine(MachineMapping mapping) {
        if (null == mapping || null == mapping.getMachine()) {
            return null;
        }
        return queryTerminalService.queryCsMachineByIdFromCache(mapping.getMachine().intValue());
    }

    /**
     * 通过csvehicle id 车辆信息
     *
     * @param carId csVehicle 车辆
     */
    public CsVehicle getCsVehicle(final Long carId) {
        return queryVehicleService.queryVehicleByIdFromCache(carId.intValue());
    }

    /**
     * 设置当前状态 CssAccess ，CssHost，CssCar
     */
    public CsState setCsStatus(CsVehicle csVehicle, CsMachine csMachine) {
        CsState csState = new CsState();
        if (csVehicle == null) {
            csState.setCssAccess(
                    csMachine.getCsmAccess() == null ? (short) 0 : csMachine.getCsmAccess().shortValue());
            csState.setCssHost(
                    csMachine.getCsmHost() == null ? (short) 0 : csMachine.getCsmHost().shortValue());
            csState.setCssCar(0);
        } else {
            csState.setCssAccess(csMachine.getCsmAccess().shortValue());
            csState.setCssHost(csMachine.getCsmHost().shortValue());
            csState.setCssCar(csVehicle.getCsvId());
        }
        return csState;
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
     * 车机基础信息
     */
    public CsMachine setUpdateMapBaseInfo(CCCLUBS_60 terminalInfo, CsMachine csMachine) {
        CsMachine csMachineNew = new CsMachine();
        //终端序列号
        if (!StringUtils.empty(terminalInfo.getCfxId()) && !terminalInfo.getCfxId()
                .equals(csMachine.getCsmTeNo())) {
            if (csMachine.getCsmTeType() != null && 0 == csMachine.getCsmTeType().intValue()
                    && terminalInfo.getCfxId().length() == 15 && terminalInfo.getCfxId().startsWith("CFX")) {
                csMachineNew.setCsmTeNo(terminalInfo.getCfxId());
            }
        }
        //适配车型
        if (terminalInfo.getModel() != null) {
            if (csMachine.getCsmSuit() == null) {
                csMachineNew.setCsmSuit(terminalInfo.getModel());
            } else if (terminalInfo.getModel().intValue() != csMachine.getCsmSuit().intValue()) {
                csMachineNew.setCsmSuit(terminalInfo.getModel());
            }
        }

        // FIXME 适配老版本车机属性协议，老版本车机属性不上传{MachineAdditional_Type}
        if (null == terminalInfo.getMachineType()) {
            //0:车厘子 1:中导 2:慧翰 3:通领
            if (csMachine.getCsmTeType() != null && 3 == csMachine.getCsmTeType().intValue()) {
                // 通领硬件版本
                if (terminalInfo.getVersion() != null && !String.valueOf(terminalInfo.getVersion())
                        .equals(csMachine.getCsmV2())) {
                    csMachineNew.setCsmV2(String.valueOf(terminalInfo.getVersion()));
                }

                //通领主版本
                if (terminalInfo.getSoftwareVersionI() != null && !String
                        .valueOf(terminalInfo.getSoftwareVersionI())
                        .equals(csMachine.getCsmTlV1())) {
                    csMachineNew.setCsmTlV1(String.valueOf(terminalInfo.getSoftwareVersionI()));
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
                if (!StringUtils.empty(terminalInfo.getZSoftWareVersion()) && !String
                        .valueOf(terminalInfo.getZSoftWareVersion())
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
                if (terminalInfo.getFVersion() != null && !String
                        .valueOf(terminalInfo.getFVersion())
                        .equals(csMachine.getCsmV2())) {
                    csMachineNew.setCsmV2(String.valueOf(terminalInfo.getFVersion()));
                }

                // 富士康软件版本
                if (terminalInfo.getFIapVersion() != null && terminalInfo.getFIapVersion() != null) {
                    String softVersion =
                            Tools.ToHexString((short) terminalInfo.getFIapVersion().intValue()) + Tools
                                    .ToHexString((short) terminalInfo.getFAppVersion().intValue());
                    if (!softVersion.equals(csMachine.getCsmV1())) {
                        csMachineNew.setCsmV1(softVersion);
                    }
                }
                // 富士康IAP版本
                if (terminalInfo.getFIapVersion() != null && !String
                        .valueOf(terminalInfo.getFIapVersion())
                        .equals(csMachine.getCsmTlV1())) {
                    csMachineNew.setCsmTlV1(String.valueOf(terminalInfo.getFIapVersion()));
                }
                // 富士康APP软件版本
                if (terminalInfo.getFAppVersion() != null) {
                    if (csMachine.getCsmTlV2() == null
                            || terminalInfo.getFAppVersion().intValue() != csMachine.getCsmTlV2().intValue()) {
                        csMachineNew.setCsmTlV2(terminalInfo.getFAppVersion());
                    }
                }
            }
        } else {
            // 硬件版本
            if (terminalInfo.getHardwareVersion() != null && !String
                    .valueOf(terminalInfo.getHardwareVersion())
                    .equals(csMachine.getCsmV2())) {
                csMachineNew.setCsmV2(String.valueOf(terminalInfo.getHardwareVersion()));
            }
            // 软件版本I
            if (terminalInfo.getSoftwareVersionNewI() != null && !String
                    .valueOf(terminalInfo.getSoftwareVersionNewI())
                    .equals(csMachine.getCsmTlV1())) {
                csMachineNew.setCsmTlV1(String.valueOf(terminalInfo.getSoftwareVersionNewI()));
            }
            //TODO 软件版本II
            // 插件版本
            if (terminalInfo.getPluginVersion() != null) {
                if (csMachine.getCsmTlV2() == null
                        || terminalInfo.getPluginVersion().intValue() != csMachine.getCsmTlV2()
                        .intValue()) {
                    csMachineNew.setCsmTlV2(terminalInfo.getPluginVersion());
                }
            }
        }


        String functions =
                StringUtils.empty(csMachine.getCsmFunctions()) ? "" : csMachine.getCsmFunctions();

//开启自动续电
        if (terminalInfo.getAutoConfigStatusCharge() != null) {
            if (terminalInfo.getAutoConfigStatusCharge() == true && !functions.contains("#4#")) {
                functions = StringUtils.empty(functions) ? "#4#" : functions + ",#4#";
                csMachineNew.setCsmFunctions(functions);
            } else if (terminalInfo.getAutoConfigStatusCharge() == false && functions.contains("#4#")) {
                functions = functions.replaceAll(",#4#", "").replaceAll("#4#,", "").replaceAll("#4#", "");
                csMachineNew.setCsmFunctions(functions);
            }
        }
        //修改重启关闭自动锁门
        if (terminalInfo.getAutoConfigStatusUnlockdoor() != null) {
            if (terminalInfo.getAutoConfigStatusUnlockdoor() == true && !functions.contains("#3#")) {
                functions = StringUtils.empty(functions) ? "#3#" : functions + ",#3#";
                csMachineNew.setCsmFunctions(functions);
            } else if (terminalInfo.getAutoConfigStatusUnlockdoor() == false && functions.contains("#3#")) {
                functions = functions.replaceAll(",#3#", "").replaceAll("#3#,", "").replaceAll("#3#", "");
                csMachineNew.setCsmFunctions(functions);
            }
        }
        // 插枪还车
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
        //TODO 添加手刹和自动驾驶状态字段

        // 必须有蓝牙版本，mac地址，蓝牙密钥，并且mac地址不为 000000000000
        if (terminalInfo.getBleVersion() != null && (!StringUtils.empty(terminalInfo.getMacAddress())
                || !StringUtils
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
            } else if (terminalInfo.getNetworkType() != csMachine.getCsmNetType()
                    .intValue()) {
                csMachineNew.setCsmNetType(terminalInfo.getNetworkType().byteValue());
            }
        }
        //终端协议
        if (terminalInfo.getProtocol() != null) {
            if (csMachine.getCsmProType() == null || terminalInfo.getProtocol() != csMachine
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
            csState.setCssDoor(StringUtils
                    .zerofill(Integer.toBinaryString(terminalInfo.getTriggerMergeDoorStatus() & 0xFF), 8));
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
