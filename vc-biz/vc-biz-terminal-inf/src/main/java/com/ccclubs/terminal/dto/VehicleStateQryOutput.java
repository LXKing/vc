package com.ccclubs.terminal.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 车辆状态数据
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
public class VehicleStateQryOutput implements java.io.Serializable{

    private String cssVin;//车架号

    private String cssTeNo;//终端序列号

    private Date cssCurrentTime;//下位机时间

    private String cssRented;//租赁状态

    private BigDecimal cssObdMile;//OBD里程，单位0.1km

    private BigDecimal cssEngineT;//发动机温度，单位℃

    private BigDecimal cssSpeed;//车速，单位km/h

    private Integer cssMotor;//转速，单位r/min

    private BigDecimal cssOil;//燃油量，单位L

    private Integer cssPower;//蓄电量，单位10mV

    private Byte cssEvBattery;//动力电池电，单位1%

    private Byte cssCharging;//在充电(0：未充电或无效，1：慢充，2：快充)

    private BigDecimal cssEndurance;//续航里程，单位km

    private BigDecimal cssTemperature;//车内温度【仅供参考】，单位℃

    private Short cssCsq;//信号强度

    private BigDecimal cssLongitude;//经度【小数6位】

    private BigDecimal cssLatitude;//纬度【小数6位】

    private Byte cssGpsValid;// GPS有效位
    private Short cssGpsCn;//  GPS CN值
    private Short cssGpsCount;// GPS可视卫星数量

    private BigDecimal cssDir;//方向角度

    private Byte cssCircular;//循环模式，（0:内循环 1:外循环）

    private Byte cssPtc;//PTC启停，（0:OFF 1:ON）

    private Byte cssCompres;//压缩机，（0:OFF 1:ON）

    private Byte cssFan;//档风量，（0:OFF 1:1档 2:2档 3:3档 4:4档）

    private Long cssOrder;//当前订单

    private Integer cssBaseLac; // 基站信号 LAC 值
    private Integer cssBaseCi;//  基站信号 CI值

    private Byte cssSaving;//省电模式，（0:标准模式 1:最佳省电 2:极度省电）

    private Byte cssEngine;//车门状态共两个字节，高字节代表车门MASK，详见表A，低字节代表车门开关状态

    private String cssDoor;//车门状态共两个字节，高字节代表车门MASK，详见表A，低字节代表车门开关状态

    private Integer cssLight;//灯状态，共四个字节，高双字节代表灯MASK，详见表C，低双字节代表灯开关状态

    private Integer cssLock;//门锁状态，共两个字节，高字节代表车门MASK，详见表E，低字节代表车门开关状态

    private Byte cssGear;//0：空挡；1：1挡；2：2挡；3：3挡；...13：倒挡；14：自动D挡；15：停车P挡

    private Byte cssHandbrake;//手刹状态0x0=所有刹车释放；0x1=所有刹车应用；0x2=所有刹车不工作（应用或释放中）；0x3=未知；

    private Integer cssAutopilot;//自动驾驶状态

    private Byte cssKey;//钥匙状态

    /**
     * 车辆启动控制状态
     * */
    private Integer controlStatus;

    /**
     * 车辆自身经度
     */
    private BigDecimal acuLongitude;

    /**
     * 车辆自身纬度
     */
    private BigDecimal acuLatitude;

    /**
     * 车辆状态-自动行驶当前状态
     */
    private Byte acuVehicleAdState;

    /**
     * 车辆启动控制方式-自动行驶当前车机指令状态
     */
    private Byte vrtVehicleStart;

    /**
     * 订单里程
     */
    BigDecimal tradeMiles;
    /**
     * 订单状态
     */
    Integer tradeStatus;
    /**
     * 订单开始时间
     */
    Integer tradeStartTime;
    /**
     * 订单结束时间
     */
    Integer tradeEndTime;
    /**
     * 初始化业务订单RFID号
     */
    String tradeInitCard;
    /**
     * 业务订单RFID号
     */
    String tradeTakeCard;
    /**
     * GPS辅助定位，经度平均值
     */
    private BigDecimal cssLongitudeAvg;
    /**
     * GPS辅助定位，纬度平均值
     */
    private BigDecimal cssLatitudeAvg;
    /**
     * GPS辅助定位，经度最大值
     */
    private BigDecimal cssLongitudeMax;
    /**
     * GPS辅助定位，纬度最大值
     */
    private BigDecimal cssLatitudeMax;
    /**
     * GPS辅助定位，经度最小值
     */
    private BigDecimal cssLongitudeMin;
    /**
     * GPS辅助定位，纬度最小值
     */
    private BigDecimal cssLatitudeMin;

    public BigDecimal getCssLongitudeAvg() {
        return cssLongitudeAvg;
    }

    public void setCssLongitudeAvg(BigDecimal cssLongitudeAvg) {
        this.cssLongitudeAvg = cssLongitudeAvg;
    }

