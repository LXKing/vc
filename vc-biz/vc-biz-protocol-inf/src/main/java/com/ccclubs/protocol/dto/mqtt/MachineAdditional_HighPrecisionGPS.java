package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.MyBuffer;
import java.math.BigDecimal;

/**
 * 高精度经纬度【车辆自身经纬度】
 *
 * @author jianghaiyang
 * @create 2018-09-20
 **/
public class MachineAdditional_HighPrecisionGPS implements IMachineAdditionalItem {

    /**
     * 车辆自身经度
     */
    private int acuLongitude;

    /**
     * 车辆自身纬度
     */
    private int acuLatitude;

    /**
     * 车辆状态-自动行驶当前状态
     */
    private byte acuVehicleAdState;

    /**
     * 车辆启动控制方式-自动行驶当前车机指令状态
     */
    private byte vrtVehicleStart;

    public int getAcuLongitude() {
        return acuLongitude;
    }

    public void setAcuLongitude(int acuLongitude) {
        this.acuLongitude = acuLongitude;
    }

    public int getAcuLatitude() {
        return acuLatitude;
    }

    public void setAcuLatitude(int acuLatitude) {
        this.acuLatitude = acuLatitude;
    }

    public byte getAcuVehicleAdState() {
        return acuVehicleAdState;
    }

    public void setAcuVehicleAdState(byte acuVehicleAdState) {
        this.acuVehicleAdState = acuVehicleAdState;
    }

    public byte getVrtVehicleStart() {
        return vrtVehicleStart;
    }

    public void setVrtVehicleStart(byte vrtVehicleStart) {
        this.vrtVehicleStart = vrtVehicleStart;
    }

    public BigDecimal getLongitudeDecimal() {
        return AccurateOperationUtils
                .mul(getAcuLongitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getLatitudeDecimal() {
        return AccurateOperationUtils
                .mul(getAcuLatitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public byte getAdditionalId() {
        return (byte) 156;
    }

    @Override
    public byte getAdditionalLength() {
        return 16;
    }

    @Override
    public byte[] WriteToBytes() {
        MyBuffer buff = new MyBuffer();
        buff.put(getAcuLongitude());
        buff.put(getAcuLatitude());
        buff.put(getAcuVehicleAdState());
        buff.put(getVrtVehicleStart());

        return buff.array();
    }

    @Override
    public void ReadFromBytes(byte[] bytes) {
        MyBuffer buff = new MyBuffer(bytes);
        setAcuLongitude(buff.getInt());
        setAcuLatitude(buff.getInt());
        setAcuVehicleAdState(buff.get());
        setVrtVehicleStart(buff.get());
    }
}
