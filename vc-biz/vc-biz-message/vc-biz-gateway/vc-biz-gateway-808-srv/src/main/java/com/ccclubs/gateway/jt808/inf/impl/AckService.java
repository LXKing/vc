package com.ccclubs.gateway.jt808.inf.impl;

import com.ccclubs.mongo.modify.UpdateLoggerService;
import com.ccclubs.mongo.modify.UpdateTerminalService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.gateway.jt808.inf.IAckService;
import com.ccclubs.gateway.jt808.inf.IMessageSender;
import com.ccclubs.protocol.dto.jt808.JT_0001;
import com.ccclubs.protocol.dto.jt808.JT_0100;
import com.ccclubs.protocol.dto.jt808.JT_0102;
import com.ccclubs.protocol.dto.jt808.JT_01F0;
import com.ccclubs.protocol.dto.jt808.JT_0201;
import com.ccclubs.protocol.dto.jt808.JT_0500;
import com.ccclubs.protocol.dto.jt808.JT_8001;
import com.ccclubs.protocol.dto.jt808.JT_8100;
import com.ccclubs.protocol.dto.jt808.JT_80F4;
import com.ccclubs.protocol.dto.jt808.JT_81F4;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.jt808.T808MessageHeader;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsTerminal;
import com.ccclubs.pub.orm.model.CsVehicle;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 终端上行数据应答服务
 */
