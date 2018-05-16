package com.ccclubs.phoenix.output;


import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.phoenix.orm.model.Pace;

import java.io.Serializable;
import java.util.List;

/**

 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
@Deprecated
public class CarStateHistoryOutput implements Serializable {


    private static final long serialVersionUID = 8397279666160938246L;
    //记录总数
    private Long total;
    //记录
    private List<CarState> list;

    private List<Pace> paceList;

    public List<Pace> getPaceList() {
        return paceList;
    }

    public void setPaceList(List<Pace> paceList) {
        this.paceList = paceList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<CarState> getList() {
        return list;
    }

    public void setList(List<CarState> list) {
        this.list = list;
    }

}
