package com.ccclubs.olap.protocol.protocolmodel.gb;

/**
 * 车辆位置数据
 */
public class GB_02_05  {

    //字节位 BYTE; 描述 0 [0:有效定位；1:无效定位（当数据通信正常，而不能获取定位信息时，发送最后一次有效定位信息，并将定位状态置为无效。）]. 1 [0:北纬；1:南纬]. 2 [0:东经；1:西经]. * 3~7 保留
    private int positionStatus=-2;

    // DWORD ; 以度为单位的纬度值乘以10的6次方，精确到百万分之一度。
    private float latitude=-2;

    //DWORD ; 以度为单位的纬度值乘以10的6次方，精确到百万分之一度。
    private float longitude=-2;

//

    public int getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(int positionStatus) {
        this.positionStatus = positionStatus;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }


//

    public String getPositionStatusString(int positionStatus) {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append((positionStatus & 0x1) == 0 ? "有效定位" : "无效定位");
        sBuilder.append(";");
        sBuilder.append((positionStatus & 0x2) == 0 ? "北纬" : "南纬");
        sBuilder.append(";");
        sBuilder.append((positionStatus & 0x4) == 0 ? "东经" : "西经");

        return sBuilder.toString();
    }
//    public float getLongitudeString() {
//
//        return getLongitude();
//    }
//
//    public float getLatitudeString(){
//        return getLongitude();
//    }
}
