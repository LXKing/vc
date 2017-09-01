package com.ccclubs.protocol.dto;

/**
 * 通用结果返回
 * Created by qsxiaogang on 2017/5/31.
 */
public class CommonResult<T> {


  private boolean success;
  private long messageId;
  private int code;
  private String message;
  private T data;

  public CommonResult() {
  }

  public CommonResult(boolean success, int code, String message) {
    this.success = success;
    this.code = code;
    this.message = message;
  }

  public CommonResult(long messageId, boolean success, int code, String message) {
    this.success = success;
    this.code = code;
    this.message = message;
    this.messageId = messageId;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public long getMessageId() {
    return messageId;
  }

  public void setMessageId(long messageId) {
    this.messageId = messageId;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static CommonResult create(boolean success, int code, String message) {
    return new CommonResult(success, code, message);
  }

  public static CommonResult create(boolean success, int code, String message, String data) {
    CommonResult commonResult = new CommonResult(success, code, message);
    commonResult.data = data;
    return commonResult;
  }

  public static CommonResult create(long messageId, boolean success, int code, String message) {
    return new CommonResult(messageId, success, code, message);
  }
}
