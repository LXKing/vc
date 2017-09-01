package com.ccclubs.mongodb.orm.model;

import com.ccclubs.frm.mongodb.lang.AutomaticSequence;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by qsxiaogang on 2017/4/12.
 */
public abstract class AbstractDocument {

  @Id
  @AutomaticSequence
  private long id;
  @CreatedBy
  @Field("create_by")
  private long createBy;
  @CreatedDate
  @Field("create_date")
  private DateTime createDate;
  @LastModifiedBy
  @Field("last_modified_by")
  private long lastModifiedBy;
  @LastModifiedDate
  @Field("last_modified_date")
  private DateTime lastModifiedDate;
  @Field("del_flag")
  private int delFlag;
  @Version
  private long version;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getCreateBy() {
    return createBy;
  }

  public void setCreateBy(long createBy) {
    this.createBy = createBy;
  }

  public DateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(DateTime createDate) {
    this.createDate = createDate;
  }

  public long getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(long lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
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
    final StringBuilder sb = new StringBuilder("");
    sb.append("\"id\":")
        .append(id);
    sb.append(",\"createBy\":")
        .append(createBy);
    sb.append(",\"createDate\":")
        .append(createDate);
    sb.append(",\"lastModifiedBy\":")
        .append(lastModifiedBy);
    sb.append(",\"lastModifiedDate\":")
        .append(lastModifiedDate);
    sb.append(",\"delFlag\":")
        .append(delFlag);
    sb.append(",\"version\":")
        .append(version);
//    sb.append('}');
    return sb.toString();
  }
}
