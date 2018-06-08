package com.ccclubs.gateway.jt808.constant.msg;

import com.ccclubs.gateway.jt808.message.pac.Package808;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.function.Function;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 15:17
 * Email:  yeanzhi@ccclubs.com
 * 下行报文类型
 */
public enum DownPacType {
    /**
     * 平台通用应答
     */
    ACK_NORMAL(0X8001, "平台通用应答", null),

    /**
     * 补传分包请求
     */
    SUPPLE(0X8003, "补传分包请求", null),

    /**
     * 终端注册应答
     */
    ACK_REGISTER(0X8100, "终端注册应答", (authCode) -> {
        ByteBuf contentBuf = Unpooled.buffer();
        contentBuf.writeBytes(((String) authCode).getBytes());
        return contentBuf;
    }),

    /**
     * 设置终端参数
     */
    SET_PARAM(0X8103, "设置终端参数", null),

    /**
     * 查询终端参数
     */
    QUERY_PARAM(0X8104, "查询终端参数", null),

    /**
     * 终端控制
     */
    CONTROL(0X8105, "终端控制", null),

    /**
     * 查询指定终端参数
     */
    QUERY_SPECIFY_PARAM(0X8106, "查询指定终端参数", null),

    /**
     * 查询终端属性
     */
    QUERY_ATTR(0X8107, "查询终端属性", null),

    /**
     * 下发终端升级包
     */
    SEND_UPGRADE(0X8108, "下发终端升级包", null),

    /**
     * 位置信息查询
     */
    QUERY_POSITION(0X8201, "位置信息查询", null),

    /**
     * 临时位置跟踪控制
     */
    TRACK_POSITION(0X8202, "临时位置跟踪控制", null),

    /**
     * 人工确认报警消息
     */
    ALARM_MANUAL(0X8203, "人工确认报警消息", null),

    /**
     * 文本消息下发
     */
    SEND_TEXT(0X8300, "文本消息下发", null),

    /**
     * 事件设置
     */
    EVENT_SET(0X8301, "事件设置", null),

    /**
     * 提问下发
     */
    SEND_QUESTION(0X8302, "提问下发", null),

    /**
     * 信息点播菜单设置
     */
    SET_NEWS(0x8303, "信息点播菜单设置", null),

    /**
     * 信息服务
     */
    NEWS_SERVICE(0X8304, "信息服务", null),

    /**
     * 电话回拨
     */
    CALL_BACK(0x8400, "电话回拨", null),

    /**
     * 设置电话本
     */
    SET_PHONE_BOOK(0x8401, "设置电话本", null),

    /**
     * 车辆控制
     */
    CAR_CONTROL(0x8500, "车辆控制", null),

    /**
     * 设置圆形区域
     */
    SET_AREA_CIR(0x8600, "设置圆形区域", null),

    /**
     * 删除圆形区域
     */
    DEL_AREA_CIR(0x8601, "删除圆形区域", null),

    /**
     * 设置矩形区域
     */
    SET_AREA_REC(0x8602, "设置矩形区域", null),

    /**
     * 删除矩形区域
     */
    DEL_AREA_REC(0x8603, "删除矩形区域", null),

    /**
     * 设置多边形区域
     */
    SET_AREA_POLYGONAL(0x8604, "设置多边形区域", null),

    /**
     * 删除多边形区域
     */
    DEL_AREA_POLYGONAL(0x8605, "删除多边形区域", null),

    /**
     * 设置路线
     */
    SET_ROUTE(0x8606, "设置路线", null),

    /**
     * 删除路线
     */
    DEL_ROUTE(0x8607, "删除路线", null),

    /**
     * 行驶记录仪数据采集命令
     */
    DRIVE_RECORD_COLLECT(0x8700, "行驶记录仪数据采集命令", null),

    /**
     * 行驶记录仪参数下传命令
     */
    DRIVE_RECORD_PARAM(0x8601, "行驶记录仪参数下传命令", null),

    /**
     * 上报驾驶员身份信息请求
     */
    REQ_DRIVER_DATA(0x8702, "上报驾驶员身份信息请求", null),

    /**
     * 多媒体数据上传应答
     */
    ACK_MEDIA_DATA(0x8800, "多媒体数据上传应答", null),

    /**
     * 存储多媒体数据检索
     */
    REQ_MEDIA_STORE(0x8802, "存储多媒体数据检索", null),

    /**
     * 存储多媒体数据上传
     */
    MEDIA_DATA_UPLOAD(0x8803, "存储多媒体数据上传", null),

    /**
     * 录音开始命令
     */
    RECORDING_START(0x8804, "录音开始命令", null),

    /**
     * 单条存储多媒体数据检索上
     * 传命令
     */
    SINGLE_MEDIA_SEARCH(0x8805, "单条存储多媒体数据检索上传命令", null),

    /**
     * 平台透传传输
     */
    SEND_MQTT(0x8900, "平台透传传输", null),

    /**
     * 扩展终端参数设置1指令
     */
    EXTRA_SET_PARAM(0xFF03, "扩展终端参数设置1指令", null),

    /**
     * 查询扩展终端参数1指令
     */
    EXTRA_SEARCH_PARAM(0xFF04, "查询扩展终端参数1指令", null);

    private int code;
    private String des;
    private Function<Object, ByteBuf> function;
    DownPacType(int code, String des, Function function) {
        this.code = code;
        this.des = des;
        this.function = function;
    }

    public int getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    public Function<Object, ByteBuf> getFunction() {
        return function;
    }

    public static DownPacType getByCode(int code) {
        for (DownPacType e :
                DownPacType.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

}
