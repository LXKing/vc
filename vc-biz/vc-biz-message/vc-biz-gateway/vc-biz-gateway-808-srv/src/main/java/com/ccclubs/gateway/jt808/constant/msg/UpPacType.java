package com.ccclubs.gateway.jt808.constant.msg;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 15:13
 * Email:  yeanzhi@ccclubs.com
 * 上行报文类型
 *      注意：
 *          终端的应答消息命名时使用"ACK"作为前缀
 */
public enum UpPacType {
    /**
     * 终端通用应答
     */
    ACK(0X0001, "终端通用应答", true),

    /**
     * 终端心跳
     */
    HEART(0X0002, "终端心跳", true),

    /**
     * 终端注销
     */
    LOGOUT(0X0003, "终端注销", true),

    /**
     * 终端注册
     */
    REGISTER(0X0100, "终端注册", true),

    /**
     * 终端鉴权
     */
    AUTH(0X0102, "终端鉴权", true),

    /**
     * 查询终端参数应答
     */
    ACK_QUERY_PARAM(0x0104, "查询终端参数应答", false),

    /**
     * 查询终端属性应答
     */
    ACK_QUERY_ATTR(0X0107, "查询终端属性应答", false),

    /**
     * 终端升级结果通知
     */
    ACK_UPGRADE(0X0108, "终端升级结果通知", false),

    /**
     * 终端升级应答
     */
    ACK_UPGRADE_TL(0x01F0, "终端升级应答", true),

    /**
     * 终端升级应答
     */
    REQ_VIN_SYN(0x01F4, "终端同步VIN码", false),

    /**
     * 位置信息汇报
     */
    POSITION_REPORT(0X0200, "位置信息汇报", true),

    /**
     * 位置信息查询应答
     */
    ACK_QUERY_POSITION(0X0201, "位置信息查询应答", true),

    /**
     * 事件报告
     */
    EVENT_REPORT(0X0301, "事件报告", false),

    /**
     * 提问应答
     */
    ACK_QUESTION(0X0302, "提问应答", false),

    /**
     * 信息点播/取消
     */
    NEWS(0X0303, "信息点播/取消", false),

    /**
     * 车辆控制应答
     */
    ACK_CONTROL(0X0500, "车辆控制应答", false),

    /**
     * 行驶记录仪数据上传
     */
    DRIVE_RECORDER_DATA(0x0700, "行驶记录仪数据上传", false),

    /**
     * 电子运单上报
     */
    ELECTRONIC_WAYBILL(0x0701, "电子运单上报", false),

    /**
     * 驾驶员身份信息采集上报
     */
    DRIVER_AUTH_REPORT(0x0702, "驾驶员身份信息采集上报", false),

    /**
     * 定位数据批量上传
     */
    BATCH_POSITION(0x0704, "定位数据批量上传", true),

    /**
     * CAN 总线数据上传
     */
    CAN_DATA(0x0705, "CAN 总线数据上传", false),

    /**
     * 多媒体事件信息上传
     */
    MEDIA_EVENT(0x0800, "多媒体事件信息上传", false),

    /**
     * 多媒体数据上传
     */
    MEDIA_DATA(0x0801, "多媒体数据上传", false),

    /**
     * 存储多媒体数据检索应答
     */
    ACK_MEDIA_SEARCH(0x0802, "存储多媒体数据检索应答", false),

    /**
     * 摄像头立即拍摄命令应答
     */
    ACK_CAMERA(0x0805, "摄像头立即拍摄命令应答", false),

    /**
     * 数据上行透传
     */
    PENETRATE_UP(0x0900, "数据上行透传", true),

    /**
     * 数据压缩上报
     */
    DATA_ZIP(0x0901, "数据压缩上报", false),

    /**
     * 终端 RSA 公钥
     */
    TER_RSA_KEY(0x0A00, "终端 RSA 公钥", false),
    /**
     * 终端CAN过滤表
     */
    TER_CAN_TABLE(0x7F04, "终端CAN过滤表", true);

    private int code;
    private String des;
    /**
     * 标识该消息是否对外发送（ons、kafka等）
     */
    private boolean needSendout;
    UpPacType(int code, String des, boolean needSendout) {
        this.code = code;
        this.des = des;
        this.needSendout = needSendout;
    }

    public int getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    public boolean getNeedSendout() {
        return this.needSendout;
    }

    public static UpPacType getByCode(int code) {
        for (UpPacType e :
                UpPacType.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    // 预期的期望值，逗号分隔
    public static String expectedVals() {
        StringBuilder valSb = new StringBuilder();
        for (UpPacType c :
                UpPacType.values()) {
            valSb.append(Integer.toHexString(c.getCode())).append(",");
        }
        // 删除最后一个逗号
        valSb.deleteCharAt(valSb.length() - 1);
        return valSb.toString();
    }
}
