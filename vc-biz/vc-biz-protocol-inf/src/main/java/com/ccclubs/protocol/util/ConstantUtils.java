package com.ccclubs.protocol.util;

/**
 * 程序中用到的约束，及常量
 */
public final class ConstantUtils {
  public static final Long SECOND = 1000L;
  public static final Long MINUTE = SECOND * 60L;
  public static final Long HOUR = MINUTE * 60L;
  public static final Long DAY = HOUR * 24;
  public static final long MONTH = DAY * 31;
  public static final long YEAR = DAY * 365;

  // 记录终端在线的 redis key
  public static final String ONLINE_REDIS_PRE = "online:";
  // 终端在线的 exprie 时间
  public static final Long ONLINE_IDE_TIME = 6 * MINUTE;

  public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String TIME_FORMAT_KEY = "_yyyy-MM-dd_HH-mm-ss";
  // 终端实际时间与服务器时间间隔
  public static final Long TimeSynchronizationDur = 5 * SECOND;
  // 2000年的毫秒数
  public static final long MACHINE_TIME = StringUtils.date("2000-01-01 00:00:00", TIME_FORMAT)
      .getTime();
  // 2008年的毫秒数
  public static final long MIN_SYSTEM_TIME = StringUtils.date("2008-01-01 00:00:00", TIME_FORMAT)
      .getTime();

  public static final String SEPARATOR = ",";
  // 众行EVPOP，远程控制指令ID在redis中存储的Key
  public static final String REMOTE_REDIS_PRE = "remoteOrder";
  // 众车纷享 订单下发订单ID 在redis中存储的Key
  public static final String ORDER_REDIS_PRE = "order";
  /**
   * 自定义mqtt消息最短长度
   */
  public final static int MessageMinimumLength = 17;
  // 应用间MQ topic
  public static final String MQ_CAR = "mq.car";
  public static final String MQ_TOPIC = "mq.topic";
  public static final String MQ_PROTOCOL = "mq.protocol";
  // 应用内日志
  private static final String LOG_PRE = "mq.log";
  private static final String LOG_DOT = ".";


  // 808
  public static final String NOTIFY_FD = "JT0900FD";

  public static final String LOG_SHOW_SOURCE = LOG_PRE + LOG_DOT + "showSource";
}
