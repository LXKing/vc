package com.ccclubs.protocol.protocolmodel.convert;


import com.alibaba.fastjson.JSON;
import com.ccclubs.protocol.protocolmodel.evnet.EV_69_can_item;

import java.util.List;

/**
 *  EVnet 状态，报警数据转换为gb中格式数据
 */
public class CanGBVehicle {



    public static String getCan_gb(List<EV_69_can_item> canItemsList ) {

        VehicleRealData vehicleRealData =new VehicleRealData();
        GB_02 gb_02 = new GB_02();

        //整车数据
        GB_02_01 gb_02_01 = new GB_02_01();
        //驱动电机数据
        GB_02_02 gb_02_02 = new GB_02_02();
        GB_02_02_Item gb_02_02_item=new GB_02_02_Item();
        // 燃料电池数据
        GB_02_03 gb_02_03= new GB_02_03();
        //发动机数据
        GB_02_04 gb_02_04 = new GB_02_04();
        //车辆位置数据
        GB_02_05 gb_02_05 = new GB_02_05();
        //极值数据
        GB_02_06 gb_02_06 = new GB_02_06();
        //报警数据
        GB_02_07 gb_02_07 = new GB_02_07();


        for (EV_69_can_item can_item : canItemsList) {

            switch (can_item.getCanId()) {

                case 0x0300:
                    //
                    float speed=gb_02_01.getSpeedString( can_item.getmCanData2()&0xff);
                    gb_02_01.setSpeed(speed);//车速
                    //
                    int dcDcStatus=gb_02_01.getDcDcStatusString( (can_item.getmCanData1() >>3 )&0x1);
                    gb_02_01.setDcDcStatus(dcDcStatus);//DC-DC状态
                    //
                    String gear=gb_02_01.getGearString( can_item.getmCanData1()&0x7);
                    gb_02_01.setGear(gear);//挡位信息
                    //
                    int driveMotorStatus=gb_02_02_item.getDriveMotorStatusString(can_item.getmCanData1() & 0x7);
                    gb_02_02_item.setDriveMotorStatus(driveMotorStatus);//驱动电机状态--以刚哥为准
                    break;

                case 0x0301:
                    //
                    int driveMotorControllerTemperature= gb_02_02_item.getDriveMotorControllerTemperatureString(can_item.getmCanData7()&0xff );
                    gb_02_02_item.setDriveMotorControllerTemperature(driveMotorControllerTemperature);//驱动电机控制器温度
                    //
                    int driveMotorSpeed=gb_02_02_item.getDriveMotorSpeedString(  (can_item.getmCanData1()&0xff)*256+ (can_item.getmCanData2()&0xff)  );
                    gb_02_02_item.setDriveMotorSpeed( driveMotorSpeed );//驱动电机转速
                    //
                    int value=  gb_02_02_item.getDriveMotorTemperatureString( (can_item.getmCanData5()&0xff)*256+ (can_item.getmCanData6()&0xff) );
                    gb_02_02_item.setDriveMotorTemperature(value);//驱动电机温度
                    break;
                //
                case 0x0302:
                    //
                    float totalVoltageValue=gb_02_01.getTotalVoltageString((can_item.getmCanData1()&0xff)*256+ (can_item.getmCanData2()&0xff));
                    gb_02_01.setTotalVoltage( totalVoltageValue );//总电压
                    //
                    float totalCurrentValue=gb_02_01.getTotalCurrentString((can_item.getmCanData3()&0xff)*256+ (can_item.getmCanData4()&0xff));
                    gb_02_01.setTotalCurrent(totalCurrentValue);//总电流
                    //
                    int socValue=gb_02_01.getSocString(can_item.getmCanData5()&0xff );
                    gb_02_01.setSoc(socValue );//soc
                    //
                    int  highestVoltageBatterySinzhugleModuleNoValue=gb_02_06.getDataString(can_item.getmCanData8()&0xff);
                    gb_02_06.setHighestVoltageBatterySingleModuleNo(highestVoltageBatterySinzhugleModuleNoValue);//最高电压电池单体代号不用zhu
                    //
                    float batterySingleVoltageHighestValue=gb_02_06.getBatterySingleVoltageHighestValueString((can_item.getmCanData6()& 0xff) * 256 + (can_item.getmCanData7() & 0xff));
                    gb_02_06.setBatterySingleVoltageHighestValue(batterySingleVoltageHighestValue);//电池单体电压最高值
                    //
                    int motorControllerInputVoltage=gb_02_02_item.getMotorControllerInputVoltageString( (can_item.getmCanData1()&0xff)*256 + (can_item.getmCanData2()&0xff));
                    gb_02_02_item.setMotorControllerInputVoltage(motorControllerInputVoltage );//以刚哥的为准 //电机控制器输入电压
                    //
                    float motorControllerDCBusCurrentValue=gb_02_02_item.getMotorControllerDCBusCurrentString((can_item.getmCanData3()&0xff) * 256 + (can_item.getmCanData4()&0xff));
                    gb_02_02_item.setMotorControllerDCBusCurrent(motorControllerDCBusCurrentValue);////以刚哥的为准 //电机控制器直流母线电流
                    break;
                //
                case 0x0303:
                    //
                    int  LowestVoltageBatterySingleModuleNo=gb_02_06.getDataString(can_item.getmCanData3()&0xff);
                    gb_02_06.setLowestVoltageBatterySingleModuleNo(LowestVoltageBatterySingleModuleNo); //最低电压电池单体代号
                    //
                    float batterySingleVoltageLowestValue=gb_02_06.getBatterySingleVoltageLowestValueString((can_item.getmCanData1()&0xff)*256+ (can_item.getmCanData2()&0xff));
                    gb_02_06.setBatterySingleVoltageLowestValue( batterySingleVoltageLowestValue );//电池单体电压最低值
                    //
                    int highestTemperatureProbeSingleNo=gb_02_06.getDataString(can_item.getmCanData5()&0xff)  ;
                    gb_02_06.setHighestTemperatureProbeSingleNo(highestTemperatureProbeSingleNo); //最高温度探针单体代号
                    //
                    int highestTemperatureValue=gb_02_06.getHighestTemperatureValueString(can_item.getmCanData4()&0xff);
                    gb_02_06.setHighestTemperatureValue(highestTemperatureValue);//最高温度值
                    //
                    int lowestTemperatureProbeSubsystemNo=gb_02_06.getDataString(can_item.getmCanData7()&0xff);
                    gb_02_06.setLowestTemperatureProbeSubsystemNo(lowestTemperatureProbeSubsystemNo);//最低温度探针子系统代号
                    //
                    int lowestTemperatureValue= gb_02_06.getLowestTemperatureValueString(can_item.getmCanData6());
                    gb_02_06.setLowestTemperatureValue(lowestTemperatureValue);//最低温度值
                    break;

                case 0x0304:
                    //
                    int chargeStatus=gb_02_01.getChargeStatusString((can_item.getmCanData1()>>6)&0x3 );
                    gb_02_01.setChargeStatus(chargeStatus);//充电状态
                    break;

                //
                case 0x0308:
//                    (can_item.getmCanData6()&0x00FF)
//                    LZ.digit(    (   (this.mCanData5 & 0xff) * 256 + (this.mCanData6 & 0xff)   )* 0.1,   2)
//                    int ll=   (can_item.getmCanData5()&0xff)*256+(can_item.getmCanData6()&0xff);

                    int insulationResistance= gb_02_01.getInsulationResistanceString( (  (can_item.getmCanData5()&0xff)*256+(can_item.getmCanData6()&0xff)  )  &0xffff );
                    gb_02_01.setInsulationResistance(insulationResistance );//绝缘电阻

                    break;

                case 0x0311:
                    //
                    int driveMotorTorque= gb_02_02_item.getDriveMotorTorqueString((can_item.getmCanData1()&0xff)*256+ (can_item.getmCanData2()&0xff));
                    gb_02_02_item.setDriveMotorTorque( driveMotorTorque );//驱动电机转矩
                    break;

                //
                case 0x0380:
                    //
                    float accumulatedMileage =gb_02_01.getAccumulatedMileageString( (can_item.getmCanData3()&0xff)*256*256+  (can_item.getmCanData4()&0xff)*256+ (can_item.getmCanData5()&0xff));
                    gb_02_01.setAccumulatedMileage(accumulatedMileage );//累计里程
                    break;
                //


                case 0x0400:    //canId待定
                    //
                    int vechicleStaus=gb_02_01.getVechicleStatusString((can_item.getmCanData4()>>3)&0x3);
                    gb_02_01.setVehicleStatus(vechicleStaus );//车辆状态  ---以刚哥为准------
                    break;
            }

        }


        //
        gb_02_02.setDriveMotorCount(1);//发动机个数---无对应canID --默认1
        gb_02_02_item.setDriveMotorSerial(1);//驱动电机序号---无对应canID---默认1


        //燃料电池数据 （全部没有 GB_02_03）
        gb_02_03.setFuelCellVoltage(-2);//燃料电池电压
        gb_02_03.setFuelCellCurrent(-2);//燃料电池电流
        gb_02_03.setFuelConsumptionRate(-2);//燃料消耗率
        gb_02_03.setFuelCellTemperatureProbeCount(-2);//燃料电池温度探针总数
        gb_02_03.setHydrogenMaxTemperature(-2);//氢系统中最高温度
//        gb_02_03.setProbeTemperature();//探针温度值
        gb_02_03.setHydrogenMaxPressure(-2);//氢系统中最高压力
        gb_02_03.setHydrogenMaxTemperatureProbeNo(-2);//氢系统中最高温度探针代号
        gb_02_03.setHydrogenMaxConcentration(-2);//氢气最高浓度
        gb_02_03.setHydrogenMaxConcentrationSensorNo(-2); //氢气最高浓度传感器代号
        gb_02_03.setHydrogenMaxPressure(-2); //氢气最高压力
        gb_02_03.setHydrogenMaxPressureSensorNo(-2);// 氢气最高压力传感器代号
        gb_02_03.setHighvoltageDCDCStatus(-2);//高压DC/DC状态
//
        ///发动机数据（全部无 GB_02_04）
        gb_02_04.setEngineStatus(-2);//发动机状态
        gb_02_04.setCrankshaftSpeed(-2);//曲轴转速
        gb_02_04.setFuelConsumptionRate(-2);//燃料消耗率
//
        //车辆位置数据(全部无 gb_02_05)
//        gb_02_05.setPositionStatus(0);//定位状态
//        gb_02_05.setLongitude(0);//经度
//        gb_02_05.setLatitude(0);//维度
//
        gb_02_06.setHighestVoltageBatterySubsystemNo(1);  // 最高电压电池子系统号 默认1
        gb_02_06.setLowestVoltageBatterySubsystemNo(1);//最低电压电池子系统号 默认E200=1
        gb_02_06.setHighestTemperatureSubsystemNo(1);//最高温度子系统号 默认E200=1
        gb_02_06.setLowestTemperatureSubsystemNo(1);  //最低温度子系统号 默认E200=1
//

        //报警数据(全部无 GB_02_07）
//        gb_02_07.setHighestAlarmLevel(0);//最高报警等级
//        gb_02_07.setGeneralAlarmFlag("");//通用报警标志
//        gb_02_07.setRechargeableStorageDeviceFailuresTotalCount(0); //可充电储能装置故障总数
//        gb_02_07.setRechargeableStorageDeviceFailuresCodeList(null);//可充电储能装置故障代码列表
//        gb_02_07.setDriveMotorFailureTotalCount(0); //驱动电机故障总数
//        gb_02_07.setDriveMotorFailuresCodeList(null);//驱动电机故障代码列表
//        gb_02_07.setEngineFailuresTotalCount(0);//发动机故障总数
//        gb_02_07.setEngineFailuresCodeList(null);//发动机故障列表
//        gb_02_07.setOtherFailuresTotalCount(0);//其它故障总数
//        gb_02_07.setOtherFailuresCodeList(null);//其它故障代码列表
//

///==================

        gb_02.setVehicleData(gb_02_01);
        //
        gb_02_02.getDriveMotorList().add(gb_02_02_item);
        gb_02.setDriveMotorData(gb_02_02);
        //
        gb_02.setFuelCellData(gb_02_03);//燃料电池数据
        //
        gb_02.setEngineData(gb_02_04);//发动机数据
        //
        gb_02.setVehicleLocationData(gb_02_05);//车辆位置数据
        //
        gb_02.setExtremumData(gb_02_06);
        //
        gb_02.setAlarmData(gb_02_07);//报警数据
        //
        vehicleRealData.setVehicleRealData(gb_02);

        String jsonString= JSON.toJSONString(vehicleRealData);
        //
        return jsonString;
    }

}
