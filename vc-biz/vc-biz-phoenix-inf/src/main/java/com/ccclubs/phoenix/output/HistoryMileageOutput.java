package com.ccclubs.phoenix.output;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 历史里程查询
 *
 * @author jianghaiyang
 * @create 2018-09-26
 **/
public class HistoryMileageOutput implements Serializable {

    /**
     * 里程总计
     */
    private BigDecimal totalMileage;

    public BigDecimal getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(BigDecimal totalMileage) {
        this.totalMileage = totalMileage;
    }
}
