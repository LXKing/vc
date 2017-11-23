package com.ccclubs.manage.dto;

import com.ccclubs.manage.model.CsVehicle;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 11:18
 * Email:fengjun@ccclubs.com
 */
public class CsVehicleOutput implements Serializable {
    private static final long serialVersionUID = 6756016086508898643L;
    private List<CsVehicle> list=null;

    public List<CsVehicle> getList() {
        return list;
    }

    public void setList(List<CsVehicle> list) {
        this.list = list;
    }
}
