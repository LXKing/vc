package com.ccclubs.engine.rule.inf.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.common.modify.UpdateTerminalService;
import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.frm.spring.util.EnvironmentUtils;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.engine.core.util.TerminalUtils;
import com.ccclubs.engine.rule.inf.util.LogicHelperMqtt;
import com.ccclubs.engine.rule.inf.util.TransformUtils;
import com.ccclubs.frm.logger.VehicleControlLogger;
import com.ccclubs.helper.MachineMapping;
import com.ccclubs.mongo.orm.dao.CsLoggerDao;
import com.ccclubs.mongo.orm.model.history.CsLogger;
import com.ccclubs.protocol.dto.mqtt.CCCLUBS_60;
import com.ccclubs.protocol.dto.mqtt.CCCLUBS_6C;
import com.ccclubs.protocol.dto.mqtt.CStruct;
import com.ccclubs.protocol.dto.mqtt.CarStartAndStop;
import com.ccclubs.protocol.dto.mqtt.MQTT_43;
import com.ccclubs.protocol.dto.mqtt.MQTT_66;
import com.ccclubs.protocol.dto.mqtt.MQTT_68_03;
import com.ccclubs.protocol.dto.mqtt.MQTT_6B;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.mqtt.can.CanDataTypeI;
import com.ccclubs.protocol.dto.mqtt.can.CanStatusZotye;
import com.ccclubs.protocol.dto.transform.TerminalStatus;
import com.ccclubs.protocol.dto.transform.TerminalTriggerStatus;
import com.ccclubs.protocol.inf.IParseDataService;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MqTagProperty;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.SrvHost;
import java.util.Date;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * 处理除远程控制以外的数据写入
 */
public class ParseDataService implements IParseDataService {

  private static Logger logger = LoggerFactory.getLogger(ParseDataService.class);
  private static final Logger loggerBusiness = VehicleControlLogger.getLogger();

  @Resource(name = "producer")
  private Producer client;

  @Resource
  TerminalUtils terminalUtils;

  @Resource
  MessageFactory messageFactory;

  @Resource
  LogicHelperMqtt logicHelperMqtt;

  @Value("${" + ConstantUtils.MQ_TOPIC + "}")
  String topic;

  @Resource
  QueryAppInfoService queryHostInfoService;

  @Resource
  QueryTerminalService queryTerminalService;

  @Resource
  UpdateTerminalService updateTerminalService;

  @Autowired
  CsLoggerDao loggerDao;

  @Autowired
  EnvironmentUtils environmentUtils;

  @Override
  public void processMessage(MqMessage tm) {
    // 消息类型
    int headerType = tm.getFucCode();

    // 处理远程控制以外的数据
    if (headerType == 0x41 || headerType == 0x66) {// 状态数据
      processCarStatus(tm);
    } else if (headerType == 0x42 || headerType == 0x64) {// 还车数据
      processFurtherCarStatus(tm);
    } else if (headerType == 0x43) {// 报警数据
      processAlarmStatus(tm);
    } else if (headerType == 0x44) {// 定单数据回复
      processOrderStatus(tm);
    } else if (headerType == 0x45) {// 取车数据
      processTakeCarStatus(tm);
    } else if (headerType == 0x52) {// 定单详细数据
      processOrderDetailStatus(tm);
    } else if (headerType == 0x53) {// 定单续订数据
      processOrderModify(tm);
    } else if (headerType == 0x60) {//车机属性，记录日志
      processTerminalInfo(tm);
    } else if (headerType == 0x68) {// 启动、停止数据；车辆状态改变推送；新版本状态数据
      processStartStopStatus(tm);
    } else if (headerType == 0x69) {// CAN数据
      processCanStatus(tm);
    } else if (headerType == 0x6B) {// 终端重启数据
      processRestart(tm);
    } else if (headerType == 0x6C) {//车机网络日志
      processTerminalLog(tm);
    }
  }

