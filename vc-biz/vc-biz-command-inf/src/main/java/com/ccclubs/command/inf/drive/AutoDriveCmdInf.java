package com.ccclubs.command.inf.drive;

import com.ccclubs.command.dto.GpsAutoDriveInput;
import com.ccclubs.command.dto.GpsAutoDriveOutput;

/**
 * @Author: yeanzi
 * @Date: 2018/9/20
 * @Time: 10:53
 * Email:  yeanzhi@ccclubs.com
 */
public interface AutoDriveCmdInf {

    /**
     * GPS自动驾驶
     * @param input
     * @return
     */
    GpsAutoDriveOutput gpsAutoDriveCtrl(GpsAutoDriveInput input);
}
