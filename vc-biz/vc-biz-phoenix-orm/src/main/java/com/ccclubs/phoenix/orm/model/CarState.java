package com.ccclubs.phoenix.orm.model;


/**
 * Created by taosm on 2017/9/5 0005.
 */
public class CarState {
    //车机号
    private String cs_number;
    //private String cs_vin;

    //授权系统
    private Integer cs_access;
    //添加时间
    private Long add_time;
    //下位机时间
    private Long current_time;

    private String current_datetime;
    //租赁状态
    private Integer rent_flg;
    //报警代码
    private String warn_code;
    //RFID卡号
    private String rfid;
    //用户RFID
    private String user_rfid;
    //OBD里程
    private Float obd_miles;
    //发动机温度
    private Float engine_tempe;
    //总里程
    private Float total_miles;
    //车速
    private Float speed;
    //转速
    private Float motor_speed;
    //燃油量
    private Float oil_cost;
    //蓄电量
    private Float power_reserve;
    //动力电池电量
    private Float ev_battery;
    //充电状态
    private Integer charging_status;
    //油里程
    private Float fuel_miles;
    //电量程
    private Float elec_miles;
    //续航里程
    private Float endur_miles;
    //温度
    private Float tempe;
    //卫星数量
    private Integer gps_num;
    //卫星信号强度
    private Integer gps_strength;
    //gps有效性
    private Integer gps_valid;
    //网络信号强度
    private Integer net_strength;
    //经度
    private Double longitude;
    //纬度
    private Double latitude;
    //方向角度
    private Float direction_angle;
    //循环模式
    private Integer circular_mode;
    //PTC启停
    private Integer ptc_status;
    //压缩机状态
    private Integer compre_status;
    //档风量
    private Integer fan_mode;
    //省电模式
    private Integer saving_mode;
    //省电模式 format
    private String saving_mode_str;
    //车门状态
    private Integer door_status;
    //发动机
    private Integer engine_status;
    //钥匙状态
    private Integer key_status;
    //灯状态
    private Integer light_status;
    //锁状态
    private Integer lock_status;
    //网络类型
    private String net_type;
    //基站LAC
    private String base_lac;
    //基站CI
    private String base_ci;
    //当前订单
    private String cur_order;

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

    public Integer getCs_access() {
        return cs_access;
    }

    public void setCs_access(Integer cs_access) {
        this.cs_access = cs_access;
    }

    public Long getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(Long current_time) {
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

    public Float getObd_miles() {
        return obd_miles;
    }

    public void setObd_miles(Float obd_miles) {
        this.obd_miles = obd_miles;
    }

    public Float getEngine_tempe() {
        return engine_tempe;
    }

    public void setEngine_tempe(Float engine_tempe) {
        this.engine_tempe = engine_tempe;
    }

    public Float getTotal_miles() {
        return total_miles;
    }

    public void setTotal_miles(Float total_miles) {
        this.total_miles = total_miles;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Float getMotor_speed() {
        return motor_speed;
    }

    public void setMotor_speed(Float motor_speed) {
        this.motor_speed = motor_speed;
    }

    public Float getOil_cost() {
        return oil_cost;
    }

    public void setOil_cost(Float oil_cost) {
        this.oil_cost = oil_cost;
    }

    public Float getPower_reserve() {
        return power_reserve;
    }

    public void setPower_reserve(Float power_reserve) {
        this.power_reserve = power_reserve;
    }

    public Float getEv_battery() {
        return ev_battery;
    }

    public void setEv_battery(Float ev_battery) {
        this.ev_battery = ev_battery;
    }

    public Integer getCharging_status() {
        return charging_status;
    }

    public void setCharging_status(Integer charging_status) {
        this.charging_status = charging_status;
    }

    public Float getFuel_miles() {
        return fuel_miles;
    }

    public void setFuel_miles(Float fuel_miles) {
        this.fuel_miles = fuel_miles;
    }

    public Float getElec_miles() {
        return elec_miles;
    }

    public void setElec_miles(Float elec_miles) {
        this.elec_miles = elec_miles;
    }

    public Float getEndur_miles() {
        return endur_miles;
    }

    public void setEndur_miles(Float endur_miles) {
        this.endur_miles = endur_miles;
    }

    public Float getTempe() {
        return tempe;
    }

    public void setTempe(Float tempe) {
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

    public Float getDirection_angle() {
        return direction_angle;
    }

    public void setDirection_angle(Float direction_angle) {
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


    public String getCurrent_datetime() {
        return current_datetime;
    }

    public void setCurrent_datetime(String current_datetime) {
        this.current_datetime = current_datetime;
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
                '}';
    }
}
