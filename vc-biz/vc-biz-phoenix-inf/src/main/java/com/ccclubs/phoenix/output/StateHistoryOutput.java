package com.ccclubs.phoenix.output;

import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.phoenix.orm.model.VehicleState;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/8
 * @Time: 17:50
 * @Description: 请填写描述！
 */

public class StateHistoryOutput implements Serializable {
    private static final long serialVersionUID = 7490011628156591773L;

    List<VehicleState> beforeList;
    List<VehicleState> afterList;

    public List<VehicleState> getBeforeList() {
        return beforeList;
    }

    public void setBeforeList(List<VehicleState> beforeList) {
        this.beforeList = beforeList;
    }

    public List<VehicleState> getAfterList() {
        return afterList;
    }

    public void setAfterList(List<VehicleState> afterList) {
        this.afterList = afterList;
    }
}
