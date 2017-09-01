package com.ccclubs.protocol.util;

/**
 * MQ消息 TAG 类型
 *
 * @author qsxiaogang
 */
public class MqTagProperty {

  // 包括 车机端订单下发回复、订单详细数据回复，续订回复 TAG
  public static String MQ_TERMINAL_ORDER = "terminal_order_";
  // 车机端 上行远程控制 TAG
  public static String MQ_TERMINAL_REMOTE = "terminal_remote_";
  // 车机端 状态数据 TAG
  public static String MQ_TERMINAL_STATUS = "terminal_status_";
  // 车机端 触发状态数据 TAG
  public static String MQ_TERMINAL_TRIGGER = "terminal_trigger_";
  // 车机端 报警数据 TAG
  public static String MQ_TERMINAL_ALARM = "terminal_alarm_";
  // 车机端 CAN数据 TAG
  public static String MQ_TERMINAL_CAN = "terminal_can_";
  // 车机端 CAN数据 补传 TAG
  public static String MQ_TERMINAL_CAN_FD = "terminal_can_fd_";
  // 车机端 取车数据回复 TAG
  public static String MQ_TERMINAL_TAKECAR = "terminal_takecar_";
  // 车机端 还车数据回复 TAG
  public static String MQ_TERMINAL_FURTHERCAR = "terminal_furthercar_";
  // 车机端 基本属性 TAG
  public static String MQ_TERMINAL_INFO = "terminal_info_";

  // 车机端 国标消息 TAG
  public static String MQ_TERMINAL_GB = "terminal_gb_";
}
