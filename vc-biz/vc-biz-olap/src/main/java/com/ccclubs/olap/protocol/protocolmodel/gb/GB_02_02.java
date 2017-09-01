package com.ccclubs.olap.protocol.protocolmodel.gb;

import java.util.ArrayList;
import java.util.List;

/**
 *   驱动电机数据
 */
public class GB_02_02 {

     //驱动电机个数；byte 有效值1～253
    private int driveMotorCount;
    //驱动电机总成信息列表，按驱动电机序号依次排列
    private List<GB_02_02_Item> driveMotorList=new ArrayList<GB_02_02_Item>();
//


    public int getDriveMotorCount() {
        return driveMotorCount;
    }

    public void setDriveMotorCount(int driveMotorCount) {
        this.driveMotorCount = driveMotorCount;
    }

    public List<GB_02_02_Item> getDriveMotorList() {
        return driveMotorList;
    }

    public void setDriveMotorList(List<GB_02_02_Item> driveMotorList) {
        this.driveMotorList = driveMotorList;
    }
}
