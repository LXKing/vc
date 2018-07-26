package com.ccclubs.phoenix.output;

import com.ccclubs.phoenix.orm.dto.GbMessageDto;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/15
 * @Time: 15:56
 * @Description: 国标历史数据输出类！
 */

public class GbMessageHistoryOutput implements Serializable {

    private static final long serialVersionUID = 4779334450923354813L;

    //记录总数
    private Long total;
    //记录
    private List<GbMessageDto> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<GbMessageDto> getList() {
        return list;
    }

    public void setList(List<GbMessageDto> list) {
        this.list = list;
    }
}
