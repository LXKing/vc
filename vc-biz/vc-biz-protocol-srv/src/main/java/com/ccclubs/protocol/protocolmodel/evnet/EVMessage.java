package com.ccclubs.protocol.protocolmodel.evnet;

import com.ccclubs.protocol.util.MyBuffer;


/**
 * Created by Administrator on 2017/7/10 0010.
 * Evnet协议总称 （依据解析的bytes; 通过: 车辆id orderId funcode 判断具体是Evnet协议下的那条命令 ）
 */
public class EVMessage {

    //车辆Id编号（8 byte）
    private long  vehicleId;

    //订单Id编号(8 byte）
    private long  orderId;

    //功能码FucCode（1 byte）
    private int funcCode;

    //
    private  IEvMessage messageContents ;

//


    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(int funcCode) {
        this.funcCode = funcCode;
    }

    public IEvMessage getMessageContents() {
        return messageContents;
    }

    public void setMessageContents(IEvMessage messageContents) {
        this.messageContents = messageContents;
    }
 //

    public final void ReadFromBytes(byte[] messageBytes) {

        MyBuffer buff = new MyBuffer(messageBytes);
        setVehicleId(buff.getLong());
        setOrderId(buff.getLong());
        setFuncCode(buff.get());

        byte[] sourceData = new byte[messageBytes.length - 17];
        System.arraycopy(messageBytes, 17, sourceData, 0, sourceData.length);
        // 进行解析到具体的类中
        setMessageContents(EVMessageFactory.Create(getFuncCode(), sourceData));

    }

}
