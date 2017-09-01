package com.ccclubs.frm.mongodb.document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "LZPrimary")
public class LZPrimary {

  @Field("id")
  private long sequenceId;

  @Field("name")
  private String documentName;

  public LZPrimary(Long sequenceId, String documentName) {
    this.sequenceId = sequenceId;
    this.documentName = documentName;
  }

  public long getSequenceId() {
    return sequenceId;
  }

  public void setSequenceId(long sequenceId) {
    this.sequenceId = sequenceId;
  }

  public String getDocumentName() {
    return documentName;
  }

  public void setDocumentName(String documentName) {
    this.documentName = documentName;
  }
}