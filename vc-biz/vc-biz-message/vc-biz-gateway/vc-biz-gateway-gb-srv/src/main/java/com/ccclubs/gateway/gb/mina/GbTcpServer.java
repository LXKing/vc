package com.ccclubs.gateway.gb.mina;

import com.ccclubs.gateway.gb.dto.GpsConnection;
import com.ccclubs.gateway.gb.inf.IGbServer;
import java.net.InetSocketAddress;
import java.util.Collection;
import javax.annotation.Resource;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于tcp的808服务器
 */
public class GbTcpServer implements IGbServer {

  private static final Logger logger = LoggerFactory.getLogger(GbTcpServer.class);

  private boolean isOpen = false;

  // private IJT808Server instance = null;

  private int port; // 服务端口号
  private int maxOfflineTime; // 终端与服务超时时间
  private IoAcceptor dataAccepter = null;
  @Resource(name = "gbHandler")
  private GbServerHandler gbHandler;

  @Override
  public void stop() {
    if (null != dataAccepter) {
      dataAccepter.unbind();
      dataAccepter.getFilterChain().clear(); // 清空Filter
      // chain，防止下次重新启动时出现重名错误
      dataAccepter.dispose();
      dataAccepter = null;
      // System.exit(0); 将导致容器停止
    }
  }

  /**
   * 获得当前的连接列表
   */
  public Collection<GpsConnection> getGpsConnections() {
    return gbHandler.getConnections();
  }

  @Override
  public boolean isOnline(String vin) {
    if (vin == null || vin.length() == 0) {
      logger.error(vin + "不能为空");
      return false;
    }
    GpsConnection conn = gbHandler.getConnection(vin);
    if (conn != null) {
      IoSession session = getSession(conn.getSessionId());
      if (session == null) {
        logger.error(vin + "找不到对应的链接的session,判断离线");
      } else if (session.isConnected() == false) {
        logger.error(vin + "session关闭,判断离线");
      } else
      // logger.error(simNo+"上线");
      {
        return session != null && session.isConnected();
      }
    } else {
      logger.error(vin + "没有此链接,判断离线");
    }
    return false;
  }

  /**
   * 向终端下发命令数据
   */
  public boolean send(String vin, byte[] msg) {
    GpsConnection conn = gbHandler.getConnection(vin);
    if (conn != null) {
      return send(conn.getSessionId(), msg);
    }
    return false;
  }

  /**
   * 向终端下发命令数据
   */
  public boolean send(long sessionId, byte[] msg) {
    try {
      IoSession session = getSession(sessionId);
      if (session != null && session.isConnected()) {
        WriteFuture wf = session.write(msg);
        wf.awaitUninterruptibly(1000);
        if (wf.isWritten()) {
          return true;
        } else {
          Throwable tr = wf.getException();
          if (tr != null) {
            logger.error(tr.getMessage(), tr);
          }

          return false;
        }

      }
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
    }
    return false;
  }

  public IoSession getSession(long sid) {
    return dataAccepter.getManagedSessions().get(sid);
  }

  /**
   * 启动TCP服务
   */
  @Override
  public boolean start() {
    try {
      dataAccepter = new NioSocketAcceptor();
      // 编码、解码
      dataAccepter.getFilterChain()
          .addLast("codec", new ProtocolCodecFilter(new GbMessageCodecFactory()));
      //			dataAccepter.getFilterChain().addLast("logger", new LoggingFilter());
      //			dataAccepter.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
      IoSessionConfig config = dataAccepter.getSessionConfig();

      config.setReadBufferSize(4096);
      config.setWriteTimeout(10000);
      config.setWriterIdleTime(100000);
      config.setIdleTime(IdleStatus.BOTH_IDLE, maxOfflineTime);
      // 业务处理
      dataAccepter.setHandler(gbHandler);

      dataAccepter.bind(new InetSocketAddress(getPort()));
      logger.info("数据服务器启动成功!端口号:" + getPort());
      isOpen = true;
    } catch (Exception e) {
      isOpen = false;
      logger.error("GB服务器启动失败:" + e);
      e.printStackTrace();
    }
    return isOpen;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public int getPort() {
    return port;
  }

  public int getMaxOfflineTime() {
    return maxOfflineTime;
  }

  public void setMaxOfflineTime(int maxOfflineTime) {
    this.maxOfflineTime = maxOfflineTime;
  }
}
