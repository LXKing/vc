package com.ccclubs.gateway.gb.mina;


import com.ccclubs.gateway.gb.inf.IGbServer;

public class GbServerFactory {

  public static String TANSPORT_BY_TCP = "tcp";
  private String transport;

  private GbTcpServer gbTcpServer;

  public IGbServer getJt808Server() {
    return gbTcpServer;
  }

  public String getTransport() {
    return transport;
  }

  public void setTransport(String transport) {
    this.transport = transport;
  }

  public GbTcpServer getGbTcpServer() {
    return gbTcpServer;
  }

  public void setGbTcpServer(GbTcpServer gbTcpServer) {
    this.gbTcpServer = gbTcpServer;
  }
}
