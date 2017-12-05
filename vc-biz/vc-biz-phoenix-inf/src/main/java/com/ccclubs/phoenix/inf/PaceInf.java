package com.ccclubs.phoenix.inf;


import com.ccclubs.phoenix.orm.model.Pace;
import com.ccclubs.phoenix.orm.model.PaceBlock;

import java.util.List;

public interface PaceInf {
    //添加驾驶阶段PaceBlock数据
    public void addDrivePaceBlock(PaceBlock paceBlock);

    //添加充电阶段PaceBlock数据
    public void addChargingPaceBlock(PaceBlock paceBlock);

    public List<Pace> getPaceList();
}
