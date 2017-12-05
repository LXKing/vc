package com.ccclubs.phoenix.output;


import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.phoenix.orm.model.Pace;

import java.io.Serializable;
import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　 ┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
public class CarStateHistoryOutput implements Serializable {
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
