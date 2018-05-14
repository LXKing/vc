package com.ccclubs.phoenix.output;

import com.ccclubs.phoenix.orm.dto.MqttStateDto;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/14
 * @Time: 14:49
 * @Description: 分时租赁协议车辆状态数据输出类！
 */

public class MqttStateHistoryOutput implements Serializable {

    private static final long serialVersionUID = 4996127786916041508L;
    //记录总数
    private Long total;
    //记录
    private List<MqttStateDto> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<MqttStateDto> getList() {
        return list;
    }

    public void setList(List<MqttStateDto> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "MqttStateHistoryOutput{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
