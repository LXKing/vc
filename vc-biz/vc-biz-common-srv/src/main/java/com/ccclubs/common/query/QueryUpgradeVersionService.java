package com.ccclubs.common.query;

import com.ccclubs.pub.orm.mapper.VerSoftHardwareMapper;
import com.ccclubs.pub.orm.mapper.VerUpgradeMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.VerSoftHardware;
import com.ccclubs.pub.orm.model.VerUpgrade;
import com.ccclubs.pub.orm.model.VerUpgradeExample;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: yeanzi
 * @Date: 2018/5/29
 * @Time: 14:32
 * Email:  yeanzhi@ccclubs.com
 * 车机升级版本查询
 */
@Component
public class QueryUpgradeVersionService {

    @Resource
    private VerUpgradeMapper verUpgradeMapper;

    @Resource
    private VerSoftHardwareMapper verSoftHardwareMapper;

    /**
     * 根据终端条件获取对应的升级版本信息
     * @param vehicleModel  车型
     * @param terType       终端类型
     * @param terModel      终端型号
     * @param isTurning     是否拐点
     * @return
     */
    public VerUpgrade getUpgradeVersion(int vehicleModel, byte terType, String terModel, boolean isTurning) {
        VerUpgradeExample example = new VerUpgradeExample();
        VerUpgradeExample.Criteria criteria = example.createCriteria();
        criteria.andTelTypeEqualTo((byte)terType);
        List<VerUpgrade> verUpgrades = verUpgradeMapper.selectByExample(example);
        if (Objects.nonNull(verUpgrades)) {
            return verUpgrades.get(0);
        }
        return null;
    }

    /**
     * 根据车机信息获取车机当前版本信息
     * @param csvModelId
     * @param terModel
     * @param terType
     * @param csMachine
     * @return
     */
    public VerUpgrade getCurrentUpgradeVersionInfo(Integer csvModelId, String terModel, Byte terType, CsMachine csMachine) {
        VerUpgradeExample currentQuery = new VerUpgradeExample();
        VerUpgradeExample.Criteria criterial = currentQuery.createCriteria();
        criterial.andModelIdEqualTo(csvModelId)
                .andTelModelEqualTo(terModel)
                .andTelTypeEqualTo(terType);
        List<VerUpgrade> csVerList = verUpgradeMapper.selectByExample(currentQuery);
        if (Objects.nonNull(csVerList) && csVerList.size() > 0) {
            csVerList = csVerList.stream().filter(up -> {
                VerSoftHardware currentPluginModel = verSoftHardwareMapper.selectByPrimaryKey(up.getSoftVerId());
                if (Objects.nonNull(currentPluginModel)) {
                    // 车机的插件版本相等则为相同升级版本
                    if (currentPluginModel.getVerNo().equals(String.valueOf(csMachine.getCsmTlV2()))) {
                        return true;
                    }
                }
                return false;
            }).collect(Collectors.toList());
            if (csVerList.size() > 0) {
                return csVerList.get(0);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


}
