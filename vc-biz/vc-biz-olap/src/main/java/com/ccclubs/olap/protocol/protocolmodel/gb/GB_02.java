package com.ccclubs.olap.protocol.protocolmodel.gb;
/**
 * Created by admin on 2017/7/4.
 */
public class GB_02 {

    //整车数据
    private GB_02_01 vehicleData=new GB_02_01();

    //驱动电机数据
    private  GB_02_02 driveMotorData=new GB_02_02();

    //燃料电池数据
    private  GB_02_03 fuelCellData=new GB_02_03();

    //发动机数据
    private GB_02_04 engineData=new GB_02_04();

    //车辆位置数据
    private  GB_02_05 vehicleLocationData=new GB_02_05();

    //极值数据
    private GB_02_06 extremumData=new GB_02_06();

    //报警数据
    private  GB_02_07 alarmData=new GB_02_07();

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
