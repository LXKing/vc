package com.ccclubs.engine.cmd.inf.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.common.modify.UpdateTerminalService;
import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.engine.core.util.RedisHelper;
import com.ccclubs.engine.core.util.RemoteHelper;
import com.ccclubs.frm.spring.util.EnvironmentUtils;
import com.ccclubs.mongo.modify.UpdateRemoteService;
import com.ccclubs.mongo.orm.dao.CsRemoteDao;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.dto.CommonResult;
import com.ccclubs.protocol.dto.mqtt.*;
import com.ccclubs.protocol.dto.transform.TerminalPartStatus;
import com.ccclubs.protocol.inf.IParseDataService;
import com.ccclubs.protocol.util.*;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.SrvHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 处理远程控制结果
 */
public class ParseOperationService implements IParseDataService {

    private static Logger logger = LoggerFactory.getLogger(ParseOperationService.class);

    //ons消息发送
    private Producer client;

    //消息构造器
    @Resource
    MessageFactory messageFactory;

    //topic
    @Value("${" + ConstantUtils.MQ_TOPIC + "}")
    String topic;

    //redisHelper
    @Resource
    RedisHelper redisHelper;
    //remoteHelper
    @Resource
    RemoteHelper remoteHelper;
    //终端信息查询服务
    @Resource
    QueryTerminalService queryTerminalService;
    //接入商信息查询服务
    @Resource
    QueryAppInfoService queryHostInfoService;
    //终端信息更新服务
    @Resource
    UpdateTerminalService updateTerminalService;
    //远程指令记录更新服务mongo
    @Resource
    UpdateRemoteService updateRemoteService;
    //当前运行环境
    @Resource
    EnvironmentUtils environmentUtils;
    //remoteDao
    @Resource
    CsRemoteDao remoteDao;

    /**
     * 处理消息
     *
     * @param tm
     */
    @Override
    public void processMessage(MqMessage tm) {
        // 消息类型
        int headerType = tm.getFucCode();
        // 2017-06-03 新添加FcCode 06，用作众行复合指令
        if (headerType == 0x03 || headerType == 0x05 || headerType == 0x0F
                || headerType == 0x10
                || headerType == 0x46 || headerType == 0x47
                || headerType == 0x48 || headerType == 0x49 || headerType == 0x50 || headerType == 0x6F
                || (headerType & 0xFF) == 0xF0) {// 远程控制
            //远程控制指令
            processRemoteStatus(tm);
        } else if (headerType == 0x06) {
            // 新版本复合远程控制指令，2017-09-21 ,因1.0版本RemoteService也在使用，需要兼容1.0版本 Redis 存储结构
            processMultipleOperation(tm);
        } else if (headerType == 0x54) {
            // 新版本众车纷享 订单下发指令应答
            processOrderModifyNew(tm);
        } else if (headerType == 0x44) {
            // 处理0x44订单下发指令
            processOrderAck(tm);
        }
    }

