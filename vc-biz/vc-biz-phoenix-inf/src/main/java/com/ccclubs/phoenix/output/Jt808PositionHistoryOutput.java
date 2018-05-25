package com.ccclubs.phoenix.output;

import com.ccclubs.phoenix.orm.dto.Jt808Dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/15
 * @Time: 15:56
 * @Description: 808位置历史数据输出类！
 */

public class Jt808PositionHistoryOutput implements Serializable {
    private static final long serialVersionUID = -3449068433051945469L;
    //记录总数
    private Long total;
    //记录
    private List<Jt808Dto> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Jt808Dto> getList() {
        return list;
    }

    public void setList(List<Jt808Dto> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Jt808PositionHistoryOutput{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
