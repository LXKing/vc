package com.ccclubs.manage.dto;

import com.ccclubs.manage.model.CsState;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 11:18
 * Email:fengjun@ccclubs.com
 */
public class CsStateOutput implements Serializable {
    private static final long serialVersionUID = 2034327754987774621L;
    List<CsState> list=null;

    public List<CsState> getList() {
        return list;
    }

    public void setList(List<CsState> list) {
        this.list = list;
    }
}
