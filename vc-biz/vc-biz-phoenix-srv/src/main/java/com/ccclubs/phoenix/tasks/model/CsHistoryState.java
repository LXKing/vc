package com.ccclubs.phoenix.tasks.model;

import com.ccclubs.frm.spring.annotation.AutomaticSequence;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 历史状态
 *
 * @author jianghaiyang
 * @create 2017-08-07
 **/
public class CsHistoryState  implements Serializable {

    @AutomaticSequence
    private Long cshsId;// 主键 非空
    private Integer cshsAccess;// 非空
    private Integer cshsHost;// 非空
    private String cshsNumber;// 非空
    private Integer cshsCar;//
    private Long cshsAddTime;// 非空
    private Long cshsCurrentTime;//
    private String cshsRented;//
    private Integer cshsWarn;//
    private String cshsRfid;//
    private String cshsRfidDte;//
    private Integer cshsObdMile;//
    private Integer cshsEngineT;//
    private Integer cshsMileage;//
    private Short cshsSpeed;//
    private Integer cshsMotor;//
    private String cshsOil;//
    private Integer cshsPower;//
    private Byte cshsEvBattery;//
    private Byte cshsCharging;//
    private String cshsFuelMileage;//
    private String cshsElectricMileage;//
    private String cshsEndurance;//
    private Short cshsTemperature;//
    private Short cshsCsq;//
    private String cshsPowerConsumption;//
    private BigDecimal cshsLongitude;//
    private BigDecimal cshsLatitude;//
    private Byte cshsGpsValid;//
    private Short cshsGpsCn;//
    private Short cshsGpsCount;//
    private String cshsDir;//
    private Byte cshsCircular;// 0:内循环 1:外循环
    private Byte cshsPtc;// 0:OFF 1:ON
    private Byte cshsCompres;// 0:OFF 1:ON
    private Byte cshsFan;// 0:OFF 1:1档 2:2档 3:3档 4:4档
    private Byte cshsSaving;// 0:标准模式 1:最佳省电 2:极度省电
    private String cshsDoor;//
    private Byte cshsEngine;//
    private Byte cshsKey;//
    private Integer cshsLight;//
    private Integer cshsLock;//
    private Byte cshsNetType;//    state_net_type:当前状态网络类型
    private Integer cshsBaseLac;//
    private Integer cshsBaseCi;//
    private Long cshsOrder;//
    private String cshsMoData;//
    private Integer cshsGear;//档位

    public Integer getCshsGear() {
        return cshsGear;
    }

    public void setCshsGear(Integer cshsGear) {
        this.cshsGear = cshsGear;
    }

    public Long getCshsId() {
        return cshsId;
    }

    public void setCshsId(Long cshsId) {
        this.cshsId = cshsId;
    }

    public Integer getCshsAccess() {
        return cshsAccess;
    }

    public void setCshsAccess(Integer cshsAccess) {
        this.cshsAccess = cshsAccess;
    }

    public Integer getCshsHost() {
        return cshsHost;
    }

    public void setCshsHost(Integer cshsHost) {
        this.cshsHost = cshsHost;
    }

    public String getCshsNumber() {
        return cshsNumber;
    }

    public void setCshsNumber(String cshsNumber) {
        this.cshsNumber = cshsNumber;
    }

    public Integer getCshsCar() {
        return cshsCar;
    }

    public void setCshsCar(Integer cshsCar) {
        this.cshsCar = cshsCar;
    }

    public Long getCshsAddTime() {
        return cshsAddTime;
    }

    public void setCshsAddTime(Long cshsAddTime) {
        this.cshsAddTime = cshsAddTime;
    }

    public Long getCshsCurrentTime() {
        return cshsCurrentTime;
    }

    public void setCshsCurrentTime(Long cshsCurrentTime) {
        this.cshsCurrentTime = cshsCurrentTime;
    }

    public String getCshsRented() {
        return cshsRented;
    }

    public void setCshsRented(String cshsRented) {
        this.cshsRented = cshsRented;
    }

    public Integer getCshsWarn() {
        return cshsWarn;
    }

    public void setCshsWarn(Integer cshsWarn) {
        this.cshsWarn = cshsWarn;
    }

    public String getCshsRfid() {
        return cshsRfid;
    }

    public void setCshsRfid(String cshsRfid) {
        this.cshsRfid = cshsRfid;
    }

    public String getCshsRfidDte() {
        return cshsRfidDte;
    }

    public void setCshsRfidDte(String cshsRfidDte) {
        this.cshsRfidDte = cshsRfidDte;
    }

    public Integer getCshsObdMile() {
        return cshsObdMile;
    }

    public void setCshsObdMile(Integer cshsObdMile) {
        this.cshsObdMile = cshsObdMile;
    }

    public Integer getCshsEngineT() {
        return cshsEngineT;
    }

    public void setCshsEngineT(Integer cshsEngineT) {
        this.cshsEngineT = cshsEngineT;
    }

    public Integer getCshsMileage() {
        return cshsMileage;
    }

    public void setCshsMileage(Integer cshsMileage) {
        this.cshsMileage = cshsMileage;
    }

    public Short getCshsSpeed() {
        return cshsSpeed;
    }

    public void setCshsSpeed(Short cshsSpeed) {
        this.cshsSpeed = cshsSpeed;
    }

    public Integer getCshsMotor() {
        return cshsMotor;
    }

    public void setCshsMotor(Integer cshsMotor) {
        this.cshsMotor = cshsMotor;
    }

    public String getCshsOil() {
        return cshsOil;
    }

    public void setCshsOil(String cshsOil) {
        this.cshsOil = cshsOil;
    }

