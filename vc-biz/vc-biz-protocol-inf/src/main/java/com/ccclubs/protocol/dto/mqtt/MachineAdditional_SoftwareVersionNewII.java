package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by Administrator on 2017/8/15 0015.
 * 车机软件版本2
 */
public class MachineAdditional_SoftwareVersionNewII  implements IMachineAdditionalItem {

    /**
     * 软件版本2
     */
    private int softwareVersion;

    public int getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(int softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    @Override
    public byte getAdditionalId() {
        return 38;
    }

    @Override
    public byte getAdditionalLength() {
        return 4;
    }

    @Override
    public byte[] WriteToBytes() {
        MyBuffer buff = new MyBuffer();
        buff.put(getSoftwareVersion());
        return buff.array();
    }

    @Override
    public void ReadFromBytes(byte[] bytes) {
        MyBuffer buff = new MyBuffer(bytes);
        setSoftwareVersion(buff.getInt());
    }
}
