package com.ccclubs.upgrade.inf;

import com.ccclubs.upgrade.dto.UpgradeInput;
import com.ccclubs.upgrade.dto.UpgradeOutput;

/**
 * 终端软件版本或插件升级
 *
 * @author jianghaiyang
 * @create 2017-08-14
 **/
public interface UpgradeInf {
    UpgradeOutput upgrade(UpgradeInput input);
}
