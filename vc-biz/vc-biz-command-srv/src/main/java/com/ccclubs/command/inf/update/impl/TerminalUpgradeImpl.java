package com.ccclubs.command.inf.update.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.command.dto.UpgradeInput;
import com.ccclubs.command.dto.UpgradeOutput;
import com.ccclubs.command.inf.update.TerminalUpgradeInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.util.CommandConstants;
import com.ccclubs.command.util.UpdateHelper;
import com.ccclubs.command.util.ValidateHelper;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.pub.orm.model.CsMachine;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 终端一键升级实现
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
@Service(version = CommandServiceVersion.V1)
public class TerminalUpgradeImpl implements TerminalUpgradeInf {

  private static final Logger logger = LoggerFactory.getLogger(TerminalUpgradeImpl.class);

  @Autowired
  private CommandProcessInf process;

  @Resource
  private ValidateHelper validateHelper;

  /**
   * 终端升级（直接发送，不返还结果）
   *
   * @param input 升级参数
   * @return
   */
  @Override
  public UpgradeOutput oneKeyUpgrade(UpgradeInput input) {
    // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
    Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
    CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

    // TODO:检查终端是否在线，暂时通过查询状态数据来实现
    //升级到1072版本
    T808Message updateMessage = UpdateHelper
        .getUpdateMessageForTl(csMachine.getCsmMobile(), input.getFilename());

    process.dealRemoteCommand(csMachine, updateMessage.WriteToBytes(), true);

    logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());

    return null;

  }

}
