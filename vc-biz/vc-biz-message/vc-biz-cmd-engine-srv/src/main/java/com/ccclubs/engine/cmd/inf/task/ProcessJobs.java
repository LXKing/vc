package com.ccclubs.engine.cmd.inf.task;

import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleKeyStatusService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.engine.cmd.inf.util.CmdEngineConstants;
import com.ccclubs.mongo.orm.dao.BaseDao;
import com.ccclubs.mongo.orm.model.VcVehicleKeyStatus;
import com.ccclubs.mongo.orm.model.VehicleKeyStatus;
import com.ccclubs.protocol.dto.mqtt.MQTT_07;
import com.ccclubs.protocol.dto.mqtt.MQTT_07_Item;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.SrvHost;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 钥匙状态改变处理定时任务
 *
 * @author jianghaiyang
 * @create 2017-09-27
 **/
@Component
public class ProcessJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory.getLogger(ProcessJobs.class);

  @Autowired
  QueryTerminalService queryTerminalService;
  @Autowired
  QueryVehicleService queryVehicleService;
  @Resource
  QueryAppInfoService queryHostInfoService;
  @Autowired
  BaseDao<VcVehicleKeyStatus> vehicleKeyStatusDao;
  @Autowired
  QueryVehicleKeyStatusService queryVehicleKeyStatusService;

  @Autowired
  RedisTemplate redisTemplate;

  protected static ApplicationContext context;

  /**
   * 扫描请求队列，移除成功的记录并重置计数器
   */
  @Scheduled(fixedRate = 2000)
  public void fixedRateJob() {
    Object keyStatus = redisTemplate.opsForList()
        .rightPop(CmdEngineConstants.REDIS_KEY_VEHICLE_KEY_QUEUE);
    if (null != keyStatus) {
      MqMessage input = new MqMessage();
      input.ReadFromBytes(Tools.HexString2Bytes(keyStatus.toString()));
      if (input == null || StringUtils.empty(input.getCarNumber())) {
        return;
      }
      CsMachine csMachine = queryTerminalService.queryTerminalByCarNumber(input.getCarNumber());
      if (null == csMachine) {
        logger.warn("{} 终端在系统中不存在", input.getCarNumber());
        return;
      }
      CsVehicle csVehicle = queryVehicleService.queryVehicleByMachine(csMachine.getCsmId());
      SrvHost srvHost = queryHostInfoService.queryHostById(csMachine.getCsmAccess());

      VcVehicleKeyStatus vcVehicleKeyStatus = queryVehicleKeyStatusService
          .queryVehicleKeyStatus(input.getCarNumber(), input.getTransId());
      if (null == vcVehicleKeyStatus) {
        vcVehicleKeyStatus = new VcVehicleKeyStatus();
        vcVehicleKeyStatus.setAccess(csMachine.getCsmAccess());
        vcVehicleKeyStatus.setAccessName(null == srvHost ? "" : srvHost.getShName());
        vcVehicleKeyStatus.setTerminal(csMachine);
        vcVehicleKeyStatus.setTerminalId(csMachine.getCsmId());
        vcVehicleKeyStatus.setTerminalNumber(input.getCarNumber());
        vcVehicleKeyStatus.setVehicleId(null == csVehicle ? 0 : csVehicle.getCsvId());
        vcVehicleKeyStatus.setVin(null == csVehicle ? "" : csVehicle.getCsvVin());
        vcVehicleKeyStatus.setTransOrderId(input.getTransId());

        MQTT_07 mqtt_07 = new MQTT_07();
        mqtt_07.ReadFromBytes(input.getMsgBody());
        List<VehicleKeyStatus> vehicleKeyStatusList = getMqttItemList(mqtt_07);
        if (vehicleKeyStatusList.size() != 0) {
          vcVehicleKeyStatus.setKeyStatusList(vehicleKeyStatusList);
        }
        logger.debug("save start");
        vehicleKeyStatusDao.save(vcVehicleKeyStatus);
      } else {
        MQTT_07 mqtt_07 = new MQTT_07();
        mqtt_07.ReadFromBytes(input.getMsgBody());
        List<VehicleKeyStatus> vehicleKeyStatusList = getMqttItemList(mqtt_07);
        if (vehicleKeyStatusList.size() == 0) {
          return;
        }

        Update update = new Update();
        update.pushAll("keyStatusList", vehicleKeyStatusList.toArray());

        logger.debug("update start");
        vehicleKeyStatusDao
            .update(new Query(Criteria.where("_id").is(vcVehicleKeyStatus.getId())), update);
      }
    }
  }

  private List<VehicleKeyStatus> getMqttItemList(MQTT_07 mqtt_07) {
    List<VehicleKeyStatus> vehicleKeyStatusList = new ArrayList<>();
    for (MQTT_07_Item item : mqtt_07.getList()) {
      if (null != item) {
        VehicleKeyStatus vehicleKeyStatus = new VehicleKeyStatus();
        vehicleKeyStatus.setVehicleKeyStatus((int) item.getKeyStatus());
        vehicleKeyStatus
            .setStartTime(new DateTime(ProtocolTools.transformToServerTime(item.getTime())));
        vehicleKeyStatus.setPlatformStartTime(DateTime.now());
        vehicleKeyStatusList.add(vehicleKeyStatus);
      }
    }
    return vehicleKeyStatusList;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
