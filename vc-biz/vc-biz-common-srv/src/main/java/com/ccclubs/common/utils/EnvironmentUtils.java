package com.ccclubs.common.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author qsxiaogang
 * @create 2017-10-11
 **/
@Component
public class EnvironmentUtils {

  @Autowired
  private Environment env;

  /**
   * 获取当前应用的应用名
   */
  public String getApplicationName() {
    return env.getProperty("spring.application.name");
  }

  /**
   * 获取当前应用编译环境，dev，test，prod
   */
  public String getApplicationActive() {
    return env.getProperty("spring.profiles.active");
  }

  /**
   * 当前应用是否是test环境
   */
  public boolean isTestEnvironment() {
    return "test".equals(getApplicationActive());
  }

  /**
   * 当前应用是否是dev环境
   */
  public boolean isDevEnvironment() {
    return "dev".equals(getApplicationActive());
  }

  /**
   * 当前应用是否是prod环境
   */
  public boolean isProdEnvironment() {
    return "prod".equals(getApplicationActive());
  }

  /**
   * 服务器当前IP地址
   */
  public String getCurrentIp() {
    try {
      Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
      while (networkInterfaces.hasMoreElements()) {
        NetworkInterface ni = networkInterfaces.nextElement();
        Enumeration<InetAddress> nias = ni.getInetAddresses();
        while (nias.hasMoreElements()) {
          InetAddress ia = nias.nextElement();
          if (!ia.isLinkLocalAddress() && !ia.isLoopbackAddress() && ia instanceof Inet4Address) {
            return ia.getHostAddress();
          }
        }
      }
    } catch (SocketException e) {
      e.printStackTrace();
      return null;
    }
    return null;
  }

}
