package com.ccclubs.command.inf.tamper.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.TamperInput;
import com.ccclubs.command.dto.TamperOutput;
import com.ccclubs.command.inf.tamper.TamperCmdInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteManager;
import com.ccclubs.command.util.CommandConstants;
import com.ccclubs.command.util.CsRemoteUtil;
import com.ccclubs.command.util.IdGeneratorHelper;
import com.ccclubs.command.util.ResultHelper;
import com.ccclubs.command.util.TerminalOnlineHelper;
import com.ccclubs.command.util.ValidateHelper;
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
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 防拆控制服务
 * @auther Vincent
 * @wechat luxiaotao1123
 * @data 2018/8/21
 */
@Service(version = CommandServiceVersion.V1)
public class TamperCmdInfImpl implements TamperCmdInf {

    private static final Logger logger = LoggerFactory.getLogger(TamperCmdInfImpl.class);

    @Resource
    private ValidateHelper validateHelper;
    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;
    @Resource
    private ResultHelper resultHelper;
    @Resource
    private CsRemoteManager csRemoteManager;
    @Resource
    IdGeneratorHelper idGen;
    @Autowired
    private CommandProcessInf process;
    @Autowired
    private CsStructMapper sdao;
    @Resource
    AuthValidateHelper authValidateHelper;

    @Override
    public TamperOutput tamperCommandComply(TamperInput input) {

        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        Long structId = CommandConstants.CMD_TAMPER.longValue();
        logger.debug("begin process command {} start.", structId);

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine,input.getVin());

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(structId);
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                        format("[{\"value\":\"{}\"}]", input.codeToHexString()).getMessage(),
                Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGen.getNextId();
        CsRemote csRemote = CsRemoteUtil.construct(csVehicle, csMachine, structId, array, input.getAppId(), csrId);
        csRemoteManager.asyncSave(csRemote);

        // 3.发送指令
        logger.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);

        TamperOutput output = new TamperOutput();
        output = resultHelper.confirmResult(csRemote, input.getResultType(), output, csMachine);

        return output;
    }

}