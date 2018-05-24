package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/9
 * @Time: 11:24
 * @Description: 自动驾驶状态
 */

public class MachineAdditional_Autopilot implements IMachineAdditionalItem {

    /**
     * 自动驾驶状态：
     * 0x0：默认值
     * 0x1:宾馆门口到车库门自动驾驶
     * 0x2：到达车库门
     * 0x3:进入停车场；
     * 0x4: 停车场内自动驾驶寻找车位;
     * 0x5:在车位旁停下；
     * 0x6: 泊车入库；
     * 0x7: 泊车完成
     * 0x8: 泊车出库
     * 0x9:自动驾驶驶出停车场
     * 0xA：到达停车场出库门
     * 0xB：驶出停车场，自动驾驶到酒店门口
     * 0xC：到达酒店门口
     * 0xD：异常情况
     * */
    private int autopilotState;

    public int getAutopilotState() {
        return autopilotState;
    }

    public void setAutopilotState(int autopilotState) {
        this.autopilotState = autopilotState;
    }

    @Override
    public byte getAdditionalId() {
        return (byte)154;
    }

    @Override
    public byte getAdditionalLength() {
        return 4;
    }

    @Override
    public byte[] WriteToBytes() {
        MyBuffer buff = new MyBuffer();
        buff.put(getAutopilotState());
        return buff.array();
    }

    @Override
    public void ReadFromBytes(byte[] bytes) {
        MyBuffer buff = new MyBuffer(bytes);
        setAutopilotState(buff.getInt());
    }
}
