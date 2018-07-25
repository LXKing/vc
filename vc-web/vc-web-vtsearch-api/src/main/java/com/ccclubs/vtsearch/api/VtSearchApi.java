package com.ccclubs.vtsearch.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.annotation.ApiSecurity;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.terminal.dto.*;
import com.ccclubs.terminal.inf.state.QueryTerminalInfoInf;
import com.ccclubs.terminal.inf.state.QueryVehicleStateInf;
import com.ccclubs.terminal.inf.upgrade.UpgradeInf;
import com.ccclubs.terminal.version.TerminalServiceVersion;
import com.ccclubs.vehicle.dto.CarLifeInput;
import com.ccclubs.vehicle.dto.CarLifeOutput;
import com.ccclubs.vehicle.dto.VehicleBaseInput;
import com.ccclubs.vehicle.dto.VehicleBaseOutput;
import com.ccclubs.vehicle.inf.base.QueryVehicleBaseInf;
import com.ccclubs.vehicle.inf.binding.BindHistoryInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 车机、车辆查询API
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
@RefreshScope
@RequestMapping("search")
@RestController
public class VtSearchApi {

    @Reference(version = VehicleServiceVersion.V1)
    private QueryVehicleBaseInf queryVehicleBaseInf;

    @Reference(version = VehicleServiceVersion.V1)
    private QueryTerminalInfoInf queryTerminalInfoInf;

    @Reference(version = VehicleServiceVersion.V1)
    private QueryVehicleStateInf queryVehicleStateInf;

    @Reference(version = VehicleServiceVersion.V1)
    private BindHistoryInf bindHistoryInf;

    @Reference(version = TerminalServiceVersion.V1)
    private UpgradeInf upgradeInf;

    /**
     * 1.获取车辆出厂日期及车辆的颜色
     *
     * @param input
     * @return
     */
    //@ApiSecurity
    //@ApiOperation(value="获取车辆出厂日期及车辆的颜色", notes="通过VIN码查询车辆出厂日期及车辆的颜色")
    //@PostMapping("getProdDateAndCarColor")
    public ApiMessage<VehicleBaseOutput> getProdDateAndCarColor(VehicleBaseInput input) {
        VehicleBaseOutput output = queryVehicleBaseInf.getProdDateAndCarColor(input);
        return new ApiMessage<>(output);
    }

    /**
     * 2.判断是否最新版本
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "判断终端是否是最新版本", notes = "通过VIN码查询车辆终端是否是最新版本")
    @PostMapping("isLatestVersion")
    public ApiMessage<VersionQryOutput> isLatestVersion(@RequestHeader("appId") String appId, VersionQryInput input) {
        input.setAppId(appId);
        VersionQryOutput output = queryTerminalInfoInf.isLatestVersion(input);
        return new ApiMessage<>(output);
    }

    /**
     * 3.状态信息的实时读取
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "车辆状态信息的实时读取", notes = "通过VIN码查询车辆的实时状态信息")
    @PostMapping("getRealTimeCarState")
    public ApiMessage<VehicleStateQryOutput> getRealTimeCarState(@RequestHeader("appId") String appId, VehicleStateQryInput input) {
        input.setAppId(appId);
        VehicleStateQryOutput output = queryVehicleStateInf.getRealTimeCarState(input);
        return new ApiMessage<>(output);
    }


    /**
     * 4.状态信息的实时读取
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "终端信息获取", notes = "通过VIN码查询车辆的终端信息")
    @PostMapping("getTerminalInfo")
    public ApiMessage<TerminalQryOutput> getTerminalInfo(@RequestHeader("appId") String appId, TerminalQryInput input) {
        input.setAppId(appId);
        TerminalQryOutput output = queryTerminalInfoInf.getTerminalInfo(input);
        return new ApiMessage<>(output);
    }


    @ApiSecurity
    @ApiOperation(value = "终端信息获取", notes = "通过序列号获取终端信息，需要不小于4位长度")
    @PostMapping("searchTerminalInfo")
    public ApiMessage<List<TerminalQryOutput>> searchTerminalInfo(@RequestHeader("appId") String appId, TerminalListQryInput input) {
        input.setAppId(appId);
        List<TerminalQryOutput> output = queryTerminalInfoInf.searchTerminalInfo(input);
        return new ApiMessage<>(output);
    }

    /**
     * 6.状态信息批量实时读取
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "车辆状态信息的实时读取（长安智行）", notes = "通过VIN码查询车辆的实时状态信息")
    @PostMapping("getRealTimeCarStates")
    public ApiMessage<VehicleStatesQryOutput> getRealTimeCarStates(@RequestHeader("appId") String appId, VehicleStatesQryInput input) {
        input.setAppId(appId);
        VehicleStatesQryOutput output = queryVehicleStateInf.getRealTimeCarStates(input);
        return new ApiMessage<>(output);
    }

    /**
     * 车辆在线状态判断
     *
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "车辆在线状态判断", notes = "根据Vin判断车辆在线状态")
    @PostMapping("isOnline")
    public ApiMessage<VehicleOnlineOutput> isOnline(@RequestHeader("appId") String appId, VehicleOnlineInput input) {
        input.setAppId(appId);
        VehicleOnlineOutput output = queryVehicleStateInf.isOnline(input);
        return new ApiMessage<>(output);
    }

    /**
     * 车辆绑定车机生命周期获取
     *
     * @param appId
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "车辆绑定车机生命周期获取", notes = "通过车架号获取车机生命周期信息")
    @PostMapping("searchCarLifeInfo")
    public ApiMessage<List<CarLifeOutput>> searchCarLifeInfo(@RequestHeader("appId") String appId, CarLifeInput input) {
        input.setAppId(appId);
        List<CarLifeOutput> output = bindHistoryInf.getBindHistoryByVin(input);
        return new ApiMessage<>(output);
    }

    /**
     * 获取终端可升级的版本列表
     *
     * @param appId
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "获取终端可升级的版本列表", notes = "获取终端可升级的版本列表")
    @PostMapping("getAbleUpgradeList")
    public ApiMessage<List<AbleUpgradeOutput>> getAbleUpgradeList(@RequestHeader("appId") String appId, AbleUpgradeInput input) {
        input.setAppId(appId);
        List<AbleUpgradeOutput> output = upgradeInf.getAbleUpgradeList(input);
        return new ApiMessage<>(output);
    }

    /**
     * 获取终端版本升级进度
     *
     * @param appId
     * @param input
     * @return
     */
    @ApiSecurity
    @ApiOperation(value = "获取终端版本升级进度", notes = "获取终端版本升级进度")
    @PostMapping("getTboxVersionInfo")
    public ApiMessage<TboxVersionOutput> getTboxVersionInfo(@RequestHeader("appId") String appId, TboxVersionInput input) {
        input.setAppId(appId);
        TboxVersionOutput output = upgradeInf.getTboxVersionInfo(input);
        return new ApiMessage<>(output);
    }
}
