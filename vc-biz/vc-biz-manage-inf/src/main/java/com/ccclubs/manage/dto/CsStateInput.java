package com.ccclubs.manage.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 11:17
 * Email:fengjun@ccclubs.com
 */
public class CsStateInput implements Serializable {

    private static final long serialVersionUID = -8025591152889723933L;



    private Integer pageSize;//页面大小
    private Integer pageNum;//目标页码
    private Integer id;//数据库ID

    private Integer csAccess=1;//授权系统
    private String csNumber;//车机号

    /**
     * 来自车辆表cs_vehicle
     * */
    private Integer csVehicleId;//关联车辆 css_car
    private String csCarNo;//车牌号 ，可由此值得到关联车辆
    private String csVin;//车架号，可由此值得到关联车辆

    //private Integer csMachineId;//车机设备


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getCsNumber() {
        return csNumber;
    }

    public void setCsNumber(String csNumber) {
        this.csNumber = csNumber;
    }

    public String getCsCarNo() {
        return csCarNo;
    }

    public void setCsCarNo(String csCarNo) {
        this.csCarNo = csCarNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCsVin() {
        return csVin;
    }

    public void setCsVin(String csVin) {
        this.csVin = csVin;
    }

    public Integer getCsVehicleId() {
        return csVehicleId;
    }

    public void setCsVehicleId(Integer csVehicleId) {
        this.csVehicleId = csVehicleId;
    }

    public Integer getCsAccess() {
        return csAccess;
    }

    public void setCsAccess(Integer csAccess) {
        this.csAccess = csAccess;
    }

}
