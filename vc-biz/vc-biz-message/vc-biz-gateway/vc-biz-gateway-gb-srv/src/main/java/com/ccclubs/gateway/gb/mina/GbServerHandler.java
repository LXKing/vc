package com.ccclubs.gateway.gb.mina;

import com.ccclubs.gateway.gb.dto.GpsConnection;
import com.ccclubs.gateway.gb.inf.IGbMessageProcessService;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.util.StringUtils;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Resource;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * GB业务处理器
 */
public class GbServerHandler extends IoHandlerAdapter {

  private static final Logger logger = LoggerFactory.getLogger(GbServerHandler.class);
  @Resource(name = "gbMessageProcessService")
  private IGbMessageProcessService messageProcessService;
  // 终端连接集合
  private static ConcurrentMap<String, GpsConnection> connctionMap = new ConcurrentHashMap<String, GpsConnection>();

  public Collection<GpsConnection> getConnections() {
    return connctionMap.values();
  }

  private String getVin(IoSession session) {
    return "" + session.getAttribute("vin");
  }

  public GpsConnection getConnection(String vin) {
    GpsConnection conn = connctionMap.get(vin);
    return conn;
  }

  private GpsConnection getConnection(long sessionId, GBMessage msg) {
    if (msg == null || msg.getVin() == null) {
      logger.error("错误的空消息:");
      return null;
    }
    GpsConnection conn = connctionMap.get(msg.getVin());
    if (conn == null) {
      conn = new GpsConnection(msg.getVin(), sessionId);
      connctionMap.put(msg.getVin(), conn);
    } else if (conn.getSessionId() != sessionId) {
      // 新的连接
      // logger.error(msg.getSimNo() + "接入新的连接");
      conn.setSessionId(sessionId);
    }
    conn.setOnlineDate(new Date());
    conn.setSessionId(sessionId);

    return conn;
  }

  public void messageReceived(IoSession session, Object message) throws Exception {
    // tm.platform.server.LocalServer.session = session;
    GBMessage tm = (GBMessage) message;

    session.setAttribute("vin", tm.getVin());
    GpsConnection conn = getConnection(session.getId(), tm);
    if (conn != null) {
      conn.setConnected(true);
      // 消息处理
      messageProcessService.processMsg(tm);
      //			conn.setPlateNo(tm.getPlateNo()); // 设置连接的车牌号
      if (conn.getPackageNum() == Integer.MAX_VALUE) {
        conn.setPackageNum(0);
        conn.setErrorPacketNum(0);
      }

      conn.setPackageNum(conn.getPackageNum() + 1);

      if (tm.getErrorMessage() != null) {
        // 收到错误解析的包
        conn.setErrorPacketNum(conn.getErrorPacketNum() + 1);
      }
      if (tm.getHeader() != null && tm.getHeader().getMessageType() == 0x0200) {
        conn.setPositionPackageNum(conn.getPositionPackageNum() + 1);
      }
      // 上行数据
      logger.info(
          "UP >> " + tm.getVin() + " 消息ID:" + Integer.toHexString(tm.getMessageType()) + "  " + tm
              .getPacketDescr());
    }
    //		session.close(false);
  }

  public void messageSent(IoSession session, Object message) throws Exception {
    //		this.logger.info("SimNo:" + session.getAttribute("simNo") + "下发命令发送成功!");
  }

  public void sessionClosed(IoSession session) throws Exception {
    String vin = "" + session.getAttribute("vin");
    if (!StringUtils.empty(vin)) {
      GpsConnection conn = connctionMap.get(vin);
      if (conn != null) {
        // connctionMap.remove(simNo);
        conn.setConnected(false);
        conn.setDisconnectTimes(conn.getDisconnectTimes() + 1);
      }
    }
    if (session != null) {
      session.close(true);
    }
    this.logger.info("与本地服务器断开连接, Vin:" + vin);
  }

  public void exceptionCaught(IoSession session, Throwable e) throws Exception {
    // this.logger.error(getSimNo(session) + "通讯时发生异常：" + e.getMessage(),
    // e);
    if (session != null) {
      session.close(true);
    }
    this.logger.error(getVin(session) + "通讯时发生异常：" + e.getMessage());
  }

  public void sessionIdle(IoSession session, IdleStatus idle) throws Exception {
    String simNo = getVin(session);
    this.logger.info(simNo + "空闲时间过长，系统将关闭连接");
    session.close(true);
  }

  public void sessionCreated(IoSession session) throws Exception {
    // 当网络连接被创建时此方法被调用（这个肯定在sessionOpened(IoSession
    // session)方法之前被调用），这里可以对Socket设置一些网络参数
    IoSessionConfig cfg1 = session.getConfig();
    if (cfg1 instanceof SocketSessionConfig) {
      SocketSessionConfig cfg = (SocketSessionConfig) session.getConfig();
      // ((SocketSessionConfig) cfg).setReceiveBufferSize(4096);
      cfg.setReceiveBufferSize(2 * 1024 * 1024);
      cfg.setReadBufferSize(2 * 1024 * 1024);
      cfg.setKeepAlive(true);
      // if (session.== TransportType.SOCKET) {
      // ((SocketSessionConfig) cfg).setKeepAlive(true);
      ((SocketSessionConfig) cfg).setSoLinger(0);
      ((SocketSessionConfig) cfg).setTcpNoDelay(true);
      ((SocketSessionConfig) cfg).setWriteTimeout(10000);
    }

  }

  public void sessionOpened(IoSession session) throws Exception {
    //		session.getConfig().setBothIdleTime(360);//set timeout seconds, must
  }
}
