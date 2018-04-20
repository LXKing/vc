package com.ccclubs.engine.rule.inf.util;

import com.ccclubs.common.aop.Timer;
import com.ccclubs.common.query.QueryCanService;
import com.ccclubs.common.query.QueryStateService;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.core.util.TerminalUtils;
import com.ccclubs.frm.spring.constant.KafkaConst;
import com.ccclubs.helper.MachineMapping;
import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.common.modify.UpdateStateService;
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

@Component
public class LogicHelperJt808 {

  private static Logger logger = LoggerFactory.getLogger(LogicHelperJt808.class);

  @Resource
  private RedisTemplate redisTemplate;
  @Resource
  private KafkaTemplate kafkaTemplate;

  @Value("${" + KafkaConst.KAFKA_TOPIC_CS_CAN + "}")
  String kafkaTopicCanForInsertHbase;
  @Value("${" + KafkaConst.KAFKA_TOPIC_CS_STATE + "}")
  String kafkaTopicStateForInsertHbase;

  @Resource
  private TerminalUtils terminalUtils;

  @Resource
  private UpdateStateService updateStateService;

  @Resource
  UpdateCanService updateCanService;

  @Resource
  QueryCanService queryCanService;

  @Resource
  QueryStateService queryStateService;


  /**
   * 保存状态数据
   *
   * @param message 上传
   * @param jvi 0x0200数据
   */
  @Timer
  public CsState saveStatusData(final MachineMapping mapping, final T808Message message,
      final JT_0200 jvi) {
    try {
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

      if (mapping.getState() != null) {
        CsState csState = terminalUtils.setCsStatus(csVehicle, csMachine);
        // 设置 CAR
        csState.setCssCar(mapping.getCar() == null ? 0 : mapping.getCar().intValue());
        csState.setCssCsq(jvi.getCsq());
        csState.setCssCurrentTime(StringUtils.date(jvi.getTime(), ConstantUtils.TIME_FORMAT));
        csState.setCssAddTime(new Date());
        csState.setCssGpsValid(jvi.isValid() ? (byte) 1 : (byte) 0);
        // 保存的 消息体
        csState.setCssMoData(message.getPacketDescr());

        csState.setCssId(mapping.getState().intValue());
        if (ProtocolTools.isValid(jvi.getLongitude(), jvi.getLatitude())) {
          BigDecimal bigDecimalLong = AccurateOperationUtils.mul(jvi.getLongitude(), 0.000001);
          csState.setCssLongitude(bigDecimalLong.setScale(6, BigDecimal.ROUND_HALF_UP));
          BigDecimal bigDecimalLat = AccurateOperationUtils.mul(jvi.getLatitude(), 0.000001);
          csState.setCssLatitude(bigDecimalLat.setScale(6, BigDecimal.ROUND_HALF_UP));
        }

        // 需要更新的当前状态加入等待队列
        ListOperations opsForList = redisTemplate.opsForList();
        opsForList.leftPush(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, csState);
        // 合并为完整的状态数据，并写入历史数据
        CsState csStateCurrent = queryStateService.queryStateByIdFor808(csState.getCssId());
        csStateCurrent.setCssCsq(csState.getCssCsq());
        csStateCurrent.setCssCurrentTime(csState.getCssCurrentTime());
        csStateCurrent.setCssAddTime(csState.getCssAddTime());
        csStateCurrent.setCssGpsValid(csState.getCssGpsValid());
        csStateCurrent.setCssMoData(csState.getCssMoData());
        if (null != csState.getCssLatitude() && null != csState.getCssLatitude()) {
          csStateCurrent.setCssLongitude(csState.getCssLongitude());
          csStateCurrent.setCssLatitude(csState.getCssLatitude());
        }
        // 处理历史状态
//        opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE, csStateCurrent);
// 发送历史状态到kafka
        kafkaTemplate.send(kafkaTopicStateForInsertHbase,csStateCurrent);
        // 含分时租赁插件的 808 终端，不转发 0x0200 定位数据
        // 终端具备分时租赁功能，则不更新SOC，obd里程，目前按照插件版本>0来判断终端具备分时租赁功能
        if (!(csMachine.getCsmTlV2() != null && csMachine.getCsmTlV2() > 0)) {
          return csStateCurrent;
        } else {
          return null;
        }
      } else {
        // 808 原始0200数据，以下业务数据不做更新
        CsState csStateInsert = terminalUtils.setCsStatus(csVehicle, csMachine);
        csStateInsert.setCssNumber(mapping.getNumber());
        csStateInsert.setCssCsq(jvi.getCsq());
        csStateInsert.setCssCurrentTime(StringUtils.date(jvi.getTime(), ConstantUtils.TIME_FORMAT));
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

        csStateInsert.setCssLongitude(AccurateOperationUtils.mul(jvi.getLongitude(), 0.000001));
        csStateInsert.setCssLatitude(AccurateOperationUtils.mul(jvi.getLatitude(), 0.000001));

        updateStateService.insert(csStateInsert);
        // 发送历史状态到kafka
        kafkaTemplate.send(kafkaTopicStateForInsertHbase,csStateInsert);
        // 处理历史状态
//        ListOperations opsForList = redisTemplate.opsForList();
//        opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE, csStateInsert);
        //historyStateUtils.saveHistoryData(csStateInsert);
        return csStateInsert;
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 保存CAN数据
   *
   * @param message 上传
   * @param canData 0x0900 透传数据
   */
  @Timer
  public void saveCanData(MachineMapping mapping, final T808Message message,
      final JT_0900_can canData) {
    try {
      CsMachine csMachine = new CsMachine();
      csMachine.setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
      csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
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
      int speed = 0;

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
          } else if (canDataTypeI.mCanId == 0x300) {
            speed = (canDataTypeI.mCanData2 & 0xff);
          }
        }
      }

      final String hexString = Tools.ToHexString(buff.array());

      csCan.setCscAddTime(new Date());
      csCan.setCscNumber(csMachine.getCsmNumber());
      csCan.setCscData(hexString);
      csCan.setCscType((short) 1);
      csCan.setCscUploadTime(StringUtils.date(canData.getTime(), ConstantUtils.TIME_FORMAT));
      csCan.setCscOrder(0L);

      final String errorInfo = "";// CanHelperFactory.parseCanErrorData(canDataStr);
      csCan.setCscFault(errorInfo);

      if (mapping.getCan() != null) {
        csCan.setCscId(mapping.getCan());
        // 需要更新的当前CAN数据加入等待队列
        ListOperations opsForList = redisTemplate.opsForList();
        opsForList.leftPush(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE, csCan);
      } else {
        updateCanService.insert(csCan);
      }
      // 处理can历史状态
      kafkaTemplate.send(kafkaTopicCanForInsertHbase,csCan);
//      ListOperations opsForList = redisTemplate.opsForList();
//      opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE, csCan);


      // 众泰E200车型不包含分时租赁插件的终端需要更新obd里程跟SOC
      if (mapping.getAccess() != null && mapping.getAccess() != 3 && mapping.getAccess() != 4
          && mapping.getAccess() != 5) {
        csMachine = terminalUtils.getMappingMachine(mapping);
        // 不含分时租赁插件的808终端 通过 can 更新 soc，obdmiles，speed
        if (!(csMachine.getCsmTlV2() != null && csMachine.getCsmTlV2() > 0)) {
          if (mapping.getState() != null) {
            CsState csState = queryStateService.queryStateByIdFor808(mapping.getState().intValue());
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
              // 需要更新的当前状态加入等待队列
//          opsForList.leftPush(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, csState);
            }
          }
        }
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
  @Timer
  public void saveCanData(MachineMapping mapping, final T808Message message,
      final JT_0900_can canData,
      final String type) {
    try {
      long startTime = System.nanoTime();

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

      logger.info("saveCanData()2 init csCan time {} 微秒",
          System.nanoTime() - startTime);

      CsCan csCanNew;
      if (mapping.getCan() != null) {
        // 获取车机号，access，host，car 等信息
        startTime = System.nanoTime();
        csCanNew = queryCanService.queryCanById(mapping.getCan());
        logger.info("saveCanData()2 queryCanService.queryCanById time {} 微秒",
            System.nanoTime() - startTime);
      } else {
        return;
      }
      if (csCanNew != null) {
        // 设置上传时间，原始数据
        startTime = System.nanoTime();
        csCanNew.setCscUploadTime(StringUtils.date(canData.getTime(), ConstantUtils.TIME_FORMAT));
        csCanNew.setCscData(hexString);
        // 处理can历史状态
        kafkaTemplate.send(kafkaTopicCanForInsertHbase,csCanNew);
//        ListOperations opsForList = redisTemplate.opsForList();
//        opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE, csCanNew);
        logger.info("saveCanData()2 historyCanUtils.saveHistoryData time {} 微秒",
            System.nanoTime() - startTime);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
