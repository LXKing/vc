package com.ccclubs.terminal.inf.state.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.CsVehicleExample;
import com.ccclubs.terminal.dto.TerminalQryInput;
import com.ccclubs.terminal.dto.TerminalQryOutput;
import com.ccclubs.terminal.dto.VersionQryInput;
import com.ccclubs.terminal.dto.VersionQryOutput;
import com.ccclubs.terminal.inf.state.QueryTerminalInfoInf;
import com.ccclubs.terminal.version.TerminalServiceVersion;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


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

  @Override
  @DataAuth
  public TerminalQryOutput getTerminalInfo(TerminalQryInput input) {
    CsVehicle csVehicle = queryVehicleService.queryVehicleByVin(input.getVin());
    // 未查询到车辆
    if (null == csVehicle) {
      throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
    }

    // 未查询到终端
    if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
      throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
    }
    CsMachine csMachine = queryTerminalService.queryCsMachineById(csVehicle.getCsvMachine());
    if (null == csMachine) {
      throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
    }

    //todo 未来会修改此表结构 cs_Machine
    TerminalQryOutput output = new TerminalQryOutput();
    switch (csMachine.getCsmTeType()) {
      case 0://富士康
        output.setSoftVersion(csMachine.getCsmV1() == null || "".equals(csMachine.getCsmV1()) ? ""
            : Integer.toString(Integer.parseInt(csMachine.getCsmV1().substring(4), 16)));
        output.setHardVersion(csMachine.getCsmV2());
        output.setPluginVersion(csMachine.getCsmV1() == null || "".equals(csMachine.getCsmV1()) ? ""
            : Integer.toString(Integer.parseInt(csMachine.getCsmV1().substring(4), 16)));
        break;
      case 1://中导
        output.setSoftVersion(csMachine.getCsmTlV1());
        output.setHardVersion(csMachine.getCsmV2());
        output.setPluginVersion(
            csMachine.getCsmTlV2() == null || "".equals(csMachine.getCsmTlV2()) ? ""
                : csMachine.getCsmTlV2().toString());
        break;
      case 2://慧瀚
        break;
      case 3://通领
        output.setSoftVersion(csMachine.getCsmTlV1());
        output.setHardVersion(csMachine.getCsmV2());
        output.setPluginVersion(
            csMachine.getCsmTlV2() == null || "".equals(csMachine.getCsmTlV2()) ? ""
                : csMachine.getCsmTlV2().toString());
        break;
    }
    BeanUtils.copyProperties(csMachine, output);
    return output;
  }

  @Override
  public VersionQryOutput isLatestVersion(VersionQryInput input) {
    CsVehicle csVehicle = queryVehicleService.queryVehicleByVin(input.getVin());

    // 未查询到车辆
    if (null == csVehicle) {
      throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
    }

    // 未查询到终端
    if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
      throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
    }
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
        makeFSKOutput(latest_version, latest_filename, output, csMachine);
        break;
      case 1://中导
        makeOutput(latest_version, latest_filename, output, csMachine);
        break;
      case 2://慧瀚
        output.setTerminalType(csMachine.getCsmTeType());
        break;
      case 3://通领
        makeOutput(latest_version, latest_filename, output, csMachine);
        break;
    }

    return output;
  }


  private VersionQryOutput makeFSKOutput(String latest_version, String latest_filename,
      VersionQryOutput output, CsMachine csMachine) {
    if (null == csMachine.getCsmV1()) {
      output.setLatest(false);
      output.setTerminalType(csMachine.getCsmTeType());
      output.setLatestV(latest_version);
      output.setFilename(latest_filename);
      output.setCurrentV("");
    } else {
      if (latest_version
          .equals(Integer.toString(Integer.parseInt(csMachine.getCsmV1().substring(4), 16)))) {
        output.setLatest(true);
        output.setTerminalType(csMachine.getCsmTeType());
        output.setLatestV(latest_version);
        output.setFilename(latest_filename);
        output
            .setCurrentV(Integer.toString(Integer.parseInt(csMachine.getCsmV1().substring(4), 16)));
      } else {
        output.setLatest(false);
        output.setTerminalType(csMachine.getCsmTeType());
        output.setLatestV(latest_version);
        output.setFilename(latest_filename);
        output
            .setCurrentV(Integer.toString(Integer.parseInt(csMachine.getCsmV1().substring(4), 16)));
      }
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
      if (latest_version.equals(csMachine.getCsmTlV2().toString())) {
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
