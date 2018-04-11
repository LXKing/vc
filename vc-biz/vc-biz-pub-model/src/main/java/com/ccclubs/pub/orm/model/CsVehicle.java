package com.ccclubs.pub.orm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CsVehicle implements Serializable {
    /**
     * 编号:
     */
    private Integer csvId;

    /**
     * 授权系统,0:无所属者
     */
    private Integer csvAccess;

    /**
     * 子域:
     */
    private Integer csvHost;

    /**
     * 真实车牌:
     */
    private String csvCarNo;

    /**
     * 车架号:
     */
    private String csvVin;

    /**
     * 发动机号
     */
    private String csvEngineNo;

    /**
     * 合格证号
     */
    private String csvCertific;

    /**
     * 颜色
     */
    private Byte csvColor;

    /**
     * 车型:
     */
    private Integer csvModel;

    /**
     * 车机设备:
     */
    private Integer csvMachine;

    /**
     * 历史设备:
     */
    private String csvMachines;

    /**
     * 车颜色代码0: 白套红橙1: 白套玫瑰金2: 白套苹果绿3: 红橙套黑4: 红套黑5: 黄/黑6: 黄套黑7: 蓝白套8: 苹果绿/白9: 深空黑/红橙10: 紫白套
     */
    private Byte csvColorCode;

    /**
     * 可充电储能系统编码
     */
    private String csvBataccuCode;

    /**
     * 出厂日期
     */
    private Date csvProdDate;

    /**
     * 地标类型
     */
    private String csvLandmark;

    /**
     * 车辆领域：0:未知,1:个人领域,2:公共领域
     */
    private Byte csvDomain;

    /**
     * 车型代码
     */
    private String csvModelCodeFull;

    /**
     * 车型备案型号
     */
    private String csvModelCodeSimple;

    /**
     * 内饰颜色
     */
    private String csvInteriorColorCode;

    /**
     * 状态:1:正常,0:无效;
     */
    private Byte csvStatus;

    /**
     * 添加时间:
     */
    private Date csvAddTime;

    /**
     * 修改时间:
     */
    private Date csvUpdateTime;

    private static final long serialVersionUID = 1L;

    public Integer getCsvId() {
        return csvId;
    }

    public void setCsvId(Integer csvId) {
        this.csvId = csvId;
    }

    public Integer getCsvAccess() {
        return csvAccess;
    }

    public void setCsvAccess(Integer csvAccess) {
        this.csvAccess = csvAccess;
    }

    public Integer getCsvHost() {
        return csvHost;
    }

    public void setCsvHost(Integer csvHost) {
        this.csvHost = csvHost;
    }

    public String getCsvCarNo() {
        return csvCarNo;
    }

    public void setCsvCarNo(String csvCarNo) {
        this.csvCarNo = csvCarNo;
    }

    public String getCsvVin() {
        return csvVin;
    }

    public void setCsvVin(String csvVin) {
        this.csvVin = csvVin;
    }

    public String getCsvEngineNo() {
        return csvEngineNo;
    }

    public void setCsvEngineNo(String csvEngineNo) {
        this.csvEngineNo = csvEngineNo;
    }

    public String getCsvCertific() {
        return csvCertific;
    }

    public void setCsvCertific(String csvCertific) {
        this.csvCertific = csvCertific;
    }

    public Byte getCsvColor() {
        return csvColor;
    }

    public void setCsvColor(Byte csvColor) {
        this.csvColor = csvColor;
    }

    public Integer getCsvModel() {
        return csvModel;
    }

    public void setCsvModel(Integer csvModel) {
        this.csvModel = csvModel;
    }

    public Integer getCsvMachine() {
        return csvMachine;
    }

    public void setCsvMachine(Integer csvMachine) {
        this.csvMachine = csvMachine;
    }

    public String getCsvMachines() {
        return csvMachines;
    }

    public void setCsvMachines(String csvMachines) {
        this.csvMachines = csvMachines;
    }

    public Byte getCsvColorCode() {
        return csvColorCode;
    }

    public void setCsvColorCode(Byte csvColorCode) {
        this.csvColorCode = csvColorCode;
    }

    public String getCsvBataccuCode() {
        return csvBataccuCode;
    }

    public void setCsvBataccuCode(String csvBataccuCode) {
        this.csvBataccuCode = csvBataccuCode;
    }

    public Date getCsvProdDate() {
        return csvProdDate;
    }

    public void setCsvProdDate(Date csvProdDate) {
        this.csvProdDate = csvProdDate;
    }

    public String getCsvLandmark() {
        return csvLandmark;
    }

    public void setCsvLandmark(String csvLandmark) {
        this.csvLandmark = csvLandmark;
    }

    public Byte getCsvDomain() {
        return csvDomain;
    }

    public void setCsvDomain(Byte csvDomain) {
        this.csvDomain = csvDomain;
    }

    public String getCsvModelCodeFull() {
        return csvModelCodeFull;
    }

    public void setCsvModelCodeFull(String csvModelCodeFull) {
        this.csvModelCodeFull = csvModelCodeFull;
    }

    public String getCsvModelCodeSimple() {
        return csvModelCodeSimple;
    }

    public void setCsvModelCodeSimple(String csvModelCodeSimple) {
        this.csvModelCodeSimple = csvModelCodeSimple;
    }

    public String getCsvInteriorColorCode() {
        return csvInteriorColorCode;
    }

    public void setCsvInteriorColorCode(String csvInteriorColorCode) {
        this.csvInteriorColorCode = csvInteriorColorCode;
    }

    public Byte getCsvStatus() {
        return csvStatus;
    }

    public void setCsvStatus(Byte csvStatus) {
        this.csvStatus = csvStatus;
    }

    public Date getCsvAddTime() {
        return csvAddTime;
    }

    public void setCsvAddTime(Date csvAddTime) {
        this.csvAddTime = csvAddTime;
    }

    public Date getCsvUpdateTime() {
        return csvUpdateTime;
    }

    public void setCsvUpdateTime(Date csvUpdateTime) {
        this.csvUpdateTime = csvUpdateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CsVehicle other = (CsVehicle) that;
        return (this.getCsvId() == null ? other.getCsvId() == null : this.getCsvId().equals(other.getCsvId()))
            && (this.getCsvAccess() == null ? other.getCsvAccess() == null : this.getCsvAccess().equals(other.getCsvAccess()))
            && (this.getCsvHost() == null ? other.getCsvHost() == null : this.getCsvHost().equals(other.getCsvHost()))
            && (this.getCsvCarNo() == null ? other.getCsvCarNo() == null : this.getCsvCarNo().equals(other.getCsvCarNo()))
            && (this.getCsvVin() == null ? other.getCsvVin() == null : this.getCsvVin().equals(other.getCsvVin()))
            && (this.getCsvEngineNo() == null ? other.getCsvEngineNo() == null : this.getCsvEngineNo().equals(other.getCsvEngineNo()))
            && (this.getCsvCertific() == null ? other.getCsvCertific() == null : this.getCsvCertific().equals(other.getCsvCertific()))
            && (this.getCsvColor() == null ? other.getCsvColor() == null : this.getCsvColor().equals(other.getCsvColor()))
            && (this.getCsvModel() == null ? other.getCsvModel() == null : this.getCsvModel().equals(other.getCsvModel()))
            && (this.getCsvMachine() == null ? other.getCsvMachine() == null : this.getCsvMachine().equals(other.getCsvMachine()))
            && (this.getCsvMachines() == null ? other.getCsvMachines() == null : this.getCsvMachines().equals(other.getCsvMachines()))
            && (this.getCsvColorCode() == null ? other.getCsvColorCode() == null : this.getCsvColorCode().equals(other.getCsvColorCode()))
            && (this.getCsvBataccuCode() == null ? other.getCsvBataccuCode() == null : this.getCsvBataccuCode().equals(other.getCsvBataccuCode()))
            && (this.getCsvProdDate() == null ? other.getCsvProdDate() == null : this.getCsvProdDate().equals(other.getCsvProdDate()))
            && (this.getCsvLandmark() == null ? other.getCsvLandmark() == null : this.getCsvLandmark().equals(other.getCsvLandmark()))
            && (this.getCsvDomain() == null ? other.getCsvDomain() == null : this.getCsvDomain().equals(other.getCsvDomain()))
            && (this.getCsvModelCodeFull() == null ? other.getCsvModelCodeFull() == null : this.getCsvModelCodeFull().equals(other.getCsvModelCodeFull()))
            && (this.getCsvModelCodeSimple() == null ? other.getCsvModelCodeSimple() == null : this.getCsvModelCodeSimple().equals(other.getCsvModelCodeSimple()))
            && (this.getCsvInteriorColorCode() == null ? other.getCsvInteriorColorCode() == null : this.getCsvInteriorColorCode().equals(other.getCsvInteriorColorCode()))
            && (this.getCsvStatus() == null ? other.getCsvStatus() == null : this.getCsvStatus().equals(other.getCsvStatus()))
            && (this.getCsvAddTime() == null ? other.getCsvAddTime() == null : this.getCsvAddTime().equals(other.getCsvAddTime()))
            && (this.getCsvUpdateTime() == null ? other.getCsvUpdateTime() == null : this.getCsvUpdateTime().equals(other.getCsvUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCsvId() == null) ? 0 : getCsvId().hashCode());
        result = prime * result + ((getCsvAccess() == null) ? 0 : getCsvAccess().hashCode());
        result = prime * result + ((getCsvHost() == null) ? 0 : getCsvHost().hashCode());
        result = prime * result + ((getCsvCarNo() == null) ? 0 : getCsvCarNo().hashCode());
        result = prime * result + ((getCsvVin() == null) ? 0 : getCsvVin().hashCode());
        result = prime * result + ((getCsvEngineNo() == null) ? 0 : getCsvEngineNo().hashCode());
        result = prime * result + ((getCsvCertific() == null) ? 0 : getCsvCertific().hashCode());
        result = prime * result + ((getCsvColor() == null) ? 0 : getCsvColor().hashCode());
        result = prime * result + ((getCsvModel() == null) ? 0 : getCsvModel().hashCode());
        result = prime * result + ((getCsvMachine() == null) ? 0 : getCsvMachine().hashCode());
        result = prime * result + ((getCsvMachines() == null) ? 0 : getCsvMachines().hashCode());
        result = prime * result + ((getCsvColorCode() == null) ? 0 : getCsvColorCode().hashCode());
        result = prime * result + ((getCsvBataccuCode() == null) ? 0 : getCsvBataccuCode().hashCode());
        result = prime * result + ((getCsvProdDate() == null) ? 0 : getCsvProdDate().hashCode());
        result = prime * result + ((getCsvLandmark() == null) ? 0 : getCsvLandmark().hashCode());
        result = prime * result + ((getCsvDomain() == null) ? 0 : getCsvDomain().hashCode());
        result = prime * result + ((getCsvModelCodeFull() == null) ? 0 : getCsvModelCodeFull().hashCode());
        result = prime * result + ((getCsvModelCodeSimple() == null) ? 0 : getCsvModelCodeSimple().hashCode());
        result = prime * result + ((getCsvInteriorColorCode() == null) ? 0 : getCsvInteriorColorCode().hashCode());
        result = prime * result + ((getCsvStatus() == null) ? 0 : getCsvStatus().hashCode());
        result = prime * result + ((getCsvAddTime() == null) ? 0 : getCsvAddTime().hashCode());
        result = prime * result + ((getCsvUpdateTime() == null) ? 0 : getCsvUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", csvId=").append(csvId);
        sb.append(", csvAccess=").append(csvAccess);
        sb.append(", csvHost=").append(csvHost);
        sb.append(", csvCarNo=").append(csvCarNo);
        sb.append(", csvVin=").append(csvVin);
        sb.append(", csvEngineNo=").append(csvEngineNo);
        sb.append(", csvCertific=").append(csvCertific);
        sb.append(", csvColor=").append(csvColor);
        sb.append(", csvModel=").append(csvModel);
        sb.append(", csvMachine=").append(csvMachine);
        sb.append(", csvMachines=").append(csvMachines);
        sb.append(", csvColorCode=").append(csvColorCode);
        sb.append(", csvBataccuCode=").append(csvBataccuCode);
        sb.append(", csvProdDate=").append(csvProdDate);
        sb.append(", csvLandmark=").append(csvLandmark);
        sb.append(", csvDomain=").append(csvDomain);
        sb.append(", csvModelCodeFull=").append(csvModelCodeFull);
        sb.append(", csvModelCodeSimple=").append(csvModelCodeSimple);
        sb.append(", csvInteriorColorCode=").append(csvInteriorColorCode);
        sb.append(", csvStatus=").append(csvStatus);
        sb.append(", csvAddTime=").append(csvAddTime);
        sb.append(", csvUpdateTime=").append(csvUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}