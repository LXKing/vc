package com.ccclubs.olap.protocol.protocolmodel.gb;


import com.ccclubs.olap.protocol.util.AccurateOperationUtils;

import java.math.BigDecimal;

/**
 *
 */
public class GB_02_02_Item {

    //驱动电机序号；byte；有效值范围1～253
    private int driveMotorSerial;

    //驱动电机状态；byte；0x01：耗电；0x02：发电；0x03：关闭状态；0x04：准备状态“0xFE”表示异常，“0xFF”表示无效。
    private int driveMotorStatus=-2;

    //驱动电机控制器温度；byte; 有效值范围：0～250 （数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
    private int driveMotorControllerTemperature=-2;

    //驱动电机转速；WORD; 有效值范围：0～65531（数值偏移量20000表示-20000 r/min～45531r/min），最小计量单元：1r/min，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private int driveMotorSpeed=-2;

    //驱动电机转矩；WORD; 有效值范围：0～65531（数值偏移量20000表示-2000N*m～4553.1N*m），最小计量单元：0.1N*m，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private int driveMotorTorque=-2;

    //驱动电机温度； BYTE ; 有效值范围：0～250 （数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
    private int driveMotorTemperature=-2;

    // 电机控制器输入电压；WORD ; 有效值范围：0～60000（表示0V～6000V），最小计量单元：0.1V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private int motorControllerInputVoltage=-2;

    //电机控制器直流母线电流； WORD ;有效值范围： 0～20000（数值偏移量1000A，表示-1000A～+1000A），最小计量单元：0.1A，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private float motorControllerDCBusCurrent=-2;


//
    public int getDriveMotorSerial() {
        return driveMotorSerial;
    }

    public void setDriveMotorSerial(int driveMotorSerial) {
        this.driveMotorSerial = driveMotorSerial;
    }

    public int getDriveMotorStatus() {
        return driveMotorStatus;
    }

    public void setDriveMotorStatus(int driveMotorStatus) {
        this.driveMotorStatus = driveMotorStatus;
    }

    public int getDriveMotorControllerTemperature() {
        return driveMotorControllerTemperature;
    }

    public void setDriveMotorControllerTemperature(int driveMotorControllerTemperature) {
        this.driveMotorControllerTemperature = driveMotorControllerTemperature;
    }

    public int getDriveMotorSpeed() {
        return driveMotorSpeed;
    }

    public void setDriveMotorSpeed(int driveMotorSpeed) {
        this.driveMotorSpeed = driveMotorSpeed;
    }

    public int getDriveMotorTorque() {
        return driveMotorTorque;
    }

    public void setDriveMotorTorque(int driveMotorTorque) {
        this.driveMotorTorque = driveMotorTorque;
    }

    public int getDriveMotorTemperature() {
        return driveMotorTemperature;
    }

    public void setDriveMotorTemperature(int driveMotorTemperature) {
        this.driveMotorTemperature = driveMotorTemperature;
    }

    public int getMotorControllerInputVoltage() {
        return motorControllerInputVoltage;
    }

    public void setMotorControllerInputVoltage(int motorControllerInputVoltage) {
        this.motorControllerInputVoltage = motorControllerInputVoltage;
    }

    public float getMotorControllerDCBusCurrent() {
        return motorControllerDCBusCurrent;
    }