    public Integer getCshsPower() {
        return cshsPower;
    }

    public void setCshsPower(Integer cshsPower) {
        this.cshsPower = cshsPower;
    }

    public Byte getCshsEvBattery() {
        return cshsEvBattery;
    }

    public void setCshsEvBattery(Byte cshsEvBattery) {
        this.cshsEvBattery = cshsEvBattery;
    }

    public Byte getCshsCharging() {
        return cshsCharging;
    }

    public void setCshsCharging(Byte cshsCharging) {
        this.cshsCharging = cshsCharging;
    }

    public String getCshsFuelMileage() {
        return cshsFuelMileage;
    }

    public void setCshsFuelMileage(String cshsFuelMileage) {
        this.cshsFuelMileage = cshsFuelMileage;
    }

    public String getCshsElectricMileage() {
        return cshsElectricMileage;
    }

    public void setCshsElectricMileage(String cshsElectricMileage) {
        this.cshsElectricMileage = cshsElectricMileage;
    }

    public String getCshsEndurance() {
        return cshsEndurance;
    }

    public void setCshsEndurance(String cshsEndurance) {
        this.cshsEndurance = cshsEndurance;
    }

    public Short getCshsTemperature() {
        return cshsTemperature;
    }

    public void setCshsTemperature(Short cshsTemperature) {
        this.cshsTemperature = cshsTemperature;
    }

    public Short getCshsCsq() {
        return cshsCsq;
    }

    public void setCshsCsq(Short cshsCsq) {
        this.cshsCsq = cshsCsq;
    }

    public String getCshsPowerConsumption() {
        return cshsPowerConsumption;
    }

    public void setCshsPowerConsumption(String cshsPowerConsumption) {
        this.cshsPowerConsumption = cshsPowerConsumption;
    }

    public BigDecimal getCshsLongitude() {
        return cshsLongitude;
    }

    public void setCshsLongitude(BigDecimal cshsLongitude) {
        this.cshsLongitude = cshsLongitude;
    }

    public BigDecimal getCshsLatitude() {
        return cshsLatitude;
    }

    public void setCshsLatitude(BigDecimal cshsLatitude) {
        this.cshsLatitude = cshsLatitude;
    }

    public Byte getCshsGpsValid() {
        return cshsGpsValid;
    }

    public void setCshsGpsValid(Byte cshsGpsValid) {
        this.cshsGpsValid = cshsGpsValid;
    }

    public Short getCshsGpsCn() {
        return cshsGpsCn;
    }

    public void setCshsGpsCn(Short cshsGpsCn) {
        this.cshsGpsCn = cshsGpsCn;
    }

    public Short getCshsGpsCount() {
        return cshsGpsCount;
    }

    public void setCshsGpsCount(Short cshsGpsCount) {
        this.cshsGpsCount = cshsGpsCount;
    }

    public String getCshsDir() {
        return cshsDir;
    }

    public void setCshsDir(String cshsDir) {
        this.cshsDir = cshsDir;
    }

    public Byte getCshsCircular() {
        return cshsCircular;
    }

    public void setCshsCircular(Byte cshsCircular) {
        this.cshsCircular = cshsCircular;
    }

    public Byte getCshsPtc() {
        return cshsPtc;
    }

    public void setCshsPtc(Byte cshsPtc) {
        this.cshsPtc = cshsPtc;
    }

    public Byte getCshsCompres() {
        return cshsCompres;
    }

    public void setCshsCompres(Byte cshsCompres) {
        this.cshsCompres = cshsCompres;
    }

    public Byte getCshsFan() {
        return cshsFan;
    }

    public void setCshsFan(Byte cshsFan) {
        this.cshsFan = cshsFan;
    }

    public Byte getCshsSaving() {
        return cshsSaving;
    }

    public void setCshsSaving(Byte cshsSaving) {
        this.cshsSaving = cshsSaving;
    }

    public String getCshsDoor() {
        return cshsDoor;
    }

    public void setCshsDoor(String cshsDoor) {
        this.cshsDoor = cshsDoor;
    }

    public Byte getCshsEngine() {
        return cshsEngine;
    }

    public void setCshsEngine(Byte cshsEngine) {
        this.cshsEngine = cshsEngine;
    }

    public Byte getCshsKey() {
        return cshsKey;
    }

    public void setCshsKey(Byte cshsKey) {
        this.cshsKey = cshsKey;
    }

    public Integer getCshsLight() {
        return cshsLight;
    }

    public void setCshsLight(Integer cshsLight) {
        this.cshsLight = cshsLight;
    }

    public Integer getCshsLock() {
        return cshsLock;
    }

    public void setCshsLock(Integer cshsLock) {
        this.cshsLock = cshsLock;
    }

    public Byte getCshsNetType() {
        return cshsNetType;
    }

    public void setCshsNetType(Byte cshsNetType) {
        this.cshsNetType = cshsNetType;
    }

    public Integer getCshsBaseLac() {
        return cshsBaseLac;
    }

    public void setCshsBaseLac(Integer cshsBaseLac) {
        this.cshsBaseLac = cshsBaseLac;
    }

    public Integer getCshsBaseCi() {
        return cshsBaseCi;
    }

    public void setCshsBaseCi(Integer cshsBaseCi) {
        this.cshsBaseCi = cshsBaseCi;
    }

    public Long getCshsOrder() {
        return cshsOrder;
    }

    public void setCshsOrder(Long cshsOrder) {
        this.cshsOrder = cshsOrder;
    }

    public String getCshsMoData() {
        return cshsMoData;
    }

    public void setCshsMoData(String cshsMoData) {
        this.cshsMoData = cshsMoData;
    }
}
