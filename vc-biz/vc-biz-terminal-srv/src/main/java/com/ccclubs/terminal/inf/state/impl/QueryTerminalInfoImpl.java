package com.ccclubs.terminal.inf.state.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.common.validate.AuthValidateHelper;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.SrvHost;
import com.ccclubs.terminal.dto.*;
import com.ccclubs.terminal.inf.state.QueryTerminalInfoInf;
import com.ccclubs.terminal.version.TerminalServiceVersion;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * 终端信息查询实现
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
@Service(version = TerminalServiceVersion.V1)
public class QueryTerminalInfoImpl implements QueryTerminalInfoInf {

    @Autowired
    QueryVehicleService queryVehicleService;

    @Autowired
    QueryTerminalService queryTerminalService;

    @Autowired
    private TerminalProp terminalProp;
    @Resource
    QueryAppInfoService hostService;
    @Resource
    AuthValidateHelper authValidateHelper;

    @Override
    public TerminalQryOutput getTerminalInfo(TerminalQryInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        //根据vin码获取车辆信息
        CsVehicle csVehicle = queryVehicleService.queryVehicleByVin(input.getVin());
        // 未查询到车辆
        if (null == csVehicle) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }

        // 未查询到终端
        if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }
        //根据id获取车机信息
        CsMachine csMachine = queryTerminalService.queryCsMachineById(csVehicle.getCsvMachine());
        if (null == csMachine) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }

        TerminalQryOutput output = new TerminalQryOutput();
        switch (csMachine.getCsmTeType()) {
            case 0://富士康
            case 1://中导
            case 3://通领
                output.setSoftVersion(csMachine.getCsmTlV1());
                output.setHardVersion(csMachine.getCsmV2());
                output.setPluginVersion(
                        csMachine.getCsmTlV2() == null || 0 == csMachine.getCsmTlV2() ? ""
                                : csMachine.getCsmTlV2().toString());
                break;
            case 2://慧瀚
                break;
            default:
                break;
        }
        BeanUtils.copyProperties(csMachine, output);
        return output;
    }

    @Override
    public List<TerminalQryOutput> searchTerminalInfo(TerminalListQryInput input) {
        //根据appId获取
        SrvHost host = hostService.queryHostByAppid(input.getAppId());
        // 未查询到终端
        List<CsMachine> csMachineList = queryTerminalService.searchCsMachineFuzzyByTenoOrMobile(host.getShId(), input.getKey());
        if (null == csMachineList) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }

        List<TerminalQryOutput> listOutPut = new ArrayList<>();
        for (CsMachine csMachine : csMachineList) {
            //todo 未来会修改此表结构 cs_Machine
            TerminalQryOutput output = new TerminalQryOutput();
            switch (csMachine.getCsmTeType()) {
                case 0://富士康
                case 1://中导
                case 3://通领
                    output.setSoftVersion(csMachine.getCsmTlV1());
                    output.setHardVersion(csMachine.getCsmV2());
                    output.setPluginVersion(
                            csMachine.getCsmTlV2() == null || 0 == csMachine.getCsmTlV2() ? ""
                                    : csMachine.getCsmTlV2().toString());
                    break;
                case 2://慧瀚
                    break;
                default:
                    break;
            }
            BeanUtils.copyProperties(csMachine, output);
            listOutPut.add(output);
        }

        return listOutPut;
    }

    @Override
    public VersionQryOutput isLatestVersion(VersionQryInput input) {
        //根据vin码获取车辆信息
        CsVehicle csVehicle = queryVehicleService.queryVehicleByVin(input.getVin());

        // 未查询到车辆
        if (null == csVehicle) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }

        // 未查询到终端
        if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }
        //根据id查询车机信息
        CsMachine csMachine = queryTerminalService.queryCsMachineById(csVehicle.getCsvMachine());
        if (null == csMachine) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }

        VersionQryOutput output = new VersionQryOutput();

        //检查该车机插件的类型 TODO Csm_Te_Type字段应该非null
        if (null == csMachine.getCsmTeType()) {
            //未查询到该终端类型,当前支持终端类型:0:车厘子,1:中导,2:慧翰,3:通领
            throw new ApiException(ApiEnum.UNKNOWN_TERMINAL);
        }

        //该车机插件的最新版本
        String LV = terminalProp.getLatestVersionMap().get(csMachine.getCsmTeType().toString());
        if (null == LV) {
            throw new ApiException(ApiEnum.UNKNOWN_TERMINAL);
        }

        //当前仅支持通领车机的升级
//        if (csMachine.getCsmTeType() != QueryTerminalInfoInf.TL_TYPE) {
//            throw new ApiException(ApiEnum.TERMINAL_NOT_TL);
//        }

        //最新版本号
        String latest_version = LV.split(",")[0];
        String latest_filename = LV.split(",")[1];
        switch (csMachine.getCsmTeType()) {
            case 0://富士康
            case 1://中导
            case 3://通领
                makeOutput(latest_version, latest_filename, output, csMachine);
                break;
            case 2://慧瀚
                output.setTerminalType(csMachine.getCsmTeType());
                break;
            default:
                break;
        }

        return output;
    }

    private VersionQryOutput makeOutput(String latest_version, String latest_filename,
                                        VersionQryOutput output, CsMachine csMachine) {
        if (null == csMachine.getCsmTlV2()) {
            output.setLatest(false);
            output.setTerminalType(csMachine.getCsmTeType());
            output.setLatestV(latest_version);
            output.setFilename(latest_filename);
            output.setCurrentV("");
        } else {
            // TBOX当前插件版本比设定的目标版本大，则认为已是最新版本，不用升级
            if (csMachine.getCsmTlV2() >= Integer.parseInt(latest_version)) {
                output.setLatest(true);
                output.setTerminalType(csMachine.getCsmTeType());
                output.setLatestV(latest_version);
                output.setFilename(latest_filename);
                output.setCurrentV(csMachine.getCsmTlV2().toString());
            } else {
                output.setLatest(false);
                output.setTerminalType(csMachine.getCsmTeType());
                output.setLatestV(latest_version);
                output.setFilename(latest_filename);
                output.setCurrentV(csMachine.getCsmTlV2().toString());
            }
        }
        return output;
    }
}