    /**
     * 新版本复合远程控制指令 ，目前暂时仅供众行EVPOP使用
     *
     * @param tm
     */
    private void processMultipleOperation(MqMessage tm) {
        CsRemote csRemote;
        CommonWriter commonWriter = null;
        try {
            //判断流水号与消息长度
            if (tm.getTransId() == 0 || tm.getMsgBody().length < 4) {
                return;
            }
            byte[] byteMsg = tm.WriteToBytes();
            // -
            commonWriter = CommonWriter.readObject(byteMsg, CommonWriter.class);
            // -
            MyBuffer myBuffer = new MyBuffer(tm.getMsgBody());
            //取命令码，四个字节
            int fcCode = myBuffer.getInt();
            switch (fcCode) {
                //远程开门
                case 0x1000FF00:
                    // -
                    int fcCodeOpen = myBuffer.getInt();
                    String resultJson;
                    short remoteResult;
                    // -
                    switch (fcCodeOpen) {
                        // 开门并允许启动
                        case 0x1004FF00:
                            // 开门并禁止启动
                        case 0x10040000:
                            // -
                            remoteResult = myBuffer.getShort();
                            //指令结果转json
                            resultJson = RemoteHelper
                                    .getMultipleOperationJsonMessage(commonWriter.mId, 0x10000000,
                                            myBuffer.gets(tm.getMsgBody().length - 4 - 4 - 2),
                                            remoteResult);
                            // 指令结果写入redis
                            redisHelper
                                    .setRemote(String.valueOf(commonWriter.mId),
                                            resultJson);
                            // 转发远程控制指令结果到业务ons
                            transferRemoteStatus(tm, resultJson);
                            // 初始化csRemote
                            csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJson,
                                    remoteResult == 0 || remoteResult == 0x00FF);
                            // 更新mongo指令控制记录
                            updateRemoteService.update(csRemote);
                            break;
                        //简单开门指令
                        default:
                            // -
                            MyBuffer myBufferOpen = new MyBuffer(tm.getMsgBody());
                            myBufferOpen.getInt();
                            // -
                            remoteResult = myBufferOpen.getShort();
                            //指令结果转json
                            resultJson = RemoteHelper
                                    .getMultipleOperationJsonMessage(commonWriter.mId, 0x1000FF00,
                                            myBufferOpen.gets(tm.getMsgBody().length - 4 - 2),
                                            remoteResult);
                            // 指令结果写入redis
                            redisHelper
                                    .setRemote(String.valueOf(commonWriter.mId),
                                            resultJson);
                            // 转发远程控制指令结果到业务ons
                            transferRemoteStatus(tm, resultJson);
                            // 初始化csRemote
                            csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJson,
                                    remoteResult == 0 || remoteResult == 0x00FF);
                            // 更新mongo指令控制记录
                            updateRemoteService.update(csRemote);
                            break;
                    }
                    break;
                // 远程关门
                case 0x10000000:
                    // -
                    int fcCodeClose = myBuffer.getInt();
                    String resultJsonClose;
                    // 指令返回结果
                    short remoteResultClose;
                    // -
                    switch (fcCodeClose) {
                        // 关门并允许启动
                        case 0x1004FF00:
                            // 关门并禁止启动
                        case 0x10040000:
                            // -
                            remoteResultClose = myBuffer.getShort();
                            //指令结果转json
                            resultJsonClose = RemoteHelper
                                    .getMultipleOperationJsonMessage(commonWriter.mId, 0x10000000,
                                            myBuffer.gets(tm.getMsgBody().length - 4 - 4 - 2),
                                            remoteResultClose);
                            // 指令结果写入redis
                            redisHelper
                                    .setRemote(String.valueOf(commonWriter.mId),
                                            resultJsonClose);
                            // 转发远程控制指令结果到业务ons
                            transferRemoteStatus(tm, resultJsonClose);
                            // 初始化csRemote
                            csRemote = RemoteHelper
                                    .getRemote(commonWriter.mId, tm.getHexString(), resultJsonClose,
                                            remoteResultClose == 0 || remoteResultClose == 0x00FF);
                            // 更新mongo指令控制记录
                            updateRemoteService.update(csRemote);
                            break;
                        // 简单关门指令
                        default:
                            // -
                            MyBuffer myBufferClose = new MyBuffer(tm.getMsgBody());
                            myBufferClose.getInt();
                            // -
                            remoteResultClose = myBufferClose.getShort();
                            // 指令结果转json
                            resultJsonClose = RemoteHelper
                                    .getMultipleOperationJsonMessage(commonWriter.mId, 0x10000000,
                                            myBufferClose.gets(tm.getMsgBody().length - 4 - 2),
                                            remoteResultClose);
                            // 指令结果写入redis
                            redisHelper
                                    .setRemote(String.valueOf(commonWriter.mId),
                                            resultJsonClose);
                            // 转发远程控制指令结果到业务ons
                            transferRemoteStatus(tm, resultJsonClose);
                            // 初始化csRemote
                            csRemote = RemoteHelper
                                    .getRemote(commonWriter.mId, tm.getHexString(), resultJsonClose,
                                            remoteResultClose == 0 || remoteResultClose == 0x00FF);
                            // 更新mongo指令控制记录
                            updateRemoteService.update(csRemote);
                            break;
                    }
                    break;
                //远程鸣笛
                case 0x1012FF00:
                    String resultJsonW = JSON.toJSONString(
                            CommonResult.create(commonWriter.mId, true, RemoteHelper.SUCCESS_CODE, "操作成功"));
                    // 指令结果写入redis
                    redisHelper
                            .setRemote(String.valueOf(commonWriter.mId),
                                    resultJsonW);
                    // 转发远程控制指令结果到业务ons
                    transferRemoteStatus(tm, resultJsonW);
                    // 初始化csRemote
                    csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJsonW,
                            byteMsg[21] == 0 && (byteMsg[22] == 0 || (byteMsg[22] & 0xFF) == 0xFF));
                    // 更新mongo指令控制记录
                    updateRemoteService.update(csRemote);
                    break;
                //允许启动
                case 0x1004FF00:
                    //禁止启动
                case 0x10040000:
                    //发动机启动
                case 0x1017FF00:
                    //发动机ACC
                case 0x10178800:
                    //发动机停止
                case 0x10170000:
                case 0x10220010:
                    String resultJsonCommon = JSON.toJSONString(
                            CommonResult.create(commonWriter.mId, true, RemoteHelper.SUCCESS_CODE, "操作成功"));
                    // 指令结果写入redis
                    redisHelper
                            .setRemote(String.valueOf(commonWriter.mId),
                                    resultJsonCommon);
                    // 转发远程控制指令结果到业务ons
                    transferRemoteStatus(tm, resultJsonCommon);
                    // 初始化csRemote
                    csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJsonCommon,
                            byteMsg[21] == 0 && (byteMsg[22] == 0 || (byteMsg[22] & 0xFF) == 0xFF));
                    // 更新mongo指令控制记录
                    updateRemoteService.update(csRemote);
                    break;
                // 批量查询(带参数)
                case 0x10200000:
                    String resultJsonCommonSelect = JSON.toJSONString(
                            CommonResult.create(commonWriter.mId, true, RemoteHelper.SUCCESS_CODE, "操作成功"));
                    // 指令结果写入redis
                    redisHelper
                            .setRemote(String.valueOf(commonWriter.mId),
                                    resultJsonCommonSelect);
                    // 转发远程控制指令结果到业务ons
                    transferRemoteStatus(tm, resultJsonCommonSelect);
                    // 初始化csRemote
                    csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJsonCommonSelect,
                            true);
                    // 更新mongo指令控制记录
                    updateRemoteService.update(csRemote);
                    break;
                // 远程关门(带参数)
                case 0x10210000:
                    // 获取参数
                    short fcCodeParams = myBuffer.getShort();
                    // 获取结果
                    short fcCodeResult = myBuffer.getShort();
                    String resultJsonCloseWithParams;
                    resultJsonCloseWithParams = RemoteHelper
                            .getMultipleOperationJsonMessage(commonWriter.mId, 0x10210000,
                                    myBuffer.gets(tm.getMsgBody().length - 4 - 2 - 2),
                                    fcCodeResult);
                    // 指令结果写入redis
                    redisHelper
                            .setRemote(String.valueOf(commonWriter.mId),
                                    resultJsonCloseWithParams);
                    // 转发远程控制指令结果到业务ons
                    transferRemoteStatus(tm, resultJsonCloseWithParams);
                    // 初始化csRemote
                    csRemote = RemoteHelper
                            .getRemote(commonWriter.mId, tm.getHexString(), resultJsonCloseWithParams,
                                    fcCodeResult == 0 || fcCodeResult == 0x00FF);
                    // 更新mongo指令控制记录
                    updateRemoteService.update(csRemote);
                    break;
                //语音指令
                case 0x10240010:
                    myBuffer.gets(tm.getMsgBody().length - 4 - 2);
                    short fcCodeVoice = myBuffer.getShort();
                    String resultJsonVoice = JSON.toJSONString(
                            CommonResult.create(commonWriter.mId, true, RemoteHelper.SUCCESS_CODE, "操作成功"));
                    // 指令结果写入redis
                    redisHelper
                            .setRemote(String.valueOf(commonWriter.mId),
                                    resultJsonVoice);
                    // 转发远程控制指令结果到业务ons
                    transferRemoteStatus(tm, resultJsonVoice);
                    // 初始化csRemote
                    csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJsonVoice,
                            (fcCodeVoice == 0 || fcCodeVoice == 0x00FF));
                    // 更新mongo指令控制记录
                    updateRemoteService.update(csRemote);
                    break;
                //站点下发、GPS自动驾驶指令
                case 0x10260010:
                    myBuffer.gets(tm.getMsgBody().length - 4 - 2);
                    short fcCodeSite = myBuffer.getShort();

                    String resultJsonSite = JSON.toJSONString(
                            CommonResult.create(commonWriter.mId, true, RemoteHelper.SUCCESS_CODE, "操作成功"));
                    // 指令结果写入redis
                    redisHelper
                            .setRemote(String.valueOf(commonWriter.mId),
                                    resultJsonSite);
                    // 转发远程控制指令结果到业务ons
                    transferRemoteStatus(tm, resultJsonSite);
                    // 初始化csRemote
                    csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJsonSite,
                            (fcCodeSite == 0 || fcCodeSite == 0x00FF));
                    // 更新mongo指令控制记录
                    updateRemoteService.update(csRemote);
                    break;
                default:
                    //状态获取
                    CCCLUBS_60 terminalInfo = new CCCLUBS_60();
                    terminalInfo.ReadFromBytes(tm.getMsgBody());
                    TerminalPartStatus terminalPartStatus = new TerminalPartStatus();
                    // terminalPartStatus.setCssNumber(tm.getCarNumber());
                    //电池电量
                    terminalPartStatus.setCssEvBattery(terminalInfo.getSoc());
                    //obd里程
                    terminalPartStatus.setCssObdMile(terminalInfo.getObdMile());
                    //油量
                    terminalPartStatus.setCssOil(terminalInfo.getOil());
                    //订单里程
                    terminalPartStatus.setCssTradeMile(terminalInfo.getTradeMiles());
                    //订单状态
                    terminalPartStatus.setCssTradeStatus(terminalInfo.getTradeStatus());
                    //订单开始时间
                    terminalPartStatus.setCssTradeStartTime(terminalInfo.getTradeStartTime() == null ? null : new Date(terminalInfo.getTradeStartTime().longValue()));
                    //订单结束时间
                    terminalPartStatus.setCssTradeEndTime(terminalInfo.getTradeEndTime() == null ? null : new Date(terminalInfo.getTradeEndTime().longValue()));
                    //纬度
                    terminalPartStatus.setCssLatitude(terminalInfo.getTriggerGpsLatitude());
                    //经度
                    terminalPartStatus.setCssLongitude(terminalInfo.getTriggerGpsLongitude());
                    //下位机时间
                    terminalPartStatus.setCssCurrentTime(
                            terminalInfo.getCurrentTime() == null ? System.currentTimeMillis() :
                                    ProtocolTools.transformToServerTime(terminalInfo.getCurrentTime()));
                    //充电状态
                    terminalPartStatus.setCssCharging(terminalInfo.getTriggerChargeStatus());
                    //门状态
                    terminalPartStatus.setCssDoor(terminalInfo.getTriggerMergeDoorStatusWithMask());
                    //发动机状态
                    terminalPartStatus.setCssEngine(terminalInfo.getTriggerEngineStatus());
                    //锁状态
                    terminalPartStatus.setCssLock(terminalInfo.getTriggerDoorLockStatusWithMask());
                    //灯状态
                    terminalPartStatus.setCssLight(terminalInfo.getTriggerLightStatusWithMask());
                    //控制状态
                    terminalPartStatus.setControlStatus(terminalInfo.getControlStatus());

                    // add at 2018-05-24 by qsxiaogang 添加GPS辅助定位
                    MachineAdditional_GpsAssistStatus gpsAssistStatus = terminalInfo.getGpsAssistStatus();
                    if (null != gpsAssistStatus) {
                        terminalPartStatus.setCssLongitudeAvg(gpsAssistStatus.getLongitudeAvgDecimal());
                        terminalPartStatus.setCssLatitudeAvg(gpsAssistStatus.getLatitudeAvgDecimal());
                        terminalPartStatus.setCssLongitudeMax(gpsAssistStatus.getLongitudeMaxDecimal());
                        terminalPartStatus.setCssLatitudeMax(gpsAssistStatus.getLatitudeMaxDecimal());
                        terminalPartStatus.setCssLongitudeMin(gpsAssistStatus.getLongitudeMinDecimal());
                        terminalPartStatus.setCssLatitudeMin(gpsAssistStatus.getLatitudeMinDecimal());
                    }
                    // 操作成功
                    CommonResult commonResult = CommonResult
                            .create(commonWriter.mId, true, RemoteHelper.SUCCESS_CODE, "操作成功");
                    commonResult.setData(terminalPartStatus);
                    String resultJsonState = JSON.toJSONString(commonResult);
                    // 指令结果写入redis
                    redisHelper.setRemote(String.valueOf(commonWriter.mId), resultJsonState);
                    // 转发远程控制指令结果到业务ons
                    transferRemoteStatus(tm, resultJsonState);
                    // 初始化csRemote
                    csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJsonState,
                            true);
                    // 更新mongo指令控制记录
                    updateRemoteService.update(csRemote);
                    break;
            }
        } catch (Exception e) {
            logger.error("processMultipleOperation" + e.getMessage(), e);
            if (null != commonWriter) {
                // -
                csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), "协议错误",
                        false);
                // -
                updateRemoteService.update(csRemote);
            }
        }
    }

    /**
     * processCarStatus
     *
     * @param message
     */
    @Override
    public void processCarStatus(MqMessage message) {
    }

    /**
     * processAlarmStatus
     *
     * @param message
     */
    @Override
    public void processAlarmStatus(MqMessage message) {
    }

    /**
     * processCanStatus
     *
     * @param message
     */
    @Override
    public void processCanStatus(MqMessage message) {
    }

    /**
     * processStartStopStatus
     *
     * @param message
     */
    @Override
    public void processStartStopStatus(MqMessage message) {
    }

    /**
     * processOrderModify
     *
     * @param msg
     */
    @Override
    public void processOrderModify(MqMessage msg) {
        try {
            // 转发订单修改指令
            Message mqMessage = messageFactory
                    .getMessage(topic, MqTagProperty.MQ_TERMINAL_ORDER, msg);
            if (mqMessage != null) {
                // -
                client.send(mqMessage);
            } else {
                logger.error(msg.getCarNumber() + " 未授权给应用");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * processTakeCarStatus
     *
     * @param message
     */
    @Override
    public void processTakeCarStatus(MqMessage message) {

    }

    /**
     * processOrderStatus
     *
     * @param message
     */
    @Override
    public void processOrderStatus(MqMessage message) {
    }

    /**
     * processOrderDetailStatus
     *
     * @param message
     */
    @Override
    public void processOrderDetailStatus(MqMessage message) {
    }

    /**
     * processFurtherCarStatus
     *
     * @param message
     */
    @Override
    public void processFurtherCarStatus(MqMessage message) {
    }

    /**
     * processTerminalLog
     *
     * @param message
     */
    @Override
    public void processTerminalLog(MqMessage message) {
    }

    /**
     * processRemoteStatus
     *
     * @param message
     */
    @Override
    public void processRemoteStatus(MqMessage message) {
        try {
            // -
            if (message.getTransId() == 0) {
                return;
            }
            // -
            int headerType = message.getFucCode();
            // -
            byte[] byteMsg = message.WriteToBytes();
            // 订单价格更新，续订，T-Box升级等
            if (headerType == 0x10) {
                // -
                RemoteOption commonWriter = RemoteOption.readObject(byteMsg, RemoteOption.class);
                // 订单续订信息
                if (commonWriter != null && (commonWriter.address & 0xFFFF) == 0x900E) {
                    // -
                    processOrderModify(message);
                } else if (commonWriter != null) {
                    // -
                    CsRemote csRemote = remoteHelper.getRemote(commonWriter, message.getHexString());
                    // -
                    redisHelper
                            .setRemote(String.valueOf(commonWriter.id),
                                    csRemote.getCsrResult());
                    // -
                    transferRemoteStatus(message, csRemote.getCsrResult());
                    // -
                    updateRemoteService.update(csRemote);
                }
            } else {
                // 添加 远程开门，远程关门，允许启动，禁止启动，鸣笛，初始化，远程还车，远程取车 操作反馈
                if (byteMsg.length == 21) {
                    // -
                    RemoteOption remoteOption = RemoteOption.readObject(byteMsg, RemoteOption.class);
                    // -
                    CsRemote csRemote = remoteHelper.getRemote(remoteOption, message.getHexString());
                    // -
                    redisHelper
                            .setRemote(String.valueOf(remoteOption.id),
                                    csRemote.getCsrResult());
                    // -
                    transferRemoteStatus(message, csRemote.getCsrResult());
                    // -
                    updateRemoteService.update(csRemote);
                } else if (byteMsg.length == 21 + 8
                        || byteMsg.length == 21 + 14) {
                    //TODO:新版本，关门反馈，还车反馈
                    CommonWriter commonWriter = CommonWriter.readObject(byteMsg, CommonWriter.class);
                    // -
                    CsRemote csRemote =
                            RemoteHelper.getRemote(commonWriter.mId, message.getHexString(),
                                    RemoteHelper.getRemoteJsonMessage(commonWriter, byteMsg),
                                    byteMsg[21] == 0 && (byteMsg[22] == 0 || (byteMsg[22] & 0xFF) == 0xFF));
                    // -
                    redisHelper
                            .setRemote(String.valueOf(commonWriter.mId),
                                    csRemote.getCsrResult());
                    // -
                    transferRemoteStatus(message, csRemote.getCsrResult());
                    // -
                    updateRemoteService.update(csRemote);
                } else {
                    // -
                    RemoteCurtness remoteCurtness = RemoteCurtness
                            .readObject(byteMsg, RemoteCurtness.class);
                    // -
                    CsRemote csRemote = RemoteHelper.getRemote(remoteCurtness.id, message.getHexString(),
                            RemoteHelper.getRemoteJsonMessage(remoteCurtness.id),
                            true);
                    // -
                    redisHelper
                            .setRemote(String.valueOf(remoteCurtness.id),
                                    csRemote.getCsrResult());
                    // -
                    transferRemoteStatus(message, csRemote.getCsrResult());
                    // -
                    updateRemoteService.update(csRemote);
                }
            }

            // 蓝牙操作
            if ((headerType & 0xFF) == 0xF0) {
                modifyTerminalBle(message);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 修改终端BLE参数，如：MAC地址或蓝牙密钥
     */
    private void modifyTerminalBle(MqMessage message) {
        // -
        CsMachine csMachineBase = queryTerminalService
                .queryCsMachineByCarNumber(message.getCarNumber());
        if (csMachineBase == null) {
            return;
        }

        CCCLUBS_03 bleModle = new CCCLUBS_03();
        bleModle.ReadFromBytes(message.getMsgBody());
        if (bleModle != null) {
            CsMachine csMachine = new CsMachine();
            csMachine.setCsmId(csMachineBase.getCsmId());
            // 更新终端mac地址
            if (!StringUtils.empty(bleModle.getMacValue())) {
                // -
                csMachine.setCsmBluetoothMac(bleModle.getMacValue());
                // -
                csMachine.setCsmUpdateTime(new Date());
                // -
                updateTerminalService.update(csMachine);
                return;
            }
            // 更新终端蓝牙密钥
            if (!StringUtils.empty(bleModle.getBleKey())) {
                // -
                csMachine.setCsmBluetoothPsd(bleModle.getBleKey());
                // -
                csMachine.setCsmUpdateTime(new Date());
                // -
                updateTerminalService.update(csMachine);
                return;
            }
            // 更新插枪还车状态
            if (bleModle.getGunValue() != 0) {
                String functions = csMachine.getCsmFunctions();
                if (StringUtils.empty(functions)) {
                    // -
                    csMachine.setCsmFunctions("#2#");
                } else {
                    // -
                    csMachine.setCsmFunctions(functions + ",#2#");
                }
                // -
                csMachine.setCsmUpdateTime(new Date());
                // -
                updateTerminalService.update(csMachine);
                return;
            } else {
                // -
                String functions = csMachine.getCsmFunctions();
                // -
                if (!StringUtils.empty(functions) && functions.contains("#2#")) {
                    csMachine.setCsmFunctions(
                            functions.replaceAll(",#2#", "").replaceAll("#2#,", "").replaceAll("#2#", ""));
                    // -
                    csMachine.setCsmUpdateTime(new Date());
                    // -
                    updateTerminalService.update(csMachine);
                    return;
                }
            }
            //多媒体DVD当前版本
            if (bleModle.getMediaCurrentVersion() != 0) {
                // -
                csMachine.setCsmV3(String.valueOf(bleModle.getMediaCurrentVersion()));
                // -
                csMachine.setCsmUpdateTime(new Date());
                // -
                updateTerminalService.update(csMachine);
                return;
            }
            //多媒体DVD最新版本
            if (bleModle.getMediaNewVersion() != 0) {
                // -
                csMachine.setCsmV3To(String.valueOf(bleModle.getMediaNewVersion()));
                // -
                csMachine.setCsmUpdateTime(new Date());
                // -
                updateTerminalService.update(csMachine);
                return;
            }
        }
    }

    /**
     * 处理订单下发指令 0x54
     */
    public void processOrderModifyNew(MqMessage message) {
        try {
            // -
            OrderUpStreamII orderUpStream = OrderUpStreamII
                    .readObject(Tools.HexString2Bytes(message.getHexString()), OrderUpStreamII.class);
            String jsonString;
            if (orderUpStream.isSuccess()) {
                //操作成功
                jsonString = JSON.toJSONString(CommonResult
                        .create(orderUpStream.mId, true, RemoteHelper.SUCCESS_CODE, "操作成功"));
            } else {
                //操作失败
                jsonString = JSON.toJSONString(CommonResult
                        .create(orderUpStream.mId, false, RemoteHelper.FAILED_CODE, "操作失败"));
            }
            // -
            redisHelper
                    .setRemote(String.valueOf(orderUpStream.mId),
                            jsonString);
            //消息转发
            transferRemoteStatus(message, jsonString);
            // -
            CsRemote csRemote = RemoteHelper
                    .getRemote(orderUpStream.mId, message.getHexString(), jsonString,
                            orderUpStream.isSuccess());
            updateRemoteService.update(csRemote);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 处理订单下发指令 0x44
     */
    public void processOrderAck(MqMessage message) {
        try {
            byte[] srcByteArray = message.WriteToBytes();
            OrderUpStream orderUpStream = OrderUpStream
                    .readObject(srcByteArray, OrderUpStream.class);
            String jsonString = "";
            boolean isSuccess = false;
            switch (srcByteArray.length) {
                case 29:
                    //其它情况，如果发送指令跟返回指令一致，则表示成功，或者返回指令是发送指令后附加“0000”
                    CsRemote csRemote = remoteDao.findById(orderUpStream.mId);
                    if (csRemote != null && !StringUtils.empty(csRemote.getCsrCode())) {
                        OrderDownStream orderDownStream = OrderDownStream
                                .readObject(Tools.HexString2Bytes(csRemote.getCsrCode()), OrderDownStream.class);
                        // 下发的订单号与上行的订单号一致，代表成功
                        if (orderDownStream.mId == orderUpStream.mId) {
                            isSuccess = true;
                            //下发成功
                            jsonString = JSON.toJSONString(CommonResult
                                    .create(orderUpStream.mId, isSuccess, RemoteHelper.SUCCESS_CODE, "下发成功"));
                        } else {
                            isSuccess = false;
                            //下发失败
                            jsonString = JSON.toJSONString(CommonResult
                                    .create(orderUpStream.mId, isSuccess, RemoteHelper.FAILED_CODE, "下发失败"));
                        }
                    }
                    break;
                case 31:
                    byte resultHigh = srcByteArray[29];
                    byte resultLow = srcByteArray[30];
                    if (resultHigh == 0 && resultLow == 0) {
                        isSuccess = true;
                        //下发成功
                        jsonString = JSON.toJSONString(CommonResult
                                .create(orderUpStream.mId, isSuccess, RemoteHelper.SUCCESS_CODE, "下发成功"));
                    } else {
                        isSuccess = false;
                        if ((resultLow & 1) == 1) {
                            //当前车辆已有订单
                            jsonString = JSON.toJSONString(CommonResult
                                    .create(orderUpStream.mId, isSuccess, RemoteHelper.FAILED_CODE, "当前车辆已有订单"));
                        } else if ((resultLow & 2) == 2) {
                            //有取车
                            jsonString = JSON.toJSONString(CommonResult
                                    .create(orderUpStream.mId, isSuccess, RemoteHelper.FAILED_CODE, "有取车"));
                        } else if ((resultLow & 8) == 8) {
                            //订单号不正确
                            jsonString = JSON.toJSONString(CommonResult
                                    .create(orderUpStream.mId, isSuccess, RemoteHelper.FAILED_CODE, "订单号不正确"));
                        } else {
                            //下发失败
                            jsonString = JSON.toJSONString(CommonResult
                                    .create(orderUpStream.mId, isSuccess, RemoteHelper.FAILED_CODE, "下发失败"));
                        }
                    }
                    break;
                default:
                    break;
            }

            if (!StringUtils.empty(jsonString)) {
                redisHelper
                        .setRemote(String.valueOf(orderUpStream.mId),
                                jsonString);

                transferRemoteStatus(message, jsonString);

                CsRemote csRemote = RemoteHelper
                        .getRemote(orderUpStream.mId, message.getHexString(), jsonString, isSuccess);
                updateRemoteService.update(csRemote);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 转发远程控制结果
     */
    private void transferRemoteStatus(MqMessage message, String jsonString) {
        try {
            // 根据车机号查询车机信息
            CsMachine csMachine = queryTerminalService.queryCsMachineByCarNumber(message.getCarNumber());
            if (csMachine == null) {
                return;
            }
            // 查询接入商信息
            SrvHost srvHost = queryHostInfoService.queryHostById(csMachine.getCsmAccess());
            // 当指令转发设置为不转发时，则不转发
            if (srvHost == null || StringUtils.empty(srvHost.getShTransformRemote()) || "0"
                    .equals(srvHost.getShTransformRemote())) {
                return;
            }
            String transTopic = StringUtils.empty(srvHost.getShTopic()) ? topic
                    : srvHost.getShTopic().trim();
            // 转发远程控制结果JSON结构
            Message mqMessage = messageFactory.getMessage(transTopic,
                    MqTagProperty.MQ_TERMINAL_REMOTE + srvHost.getShId(),
                    JSON.toJSONBytes(jsonString));
            //目前只在生产环境转发
            if (mqMessage != null && environmentUtils.isProdEnvironment()) {
                client.sendOneway(mqMessage);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * getClient
     *
     * @return
     */
    public Producer getClient() {
        return client;
    }

    /**
     * setClient
     *
     * @param client
     */
    public void setClient(Producer client) {
        this.client = client;
    }
}
