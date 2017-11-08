package com.ccclubs.command.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.command.dto.*;
import com.ccclubs.command.inf.air.AirConditionerCmdInf;
import com.ccclubs.command.inf.confirm.HttpConfirmResultInf;
import com.ccclubs.command.inf.order.OrderCmdInf;
import com.ccclubs.command.inf.power.PowerModeSwitchInf;
import com.ccclubs.command.inf.simple.SendSimpleCmdInf;
import com.ccclubs.command.inf.time.TimeSyncCmdInf;
import com.ccclubs.command.inf.update.ReturnCheckInf;
import com.ccclubs.command.inf.update.SetDvdVersionInf;
import com.ccclubs.command.inf.update.TerminalUpgradeInf;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.frm.spring.annotation.ApiSecurity;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.terminal.dto.VersionQryInput;
import com.ccclubs.terminal.dto.VersionQryOutput;
import com.ccclubs.terminal.inf.state.QueryTerminalInfoInf;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Reference(version = CommandServiceVersion.V1)
    private TerminalUpgradeInf upgradeCmd;

    @Reference(version = CommandServiceVersion.V1)
    private SendSimpleCmdInf simpleCmd;

    @Reference(version = CommandServiceVersion.V1)
    private PowerModeSwitchInf powerModeSwitchCmd;

    @Reference(version = CommandServiceVersion.V1)
    private TimeSyncCmdInf timeSyncCmd;

    @Reference(version = CommandServiceVersion.V1)
    private AirConditionerCmdInf airCmd;

    @Reference(version = CommandServiceVersion.V1)
    private OrderCmdInf orderCmd;

    @Reference(version = CommandServiceVersion.V1)
    private QueryTerminalInfoInf versionInf;

    @Reference(version = CommandServiceVersion.V1)
    private HttpConfirmResultInf httpConfirmInf;

    @Reference(version = CommandServiceVersion.V1)
    private ReturnCheckInf returnCheckInf;

    @Reference(version = CommandServiceVersion.V1)
    private SetDvdVersionInf setDvdVersionInf;

    /**
     * 1.车机的一键升级功能
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "一键升级", notes = "根据车辆vin码升级该车终端")
    @PostMapping("oneKeyUpgrade")
    public ApiMessage<UpgradeOutput> oneKeyUpgrade(@RequestHeader("appId") String appId, UpgradeInput input) {
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }
        VersionQryInput qryInput = new VersionQryInput();
        qryInput.setVin(input.getVin());
        VersionQryOutput version = versionInf.isLatestVersion(qryInput);
        if (version.getTerminalType() != 0 ||version.getTerminalType() != 1 ||version.getTerminalType() != 3) {
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

    /**
     * 2.简单指令
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "简单指令下发", notes = "传入车辆Vin码和指令类型，进行简单指令下发")
    @PostMapping("sendSimpleCmd")
    public ApiMessage<SimpleCmdOutput> sendSimpleCmd(@RequestHeader("appId") String appId, SimpleCmdInput input) {
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }
        SimpleCmdOutput output = simpleCmd.sendSimpleCmd(input);
        return new ApiMessage<>(output);
    }

    /**
     * 3.省电模式切换
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "省电模式切换", notes = "省电模式切换")
    @PostMapping("powerModeSwitch")
    public ApiMessage<PowerModeOutput> powerModeSwitch(@RequestHeader("appId") String appId, PowerModeInput input) {
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }
        PowerModeOutput output = powerModeSwitchCmd.powerModeSwitch(input);
        return new ApiMessage<>(output);
    }

    /**
     * 4.终端校时
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "终端校时", notes = "终端校时")
    @PostMapping("timeSynchronization")
    public ApiMessage<TimeSyncOutput> timeSynchronization(@RequestHeader("appId") String appId, TimeSyncInput input) {
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }
        TimeSyncOutput output = timeSyncCmd.timeSynchronization(input);
        return new ApiMessage<>(output);
    }

    /**
     * 5.1空调控制-单个控制
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "空调控制-单个控制项", notes = "空调控制-单个控制项")
    @PostMapping("airConditionerMonoCtrl")
    public ApiMessage<AirMonoOutput> airConditionerMonoCtrl(@RequestHeader("appId") String appId, AirMonoInput input) {
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }
        AirMonoOutput output = airCmd.airConditionerMonoCtrl(input);
        return new ApiMessage<>(output);
    }

    /**
     * 5.2空调控制-全部控制
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "空调控制-全部控制项", notes = "空调控制-全部控制项")
    @PostMapping("airConditionerAllCtrl")
    public ApiMessage<AirAllOutput> airConditionerAllCtrl(@RequestHeader("appId") String appId, AirAllInput input) {
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }
        AirAllOutput output = airCmd.airConditionerAllCtrl(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.1订单数据下发
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "订单数据下发", notes = "订单数据下发")
    @PostMapping("issueOrderData")
    public ApiMessage<IssueOrderOutput> issueOrderData(@RequestHeader("appId") String appId, IssueOrderInput input) {
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }
        IssueOrderOutput output = orderCmd.issueOrderData(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.2订单详细数据下发
     *
     * @param input
     * @return
     */
    //@ApiSecurity
    //@ApiOperation(value = "订单详细数据下发",notes = "订单详细数据下发")
    //@PostMapping("issueOrderDetailData")
    public ApiMessage<IssueOrderDetailOutput> issueOrderDetailData(@RequestHeader("appId") String appId, IssueOrderDetailInput input) {
        input.setAppId(appId);
        IssueOrderDetailOutput output = orderCmd.issueOrderDetailData(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.3订单续订
     *
     * @param input
     * @return
     */
    //@ApiSecurity
    //@ApiOperation(value = "订单续订",notes = "订单续订")
    //@PostMapping("renewOrder")
    public ApiMessage<RenewOrderOutput> renewOrder(@RequestHeader("appId") String appId, RenewOrderInput input) {
        input.setAppId(appId);
        RenewOrderOutput output = orderCmd.renewOrder(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.4订单续订成功-应答
     *
     * @param input
     * @return
     */
    //@ApiSecurity
    //@ApiOperation(value = "订单续订成功-应答",notes = "订单续订成功-应答")
    //@PostMapping("renewOrderReplySuccess")
    public ApiMessage<RenewOrderReplySOutput> renewOrderReplySuccess(@RequestHeader("appId") String appId, RenewOrderReplySInput input) {
        input.setAppId(appId);
        RenewOrderReplySOutput output = orderCmd.renewOrderReplySuccess(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.5订单续订失败-应答
     *
     * @param input
     * @return
     */
    //@ApiSecurity
    //@ApiOperation(value = "订单续订失败-应答",notes = "订单续订失败-应答")
    //@PostMapping("renewOrderReplyFailed")
    public ApiMessage<RenewOrderReplyFOutput> renewOrderReplyFailed(@RequestHeader("appId") String appId, RenewOrderReplyFInput input) {
        input.setAppId(appId);
        RenewOrderReplyFOutput output = orderCmd.renewOrderReplyFailed(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.6下发订单数据--需要授权信息
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "下发订单数据--需要授权信息", notes = "下发订单数据--需要授权信息")
    @PostMapping("issueAuthOrderData")
    public ApiMessage<IssueAuthOrderOutput> issueAuthOrderData(@RequestHeader("appId") String appId, IssueAuthOrderInput input) {
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }
        IssueAuthOrderOutput output = orderCmd.issueAuthOrderData(input);
        return new ApiMessage<>(output);
    }

    /**
     * 7.设置DVD车载APP最新版本
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "设置DVD车载APP最新版本", notes = "设置DVD车载APP最新版本（仅设置版本号）")
    @PostMapping("setDvdVersion")
    public ApiMessage<DvdVersionOutput> setDvdVersion(@RequestHeader("appId") String appId, DvdVersionIntput input) {
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }
        DvdVersionOutput output = setDvdVersionInf.setDvdVersion(input);
        return new ApiMessage<>(output);
    }

    /**
     * 8.设置还车检查-充电状态
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "设置充电还车配置", notes = "配置还车时是否校验充电状态0：还车时，终端不校验车辆充电；1：还车时，终端需要校验车辆充电，不充电不允许还车。")
    @PostMapping("setReturn")
    public ApiMessage<ReturnCheckOutput> setReturn(@RequestHeader("appId") String appId, ReturnCheckInput input) {
        input.setAppId(appId);
        if (isRateLimit(input.getVin())) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }
        ReturnCheckOutput output = returnCheckInf.setReturn(input);
        return new ApiMessage<>(output);
    }

    /**
     * 9.指令结果HTTP方式确认
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "指令结果确认-HTTP方式", notes = "以HTTP方式确认指令执行结果")
    @PostMapping("confirm")
    public ApiMessage confirm(ConfirmInput input) {
        return new ApiMessage<>(httpConfirmInf.confirm(input));
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
            redisTemplate.expire(redisKey,timeout,timeUnit);
            return false;
        } else {
            if (current > 5) {
                return true;
            } else {
                return false;
            }
        }
    }
}
