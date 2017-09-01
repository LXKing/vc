package com.ccclubs.olap.protocol.protocolmodel.gb;

/**
 * 极值数据
 */
public class GB_02_06 {

    //byte; 最高电压电池子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
    private int highestVoltageBatterySubsystemNo=-2;

    //byte; 最高电压电池单体代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
    private int highestVoltageBatterySingleModuleNo=-2;

    //WORD; 电池单体电压最高值 : 有效值范围：0～15000（表示0V～15V），最小计量单元：0.001V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private float batterySingleVoltageHighestValue=-2;

    //BYTE; 最低电压电池子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
    private int lowestVoltageBatterySubsystemNo=-2;

    //BYTE; 最低电压电池单体代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
    private int lowestVoltageBatterySingleModuleNo=-2;

    //WORD ; 电池单体电压最低值 : 有效值范围：0～15000（表示0V～15V），最小计量单元：0.001V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private float batterySingleVoltageLowestValue=-2;

    //BYTE; 最高温度子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
    private int highestTemperatureSubsystemNo=-2;

    //BYTE; 最高温度探针单体代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
    private int highestTemperatureProbeSingleNo=-2;

    //BYTE; 最高温度值 : 有效值范围：0～250（数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
    private int highestTemperatureValue=-2;

    //BYTE; 最低温度子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
    private int lowestTemperatureSubsystemNo=-2;

    //BYTE; 最低温度探针子系统代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
    private int lowestTemperatureProbeSubsystemNo=-2;

    //BYTE; 最低温度值 : 有效值范围：0～250（数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
    private int lowestTemperatureValue=-2;
//


    public int getHighestVoltageBatterySubsystemNo() {
        return highestVoltageBatterySubsystemNo;
    }

    public void setHighestVoltageBatterySubsystemNo(int highestVoltageBatterySubsystemNo) {
        this.highestVoltageBatterySubsystemNo = highestVoltageBatterySubsystemNo;
    }

    public int getHighestVoltageBatterySingleModuleNo() {
        return highestVoltageBatterySingleModuleNo;
    }

    public void setHighestVoltageBatterySingleModuleNo(int highestVoltageBatterySingleModuleNo) {
        this.highestVoltageBatterySingleModuleNo = highestVoltageBatterySingleModuleNo;
    }

    public float getBatterySingleVoltageHighestValue() {
        return batterySingleVoltageHighestValue;
    }

    public void setBatterySingleVoltageHighestValue(float batterySingleVoltageHighestValue) {
        this.batterySingleVoltageHighestValue = batterySingleVoltageHighestValue;
    }

    public int getLowestVoltageBatterySubsystemNo() {
        return lowestVoltageBatterySubsystemNo;
    }

    public void setLowestVoltageBatterySubsystemNo(int lowestVoltageBatterySubsystemNo) {
        this.lowestVoltageBatterySubsystemNo = lowestVoltageBatterySubsystemNo;
    }

    public int getLowestVoltageBatterySingleModuleNo() {
        return lowestVoltageBatterySingleModuleNo;
    }

    public void setLowestVoltageBatterySingleModuleNo(int lowestVoltageBatterySingleModuleNo) {
        this.lowestVoltageBatterySingleModuleNo = lowestVoltageBatterySingleModuleNo;
    }

    public float getBatterySingleVoltageLowestValue() {
        return batterySingleVoltageLowestValue;
    }

    public void setBatterySingleVoltageLowestValue(float batterySingleVoltageLowestValue) {
        this.batterySingleVoltageLowestValue = batterySingleVoltageLowestValue;
    }

    public int getHighestTemperatureSubsystemNo() {
        return highestTemperatureSubsystemNo;
    }

    public void setHighestTemperatureSubsystemNo(int highestTemperatureSubsystemNo) {
        this.highestTemperatureSubsystemNo = highestTemperatureSubsystemNo;
    }

    public int getHighestTemperatureProbeSingleNo() {
        return highestTemperatureProbeSingleNo;
    }

    public void setHighestTemperatureProbeSingleNo(int highestTemperatureProbeSingleNo) {
        this.highestTemperatureProbeSingleNo = highestTemperatureProbeSingleNo;
    }

    public int getHighestTemperatureValue() {
        return highestTemperatureValue;
    }

    public void setHighestTemperatureValue(int highestTemperatureValue) {
        this.highestTemperatureValue = highestTemperatureValue;
    }

    public int getLowestTemperatureSubsystemNo() {
        return lowestTemperatureSubsystemNo;
    }

    public void setLowestTemperatureSubsystemNo(int lowestTemperatureSubsystemNo) {
        this.lowestTemperatureSubsystemNo = lowestTemperatureSubsystemNo;
    }

    public int getLowestTemperatureProbeSubsystemNo() {
        return lowestTemperatureProbeSubsystemNo;
    }

    public void setLowestTemperatureProbeSubsystemNo(int lowestTemperatureProbeSubsystemNo) {
        this.lowestTemperatureProbeSubsystemNo = lowestTemperatureProbeSubsystemNo;
    }

    public int getLowestTemperatureValue() {
        return lowestTemperatureValue;
    }

    public void setLowestTemperatureValue(int lowestTemperatureValue) {
        this.lowestTemperatureValue = lowestTemperatureValue;
    }

 //
    public  int getDataString(int value) {
        switch (value) {
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return value;
        }
    }





    public  int getHighestVoltageBatterySubsystemNoString(int highestVoltageBatterySubsystemNo){
        return 1;
    }
    public  float getBatterySingleVoltageHighestValueString(int batterySingleVoltageHighestValue ) {
        switch (batterySingleVoltageHighestValue) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
//                BigDecimal bigDecimal = AccurateOperationUtils
//                        .mul(getBatterySingleVoltageHighestValue(), 0.001);
//                bigDecimal = bigDecimal.setScale(3,BigDecimal.ROUND_HALF_UP);
                return batterySingleVoltageHighestValue;
        }
    }

    public  float getBatterySingleVoltageLowestValueString(int batterySingleVoltageLowestValue) {
        switch (batterySingleVoltageLowestValue) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
//                BigDecimal bigDecimal = AccurateOperationUtils
//                        .mul(getBatterySingleVoltageLowestValue(), 0.001);
//                bigDecimal = bigDecimal.setScale(3,BigDecimal.ROUND_HALF_UP);
                return batterySingleVoltageLowestValue;
        }
    }

    public  int  getHighestTemperatureValueString(int highestTemperatureValue) {
        switch (highestTemperatureValue) {
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return highestTemperatureValue-50;
        }
    }

    public  int getLowestTemperatureValueString(int lowestTemperatureValue) {
        switch (lowestTemperatureValue) {
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效;
            default:
                return lowestTemperatureValue-50;
        }
    }

}
