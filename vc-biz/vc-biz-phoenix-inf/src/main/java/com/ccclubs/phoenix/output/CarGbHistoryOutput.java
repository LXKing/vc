package com.ccclubs.phoenix.output;


import com.ccclubs.phoenix.orm.model.CarGb;

import java.io.Serializable;
import java.util.List;

public class CarGbHistoryOutput implements Serializable{

    private static final long serialVersionUID = 6405556016793996382L;
    //记录总数
    private Long total;
    //记录
    private List<CarGb> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<CarGb> getList() {
        return list;
    }

    public void setList(List<CarGb> list) {
        this.list = list;
    }
}