  @Override
  public void processCarStatus(MqMessage message) {
    try {
      MachineMapping mapping = terminalUtils.getMapping(message.getCarNumber());

      CsMachine csMachine = terminalUtils.getMappingMachine(mapping);
      if (null == mapping || null == csMachine) {
        return;
      }

      SrvHost srvHost = queryHostInfoService.queryHostByIdFromCache(csMachine.getCsmAccess());
      if (srvHost == null) {
        return;
      }

      // 目前汽油车，电动车共用 MQTT_66
      MQTT_66 mqtt_66 = new MQTT_66();
      mqtt_66.ReadFromBytes(message.getMsgBody());
      // 如果未绑定车辆，则不转发到业务平台
      if (null != mapping.getVin()) {
        transferToMq(srvHost,
            TransformUtils
                .transform2TerminalStatus(csMachine, mapping.getVin(), mqtt_66, message),
            message);
      }
      logicHelperMqtt.saveStatusData(mapping, message, mqtt_66);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("saveStatusData error : " + message.getHexString());
      logger.error(e.getMessage(), e);
    }
  }


  @Override
  public void processAlarmStatus(MqMessage message) {
    try {
      MQTT_43 mqtt_43 = new MQTT_43();
      mqtt_43.ReadFromBytes(message.getMsgBody());
      //暂时不记录报警数据 2017-10-11
//      logicHelperMqtt.saveAlarmData(message, mqtt_43);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void processCanStatus(MqMessage message) {
    try {
      final MachineMapping mapping = terminalUtils.getMapping(message.getCarNumber());
      if (null == mapping) {
        return;
      }
      transferToMq(mapping, MqTagProperty.MQ_TERMINAL_CAN, message, true);

      byte[] byteMsg = message.WriteToBytes();
      CanStatusZotye canZotye = CanStatusZotye.readObject(byteMsg, CanStatusZotye.class);
      if (canZotye == null || canZotye.mCanNum < 0) {
        return;
      }
      int canZotyeLength = CStruct.sizeof(CanStatusZotye.class);
      int canTypeILength = CStruct.sizeof(CanDataTypeI.class);

      if ((byteMsg.length - canZotyeLength) % canTypeILength == 0) {
        canZotye.mCanNum = (byte) ((byteMsg.length - canZotyeLength) / canTypeILength);
        canZotye.mCanType = 0x01;
      }
      logicHelperMqtt.saveCanData(mapping, message, canZotye);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void processStartStopStatus(MqMessage message) {
    try {
      //TODO: subCode 0x01老协议[对应终端启停数据] ,0x02新协议[对应车辆状态推送]
      byte subCode = message.getMsgBody()[0];
      // mqtt 终端，按照车机号唯一性来确认
      final MachineMapping mapping = terminalUtils.getMapping(message.getCarNumber());

      switch (subCode) {
        case 0x01:
          terminalUtils
              .processTerminalLog(message.getCarNumber(), "车辆启动数据上报", message.getHexString(),
                  message.getTransId());

          byte[] byteMsg = message.WriteToBytes();
          if (byteMsg.length < 100) {
            return;
          }
          CarStartAndStop carStartAndStop = CarStartAndStop
              .readObject(byteMsg, CarStartAndStop.class);

          if (carStartAndStop != null) {
            // 由于协议里定义的 mAlarmType 为 short ，需要强制转换成 byte
            // 停止：254 启动：255
            MQTT_43 mqtt_43 = new MQTT_43();
            mqtt_43.setAlarmType(carStartAndStop.mGear == 0 ? (byte) 254 : (byte) 255);
            // 暂时不记录报警数据 2017-10-11
//            logicHelperMqtt.saveAlarmData(message, mqtt_43);
          }
          break;

        case 0x02:
          CCCLUBS_60 terminalInfo = new CCCLUBS_60();
          terminalInfo.ReadFromBytes(message.getMsgBody());

          if (mapping.getState() == null || mapping.getAccess() == null) {
            return;
          }

          if (!StringUtils.empty(mapping.getVin())) {
            transferTriggerStatus(message, terminalInfo, mapping);
          }

          // 0x6802 将在 0x6803 新版本状态数据后弃用
          CsState csStateNew = terminalUtils.setUpdateMapTriggerInfoNew(terminalInfo);
          csStateNew.setCssAddTime(new Date());
          csStateNew.setCssId(mapping.getState().intValue());
          logicHelperMqtt.updateStatus(csStateNew);
          break;
        case 0x03:
          // 新版本状态数据
          CsMachine csMachine = terminalUtils.getMappingMachine(mapping);
          if (csMachine == null) {
            return;
          }

          SrvHost srvHost = queryHostInfoService.queryHostByIdFromCache(csMachine.getCsmAccess());
          if (srvHost == null) {
            return;
          }

          MQTT_68_03 mqtt_68_03 = new MQTT_68_03();
          mqtt_68_03.ReadFromBytes(message.getMsgBody());
          // 如果未配置转发topic，就不转发状态数据
          transferToMq(srvHost, TransformUtils
                  .transform2TerminalStatus(csMachine, mapping.getVin(), mqtt_68_03, message),
              message);
          logicHelperMqtt.saveStatusData(mapping, message, mqtt_68_03);
          break;
        default:
          break;
      }

    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      e.printStackTrace();
    }
  }

  /**
   * 转发触发数据
   */
  private void transferTriggerStatus(MqMessage message, CCCLUBS_60 terminalInfo,
      MachineMapping mapping) {
    TerminalTriggerStatus terminalTriggerStatus = new TerminalTriggerStatus();
    terminalTriggerStatus.setCssCurrentTime(
        terminalInfo.getCurrentTime() == null ? System.currentTimeMillis() :
            ProtocolTools.transformToServerTime(terminalInfo.getCurrentTime()));

    terminalTriggerStatus.setCssCharging(terminalInfo.getTriggerChargeStatus() == null ? 0
        : terminalInfo.getTriggerChargeStatus());
    terminalTriggerStatus.setCssDoor(
        (terminalInfo.getTriggerMergeDoorStatusWithMask() == null ? 0
            : terminalInfo.getTriggerMergeDoorStatusWithMask()) & 0xFFFF);
    terminalTriggerStatus.setCssEngine(terminalInfo.getTriggerEngineStatus() == null ? 0
        : terminalInfo.getTriggerEngineStatus());
    terminalTriggerStatus.setCssLock((terminalInfo.getTriggerDoorLockStatusWithMask() == null ? 0
        : terminalInfo.getTriggerDoorLockStatusWithMask()) & 0xFFFF);
    terminalTriggerStatus.setCssLight(terminalInfo.getTriggerLightStatusWithMask() == null ? 0
        : terminalInfo.getTriggerLightStatusWithMask());
    terminalTriggerStatus.setCssNumber(mapping.getTeno().trim());
    terminalTriggerStatus.setCssVin(mapping.getVin());
    terminalTriggerStatus.setCssGear(
        terminalInfo.getTriggerGearStatus() == null ? 0 : terminalInfo.getTriggerGearStatus());

    SrvHost srvHost = queryHostInfoService.queryHostByIdFromCache(mapping.getAccess().intValue());

    Message mqMessage = messageFactory
        .getMessage(srvHost.getShTopic().trim(),
            MqTagProperty.MQ_TERMINAL_STATUS + srvHost.getShId(),
            JSON.toJSONBytes(terminalTriggerStatus));
    if (mqMessage != null) {
      mqMessage
          .setKey(
              message.getCarNumber() + "_" + StringUtils
                  .date(new Date(), ConstantUtils.TIME_FORMAT));
      if (environmentUtils.isProdEnvironment()) {
        client.sendOneway(mqMessage);
      } else {
        logger.debug(JSON.toJSONString(terminalTriggerStatus));
      }
    } else {
      logger.error(message.getCarNumber() + " 未授权给应用");
    }
  }

  @Override
  public void processRemoteStatus(MqMessage message) {
  }

  @Override
  public void processOrderModify(MqMessage message) {
    try {
      final MachineMapping mapping = terminalUtils.getMapping(message.getCarNumber());
      transferToMq(mapping, MqTagProperty.MQ_TERMINAL_ORDER, message, false);

      terminalUtils.processTerminalLog(message.getCarNumber(), "订单续订数据", message.getHexString(),
          message.getTransId());
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void processTakeCarStatus(MqMessage message) {
    try {
      final MachineMapping mapping = terminalUtils.getMapping(message.getCarNumber());
      transferToMq(mapping, MqTagProperty.MQ_TERMINAL_TAKECAR, message, false);

      terminalUtils.processTerminalLog(message.getCarNumber(), "取车数据", message.getHexString(),
          message.getTransId());
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void processOrderStatus(MqMessage message) {
    try {
      final MachineMapping mapping = terminalUtils.getMapping(message.getCarNumber());
      transferToMq(mapping, MqTagProperty.MQ_TERMINAL_ORDER, message, false);

      terminalUtils.processTerminalLog(message.getCarNumber(), "订单回复数据", message.getHexString(),
          message.getTransId());
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void processOrderDetailStatus(MqMessage message) {
    try {
      final MachineMapping mapping = terminalUtils.getMapping(message.getCarNumber());
      transferToMq(mapping, MqTagProperty.MQ_TERMINAL_ORDER, message, false);

      terminalUtils.processTerminalLog(message.getCarNumber(), "订单详细数据", message.getHexString(),
          message.getTransId());
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void processFurtherCarStatus(MqMessage message) {
    try {
      final MachineMapping mapping = terminalUtils.getMapping(message.getCarNumber());
      transferToMq(mapping, MqTagProperty.MQ_TERMINAL_FURTHERCAR, message, false);

      terminalUtils.processTerminalLog(message.getCarNumber(), "还车数据", message.getHexString(),
          message.getTransId());
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void processTerminalLog(MqMessage message) {
    try {
      CCCLUBS_6C logCcclubs_6c = new CCCLUBS_6C();
      logCcclubs_6c.ReadFromBytes(message.getMsgBody());
      CsLogger csLogger = new CsLogger();
      csLogger.setCslNumber(message.getCarNumber());
      csLogger.setCslOrder(message.getTransId());
      csLogger.setCslLog(logCcclubs_6c.getmLog());
      csLogger.setCslData(message.getHexString());
      csLogger.setCslAddTime(System.currentTimeMillis());
      csLogger.setCslStatus((short) 1);
      loggerDao.save(csLogger);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  /**
   * 车机重启数据上报 TODO:数据解析
   */
  public void processRestart(MqMessage message) {
    try {
      terminalUtils.processTerminalLog(message.getCarNumber(), "车机重启数据上报", message.getHexString(),
          message.getTransId());
      MQTT_6B mqtt_6B = new MQTT_6B();
      mqtt_6B.ReadFromBytes(message.getMsgBody());
      if (!StringUtils.empty(mqtt_6B.getSuperSimNo())) {
        // mqtt 终端，按照车机号唯一性来确认
        CsMachine csMachine = queryTerminalService
            .queryCsMachineByCarNumber(message.getCarNumber());
        CsMachine machineUpdate = new CsMachine();
        //设置超级手机号
        if (!StringUtils.empty(mqtt_6B.getSuperSimNo()) && !mqtt_6B.getSuperSimNo()
            .equals(csMachine.getCsmSuperSim())) {
          machineUpdate.setCsmSuperSim(mqtt_6B.getSuperSimNo().trim());
        }
        //设置终端序列号
//                if (!StringUtils.empty(mqtt_6B.getCfxId()) && !mqtt_6B.getCfxId()
//                        .equals(csMachine.getCsmTeNo())) {
//                    machineUpdate.setCsmTeNo(mqtt_6B.getCfxId());
//                }
        //设置终端适配车型
        if (csMachine.getCsmSuit() == null || mqtt_6B.getModel() != csMachine.getCsmSuit()) {
          machineUpdate.setCsmSuit((int) mqtt_6B.getModel());
        }
        machineUpdate.setCsmUpdateTime(new Date());
        machineUpdate.setCsmId(csMachine.getCsmId());
        updateTerminalService.update(machineUpdate);
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  /**
   * 更新车机基础信息
   */
  public void processTerminalInfo(MqMessage message) {
    try {
      CCCLUBS_60 terminalInfo = new CCCLUBS_60();
      terminalInfo.ReadFromBytes(message.getMsgBody());

      // 以手机号或车机号为key写入
      final String info = terminalUtils.getFormatString(terminalInfo, message);
      terminalUtils
          .processTerminalLog(StringUtils.empty(terminalInfo.getSimNo()) ? message.getCarNumber()
              : terminalInfo.getSimNo(), info, message.getHexString(), message.getTransId());

      // mqtt 终端，按照车机号唯一性来确认 --> 通过车机号来规范手机号，序列号 等
      CsMachine numberMachine = queryTerminalService.queryCsMachineByCarNumber(
          message.getCarNumber());//.Get($.add(CSM.csmNumber, message.getCarNumber()));
      if (numberMachine == null) {
        return;
      }
      CsMachine machine = terminalUtils.setUpdateMapBaseInfo(terminalInfo, numberMachine);
      //设置手机号
      if (!StringUtils.empty(terminalInfo.getSimNo()) && !terminalInfo.getSimNo()
          .equals("00000000000") && terminalInfo.getSimNo().length() >= 11 && !terminalInfo.getSimNo()
          .equals(numberMachine.getCsmMobile())) {
        machine.setCsmMobile(terminalInfo.getSimNo());
      }
      if (!ProtocolTools.isAllFieldNull(machine)) {
        machine.setCsmUpdateTime(new Date());
        machine.setCsmId(numberMachine.getCsmId());
        updateTerminalService.update(machine);
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  /**
   * 转发到MQ，topic：terminal，tag
   */
  private void transferToMq(final MachineMapping mapping, String tag, MqMessage message,
      boolean isCanState) {
    try {
      CsMachine csMachine = terminalUtils.getMappingMachine(mapping);
      if (mapping.getCar() == null) {
        return;
      }
      CsVehicle csVehicle = terminalUtils.getCsVehicle(mapping.getCar());
      if (csMachine == null || csVehicle == null) {
        return;
      }
      if (isCanState) {
        //[地标类型] 只有标记为地标类型的终端才转发。
        if (StringUtils.empty(csVehicle.getCsvLandmark())) {
          return;
        }
        Message mqMessage = messageFactory
            .getMessage(csVehicle.getCsvLandmark(), topic, tag, message.getHexString());
        if (environmentUtils.isProdEnvironment()) {
          client.sendOneway(mqMessage);
        } else {
          logger.debug(message.getHexString());
        }
        return;
      }

      SrvHost srvHost = queryHostInfoService.queryHostByIdFromCache(csMachine.getCsmAccess());

      Message mqMessage = messageFactory
          .getMessage(srvHost, topic, tag, message);

      if (mqMessage != null) {
        mqMessage.setKey(
            message.getCarNumber() + "_" + StringUtils.date(new Date(), ConstantUtils.TIME_FORMAT));
        if (environmentUtils.isProdEnvironment()) {
          client.sendOneway(mqMessage);
        } else {
          logger.debug(message.getHexString());
        }
      } else {
        logger.error(message.getCarNumber() + " 未授权给应用");
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  private void transferToMq(SrvHost srvHost, TerminalStatus terminalStatus, MqMessage message) {
    String tag=MqTagProperty.MQ_TERMINAL_STATUS + srvHost.getShId();
    if (null!=terminalStatus.getAutopilot()){
      tag=MqTagProperty.MQ_TERMINAL_AUTOPILOT+ srvHost.getShId();
    }
    Message mqMessage = messageFactory
        .getMessage(srvHost.getShTopic().trim(),
                tag,
            JSON.toJSONBytes(terminalStatus));
    if (mqMessage != null) {
      mqMessage
          .setKey(
              message.getCarNumber() + "_" + StringUtils
                  .date(new Date(), ConstantUtils.TIME_FORMAT));
      if (environmentUtils.isProdEnvironment()) {
        client.sendOneway(mqMessage);
      } else {
        logger.debug(JSON.toJSONString(terminalStatus));
      }
    } else {
      logger.error(message.getCarNumber() + " 未授权给应用");
    }
  }

}
