package com.ccclubs.command.util;

/**
 * 命令常量
 *
 * @author jianghaiyang
 * @create 2017-07-05
 **/
public class CommandConstants {
    // 众行EVPOP，远程控制指令ID在redis中存储的Key
    public static final String REMOTE_REDIS_PRE = "cmd:";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final long TIMEOUT = 16 * 1000L;
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
    public static final Integer CMD_LOCK = 102;     //车门落锁-带控制参数
    public static final Integer CMD_SITE = 110;//站点下发
    public static final Integer CMD_VOICE = 109;//语音编号下发
    public static final Integer CMD_TAMPER=127;//防拆指令下发

    public static final Integer CMD_UPGREAD_FILE=68;//带文件名升级
    //风量fan 0:OFF 1:1档 2:2档 3:3档 4:4档
    public static final Integer[] FAN = {0, 1, 2, 3, 4};

}
