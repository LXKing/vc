package com.ccclubs.protocol.protocolmodel.convert;

import com.ccclubs.protocol.protocolmodel.evnet.EVMessage;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.Tools;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/7/4.
 */
public class VehicleRealData implements Serializable {

  private GB_02 vehicleRealData = new GB_02();

  public GB_02 getVehicleRealData() {
    return vehicleRealData;
  }

  public void setVehicleRealData(GB_02 vehicleRealData) {
    this.vehicleRealData = vehicleRealData;
  }


  public static void main(String[] args) {

    String values = "54363339303836330000000000000000690520E91B4D010D003008010000000000002C03000802000300000000B20301087D0000C8003232000302080E38175C6010362B0303081029424E064D0305030408B0000116050000000305081710301030102CB203060800000000000000B203070800000100000101B2030808010100EB042300B103090800000000000000B203100800000000000000B3040008E1810004001B1C00";
    EVMessage evMessage = new EVMessage();
    evMessage.ReadFromBytes(Tools.HexString2Bytes(values));

    String jsonString = "";
    if (evMessage.getMessageContents() != null
        && evMessage.getMessageContents().getCanList() != null) {
      jsonString = CanGBVehicle.getCan_gb(evMessage.getMessageContents().getCanList());
    }

    System.out.println(jsonString);
  }

}


class GB_02 {

  // /整车数据
  private GB_02_01 vehicleData = new GB_02_01();

  //驱动电机数据
  private GB_02_02 driveMotorData = new GB_02_02();

  //燃料电池数据
  private GB_02_03 fuelCellData = new GB_02_03();

  //发动机数据
  private GB_02_04 engineData = new GB_02_04();

  //车辆位置数据
  private GB_02_05 vehicleLocationData = new GB_02_05();

  //极值数据
  private GB_02_06 extremumData = new GB_02_06();

  //报警数据
  private GB_02_07 alarmData = new GB_02_07();


  public GB_02_01 getVehicleData() {
    return vehicleData;
  }

  public void setVehicleData(GB_02_01 vehicleData) {
    this.vehicleData = vehicleData;
  }

  public GB_02_02 getDriveMotorData() {
    return driveMotorData;
  }

  public void setDriveMotorData(GB_02_02 driveMotorData) {
    this.driveMotorData = driveMotorData;
  }

  public GB_02_03 getFuelCellData() {
    return fuelCellData;
  }

  public void setFuelCellData(GB_02_03 fuelCellData) {
    this.fuelCellData = fuelCellData;
  }

  public GB_02_04 getEngineData() {
    return engineData;
  }

  public void setEngineData(GB_02_04 engineData) {
    this.engineData = engineData;
  }

  public GB_02_05 getVehicleLocationData() {
    return vehicleLocationData;
  }

  public void setVehicleLocationData(GB_02_05 vehicleLocationData) {
    this.vehicleLocationData = vehicleLocationData;
  }

  public GB_02_06 getExtremumData() {
    return extremumData;
  }

  public void setExtremumData(GB_02_06 extremumData) {
    this.extremumData = extremumData;
  }

  public GB_02_07 getAlarmData() {
    return alarmData;
  }

  public void setAlarmData(GB_02_07 alarmData) {
    this.alarmData = alarmData;
  }
}


/**
 * 整车数据
 */
class GB_02_01 {

  //车辆状态
  private int vehicleStatus = -2;

  //充电状态
  private int chargeStatus = -2;

  // 运行模式 0x01: 纯电；0x02：混动；0x03：燃油；0xFE表示异常；0xFF表示无效()
  private int runningMode = 0x01; //写死了

  //车速
  private float speed = -2;

  //累计里程
  private float accumulatedMileage = -2;

  //总电压
  private float totalVoltage = -2;

  //有效值范围： 0～20000（偏移量1000A，表示-1000A～+1000A），最小计量单元：0.1A，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private float totalCurrent = -2;

