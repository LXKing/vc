package com.ccclubs.engine.rule.inf.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.common.modify.UpdateTerminalService;
import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.engine.core.util.MachineMapping;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.engine.core.util.RedisHelper;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.core.util.TerminalUtils;
import com.ccclubs.engine.rule.inf.util.LogicHelperMqtt;
import com.ccclubs.engine.rule.inf.util.TransformUtils;
import com.ccclubs.mongo.orm.dao.CsLoggerDao;
import com.ccclubs.mongo.orm.model.CsLogger;
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
import com.ccclubs.pub.orm.model.SrvHost;
import java.util.Date;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 处理除远程控制以外的数据写入
 */
public class ParseDataService implements IParseDataService {

  private static Logger logger = LoggerFactory.getLogger(ParseDataService.class);

  @Resource(name = "producer")
  private Producer client;

  @Resource
  TerminalUtils terminalUtils;

  @Resource
  TransformUtils transformUtils;

  @Resource
  MessageFactory messageFactory;

  @Resource
  LogicHelperMqtt logicHelperMqtt;

  @Value("${" + ConstantUtils.MQ_TOPIC + "}")
  String topic;

  @Resource
  private RedisTemplate redisTemplate;

  @Resource
  RedisHelper redisHelper;

  @Resource
  QueryAppInfoService queryHostInfoService;

  @Resource
  QueryTerminalService queryTerminalService;
  @Resource
  UpdateStateService updateStateService;
  @Resource
  UpdateTerminalService updateTerminalService;

