package com.ccclubs.gateway.jt808.mina;

import com.ccclubs.frm.spring.util.EnvironmentUtils;
import com.ccclubs.gateway.jt808.dto.GpsConnection;
import com.ccclubs.gateway.jt808.inf.I808MessageProcessService;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.online.OnlineConnection;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.StringUtils;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * JT808业务处理器
 */
public class JT808ServerHandler extends IoHandlerAdapter {

  private static final Logger logger = LoggerFactory.getLogger(JT808ServerHandler.class);

  @Resource(name = "jt808MessageProcessService")
  private I808MessageProcessService messageProcessService;
  @Resource
  RedisTemplate redisTemplate;
  @Resource
  EnvironmentUtils environmentUtils;

  // 终端连接集合
  private static ConcurrentMap<String, GpsConnection> connectionMap = new ConcurrentHashMap<>();

  public Collection<GpsConnection> getConnections() {
    return connectionMap.values();
  }

  private String getSimNo(IoSession session) {
    return "" + session.getAttribute("simNo");
  }

  public GpsConnection getConnection(String simNo) {
    if (simNo.length() > 11) {
      simNo = simNo.substring(1);
    }
    return connectionMap.get(simNo);
  }

  private GpsConnection getConnection(long sessionId, T808Message msg) {
    if (msg == null || msg.getSimNo() == null) {
      logger.debug("错误的空消息:");
      return null;
    }
    GpsConnection conn = connectionMap.get(msg.getSimNo());
    if (conn == null) {
      conn = new GpsConnection(msg.getSimNo(), sessionId);
      connectionMap.put(msg.getSimNo(), conn);
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
    T808Message tm = (T808Message) message;

    // T808Manager.putMsg(tm);
    session.setAttribute("simNo", tm.getSimNo());
    String clientIP = ((InetSocketAddress) session.getRemoteAddress()).getAddress()
        .getHostAddress();
    GpsConnection conn = getConnection(session.getId(), tm);
    if (conn != null) {
      conn.setConnected(true);
      // 消息处理
      messageProcessService.processMsg(tm);
      conn.setPlateNo(tm.getPlateNo()); // 设置连接的车牌号
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
      // 记录终端在线情况
      redisTemplate.opsForValue().set(ConstantUtils.ONLINE_REDIS_PRE + tm.getSimNo(),
          new OnlineConnection(tm.getSimNo(), clientIP, environmentUtils.getCurrentIp(),
              System.currentTimeMillis()),
          ConstantUtils.ONLINE_IDE_TIME, TimeUnit.MILLISECONDS);
      // 上行数据
      logger.info("UP >> {}{}", tm.getPacketDescr(), clientIP);
    }
    //		session.close(false);
  }

  public void messageSent(IoSession session, Object message) throws Exception {
    //		this.logger.info("SimNo:" + session.getAttribute("simNo") + "下发命令发送成功!");
  }

  public void sessionClosed(IoSession session) throws Exception {
    String simNo = "" + session.getAttribute("simNo");
    if (!StringUtils.empty(simNo)) {
      GpsConnection conn = connectionMap.get(simNo);
      if (conn != null) {
        conn.setConnected(false);
        conn.setDisconnectTimes(conn.getDisconnectTimes() + 1);
      }
    }
    if (session != null) {
      session.closeOnFlush();
    }
    logger.debug("与本地服务器断开连接, SimNo:" + simNo);
  }

  public void exceptionCaught(IoSession session, Throwable e) throws Exception {
    // this.logger.error(getSimNo(session) + "通讯时发生异常：" + e.getMessage(),
    // e);
    if (session != null) {
      session.closeOnFlush();
    }
    logger.debug(getSimNo(session) + "通讯时发生异常：" + e.getMessage());
  }

  public void sessionIdle(IoSession session, IdleStatus idle) throws Exception {
    String simNo = getSimNo(session);
    logger.debug(simNo + "空闲时间过长，系统将关闭连接");
    session.closeOnFlush();
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

  public void setMessageProcessService(I808MessageProcessService messageProcessService) {
    this.messageProcessService = messageProcessService;
  }

  public I808MessageProcessService getMessageProcessService() {
    return messageProcessService;
  }
}
