package com.ccclubs.olap.protocol.protocolmodel.gb;

import java.util.ArrayList;
import java.util.List;

/**
 * 报警数据
 */
public class GB_02_07 {


    //最高报警等级 : 为当前发生的故障中的最高等级值，有效值范围：0～3，“0”表示无故障；“1”表示1级故障，指代不影响车辆正常行驶的故障；“2”表示2级故障，指代影响车辆性能，需驾驶员限制行驶的故障；“3”表示3级故障，为最高级别故障
    // ，指代驾驶员应立即停车处理或请求救援的故障；具体等级对应的故障内容由厂商自行定义；“0xFE”表示异常，“0xFF”表示无效。
    private int highestAlarmLevel=-2;

    /**
     * 通用报警标志 : 通用报警标志位定义见表18。
     */
    private String generalAlarmFlag="";

    /**
     * 可充电储能装置故障总数N1 : N1个可充电储能装置故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
     */
    private int rechargeableStorageDeviceFailuresTotalCount=-2;

    /**
     * 扩展性数据，由厂商自行定义，可充电储能装置故障个数等于可充电储能装置故障总数N1
     */
    private List<String> rechargeableStorageDeviceFailuresCodeList=new ArrayList<String>();

    /**
     * 驱动电机故障总数N2 : N2个驱动电机故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
     */
    private int driveMotorFailureTotalCount=-2;

    /**
     * 驱动电机故障代码列表 : 厂商自行定义，驱动电机故障个数等于驱动电机故障总数N2。
     */
    private List<String> driveMotorFailuresCodeList=new ArrayList<String>();

    /**
     * 发动机故障总数N3 : N3个驱动电机故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
     */
    private int engineFailuresTotalCount=-2;

    /**
     * 发动机故障列表 : 厂商自行定义，发动机故障个数等于驱动电机故障总数N3
     */
    private List<String> engineFailuresCodeList=new ArrayList<String>();

    /**
     * 其他故障总数N4 : N4个其他故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
     */
    private int otherFailuresTotalCount=-2;

    /**
     * 其他故障代码列表 : 厂商自行定义，故障个数等于故障总数N4。
     */
    private List<String> otherFailuresCodeList=new ArrayList<String>();

//

    public int getHighestAlarmLevel() {
        return highestAlarmLevel;
    }

    public void setHighestAlarmLevel(int highestAlarmLevel) {
        this.highestAlarmLevel = highestAlarmLevel;
    }

    public String getGeneralAlarmFlag() {
        return generalAlarmFlag;
    }

    public void setGeneralAlarmFlag(String generalAlarmFlag) {
        this.generalAlarmFlag = generalAlarmFlag;
    }

    public int getRechargeableStorageDeviceFailuresTotalCount() {
        return rechargeableStorageDeviceFailuresTotalCount;
    }

    public void setRechargeableStorageDeviceFailuresTotalCount(int rechargeableStorageDeviceFailuresTotalCount) {
        this.rechargeableStorageDeviceFailuresTotalCount = rechargeableStorageDeviceFailuresTotalCount;
    }

    public List<String> getRechargeableStorageDeviceFailuresCodeList() {
        return rechargeableStorageDeviceFailuresCodeList;
    }

    public void setRechargeableStorageDeviceFailuresCodeList(List<String> rechargeableStorageDeviceFailuresCodeList) {
        this.rechargeableStorageDeviceFailuresCodeList = rechargeableStorageDeviceFailuresCodeList;
    }

    public int getDriveMotorFailureTotalCount() {
        return driveMotorFailureTotalCount;
    }

    public void setDriveMotorFailureTotalCount(int driveMotorFailureTotalCount) {
        this.driveMotorFailureTotalCount = driveMotorFailureTotalCount;
    }

    public List<String> getDriveMotorFailuresCodeList() {
        return driveMotorFailuresCodeList;
    }

    public void setDriveMotorFailuresCodeList(List<String> driveMotorFailuresCodeList) {
        this.driveMotorFailuresCodeList = driveMotorFailuresCodeList;
    }

