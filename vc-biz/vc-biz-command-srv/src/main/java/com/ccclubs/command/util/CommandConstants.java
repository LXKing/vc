package com.ccclubs.command.util;

/**
 * 命令常量
 *
 * @author jianghaiyang
 * @create 2017-07-05
 **/
public class CommandConstants {
    // 众行EVPOP，远程控制指令ID在redis中存储的Key
    public static final String REMOTE_REDIS_PRE = "remoteOrder";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static long TIMEOUT = 10 * 1000;
    // Map key
    public static final String MAP_KEY_CSVEHICLE = "CsVehicle";
    public static final String MAP_KEY_CSMACHINE = "CsMachine";
    //指令ID cs_struct
    public static final Integer CMD_AIR = 18;       //空调控制
    public static final Integer CMD_POWER = 19;     //省电模式切换
    public static final Integer CMD_TIME = 81;      //终端校时
    public static final Integer CMD_RETURN = 65;    //还车检查配置（插枪还车状态写）
    public static final Integer CMD_DVD = 66;       //多媒体DVD最新版本写
    public static final Integer CMD_ORDER = 85;     //订单下发
    public static final Integer CMD_ORDER_AUTH = 86;//订单下发-有授权信息
    //风量fan 0:OFF 1:1档 2:2档 3:3档 4:4档
    public static final Integer[] FAN = {0, 1, 2, 3, 4};

}
