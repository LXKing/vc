package com.ccclubs.phoenix.orm.model;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/9
 * @Time: 14:13
 * @Description: 请填写描述！
 */

public class TransforCarStateToVehicleState {

    public static VehicleState transforCarStateToVehicleState(CarState carState){
        VehicleState vehicleState=new VehicleState();
        vehicleState.setAccess(carState.getCs_access());
        vehicleState.setAddTime(carState.getAdd_time());
        vehicleState.setAutopilotStatus(carState.getAutopilot_status());
        vehicleState.setBaseCi(carState.getBase_ci());
        vehicleState.setBaseLac(carState.getBase_lac());
        vehicleState.setChargingStatus(carState.getCharging_status());
        vehicleState.setCircularMode(carState.getCircular_mode());
        vehicleState.setCompreStatus(carState.getCompre_status());
        vehicleState.setCurOrder(carState.getCur_order());
        vehicleState.setCurrentTime(carState.getCurrent_time());
        vehicleState.setDirectionAngle(carState.getDirection_angle());
        vehicleState.setDoorStatus(carState.getDoor_status());
        vehicleState.setElecMiles(carState.getElec_miles());
        vehicleState.setEndurMiles(carState.getEndur_miles());
        vehicleState.setEngineStatus(carState.getEngine_status());
        vehicleState.setEngineTempe(carState.getEngine_tempe());
        vehicleState.setEvBattery(carState.getEv_battery());
        vehicleState.setFanMode(carState.getFan_mode());
        vehicleState.setFuelMiles(carState.getFuel_miles());
        vehicleState.setGear(carState.getGear());
        vehicleState.setGpsNum(carState.getGps_num());
        vehicleState.setGpsStrength(carState.getGps_strength());
        vehicleState.setGpsValid(carState.getGps_valid());
        vehicleState.setHandbrakeStatus(carState.getHandbrake_status());
        vehicleState.setKeyStatus(carState.getKey_status());
        vehicleState.setLatitude(carState.getLatitude());
        vehicleState.setLightStatus(carState.getLight_status());
        vehicleState.setLockStatus(carState.getLock_status());
        vehicleState.setLongitude(carState.getLongitude());
        vehicleState.setMotorSpeed(carState.getMotor_speed());
        vehicleState.setNetStrength(carState.getNet_strength());
        vehicleState.setNetType(carState.getNet_type());
        vehicleState.setObdMiles(carState.getObd_miles());
        vehicleState.setOilCost(carState.getOil_cost());
        vehicleState.setPowerReserve(carState.getPower_reserve());
        vehicleState.setPtcStatus(carState.getPtc_status());
        vehicleState.setRentFlg(carState.getRent_flg());
        vehicleState.setRfid(carState.getRfid());
        vehicleState.setSavingMode(carState.getSaving_mode());
        vehicleState.setSpeed(carState.getSpeed());
        vehicleState.setTempe(carState.getTempe());
        vehicleState.setTeNumber(carState.getCs_number());
        vehicleState.setTotalMiles(carState.getTotal_miles());
        vehicleState.setUserRfid(carState.getUser_rfid());
        vehicleState.setVin(carState.getCs_vin());
        vehicleState.setWarnCode(carState.getWarn_code());
        return vehicleState;
    }

}
