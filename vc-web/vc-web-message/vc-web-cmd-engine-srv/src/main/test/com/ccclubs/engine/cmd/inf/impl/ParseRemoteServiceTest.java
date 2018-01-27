package com.ccclubs.engine.cmd.inf.impl;


import com.alibaba.fastjson.JSON;
import com.ccclubs.engine.cmd.srv.CmdEngineSrvApp;
import com.ccclubs.engine.core.util.RemoteHelper;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.dto.CommonResult;
import com.ccclubs.protocol.dto.mqtt.CCCLUBS_60;
import com.ccclubs.protocol.dto.mqtt.CommonWriter;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.transform.TerminalPartStatus;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.Tools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 指令解析验证
 *
 * @author qsxiaogang
 * @create 2018-01-25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CmdEngineSrvApp.class)
public class ParseRemoteServiceTest {

  @Test
  public void processMultipleOperation() {
    CsRemote csRemote;
    CommonWriter commonWriter = null;
//    String hexString = "5436364B3030353100000000072DCBC9061021000000C300FF03140421FC6642CA020000CC020000CE0400000000D002030067010268010069010071080000000000000000720658B00000E9F57404000000007601006C0100880100";
    String hexString = "543637463437323000000000072F101B0610210000008003140421FF7297CA027E00CC020000CE0401FE0000D002030067010268010069010271080659C6BB01C350557206A3380ADF07A074040000092E7601246C0100880100";
//      String hexString = "5436364B3030353100000000072D588F0610210000100000FF03140421FB7023CA020000CC020000CE0400000000D002030067010268010069010071080000000000000000720658B00000E9F57404000000007601006C0100880100";
//      String hexString = "5436364B3030353100000000072D2EFD061004FF000000";
    MqMessage tm = new MqMessage();
    tm.ReadFromBytes(Tools.HexString2Bytes(hexString));
    try {
      if (tm.getTransId() == 0 || tm.getMsgBody().length < 4) {
        return;
      }
      byte[] byteMsg = tm.WriteToBytes();

      commonWriter = CommonWriter.readObject(byteMsg, CommonWriter.class);

      MyBuffer myBuffer = new MyBuffer(tm.getMsgBody());
      //取命令码，四个字节
      int fcCode = myBuffer.getInt();
      switch (fcCode) {
        //远程开门
        case 0x1000FF00:
          int fcCodeOpen = myBuffer.getInt();
          String resultJson;
          short remoteResult;
          switch (fcCodeOpen) {
            // 开门并允许启动
            case 0x1004FF00:
              // 开门并禁止启动
            case 0x10040000:
              remoteResult = myBuffer.getShort();

              resultJson = RemoteHelper
                  .getMultipleOperationJsonMessage(commonWriter.mId, 0x10000000,
                      myBuffer.gets(tm.getMsgBody().length - 4 - 4 - 2),
                      remoteResult);

              csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJson,
                  remoteResult == 0 || remoteResult == 0x00FF);
              break;
            //简单开门指令
            default:
              MyBuffer myBufferOpen = new MyBuffer(tm.getMsgBody());
              myBufferOpen.getInt();
              remoteResult = myBufferOpen.getShort();

              resultJson = RemoteHelper
                  .getMultipleOperationJsonMessage(commonWriter.mId, 0x1000FF00,
                      myBufferOpen.gets(tm.getMsgBody().length - 4 - 2),
                      remoteResult);

              csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJson,
                  remoteResult == 0 || remoteResult == 0x00FF);
              break;
          }
          break;
        // 远程关门
        case 0x10000000:
          int fcCodeClose = myBuffer.getInt();
          String resultJsonClose;
          // 指令返回结果
          short remoteResultClose;
          switch (fcCodeClose) {
            // 关门并允许启动
            case 0x1004FF00:
              // 关门并禁止启动
            case 0x10040000:
              remoteResultClose = myBuffer.getShort();

              resultJsonClose = RemoteHelper
                  .getMultipleOperationJsonMessage(commonWriter.mId, 0x10000000,
                      myBuffer.gets(tm.getMsgBody().length - 4 - 4 - 2),
                      remoteResultClose);

              csRemote = RemoteHelper
                  .getRemote(commonWriter.mId, tm.getHexString(), resultJsonClose,
                      remoteResultClose == 0 || remoteResultClose == 0x00FF);
              break;
            // 简单关门指令
            default:
              MyBuffer myBufferClose = new MyBuffer(tm.getMsgBody());
              myBufferClose.getInt();
              remoteResultClose = myBufferClose.getShort();

              resultJsonClose = RemoteHelper
                  .getMultipleOperationJsonMessage(commonWriter.mId, 0x10000000,
                      myBufferClose.gets(tm.getMsgBody().length - 4 - 2),
                      remoteResultClose);

              csRemote = RemoteHelper
                  .getRemote(commonWriter.mId, tm.getHexString(), resultJsonClose,
                      remoteResultClose == 0 || remoteResultClose == 0x00FF);
              break;
          }
          break;
        //远程鸣笛
        case 0x1012FF00:
          String resultJsonW = JSON.toJSONString(
              CommonResult.create(commonWriter.mId, true, RemoteHelper.SUCCESS_CODE, "操作成功"));

          csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJsonW,
              byteMsg[21] == 0 && (byteMsg[22] == 0 || (byteMsg[22] & 0xFF) == 0xFF));
          break;
        //允许启动
        case 0x1004FF00:
          //禁止启动
        case 0x10040000:
          //发动机启动
        case 0x1017FF00:
          //发动机ACC
        case 0x10178800:
          //发动机停止
        case 0x10170000:
          String resultJsonCommon = JSON.toJSONString(
              CommonResult.create(commonWriter.mId, true, RemoteHelper.SUCCESS_CODE, "操作成功"));

          csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJsonCommon,
              byteMsg[21] == 0 && (byteMsg[22] == 0 || (byteMsg[22] & 0xFF) == 0xFF));
          break;
        // 批量查询(带参数)
        case 0x10200000:
          String resultJsonCommonSelect = JSON.toJSONString(
              CommonResult.create(commonWriter.mId, true, RemoteHelper.SUCCESS_CODE, "操作成功"));

          csRemote = RemoteHelper
              .getRemote(commonWriter.mId, tm.getHexString(), resultJsonCommonSelect,
                  true);
          break;
        // 远程关门(带参数)
        case 0x10210000:
          // 获取结果
          short fcCodeResult = myBuffer.getShort();

          String resultJsonCloseWithParams;
          resultJsonCloseWithParams = RemoteHelper
              .getMultipleOperationJsonMessage(commonWriter.mId, 0x10210000,
                  myBuffer.gets(tm.getMsgBody().length - 4 - 2), fcCodeResult);

          csRemote = RemoteHelper
              .getRemote(commonWriter.mId, tm.getHexString(), resultJsonCloseWithParams,
                  fcCodeResult == 0 || fcCodeResult == 0x00FF);
          break;
        default:
          //状态获取
          CCCLUBS_60 terminalInfo = new CCCLUBS_60();
          terminalInfo.ReadFromBytes(tm.getMsgBody());

          TerminalPartStatus terminalPartStatus = new TerminalPartStatus();
//          terminalPartStatus.setCssNumber(tm.getCarNumber());
          terminalPartStatus.setCssEvBattery(terminalInfo.getSoc());
          terminalPartStatus.setCssObdMile(terminalInfo.getObdMile().intValue());
          terminalPartStatus.setCssLatitude(terminalInfo.getTriggerGpsLatitude());
          terminalPartStatus.setCssLongitude(terminalInfo.getTriggerGpsLongitude());
          terminalPartStatus.setCssCurrentTime(
              terminalInfo.getCurrentTime() == null ? System.currentTimeMillis() :
                  ProtocolTools.transformToServerTime(terminalInfo.getCurrentTime()));
          terminalPartStatus.setCssCharging(terminalInfo.getTriggerChargeStatus());
          terminalPartStatus.setCssDoor(terminalInfo.getTriggerMergeDoorStatusWithMask());
          terminalPartStatus.setCssEngine(terminalInfo.getTriggerEngineStatus());
          terminalPartStatus.setCssLock(terminalInfo.getTriggerDoorLockStatusWithMask());
          terminalPartStatus.setCssLight(terminalInfo.getTriggerLightStatusWithMask());

          CommonResult commonResult = CommonResult
              .create(commonWriter.mId, true, RemoteHelper.SUCCESS_CODE, "操作成功");
          commonResult.setData(terminalPartStatus);
          String resultJsonState = JSON.toJSONString(commonResult);

          csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), resultJsonState,
              true);
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
      if (null != commonWriter) {
        csRemote = RemoteHelper.getRemote(commonWriter.mId, tm.getHexString(), "协议错误",
            false);
      }
    }
  }
}
