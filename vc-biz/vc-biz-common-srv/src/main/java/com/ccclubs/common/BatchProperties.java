package com.ccclubs.common;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author qsxiaogang
 * @create 2017-10-13
 **/
@ConfigurationProperties(prefix = "ccclubs.batch")
public class BatchProperties {

  /**
   * update 任务定时执行周期，单位毫秒
   */
  private int updateAutoLoadTime = 1000;
  /**
   * update 单次任务批量update数量
   */
  private int updateBatchSize = 1000;
  /**
   * update 单次任务批量最大时间，建议小于任务定时执行周期
   */
  private int updateMaxDurTime = 10000;

  /**
   * mongo insert 任务定时执行周期，单位毫秒
   */
  private int mongoInsertAutoLoadTime = 5000;
  /**
   * mongo insert 单次任务批量update数量
   */
  private int mongoInsertBatchSize = 1000;
  /**
   * mongo insert 单次任务批量最大时间，建议小于任务定时执行周期
   */
  private int mongoInsertMaxDurTime = 20000;

  /**
   * hbase insert 任务定时执行周期，单位毫秒
   */
  private int hbaseInsertAutoLoadTime = 5000;
  /**
   * hbase insert 单次任务批量update数量
   */
  private int hbaseInsertBatchSize = 2000;
  /**
   * hbase insert 单次任务批量最大时间，建议小于任务定时执行周期
   */
  private int hbaseInsertMaxDurTime = 3000;

  public int getUpdateAutoLoadTime() {
    return updateAutoLoadTime;
  }

  public void setUpdateAutoLoadTime(int updateAutoLoadTime) {
    this.updateAutoLoadTime = updateAutoLoadTime;
  }

  public int getUpdateBatchSize() {
    return updateBatchSize;
  }

  public void setUpdateBatchSize(int updateBatchSize) {
    this.updateBatchSize = updateBatchSize;
  }

  public int getUpdateMaxDurTime() {
    return updateMaxDurTime;
  }

  public void setUpdateMaxDurTime(int updateMaxDurTime) {
    this.updateMaxDurTime = updateMaxDurTime;
  }

  public int getMongoInsertAutoLoadTime() {
    return mongoInsertAutoLoadTime;
  }

  public void setMongoInsertAutoLoadTime(int mongoInsertAutoLoadTime) {
    this.mongoInsertAutoLoadTime = mongoInsertAutoLoadTime;
  }

  public int getMongoInsertBatchSize() {
    return mongoInsertBatchSize;
  }

  public void setMongoInsertBatchSize(int mongoInsertBatchSize) {
    this.mongoInsertBatchSize = mongoInsertBatchSize;
  }

  public int getMongoInsertMaxDurTime() {
    return mongoInsertMaxDurTime;
  }

  public void setMongoInsertMaxDurTime(int mongoInsertMaxDurTime) {
    this.mongoInsertMaxDurTime = mongoInsertMaxDurTime;
  }

  public int getHbaseInsertAutoLoadTime() {
    return hbaseInsertAutoLoadTime;
  }

  public void setHbaseInsertAutoLoadTime(int hbaseInsertAutoLoadTime) {
    this.hbaseInsertAutoLoadTime = hbaseInsertAutoLoadTime;
  }

  public int getHbaseInsertBatchSize() {
    return hbaseInsertBatchSize;
  }

  public void setHbaseInsertBatchSize(int hbaseInsertBatchSize) {
    this.hbaseInsertBatchSize = hbaseInsertBatchSize;
  }

  public int getHbaseInsertMaxDurTime() {
    return hbaseInsertMaxDurTime;
  }

  public void setHbaseInsertMaxDurTime(int hbaseInsertMaxDurTime) {
    this.hbaseInsertMaxDurTime = hbaseInsertMaxDurTime;
  }
}
