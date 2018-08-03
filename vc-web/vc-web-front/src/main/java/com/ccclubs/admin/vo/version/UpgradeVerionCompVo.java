package com.ccclubs.admin.vo.version;

import com.ccclubs.admin.model.VerModuleRelation;

import java.util.List;

/**
 * @Author: yeanzi
 * @Date: 2018/4/19
 * @Time: 10:21
 * Email:  yeanzhi@ccclubs.com
 * 车机升级版本对比信息VO
 */
public class UpgradeVerionCompVo {

    // 硬件模块
    private List<VerModuleRelation> hardModuleVals;
    // 软件模块
    private List<VerModuleRelation> softModuleVals;

}