  //有效值范围：0～100（表示0%～100%），最小计量单元：1%，“0xFE”表示异常，“0xFF”表示无效。
  private int soc = -2;

  //0x01：工作；0x02：断开，“0xFE”表示异常，“0xFF”表示无效。
  private int dcDcStatus = -2;

  //挡位定义见附录A.1
  private String gear = "";

  //绝缘电阻 有效范围0～60000（表示0KΩ～60000KΩ），最小计量单元：1KΩ
  private int insulationResistance = -2;

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
  public int getVechicleStatusString(int vechicleStaus) {
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
   * 0x1：直流充电
   * 0x2：交流充电
   * 0x3：充电完成
   */
  public int getChargeStatusString(int chargeStatus) {
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
  public int getRunningModeString(int runningMode) {
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

  public float getSpeedString(int speed) {
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

  public float getAccumulatedMileageString(int accumulatedMileage) {
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

  public float getTotalVoltageString(int totalVoltage) {
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

  public float getTotalCurrentString(int totalCurrent) {
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

  public int getSocString(int soc) {
    switch (soc) {
      case 0xFE:
        return -1;//"异常";
      case 0xFF:
        return -2;//"无效";
      default:
        return soc;
    }
  }

  public int getDcDcStatusString(int dcDcStatus) {
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
   * 0x1：P
   * 0x2：N
   * 0x3：D
   * 0x4：R
   */
  public String getGearString(int gear) {
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


  public int getInsulationResistanceString(int insulationResistance) {
//        (short)((Integer)getInsulationResistance()*0.1) ;
    BigDecimal bigDecimal = AccurateOperationUtils.mul(insulationResistance, 0.1);
    bigDecimal = bigDecimal.setScale(1);
    return bigDecimal.intValue();
  }
}

class GB_02_02 {

  //驱动电机个数；byte 有效值1～253
  private int driveMotorCount;
  //驱动电机总成信息列表，按驱动电机序号依次排列
  private List<GB_02_02_Item> driveMotorList = new ArrayList<GB_02_02_Item>();
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

class GB_02_02_Item {

  //驱动电机序号；byte；有效值范围1～253
  private int driveMotorSerial;

  //驱动电机状态；byte；0x01：耗电；0x02：发电；0x03：关闭状态；0x04：准备状态“0xFE”表示异常，“0xFF”表示无效。
  private int driveMotorStatus = -2;

  //驱动电机控制器温度；byte; 有效值范围：0～250 （数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
  private int driveMotorControllerTemperature = -2;

  //驱动电机转速；WORD; 有效值范围：0～65531（数值偏移量20000表示-20000 r/min～45531r/min），最小计量单元：1r/min，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private int driveMotorSpeed = -2;

  //驱动电机转矩；WORD; 有效值范围：0～65531（数值偏移量20000表示-2000N*m～4553.1N*m），最小计量单元：0.1N*m，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private int driveMotorTorque = -2;

  //驱动电机温度； BYTE ; 有效值范围：0～250 （数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
  private int driveMotorTemperature = -2;

  // 电机控制器输入电压；WORD ; 有效值范围：0～60000（表示0V～6000V），最小计量单元：0.1V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private int motorControllerInputVoltage = -2;

  //电机控制器直流母线电流； WORD ;有效值范围： 0～20000（数值偏移量1000A，表示-1000A～+1000A），最小计量单元：0.1A，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private float motorControllerDCBusCurrent = -2;


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
   * 0x1：耗电
   * 0x2：发电
   * 0x3：关闭
   * 0x4：准备
   * 0x5：异常
   */
  public int getDriveMotorStatusString(int driveMotorStatus) {

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
        return -2;

      case 0x01:  //耗电
        return 0x01;

      case 0x02:  //发电
        return 0x02;

      case 0x03:  //关闭
        return 0x03;

      case 0x04:  //准备
        return 0x04;

      case 0x05:  //异常
        return -1;
      default:
        return -2;
    }
  }

  public byte getgetGearPos(int value) {

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

  public byte bit2byte(String bString) {
    byte result = 0;
    for (int i = bString.length() - 1, j = 0; i >= 0; i--, j++) {
      result += (Byte.parseByte(bString.charAt(i) + "") * Math.pow(2, j));
    }
    return result;
  }

  public int getMotorControllerInputVoltageString(int motorControllerInputVoltage) {

    switch (motorControllerInputVoltage) {
      case 0xFFFE:
        return -1;//异常
      case 0xFFFF:
        return -2;//无效
      default:
        return motorControllerInputVoltage;
    }


  }


  public int getDriveMotorSerialString() {
    return 1;
  }

  public int getDriveMotorControllerTemperatureString(int driveMotorControllerTemperature) {
    switch (driveMotorControllerTemperature) {
      case 0xFE:
        return -1;//"异常";
      case 0xFF:
        return -2;//"无效";
      default:
        return driveMotorControllerTemperature - 50;
    }
  }


  public int getDriveMotorSpeedString(int driveMotorSpeed) {
    switch (driveMotorSpeed) {
      case 0xFE:
        return -1;//"异常";
      case 0xFF:
        return -2;//"无效";
      default:
        return driveMotorSpeed - 32000;
    }
  }

  public int getDriveMotorTorqueString(int driveMotorTorque) {
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

  public int getDriveMotorTemperatureString(int driveMotorTemperature) {
    switch (driveMotorTemperature) {
      case 0xFE:
        return -1;//"异常";
      case 0xFF:
        return -2;//"无效";
      default:
        return driveMotorTemperature - 50;
    }
  }

  public int getMotorInputVoltageString(int motorControllerInputVoltage) {
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

  public float getMotorControllerDCBusCurrentString(int motorControllerDCBusCurrent) {
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

class GB_02_03 {

  //燃料电池电压；WORD ;有效值范围：0～20000（表示0V～2000V），最小计量单元：0.1V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private float fuelCellVoltage = -2;

  //燃料电池电流；WORD ;有效值范围： 0～20000（表示0A～+2000A），最小计量单元：0.1A，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private float fuelCellCurrent = -2;

  //燃料消耗率； WORD; 有效值范围：0～60000（表示0kg/100km～600kg/100km），最小计量单元：0.01kg/100km，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private float fuelConsumptionRate = -2;

  //燃料电池温度探针总数；WORD;  N个燃料电池温度探针，有效值范围：0～65531，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private int fuelCellTemperatureProbeCount = -2;

  //探针温度值； byte[N]; 有效值范围：0～240（数值偏移量40℃，表示-40℃～+200℃），最小计量单元：1℃。
  private List probeTemperature = new ArrayList<Integer>();

  // 氢系统中最高温度；WORD ;有效值范围：0～2400（偏移量40℃，表示-40℃～200℃），最小计量单元：0.1℃，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private float hydrogenMaxTemperature = -2;

  //氢系统中最高温度探针代号；BYTE; 有效值范围：1～252，“0xFE”表示异常，“0xFF”表示无效。
  private float hydrogenMaxTemperatureProbeNo = -2;

  //氢气最高浓度；WORD; 有效值范围：0～60000（表示0ppm～50000ppm），最小计量单元：1ppm，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private int hydrogenMaxConcentration = -2;

  //氢气最高浓度传感器代号；BYTE; 有效值范围：1～252，“0xFE”表示异常，“0xFF”表示无效。
  private int hydrogenMaxConcentrationSensorNo = -2;

  //氢气最高压力；WORD; 有效值范围：0～1000（表示0MPa～100MPa），最小计量单元：0.1MPa。
  private float hydrogenMaxPressure = -2;

  //氢气最高压力传感器代号；BYTE ; 有效值范围：1～252，“0xFE”表示异常，“0xFF”表示无效。
  private int hydrogenMaxPressureSensorNo = -2;

  //高压DC/DC状态；BYTE ; 0x01：工作；0x02：断开；“0xFE”表示异常，“0xFF”表示无效。
  private int highvoltageDCDCStatus = -2;

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

  public float getFuelCellVoltageString(int fuelCellVoltage) {
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

  public float getFuelCellCurrentString(int fuelCellCurrent) {
    switch (fuelCellCurrent) {
      case 0xFFFE:
        return -1;//"异常";
      case 0xFFFF:
        return -2;// "无效";
      default:
//                BigDecimal bigDecimal = AccurateOperationUtils.mul(getFuelCellCurrent(), 0.1);
//                bigDecimal = bigDecimal.setScale(1);
        return fuelCellCurrent;
    }
  }

  public float getFuelConsumptionRateString(int fuelConsumptionRate) {
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

  public int getFuelCellTemperatureProbeCountString(int fuelCellTemperatureProbeCount) {
    switch (fuelCellTemperatureProbeCount) {
      case 0xFFFE:
        return -1;//"异常";
      case 0xFFFF:
        return -2;//"无效";
      default:
        return fuelCellTemperatureProbeCount;
    }
  }

  public float getHydrogenMaxTemperatureString(int hydrogenMaxPressure) {
    switch (hydrogenMaxPressure) {
      case 0xFFFE:
        return -1;//"异常";
      case 0xFFFF:
        return -2;//"无效";
      default:
//                BigDecimal bigDecimal = AccurateOperationUtils
//                        .sub(AccurateOperationUtils.mul(getHydrogenMaxTemperature(), 0.1).doubleValue(), 40);
//                bigDecimal = bigDecimal.setScale(1);
        return hydrogenMaxPressure;
    }
  }

  public float getHydrogenMaxTemperatureProbeNoString(int hydrogenMaxTemperatureProbeNo) {
    switch (hydrogenMaxTemperatureProbeNo) {
      case 0xFE:
        return -1;//"异常";
      case 0xFF:
        return -2;//"无效";
      default:
        return hydrogenMaxTemperatureProbeNo;
    }
  }

  public int getHydrogenMaxConcentrationSensorNoString(int hydrogenMaxConcentrationSensorNo) {
    switch (hydrogenMaxConcentrationSensorNo) {
      case 0xFE:
        return -1;//"异常";
      case 0xFF:
        return -2;//"无效";
      default:
        return hydrogenMaxConcentrationSensorNo;
    }
  }

  public int getHydrogenMaxPressureSensorNoString(int hydrogenMaxPressureSensorNo) {
    switch (hydrogenMaxPressureSensorNo) {
      case 0xFE:
        return -1;//"异常";
      case 0xFF:
        return -2;//"无效";
      default:
        return hydrogenMaxPressureSensorNo;
    }
  }

  public int getHighvoltageDCDCStatusString(int highvoltageDCDCStatus) {
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

  public int getHydrogenMaxConcentrationString(int hydrogenMaxConcentration) {
    switch (hydrogenMaxConcentration) {
      case 0xFFFE:
        return -1;//"异常";
      case 0xFFFF:
        return -2;//"无效";
      default:
        return hydrogenMaxConcentration;
    }
  }

  public float getHydrogenMaxPressureString(int hydrogenMaxPressure) {
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

  public String getProbeTemperatureString(byte[] probeTemperature) {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("[");
    if (probeTemperature != null && probeTemperature.length > 0) {
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

class GB_02_04 {

  //发动机状态；BYTE; 0x01：启动状态；0x02：关闭状态，“0xFE”表示异常，“0xFF”表示无效。
  private int engineStatus = -2;

  //曲轴转速；WORD; 有效范围：0～60000(表示0rpm～60000rpm)，最小计量单元：1rpm，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private int crankshaftSpeed = -2;

  //燃料消耗率；WORD; 有效值范围：0～60000（表示0L/100km～600L/100km），最小计量单元：0.01L/100km，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private float fuelConsumptionRate = -2;

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

  public int getEngineStatusString(int engineStatus) {
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

  public int getCrankshaftSpeedString(int crankshaftSpeed) {
    switch (crankshaftSpeed) {
      case 0xFFFE:
        return -1;//"异常";
      case 0xFFFF:
        return -2;//"无效";
      default:
        return crankshaftSpeed;
    }
  }

  public float getFuelConsumptionRateString(int fuelConsumptionRate) {
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

class GB_02_05 {

  //字节位 BYTE; 描述 0 [0:有效定位；1:无效定位（当数据通信正常，而不能获取定位信息时，发送最后一次有效定位信息，并将定位状态置为无效。）]. 1 [0:北纬；1:南纬]. 2 [0:东经；1:西经]. * 3~7 保留
  private int positionStatus = -2;

  // DWORD ; 以度为单位的纬度值乘以10的6次方，精确到百万分之一度。
  private float latitude = -2;

  //DWORD ; 以度为单位的纬度值乘以10的6次方，精确到百万分之一度。
  private float longitude = -2;

//

  public int getPositionStatus() {
    return positionStatus;
  }

  public void setPositionStatus(int positionStatus) {
    this.positionStatus = positionStatus;
  }

  public float getLatitude() {
    return latitude;
  }

  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }

//

  public String getPositionStatusString(int positionStatus) {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append((positionStatus & 0x1) == 0 ? "有效定位" : "无效定位");
    sBuilder.append(";");
    sBuilder.append((positionStatus & 0x2) == 0 ? "北纬" : "南纬");
    sBuilder.append(";");
    sBuilder.append((positionStatus & 0x4) == 0 ? "东经" : "西经");

    return sBuilder.toString();
  }
//    public float getLongitudeString() {
//
//        return getLongitude();
//    }
//
//    public float getLatitudeString(){
//        return getLongitude();
//    }

}

class GB_02_06 {

  //byte; 最高电压电池子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
  private int highestVoltageBatterySubsystemNo = -2;

  //byte; 最高电压电池单体代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
  private int highestVoltageBatterySingleModuleNo = -2;

  //WORD; 电池单体电压最高值 : 有效值范围：0～15000（表示0V～15V），最小计量单元：0.001V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private float batterySingleVoltageHighestValue = -2;

  //BYTE; 最低电压电池子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
  private int lowestVoltageBatterySubsystemNo = -2;

  //BYTE; 最低电压电池单体代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
  private int lowestVoltageBatterySingleModuleNo = -2;

  //WORD ; 电池单体电压最低值 : 有效值范围：0～15000（表示0V～15V），最小计量单元：0.001V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
  private float batterySingleVoltageLowestValue = -2;

  //BYTE; 最高温度子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
  private int highestTemperatureSubsystemNo = -2;

  //BYTE; 最高温度探针单体代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
  private int highestTemperatureProbeSingleNo = -2;

  //BYTE; 最高温度值 : 有效值范围：0～250（数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
  private int highestTemperatureValue = -2;

  //BYTE; 最低温度子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
  private int lowestTemperatureSubsystemNo = -2;

  //BYTE; 最低温度探针子系统代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
  private int lowestTemperatureProbeSubsystemNo = -2;

  //BYTE; 最低温度值 : 有效值范围：0～250（数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
  private int lowestTemperatureValue = -2;
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
  public int getDataString(int value) {
    switch (value) {
      case 0xFE:
        return -1;//"异常";
      case 0xFF:
        return -2;//"无效";
      default:
        return value;
    }
  }


  public int getHighestVoltageBatterySubsystemNoString(int highestVoltageBatterySubsystemNo) {
    return 1;
  }

  public float getBatterySingleVoltageHighestValueString(int batterySingleVoltageHighestValue) {
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

  public float getBatterySingleVoltageLowestValueString(int batterySingleVoltageLowestValue) {
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

  public int getHighestTemperatureValueString(int highestTemperatureValue) {
    switch (highestTemperatureValue) {
      case 0xFE:
        return -1;//"异常";
      case 0xFF:
        return -2;//"无效";
      default:
        return highestTemperatureValue - 50;
    }
  }

  public int getLowestTemperatureValueString(int lowestTemperatureValue) {
    switch (lowestTemperatureValue) {
      case 0xFE:
        return -1;//"异常";
      case 0xFF:
        return -2;//"无效;
      default:
        return lowestTemperatureValue - 50;
    }
  }

}

class GB_02_07 {

  //最高报警等级 : 为当前发生的故障中的最高等级值，有效值范围：0～3，“0”表示无故障；“1”表示1级故障，指代不影响车辆正常行驶的故障；“2”表示2级故障，指代影响车辆性能，需驾驶员限制行驶的故障；“3”表示3级故障，为最高级别故障
  // ，指代驾驶员应立即停车处理或请求救援的故障；具体等级对应的故障内容由厂商自行定义；“0xFE”表示异常，“0xFF”表示无效。
  private int highestAlarmLevel = -2;

  /**
   * 通用报警标志 : 通用报警标志位定义见表18。
   */
  private String generalAlarmFlag = "";

  /**
   * 可充电储能装置故障总数N1 : N1个可充电储能装置故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int rechargeableStorageDeviceFailuresTotalCount = -2;

  /**
   * 扩展性数据，由厂商自行定义，可充电储能装置故障个数等于可充电储能装置故障总数N1
   */
  private List<String> rechargeableStorageDeviceFailuresCodeList = new ArrayList<String>();

  /**
   * 驱动电机故障总数N2 : N2个驱动电机故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int driveMotorFailureTotalCount = -2;

  /**
   * 驱动电机故障代码列表 : 厂商自行定义，驱动电机故障个数等于驱动电机故障总数N2。
   */
  private List<String> driveMotorFailuresCodeList = new ArrayList<String>();

  /**
   * 发动机故障总数N3 : N3个驱动电机故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int engineFailuresTotalCount = -2;

  /**
   * 发动机故障列表 : 厂商自行定义，发动机故障个数等于驱动电机故障总数N3
   */
  private List<String> engineFailuresCodeList = new ArrayList<String>();

  /**
   * 其他故障总数N4 : N4个其他故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int otherFailuresTotalCount = -2;

  /**
   * 其他故障代码列表 : 厂商自行定义，故障个数等于故障总数N4。
   */
  private List<String> otherFailuresCodeList = new ArrayList<String>();

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

  public void setRechargeableStorageDeviceFailuresTotalCount(
      int rechargeableStorageDeviceFailuresTotalCount) {
    this.rechargeableStorageDeviceFailuresTotalCount = rechargeableStorageDeviceFailuresTotalCount;
  }

  public List<String> getRechargeableStorageDeviceFailuresCodeList() {
    return rechargeableStorageDeviceFailuresCodeList;
  }

  public void setRechargeableStorageDeviceFailuresCodeList(
      List<String> rechargeableStorageDeviceFailuresCodeList) {
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


  public int getHighestAlarmLevelString(int highestAlarmLevel) {
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

  public int getTotalNumberString(int value) {
    switch (value) {
      case 0xFE:
        return -1;//"异常";
      case 0xFF:
        return -2;//"无效";
      default:
        return value;
    }
  }

  public String getGeneralAlarmFlagString(int generalAlarmFlag) {
    if (generalAlarmFlag == 0) {
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

  public String getRechargeableEnergyStorageDeviceFailuresCodeListString() {
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

  public String getEngineFailuresCodeListString() {
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

  public String getDriveMotorFailuresCodeListString() {
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

  public String getOtherFailuresCodeListString() {
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