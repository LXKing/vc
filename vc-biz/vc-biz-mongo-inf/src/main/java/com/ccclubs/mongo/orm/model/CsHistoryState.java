package com.ccclubs.mongo.orm.model;

import com.ccclubs.frm.spring.annotation.AutomaticSequence;

import java.io.Serializable;
import java.util.Date;

/**
 * 历史状态
 *
 * @author jianghaiyang
 * @create 2017-08-07
 **/
public class CsHistoryState extends AbstractDocumentOld implements Serializable {

    @AutomaticSequence
    private Long cshsId;// 主键 非空
    private Integer cshsAccess;// 非空
    private Integer cshsHost;// 非空
    private String cshsNumber;// 非空
    private Integer cshsCar;//
    private Date cshsAddTime;// 非空
    private Date cshsCurrentTime;//
    private String cshsRented;//
    private String cshsWarn;//
    private String cshsRfid;//
    private String cshsRfidDte;//
    private String cshsObdMile;//
    private String cshsEngineT;//
    private String cshsMileage;//
    private String cshsSpeed;//
    private String cshsMotor;//
    private String cshsOil;//
    private String cshsPower;//
    private String cshsEvBattery;//
    private String cshsCharging;//
    private String cshsFuelMileage;//
    private String cshsElectricMileage;//
    private String cshsEndurance;//
    private String cshsTemperature;//
    private String cshsCsq;//
    private String cshsPowerConsumption;//
    private String cshsLongitude;//
    private String cshsLatitude;//
    private Integer cshsGpsValid;//
    private Integer cshsGpsCn;//
    private Integer cshsGpsCount;//
    private String cshsDir;//
    private String cshsCircular;// 0:内循环 1:外循环
    private String cshsPtc;// 0:OFF 1:ON
    private String cshsCompres;// 0:OFF 1:ON
    private String cshsFan;// 0:OFF 1:1档 2:2档 3:3档 4:4档
    private String cshsSaving;// 0:标准模式 1:最佳省电 2:极度省电
    private String cshsDoor;//
    private Long cshsEngine;//
    private Long cshsKey;//
    private Long cshsLight;//
    private Long cshsLock;//
    private Long cshsNetType;//    state_net_type:当前状态网络类型
    private String cshsBaseLac;//
    private String cshsBaseCi;//
    private String cshsOrder;//
    private String cshsMoData;//

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

    public Date getCshsAddTime() {
        return cshsAddTime;
    }

    public void setCshsAddTime(Date cshsAddTime) {
        this.cshsAddTime = cshsAddTime;
    }

    public Date getCshsCurrentTime() {
        return cshsCurrentTime;
    }

    public void setCshsCurrentTime(Date cshsCurrentTime) {
        this.cshsCurrentTime = cshsCurrentTime;
    }

    public String getCshsRented() {
        return cshsRented;
    }

    public void setCshsRented(String cshsRented) {
        this.cshsRented = cshsRented;
    }

    public String getCshsWarn() {
        return cshsWarn;
    }

