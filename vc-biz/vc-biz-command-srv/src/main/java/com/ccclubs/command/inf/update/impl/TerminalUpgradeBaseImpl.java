/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.ccclubs.command.inf.update.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.UpgradeOutput;
import com.ccclubs.command.inf.update.TerminalUpgradeBase;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteManager;
import com.ccclubs.command.util.*;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.dto.jt808.T808Message;
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
 * @author zhaoyunxing92
 * @class: com.ccclubs.command.inf.update.impl.TerminalUpgradeBaseImpl
 * @date: 2018-08-29 11:07
 * @des: 一键升级
 */
@Service(version = CommandServiceVersion.V1)
public class TerminalUpgradeBaseImpl implements TerminalUpgradeBase {
    private static final Logger logger = LoggerFactory.getLogger(TerminalUpgradeBaseImpl.class);

    @Autowired
    private CommandProcessInf process;
    @Resource
    private ValidateHelper validateHelper;
    @Autowired
    private UpdateHelper updateHelper;
    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;
    @Autowired
    private CsStructMapper csStructMapper;
    @Resource
    private IdGeneratorHelper idGeneratorHelper;
    @Resource
    private CsRemoteManager csRemoteManager;

    /**
     * 根据文件名称升级程序
     *
     * @param vin      终端vin码
     * @param fileName 文件名称
     * @return
     */
    @Override
    public void terminalUpgradeByFileName(String appId, String vin, String fileName) {
        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(vin);
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);
        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine, vin);
        // 只支持通灵的车
        if (3 != csMachine.getCsmTeType()) {
            throw new ApiException(ApiEnum.FAIL);
        }
        //判断文件名称不同升级方式
        if (fileName.startsWith("SHENGJI")) {//大版本升级
            upgradeTerminalAll(fileName, csMachine);
        } else if (fileName.startsWith("IR_RUN")) {//插件版本升级
            upgradeTerminalPlugin("1000001", fileName, csVehicle, csMachine);
        } else {
            logger.warn("文件名{}不合法，只支持SHENGJI或IR_RUN开头的文件名升级", fileName);
            throw new ApiException(101026, String.format("文件名【%s】不合法，只支持SHENGJI或IR_RUN开头的文件名升级", fileName));
        }
    }

    /**
     * 全部升级
     *
     * @param fileName
     * @param csMachine
     */
    private void upgradeTerminalAll(String fileName, CsMachine csMachine) {
        T808Message updateMessage = updateHelper
                .getUpdateMessageForTl(csMachine.getCsmMobile(), fileName);
        process.dealRemoteCommand(csMachine, updateMessage.WriteToBytes(), true);
        logger.info("大版本升级：给终端（Mobile {}）发送升级指令，文件名称：{}", csMachine.getCsmMobile(), fileName);
    }

    /**
     * 升级插件版本
     *
     * @param appId
     * @param fileName
     * @param csVehicle
     * @param csMachine
     */
    private void upgradeTerminalPlugin(String appId, String fileName, CsVehicle csVehicle, CsMachine csMachine) {
        Long structId = CommandConstants.CMD_UPGREAD_FILE.longValue();
        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = csStructMapper.selectByPrimaryKey(structId);
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, Map.class);
        List<Map> values = JSONArray.parseArray(MessageFormatter.
                        format("[{\"value\":\"{}\"}]", fileName).getMessage(),
                Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGeneratorHelper.getNextId();
        CsRemote csRemote = CsRemoteUtil.construct(csVehicle, csMachine, structId, array, appId, csrId);
        csRemoteManager.asyncSave(csRemote);
        // 3.发送指令
        logger.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);
        logger.info("插件版本升级：给终端（Mobile {}）发送升级指令，文件名称：{}", csMachine.getCsmMobile(), fileName);
    }

}
