package com.ccclubs.command.inf.update;

import com.ccclubs.command.dto.UpgradeInput;
import com.ccclubs.command.dto.UpgradeOutput;

/**
 * 终端一键升级
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
public interface TerminalUpgradeInf {
    UpgradeOutput oneKeyUpgrade(UpgradeInput input);
}
