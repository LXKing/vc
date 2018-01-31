package com.ccclubs.gateway.zotye.constant;

/**
 * \* Created with IntelliJ IDEA2017.
 * \* User: Alban
 * \* Date: 2018/1/19
 * \* Time: 15:40
 * \* Description:
 * \
 */
public enum ServiceListForRouting {
    /*
    * 名称：注册绑定
    * 描述：在T服务平台绑定T-Box，并获取bid，PERAESkey。
    * */
    REGISTER_BIND(0x0,0x1),
    /*
   * 名称：登录
   * 描述：校验与激活当前T-Box并更新通信密钥
   * */
    LOGIN(0x0,0x2),
    /*
   * 名称：登出【预留】
   * 描述：终端主动退出
   * */
    LOGOUT(0x0,0x3),
    /*
   * 名称：重新登录【预留】
   * 描述：T服务平台通知T-Box重新登录
   * */
    RELOGIN(0x0,0x4),
    /*
   * 名称：取消息心跳【预留】
   * 描述：T-Box发送心跳请求，尝试获取未读的下行消息（非平台主动推送的下行消息）
   * */
    GET_MESSAGE_HEAREBEAT(0x0,0xB),
    /*
   * 名称：配置读取
   * 描述：T服务平台读取T-Box配置。
   * */
    READ_CONFIG(0x0,0x5),
    /*
   * 名称：配置下发
   * 描述：T服务平台下发配置至T-Box。
   * */
    ISSUED_CONFIG(0x0,0x7),
    /*
   * 名称：版本升级
   * 描述：T服务平台对T-Box进行远程升级
   * */
    UPDATE_VERSION(0x0,0x6),
    /*
   * 名称：通讯保持【预留】
   * 描述：T服务平台期望在一段时间后T-Box再次发送心跳请求。
   * */
    COMMUNICATION_MAINTAINED(0x0,0x2B),
    /*
   * 名称：持续活跃
   * 描述：T-Box发送持续活跃请求
   * */
    CONTINUED_ACTIVE(0x0,0x4B),
    /*
   * 名称：车辆控制下发
   * 描述：对控制的车辆进行某些动作。
   * */
    VEHICLE_CONTROL_ISSUED(0x1,0xF1),
    /*
   * 名称：CAN数据采集上报【预留】
   * 描述：上报can数据至T服务平台
   * */
    CAN_COLLECTION_REPORT(0x1,0xF2),
    /*
   * 名称：故障状态上报
   * 描述：车辆故障上报
   * */
    MALFUNCTION_STATE_REPORT(0x1,0xF3),
    /*
    * 名称：远程诊断【预留】
    * 描述：执行故障采集服务脚本，通过诊断方式获取故障码。
    * */
    REMOTE_DIAGNOSIS(0x1,0xF4),
    /*
    * 名称：车辆状态数据上报
    * 描述：上报车辆状态数据至T服务平台
    * */
    VEHICLE_STATE_REPORT(0x1,0xF5),
    /*
    * 名称：E-Call服务
    * 描述：人身救援服务
    * */
    ECALL_SERVICE(0x1,0xF6),
    /*
    * 名称：高频数据上报
    * 描述：高频数据上报（包括高频UBI等）
    * */
    HIGH_FREQUENCY_DATA_REPORT(0x1,0xF7),
    /*
    * 名称：国标车辆登入【预留】
    * 描述：对应A3.doc命令标识编码0x01
    * */
    GB_VEHICLE_LOGIN(0x2,0xE1),
    /*
    * 名称：国标车辆登出【预留】
    * 描述：对应A3.doc命令标识编码0x04
    * */
    GB_VEHICLE_LOGOUT(0x2,0xE2),
    /*
    * 名称：国标补发信息上报【预留】
    * 描述：对应A3.doc命令标识编码0x03
    * */
    GB_VEHICLE_REISSUE_INFO_REPORT(0x2,0xE3);

    private int messageFlag;
    private int aid;

    ServiceListForRouting(int messageFlag, int aid) {
        this.messageFlag = messageFlag;
        this.aid = aid;
    }

    public int getMessageFlag() {
        return messageFlag;
    }

    public void setMessageFlag(int messageFlag) {
        this.messageFlag = messageFlag;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
