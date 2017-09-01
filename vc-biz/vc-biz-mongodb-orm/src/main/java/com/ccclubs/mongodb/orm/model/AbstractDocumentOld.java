package com.ccclubs.mongodb.orm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

/**
 * 为了支持老的CsRemote结构
 * Created by qsxiaogang on 2017/4/12.
 */
public abstract class AbstractDocumentOld {

  @Id
  private String id;
  @Version
  private int version;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }
}
