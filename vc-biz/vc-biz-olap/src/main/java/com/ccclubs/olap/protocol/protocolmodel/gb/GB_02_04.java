package com.ccclubs.olap.protocol.protocolmodel.gb;

/**
 * 发动机数据
 */
public class GB_02_04 {

   //发动机状态；BYTE; 0x01：启动状态；0x02：关闭状态，“0xFE”表示异常，“0xFF”表示无效。
    private int engineStatus=-2;

    //曲轴转速；WORD; 有效范围：0～60000(表示0rpm～60000rpm)，最小计量单元：1rpm，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private int crankshaftSpeed=-2;

    //燃料消耗率；WORD; 有效值范围：0～60000（表示0L/100km～600L/100km），最小计量单元：0.01L/100km，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
    private float fuelConsumptionRate=-2;

 //
    public int getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(int engineStatus) {
        this.engineStatus = engineStatus;
    }

    public int getCrankshaftSpeed() {
        return crankshaftSpeed;
    }

    public void setCrankshaftSpeed(int crankshaftSpeed) {
        this.crankshaftSpeed = crankshaftSpeed;
    }

    public float getFuelConsumptionRate() {
        return fuelConsumptionRate;
    }

    public void setFuelConsumptionRate(float fuelConsumptionRate) {
        this.fuelConsumptionRate = fuelConsumptionRate;
    }

    //
    private static String jsonSplit = ",";
    public  int getEngineStatusString(int engineStatus) {
        switch (engineStatus) {
//            case 0x01:
//                return "启动状态";
//            case 0x02:
//                return "关闭状态";
            case 0xFE:
                return -1;//"异常";
            case 0xFF:
                return -2;//"无效";
            default:
                return engineStatus;
        }
    }

    public  int getCrankshaftSpeedString(int crankshaftSpeed) {
        switch (crankshaftSpeed) {
            case 0xFFFE:
                return  -1;//"异常";
            case 0xFFFF:
                return -2;//"无效";
            default:
                return crankshaftSpeed;
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
}
