package com.ccclubs.vtsearch.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.annotation.ApiSecurity;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.terminal.dto.*;
import com.ccclubs.terminal.inf.state.QueryTerminalInfoInf;
import com.ccclubs.terminal.inf.state.QueryVehicleStateInf;
import com.ccclubs.vehicle.dto.VehicleBaseInput;
import com.ccclubs.vehicle.dto.VehicleBaseOutput;
import com.ccclubs.vehicle.inf.base.QueryVehicleBaseInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 机车查询API
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
    @ApiOperation(value="车辆状态信息的实时读取", notes="通过VIN码查询车辆的实时状态信息")
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
    @ApiOperation(value="终端信息获取", notes="通过VIN码查询车辆的终端信息")
    @PostMapping("getTerminalInfo")
    public ApiMessage<TerminalQryOutput> getTerminalInfo(@RequestHeader("appId") String appId, TerminalQryInput input) {
        input.setAppId(appId);
        TerminalQryOutput output = queryTerminalInfoInf.getTerminalInfo(input);
        return new ApiMessage<>(output);
    }


    @ApiSecurity
    @ApiOperation(value="终端信息获取", notes="通过序列号获取终端信息，需要不小于4位长度")
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
    @ApiOperation(value="车辆状态信息的实时读取（长安智行）", notes="通过VIN码查询车辆的实时状态信息")
    @PostMapping("getRealTimeCarStates")
    public ApiMessage<VehicleStatesQryOutput> getRealTimeCarStates(@RequestHeader("appId") String appId, VehicleStatesQryInput input) {
        input.setAppId(appId);
        VehicleStatesQryOutput output = queryVehicleStateInf.getRealTimeCarStates(input);
        return new ApiMessage<>(output);
    }

}