  @Autowired
  CsLoggerDao loggerDao;

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
    } else if (headerType == 0x68) {// 启动、停止数据；车辆状态改变推送
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
      HashOperations ops = redisTemplate.opsForHash();
      MachineMapping mapping = (MachineMapping) ops
          .get(RuleEngineConstant.REDIS_KEY_CARNUM, message.getCarNumber());
      if (mapping == null) {
        redisHelper.setNotExist(message.getCarNumber(), message.getCarNumber());
        return;
      }
      if (mapping.getVin() == null) {
        return;
      }

      CsMachine csMachine = terminalUtils
          .getMappingMachine(RuleEngineConstant.REDIS_KEY_CARNUM, message.getCarNumber());
      if (csMachine == null) {
        return;
      }

      SrvHost srvHost = queryHostInfoService.queryHostById(csMachine.getCsmAccess());
      if (srvHost == null) {
        return;
      }
      // 目前汽油车，电动车共用 MQTT_66
      MQTT_66 mqtt_66 = new MQTT_66();
      mqtt_66.ReadFromBytes(message.getMsgBody());
      // 众行EVPOP特殊处理
      if (topic.equals(srvHost.getShTopic())) {
        transferToMq(MqTagProperty.MQ_TERMINAL_STATUS, message, false);
      } else {
        transferToMq(srvHost,
            transformUtils.transform2TerminalStatus(csMachine, mapping.getVin(), mqtt_66, message),
            message);
      }
      logicHelperMqtt.saveStatusData(message, mqtt_66);
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
      if (mqtt_43 != null) {
        logicHelperMqtt.saveAlarmData(message, mqtt_43);
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void processCanStatus(MqMessage message) {
    try {
      transferToMq(MqTagProperty.MQ_TERMINAL_CAN, message, true);

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
      logicHelperMqtt.saveCanData(message, canZotye);
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
      HashOperations ops = redisTemplate.opsForHash();
      final MachineMapping mapping = (MachineMapping) ops
          .get(RuleEngineConstant.REDIS_KEY_CARNUM, message.getCarNumber());
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
            logicHelperMqtt.saveAlarmData(message, mqtt_43);
          }
          break;

        case 0x02:
          CCCLUBS_60 terminalInfo = new CCCLUBS_60();
          terminalInfo.ReadFromBytes(message.getMsgBody());

          if (mapping == null || StringUtils.empty(mapping.getNumber())
              || mapping.getMachine() == null
              || mapping.getState() == null || StringUtils.empty(mapping.getVin())
              || mapping.getAccess() == null) {
            return;
          }

          transferTriggerStatus(message, terminalInfo, mapping);
          //FIXME 长安出行需要做变更
          if (mapping.getAccess() == 3L || mapping.getAccess() == 4L || mapping.getAccess() == 5L) {
            CsState csState = terminalUtils.setUpdateMapTriggerInfo(terminalInfo);
            csState.setCssAddTime(new Date());
            csState.setCssId(mapping.getState().intValue());
            updateStateService.update(csState);
          } else {
            CsState csStateNew = terminalUtils.setUpdateMapTriggerInfoNew(terminalInfo);
            csStateNew.setCssAddTime(new Date());
            csStateNew.setCssId(mapping.getState().intValue());
            updateStateService.update(csStateNew);
          }
          break;
        case 0x03:
          // 新版本状态数据
          if (mapping == null || StringUtils.empty(mapping.getNumber())
              || mapping.getMachine() == null
              || mapping.getState() == null || StringUtils.empty(mapping.getVin())
              || mapping.getAccess() == null) {
            return;
          }

          CsMachine csMachine = terminalUtils
              .getMappingMachine(RuleEngineConstant.REDIS_KEY_CARNUM, message.getCarNumber());
          if (csMachine == null) {
            return;
          }

          SrvHost srvHost = queryHostInfoService.queryHostById(csMachine.getCsmAccess());
          if (srvHost == null) {
            return;
          }
          MQTT_68_03 mqtt_68_03 = new MQTT_68_03();
          mqtt_68_03.ReadFromBytes(message.getMsgBody());
          // 如果未配置转发topic，就不转发状态数据
          if (!StringUtils.empty(srvHost.getShTopic())) {
            transferToMq(srvHost, TransformUtils
                    .transform2TerminalStatus(csMachine, mapping.getVin(), mqtt_68_03, message),
                message);
          }
          logicHelperMqtt.saveStatusData(message, mqtt_68_03);
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

    SrvHost srvHost = queryHostInfoService.queryHostById(mapping.getAccess());

    Message mqMessage = messageFactory
        .getMessage(srvHost.getShTopic().trim(),
            MqTagProperty.MQ_TERMINAL_STATUS + srvHost.getShId(),
            JSON.toJSONBytes(terminalTriggerStatus));
    if (mqMessage != null) {
      mqMessage
          .setKey(
              message.getCarNumber() + "_" + StringUtils
                  .date(new Date(), ConstantUtils.TIME_FORMAT));
      client.sendOneway(mqMessage);
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
      transferToMq(MqTagProperty.MQ_TERMINAL_ORDER, message, false);

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
      transferToMq(MqTagProperty.MQ_TERMINAL_TAKECAR, message, false);

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
      transferToMq(MqTagProperty.MQ_TERMINAL_ORDER, message, false);

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
      transferToMq(MqTagProperty.MQ_TERMINAL_ORDER, message, false);

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
      transferToMq(MqTagProperty.MQ_TERMINAL_FURTHERCAR, message, false);

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
      if (logCcclubs_6c != null) {
        CsLogger csLogger = new CsLogger();
        csLogger.setCslNumber(message.getCarNumber());
        csLogger.setCslOrder(message.getTransId());
        csLogger.setCslLog(logCcclubs_6c.getmLog());
        csLogger.setCslData(message.getHexString());
        csLogger.setCslAddTime(new Date().getTime());
        csLogger.setCslStatus((short) 1);
        loggerDao.save(csLogger);
      }
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
        HashOperations ops = redisTemplate.opsForHash();
        final MachineMapping mapping = (MachineMapping) ops
            .get(RuleEngineConstant.REDIS_KEY_CARNUM, message.getCarNumber());
        if (mapping == null || StringUtils.empty(mapping.getNumber())
            || mapping.getMachine() == null) {
          return;
        }

        CsMachine csMachine = queryTerminalService
            .queryCsMachineById(mapping.getMachine().intValue());
        CsMachine machineUpdate = new CsMachine();
        //设置超级手机号
        if (!StringUtils.empty(mqtt_6B.getSuperSimNo()) && !mqtt_6B.getSuperSimNo()
            .equals(csMachine.getCsmSuperSim())) {
          machineUpdate.setCsmSuperSim(mqtt_6B.getSuperSimNo());
        }
        //设置终端序列号
//                if (!StringUtils.empty(mqtt_6B.getCfxId()) && !mqtt_6B.getCfxId()
//                        .equals(csMachine.getCsmTeNo())) {
//                    machineUpdate.setCsmTeNo(mqtt_6B.getCfxId());
//                }
        //设置终端适配车型
        if (csMachine.getCsmSuit() == null || mqtt_6B.getModel() != csMachine.getCsmSuit()) {
          machineUpdate.setCsmSuit(Integer.valueOf(mqtt_6B.getModel()));
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

      // 转发车机属性信息
      transferToMq(MqTagProperty.MQ_TERMINAL_INFO, message, false);

      CCCLUBS_60 terminalInfo = new CCCLUBS_60();
      terminalInfo.ReadFromBytes(message.getMsgBody());

      // 以手机号或车机号为key写入
      final String info = terminalUtils.getFormatString(terminalInfo, message);
      terminalUtils.processTerminalLog(
          StringUtils.empty(terminalInfo.getSimNo()) ? message.getCarNumber()
              : terminalInfo.getSimNo(),
          info, message.getHexString(),
          message.getTransId());

      if (StringUtils.empty(message.getSimNo())) {
        // mqtt 终端，按照车机号唯一性来确认 --> 通过车机号来规范手机号，序列号 等
        CsMachine numberMachine = queryTerminalService.queryTerminalByCarNumber(
            message.getCarNumber());//.Get($.add(CSM.csmNumber, message.getCarNumber()));
        if (numberMachine == null) {
          return;
        }
        CsMachine machine = terminalUtils.setUpdateMapBaseInfo(terminalInfo, numberMachine);
        //设置手机号
        if (!StringUtils.empty(terminalInfo.getSimNo()) && !terminalInfo.getSimNo()
            .equals(numberMachine.getCsmMobile())) {
          machine.setCsmMobile(terminalInfo.getSimNo());
        }
        machine.setCsmUpdateTime(new Date());
        machine.setCsmId(numberMachine.getCsmId());
        updateTerminalService.update(machine);
      } else {
        // 808 终端，按照手机号唯一性来确认 --> 通过手机号来规范车机号，序列号 等
        CsMachine mobileMachine = queryTerminalService
            .queryCsMachineBySimNo(terminalInfo.getSimNo());
        if (mobileMachine == null) {
          return;
        }
        CsMachine machine = terminalUtils.setUpdateMapBaseInfo(terminalInfo, mobileMachine);
        //设置车机号
        if (!StringUtils.empty(message.getCarNumber()) && !message.getCarNumber()
            .equals(mobileMachine.getCsmNumber())) {
          machine.setCsmNumber(message.getCarNumber());
        }
        machine.setCsmUpdateTime(new Date());
        machine.setCsmId(mobileMachine.getCsmId());
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
  private void transferToMq(String tag, MqMessage message, boolean isCanState) {
    try {
      if (isCanState) {
        CsMachine csMachine = terminalUtils
            .getCsMachineBySim(RuleEngineConstant.REDIS_KEY_SIMNO, message.getSimNo());
        // 只有标记为地标类型的终端才转发。
        if (csMachine == null || csMachine.getCsmId() <= 0 || StringUtils
            .empty(csMachine.getCsmLandmark()) || "#0#".equals(csMachine.getCsmLandmark().trim())) {
          return;
        }
      }

      Message mqMessage = messageFactory
          .getMessage(topic, tag, message);

      if (mqMessage != null) {
        mqMessage.setKey(
            message.getCarNumber() + "_" + StringUtils.date(new Date(), ConstantUtils.TIME_FORMAT));
        client.sendOneway(mqMessage);
      } else {
        logger.error(message.getCarNumber() + " 未授权给应用");
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  private void transferToMq(SrvHost srvHost, TerminalStatus terminalStatus, MqMessage message) {
    Message mqMessage = messageFactory
        .getMessage(srvHost.getShTopic().trim(),
            MqTagProperty.MQ_TERMINAL_STATUS + srvHost.getShId(),
            JSON.toJSONBytes(terminalStatus));
    if (mqMessage != null) {
      mqMessage
          .setKey(
              message.getCarNumber() + "_" + StringUtils
                  .date(new Date(), ConstantUtils.TIME_FORMAT));
      client.sendOneway(mqMessage);
    } else {
      logger.error(message.getCarNumber() + " 未授权给应用");
    }
  }

}
