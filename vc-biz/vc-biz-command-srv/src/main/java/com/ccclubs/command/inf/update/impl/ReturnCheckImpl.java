package com.ccclubs.command.inf.update.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.ReturnCheckInput;
import com.ccclubs.command.dto.ReturnCheckOutput;
import com.ccclubs.command.inf.update.ReturnCheckInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteManager;
import com.ccclubs.command.util.*;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.validate.AuthValidateHelper;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.pub.orm.mapper.CsStructMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsStructWithBLOBs;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 设置还车检查（充电）
 * 0：还车时，终端不校验车辆充电；
 * 1：还车时，终端需要校验车辆充电，不充电不允许还车。
 *
 * @author jianghaiyang
 * @create 2017-08-01
 **/
@Service(version = CommandServiceVersion.V1)
public class ReturnCheckImpl implements ReturnCheckInf {
    private static final Logger logger = LoggerFactory.getLogger(ReturnCheckImpl.class);

    @Autowired
    private CommandProcessInf process;

    @Autowired
    private CsStructMapper sdao;

    @Resource
    private ValidateHelper validateHelper;

    @Resource
    private ResultHelper resultHelper;

    @Resource
    private CsRemoteManager csRemoteManager;
    @Resource
    IdGeneratorHelper idGen;

    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;
    @Resource
    AuthValidateHelper authValidateHelper;

    @Override
    public ReturnCheckOutput setReturn(ReturnCheckInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        Long structId = CommandConstants.CMD_RETURN.longValue();
        logger.debug("begin process command {} start.", structId);
        // 校验指令码
        if (null == structId) {
            throw new ApiException(ApiEnum.COMMAND_NOT_FOUND);
        }

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine);

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(structId);
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, java.util.Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                format("[{\"value\":\"{}\"}]", input.getValue())
                .getMessage(), java.util.Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGen.getNextId();
        CsRemote csRemote = CsRemoteUtil.construct(csVehicle, csMachine, structId.longValue(), array, input.getAppId(), csrId);
        csRemoteManager.asyncSave(csRemote);

        // 3.发送指令
        logger.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);

        // 4.确认结果
        ReturnCheckOutput output = new ReturnCheckOutput();
        output = resultHelper.confirmResult(csRemote, input.getResultType(), output, csMachine);

        return output;
    }
}
