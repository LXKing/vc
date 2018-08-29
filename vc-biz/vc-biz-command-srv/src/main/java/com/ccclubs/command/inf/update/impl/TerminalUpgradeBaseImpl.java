/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.ccclubs.command.inf.update.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.command.dto.UpgradeOutput;
import com.ccclubs.command.inf.update.TerminalUpgradeBase;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.util.CommandConstants;
import com.ccclubs.command.util.TerminalOnlineHelper;
import com.ccclubs.command.util.UpdateHelper;
import com.ccclubs.command.util.ValidateHelper;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
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
    UpdateHelper updateHelper;
    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;
    // 只支持通灵的车
    private int tl = 3;

    /**
     * 根据文件名称升级
     *
     * @param vin      终端vin码
     * @param fileName 文件名称
     * @return
     */
    @Override
    public void terminalUpgradeByFileName(String vin, String fileName) {
        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(vin);
        //CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);
        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine);
        // 只支持通灵的车
        if (tl != csMachine.getCsmTeType()) {
            throw new ApiException(ApiEnum.FAIL);
        }
        T808Message updateMessage = updateHelper
                .getUpdateMessageForTl(csMachine.getCsmMobile(), fileName);
        process.dealRemoteCommand(csMachine, updateMessage.WriteToBytes(), true);
        logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
    }

}
