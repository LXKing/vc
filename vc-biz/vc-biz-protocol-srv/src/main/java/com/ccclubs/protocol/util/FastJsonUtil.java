package com.ccclubs.protocol.util;

import com.ccclubs.protocol.protocolmodel.convert.CanGBVehicle;
import com.ccclubs.protocol.protocolmodel.evnet.EVMessage;


/**
 * Created by admin on 2017/7/5.
 */
public class FastJsonUtil {

    public static  String getCanToGb(String values) {

        EVMessage  evMessage=new EVMessage();
        evMessage.ReadFromBytes(Tools.HexString2Bytes(values));

        String jsonString=null;
        if(evMessage.getMessageContents()!=null&&evMessage.getMessageContents().getCanList()!=null){
            if(evMessage.getMessageContents().getCanCount()>=3){
                jsonString= CanGBVehicle.getCan_gb(evMessage.getMessageContents().getCanList());
                jsonString= jsonString.replaceAll("\t"," ");
            }
        }
        return  jsonString;
    }


}
