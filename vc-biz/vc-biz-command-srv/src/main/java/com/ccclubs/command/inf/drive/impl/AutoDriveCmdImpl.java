package com.ccclubs.command.inf.drive.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.GpsAutoDriveInput;
import com.ccclubs.command.dto.GpsAutoDriveOutput;
import com.ccclubs.command.inf.drive.AutoDriveCmdInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteManager;
import com.ccclubs.command.util.*;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.validate.AuthValidateHelper;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.frm.spring.util.LongLatitudeUtil;
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
 * @Author: yeanzi
 * @Date: 2018/9/20
 * @Time: 10:51
 * Email:  yeanzhi@ccclubs.com
 * GPS自动驾驶指令实现类
 */
@Service(version = CommandServiceVersion.V1)
public class AutoDriveCmdImpl implements AutoDriveCmdInf {
    private static final Logger logger = LoggerFactory.getLogger(AutoDriveCmdImpl.class);

    @Autowired
    private CommandProcessInf process;

    @Autowired
    private CsStructMapper sdao;

    /**
     * 验证
     */
    @Resource
    private ValidateHelper validateHelper;

    /**
     * 指令发送结果
     */
    @Resource
    private ResultHelper resultHelper;

    @Resource
    private CsRemoteManager csRemoteManager;

    /**
     * 上下线查询
     */
    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;

    @Resource
    IdGeneratorHelper idGen;

    /**
     * 身份认证
     */
    @Resource
    AuthValidateHelper authValidateHelper;

    @Override
    public GpsAutoDriveOutput gpsAutoDriveCtrl(GpsAutoDriveInput input) {
        // 数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }

        // 获取结构ID
        Long structId = CommandConstants.CMD_AUTO_DRIVE.longValue();
        logger.debug("begin process command {} start.", structId);

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
        int longitude = LongLatitudeUtil.Str2Int(input.getLog());
        int latitude = LongLatitudeUtil.Str2Int(input.getLat());
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                arrayFormat("[{\"line\":\"{}\",\"log\":\"{}\",\"lat\":\"{}\"}]", new Object[]{input.getDriveCmd(), longitude, latitude})
                .getMessage(), java.util.Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGen.getNextId();
        CsRemote csRemote = CsRemoteUtil.construct(csVehicle, csMachine, structId, array, input.getAppId(), csrId);
        csRemoteManager.asyncSave(csRemote);

        // 3.发送指令
        logger.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);

        // 4.确认结果
        GpsAutoDriveOutput output = new GpsAutoDriveOutput();
        output = resultHelper.confirmResult(csRemote, input.getResultType(), output, csMachine);

        return output;
    }
}
