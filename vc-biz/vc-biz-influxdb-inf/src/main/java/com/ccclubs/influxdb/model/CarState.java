package com.ccclubs.influxdb.model;


import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.io.Serializable;

/**
 *
 */
@Measurement(name = "INFLUXDB_CAR_STATE_HISTORY")
public class CarState implements Serializable{

    private static final long serialVersionUID = -4920229013098094437L;
    //车机号
    @Column(name = "cs_number")
    private String cs_number;

    //授权系统
    @Column(name = "cs_access")
    private String cs_access;

    //添加时间
    @Column(name = "add_time")
    private Long add_time;

    //下位机时间
    @Column(name = "time")
    private String current_time;

    @Column(name = "current_datetime")
    private Long current_datetime;

    //租赁状态
    @Column(name = "rent_flg")
    private Integer rent_flg;

    //报警代码
    @Column(name = "warn_code")
    private String warn_code;

    //RFID卡号
    @Column(name = "rfid")
    private String rfid;

    //用户RFID
    @Column(name = "user_rfid")
    private String user_rfid;

    //OBD里程
    @Column(name = "obd_miles")
    private Double obd_miles;

    //发动机温度
    @Column(name = "engine_tempe")
    private Double engine_tempe;

    //总里程
    @Column(name = "total_miles")
    private Double total_miles;

    //车速
    @Column(name = "speed")
    private Double speed;

    //转速
    @Column(name = "motor_speed")
    private Double motor_speed;

    //燃油量
    @Column(name = "oil_cost")
    private Double oil_cost;

    //蓄电量
    @Column(name = "power_reserve")
    private Double power_reserve;

    //动力电池电量
    @Column(name = "ev_battery")
    private Double ev_battery;

    //充电状态
    @Column(name = "charging_status")
    private Integer charging_status;

    //油里程
    @Column(name = "fuel_miles")
    private Double fuel_miles;

    //电量程
    @Column(name = "elec_miles")
    private Double elec_miles;

    //续航里程
    @Column(name = "endur_miles")
    private Double endur_miles;

    //温度
    @Column(name = "tempe")
    private Double tempe;

    //卫星数量
    @Column(name = "gps_num")
    private Integer gps_num;

    //卫星信号强度
    @Column(name = "gps_strength")
    private Integer gps_strength;

    //gps有效性
    @Column(name = "gps_valid")
    private Integer gps_valid;

    //网络信号强度
    @Column(name = "net_strength")
    private Integer net_strength;

    //经度
    @Column(name = "longitude")
    private Double longitude;

    //纬度
    @Column(name = "latitude")
    private Double latitude;

    //方向角度
    @Column(name = "direction_angle")
    private Double direction_angle;

    //循环模式
    @Column(name = "circular_mode")
    private Integer circular_mode;

    //PTC启停
    @Column(name = "ptc_status")
    private Integer ptc_status;

    //压缩机状态
    @Column(name = "compre_status")
    private Integer compre_status;

    //档风量
    @Column(name = "fan_mode")
    private Integer fan_mode;

    //省电模式
    @Column(name = "saving_mode")
    private Integer saving_mode;

    //省电模式 format
    @Column(name = "saving_mode_str")
    private String saving_mode_str;

    //车门状态
    @Column(name = "door_status")
    private Integer door_status;

    //发动机
    @Column(name = "engine_status")
    private Integer engine_status;

    //钥匙状态
    @Column(name = "key_status")
    private Integer key_status;

    //灯状态
    @Column(name = "light_status")
    private Integer light_status;

    //锁状态
    @Column(name = "lock_status")
    private Integer lock_status;

    //网络类型
    @Column(name = "net_type")
    private String net_type;

    //基站LAC
    @Column(name = "base_lac")
    private String base_lac;

    //基站CI
    @Column(name = "base_ci")
    private String base_ci;

    //当前订单
    @Column(name = "cur_order")
    private String cur_order;

    //档位
    @Column(name = "gear")
    private Integer gear;

