package com.ccclubs.command.util;


import com.ccclubs.protocol.dto.jt808.JT_81F0;
import com.ccclubs.protocol.dto.jt808.SL_Update;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.jt808.T808MessageHeader;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by qsxiaogang on 2017/7/6.
 */
@Component
public class UpdateHelper {

  @Autowired
  ZdHttpHelper zdHttpHelper;
  /**
   * 通领大版本升级
   *
   * @param simNo 终端手机号
   * @param fileName FTP升级文件名
   */
  public T808Message getUpdateMessageForTl(String simNo, String fileName) {
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
   * 富士康终端[ 低版本，插件版本 < 0x1322 ]升级
   *
   * @param number 车机号
   */
  public byte[] getUpdateMessageForFskSimple(String number) {
    return Tools.HexString2Bytes(
        Tools.ToHexString(number) + "0000000001e3816749c0020000");
  }

  /**
   * 富士康终端[ 低版本，插件版本 >= 0x1322 ]升级
   *
   * @param number 车机号
   * @param fileName 待升级文件名
   */
  public byte[] getUpdateMessageForFsk(String number, String fileName) {
    return Tools.HexString2Bytes(
        Tools.ToHexString(number) + "000000000083C4E210C00200010003"
            + Tools.ToHexString(fileName) + "0000");
  }

  /**
   * 中导FTP升级指令，通过Http方式升级
   *
   * @param simNo 终端手机号
   */
  public byte[] getUpdateMessageForZdHttp(String simNo) {
    String cmd = zdHttpHelper.getCmd(simNo);
    if (!StringUtils.empty(cmd)) {
      SL_Update slUpdate = new SL_Update();
      slUpdate.setSimId(simNo);
      slUpdate.setMsgBody(Tools.HexString2Bytes(cmd));
      return slUpdate.WriteToBytes();
    } else {
      return null;
    }
  }


  /**
   * 中导FTP升级指令
   *
   * @param simNo 终端手机号
   * @param fileName FTP升级文件名
   */
  public T808Message getUpdateMessageForZd(String simNo, String fileName) {
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