    public BigDecimal getCssLatitudeAvg() {
        return cssLatitudeAvg;
    }

    public void setCssLatitudeAvg(BigDecimal cssLatitudeAvg) {
        this.cssLatitudeAvg = cssLatitudeAvg;
    }

    public BigDecimal getCssLongitudeMax() {
        return cssLongitudeMax;
    }

    public void setCssLongitudeMax(BigDecimal cssLongitudeMax) {
        this.cssLongitudeMax = cssLongitudeMax;
    }

    public BigDecimal getCssLatitudeMax() {
        return cssLatitudeMax;
    }

    public void setCssLatitudeMax(BigDecimal cssLatitudeMax) {
        this.cssLatitudeMax = cssLatitudeMax;
    }

    public BigDecimal getCssLongitudeMin() {
        return cssLongitudeMin;
    }

    public void setCssLongitudeMin(BigDecimal cssLongitudeMin) {
        this.cssLongitudeMin = cssLongitudeMin;
    }

    public BigDecimal getCssLatitudeMin() {
        return cssLatitudeMin;
    }

    public void setCssLatitudeMin(BigDecimal cssLatitudeMin) {
        this.cssLatitudeMin = cssLatitudeMin;
    }

    public BigDecimal getTradeMiles() {
        return tradeMiles;
    }

    public void setTradeMiles(BigDecimal tradeMiles) {
        this.tradeMiles = tradeMiles;
    }

    public Integer getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Integer tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public Integer getTradeStartTime() {
        return tradeStartTime;
    }

    public void setTradeStartTime(Integer tradeStartTime) {
        this.tradeStartTime = tradeStartTime;
    }

    public Integer getTradeEndTime() {
        return tradeEndTime;
    }

    public void setTradeEndTime(Integer tradeEndTime) {
        this.tradeEndTime = tradeEndTime;
    }

    public String getTradeInitCard() {
        return tradeInitCard;
    }

    public void setTradeInitCard(String tradeInitCard) {
        this.tradeInitCard = tradeInitCard;
    }

    public String getTradeTakeCard() {
        return tradeTakeCard;
    }

    public void setTradeTakeCard(String tradeTakeCard) {
        this.tradeTakeCard = tradeTakeCard;
    }

    public Integer getControlStatus() {
        return controlStatus;
    }

    public void setControlStatus(Integer controlStatus) {
        this.controlStatus = controlStatus;
    }

    public BigDecimal getAcuLongitude() {
        return acuLongitude;
    }

    public void setAcuLongitude(BigDecimal acuLongitude) {
        this.acuLongitude = acuLongitude;
    }

    public BigDecimal getAcuLatitude() {
        return acuLatitude;
    }

    public void setAcuLatitude(BigDecimal acuLatitude) {
        this.acuLatitude = acuLatitude;
    }

    public Byte getAcuVehicleAdState() {
        return acuVehicleAdState;
    }

    public void setAcuVehicleAdState(Byte acuVehicleAdState) {
        this.acuVehicleAdState = acuVehicleAdState;
    }

    public Byte getVrtVehicleStart() {
        return vrtVehicleStart;
    }

    public void setVrtVehicleStart(Byte vrtVehicleStart) {
        this.vrtVehicleStart = vrtVehicleStart;
    }

    public Long getCssOrder() {
        return cssOrder;
    }

    public void setCssOrder(Long cssOrder) {
        this.cssOrder = cssOrder;
    }

    public Byte getCssKey() {
        return cssKey;
    }

    public void setCssKey(Byte cssKey) {
        this.cssKey = cssKey;
    }


    public Byte getCssGpsValid() {
        return cssGpsValid;
    }

    public void setCssGpsValid(Byte cssGpsValid) {
        this.cssGpsValid = cssGpsValid;
    }

    public Short getCssGpsCn() {
        return cssGpsCn;
    }

    public void setCssGpsCn(Short cssGpsCn) {
        this.cssGpsCn = cssGpsCn;
    }

    public Short getCssGpsCount() {
        return cssGpsCount;
    }

    public void setCssGpsCount(Short cssGpsCount) {
        this.cssGpsCount = cssGpsCount;
    }

    public Integer getCssBaseLac() {
        return cssBaseLac;
    }

    public void setCssBaseLac(Integer cssBaseLac) {
        this.cssBaseLac = cssBaseLac;
    }

    public Integer getCssBaseCi() {
        return cssBaseCi;
    }

    public void setCssBaseCi(Integer cssBaseCi) {
        this.cssBaseCi = cssBaseCi;
    }

    public Integer getCssAutopilot() {
        return cssAutopilot;
    }

    public void setCssAutopilot(Integer cssAutopilot) {
        this.cssAutopilot = cssAutopilot;
    }

    public String getCssTeNo() {
        return cssTeNo;
    }

