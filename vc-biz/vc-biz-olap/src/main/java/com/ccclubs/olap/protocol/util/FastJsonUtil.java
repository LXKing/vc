package com.ccclubs.olap.protocol.util;


import com.ccclubs.olap.protocol.protocolmodel.evnet.EV_09_can;

/**
 * Created by admin on 2017/7/5.
 */
public class FastJsonUtil {

    public static  String getCanToGb(String values) {
        EV_09_can ev_09_can = new EV_09_can();
       String jsonString= ev_09_can.getGBFromCanData(Tools.HexString2Bytes(values) );
       if (jsonString==null){
           return null;
       }
       return  jsonString.replaceAll("\t"," ");
    }


}
