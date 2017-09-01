package com.ccclubs.olap.protocol.protocolmodel.gb;

import java.util.ArrayList;
import java.util.List;

/**
 * 燃料电池数据
 */
public class GB_02_03  {

    //燃料电池电压；WORD ;有效值范围：0～20000（表示0V～2000V），最小计量单元：0.1V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private float fuelCellVoltage=-2;

    //燃料电池电流；WORD ;有效值范围： 0～20000（表示0A～+2000A），最小计量单元：0.1A，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private float fuelCellCurrent=-2;

    //燃料消耗率； WORD; 有效值范围：0～60000（表示0kg/100km～600kg/100km），最小计量单元：0.01kg/100km，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private float fuelConsumptionRate=-2;

   //燃料电池温度探针总数；WORD;  N个燃料电池温度探针，有效值范围：0～65531，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private int fuelCellTemperatureProbeCount=-2;

    //探针温度值； byte[N]; 有效值范围：0～240（数值偏移量40℃，表示-40℃～+200℃），最小计量单元：1℃。
    private List probeTemperature=new ArrayList<Integer>();

    // 氢系统中最高温度；WORD ;有效值范围：0～2400（偏移量40℃，表示-40℃～200℃），最小计量单元：0.1℃，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private float hydrogenMaxTemperature=-2;

   //氢系统中最高温度探针代号；BYTE; 有效值范围：1～252，“0xFE”表示异常，“0xFF”表示无效。
    private float hydrogenMaxTemperatureProbeNo=-2;

    //氢气最高浓度；WORD; 有效值范围：0～60000（表示0ppm～50000ppm），最小计量单元：1ppm，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private int hydrogenMaxConcentration=-2;

    //氢气最高浓度传感器代号；BYTE; 有效值范围：1～252，“0xFE”表示异常，“0xFF”表示无效。
    private int hydrogenMaxConcentrationSensorNo=-2;

    //氢气最高压力；WORD; 有效值范围：0～1000（表示0MPa～100MPa），最小计量单元：0.1MPa。
    private float hydrogenMaxPressure=-2;

    //氢气最高压力传感器代号；BYTE ; 有效值范围：1～252，“0xFE”表示异常，“0xFF”表示无效。
    private int hydrogenMaxPressureSensorNo=-2;

    //高压DC/DC状态；BYTE ; 0x01：工作；0x02：断开；“0xFE”表示异常，“0xFF”表示无效。
    private int highvoltageDCDCStatus=-2;

//

    public float getFuelCellVoltage() {
        return fuelCellVoltage;
    }

    public void setFuelCellVoltage(float fuelCellVoltage) {
        this.fuelCellVoltage = fuelCellVoltage;
    }

    public float getFuelCellCurrent() {
        return fuelCellCurrent;
    }

    public void setFuelCellCurrent(float fuelCellCurrent) {
        this.fuelCellCurrent = fuelCellCurrent;
    }

    public float getFuelConsumptionRate() {
        return fuelConsumptionRate;
    }

    public void setFuelConsumptionRate(float fuelConsumptionRate) {
        this.fuelConsumptionRate = fuelConsumptionRate;
    }

    public int getFuelCellTemperatureProbeCount() {
        return fuelCellTemperatureProbeCount;
    }

    public void setFuelCellTemperatureProbeCount(int fuelCellTemperatureProbeCount) {
        this.fuelCellTemperatureProbeCount = fuelCellTemperatureProbeCount;
    }


    public List getProbeTemperature() {
        return probeTemperature;
    }

    public void setProbeTemperature(List probeTemperature) {
        this.probeTemperature = probeTemperature;
    }

    public float getHydrogenMaxTemperature() {
        return hydrogenMaxTemperature;
    }

    public void setHydrogenMaxTemperature(float hydrogenMaxTemperature) {
        this.hydrogenMaxTemperature = hydrogenMaxTemperature;
    }

    public float getHydrogenMaxTemperatureProbeNo() {
        return hydrogenMaxTemperatureProbeNo;
    }

    public void setHydrogenMaxTemperatureProbeNo(float hydrogenMaxTemperatureProbeNo) {
        this.hydrogenMaxTemperatureProbeNo = hydrogenMaxTemperatureProbeNo;
    }

    public int getHydrogenMaxConcentration() {
        return hydrogenMaxConcentration;
    }

    public void setHydrogenMaxConcentration(int hydrogenMaxConcentration) {
        this.hydrogenMaxConcentration = hydrogenMaxConcentration;
    }

    public int getHydrogenMaxConcentrationSensorNo() {
        return hydrogenMaxConcentrationSensorNo;
    }

    public void setHydrogenMaxConcentrationSensorNo(int hydrogenMaxConcentrationSensorNo) {
        this.hydrogenMaxConcentrationSensorNo = hydrogenMaxConcentrationSensorNo;
    }

    public float getHydrogenMaxPressure() {
        return hydrogenMaxPressure;
    }

