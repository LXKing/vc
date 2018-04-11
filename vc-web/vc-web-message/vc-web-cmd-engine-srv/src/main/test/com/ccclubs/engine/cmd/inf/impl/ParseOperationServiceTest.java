package com.ccclubs.engine.cmd.inf.impl;


import com.alibaba.fastjson.JSON;
import com.ccclubs.common.modify.UpdateTerminalService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.engine.cmd.srv.CmdEngineSrvApp;
import com.ccclubs.engine.core.util.RedisHelper;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.pub.orm.model.CsMachine;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author qsxiaogang
 * @create 2017-09-21
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CmdEngineSrvApp.class)
public class ParseOperationServiceTest {

  private static Logger logger = LoggerFactory.getLogger(ParseOperationServiceTest.class);
  @Autowired
  QueryTerminalService queryTerminalService;
  @Autowired
  UpdateTerminalService updateTerminalService;

  @Autowired
  RedisHelper redisHelper;
  //  @Autowired
//  QueryVehicleService queryVehicleService;
//  @Autowired
//  BaseDao<VcVehicleKeyStatus> vehicleKeyStatusDao;
//  @Autowired
//  QueryVehicleKeyStatusService queryVehicleKeyStatusService;
  @Autowired
  RedisTemplate redisTemplate;

  @Test
  public void processMessage() throws Exception {
    String hexString = "543132333230353400000000000000020701215E6A2A06E52301215E3DAA00215E3DE601215E3E5E00215E3E9901215E3F1100215E3F4D01215E3FC500215E400101215E407900215E40B501215E412D00215E416901215E41E100215E421D01215E429500215E42D101215E434900215E438501215E43FD00215E443901215E44B100215E44ED01215E456500215E45A101215E461900215E465501215E46CD00215E470901215E478100215E47BD01215E483500215E487101215E48E900215E492501215E499D";
//    String hexString = "5436373130383737000000000000000066020000000000000000000000000000000000750001A956001F000D2565000000000031000000B70000000000000000000000003420EE28F600D664000503000000000000000014000000005551000000000000000006D5D50805319F";
    MqMessage mqMessage = new MqMessage();
    mqMessage.ReadFromBytes(Tools.HexString2Bytes(hexString));

    CsMachine csMachine2 = new CsMachine();
    csMachine2.setCsmNumber(mqMessage.getCarNumber());
    csMachine2.setCsmId(1);
    csMachine2.setCsmUpdateTime(new Date());
    csMachine2.setCsmAddTime(new Date());
    csMachine2.setCsmAccess(1);

    logger.info(JSON.toJSONString(csMachine2));

    redisTemplate.opsForValue().set("Test:CsMachine", csMachine2);

    CsMachine newCsmachine = (CsMachine) redisTemplate.opsForValue().get("Test:CsMachine");

    logger.info(JSON.toJSONString(newCsmachine));


//    ListOperations ops = redisTemplate.opsForList();
//    ops.leftPush(CmdEngineConstants.REDIS_KEY_VEHICLE_KEY_QUEUE, mqMessage);


    long startTime = System.currentTimeMillis();
    ProtocolTools.isAllFieldNull(csMachine2);
    long dur = System.currentTimeMillis() - startTime;

    logger.info("耗时 {}", dur);

    CsMachine csMachine = queryTerminalService.queryCsMachineByCarNumber("GGGGG");

    CsMachine csMachineNew = new CsMachine();
    csMachineNew.setCsmId(csMachine.getCsmId());
    csMachineNew.setCsmUpdateTime(new Date());

    CsMachine csMachine1 = updateTerminalService.update(csMachineNew);

    logger.info(JSON.toJSONString(csMachine));

//    CsVehicle csVehicle = queryVehicleService.queryVehicleByMachine(csMachine.getCsmId());
//
//    logger.debug(JSON.toJSONString(csMachine));
//
//    VcVehicleKeyStatus vcVehicleKeyStatus = queryVehicleKeyStatusService
//        .queryVehicleKeyStatus(mqMessage.getCarNumber(), mqMessage.getTransId());
//    if (null == vcVehicleKeyStatus) {
//      vcVehicleKeyStatus = new VcVehicleKeyStatus();
//      vcVehicleKeyStatus.setAccess(csMachine.getCsmAccess());
////    vcVehicleKeyStatus.setAccessName(csMachine.getCsmAccess());
//      vcVehicleKeyStatus.setTerminal(csMachine);
//      vcVehicleKeyStatus.setTerminalId(csMachine.getCsmId());
//      vcVehicleKeyStatus.setTerminalNumber(mqMessage.getCarNumber());
//      vcVehicleKeyStatus.setVehicleId(csVehicle.getCsvId());
//      vcVehicleKeyStatus.setVin(csVehicle.getCsvVin());
//      vcVehicleKeyStatus.setTransOrderId(mqMessage.getTransId());
//
//      MQTT_07 mqtt_07 = new MQTT_07();
//      mqtt_07.ReadFromBytes(mqMessage.getMsgBody());
//      List<VehicleKeyStatus> vehicleKeyStatusList = new ArrayList<>();
//      for (MQTT_07_Item item : mqtt_07.getList()) {
//        if (null != item) {
//          VehicleKeyStatus vehicleKeyStatus = new VehicleKeyStatus();
//          vehicleKeyStatus.setVehicleKeyStatus((int) item.getKeyStatus());
//          vehicleKeyStatus
//              .setStartTime(new DateTime(ProtocolTools.transformToServerTime(item.getTime())));
//          vehicleKeyStatus.setPlatformStartTime(DateTime.now());
//          vehicleKeyStatusList.add(vehicleKeyStatus);
//        }
//      }
//      vcVehicleKeyStatus.setKeyStatusList(vehicleKeyStatusList);
//      vehicleKeyStatusDao.save(vcVehicleKeyStatus);
//
//      logger.info(JSON.toJSONString(vcVehicleKeyStatus));
//    } else {
//      MQTT_07 mqtt_07 = new MQTT_07();
//      mqtt_07.ReadFromBytes(mqMessage.getMsgBody());
//      List<VehicleKeyStatus> vehicleKeyStatusList = new ArrayList<>();
//      for (MQTT_07_Item item : mqtt_07.getList()) {
//        if (null != item) {
//          VehicleKeyStatus vehicleKeyStatus = new VehicleKeyStatus();
//          vehicleKeyStatus.setVehicleKeyStatus((int) item.getKeyStatus());
//          vehicleKeyStatus
//              .setStartTime(new DateTime(ProtocolTools.transformToServerTime(item.getTime())));
//          vehicleKeyStatus.setPlatformStartTime(DateTime.now());
//          vehicleKeyStatusList.add(vehicleKeyStatus);
//        }
//      }
//      Update update = new Update();
//      update.pushAll("keyStatusList", vehicleKeyStatusList.toArray());
//      vehicleKeyStatusDao
//          .update(new Query(Criteria.where("_id").is(vcVehicleKeyStatus.getId())), update);
//
//      logger.debug(JSON.toJSONString(vcVehicleKeyStatus));
//    }
  }

}