    public void setCssTeNo(String cssTeNo) {
        this.cssTeNo = cssTeNo;
    }

    public Byte getCssHandbrake() {
        return cssHandbrake;
    }

    public void setCssHandbrake(Byte cssHandbrake) {
        this.cssHandbrake = cssHandbrake;
    }

    public Date getCssCurrentTime() {
        return cssCurrentTime;
    }

    public void setCssCurrentTime(Date cssCurrentTime) {
        this.cssCurrentTime = cssCurrentTime;
    }

    public String getCssRented() {
        return cssRented;
    }

    public void setCssRented(String cssRented) {
        this.cssRented = cssRented;
    }

    public Integer getCssMotor() {
        return cssMotor;
    }

    public void setCssMotor(Integer cssMotor) {
        this.cssMotor = cssMotor;
    }

    public Integer getCssPower() {
        return cssPower;
    }

    public void setCssPower(Integer cssPower) {
        this.cssPower = cssPower;
    }

    public Byte getCssEvBattery() {
        return cssEvBattery;
    }

    public void setCssEvBattery(Byte cssEvBattery) {
        this.cssEvBattery = cssEvBattery;
    }

    public Byte getCssCharging() {
        return cssCharging;
    }

    public void setCssCharging(Byte cssCharging) {
        this.cssCharging = cssCharging;
    }

    public BigDecimal getCssObdMile() {
        return cssObdMile;
    }

    public void setCssObdMile(BigDecimal cssObdMile) {
        this.cssObdMile = cssObdMile;
    }

    public BigDecimal getCssEngineT() {
        return cssEngineT;
    }

    public void setCssEngineT(BigDecimal cssEngineT) {
        this.cssEngineT = cssEngineT;
    }

    public BigDecimal getCssSpeed() {
        return cssSpeed;
    }

    public void setCssSpeed(BigDecimal cssSpeed) {
        this.cssSpeed = cssSpeed;
    }

    public BigDecimal getCssOil() {
        return cssOil;
    }

    public void setCssOil(BigDecimal cssOil) {
        this.cssOil = cssOil;
    }

    public BigDecimal getCssEndurance() {
        return cssEndurance;
    }

    public void setCssEndurance(BigDecimal cssEndurance) {
        this.cssEndurance = cssEndurance;
    }

    public BigDecimal getCssTemperature() {
        return cssTemperature;
    }

    public void setCssTemperature(BigDecimal cssTemperature) {
        this.cssTemperature = cssTemperature;
    }

    public Short getCssCsq() {
        return cssCsq;
    }

    public void setCssCsq(Short cssCsq) {
        this.cssCsq = cssCsq;
    }

    public BigDecimal getCssLongitude() {
        return cssLongitude;
    }

    public void setCssLongitude(BigDecimal cssLongitude) {
        this.cssLongitude = cssLongitude;
    }

    public BigDecimal getCssLatitude() {
        return cssLatitude;
    }

    public void setCssLatitude(BigDecimal cssLatitude) {
        this.cssLatitude = cssLatitude;
    }

    public BigDecimal getCssDir() {
        return cssDir;
    }

    public void setCssDir(BigDecimal cssDir) {
        this.cssDir = cssDir;
    }

    public Byte getCssCircular() {
        return cssCircular;
    }

    public void setCssCircular(Byte cssCircular) {
        this.cssCircular = cssCircular;
    }

    public Byte getCssPtc() {
        return cssPtc;
    }

    public void setCssPtc(Byte cssPtc) {
        this.cssPtc = cssPtc;
    }

    public Byte getCssCompres() {
        return cssCompres;
    }

    public void setCssCompres(Byte cssCompres) {
        this.cssCompres = cssCompres;
    }

    public Byte getCssFan() {
        return cssFan;
    }

    public void setCssFan(Byte cssFan) {
        this.cssFan = cssFan;
    }

    public Byte getCssSaving() {
        return cssSaving;
    }

    public void setCssSaving(Byte cssSaving) {
        this.cssSaving = cssSaving;
    }

    public Byte getCssEngine() {
        return cssEngine;
    }

    public void setCssEngine(Byte cssEngine) {
        this.cssEngine = cssEngine;
    }

    public String getCssDoor() {
        return cssDoor;
    }

    public void setCssDoor(String cssDoor) {
        this.cssDoor = cssDoor;
    }

    public Integer getCssLight() {
        return cssLight;
    }

    public void setCssLight(Integer cssLight) {
        this.cssLight = cssLight;
    }

    public Integer getCssLock() {
        return cssLock;
    }

    public void setCssLock(Integer cssLock) {
        this.cssLock = cssLock;
    }

    public Byte getCssGear() {
        return cssGear;
    }

    public void setCssGear(Byte cssGear) {
        this.cssGear = cssGear;
    }

    public String getCssVin() {
        return cssVin;
    }

    public void setCssVin(String cssVin) {
        this.cssVin = cssVin;
    }
}
