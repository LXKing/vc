package com.ccclubs.mongo.orm.model;

import com.ccclubs.frm.spring.annotation.AutomaticSequence;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

/**
 * Created by qsxiaogang on 2017/4/12.
 */
public class AbstractDocument {

  @Id
  @AutomaticSequence
  private long id;
  @CreatedDate
  private DateTime createDate;
  @LastModifiedDate
  private DateTime lastModifiedDate;
  private int delFlag;
  @Version
  private long version;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public DateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(DateTime createDate) {
    this.createDate = createDate;
  }

  public DateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(DateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public int getDelFlag() {
    return delFlag;
  }

  public void setDelFlag(int delFlag) {
    this.delFlag = delFlag;
  }

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
//    sb.append("\"id\":")
//        .append(id);
    sb.append(",\"createDate\":")
        .append(createDate);
    sb.append(",\"lastModifiedDate\":")
        .append(lastModifiedDate);
    sb.append(",\"delFlag\":")
        .append(delFlag);
    sb.append(",\"version\":")
        .append(version);
    sb.append('}');
    return sb.toString();
  }
}