    public int getEngineFailuresTotalCount() {
        return engineFailuresTotalCount;
    }

    public void setEngineFailuresTotalCount(int engineFailuresTotalCount) {
        this.engineFailuresTotalCount = engineFailuresTotalCount;
    }

    public List<String> getEngineFailuresCodeList() {
        return engineFailuresCodeList;
    }

    public void setEngineFailuresCodeList(List<String> engineFailuresCodeList) {
        this.engineFailuresCodeList = engineFailuresCodeList;
    }

    public int getOtherFailuresTotalCount() {
        return otherFailuresTotalCount;
    }

    public void setOtherFailuresTotalCount(int otherFailuresTotalCount) {
        this.otherFailuresTotalCount = otherFailuresTotalCount;
    }

    public List<String> getOtherFailuresCodeList() {
        return otherFailuresCodeList;
    }

    public void setOtherFailuresCodeList(List<String> otherFailuresCodeList) {
        this.otherFailuresCodeList = otherFailuresCodeList;
    }

    //



    public  int getHighestAlarmLevelString(int highestAlarmLevel) {
        switch (highestAlarmLevel) {
//            case 0x00:
//                return "无故障";
//            case 0x01:
//                return "1级故障";
//            case 0x02:
//                return "2级故障";
//            case 0x03:
//                return "最高级别故障";
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return highestAlarmLevel;
        }
    }

    public  int getTotalNumberString(int value) {
        switch (value) {
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return value;
        }
    }

    public   String getGeneralAlarmFlagString(int generalAlarmFlag){
        if(generalAlarmFlag==0){
            return "";
        }
        return "";
    }


//    public String getGeneralAlarmFlagString() {
//        //		return $.zerofill(Integer.toBinaryString(getGeneralAlarmFlag()), 32);
//        String alarmFlag = $.zerofill(Integer.toBinaryString(getGeneralAlarmFlag()), 32);
//        StringBuilder sBuilder = new StringBuilder();
//        sBuilder.append((Byte.parseByte(alarmFlag.substring(12, 13), 10) & 0x1) == 0 ? "正常" : "温度差异报警");
//        sBuilder.append(";");
//        sBuilder.append((Byte.parseByte(alarmFlag.substring(13, 14), 10) & 0x1) == 0 ? "正常" : "电池高温报警");
//        sBuilder.append(";");
//        sBuilder
//                .append((Byte.parseByte(alarmFlag.substring(14, 15), 10) & 0x1) == 0 ? "正常" : "车载储能装置类型过压报警");
//        sBuilder.append(";");
//        sBuilder
//                .append((Byte.parseByte(alarmFlag.substring(15, 16), 10) & 0x1) == 0 ? "正常" : "车载储能装置类型欠压报警");
//        sBuilder.append(";");
//        sBuilder.append((Byte.parseByte(alarmFlag.substring(16, 17), 10) & 0x1) == 0 ? "正常" : "SOC低报警");
//        sBuilder.append(";");
//        sBuilder.append((Byte.parseByte(alarmFlag.substring(17, 18), 10) & 0x1) == 0 ? "正常" : "单体电池过压报警");
//        sBuilder.append(";");
//        sBuilder.append((Byte.parseByte(alarmFlag.substring(18, 19), 10) & 0x1) == 0 ? "正常" : "单体电池欠压报警");
//        sBuilder.append(";");
//        sBuilder.append((Byte.parseByte(alarmFlag.substring(19, 20), 10) & 0x1) == 0 ? "正常" : "SOC过高报警");
//        sBuilder.append(";");
//        sBuilder.append((Byte.parseByte(alarmFlag.substring(20, 21), 10) & 0x1) == 0 ? "正常" : "SOC跳变报警");
//        sBuilder.append(";");
//        sBuilder.append(
//                (Byte.parseByte(alarmFlag.substring(21, 22), 10) & 0x1) == 0 ? "正常" : "可充电储能系统不匹配报警");
//        sBuilder.append(";");
//        sBuilder
//                .append((Byte.parseByte(alarmFlag.substring(22, 23), 10) & 0x1) == 0 ? "正常" : "电池单体一致性差报警");
//        sBuilder.append(";");
//        sBuilder.append((Byte.parseByte(alarmFlag.substring(23, 24), 10) & 0x1) == 0 ? "正常" : "绝缘报警");
//        sBuilder.append(";");
//        sBuilder
//                .append((Byte.parseByte(alarmFlag.substring(24, 25), 10) & 0x1) == 0 ? "正常" : "DC-DC温度报警");
//        sBuilder.append(";");
//        sBuilder.append((Byte.parseByte(alarmFlag.substring(25, 26), 10) & 0x1) == 0 ? "正常" : "制动系统报警");
//        sBuilder.append(";");
//        sBuilder
//                .append((Byte.parseByte(alarmFlag.substring(26, 27), 10) & 0x1) == 0 ? "正常" : "DC-DC状态报警");
//        sBuilder.append(";");
//        sBuilder.append(
//                (Byte.parseByte(alarmFlag.substring(27, 28), 10) & 0x1) == 0 ? "正常" : "驱动电机控制器温度报警");
//        sBuilder.append(";");
//        sBuilder
//                .append((Byte.parseByte(alarmFlag.substring(28, 29), 10) & 0x1) == 0 ? "正常" : "高压互锁状态报警");
//        sBuilder.append(";");
//        sBuilder
//                .append((Byte.parseByte(alarmFlag.substring(29, 30), 10) & 0x1) == 0 ? "正常" : "驱动电机温度报警");
//        sBuilder.append(";");
//        sBuilder
//                .append((Byte.parseByte(alarmFlag.substring(30, 31), 10) & 0x1) == 0 ? "正常" : "车载储能装置类型过充");
//        return sBuilder.toString();
//    }