    public void setMotorControllerDCBusCurrent(float motorControllerDCBusCurrent) {
        this.motorControllerDCBusCurrent = motorControllerDCBusCurrent;
    }


//
    /**
     * 0x0：无效
     0x1：耗电
     0x2：发电
     0x3：关闭
     0x4：准备
     0x5：异常
     * @return
     */
    public  int getDriveMotorStatusString(int driveMotorStatus) {

//       byte gearStatus= getgetGearPos(getDriveMotorStatus());
//
//        final byte NGear =bit2byte("00110000");
//        final byte PGear =bit2byte("00111111");
//        final byte DGear =bit2byte("00111110");
//        final byte RGear =bit2byte("00111101");
//        if (gearStatus == NGear) {
//            return 0x01;
//        } else if (gearStatus == PGear) {
//            return 0x04;
//        } else if (gearStatus == DGear) {
//            return 0x01;
//        } else if (gearStatus == RGear) {
//            return 0x01;
//        } else {
//            return 0x04;
//        }

        switch (driveMotorStatus) {
//            case 0x01:
//                return "耗电";
//            case 0x02:
//                return "发电";
//            case 0x03:
//                return "关闭状态";
//            case 0x04:
//                return "准备状态";
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";

            case 0x00:  //无效
                return  -2;

            case 0x01:  //耗电
                return  0x01;

            case 0x02:  //发电
                return  0x02 ;

            case 0x03:  //关闭
                return  0x03;

            case 0x04:  //准备
                return  0x04;

            case 0x05:  //异常
                return  -1;
            default:
                return -2;
        }
    }

    public  byte getgetGearPos(int value){

        if (value == 0x0) {
            return bit2byte("00111111");
        }
        if (value == 0x1) {
            return bit2byte("00111111");
        }
        if (value == 0x2) {
            return bit2byte("00110000");
        }
        if (value == 0x3) {
            return bit2byte("00111110");
        }
        if (value == 0x4) {
            return bit2byte("00111101");
        }
        return bit2byte("00110000");
    }
    public  byte bit2byte(String bString) {
        byte result = 0;
        for (int i = bString.length() - 1, j = 0; i >= 0; i--, j++) {
            result += (Byte.parseByte(bString.charAt(i) + "") * Math.pow(2, j));
        }
        return result;
    }

    public   int getMotorControllerInputVoltageString(int motorControllerInputVoltage){

        switch (motorControllerInputVoltage) {
            case 0xFFFE:
                return -1;//异常
            case 0xFFFF:
                return -2;//无效
            default:
                return motorControllerInputVoltage;
        }


    }


    public  int getDriveMotorSerialString(){
        return 1;
    }

    public  int getDriveMotorControllerTemperatureString(int driveMotorControllerTemperature ) {
        switch (driveMotorControllerTemperature) {
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return driveMotorControllerTemperature-50 ;
        }
    }



    public  int getDriveMotorSpeedString(int driveMotorSpeed) {
        switch (driveMotorSpeed) {
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return driveMotorSpeed-32000;
        }
    }

    public    int getDriveMotorTorqueString(int driveMotorTorque) {
//        switch (getDriveMotorTorque()) {
//            case 0xFFFE:
//                return -1;//"异常";
//            case 0xFFFF:
//                return -2;//"无效";
//            default:
////                BigDecimal bigDecimal = AccurateOperationUtils
////                        .sub(AccurateOperationUtils.mul(getDriveMotorTorque(), 0.1).doubleValue(), 2000);
////                bigDecimal = bigDecimal.setScale(1);
//                return getDriveMotorTorque()-3000;
//        }
        return 21650;
    }

    public  int getDriveMotorTemperatureString(int driveMotorTemperature) {
        switch (driveMotorTemperature) {
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return driveMotorTemperature-50;
        }
    }

    public  int getMotorInputVoltageString(int motorControllerInputVoltage) {
        switch (motorControllerInputVoltage) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
//                BigDecimal bigDecimal = AccurateOperationUtils.mul(getMotorInputVoltage(), 0.1);
//                bigDecimal = bigDecimal.setScale(1);
                return motorControllerInputVoltage;
        }
    }

    public  float getMotorControllerDCBusCurrentString(int motorControllerDCBusCurrent) {
        switch (motorControllerDCBusCurrent) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
//                BigDecimal bigDecimal = AccurateOperationUtils
//                        .sub(AccurateOperationUtils.mul(getMotorControllerDCBusCurrent(), 0.1).doubleValue(),
//                                1000);
//                bigDecimal = bigDecimal.setScale(1);
                BigDecimal bigDecimal = AccurateOperationUtils
                        .sub(AccurateOperationUtils.mul(motorControllerDCBusCurrent, 0.1).doubleValue(), 600);
                bigDecimal = bigDecimal.setScale(1);
                return bigDecimal.floatValue();
        }
    }
}
