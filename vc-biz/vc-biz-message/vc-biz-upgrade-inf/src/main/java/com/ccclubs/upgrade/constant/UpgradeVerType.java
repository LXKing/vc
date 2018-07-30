package com.ccclubs.upgrade.constant;

import com.ccclubs.upgrade.dto.FtpServer;
import com.ccclubs.upgrade.dto.UpgradeVersion;

/**
 * @Author: yeanzi
 * @Date: 2018/5/23
 * @Time: 17:15
 * Email:  yeanzhi@ccclubs.com
 *  车机版本升级版本类型
 */
public enum UpgradeVerType {

    /**
     * 终端类型为通领的固定拐点版本
     */
    CCCLUB_BASIC_VER(0x131F,
            new UpgradeVersion()
                    .setPluginFileName("")
                    .setMajorFileName("")
                    .setBluetoothFileName("")
                    .setMajorVer(1)
                    .setPluginVer(2)
                    .setFtpServer(new FtpServer()
                            .setSerHost("")
                            .setSerPort("")
                            .setSerUsername("")
                            .setSerPwd("")
                    )
    ),

    /**
     * 中岛拐点版本，该版本之前http升级，该版本之后ftp升级
     */
    ZD_TURNING_VER(0x2018, new UpgradeVersion().setPluginFileName(""));

    private int code;
    private UpgradeVersion version;
    UpgradeVerType(int code, UpgradeVersion version) {
        this.code = code;
        this.version = version;
    }


    public int getCode() {
        return code;
    }

    public UpgradeVersion getVersion() {
        return version;
    }
}
