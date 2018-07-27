package com.ccclubs.upgrade.srv.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.command.inf.update.TerminalUpgradeInf;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.terminal.dto.VersionQryInput;
import com.ccclubs.terminal.dto.VersionQryOutput;
import com.ccclubs.terminal.inf.state.QueryTerminalInfoInf;
import com.ccclubs.upgrade.dto.UpgradeInput;
import com.ccclubs.upgrade.dto.UpgradeOutput;
import com.ccclubs.upgrade.dto.UpgradeTask;
import com.ccclubs.upgrade.inf.UpgradeInf;
import com.ccclubs.upgrade.srv.util.UpgradeConstants;
import com.ccclubs.upgrade.util.UpgradeServiceVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 升级服务
 *
 * @author jianghaiyang
 * @create 2017-08-14
 **/
@Service(version = UpgradeServiceVersion.V1)
public class UpgradeService implements UpgradeInf {

    private static final Logger logger = LoggerFactory.getLogger(UpgradeService.class);

    @Autowired
    RedisTemplate redisTemplate;

    @Reference(version = CommandServiceVersion.V1)
    QueryTerminalInfoInf versionInf;

    @Reference(version = CommandServiceVersion.V1)
    TerminalUpgradeInf commandInf;

    @Override
    public UpgradeOutput upgrade(UpgradeInput input) {
        ListOperations ops = redisTemplate.opsForList();
        input.setReqInTime(System.currentTimeMillis());
        ops.leftPush(UpgradeConstants.REDIS_KEY_REQ_QUEUE, input);
        UpgradeOutput output = new UpgradeOutput();
        output.setVin(input.getVin());
        return output;
    }

    /**
     * 执行车机版本升级任务
     *
     * @param task
     */
    @Override
    public void doUpgradeTask(UpgradeTask task) {

    }

    public boolean isSuccess(String vin) {
        VersionQryInput input = new VersionQryInput();
        input.setVin(vin);
        return versionInf.isLatestVersion(input).getLatest();
    }

    public void upgradeCommand(String vin, String filename) {
        com.ccclubs.command.dto.UpgradeInput input = new com.ccclubs.command.dto.UpgradeInput();
        input.setVin(vin);
        input.setFilename(filename);
        logger.info("call command api oneKeyUpgrade >>> [vin:{}]", vin);
        commandInf.oneKeyUpgrade(input);
    }

    public void upgradeCron(String vin) {
        VersionQryInput qryInput = new VersionQryInput();
        qryInput.setVin(vin);
        VersionQryOutput version = versionInf.isLatestVersion(qryInput);

        if (version.getLatest()) {
            return;
        }
        UpgradeInput input = new UpgradeInput();
        input.setVin(vin);
        input.setFilename(version.getFilename());
        upgrade(input);
    }
}
