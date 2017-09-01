package com.ccclubs.olap.etl.impl;


import com.ccclubs.olap.etl.ITransform;
import com.ccclubs.olap.util.DateTimeUtil;

import java.util.Calendar;

public class StateTimeTransform implements ITransform<String,String> {
    @Override
    public String doTransform(String beforeDateTime) {
        Calendar cal = Calendar.getInstance();
        long beforeTimeMills = DateTimeUtil.date2UnixFormat(beforeDateTime,DateTimeUtil.format1);
        cal.setTimeInMillis(beforeTimeMills);
        int beforeSeconds = DateTimeUtil.getSecond(beforeTimeMills);
        int bei=(int)(beforeSeconds/15);
        int yu =  beforeSeconds%15;
        if(yu>7.5){
            bei+=1;
        }
        int afterSeconds= bei*15;
        cal.set(Calendar.SECOND,afterSeconds);
        return DateTimeUtil.getDateTimeByFormat1(cal.getTimeInMillis());
    }

    public static void main(String[] args) {
        StateTimeTransform timeTransform = new StateTimeTransform();
        System.out.println(timeTransform.doTransform("2017-01-01 14:22:44"));
//        System.out.println(FastJsonUtil.getCanToGb("54363339303836330000000000000000690520E91B4D010D003008010000000000002C03000802000300000000B20301087D0000C8003232000302080E38175C6010362B0303081029424E064D0305030408B0000116050000000305081710301030102CB203060800000000000000B203070800000100000101B2030808010100EB042300B103090800000000000000B203100800000000000000B3040008E1810004001B1C00\n"));
    }
}
