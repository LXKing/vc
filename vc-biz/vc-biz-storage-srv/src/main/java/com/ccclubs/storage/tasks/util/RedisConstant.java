package com.ccclubs.storage.tasks.util;

/**
 * Created by qsxiaogang on 2017/7/7.
 */
public class RedisConstant {

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


}
