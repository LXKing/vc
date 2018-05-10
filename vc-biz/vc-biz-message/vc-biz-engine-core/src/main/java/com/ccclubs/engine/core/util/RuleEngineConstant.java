package com.ccclubs.engine.core.util;

/**
 * Created by qsxiaogang on 2017/7/7.
 */
public class RuleEngineConstant {

  public static final String REDIS_KEY_VIN = "mappings:vin";
  public static final String REDIS_KEY_SIMNO = "mappings:simno";
  public static final String REDIS_KEY_CARNUM = "mappings:carnum";
  public static final String REDIS_KEY_TENO = "mappings:teno";
  public static final String REDIS_KEY_NOT_EXIST = "not-exist:";
  /*指令执行结果*/
  public static final String REDIS_KEY_CMD_REMOTE = "cmd:";

  public static final int REDIS_EXPIRE = 30 * 24 * 60 * 60;
  public static final int RENOTE_EXPIRE = 30;
  public static final String REMOTE_REDIS_PRE = "remoteOrder";

  public static final int MAPPING_REDIS_EXPIRE = 24 * 60 * 60;


  /*当前状态等待更新队列*/
  public static final String REDIS_KEY_STATE_UPDATE_QUEUE = "state:batchUpdate";
  /*历史状态等待写入队列 mongodb*/
  public static final String REDIS_KEY_HISTORY_STATE_INSERT_QUEUE = "historyState:insert";
  /*历史状态等待写入队列 hbase*/
  public static final String REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE = "historyState:batchInsert";

  /*当前CAN数据等待更新队列*/
  public static final String REDIS_KEY_CAN_UPDATE_QUEUE = "can:batchUpdate";
  /*历史CAN数据等待写入队列 mongodb*/
  public static final String REDIS_KEY_HISTORY_CAN_INSERT_QUEUE = "historyCan:insert";
  /*历史CAN数据等待写入队列 hbase*/
  public static final String REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE = "historyCan:batchInsert";

  /*历史国标数据等待写入队列 mongodb*/
  public static final String REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_MONGO_QUEUE = "message:batchInsert";
  /*历史国标数据等待写入队列 hbase*/
  public static final String REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_HBASE_QUEUE = "message:batchInsert";

  /**
   * MachineMapping 的查询参数类型
   */
  public static final String MACHINEMAPPING_SIMNO = "SIMNO";
  public static final String MACHINEMAPPING_CARNUMBER = "CARNUMBER";
  public static final String MACHINEMAPPING_VIN = "VIN";


}
