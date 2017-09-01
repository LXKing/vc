package com.ccclubs.gateway.jt808.inf;


public interface IJT808TransferService {

  void startTransfer();

  void stop();

  void setJt808Server(IJT808Server jt808Server);

}