    public Long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Long add_time) {
        this.add_time = add_time;
    }

    public String getCs_number() {
        return cs_number;
    }

    public void setCs_number(String cs_number) {
        this.cs_number = cs_number;
    }

    public String getCs_access() {
        return cs_access;
    }

    public void setCs_access(String cs_access) {
        this.cs_access = cs_access;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public Integer getRent_flg() {
        return rent_flg;
    }

    public void setRent_flg(Integer rent_flg) {
        this.rent_flg = rent_flg;
    }

    public String getWarn_code() {
        return warn_code;
    }

    public void setWarn_code(String warn_code) {
        this.warn_code = warn_code;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getUser_rfid() {
        return user_rfid;
    }

    public void setUser_rfid(String user_rfid) {
        this.user_rfid = user_rfid;
    }

    public Double getObd_miles() {
        return obd_miles;
    }

    public void setObd_miles(Double obd_miles) {
        this.obd_miles = obd_miles;
    }

    public Double getEngine_tempe() {
        return engine_tempe;
    }

    public void setEngine_tempe(Double engine_tempe) {
        this.engine_tempe = engine_tempe;
    }

    public Double getTotal_miles() {
        return total_miles;
    }

    public void setTotal_miles(Double total_miles) {
        this.total_miles = total_miles;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getMotor_speed() {
        return motor_speed;
    }

    public void setMotor_speed(Double motor_speed) {
        this.motor_speed = motor_speed;
    }

    public Double getOil_cost() {
        return oil_cost;
    }

    public void setOil_cost(Double oil_cost) {
        this.oil_cost = oil_cost;
    }

    public Double getPower_reserve() {
        return power_reserve;
    }

    public void setPower_reserve(Double power_reserve) {
        this.power_reserve = power_reserve;
    }

    public Double getEv_battery() {
        return ev_battery;
    }

    public void setEv_battery(Double ev_battery) {
        this.ev_battery = ev_battery;
    }

    public Integer getCharging_status() {
        return charging_status;
    }

    public void setCharging_status(Integer charging_status) {
        this.charging_status = charging_status;
    }

    public Double getFuel_miles() {
        return fuel_miles;
    }

    public void setFuel_miles(Double fuel_miles) {
        this.fuel_miles = fuel_miles;
    }

    public Double getElec_miles() {
        return elec_miles;
    }

    public void setElec_miles(Double elec_miles) {
        this.elec_miles = elec_miles;
    }

    public Double getEndur_miles() {
        return endur_miles;
    }

    public void setEndur_miles(Double endur_miles) {
        this.endur_miles = endur_miles;
    }

    public Double getTempe() {
        return tempe;
    }

    public void setTempe(Double tempe) {
        this.tempe = tempe;
    }

    public Integer getNet_strength() {
        return net_strength;
    }

    public void setNet_strength(Integer net_strength) {
        this.net_strength = net_strength;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getDirection_angle() {
        return direction_angle;
    }

    public void setDirection_angle(Double direction_angle) {
        this.direction_angle = direction_angle;
    }

    public Integer getCircular_mode() {
        return circular_mode;
    }

    public void setCircular_mode(Integer circular_mode) {
        this.circular_mode = circular_mode;
    }

    public Integer getPtc_status() {
        return ptc_status;
    }

    public void setPtc_status(Integer ptc_status) {
        this.ptc_status = ptc_status;
    }

    public Integer getCompre_status() {
        return compre_status;
    }

    public void setCompre_status(Integer compre_status) {
        this.compre_status = compre_status;
    }

    public Integer getFan_mode() {
        return fan_mode;
    }

    public void setFan_mode(Integer fan_mode) {
        this.fan_mode = fan_mode;
    }

    public Integer getSaving_mode() {
        return saving_mode;
    }

    public void setSaving_mode(Integer saving_mode) {
        this.saving_mode = saving_mode;
    }

    public Integer getDoor_status() {
        return door_status;
    }

    public void setDoor_status(Integer door_status) {
        this.door_status = door_status;
    }

    public Integer getEngine_status() {
        return engine_status;
    }

    public void setEngine_status(Integer engine_status) {
        this.engine_status = engine_status;
    }

    public Integer getKey_status() {
        return key_status;
    }

    public void setKey_status(Integer key_status) {
        this.key_status = key_status;
    }

    public Integer getLight_status() {
        return light_status;
    }

    public void setLight_status(Integer light_status) {
        this.light_status = light_status;
    }

    public Integer getLock_status() {
        return lock_status;
    }

    public void setLock_status(Integer lock_status) {
        this.lock_status = lock_status;
    }

    public String getNet_type() {
        return net_type;
    }

    public void setNet_type(String net_type) {
        this.net_type = net_type;
    }

    public String getBase_lac() {
        return base_lac;
    }

    public void setBase_lac(String base_lac) {
        this.base_lac = base_lac;
    }

    public String getBase_ci() {
        return base_ci;
    }

    public void setBase_ci(String base_ci) {
        this.base_ci = base_ci;
    }

    public String getCur_order() {
        return cur_order;
    }

    public void setCur_order(String cur_order) {
        this.cur_order = cur_order;
    }

    public Integer getGps_num() {
        return gps_num;
    }

    public void setGps_num(Integer gps_num) {
        this.gps_num = gps_num;
    }

    public Integer getGps_strength() {
        return gps_strength;
    }

    public void setGps_strength(Integer gps_strength) {
        this.gps_strength = gps_strength;
    }

    public Integer getGps_valid() {
        return gps_valid;
    }

    public void setGps_valid(Integer gps_valid) {
        this.gps_valid = gps_valid;
    }

    public String getSaving_mode_str() {
        return saving_mode_str;
    }

    public void setSaving_mode_str(String saving_mode_str) {
        this.saving_mode_str = saving_mode_str;
    }

    public Long getCurrent_datetime() {
        return current_datetime;
    }

    public void setCurrent_datetime(Long current_datetime) {
        this.current_datetime = current_datetime;
    }

    public Integer getGear() {
        return gear;
    }

    public void setGear(Integer gear) {
        this.gear = gear;
    }

    @Override
    public String toString() {
        return "CarState{" +
                "cs_number='" + cs_number + '\'' +
                ", cs_access=" + cs_access +
                ", add_time=" + add_time +
                ", current_time=" + current_time +
                ", current_datetime='" + current_datetime + '\'' +
                ", rent_flg=" + rent_flg +
                ", warn_code='" + warn_code + '\'' +
                ", rfid='" + rfid + '\'' +
                ", user_rfid='" + user_rfid + '\'' +
                ", obd_miles=" + obd_miles +
                ", engine_tempe=" + engine_tempe +
                ", total_miles=" + total_miles +
                ", speed=" + speed +
                ", motor_speed=" + motor_speed +
                ", oil_cost=" + oil_cost +
                ", power_reserve=" + power_reserve +
                ", ev_battery=" + ev_battery +
                ", charging_status=" + charging_status +
                ", fuel_miles=" + fuel_miles +
                ", elec_miles=" + elec_miles +
                ", endur_miles=" + endur_miles +
                ", tempe=" + tempe +
                ", gps_num=" + gps_num +
                ", gps_strength=" + gps_strength +
                ", gps_valid=" + gps_valid +
                ", net_strength=" + net_strength +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", direction_angle=" + direction_angle +
                ", circular_mode=" + circular_mode +
                ", ptc_status=" + ptc_status +
                ", compre_status=" + compre_status +
                ", fan_mode=" + fan_mode +
                ", saving_mode=" + saving_mode +
                ", saving_mode_str='" + saving_mode_str + '\'' +
                ", door_status=" + door_status +
                ", engine_status=" + engine_status +
                ", key_status=" + key_status +
                ", light_status=" + light_status +
                ", lock_status=" + lock_status +
                ", net_type='" + net_type + '\'' +
                ", base_lac='" + base_lac + '\'' +
                ", base_ci='" + base_ci + '\'' +
                ", cur_order='" + cur_order + '\'' +
                ", gear=" + gear +
                '}';
    }
}
