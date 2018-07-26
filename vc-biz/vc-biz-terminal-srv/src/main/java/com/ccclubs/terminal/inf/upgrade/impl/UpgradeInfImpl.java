package com.ccclubs.terminal.inf.upgrade.impl;

import com.alibaba.dubbo.config.annotation.Service;
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
import com.ccclubs.terminal.version.TerminalServiceVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 终端升级相关查询接口
 *
 * @author jianghaiyang
 * @create 2018-07-24
 **/
@Service(version = TerminalServiceVersion.V1)
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

    @Value("${upgrade.timeout}")
    Integer upgradeTimeout;

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
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }

        return BeanMapper.mapList(list, AbleUpgradeOutput.class);
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
        example.setOrderByClause("id desc limit 1");
        List<VerUpgradeRecord> verUpgradeRecordList = verUpgradeRecordMapper.selectByExample(example);

        //查询该终端对应的升级包
        VerUpgradeExample verUpgradeExample = new VerUpgradeExample();
        VerUpgradeExample.Criteria verUpgradeCriteria = verUpgradeExample.createCriteria();
        verUpgradeCriteria.andModelIdEqualTo(csVehicle.getCsvModel());
        verUpgradeCriteria.andTelModelEqualTo(csMachine.getCsmTeModel());
        verUpgradeCriteria.andTelTypeEqualTo(csMachine.getCsmTeType());
        verUpgradeExample.setOrderByClause("id desc limit 1");
        List<VerUpgrade> verUpgradeList = verUpgradeMapper.selectByExample(verUpgradeExample);

        TboxVersionOutput output = new TboxVersionOutput();
        //当前插件版本
        Integer currentPluginV = csMachine.getCsmTlV2();

        //未查询到该终端对应的版本包，提示需要到车机中心注册该版本包信息[ver_upgrade]
        if (verUpgradeList == null || verUpgradeList.isEmpty()) {
            throw new ApiException(ApiEnum.UPGRADE_VERSION_NOT_FOUND);
        } else {
            //得到最新的版本包
            VerUpgrade verUpgrade = verUpgradeList.get(0);
            output.setLatestV(getLatestPluginV(verUpgrade));
            output.setLatest(currentPluginV >= Integer.parseInt(output.getLatestV()));
        }

        //未查询到升级记录
        if (verUpgradeRecordList == null || verUpgradeRecordList.isEmpty()) {
            output.setCurrentV(String.valueOf(currentPluginV));
            //插件版本已最新，返回已升级；否则返回待升级
            if (output.getLatest()) {
                output.setStatus(UpgradeStatus.UPGRADED.getValue());
                output.setStatusText(UpgradeStatus.UPGRADED.getName());
            } else {
                output.setStatus(UpgradeStatus.TOUPGRADE.getValue());
                output.setStatusText(UpgradeStatus.TOUPGRADE.getName());
            }
        } else {
            //最新的升级记录
            VerUpgradeRecord verUpgradeRecord = verUpgradeRecordList.get(0);
            UpgradeStatus status = UpgradeStatus.getStatus(verUpgradeRecord.getStatus());
            output.setStatus(status.getValue());
            output.setStatusText(status.getName());
            //只有处于升级中的才显示进度、剩余时间
            if (UpgradeStatus.UPGRADING.getValue().equals(status.getValue())) {
                //已升级的时间
                Long passedTime = System.currentTimeMillis() - verUpgradeRecord.getAddTime().getTime();
                if (passedTime < upgradeTimeout) {
                    Long percent = (passedTime * 100) / (upgradeTimeout * 1000L);
                    Long leftTime = upgradeTimeout - upgradeTimeout * percent / 100;
                    output.setPercent(percent);
                    output.setLeftTime(leftTime);
                } else if (passedTime > upgradeTimeout * 2) {
                    //升级超过10min，认为失败
                    output.setStatus(UpgradeStatus.FAILED.getValue());
                    output.setStatusText(UpgradeStatus.FAILED.getName());
                    //更新record
                    VerUpgradeRecord verUpgradeRecordUpdate = new VerUpgradeRecord();
                    verUpgradeRecordUpdate.setId(verUpgradeRecord.getId());
                    verUpgradeRecordUpdate.setStatus(UpgradeStatus.FAILED.getValue());
                    updateUpgradeRecord(verUpgradeRecordUpdate);
                }
            }
        }
        return output;
    }

    /**
     * 通过最新的版本包得到最新的插件版本号
     *
     * @param verUpgrade 最新的版本包
     * @return 最新的插件版本
     */
    private String getLatestPluginV(VerUpgrade verUpgrade) {
        VerSoftHardware verSoftHardware = verSoftHardwareMapper.selectByPrimaryKey(verUpgrade.getSoftVerId());
        if (verSoftHardware == null) {
            throw new ApiException(ApiEnum.UPGRADE_PLUGIN_VERSION_NOT_FOUND);
        }
        return verSoftHardware.getVerNo();
    }

    private int updateUpgradeRecord(VerUpgradeRecord verUpgradeRecordUpdate) {
        VerUpgradeRecordExample example = new VerUpgradeRecordExample();
        VerUpgradeRecordExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(verUpgradeRecordUpdate.getId());
        return verUpgradeRecordMapper.updateByExampleSelective(verUpgradeRecordUpdate, example);
    }
}
