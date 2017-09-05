package com.ccclubs.command.inf.time.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.TimeSyncInput;
import com.ccclubs.command.dto.TimeSyncOutput;
import com.ccclubs.command.inf.time.TimeSyncCmdInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteService;
import com.ccclubs.command.util.ResultHelper;
import com.ccclubs.command.util.CommandConstants;
import com.ccclubs.command.util.ValidateHelper;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.CsRemote;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.mapper.CsStructMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsStructWithBLOBs;
import com.ccclubs.pub.orm.model.CsVehicle;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 时间同步指令实现
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
@Service(version = CommandServiceVersion.V1)
public class TimeSyncCmdImpl implements TimeSyncCmdInf {

  private static final Logger logger = LoggerFactory.getLogger(TimeSyncCmdImpl.class);

  @Autowired
  private CommandProcessInf process;

  @Autowired
  private CsStructMapper sdao;

  @Resource
  private ValidateHelper validateHelper;

  @Resource
  private ResultHelper resultHelper;

  @Resource
  private CsRemoteService remoteService;

  @Override
  @DataAuth
  public TimeSyncOutput timeSynchronization(TimeSyncInput input) {

    Integer structId = CommandConstants.CMD_TIME;
    Date time = StringUtils.date(input.getTime(), CommandConstants.DATE_FORMAT);
    logger.info("begin process command {} start.", structId);
    // 校验指令码
    if (null == structId) {
      throw new ApiException(ApiEnum.COMMAND_NOT_FOUND);
    }

    // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
    Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
    CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
    CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

    // 1.查询指令结构体定义
    CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(Long.parseLong(structId.toString()));//todo
    String cssReq = csStruct.getCssRequest();
    List<Map> requests = JSONArray.parseArray(cssReq, java.util.Map.class);
    List<Map> values = JSONArray.parseArray(MessageFormatter.
            format("[{\"value\":\"{}\"}]", ProtocolTools.transformToTerminalTime(time)).getMessage(),
        java.util.Map.class);
    Object[] array = ProtocolTools.getArray(requests, values);

    // 2.保存记录 cs_remote
    CsRemote csRemote = remoteService.save(csVehicle, csMachine, structId, input.getAppId());

    // 3.发送指令
    logger.info("command send start.");
    try {
      process.dealRemoteCommand(csRemote, array);
    } catch (ApiException ex) {
      throw ex;
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
      throw new ApiException(ApiEnum.SYSTEM_ERROR);
    }

    TimeSyncOutput output = new TimeSyncOutput();

    // 4.校验结果返回
    output = resultHelper.confirmResult(csRemote, input.getResultType(), output);

    return output;
  }

}
