/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.ccclubs.command.inf.update;

/**
 * @author zhaoyunxing92
 * @class: com.ccclubs.command.inf.update.TerminalUpgrade
 * @date: 2018-08-29 11:01
 * @des: 终端上级接口
 */
public interface TerminalUpgradeBase {
    /**
     * 根据文件名称升级程序
     *
     * @param appId    appId
     * @param vin      终端vin码
     * @param fileName 文件名称
     * @return
     */
    void terminalUpgradeByFileName(String appId, String vin, String fileName);
}