    public void setCshsWarn(String cshsWarn) {
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

    public String getCshsObdMile() {
        return cshsObdMile;
    }

    public void setCshsObdMile(String cshsObdMile) {
        this.cshsObdMile = cshsObdMile;
    }

    public String getCshsEngineT() {
        return cshsEngineT;
    }

    public void setCshsEngineT(String cshsEngineT) {
        this.cshsEngineT = cshsEngineT;
    }

    public String getCshsMileage() {
        return cshsMileage;
    }

    public void setCshsMileage(String cshsMileage) {
        this.cshsMileage = cshsMileage;
    }

    public String getCshsSpeed() {
        return cshsSpeed;
    }

    public void setCshsSpeed(String cshsSpeed) {
        this.cshsSpeed = cshsSpeed;
    }

    public String getCshsMotor() {
        return cshsMotor;
    }

    public void setCshsMotor(String cshsMotor) {
        this.cshsMotor = cshsMotor;
    }

    public String getCshsOil() {
        return cshsOil;
    }

    public void setCshsOil(String cshsOil) {
        this.cshsOil = cshsOil;
    }

    public String getCshsPower() {
        return cshsPower;
    }

    public void setCshsPower(String cshsPower) {
        this.cshsPower = cshsPower;
    }

    public String getCshsEvBattery() {
        return cshsEvBattery;
    }

    public void setCshsEvBattery(String cshsEvBattery) {
        this.cshsEvBattery = cshsEvBattery;
    }

    public String getCshsCharging() {
        return cshsCharging;
    }

    public void setCshsCharging(String cshsCharging) {
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

    public String getCshsTemperature() {
        return cshsTemperature;
    }

    public void setCshsTemperature(String cshsTemperature) {
        this.cshsTemperature = cshsTemperature;
    }

    public String getCshsCsq() {
        return cshsCsq;
    }

    public void setCshsCsq(String cshsCsq) {
        this.cshsCsq = cshsCsq;
    }

    public String getCshsPowerConsumption() {
        return cshsPowerConsumption;
    }

    public void setCshsPowerConsumption(String cshsPowerConsumption) {
        this.cshsPowerConsumption = cshsPowerConsumption;
    }

    public String getCshsLongitude() {
        return cshsLongitude;
    }

    public void setCshsLongitude(String cshsLongitude) {
        this.cshsLongitude = cshsLongitude;
    }

    public String getCshsLatitude() {
        return cshsLatitude;
    }

    public void setCshsLatitude(String cshsLatitude) {
        this.cshsLatitude = cshsLatitude;
    }

    public Integer getCshsGpsValid() {
        return cshsGpsValid;
    }

    public void setCshsGpsValid(Integer cshsGpsValid) {
        this.cshsGpsValid = cshsGpsValid;
    }

    public Integer getCshsGpsCn() {
        return cshsGpsCn;
    }

    public void setCshsGpsCn(Integer cshsGpsCn) {
        this.cshsGpsCn = cshsGpsCn;
    }

    public Integer getCshsGpsCount() {
        return cshsGpsCount;
    }

    public void setCshsGpsCount(Integer cshsGpsCount) {
        this.cshsGpsCount = cshsGpsCount;
    }

    public String getCshsDir() {
        return cshsDir;
    }

    public void setCshsDir(String cshsDir) {
        this.cshsDir = cshsDir;
    }

    public String getCshsCircular() {
        return cshsCircular;
    }

    public void setCshsCircular(String cshsCircular) {
        this.cshsCircular = cshsCircular;
    }

    public String getCshsPtc() {
        return cshsPtc;
    }

    public void setCshsPtc(String cshsPtc) {
        this.cshsPtc = cshsPtc;
    }

    public String getCshsCompres() {
        return cshsCompres;
    }

    public void setCshsCompres(String cshsCompres) {
        this.cshsCompres = cshsCompres;
    }

    public String getCshsFan() {
        return cshsFan;
    }

    public void setCshsFan(String cshsFan) {
        this.cshsFan = cshsFan;
    }

    public String getCshsSaving() {
        return cshsSaving;
    }

    public void setCshsSaving(String cshsSaving) {
        this.cshsSaving = cshsSaving;
    }

    public String getCshsDoor() {
        return cshsDoor;
    }

    public void setCshsDoor(String cshsDoor) {
        this.cshsDoor = cshsDoor;
    }

    public Long getCshsEngine() {
        return cshsEngine;
    }

    public void setCshsEngine(Long cshsEngine) {
        this.cshsEngine = cshsEngine;
    }

    public Long getCshsKey() {
        return cshsKey;
    }

    public void setCshsKey(Long cshsKey) {
        this.cshsKey = cshsKey;
    }

    public Long getCshsLight() {
        return cshsLight;
    }

    public void setCshsLight(Long cshsLight) {
        this.cshsLight = cshsLight;
    }

    public Long getCshsLock() {
        return cshsLock;
    }

    public void setCshsLock(Long cshsLock) {
        this.cshsLock = cshsLock;
    }

    public Long getCshsNetType() {
        return cshsNetType;
    }

    public void setCshsNetType(Long cshsNetType) {
        this.cshsNetType = cshsNetType;
    }

    public String getCshsBaseLac() {
        return cshsBaseLac;
    }

    public void setCshsBaseLac(String cshsBaseLac) {
        this.cshsBaseLac = cshsBaseLac;
    }

    public String getCshsBaseCi() {
        return cshsBaseCi;
    }

    public void setCshsBaseCi(String cshsBaseCi) {
        this.cshsBaseCi = cshsBaseCi;
    }

    public String getCshsOrder() {
        return cshsOrder;
    }

    public void setCshsOrder(String cshsOrder) {
        this.cshsOrder = cshsOrder;
    }

    public String getCshsMoData() {
        return cshsMoData;
    }

    public void setCshsMoData(String cshsMoData) {
        this.cshsMoData = cshsMoData;
    }
}
