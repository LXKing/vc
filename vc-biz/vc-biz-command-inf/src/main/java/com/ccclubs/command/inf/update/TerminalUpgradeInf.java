package com.ccclubs.command.inf.update;

import com.ccclubs.command.dto.MixedUpgradeTask;
import com.ccclubs.command.dto.UpgradeInput;
import com.ccclubs.command.dto.UpgradeOutput;
import com.ccclubs.upgrade.dto.UpgradeTask;

/**
 * 终端一键升级
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
public interface TerminalUpgradeInf {
    /**
     * 一键升级
     * @param input
     * @return
     */
    UpgradeOutput oneKeyUpgrade(UpgradeInput input);

    UpgradeOutput basicUpgrade(UpgradeTask task);

    UpgradeOutput upgradePlugin(UpgradeTask task);

    UpgradeOutput upgradeMajor(UpgradeTask task);

    /**
     * 通领二合一版本升级
     * @param upgradeTask
     */
    UpgradeOutput upgradeMixedVersionTask(MixedUpgradeTask upgradeTask);

    void sendSetCommand(String vin);
}
