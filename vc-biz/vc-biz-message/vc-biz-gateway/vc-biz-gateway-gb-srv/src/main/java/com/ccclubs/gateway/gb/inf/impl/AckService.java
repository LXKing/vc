package com.ccclubs.gateway.gb.inf.impl;

import com.ccclubs.gateway.gb.inf.IAckService;
import com.ccclubs.gateway.gb.inf.IMessageSender;
import com.ccclubs.protocol.dto.gb.GBAck;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.dto.gb.GBMessageHeader;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.GbTools;
import com.ccclubs.protocol.util.StringUtils;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 终端上行数据应答服务
 */
public class AckService implements IAckService {

  private static final Logger logger = LoggerFactory.getLogger(AckService.class);

  private static ConcurrentLinkedQueue<GBMessage> dataQueue = new ConcurrentLinkedQueue<GBMessage>();

  private Thread processRealDataThread;
  private IMessageSender messageSender;

  private int threadPool;

  public AckService() {
  }

  public void start() {
    processRealDataThread = new Thread(new Runnable() {
      public void run() {
        ProcessRealDataThreadFunc();
      }
    });
    processRealDataThread.start();
  }

  private void ProcessRealDataThreadFunc() {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(getThreadPool());

    for (int i = 0; i < getThreadPool(); i++) {
      fixedThreadPool.execute(new Runnable() {
        @Override
        public void run() {
          while (true) {
            try {
              final GBMessage tm = dataQueue.poll();
              if (tm != null) {
                sendGeneralAck(tm);
              }

              try {
                Thread.sleep(5L);
              } catch (InterruptedException e1) {
                logger.error(e1.getMessage(), e1);
              }
            } catch (Exception e) {
              e.printStackTrace();
              logger.info(e.getMessage(), e);
            }
          }
        }
      });
    }
  }

  public void beginAck(GBMessage tm) {

    if (!GbTools.isNeedToAck(tm.getAckType())) {
      return;
    }

    dataQueue.add(tm);
  }

  /**
   * 对终端发送上来的消息进行通用应答
   *
   * @param msgFromTerminal 终端消息
   */
  private void sendGeneralAck(GBMessage msgFromTerminal) {

    GBMessage ts = new GBMessage();
    ts.setHeader(new GBMessageHeader());
    ts.getHeader().setMessageType(msgFromTerminal.getMessageType());
    ts.getHeader().setAckType(0x01);
    ts.getHeader().setEncodeType((short) msgFromTerminal.getEncodType());
    ts.getHeader().setVin(msgFromTerminal.getVin());
    // add at 2017-03-14 16:55，用于终端校时
    if (msgFromTerminal.getMessageContents() == null && msgFromTerminal.getMessageType() == 0x08) {
      GBAck ack = new GBAck();
      ack.setTime(StringUtils.date(new Date(), ConstantUtils.TIME_FORMAT));
      ts.setMessageContents(ack);

      getMessageSender().sendGbMessage(ts);
      return;
    }

    // 如果车辆登入，判断VIN码是否存在
    if (msgFromTerminal.getMessageContents() != null) {
      GBAck ack = new GBAck();
      ack.setTime(msgFromTerminal.getMessageContents().getTime());
      ts.setMessageContents(ack);
    }

    getMessageSender().sendGbMessage(ts);
  }

  public void setMessageSender(IMessageSender messageSender) {
    this.messageSender = messageSender;
  }

  public IMessageSender getMessageSender() {
    return messageSender;
  }

  public int getThreadPool() {
    return threadPool;
  }

  public void setThreadPool(int threadPool) {
    this.threadPool = threadPool;
  }

}
