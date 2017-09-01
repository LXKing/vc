package com.ccclubs.olap.protocol.protocolmodel.gb;


import com.ccclubs.olap.protocol.util.AccurateOperationUtils;

import java.math.BigDecimal;

/**
 *  整车数据
 */
public class GB_02_01 {


    //车辆状态
    private int vehicleStatus=-2;

    //充电状态
    private int chargeStatus=-2;

    // 运行模式 0x01: 纯电；0x02：混动；0x03：燃油；0xFE表示异常；0xFF表示无效()
    private int runningMode=0x01; //写死了

    //车速
    private float speed=-2;

    //累计里程
    private float  accumulatedMileage=-2;

    //总电压
    private float totalVoltage=-2;

    //有效值范围： 0～20000（偏移量1000A，表示-1000A～+1000A），最小计量单元：0.1A，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private float totalCurrent=-2;

    //有效值范围：0～100（表示0%～100%），最小计量单元：1%，“0xFE”表示异常，“0xFF”表示无效。
    private int soc=-2;

    //0x01：工作；0x02：断开，“0xFE”表示异常，“0xFF”表示无效。
    private int dcDcStatus=-2;

    //挡位定义见附录A.1
    private String gear="";

    //绝缘电阻 有效范围0～60000（表示0KΩ～60000KΩ），最小计量单元：1KΩ
    private int insulationResistance=-2;

//

    public int getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(int vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public int getChargeStatus() {
        return chargeStatus;
    }

    public void setChargeStatus(int chargeStatus) {
        this.chargeStatus = chargeStatus;
    }

    public int getRunningMode() {
        return runningMode;
    }

    public void setRunningMode(int runningMode) {
        this.runningMode = runningMode;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getAccumulatedMileage() {
        return accumulatedMileage;
    }

    public void setAccumulatedMileage(float accumulatedMileage) {
        this.accumulatedMileage = accumulatedMileage;
    }

    public float getTotalVoltage() {
        return totalVoltage;
    }

    public void setTotalVoltage(float totalVoltage) {
        this.totalVoltage = totalVoltage;
    }

    public float getTotalCurrent() {
        return totalCurrent;
    }

    public void setTotalCurrent(float totalCurrent) {
        this.totalCurrent = totalCurrent;
    }

    public int getSoc() {
        return soc;
    }

    public void setSoc(int soc) {
        this.soc = soc;
    }

    public int getDcDcStatus() {
        return dcDcStatus;
    }

    public void setDcDcStatus(int dcDcStatus) {
        this.dcDcStatus = dcDcStatus;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public int getInsulationResistance() {
        return insulationResistance;
    }

    public void setInsulationResistance(int insulationResistance) {
        this.insulationResistance = insulationResistance;
    }

    //
    public  int getVechicleStatusString(int vechicleStaus ) {
        switch (vechicleStaus) {
//            case 0x01:
//                return "车辆启动状态";
//            case 0x02:
//                return "熄火";
//            case 0x03:
//                return "其他状态";
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";

            case 0x00:   //OFF
                return 0x02;

            case 0x01:  //ACC
                return 0x03;

            case 0x02:  //ON
                return 0x01;
            default:
                return -2;
        }
    }


    /**
     * 0x0：未充电
     0x1：直流充电
     0x2：交流充电
     0x3：充电完成
     * @return
     */
    public  int getChargeStatusString(int chargeStatus) {
        switch (chargeStatus) {
//            case 0x01:
//                return "停车充电";
//            case 0x02:
//                return "行驶充电";
//            case 0x03:
//                return "未充电状态";
//            case 0x04:
//                return "充电完成";
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";

            case 0x00:  //未充电
                return 0x03;

            case 0x01:  //直流充电
                return 0x01;

            case 0x02:  //交流充电
                return 0x01;

            case 0x03:  //充电完成
                return 0x04;
            default:
                return -2;
        }
    }

    /**
     *
     * @return
     */
    public  int getRunningModeString(int runningMode) {
        switch (runningMode) {
//            case 0x01:
//                return "纯电";
//            case 0x02:
//                return "混动";
//            case 0x03:
//                return "燃油";
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return 0x01;//
        }
    }

    public  float getSpeedString(int speed) {
        switch (speed) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
//                BigDecimal bigDecimal = AccurateOperationUtils.mul(getSpeed(), 0.1);
//                bigDecimal = bigDecimal.setScale(1);
                return speed;
        }
    }

    public  float getAccumulatedMileageString(int accumulatedMileage) {
        switch (accumulatedMileage) {
            case 0xFFFFFFFE:
                return -1;//"异常";
            case 0xFFFFFFFF:
                return -2;//"无效";
            default:
                BigDecimal bigDecimal = AccurateOperationUtils.mul(accumulatedMileage, 0.1);
                bigDecimal = bigDecimal.setScale(1);
                return bigDecimal.floatValue();
        }
    }

    public   float getTotalVoltageString(int totalVoltage) {
        switch (totalVoltage) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
                BigDecimal bigDecimal = AccurateOperationUtils.mul(totalVoltage, 0.1);
                bigDecimal = bigDecimal.setScale(1);
                return bigDecimal.floatValue();
        }
    }

    public    float getTotalCurrentString(int totalCurrent) {
        switch (totalCurrent) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
                BigDecimal bigDecimal = AccurateOperationUtils
                        .sub(AccurateOperationUtils.mul(totalCurrent, 0.1).doubleValue(), 600);
                bigDecimal = bigDecimal.setScale(1);
                return bigDecimal.floatValue();
        }
    }

    public  int getSocString(int soc) {
        switch (soc) {
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return soc;
        }
    }

    public  int getDcDcStatusString(int dcDcStatus) {
        switch (dcDcStatus) {
//            case 0x01:
//                return "工作";
//            case 0x02:
//                return "断开";
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";

            case 0x00:  //Normal
               return 0x01;

            case 0x01:  //断开
                return 0x02;

            default:
                return -2;
        }
    }


    /**
     * 0x0：无效
     0x1：P
     0x2：N
     0x3：D
     0x4：R
     * @return
     */
    public   String getGearString(int gear) {
        int result = (gear & 0xF);
        switch (result) {
//            case 0: //0x0：无效
//                return "00000000";

            case 0x01:  //P 停车当
                return "00001111";

            case 0x02:  //N----------空挡
                return "00000000";

            case 0x03:  //D
                return "00001110";

            case 0x04:  //R倒挡
                return "00001101";


            default:
                return Integer.toBinaryString((result & 0xFF) + 0x100).substring(1);
            }

    }


    public   int getInsulationResistanceString(int insulationResistance) {
//        (short)((Integer)getInsulationResistance()*0.1) ;
        BigDecimal bigDecimal = AccurateOperationUtils.mul(insulationResistance, 0.1);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.intValue();
    }

//    public String getAcceleratedPedalStrokeValueString() {
//        switch (getAcceleratedPedalStrokeValue()) {
//            case 0xFE:
//                return "异常";
//            case 0xFF:
//                return "无效";
//            default:
//                return String.valueOf(getAcceleratedPedalStrokeValue());
//        }
//    }
//
//    public String getBrakePedalStateString() {
//        switch (getBrakePedalState()) {
//            case 0:
//                return "制动关的状态";
//            case 0x65:
//                return "制动有效状态";
//            case 0xFE:
//                return "异常";
//            case 0xFF:
//                return "无效";
//            default:
//                return String.valueOf(getBrakePedalState());
//        }
//    }
}
