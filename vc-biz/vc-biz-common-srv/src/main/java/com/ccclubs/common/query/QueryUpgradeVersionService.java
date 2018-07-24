package com.ccclubs.common.query;

import com.ccclubs.pub.orm.model.VerUpgrade;
import com.ccclubs.pub.orm.model.VerUpgradeExample;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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

    /**
     * 根据终端条件获取对应的升级版本信息
     * @param vehicleModel  车型
     * @param terType       终端类型
     * @param terModel      终端型号
     * @param isTurning     是否拐点
     * @return
     */
    public VerUpgrade getUpgradeVersion(int vehicleModel, int terType, String terModel, boolean isTurning) {
        VerUpgradeExample example = new VerUpgradeExample();
        VerUpgradeExample.Criteria criteria = example.createCriteria();
        criteria.andTelTypeEqualTo(terType);
        List<VerUpgrade> verUpgrades = verUpgradeMapper.selectByExample(example);
        if (Objects.nonNull(verUpgrades)) {
            return verUpgrades.get(0);
        }
        return null;
    }


}
