package com.ccclubs.command.inf.air.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.AirAllInput;
import com.ccclubs.command.dto.AirAllOutput;
import com.ccclubs.command.dto.AirMonoInput;
import com.ccclubs.command.dto.AirMonoOutput;
import com.ccclubs.command.inf.air.AirConditionerCmdInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteService;
import com.ccclubs.command.util.ResultHelper;
import com.ccclubs.command.util.CommandConstants;
import com.ccclubs.command.util.TerminalOnlineHelper;
import com.ccclubs.command.util.ValidateHelper;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.CsRemote;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.pub.orm.mapper.CsStructMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsStructWithBLOBs;
import com.ccclubs.pub.orm.model.CsVehicle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 空调控制指令实现
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
@Service(version = CommandServiceVersion.V1)
public class AirConditionerCmdImpl implements AirConditionerCmdInf {

    private static final Logger logger = LoggerFactory.getLogger(AirConditionerCmdImpl.class);

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

    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;

    @Override
    @DataAuth
    public AirMonoOutput airConditionerMonoCtrl(AirMonoInput input) {
        Integer structId = CommandConstants.CMD_AIR;
        if (input.getItem() == 1 && input.getValue() != 0 && input.getValue() != 1) {
            throw new ApiException(ApiEnum.AIR_CTRL_CIRCULAR_ERROR);
        }
        if (input.getItem() == 2 && input.getValue() != 0 && input.getValue() != 1) {
            throw new ApiException(ApiEnum.AIR_CTRL_PTC_ERROR);
        }
        if (input.getItem() == 3 && input.getValue() != 0 && input.getValue() != 1) {
            throw new ApiException(ApiEnum.AIR_CTRL_COMPRESS_ERROR);
        }
        if (input.getItem() == 4 && Arrays.binarySearch(CommandConstants.FAN, input.getValue()) < 0) {
            throw new ApiException(ApiEnum.AIR_CTRL_FAN_ERROR);
        }
        logger.debug("begin process command {} start.", structId);

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine);

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(Long.parseLong(structId.toString()));//todo
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, java.util.Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                format("[{\"type\":\"{}\",\"ctrl\":\"{}\"}]", input.getItem(), input.getValue())
                .getMessage(), java.util.Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        CsRemote csRemote = remoteService.save(csVehicle, csMachine, structId, input.getAppId());

        // 3.发送指令
        logger.debug("command send start.");

        process.dealRemoteCommand(csRemote, array);

        AirMonoOutput output = new AirMonoOutput();
        // 4.确认结果
        output = resultHelper.confirmResult(csRemote, input.getResultType(), output);

        return output;
    }

    @Override
    @DataAuth
    public AirAllOutput airConditionerAllCtrl(AirAllInput input) {
        Integer structId = CommandConstants.CMD_AIR;

        logger.debug("begin process command {} start.", structId);

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine);

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(Long.parseLong(structId.toString()));
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, java.util.Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                        format("[{\"type\":\"{}\",\"ctrl\":\"{}\"}]", 5, getAllValue(input)).getMessage(),
                java.util.Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        CsRemote csRemote = remoteService.save(csVehicle, csMachine, structId, input.getAppId());

        // 3.发送指令
        logger.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);

        AirAllOutput output = new AirAllOutput();
        // 4.确认结果
        output = resultHelper.confirmResult(csRemote, input.getResultType(), output);

        return output;
    }

    /**
     * 根据Evnet远程操作协议计算 全部控制情况下的操作值（8位二进制）
     */
    public int getAllValue(AirAllInput input) {
        int sum = input.getCircular() + (input.getPtc() << 1) + (input.getCompress() << 2);
        int value = (input.getFan() << 3) | sum;
        return value;
    }

}
