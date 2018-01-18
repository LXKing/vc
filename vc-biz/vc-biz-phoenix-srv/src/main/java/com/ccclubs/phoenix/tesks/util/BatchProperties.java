package com.ccclubs.phoenix.tesks.util;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author qsxiaogang
 * @create 2017-10-13
 **/
@ConfigurationProperties(prefix = "ccclubs.data.batch")
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
  private int updateMaxDurTime = 5000;
  /**
   * update 单次任务批量开启的线程数
   */
  private int updateThreads = 20;
  /**
   * update 队列中最大数量
   */
  private int updateQueueMax = 5 * 10000;

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
  /**
   * hbase insert 单次任务开启的线程数量
   */
  private int hbaseInsertThreads = 20;
  /**
   * hbase insert 队列中最大数量
   */
  private int hbaseInsertQueueMax = 20 * 10000;

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

  public int getUpdateThreads() {
    return updateThreads;
  }

  public void setUpdateThreads(int updateThreads) {
    this.updateThreads = updateThreads;
  }

  public int getHbaseInsertThreads() {
    return hbaseInsertThreads;
  }

  public void setHbaseInsertThreads(int hbaseInsertThreads) {
    this.hbaseInsertThreads = hbaseInsertThreads;
  }

  public int getUpdateQueueMax() {
    return updateQueueMax;
  }

  public void setUpdateQueueMax(int updateQueueMax) {
    this.updateQueueMax = updateQueueMax;
  }



  public int getHbaseInsertQueueMax() {
    return hbaseInsertQueueMax;
  }

  public void setHbaseInsertQueueMax(int hbaseInsertQueueMax) {
    this.hbaseInsertQueueMax = hbaseInsertQueueMax;
  }
}