    public void setHydrogenMaxPressure(float hydrogenMaxPressure) {
        this.hydrogenMaxPressure = hydrogenMaxPressure;
    }

    public int getHydrogenMaxPressureSensorNo() {
        return hydrogenMaxPressureSensorNo;
    }

    public void setHydrogenMaxPressureSensorNo(int hydrogenMaxPressureSensorNo) {
        this.hydrogenMaxPressureSensorNo = hydrogenMaxPressureSensorNo;
    }

    public int getHighvoltageDCDCStatus() {
        return highvoltageDCDCStatus;
    }

    public void setHighvoltageDCDCStatus(int highvoltageDCDCStatus) {
        this.highvoltageDCDCStatus = highvoltageDCDCStatus;
    }


//

    public  float  getFuelCellVoltageString( int fuelCellVoltage) {
        switch (fuelCellVoltage) {
            case 0xFFFE:
                return -1;//异常
            case 0xFFFF:
                return -2;//无效
            default:
//                BigDecimal bigDecimal = AccurateOperationUtils.mul(getFuelCellVoltage(), 0.1);
//                bigDecimal = bigDecimal.setScale(1);
                return fuelCellVoltage;
        }
    }

    public  float getFuelCellCurrentString(int fuelCellCurrent) {
        switch (fuelCellCurrent) {
            case 0xFFFE:
                return -1 ;//"异常";
            case 0xFFFF:
                return -2;// "无效";
            default:
//                BigDecimal bigDecimal = AccurateOperationUtils.mul(getFuelCellCurrent(), 0.1);
//                bigDecimal = bigDecimal.setScale(1);
                return fuelCellCurrent;
        }
    }

    public  float getFuelConsumptionRateString(int fuelConsumptionRate) {
        switch (fuelConsumptionRate) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
//                BigDecimal bigDecimal = AccurateOperationUtils.mul(getFuelConsumptionRate(), 0.01);
//                bigDecimal = bigDecimal.setScale(2);
                return fuelConsumptionRate;
        }
    }

    public  int getFuelCellTemperatureProbeCountString(int fuelCellTemperatureProbeCount) {
        switch (fuelCellTemperatureProbeCount) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
                return fuelCellTemperatureProbeCount;
        }
    }

    public  float getHydrogenMaxTemperatureString(int hydrogenMaxPressure) {
        switch (hydrogenMaxPressure) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return  -2;//"无效";
            default:
//                BigDecimal bigDecimal = AccurateOperationUtils
//                        .sub(AccurateOperationUtils.mul(getHydrogenMaxTemperature(), 0.1).doubleValue(), 40);
//                bigDecimal = bigDecimal.setScale(1);
                return hydrogenMaxPressure;
        }
    }

    public  float getHydrogenMaxTemperatureProbeNoString(int hydrogenMaxTemperatureProbeNo) {
        switch (hydrogenMaxTemperatureProbeNo) {
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return hydrogenMaxTemperatureProbeNo;
        }
    }

    public  int getHydrogenMaxConcentrationSensorNoString(int hydrogenMaxConcentrationSensorNo) {
        switch (hydrogenMaxConcentrationSensorNo) {
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return hydrogenMaxConcentrationSensorNo;
        }
    }

    public  int getHydrogenMaxPressureSensorNoString(int hydrogenMaxPressureSensorNo) {
        switch (hydrogenMaxPressureSensorNo) {
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return  -2;//"无效";
            default:
                return hydrogenMaxPressureSensorNo;
        }
    }

    public  int getHighvoltageDCDCStatusString( int highvoltageDCDCStatus) {
        switch (highvoltageDCDCStatus) {
//            case 0x01:
//                return "工作";
//            case 0x02:
//                return "断开";
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return highvoltageDCDCStatus;
        }
    }

    public  int  getHydrogenMaxConcentrationString( int hydrogenMaxConcentration) {
        switch (hydrogenMaxConcentration) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
                return hydrogenMaxConcentration;
        }
    }

    public  float getHydrogenMaxPressureString(int hydrogenMaxPressure) {
        switch (hydrogenMaxPressure) {
            case 0xFFFE:
                return -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
//                BigDecimal bigDecimal = AccurateOperationUtils.mul(getHydrogenMaxPressure(), 0.1);
//                bigDecimal = bigDecimal.setScale(1);
                return hydrogenMaxPressure;
        }
    }

    private static String jsonSplit = ",";
    public   String getProbeTemperatureString(byte[] probeTemperature ) {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[");
        if (probeTemperature!=null&&probeTemperature.length > 0) {
            for (int i = 0; i < probeTemperature.length; i++) {
                byte item = probeTemperature[i];
                sBuilder.append((item & 0xFF));

                if (i != probeTemperature.length - 1) {
                    sBuilder.append(jsonSplit);
                }
            }
        }
        sBuilder.append("]");
        return sBuilder.toString();
    }
}
