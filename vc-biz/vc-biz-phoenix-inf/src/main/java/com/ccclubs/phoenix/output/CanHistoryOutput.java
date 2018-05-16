package com.ccclubs.phoenix.output;

import com.ccclubs.phoenix.orm.dto.CanDto;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/15
 * @Time: 15:56
 * @Description: CAN历史数据输出类！
 */

public class CanHistoryOutput implements Serializable {

    private static final long serialVersionUID = -4830561956410067694L;

    //记录总数
    private Long total;
    //记录
    private List<CanDto> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<CanDto> getList() {
        return list;
    }

    public void setList(List<CanDto> list) {
        this.list = list;
    }
}
