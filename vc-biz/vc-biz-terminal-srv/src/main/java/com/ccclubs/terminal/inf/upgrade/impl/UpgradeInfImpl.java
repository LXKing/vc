package com.ccclubs.terminal.inf.upgrade.impl;

import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.frm.spring.util.BeanMapper;
import com.ccclubs.pub.orm.mapper.VerSoftHardwareMapper;
import com.ccclubs.pub.orm.mapper.VerTboxMapper;
import com.ccclubs.pub.orm.mapper.VerUpgradeMapper;
import com.ccclubs.pub.orm.mapper.VerUpgradeRecordMapper;
import com.ccclubs.pub.orm.model.*;
import com.ccclubs.terminal.constant.UpgradeStatus;
import com.ccclubs.terminal.dto.AbleUpgradeInput;
import com.ccclubs.terminal.dto.AbleUpgradeOutput;
import com.ccclubs.terminal.dto.TboxVersionInput;
import com.ccclubs.terminal.dto.TboxVersionOutput;
import com.ccclubs.terminal.inf.upgrade.UpgradeInf;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 终端升级相关查询接口
 *
 * @author jianghaiyang
 * @create 2018-07-24
 **/
public class UpgradeInfImpl implements UpgradeInf {

    @Autowired
    QueryVehicleService queryVehicleService;

    @Autowired
    QueryTerminalService queryTerminalService;

    @Resource
    VerUpgradeMapper verUpgradeMapper;

    @Resource
    VerUpgradeRecordMapper verUpgradeRecordMapper;

    @Resource
    VerTboxMapper verTboxMapper;

    @Resource
    VerSoftHardwareMapper verSoftHardwareMapper;

    /**
     * 获取终端可升级的版本列表
     *
     * @param input
     * @return
     */
    @Override
    public List<AbleUpgradeOutput> getAbleUpgradeList(AbleUpgradeInput input) {
        CsVehicle csVehicle = queryVehicleService.queryVehicleByVinFromCache(input.getVin());
        if (csVehicle == null) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }
        CsMachine csMachine = queryTerminalService.queryCsMachineByIdFromCache(csVehicle.getCsvMachine());
        if (csMachine == null) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }
        VerUpgradeExample example = new VerUpgradeExample();
        VerUpgradeExample.Criteria criteria = example.createCriteria();
        criteria.andModelIdEqualTo(csVehicle.getCsvModel());
        criteria.andTelModelEqualTo(csMachine.getCsmTeModel());
        criteria.andTelTypeEqualTo(csMachine.getCsmTeType());
        List<VerUpgrade> list = verUpgradeMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return new ArrayList<>();
        }
        List<AbleUpgradeOutput> output = BeanMapper.mapList(list, AbleUpgradeOutput.class);
        return output;
    }

    /**
     * 获取终端版本升级进度
     *
     * @param input
     * @return
     */
    @Override
    public TboxVersionOutput getTboxVersionInfo(TboxVersionInput input) {
        CsVehicle csVehicle = queryVehicleService.queryVehicleByVinFromCache(input.getVin());
        if (csVehicle == null) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }
        CsMachine csMachine = queryTerminalService.queryCsMachineByIdFromCache(csVehicle.getCsvMachine());
        if (csMachine == null) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }

        //查询该终端对应的升级记录
        VerUpgradeRecordExample example = new VerUpgradeRecordExample();
        VerUpgradeRecordExample.Criteria criteria = example.createCriteria();
        criteria.andTeNumberEqualTo(csMachine.getCsmNumber());
        example.setOrderByClause("id desc");
        List<VerUpgradeRecord> verUpgradeRecordList = verUpgradeRecordMapper.selectByExample(example);

        //查询该终端对应的升级包
        VerUpgradeExample verUpgradeExample = new VerUpgradeExample();
        VerUpgradeExample.Criteria verUpgradeCriteria = verUpgradeExample.createCriteria();
        verUpgradeCriteria.andModelIdEqualTo(csVehicle.getCsvModel());
        verUpgradeCriteria.andTelModelEqualTo(csMachine.getCsmTeModel());
        verUpgradeCriteria.andTelTypeEqualTo(csMachine.getCsmTeType());
        verUpgradeExample.setOrderByClause("id desc");
        List<VerUpgrade> verUpgradeList = verUpgradeMapper.selectByExample(verUpgradeExample);

        TboxVersionOutput output = new TboxVersionOutput();
        Integer currentPluginV = csMachine.getCsmTlV2();

        //未查询到该终端对应的版本包，提示需要到车机中心注册该版本包信息[ver_upgrade]
        if (verUpgradeList == null || verUpgradeList.size() == 0) {
            throw new ApiException(ApiEnum.FAIL, "系统未查询到该车机安装的版本包信息，请联系管理员录入");
        } else {
            //得到最新的版本包
            VerUpgrade verUpgrade = verUpgradeList.get(0);
            output.setLatestV(getLatestPluginV(verUpgrade));
        }

        //未查询到升级记录，默认已升级
        if (verUpgradeRecordList == null || verUpgradeRecordList.size() == 0) {

            output.setCurrentV(String.valueOf(currentPluginV));
        } else {
            //最新的升级记录
            VerUpgradeRecord verUpgradeRecord = verUpgradeRecordList.get(0);
            UpgradeStatus status = UpgradeStatus.getStatus(verUpgradeRecord.getStatus());
            output.setStatus(status.getValue());
            output.setStatusText(status.getName());
        }
        return output;
    }

    /**
     * 通过最新的版本包得到最新的插件版本
     *
     * @param verUpgrade 最新的版本包
     * @return 最新的插件版本
     */
    private String getLatestPluginV(VerUpgrade verUpgrade) {
        VerSoftHardware verSoftHardware = verSoftHardwareMapper.selectByPrimaryKey(verUpgrade.getSoftVerId());
        if (verSoftHardware == null) {
            throw new ApiException(ApiEnum.FAIL, "系统未查询到该车机安装的插件版本信息，请联系管理员录入");
        }
        return verSoftHardware.getVerNo();
    }
}
