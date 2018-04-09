package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/9
 * @Time: 11:14
 * @Description: 手刹状态
 */

public class MachineAdditional_Handbrake implements IMachineAdditionalItem {

    /**
     * 手刹状态：
     * 0x0=所有刹车释放；
     * 0x1=所有刹车应用；
     * 0x2=所有刹车不工作（应用或释放中）；
     * 0x3=未知；
     * */
    private int handbrakeState;

    public int getHandbrakeState() {
        return handbrakeState;
    }

    public void setHandbrakeState(int handbrakeState) {
        this.handbrakeState = handbrakeState;
    }

    @Override
    public byte getAdditionalId() {
        return (byte)153;
    }

    @Override
    public byte getAdditionalLength() {
        return 1;
    }

    @Override
    public byte[] WriteToBytes() {
        MyBuffer buff = new MyBuffer();
        buff.put(getHandbrakeState());
        return buff.array();
    }

    @Override
    public void ReadFromBytes(byte[] bytes) {
        MyBuffer buff = new MyBuffer(bytes);
        setHandbrakeState(buff.getInt());
    }
}
