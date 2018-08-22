package com.ccclubs.phoenix.output;

import com.ccclubs.phoenix.orm.dto.TBoxLogDto;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: GFA
 * @Project: vc
 * @Package: com.ccclubs.phoenix.output
 * @Date: 2018/08/20  15:42
 * @Description:
 */
public class TBoxLogOutput implements Serializable {

    private static final long serialVersionUID = 2337200788366653553L;

    //记录总数
    private Long total;
    //记录
    private List<TBoxLogDto> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<TBoxLogDto> getList() {
        return list;
    }

    public void setList(List<TBoxLogDto> list) {
        this.list = list;
    }
}
