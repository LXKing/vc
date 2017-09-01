package com.ccclubs.gateway.jt808.inf;

import com.ccclubs.gateway.jt808.dto.GpsConnection;
import java.util.Collection;
import org.apache.mina.core.session.IoSession;

public interface IJT808Server {

   void stop();

   Collection<GpsConnection> getGpsConnections();

   boolean send(String simNo, byte[] msg);

   boolean send(long sessionId, byte[] msg);

   IoSession getSession(long sid);

   boolean start();

   boolean isOnline(String simNo);

}