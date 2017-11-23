package com.ccclubs.manage.dto;

import com.ccclubs.manage.model.CsMachine;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 11:16
 * Email:fengjun@ccclubs.com
 */
public class CsMachineOutput implements Serializable{

    private static final long serialVersionUID = -6725243814368540502L;

    private List<CsMachine> list;


    public List<CsMachine> getList() {
        return list;
    }

    public void setList(List<CsMachine> list) {
        this.list = list;
    }
}
