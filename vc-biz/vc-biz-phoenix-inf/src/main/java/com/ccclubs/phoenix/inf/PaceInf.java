package com.ccclubs.phoenix.inf;


import com.ccclubs.phoenix.orm.model.Pace;
import com.ccclubs.phoenix.orm.model.PaceBlock;

import java.util.List;

public interface PaceInf {
    //添加驾驶阶段PaceBlock数据
     void addDrivePaceBlock(PaceBlock paceBlock);

    //添加充电阶段PaceBlock数据
     void addChargingPaceBlock(PaceBlock paceBlock);

     List<Pace> getPaceList();


}
