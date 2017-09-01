package com.ccclubs.gateway.gb.inf;


import com.ccclubs.gateway.gb.dto.GpsConnection;
import java.util.Collection;
import org.apache.mina.core.session.IoSession;

public interface IGbServer {

  public abstract void stop();

  public abstract Collection<GpsConnection> getGpsConnections();

  public abstract boolean send(String simNo, byte[] msg);

  public abstract boolean send(long sessionId, byte[] msg);

  public abstract IoSession getSession(long sid);

  public abstract boolean start();

  public abstract boolean isOnline(String simNo);

}