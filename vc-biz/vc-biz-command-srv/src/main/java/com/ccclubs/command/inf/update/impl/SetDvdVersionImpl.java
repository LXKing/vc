package com.ccclubs.command.inf.update.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.DvdVersionIntput;
import com.ccclubs.command.dto.DvdVersionOutput;
import com.ccclubs.command.inf.update.SetDvdVersionInf;
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
 * DVD最新版本设置
 *
 * @author jianghaiyang
 * @create 2017-08-01
 **/
@Service(version = CommandServiceVersion.V1)
public class SetDvdVersionImpl implements SetDvdVersionInf {
    private static final Logger logger = LoggerFactory.getLogger(SetDvdVersionImpl.class);

    /**
     * 命令处理
     *      主要用于终端升级
     */
    @Autowired
    private CommandProcessInf process;

    /**
     * 指令结构
     */
    @Autowired
    private CsStructMapper sdao;

    /**
     * 验证
     */
    @Resource
    private ValidateHelper validateHelper;

    /**
     * 指令结果
     */
    @Resource
    private ResultHelper resultHelper;

    /**
     * 指令记录
     */
    @Resource
    private CsRemoteManager csRemoteManager;
    /**
     * ID生成
     */
    @Resource
    IdGeneratorHelper idGen;

    /**
     * 终端在线情况查询
     */
    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;
    /**
     * 指令发送时身份认证
     */
    @Resource
    AuthValidateHelper authValidateHelper;

    /**
     * 设置DVD版本
     * @param input
     * @return
     */
    @Override
    public DvdVersionOutput setDvdVersion(DvdVersionIntput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        Long structId = CommandConstants.CMD_DVD.longValue();
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
        terminalOnlineHelper.isOnline(csMachine, input.getVin());

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(structId);
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, java.util.Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                format("[{\"value\":\"{}\"}]", input.getLatestVersion())
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
        DvdVersionOutput output = new DvdVersionOutput();
        output = resultHelper.confirmResult(csRemote, input.getResultType(), output, csMachine);

        return output;
    }
}
