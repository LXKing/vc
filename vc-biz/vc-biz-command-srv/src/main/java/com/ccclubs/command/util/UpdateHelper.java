package com.ccclubs.command.util;


import com.ccclubs.protocol.dto.jt808.JT_81F0;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.jt808.T808MessageHeader;

/**
 * Created by qsxiaogang on 2017/7/6.
 */
public class UpdateHelper {

  /**
   * 通领大版本升级
   *
   * @param simNo 终端手机号
   * @param fileName FTP升级文件名
   */
  public static T808Message getUpdateMessageForTl(String simNo, String fileName) {
    T808Message ts = new T808Message();
    ts.setHeader(new T808MessageHeader());
    ts.getHeader().setSimId(simNo);
    ts.getHeader().setIsPackage(false);
    ts.getHeader().setMessageSerialNo((short) 16);
    ts.getHeader().setMessageType(0x81F0);
    // 终端升级
    JT_81F0 cmdData = new JT_81F0();

    // 通领FTP升级
    cmdData.setMessageType((byte) 0x01);
    cmdData.setFtpAddress("www.hopelead.link");
    cmdData.setFtpPort("2014");
    cmdData.setFtpUserName("ccclubs");
    cmdData.setFtpPassword("ccclubs");

    cmdData.setFileName(fileName);
    cmdData.setConnectToServerTimeLimit("5");

    ts.setMessageContents(cmdData);

    return ts;
  }

  /**
   * 中导FTP升级指令
   *
   * @param simNo 终端手机号
   * @param fileName FTP升级文件名
   */
  public static T808Message getUpdateMessageForZd(String simNo, String fileName) {
    T808Message ts = new T808Message();
    ts.setHeader(new T808MessageHeader());
    ts.getHeader().setSimId(simNo);
    ts.getHeader().setIsPackage(false);
    ts.getHeader().setMessageSerialNo((short) 16);
    ts.getHeader().setMessageType(0x81F0);
    // 终端升级
    JT_81F0 cmdData = new JT_81F0();

    cmdData.setMessageType((byte) 0x01);
    //中导FTP升级
    cmdData.setFtpAddress("ftp2.ccclubs.com");
    cmdData.setFtpPort("36797");
    cmdData.setFtpUserName("evnet507");
    cmdData.setFtpPassword("Rn1Qu3OR");

    cmdData.setFileName(fileName);
    cmdData.setConnectToServerTimeLimit("5");

    ts.setMessageContents(cmdData);

    return ts;
  }
}