    public  String getRechargeableEnergyStorageDeviceFailuresCodeListString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[");
//        if (getRechargeableStorageDeviceFailuresCodeList()!=null&&getRechargeableStorageDeviceFailuresCodeList().size() > 0) {
//            for (int i = 0, length = getRechargeableStorageDeviceFailuresCodeList().size(); i < length; i++) {
//                int item = getRechargeableStorageDeviceFailuresCodeList().get(i);
//                sBuilder.append(item);
//                if (i != length - 1) {
//                    sBuilder.append(jsonSplit);
//                }
//            }
//        }
        sBuilder.append("]");
        return sBuilder.toString();
    }

    public   String getEngineFailuresCodeListString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[");
//        if (getEngineFailuresCodeList()!=null&&getEngineFailuresCodeList().size() > 0) {
//            for (int i = 0, length = getEngineFailuresCodeList().size(); i < length; i++) {
//                int item = getEngineFailuresCodeList().get(i);
//                sBuilder.append(item);
//                if (i != length - 1) {
//                    sBuilder.append(jsonSplit);
//                }
//            }
//        }
        sBuilder.append("]");
        return sBuilder.toString();
    }

    public  String getDriveMotorFailuresCodeListString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[");
//        if (getDriveMotorFailuresCodeList()!=null&&getDriveMotorFailuresCodeList().size() > 0) {
//            for (int i = 0, length = getDriveMotorFailuresCodeList().size(); i < length; i++) {
//                int item = getDriveMotorFailuresCodeList().get(i);
//                sBuilder.append(item);
//                if (i != length - 1) {
//                    sBuilder.append(jsonSplit);
//                }
//            }
//        }
        sBuilder.append("]");
        return sBuilder.toString();
    }

    public    String getOtherFailuresCodeListString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[");
//        if (getOtherFailuresCodeList()!=null&&getOtherFailuresCodeList().size() > 0) {
//            for (int i = 0, length = getOtherFailuresCodeList().size(); i < length; i++) {
//                int item = getOtherFailuresCodeList().get(i);
//                sBuilder.append(item);
//                if (i != length - 1) {
//                    sBuilder.append(jsonSplit);
//                }
//            }
//        }
        sBuilder.append("]");
        return sBuilder.toString();
    }


}


