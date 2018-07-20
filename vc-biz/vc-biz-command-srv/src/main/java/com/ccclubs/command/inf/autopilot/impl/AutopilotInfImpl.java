package com.ccclubs.command.inf.autopilot.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.SiteIssuedInput;
import com.ccclubs.command.dto.SiteIssuedOutput;
import com.ccclubs.command.dto.VoiceIssuedInput;
import com.ccclubs.command.dto.VoiceIssuedOutput;
import com.ccclubs.command.inf.autopilot.AutopilotInf;
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
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/10
 * @Time: 14:55
 * @Description: 自动驾驶相关指令下发！
 */
@Service(version = CommandServiceVersion.V1)
public class AutopilotInfImpl implements AutopilotInf {

    private static final Logger logger = LoggerFactory.getLogger(AutopilotInfImpl.class);

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
    private TerminalOnlineHelper terminalOnlineHelper;

    @Resource
    IdGeneratorHelper idGen;
    @Resource
    AuthValidateHelper authValidateHelper;

    /**
     * 语音编号下发
     *
     * @param voiceIssuedInput
     */
    @Override
    public VoiceIssuedOutput voiceCommandComply(VoiceIssuedInput voiceIssuedInput) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(voiceIssuedInput.getAppId(), voiceIssuedInput.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        Long structId = CommandConstants.CMD_VOICE.longValue();
        logger.debug("begin process command {} start.", structId);

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(voiceIssuedInput.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine, voiceIssuedInput.getVin());

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(structId);
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, java.util.Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                format("[{\"value\":\"{}\"}]",
                        getAllValue(voiceIssuedInput))
                .getMessage(), java.util.Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGen.getNextId();
        CsRemote csRemote = CsRemoteUtil.construct(csVehicle, csMachine, structId, array, voiceIssuedInput.getAppId(), csrId);
        csRemoteManager.asyncSave(csRemote);

        // 3.发送指令
        logger.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);

        // 4.确认结果
        VoiceIssuedOutput output = new VoiceIssuedOutput();
        output = resultHelper.confirmResult(csRemote, voiceIssuedInput.getResultType(), output, csMachine);

        return output;
    }

    /**
     * 目标站点下发
     * 依据协议，语音类型左右 7 位，或  input.getVoiceType() & 0x80 或 input.getVoiceType() * 128
     *
     * @param siteIssuedInput
     */
    @Override
    public SiteIssuedOutput siteCommandComply(SiteIssuedInput siteIssuedInput) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(siteIssuedInput.getAppId(), siteIssuedInput.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        Long structId = CommandConstants.CMD_SITE.longValue();
        logger.debug("begin process command {} start.", structId);

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(siteIssuedInput.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine, siteIssuedInput.getVin());

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(structId);
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, java.util.Map.class);
        List<Map> values;
        values = JSONArray.parseArray(MessageFormatter.
                format("[{\"value\":\"{}\"}]", siteIssuedInput.getSiteNum())
                .getMessage(), java.util.Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGen.getNextId();
        CsRemote csRemote = CsRemoteUtil.construct(csVehicle, csMachine, structId, array, siteIssuedInput.getAppId(), csrId);
        csRemoteManager.asyncSave(csRemote);

        // 3.发送指令
        logger.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);

        // 4.确认结果
        SiteIssuedOutput output = new SiteIssuedOutput();
        output = resultHelper.confirmResult(csRemote, siteIssuedInput.getResultType(), output, csMachine);

        return output;
    }

    /**
     * 获取所有值
     * @param input
     * @return
     */
    private int getAllValue(VoiceIssuedInput input) {
        int voicetype = 0;
        if (input.getVoiceType() == 1) {
            voicetype = 128;
        }

        int sum = (voicetype * 256) + input.getVoiceNum();
        return sum;
    }


}
