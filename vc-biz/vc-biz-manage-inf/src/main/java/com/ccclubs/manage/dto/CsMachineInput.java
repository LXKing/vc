package com.ccclubs.manage.dto;

import com.ccclubs.manage.orm.model.CsMachine;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 11:16
 * Email:fengjun@ccclubs.com
 */
public class CsMachineInput implements Serializable {

    private static final long serialVersionUID = 3520141038126499490L;


    private CsMachine csMachine;
    private Integer pageSize;//页面大小
    private Integer pageNum;//目标页码
    private String csNumber;//车机号
    private Integer id;//数据库ID

    private String teNo;//终端号（序列号）
    private String mobile;//手机号

    //private Integer csMachineId;//车机设备
    private Integer csAccess=1;//授权系统


    private List<Integer> ids;//数据库ID集合，用于批量删除。
    /**
     * 来自车辆表cs_vehicle
     * */
    private String csVin;//车架号，可以由此查车辆表得csNumber
    private String csCarNo;//车牌号，可以由此查车辆表得csNumber


    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
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

    public CsMachine getCsMachine() {
        return csMachine;
    }

    public void setCsMachine(CsMachine csMachine) {
        this.csMachine = csMachine;
    }

    public Integer getCsAccess() {
        return csAccess;
    }

    public void setCsAccess(Integer csAccess) {
        this.csAccess = csAccess;
    }

    public String getTeNo() {
        return teNo;
    }

    public void setTeNo(String teNo) {
        this.teNo = teNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
