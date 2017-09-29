package com.ccclubs.frm.mqtt.inf.impl;

import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.frm.mqtt.inf.IMqClient;
import com.ccclubs.frm.mqtt.util.MqttHelper;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqMqttClient implements IMqClient {

  private static final Logger logger = LoggerFactory.getLogger(MqMqttClient.class);

  private MqttAsyncClient mqttClientReceiver = null;

  private String host;
  private String listenPort;
  private String clientIdPre;
  private String subTopic;
  private String userName;
  private String pwd;
  private boolean logUpDown;
  private MqttConnectOptions conOpt = null;

  private IMessageProcessService mqMessageProcessService;
  /**
   * 连接处理线程
   */
  private Thread processConnectThread;

  @Override
  public void stop() {
    try {
      mqttClientReceiver.close();
    } catch (MqttException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
  }

  @Override
  public boolean send(String topic, byte[] srcByteArray) {
    try {
      if (null == topic || topic.trim().length() == 0) {
        throw new Exception("downTopic 为空");
      }

      if (mqttClientReceiver != null && mqttClientReceiver.isConnected()) {
        
        mqttClientReceiver.publish(topic, srcByteArray, 0, false);

        if (logUpDown) {
          logger.info("DOWN >> " + MqttHelper.toHexString(srcByteArray));
        }

        return true;
      } else {
        connect();
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage());
      return false;
    }
  }

  @Override
  public boolean start() {
    try {
      conOpt = new MqttConnectOptions();
      conOpt.setUserName(getUserName());
      // conOpt.setAutomaticReconnect(true);
      conOpt.setPassword(getPwd().toCharArray());

      connect();

      processConnectThread = new Thread(new Runnable() {
        public void run() {
          try {
            ProcessConnectThreadFunc();
          } catch (MqttException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
          }
        }
      });
      processConnectThread.start();

      return true;
    } catch (MqttException e) {
      e.printStackTrace();
      logger.error(e.getMessage());
      return false;
    }
  }

  private synchronized void connect() throws MqttException, MqttSecurityException {
    mqttClientReceiver = new MqttAsyncClient(getHost() + ":" + getListenPort(), getMqttClientId(),
        new MemoryPersistence());
    mqttClientReceiver.setCallback(receiverCallback);
    mqttClientReceiver.connect(conOpt);
  }

  private MqttCallback receiverCallback = new MqttCallbackExtended() {

    @Override
    public void messageArrived(String upTopic, MqttMessage msg) throws Exception {
      String hexString = MqttHelper.toHexString(msg.getPayload());
      if (logUpDown) {
        logger.info("UP >> " + hexString);
      }

      if (getMqMessageProcessService() == null) {
        return;
      }
      getMqMessageProcessService().processMsg(upTopic, msg, hexString);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken arg0) {

    }

    @Override
    public void connectionLost(Throwable arg0) {
      try {
        connect();
      } catch (MqttSecurityException e) {
        e.printStackTrace();
      } catch (MqttException e) {
        e.printStackTrace();
        logger.error(e.getMessage());
      }
    }

    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
      subscribeTopic();
    }
  };

  /**
   * 检查是否 client 在线
   */
  protected void ProcessConnectThreadFunc() throws MqttException {
    while (true) {
      try {
        Thread.sleep(30 * 1000l);
      } catch (InterruptedException e1) {
      }
      logger.info("{} Check alive >> ",mqttClientReceiver.getClientId());
      if (mqttClientReceiver == null) {
        connect();
      } else if (!mqttClientReceiver.isConnected()) {
        connect();
      }
    }
  }

  private String getMqttClientId() {
    return getClientIdPre() + "@@@" + MqttHelper.rand(9999) + "@" + MqttHelper.rand(999);
  }

  /**
   * 订阅指定主题，远程，订单，区分城市
   */
  @Override
  public void subscribeTopic() {
    try {
      if (null == getSubTopic() || getSubTopic().trim().length() == 0) {
        return;
      }
      String[] topicArray = getSubTopic().trim().split(",");
      int[] qos = new int[topicArray.length];
      for (int i = 0; i < qos.length; i++) {
        qos[i] = 0;
      }
      mqttClientReceiver.subscribe(topicArray, qos);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public MqttAsyncClient getMqttClientReceiver() {
    return mqttClientReceiver;
  }

  public void setMqttClientReceiver(MqttAsyncClient mqttClientReceiver) {
    this.mqttClientReceiver = mqttClientReceiver;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getListenPort() {
    return listenPort;
  }

  public void setListenPort(String listenPort) {
    this.listenPort = listenPort;
  }

  public String getSubTopic() {
    return subTopic;
  }

  public void setSubTopic(String subTopic) {
    this.subTopic = subTopic;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public boolean isLogUpDown() {
    return logUpDown;
  }

  public void setLogUpDown(boolean logUpDown) {
    this.logUpDown = logUpDown;
  }

  public IMessageProcessService getMqMessageProcessService() {
    return mqMessageProcessService;
  }

  public void setMqMessageProcessService(IMessageProcessService mqMessageProcessService) {
    this.mqMessageProcessService = mqMessageProcessService;
  }

  public String getClientIdPre() {
    return clientIdPre;
  }

  public void setClientIdPre(String clientIdPre) {
    this.clientIdPre = clientIdPre;
  }

}
