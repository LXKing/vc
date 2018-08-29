package com.ccclubs.command.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.command.dto.*;
import com.ccclubs.command.inf.air.AirConditionerCmdInf;
import com.ccclubs.command.inf.autopilot.AutopilotInf;
import com.ccclubs.command.inf.confirm.HttpConfirmResultInf;
import com.ccclubs.command.inf.lock.LockDoorInf;
import com.ccclubs.command.inf.old.DealRemoteCmdInf;
import com.ccclubs.command.inf.order.OrderCmdInf;
import com.ccclubs.command.inf.power.PowerModeSwitchInf;
import com.ccclubs.command.inf.simple.SendSimpleCmdInf;
import com.ccclubs.command.inf.time.TimeSyncCmdInf;
import com.ccclubs.command.inf.update.ReturnCheckInf;
import com.ccclubs.command.inf.update.SetDvdVersionInf;
import com.ccclubs.command.inf.update.TerminalUpgradeBase;
import com.ccclubs.command.inf.update.TerminalUpgradeInf;
import com.ccclubs.command.inf.tamper.TamperCmdInf;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.frm.spring.annotation.ApiSecurity;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.terminal.dto.VersionQryInput;
import com.ccclubs.terminal.dto.VersionQryOutput;
import com.ccclubs.terminal.inf.state.QueryTerminalInfoInf;
import com.ccclubs.terminal.inf.upgrade.UpgradeInf;
import io.swagger.annotations.ApiOperation;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 指令发送
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
@RefreshScope
@RequestMapping("command")
@RestController
public class CommandApi {

    private static final Logger logger = LoggerFactory.getLogger(CommandApi.class);

    @Reference(version = CommandServiceVersion.V1)
    TerminalUpgradeInf upgradeCmd;

    @Reference(version = CommandServiceVersion.V1)
    UpgradeInf upgradeInf;

    @Reference(version = CommandServiceVersion.V1)
    SendSimpleCmdInf simpleCmd;

    @Reference(version = CommandServiceVersion.V1)
    PowerModeSwitchInf powerModeSwitchCmd;

    @Reference(version = CommandServiceVersion.V1)
    TimeSyncCmdInf timeSyncCmd;

    @Reference(version = CommandServiceVersion.V1)
    AirConditionerCmdInf airCmd;

    @Reference(version = CommandServiceVersion.V1)
    OrderCmdInf orderCmd;

    @Reference(version = CommandServiceVersion.V1)
    QueryTerminalInfoInf versionInf;

    @Reference(version = CommandServiceVersion.V1)
    HttpConfirmResultInf httpConfirmInf;

    @Reference(version = CommandServiceVersion.V1)
    ReturnCheckInf returnCheckInf;

    @Reference(version = CommandServiceVersion.V1)
    SetDvdVersionInf setDvdVersionInf;

    @Reference(version = CommandServiceVersion.V1)
    LockDoorInf lockDoorInf;

    @Reference(version = CommandServiceVersion.V1)
    AutopilotInf autopilotInf;

    @Reference(version = CommandServiceVersion.V1)
    DealRemoteCmdInf dealRemoteCmdInf;

    @Reference(version = CommandServiceVersion.V1)
    TamperCmdInf tamperCmdInf;