public class AckService implements IAckService {

  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AckService.class);

  private static ConcurrentLinkedQueue<T808Message> dataQueue = new ConcurrentLinkedQueue<T808Message>();

  private Thread processRealDataThread;
  private IMessageSender messageSender;

  private String authencateNo = "1234567890A"; // 鉴权码
  // 注册车辆集合：key:车牌号，value:SimNo
  private ConcurrentHashMap<String, String> vehicleRegisterMap = new ConcurrentHashMap<String, String>();
  // 注册车辆集合：key:终端ID，value:SimNo
  private ConcurrentHashMap<String, String> terminalRegisterMap = new ConcurrentHashMap<String, String>();
  // 车辆、终端注册关系集合：key:SIMNO value:车牌号,终端ID
  private ConcurrentHashMap<String, Object> registerMap = new ConcurrentHashMap<String, Object>();

  private boolean checkRegister;

  /**
   * 对于0200的定位包是否进行应答
   */
  private boolean ack0200PacketDisabled;

  private int threadPool;


  @Autowired
  QueryTerminalService queryTerminalService;

  @Autowired
  UpdateTerminalService updateTerminalService;

  @Autowired
  QueryVehicleService queryVehicleService;


  @Autowired
  UpdateLoggerService updateLoggerService;

  public AckService() {
  }

  @Override
  public void start() {
    processRealDataThread = new Thread(new Runnable() {
      public void run() {
        ProcessRealDataThreadFunc();
      }
    });
    processRealDataThread.start();
  }

  private void ProcessRealDataThreadFunc() {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(getThreadPool());

    for (int i = 0; i < getThreadPool(); i++) {
      fixedThreadPool.execute(new Runnable() {
        @Override
        public void run() {
          while (true) {
            try {
              final T808Message tm = dataQueue.poll();
              if (tm != null) {
                sendGeneralAck(tm);
              }

              try {
                Thread.sleep(5L);
              } catch (InterruptedException e1) {
                logger.error(e1.getMessage(), e1);
              }
            } catch (Exception e) {
              e.printStackTrace();
              logger.info(e.getMessage(), e);
            }
          }
        }
      });
    }
  }

  public void beginAck(T808Message tm) {
    int msgType = tm.getMessageType();
    // 0200的包不进行应答
    if (msgType == 0x0200 && ack0200PacketDisabled) {
      return;
    }

    // 注销请求
    if (msgType == 0x0003) {
      String simNo = tm.getSimNo();
      if (registerMap.containsKey(simNo)) {
        // 如果以前注册成功过，需要清除注册状态
        String registerData = "" + registerMap.get(simNo);
        if (registerData != null) {
          String[] temp = registerData.split(",");
          String plateNo = temp[0];
          String terminalId = temp[1];

          vehicleRegisterMap.remove(plateNo);
          terminalRegisterMap.remove(terminalId);
          registerMap.remove(simNo);
        }
      }
      return;
    }

    dataQueue.add(tm);
  }

  /**
   * 对终端发送上来的消息进行通用应答
   *
   * @param msgFromTerminal 终端消息
   */
  private void sendGeneralAck(T808Message msgFromTerminal) {
    int msgType = msgFromTerminal.getMessageType();
    if (msgType == 0) {
      return;
    }

    String simNo = msgFromTerminal.getSimNo();

    // 终端注销
    if (msgType == 0x0003) {
      if (registerMap.contains(simNo)) {
        // 如果以前注册成功过，需要清除注册状态
        String registerData = "" + registerMap.get(simNo);
        if (registerData != null) {
          String[] temp = registerData.split(",");
          String plateNo = temp[0];
          String terminalId = temp[1];

          vehicleRegisterMap.remove(plateNo);
          terminalRegisterMap.remove(terminalId);
          registerMap.remove(simNo);
        }
      }
      return;
    }
    // 终端注册
    else if (msgType == 0x0100) {
      // 对终端注册需要由平台进行应答
      JT_0100 registerData = (JT_0100) msgFromTerminal.getMessageContents();
      if (registerData == null) {
        return;
      }

      msgFromTerminal.setPlateNo(registerData.getPlateNo());
      int result = 0;// 注册成功
      if (checkRegister) {
        // 注册车辆
        // vi.set
        // 0：成功；1：车辆已被注册；2：数据库中无该车辆；3：终端已被注册；4：数据库中无该终端
        // CsCar vd =
        // CsCar.where.cscN(msgFromTerminal.getPlateNo()).get();
        // if (vd != null) {
        // if (vehicleRegisterMap.containsKey(vd.getPlateNo())) {
        // result = 1;// 车辆已被注册
        // } else {

        CsMachine csMachine =queryTerminalService.queryCsMachineByTeNo(registerData.getTerminalId());
        //
        CsTerminal csTerminal = queryTerminalService
            .queryCsTerminalByCstIdd(registerData.getTerminalId());
        //更新终端注册信息
        if (csTerminal != null) {
          CsTerminal newCsTerminal = new CsTerminal();
          newCsTerminal.setCstId(csTerminal.getCstId());
          newCsTerminal.setCstMobile(simNo);
          newCsTerminal.setCstUpdateTime(new Date());
          updateTerminalService.update(newCsTerminal);
        } else {
          // 写入终端注册信息
          CsTerminal newCsTerminal = new CsTerminal();
          newCsTerminal.setCstAddTime(new Date());
          newCsTerminal.setCstCity(String.valueOf(registerData.getCityId()));
          newCsTerminal.setCstColor((short) registerData.getPlateColor());
          newCsTerminal.setCstIdd(registerData.getTerminalId());
          newCsTerminal.setCstMade(registerData.getManufactureId());
          newCsTerminal.setCstModel(registerData.getTerminalModelNo());
          newCsTerminal.setCstNumber(registerData.getPlateNo());
          newCsTerminal.setCstStatus((byte) 1);
          newCsTerminal.setCstProvince(String.valueOf(registerData.getProvinceId()));
          // 终端未授权
          //						newCsTerminal.setCstStatus((short) 3);
          newCsTerminal.setCstMobile(simNo);
          newCsTerminal.setCstUpdateTime(new Date());
          //
          updateTerminalService.insert(newCsTerminal);
        }

        if (csMachine != null) {
          if (terminalRegisterMap.containsKey(csMachine.getCsmTeNo())) {
            // result = 3;// 终端已被注册
          }
          // 更新初次激活时间
          if (csMachine.getCsmCeFirst() == null) {
            CsMachine updateMachine = new CsMachine();
            updateMachine.setCsmId(csMachine.getCsmId());
            updateMachine.setCsmUpdateTime(new Date());
            updateMachine.setCsmCeFirst(new Date());
            updateTerminalService.update(updateMachine);
          }
        }

        if (result == 0) {
          terminalRegisterMap.put(registerData.getTerminalId(), simNo);
          vehicleRegisterMap.put(registerData.getPlateNo(), simNo);
          registerMap.put(simNo, registerData.getPlateNo() + "," + registerData.getTerminalId());
        }
      }

      JT_8100 echoData = new JT_8100();
      echoData.setRegisterResponseMessageSerialNo(msgFromTerminal.getHeader().getMessageSerialNo());
      echoData.setRegisterResponseResult((byte) result);
      echoData.setRegisterNo(authencateNo);

      T808Message ts = new T808Message();
      ts.setMessageContents(echoData);
      ts.setHeader(new T808MessageHeader());
      ts.getHeader().setMessageType(0x8100);
      ts.getHeader().setSimId(simNo);
      ts.getHeader().setIsPackage(false);

      getMessageSender().send808Message(ts);
    } else if (msgType == 0x0001) {
      // 如果是终端通用应答，就更新数据库的指令状态为已应答
      JT_0001 answerData = (JT_0001) msgFromTerminal.getMessageContents();
      short platformSn = answerData.getResponseMessageSerialNo();
    } else if (msgType == 0x01F0) {
      if (StringUtils.empty(msgFromTerminal.getSimNo())) {
        return;
      }
      // 如果是终端通升级应答，就更新数据库的升级指令状态为已应答
      JT_01F0 updateData = (JT_01F0) msgFromTerminal.getMessageContents();
      // 由于协议里未定义平台流水号，只能更新最近（5分钟）一条的升级指令状态
      if (updateData != null) {
//        // 写日志
        updateLoggerService.save(msgFromTerminal.getSimNo(),
            "FTP升级指令-" + updateData.getResultString(),
            msgFromTerminal.getPacketDescr(), 0L);
      }
    } else if (msgType == 0x00F4) {
      // 终端发起同步VIN码请求，需要应答0x80F4
      JT_80F4 echoData = new JT_80F4();
      echoData.setMessageSerialNo(msgFromTerminal.getHeader().getMessageSerialNo());
      CsMachine csMachine =queryTerminalService.queryCsMachineBySimNo(msgFromTerminal.getSimNo());
      CsVehicle csVehicle = null;
      if (csMachine != null) {
        csVehicle = queryVehicleService.queryVehicleByMachine(csMachine.getCsmId());
      }
      if (csVehicle == null || StringUtils.empty(csVehicle.getCsvVin())) {
        echoData.setPlatformVinStatus((byte) 0x01);
      } else {
        echoData.setPlatformVinStatus((byte) 0x01);
        echoData.setPlatformVin(csVehicle.getCsvVin());
        if (StringUtils.empty(csVehicle.getCsvBataccuCode())) {
          echoData.setPlatformCodeStatus((byte) 0x00);
        } else {
          echoData.setPlatformCodeStatus((byte) 0x01);
          echoData.setRechargeableSubsystemsTotalNumber((byte) 0x01);
          echoData.setRechargeableSubsystemsLength((byte) csVehicle.getCsvBataccuCode().length());
          echoData.setRechargeableSubsystemsCode(csVehicle.getCsvBataccuCode());
        }
      }

      T808Message ts = new T808Message();
      ts.setMessageContents(echoData);
      ts.setHeader(new T808MessageHeader());
      ts.getHeader().setMessageType(0x80F4);
      ts.getHeader().setSimId(simNo);
      ts.getHeader().setIsPackage(false);

      getMessageSender().send808Message(ts);

      return;
    } else if (msgType == 0x01F4) {
      // 终端发起同步VIN码请求，需要应答0x81F4
      JT_81F4 echoData = new JT_81F4();
      echoData.setMessageSerialNo(msgFromTerminal.getHeader().getMessageSerialNo());
      CsMachine csMachine =queryTerminalService.queryCsMachineBySimNo(msgFromTerminal.getSimNo());
      CsVehicle csVehicle = null;
      if (csMachine != null) {
        csVehicle = queryVehicleService.queryVehicleByMachine(csMachine.getCsmId());
      }
      if (csVehicle == null || StringUtils.empty(csVehicle.getCsvVin())) {
        echoData.setPlatformVinStatus((byte) 0x01);
      } else {
        echoData.setPlatformVinStatus((byte) 0x01);
        echoData.setPlatformVin(csVehicle.getCsvVin());
      }

      T808Message ts = new T808Message();
      ts.setMessageContents(echoData);
      ts.setHeader(new T808MessageHeader());
      ts.getHeader().setMessageType(0x81F4);
      ts.getHeader().setSimId(simNo);
      ts.getHeader().setIsPackage(false);

      getMessageSender().send808Message(ts);

      return;
    } else if (msgType == 0x7F04) {
      // 写日志
      updateLoggerService.save(msgFromTerminal.getSimNo(), "终端CAN过滤表",
          msgFromTerminal.getPacketDescr(), 0L);
    } else if (msgType == 0x0201) {
      // 终端对位置查询（点名）的应答
      JT_0201 answerData = (JT_0201) msgFromTerminal.getMessageContents();
      short platformSn = answerData.getResponseMessageSerialNo();
    } else if (msgType == 0x0500) {
      // 终端对车门控制的应答
      JT_0500 answerData = (JT_0500) msgFromTerminal.getMessageContents();
      short platformSn = answerData.getResponseMessageSerialNo();
    } else if (msgType == 0x0104) {
      // 查询终端参数应答
      JT_8001 echoData = new JT_8001();
      echoData.setResponseMessageSerialNo(msgFromTerminal.getHeader().getMessageSerialNo());
      echoData.setResponseMessageId((short) msgFromTerminal.getHeader().getMessageType());
      echoData.setResponseResult((byte) 0);

      T808Message ts = new T808Message();
      ts.setMessageContents(echoData);
      ts.setHeader(new T808MessageHeader());
      ts.getHeader().setMessageType(0x8001);
      ts.getHeader().setSimId(msgFromTerminal.getHeader().getSimId());
      ts.getHeader().setIsPackage(false);
      getMessageSender().send808Message(ts);
    } else {
      int ackResult = 0;// 通用应答，成功标志
      if (msgType == 0x0102) {
        // 终端鉴权，要向上级平台注册信息
        JT_0102 cmdData = (JT_0102) msgFromTerminal.getMessageContents();

        if (cmdData != null && checkRegister) {
          ackResult = this.authencateNo.equals(cmdData.getRegisterNo()) ? 0 : 1; // 鉴权成功或失败
        }
        // 终端鉴权成功
        if (ackResult == 0) {
          // 设置终端上线
          // realDataService.updateOnlineStatus(simNo, true);
        }
      }
      // 对于终端发送的其他命令，平台一律进行通用应答
      JT_8001 echoData = new JT_8001();
      echoData.setResponseMessageSerialNo(msgFromTerminal.getHeader().getMessageSerialNo());
      echoData.setResponseMessageId((short) msgType);
      echoData.setResponseResult((byte) ackResult); // 应答成功

      T808Message ts = new T808Message();
      ts.setMessageContents(echoData);
      ts.setHeader(new T808MessageHeader());
      ts.getHeader().setMessageType(0x8001);
      ts.getHeader().setSimId(simNo);
      ts.getHeader().setIsPackage(false);

      getMessageSender().send808Message(ts);
    }
  }

  public void setMessageSender(IMessageSender messageSender) {
    this.messageSender = messageSender;
  }

  public IMessageSender getMessageSender() {
    return messageSender;
  }

  public String getAuthencateNo() {
    return authencateNo;
  }

  public void setAuthencateNo(String authencateNo) {
    this.authencateNo = authencateNo;
  }

  public boolean isCheckRegister() {
    return checkRegister;
  }

  public void setCheckRegister(boolean checkRegister) {
    this.checkRegister = checkRegister;
  }

  public boolean isAck0200PacketDisabled() {
    return ack0200PacketDisabled;
  }

  public void setAck0200PacketDisabled(boolean ack0200PacketDisabled) {
    this.ack0200PacketDisabled = ack0200PacketDisabled;
  }

  public int getThreadPool() {
    return threadPool;
  }

  public void setThreadPool(int threadPool) {
    this.threadPool = threadPool;
  }

}
