package com.ccclubs.command.util;

import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryUpgradeFtpServerService;
import com.ccclubs.common.query.QueryUpgradeVersionService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.VerFtpSer;
import com.ccclubs.pub.orm.model.VerUpgrade;
import com.ccclubs.upgrade.dto.FtpServer;
import com.ccclubs.upgrade.dto.UpgradeVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: yeanzi
 * @Date: 2018/5/29
 * @Time: 11:30
 * Email:  yeanzhi@ccclubs.com
 * 版本升级
 */
@Component
public class UpgradeHelper {

    @Autowired
    QueryVehicleService queryVehicleService;

    @Autowired
    QueryTerminalService queryTerminalService;

    @Autowired
    private QueryUpgradeVersionService queryUpgradeVersionService;

    @Autowired
    private QueryUpgradeFtpServerService queryUpgradeFtpServerService;

    public UpgradeVersion getTurningVer(CsVehicle csVehicle, CsMachine csMachine) {
        // 获取拐点版本信息
        VerUpgrade upgradeInfo = queryUpgradeVersionService.getUpgradeVersion(csVehicle.getCsvModel(), csMachine.getCsmTeType(), csMachine.getCsmTeModel(), true);
        // 获取ftp服务器信息
        VerFtpSer verFtpSer = queryUpgradeFtpServerService.getById(upgradeInfo.getSerFtpId());
        FtpServer ftpServer = new FtpServer();
        if (0 == verFtpSer.getType()) {
            // ftp服务器
            ftpServer.setSerHost(verFtpSer.getUrl())
                    .setSerPort(String.valueOf(verFtpSer.getPort()))
                    .setSerUsername(verFtpSer.getSerUsername())
                    .setSerPwd(verFtpSer.getSerPwd());
        } else if (1 == verFtpSer.getType()) {
            // http服务器
            ftpServer.setSerHost(verFtpSer.getUrl());
        }
        UpgradeVersion turningVer = new UpgradeVersion();
        turningVer.setBluetoothFileName("")
                .setMajorFileName("")
                .setPluginFileName("")

                .setPluginVer(upgradeInfo.getSoftVerId())
                .setMajorVer(upgradeInfo.getHardVerId())
                .setFtpServer(ftpServer);
        return turningVer;
    }

}
