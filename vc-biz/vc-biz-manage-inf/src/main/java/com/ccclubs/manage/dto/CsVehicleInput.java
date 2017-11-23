package com.ccclubs.manage.dto;

import com.ccclubs.manage.orm.model.CsVehicle;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 11:18
 * Email:fengjun@ccclubs.com
 */
public class CsVehicleInput implements Serializable {

    private static final long serialVersionUID = 1742988269823758157L;


    private CsVehicle csVehicle;
    private Integer pageSize;//页面大小
    private Integer pageNum;//目标页码
    private String csCarNo;//车牌号
    private Integer id;//数据库ID
    private String csVin;//车架号
    private Integer csMachineId;//车机设备
    private Integer csAccess=1;//授权系统
    private List<Integer> ids;//数据库ID集合，用于批量删除。

    private Short isBind=-1;//-1是不关心是否绑定车机，1为已绑定车机，0为未绑定车机。

    private String addTimeBegin;
    private String addTimeEnd;
    private String factoryTimeBegin;
    private String factoryTimeEnd;

    /**
     * 来自车机表 cs_machine
     * */
    private String csNumber;//车机号,根据此值得到车机设备ID。

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public CsVehicle getCsVehicle() {
        return csVehicle;
    }

    public void setCsVehicle(CsVehicle csVehicle) {
        this.csVehicle = csVehicle;
    }

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

    public String getAddTimeBegin() {
        return addTimeBegin;
    }

    public Short getIsBind() {
        return isBind;
    }

    public void setIsBind(Short isBind) {
        this.isBind = isBind;
    }

    public void setAddTimeBegin(String addTimeBegin) {
        this.addTimeBegin = addTimeBegin;
    }

    public String getAddTimeEnd() {
        return addTimeEnd;
    }

    public void setAddTimeEnd(String addTimeEnd) {
        this.addTimeEnd = addTimeEnd;
    }

    public String getFactoryTimeBegin() {
        return factoryTimeBegin;
    }

    public void setFactoryTimeBegin(String factoryTimeBegin) {
        this.factoryTimeBegin = factoryTimeBegin;
    }

    public String getFactoryTimeEnd() {
        return factoryTimeEnd;
    }

    public void setFactoryTimeEnd(String factoryTimeEnd) {
        this.factoryTimeEnd = factoryTimeEnd;
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

    public Integer getCsMachineId() {
        return csMachineId;
    }

    public void setCsMachineId(Integer csMachineId) {
        this.csMachineId = csMachineId;
    }

    public Integer getCsAccess() {
        return csAccess;
    }

    public void setCsAccess(Integer csAccess) {
        this.csAccess = csAccess;
    }




}
