package com.ccclubs.protocol.dto.mqtt;


import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by Administrator on 2017/8/15 0015.
 * 插件版本
 */
public class MachineAdditional_PluginVersion implements IMachineAdditionalItem {

    /**
     * 插件插件版本
     */
    private int pluginVersion;

    public int getPluginVersion() {
        return pluginVersion;
    }

    public void setPluginVersion(int pluginVersion) {
        this.pluginVersion = pluginVersion;
    }

    @Override
    public byte getAdditionalId() {
        return 39;
    }

    @Override
    public byte getAdditionalLength() {
        return 4;
    }

    @Override
    public byte[] WriteToBytes() {
        MyBuffer buff = new MyBuffer();
        buff.put(getPluginVersion());
        return buff.array();
    }

    @Override
    public void ReadFromBytes(byte[] bytes) {
        MyBuffer buff = new MyBuffer(bytes);
        setPluginVersion(buff.getInt());
    }
}
