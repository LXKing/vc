package com.ccclubs.upgrade.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.annotation.ApiSecurity;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.terminal.dto.VersionQryInput;
import com.ccclubs.terminal.dto.VersionQryOutput;
import com.ccclubs.terminal.inf.state.QueryTerminalInfoInf;
import com.ccclubs.terminal.version.TerminalServiceVersion;
import com.ccclubs.upgrade.dto.UpgradeInput;
import com.ccclubs.upgrade.dto.UpgradeOutput;
import com.ccclubs.upgrade.inf.UpgradeInf;
import com.ccclubs.upgrade.util.UpgradeServiceVersion;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 升级服务
 *
 * @author jianghaiyang
 * @create 2017-08-16
 **/
@RefreshScope
@RestController
public class UpgradeApi {

    @Reference(version = UpgradeServiceVersion.V1)
    UpgradeInf upgradeInf;

    @Reference(version = TerminalServiceVersion.V1)
    QueryTerminalInfoInf versionInf;

    @ApiSecurity
    @PostMapping("upgrade")
    public ApiMessage upgrade(@RequestHeader("appId") String appId, UpgradeInput input) {
        input.setAppId(appId);
        VersionQryInput qryInput = new VersionQryInput();
        qryInput.setVin(input.getVin());

        VersionQryOutput version = versionInf.isLatestVersion(qryInput);

        if (version.getLatest()) {
            throw new ApiException(ApiEnum.TERMINAL_VERSION_LATEST);
        }

        //最新版本文件名称
        input.setFilename(version.getFilename());
        UpgradeOutput output = upgradeInf.upgrade(input);
        return new ApiMessage<>(output);
    }

}