    @Reference(version = CommandServiceVersion.V1)
    TerminalUpgradeBase terminalUpgradeBase;
    /**
     * 1.车机的一键升级功能
     */
    @ApiSecurity
    @ApiOperation(value = "一键升级", notes = "根据车辆vin码升级该车终端")
    @PostMapping("oneKeyUpgrade")
    public ApiMessage<UpgradeOutput> oneKeyUpgrade(@RequestHeader("appId") String appId,
                                                   UpgradeInput input) {
        logger.info("API事件:一键升级,APPID:{},车架号:{},升级程序包:{}", appId, input.getVin(),
                input.getFilename());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(), "终端升级");
        }
        VersionQryInput qryInput = new VersionQryInput();
        qryInput.setVin(input.getVin());
        VersionQryOutput version = versionInf.isLatestVersion(qryInput);
        if (!(version.getTerminalType() == 0 || version.getTerminalType() == 1
                || version.getTerminalType() == 3)) {
            //当前仅支持通领车机升级 TODO
            throw new ApiException(ApiEnum.TERMINAL_NOT_TL);
        }
        if (version.getLatest()) {
            throw new ApiException(ApiEnum.TERMINAL_VERSION_LATEST);
        }
        //最新版本文件名称
        input.setFilename(version.getFilename());
        UpgradeOutput output = upgradeCmd.oneKeyUpgrade(input);
        return new ApiMessage<>(output);
    }

    @ApiSecurity
    @ApiOperation(value = "通领二合一版本升级", notes = "通领二合一版本升级")
    @PostMapping("mixedUpgrade")
    public ApiMessage<UpgradeOutput> upgradeMixedVersion(@RequestHeader("appId") String appId,
                                                         VerUpgradeInput input) {
        logger.info("API事件:通领二合一版本升级,APPID:{},车架号:{},目标升级包id:{}", appId, input.getVin(),
                input.getUpgradeVerId());
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(), "终端升级");
        }

        // 构造升级条件
        MixedUpgradeInput upgradeTask = new MixedUpgradeInput();
        upgradeTask.setAppId(appId)
                .setVin(input.getVin())
                .setMixedUpVersionId(input.getUpgradeVerId());
        UpgradeOutput output = upgradeCmd.upgradeMixedVersionTask(upgradeTask);
        return new ApiMessage<>(output);
    }

    /**
     * 2.简单指令
     */
    @ApiSecurity
    @ApiOperation(value = "简单指令下发", notes = "传入车辆Vin码和指令类型，进行简单指令下发")
    @PostMapping("sendSimpleCmd")
    public ApiMessage<SimpleCmdOutput> sendSimpleCmd(@RequestHeader("appId") String appId,
                                                     SimpleCmdInput input) {
        logger.info("API事件:简单指令下发,APPID:{},车架号:{},指令:{}", appId, input.getVin(), input.getCmd());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(), input.getCmd());
        }
        SimpleCmdOutput output = simpleCmd.sendSimpleCmd(input);
        return new ApiMessage<>(output);
    }

    /**
     * 3.省电模式切换
     */
    @ApiSecurity
    @ApiOperation(value = "省电模式切换", notes = "省电模式切换")
    @PostMapping("powerModeSwitch")
    public ApiMessage<PowerModeOutput> powerModeSwitch(@RequestHeader("appId") String appId,
                                                       PowerModeInput input) {
        logger.info("API事件:省电模式切换,APPID:{},车架号:{},功耗模式:{},休眠秒数:{}", appId, input.getVin(),
                input.getType(), input.getSecond());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(),
                    "powerModeSwitch");
        }
        PowerModeOutput output = powerModeSwitchCmd.powerModeSwitch(input);
        return new ApiMessage<>(output);
    }

    /**
     * 4.终端校时
     */
    @ApiSecurity
    @ApiOperation(value = "终端校时", notes = "终端校时")
    @PostMapping("timeSynchronization")
    public ApiMessage<TimeSyncOutput> timeSynchronization(@RequestHeader("appId") String appId,
                                                          TimeSyncInput input) {
        logger.info("API事件:终端校时,APPID:{},车架号:{},校对时间:{}", appId, input.getVin(), input.getTime());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(),
                    "timeSynchronization");
        }
        TimeSyncOutput output = timeSyncCmd.timeSynchronization(input);
        return new ApiMessage<>(output);
    }

    /**
     * 5.1空调控制-单个控制
     */
    @ApiSecurity
    @ApiOperation(value = "空调控制-单个控制项", notes = "空调控制-单个控制项")
    @PostMapping("airConditionerMonoCtrl")
    public ApiMessage<AirMonoOutput> airConditionerMonoCtrl(@RequestHeader("appId") String appId,
                                                            AirMonoInput input) {
        logger.info("API事件:终端校时,APPID:{},车架号:{},控制项:{},控制项值:{}", appId, input.getVin(),
                input.getItem(), input.getValue());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(),
                    "airConditionerMonoCtrl");
        }
        AirMonoOutput output = airCmd.airConditionerMonoCtrl(input);
        return new ApiMessage<>(output);
    }

    /**
     * 5.2空调控制-全部控制
     */
    @ApiSecurity
    @ApiOperation(value = "空调控制-全部控制项", notes = "空调控制-全部控制项")
    @PostMapping("airConditionerAllCtrl")
    public ApiMessage<AirAllOutput> airConditionerAllCtrl(@RequestHeader("appId") String appId,
                                                          AirAllInput input) {
        logger.info("API事件:终端校时,APPID:{},车架号:{},内外循环模式:{},PTC启停:{},压缩机启停:{},风量:{}", appId,
                input.getVin(), input.getCircular(), input.getPtc(), input.getCompress(),
                input.getFan());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(),
                    "airConditionerAllCtrl");
        }
        AirAllOutput output = airCmd.airConditionerAllCtrl(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.1订单数据下发
     */
    @ApiSecurity
    @ApiOperation(value = "订单数据下发", notes = "订单数据下发")
    @PostMapping("issueOrderData")
    public ApiMessage<IssueOrderOutput> issueOrderData(@RequestHeader("appId") String appId,
                                                       IssueOrderInput input) {
        logger.info("API事件:终端校时,APPID:{},车架号:{},订单号:{},订单开始时间:{},订单结束时间:{},真实姓名:{},手机号:{},性别:{}",
                appId, input.getVin(), input.getOrderId(), input.getStartTime(), input.getEndTime(),
                input.getRealName(), input.getMobile(), input.getGender());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(), "issueOrderData");
        }
        IssueOrderOutput output = orderCmd.issueOrderData(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.2订单详细数据下发
     */
    //@ApiSecurity
    //@ApiOperation(value = "订单详细数据下发",notes = "订单详细数据下发")
    //@PostMapping("issueOrderDetailData")
    public ApiMessage<IssueOrderDetailOutput> issueOrderDetailData(
            @RequestHeader("appId") String appId, IssueOrderDetailInput input) {
        input.setAppId(appId);
        IssueOrderDetailOutput output = orderCmd.issueOrderDetailData(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.3订单续订
     */
    //@ApiSecurity
    //@ApiOperation(value = "订单续订",notes = "订单续订")
    //@PostMapping("renewOrder")
    public ApiMessage<RenewOrderOutput> renewOrder(@RequestHeader("appId") String appId,
                                                   RenewOrderInput input) {
        input.setAppId(appId);
        RenewOrderOutput output = orderCmd.renewOrder(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.4订单续订成功-应答
     */
    //@ApiSecurity
    //@ApiOperation(value = "订单续订成功-应答",notes = "订单续订成功-应答")
    //@PostMapping("renewOrderReplySuccess")
    public ApiMessage<RenewOrderReplySOutput> renewOrderReplySuccess(
            @RequestHeader("appId") String appId, RenewOrderReplySInput input) {
        input.setAppId(appId);
        RenewOrderReplySOutput output = orderCmd.renewOrderReplySuccess(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.5订单续订失败-应答
     */
    //@ApiSecurity
    //@ApiOperation(value = "订单续订失败-应答",notes = "订单续订失败-应答")
    //@PostMapping("renewOrderReplyFailed")
    public ApiMessage<RenewOrderReplyFOutput> renewOrderReplyFailed(
            @RequestHeader("appId") String appId, RenewOrderReplyFInput input) {
        input.setAppId(appId);
        RenewOrderReplyFOutput output = orderCmd.renewOrderReplyFailed(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.6下发订单数据--需要授权信息
     */
    @ApiSecurity
    @ApiOperation(value = "下发订单数据--需要授权信息", notes = "下发订单数据--需要授权信息")
    @PostMapping("issueAuthOrderData")
    public ApiMessage<IssueAuthOrderOutput> issueAuthOrderData(@RequestHeader("appId") String appId,
                                                               IssueAuthOrderInput input) {
        logger.info("API事件:终端校时,APPID:{},车架号:{},订单号:{},订单开始时间:{},订单结束时间:{},RFID号:{},授权码:{}", appId,
                input.getVin(), input.getOrderId(), input.getStartTime(), input.getEndTime(),
                input.getRfid(), input.getAuthCode());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(),
                    "issueAuthOrderData");
        }
        IssueAuthOrderOutput output = orderCmd.issueAuthOrderData(input);
        return new ApiMessage<>(output);
    }

    /**
     * 7.设置DVD车载APP最新版本
     */
    @ApiSecurity
    @ApiOperation(value = "设置DVD车载APP最新版本", notes = "设置DVD车载APP最新版本（仅设置版本号）")
    @PostMapping("setDvdVersion")
    public ApiMessage<DvdVersionOutput> setDvdVersion(@RequestHeader("appId") String appId,
                                                      DvdVersionIntput input) {
        logger.info("API事件:设置DVD车载APP最新版本,APPID:{},车架号:{},最新版本号:{}", appId, input.getVin(),
                input.getLatestVersion());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(), "setDvdVersion");
        }
        DvdVersionOutput output = setDvdVersionInf.setDvdVersion(input);
        return new ApiMessage<>(output);
    }

    /**
     * 8.设置还车检查-充电状态
     */
    @ApiSecurity
    @ApiOperation(value = "设置充电还车配置", notes = "配置还车时是否校验充电状态0：还车时，终端不校验车辆充电；1：还车时，终端需要校验车辆充电，不充电不允许还车。")
    @PostMapping("setReturn")
    public ApiMessage<ReturnCheckOutput> setReturn(@RequestHeader("appId") String appId,
                                                   ReturnCheckInput input) {
        logger.info("API事件:设置充电还车配置,APPID:{},车架号:{},充电检查配置项值:{}", appId, input.getVin(),
                input.getValue());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(), "setReturn");
        }
        ReturnCheckOutput output = returnCheckInf.setReturn(input);
        return new ApiMessage<>(output);
    }

    /**
     * 9.车门落锁-带控制参数
     */
    @ApiSecurity
    @ApiOperation(value = "车门落锁-带控制参数", notes = "车门落锁-带控制参数")
    @PostMapping("lockDoorWithCtrl")
    public ApiMessage<LockDoorOutput> lockDoorWithCtrl(@RequestHeader("appId") String appId,
                                                       LockDoorInput input) {
        logger.info("API事件:车门落锁-带控制参数,APPID:{},车架号:{},控制参数:{}", appId, input.getVin(),
                input.getCode());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(),
                    "lockDoorWithCtrl");
        }
        LockDoorOutput output = lockDoorInf.lockDoorWithCtrl(input);
        return new ApiMessage<>(output);
    }

    /**
     * 10.指令结果HTTP方式确认
     */
    @ApiSecurity
    @ApiOperation(value = "指令结果确认-HTTP方式", notes = "以HTTP方式确认指令执行结果")
    @PostMapping("confirm")
    public ApiMessage confirm(ConfirmInput input) {
        return new ApiMessage<>(httpConfirmInf.confirm(input));
    }


    /**
     * 11.语音指令下发
     */
    @ApiSecurity
    @ApiOperation(value = "语音指令下发", notes = "自动驾驶-下发语音编号指令")
    @PostMapping("voice")
    public ApiMessage voiceCommand(@RequestHeader("appId") String appId, VoiceIssuedInput input) {
        logger.info("API事件:语音指令下发,APPID:{},车架号:{},语音编号:{},语音类型:{}", appId, input.getVin(),
                input.getVoiceNum(), input.getVoiceType());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(), "voice");
        }
        VoiceIssuedOutput output = autopilotInf.voiceCommandComply(input);
        return new ApiMessage<>(output);

    }

    /**
     * 12.站点编号下发
     */
    @ApiSecurity
    @ApiOperation(value = "站点编号下发", notes = "自动驾驶-站点编号下发")
    @PostMapping("site")
    public ApiMessage siteCommand(@RequestHeader("appId") String appId, SiteIssuedInput input) {
        logger.info("API事件:站点编号下发,APPID:{},车架号:{},站点编号:{}", appId, input.getVin(),
                input.getSiteNum());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT, appId, input.getVin(), "site");
        }
        SiteIssuedOutput output = autopilotInf.siteCommandComply(input);
        return new ApiMessage<>(output);
    }

    /**
     * 13.远程指令
     */
    @PostMapping("dealRemoteCommend")
    public ApiMessage dealRemoteCommend(DealRemoteCmdInput input) {
        logger.info("API事件:远程指令下发,remoteId:{},指令值:{}", input.getRemoteId(), input.getStrJson());
        DealRemoteCmdOutput output = dealRemoteCmdInf.dealRemoteCommand(input);
        return new ApiMessage<>(output);
    }
    /**
     * 14.防拆控制指令
     *
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "防拆指令下发", notes = "防拆指令下发")
    @PostMapping("tamper")
    public ApiMessage tamperCommand(@RequestHeader("appId") String appId,TamperInput input) {
        logger.info("API事件:防拆指令下发，APPID:{},车架号:{},控制参数:{}", input.getAppId(), input.getVin(), input.getCode());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.AUTOPILOT_CTRL_ERROR);
        }
        TamperOutput output = tamperCmdInf.tamperCommandComply(input);
        return new ApiMessage<>(output);

    }
    @Autowired
    RedisTemplate redisTemplate;

    //当前正在处理指令的终端
    public static final String REDIS_KEY_NOW_CMD = "rates:";
    private static final long timeout = 10L;
    private static TimeUnit timeUnit = TimeUnit.SECONDS;

    private boolean isRateLimit(String vin) {

        ValueOperations ops = redisTemplate.opsForValue();
        String redisKey = REDIS_KEY_NOW_CMD + vin;
        Long current = ops.increment(redisKey, 1);
        if (1L == current) {
            redisTemplate.expire(redisKey, timeout, timeUnit);
            return false;
        } else {
            if (current > 5) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 根据文件名升级
     *
     * @param appId
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "根据文件名升级", notes = "根据车辆vin码和文件名称升级该车终端")
    @PostMapping("upgradeByFile")
    public ApiMessage upgradeByFileName(@RequestHeader("appId") String appId, UpgradeInput input) {
        logger.info("API事件:一键升级,APPID:{},车架号:{},升级程序包:{}", input.getAppId(), input.getVin(), input.getFilename());
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }
        terminalUpgradeBase.terminalUpgradeByFileName(input.getVin(), input.getFilename());
        return new ApiMessage<>();
    }
}
