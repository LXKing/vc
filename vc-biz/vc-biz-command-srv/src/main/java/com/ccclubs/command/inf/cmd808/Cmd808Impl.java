package com.ccclubs.command.inf.cmd808;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.Send808CmdInput;
import com.ccclubs.command.dto.Send808CmdOutput;
import com.ccclubs.command.inf.simple.impl.SendSimpleCmdImpl;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteManager;
import com.ccclubs.command.util.*;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.query.QueryStructService;
import com.ccclubs.frm.logger.VehicleControlLogger;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsStructWithBLOBs;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 808指令
 *
 * @author jianghaiyang
 * @create 2018-01-24
 **/
@Service(version = CommandServiceVersion.V1)
public class Cmd808Impl implements Cmd808Inf{
    private static final Logger logger = LoggerFactory.getLogger(SendSimpleCmdImpl.class);
    private static final Logger loggerBusiness = VehicleControlLogger.getLogger();
    @Resource
    IdGeneratorHelper idGen;
    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;
    @Resource
    private ValidateHelper validateHelper;
    @Resource
    private CsRemoteManager csRemoteManager;
    @Resource
    private QueryStructService queryStructService;
    @Resource
    private ResultHelper resultHelper;
    @Autowired
    private CommandProcessInf process;

    /**
     * 发送808指令 TODO
     * 808指令只有两个字节存储指令流水号（csrsId）
     * @param input
     * @return
     */
    @Override
    public Send808CmdOutput send808CmdInf(Send808CmdInput input) {
        Long structId = 808L;
        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine);

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = queryStructService.queryCsStructByStructId(structId);
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, java.util.Map.class);
//        List<Map> values = JSONArray.parseArray(MessageFormatter.
//                format("[{\"type\":\"{}\",\"ctrl\":\"{}\"}]", input.getItem(), input.getValue())
//                .getMessage(), java.util.Map.class);
//        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGen.getNextId();
        long csrsId = idGen.getNextSid(input.getVin());
        CsRemote csRemote = CsRemoteUtil.construct808(csVehicle, csMachine, structId, input.getAppId(),csrId,csrsId);
        csRemoteManager.asyncSave(csRemote);

        // 3.发送指令
        logger.debug("command send start.");
//        process.dealRemoteCommand(csRemote, array);

        // 4.确认结果
        Send808CmdOutput output = new Send808CmdOutput();
        output = resultHelper.confirmResult(csRemote, input.getResultType(), output, csMachine);
        return output;
    }
}
