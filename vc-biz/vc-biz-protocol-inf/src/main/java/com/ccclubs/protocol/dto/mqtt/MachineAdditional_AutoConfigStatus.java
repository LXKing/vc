package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * User:Alban
 * Date:2018-1-10
 * */
public class MachineAdditional_AutoConfigStatus implements IMachineAdditionalItem {

    /**
     * 自动配置状态
     * */
    private Byte AutoConfigStatus;


    public Byte getAutoConfigStatus() {
        return AutoConfigStatus;
    }

    public void setAutoConfigStatus(Byte autoConfigStatus) {
        AutoConfigStatus = autoConfigStatus;
    }

    @Override
    public byte getAdditionalId() {
        return (byte) 152;
    }

    @Override
    public byte getAdditionalLength() {
        return 1;
    }

    @Override
    public byte[] WriteToBytes() {
        MyBuffer buff = new MyBuffer();
        buff.put(getAutoConfigStatus());
        return buff.array();
    }

    @Override
    public void ReadFromBytes(byte[] bytes) {
        MyBuffer buff = new MyBuffer(bytes);
        setAutoConfigStatus(buff.get());
    }
}
