package com.ccclubs.olap.etl.impl;


import com.ccclubs.olap.etl.ITransform;
import com.ccclubs.olap.util.DateTimeUtil;

public class StateTimeInsertTransform implements ITransform<String,String> {
    @Override
    public String doTransform(String originDateTime) {
        return originDateTime+","+ DateTimeUtil.getDateTimeByAddMills(originDateTime,15000);
    }

    public static void main(String[] args) {
        StateTimeInsertTransform stateTimeInsertTransform = new StateTimeInsertTransform();
        System.out.println(stateTimeInsertTransform.doTransform("2017-01-01 13:44:30"));
    }
}
