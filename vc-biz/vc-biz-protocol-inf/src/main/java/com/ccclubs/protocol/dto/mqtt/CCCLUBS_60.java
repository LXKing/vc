package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.Tools;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 终端基础信息，终端推送信息，包含： <ul> <li>车机号</li> <li>订单号</li> <li>0x6001</li> <li>序列号</li> <li>手机号</li>
 * <li>车架号</li> <li>适配车型</li> <li>硬件版本</li> <li>软件版本1</li> <li>软件版本2</li> <li>蓝牙版本</li>
 * <li>网络类型</li> <li>协议类型</li> <li>CCID</li> <li>蓝牙MAC地址</li> <li>车机屏APP版本</li> <li>最新APP版本</li>
 * <li>服务器名</li> <li>端口</li> <li>插枪还车校验值</li> <li>CAN波特率</li> <li>系统当前时间</li> <li>系统运行时间</li> </ul>
 * Created by qsxiaogang on 2017/4/17.
 */
public class CCCLUBS_60 implements IMessageBody {

    private static Logger logger = LoggerFactory.getLogger(CCCLUBS_60.class);
  private static int SUBCODE_02 = 0x02;
  private static int SUBCODE_03 = 0x03;
  private int subFucCode;


  private java.util.ArrayList<IMachineAdditionalItem> additionals;

  /**
   * 序列号
   */
  public String getCfxId() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x01) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Serial additionalSerial = (MachineAdditional_Serial) additionalItem;
      return additionalSerial.getCfxId().trim();
    } else {
      return null;
    }
  }

  /**
   * 手机号
   */
  public String getSimNo() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x02) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_SimNo additionalSimNo = (MachineAdditional_SimNo) additionalItem;
      return additionalSimNo.getSimNo().trim();
    } else {
      return null;
    }
  }

  /**
   * 获取VIN码
   */
  public String getVin() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x03) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Vin additionalVin = (MachineAdditional_Vin) additionalItem;
      return additionalVin.getVin().trim();
    } else {
      return null;
    }
  }

  /**
   * 适配车型
   */
  public Integer getModel() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x04) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Model additionalModel = (MachineAdditional_Model) additionalItem;
      return additionalModel.getModel();
    } else {
      return null;
    }
  }

  /**
   * 硬件版本
   */
  public Integer getVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x05) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Version additionalVersion = (MachineAdditional_Version) additionalItem;
      return additionalVersion.getVersion();
    } else {
      return null;
    }
  }

  /**
   * <b>通领专用<b/>主版本，软件版本1,十六进制形式
   */
  public Integer getSoftwareVersionI() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x06) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_SoftwareVersionI softwareVersionI = (MachineAdditional_SoftwareVersionI) additionalItem;
      return softwareVersionI.getSoftwareVersion();
    } else {
      return null;
    }
  }

  /**
   * <b>通领专用<b/>插件版本，软件版本2
   */
  public Integer getSoftwareVersionII() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x07) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_SoftwareVersionII softwareVersionII = (MachineAdditional_SoftwareVersionII) additionalItem;
      return softwareVersionII.getSoftwareVersion();
    } else {
      return null;
    }
  }

  /**
   * 获取中导硬件版本
   */
  public Integer getZHardWareVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 28) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Z_HardWareVersion hardWareVersion = (MachineAdditional_Z_HardWareVersion) additionalItem;
      return hardWareVersion.getHardWareVersion();
    } else {
      return null;
    }
  }

  /**
   * 获取中导软件版本，十六进制表示
   */
  public String getZSoftWareVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 29) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Z_SoftWareVersion softWareVersion = (MachineAdditional_Z_SoftWareVersion) additionalItem;
      return Tools.ToHexString(softWareVersion.getSoftWareVersion());
    } else {
      return null;
    }
  }

  /**
   * 获取中导插件版本
   */
  public Integer getZPluginVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 30) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Z_PluginVersion pluginVersion = (MachineAdditional_Z_PluginVersion) additionalItem;
      return pluginVersion.getPluginVersion();
    } else {
      return null;
    }
  }

  /**
   * 获取蓝牙版本
   */
  public Integer getBleVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x08) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_BleVersion bleVersion = (MachineAdditional_BleVersion) additionalItem;
      return bleVersion.getBleVersion() & 0xFFFF;
    } else {
      return null;
    }
  }

  /**
   * 获取蓝牙密钥
   */
  public String getBleKey() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 33) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_BleKey additionalSerial = (MachineAdditional_BleKey) additionalItem;
      return additionalSerial.getBleKey().trim();
    } else {
      return null;
    }
  }

  /**
   * 获取终端网络类型
   */
  public Integer getNetworkType() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x09) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_NetworkType networkType = (MachineAdditional_NetworkType) additionalItem;
      return networkType.getNetworkType();
    } else {
      return null;
    }
  }

  /**
   * 终端协议版本
   */
  public Integer getProtocol() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x0A) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Protocol protocol = (MachineAdditional_Protocol) additionalItem;
      return protocol.getProtocol();
    } else {
      return null;
    }
  }

  /**
   * 获取ICCID
   */
  public String getIccid() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x0B) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_ICCID iccid = (MachineAdditional_ICCID) additionalItem;
      return iccid.getIccid().trim();
    } else {
      return null;
    }
  }

  /**
   * 获取蓝牙地址
   */
  public String getMacAddress() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x0C) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_MacAddress macAddress = (MachineAdditional_MacAddress) additionalItem;
      return macAddress.getMacAddress().trim();
    } else {
      return null;
    }
  }

  /**
   * 车载屏APP当前版本
   */
  public Integer getMediaCurrentVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x0D) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_MediaCurrentVersion mediaCurrentVersion = (MachineAdditional_MediaCurrentVersion) additionalItem;
      return mediaCurrentVersion.getMediaCurrentVersion() & 0xFFFF;
    } else {
      return null;
    }
  }

  /**
   * 车载屏APP最新版本
   */
  public Integer getMediaNewVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x0E) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_MediaNewVersion mediaNewVersion = (MachineAdditional_MediaNewVersion) additionalItem;
      return mediaNewVersion.getMediaNewVersion() & 0xFFFF;
    } else {
      return null;
    }
  }

  /**
   * 获取服务器名称
   */
  public String getServerName() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x0F) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Server server = (MachineAdditional_Server) additionalItem;
      return server.getServerName().trim().replaceAll("\"", "").replaceAll("\\[", "")
          .replaceAll("\\]", "")
          .replaceAll(" ", "");
    } else {
      return null;
    }
  }

  /**
   * 获取服务器端口
   */
  public Integer getPort() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x10) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Port port = (MachineAdditional_Port) additionalItem;
      return port.getPort();
    } else {
      return null;
    }
  }

  /**
   * 获取插枪还车状态
   */
  public Integer getPlugGun() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x11) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_PlugGun plugGun = (MachineAdditional_PlugGun) additionalItem;
      return plugGun.getPlugGun();
    } else {
      return null;
    }
  }

  /**
   * 获取波特率
   */
  public Integer getCanBaudRate() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x12) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_CanBaudRate canBaudRate = (MachineAdditional_CanBaudRate) additionalItem;
      return canBaudRate.getCanBaudRate();
    } else {
      return null;
    }
  }

  /**
   * 获取PEPS版本
   */
  public Integer getPepsVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 34) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_PepsVersion pepsVersion = (MachineAdditional_PepsVersion) additionalItem;
      return pepsVersion.getPepsVersion();
    } else {
      return null;
    }
  }

  /**
   * 系统当前时间
   */
  public Integer getCurrentTime() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x14) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_SystemTime systemTime = (MachineAdditional_SystemTime) additionalItem;
      return systemTime.getCurrentTime();
    } else {
      return null;
    }
  }

  /**
   * 系统运行时间
   */
  public Integer getRunTime() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x15) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_RunTime runTime = (MachineAdditional_RunTime) additionalItem;
      return runTime.getRunTime();
    } else {
      return null;
    }
  }

  /**
   * 获取车厘子终端发布主题
   */
  public String getPublishTopic() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x16) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_F_PublishTopic publishTopic = (MachineAdditional_F_PublishTopic) additionalItem;
      return publishTopic.getPublishTopic();
    } else {
      return null;
    }
  }

  /**
   * 获取车厘子终端订阅主题
   */
  public String getSubscribeTopic() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x16) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_F_SubscribeTopic subscribeTopic = (MachineAdditional_F_SubscribeTopic) additionalItem;
      return subscribeTopic.getSubscribeTopic();
    } else {
      return null;
    }
  }

  /**
   * 富士康硬件版本
   */
  public Integer getFVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x19) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_F_Version fVersion = (MachineAdditional_F_Version) additionalItem;
      return fVersion.getVersion();
    } else {
      return null;
    }
  }

  /**
   * 富士康IAP版本
   */
  public Integer getFIapVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x1A) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_F_IapVersion iapVersion = (MachineAdditional_F_IapVersion) additionalItem;
      return iapVersion.getIapVersion();
    } else {
      return null;
    }
  }

  /**
   * 富士康软件版本
   */
  public Integer getFAppVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 0x1B) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_F_AppVersion appVersion = (MachineAdditional_F_AppVersion) additionalItem;
      return appVersion.getAppVersion();
    } else {
      return null;
    }
  }

  /**
   * 获取OBD里程
   */
  public BigDecimal getObdMile() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 116) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_ObdMile obdMile = (MachineAdditional_ObdMile) additionalItem;
      if (SUBCODE_03 == subFucCode) {
        // 03协议版本，单位为0.1km
        return AccurateOperationUtils.mul(obdMile.getObdMile(), 0.1)
            .setScale(1, BigDecimal.ROUND_HALF_UP);
      } else {
        return new BigDecimal(obdMile.getObdMile());
      }
    } else {
      return new BigDecimal(0);
    }
  }

  /**
   * 获取SOC
   */
  public Integer getSoc() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 118) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_SOC soc = (MachineAdditional_SOC) additionalItem;
      return soc.getSoc() & 0xFF;
    } else {
      return 0;
    }
  }

  /**
   * 触发数据：GPS经度
   */
  public BigDecimal getTriggerGpsLongitude() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 113) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_GpsStatus gpsStatus = (MachineAdditional_GpsStatus) additionalItem;
      if (SUBCODE_03 == subFucCode) {
        return AccurateOperationUtils
            .mul(gpsStatus.getLongitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP);
      } else {
        return AccurateOperationUtils
            .add(gpsStatus.getLongitude(), gpsStatus.getLongitudeDecimal() * 0.000001)
            .setScale(6, BigDecimal.ROUND_HALF_UP);
      }
    } else {
      return new BigDecimal(0);
    }
  }

  /**
   * 触发数据：GPS纬度
   */
  public BigDecimal getTriggerGpsLatitude() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 113) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_GpsStatus gpsStatus = (MachineAdditional_GpsStatus) additionalItem;
      if (SUBCODE_03 == subFucCode) {
        return AccurateOperationUtils
            .mul(gpsStatus.getLatitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP);
      } else {
        return AccurateOperationUtils
            .add(gpsStatus.getLatitude(), gpsStatus.getLatitudeDecimal() * 0.000001)
            .setScale(6, BigDecimal.ROUND_HALF_UP);
      }
    } else {
      return new BigDecimal(0);
    }
  }

  /**
   * 触发数据：发动机状态
   */
  public Integer getTriggerEngineStatus() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 103) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_EngineStatus engineStatus = (MachineAdditional_EngineStatus) additionalItem;
      return engineStatus.getEngineStatus() < 0 ? 0 : engineStatus.getEngineStatus();
    } else {
      return null;
    }
  }

  /**
   * 触发数据：钥匙状态
   */
  public Integer getTriggerKeyStatus() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 105) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_KeyStatus keyStatus = (MachineAdditional_KeyStatus) additionalItem;
      return keyStatus.getKeyStatus() < 0 ? 0 : keyStatus.getKeyStatus();
    } else {
      return null;
    }
  }

  /**
   * 触发数据：灯状态
   */
  public Integer getTriggerLightStatus() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 107) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_LightsStatus lightsStatus = (MachineAdditional_LightsStatus) additionalItem;
      return lightsStatus.getLightsStatus();
    } else {
      return null;
    }
  }

  /**
   * 车灯状态带mask
   */
  public Integer getTriggerLightStatusWithMask() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 206) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_LightsStatusWithMask lightsStatusWithMask = (MachineAdditional_LightsStatusWithMask) additionalItem;
      return lightsStatusWithMask.getLightsStatus();
    } else {
      return null;
    }
  }

  /**
   * 触发数据：门锁状态
   */
  public Integer getTriggerDoorLockStatus() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 109) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_DoorLockStatus doorLockStatus = (MachineAdditional_DoorLockStatus) additionalItem;
      return doorLockStatus.getDoorLockStatus();
    } else {
      return null;
    }
  }

  /**
   * 获取门锁状态带mask
   */
  public Short getTriggerDoorLockStatusWithMask() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 204) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_DoorLockStatusWithMask doorLockStatusWithMask = (MachineAdditional_DoorLockStatusWithMask) additionalItem;
      return doorLockStatusWithMask.getDoorLockStatus();
    } else {
      return null;
    }
  }

  /**
   * 门状态
   */
  public Byte getTriggerMergeDoorStatus() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 112) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_MergeDoorStatus mergeDoorStatus = (MachineAdditional_MergeDoorStatus) additionalItem;
      return mergeDoorStatus.getDoorStatus();
    } else {
      return null;
    }
  }

  /**
   * 车门状态，带mask
   */
  public Short getTriggerMergeDoorStatusWithMask() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 202) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_MergeDoorStatusWithMask mergeDoorStatusWithMask = (MachineAdditional_MergeDoorStatusWithMask) additionalItem;
      return mergeDoorStatusWithMask.getDoorStatus();
    } else {
      return null;
    }
  }

  /**
   * 触发数据：充电状态 在充电(0：未充电或无效，1：慢充，2：快充)
   */
  public Integer getTriggerChargeStatus() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 104) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_ChargeStatus chargeStatus = (MachineAdditional_ChargeStatus) additionalItem;
      return chargeStatus.getChargeStatus();
    } else {
      return 0;
    }
  }

  /**
   * 获取挡位信息
   */
  public Integer getTriggerGearStatus() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 108) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_GearStatus chargeStatus = (MachineAdditional_GearStatus) additionalItem;
      return chargeStatus.getGearStatus();
    } else {
      return null;
    }
  }

  /**
   * 触发数据：车窗状态
   */
  public Integer getTriggerWindowStatus() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 106) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_WindowsStatus windowsStatus = (MachineAdditional_WindowsStatus) additionalItem;
      return windowsStatus.getWindowsStatus();
    } else {
      return null;
    }
  }


  /**
   * 车机类型
   */
  public Integer getMachineType() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 35) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Type machineType = (MachineAdditional_Type) additionalItem;
      return machineType.getMachineType();
    } else {
      return null;
    }
  }

  /**
   * 车机硬件版本
   */
  public Integer getHardwareVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 36) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_HardwareVersion hardwareVersion = (MachineAdditional_HardwareVersion) additionalItem;
      return hardwareVersion.getHardwareVersion();
    } else {
      return null;
    }
  }

  /**
   * 车机软件版本1
   */
  public Integer getSoftwareVersionNewI() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 37) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_SoftwareVersionNewI softwareVersionNewI = (MachineAdditional_SoftwareVersionNewI) additionalItem;
      return softwareVersionNewI.getSoftwareVersion();
    } else {
      return null;
    }
  }

  /**
   * 车机软件版本2
   */
  public Integer getSoftwareVersionNewII() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 38) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_SoftwareVersionNewII softwareVersionNewII = (MachineAdditional_SoftwareVersionNewII) additionalItem;
      return softwareVersionNewII.getSoftwareVersion();
    } else {
      return null;
    }
  }

  /**
   * 插件版本
   */
  public Integer getPluginVersion() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 39) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_PluginVersion pluginVersion = (MachineAdditional_PluginVersion) additionalItem;
      return pluginVersion.getPluginVersion();
    } else {
      return null;
    }
  }

  /**
   * 获取基站信息，LAC
   */
  public Integer getBaseLAC() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 114) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_BaseStationStatus baseStationStatus = (MachineAdditional_BaseStationStatus) additionalItem;
      return baseStationStatus.getLac() & 0xFFFF;
    } else {
      return 0;
    }
  }

  /**
   * 获取基站信息，CI
   */
  public Integer getBaseCI() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 114) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_BaseStationStatus baseStationStatus = (MachineAdditional_BaseStationStatus) additionalItem;
      return baseStationStatus.getCi();
    } else {
      return 0;
    }
  }

  /**
   * 获取续航里程
   */
  public BigDecimal getEndurance() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 119) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Endurance endurance = (MachineAdditional_Endurance) additionalItem;
      if (SUBCODE_03 == subFucCode) {
        // 03协议版本，单位为0.1km
        return AccurateOperationUtils.mul(endurance.getEndurance(), 0.1)
            .setScale(1, BigDecimal.ROUND_HALF_UP);
      } else {
        return new BigDecimal(endurance.getEndurance());
      }
    } else {
      return new BigDecimal(0);
    }
  }

  /**
   * 获取燃油量
   */
  public BigDecimal getOil() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if (item.getAdditionalId() == 126) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Oil oil = (MachineAdditional_Oil) additionalItem;
      return AccurateOperationUtils.mul(oil.getOil(), 0.1).setScale(1, BigDecimal.ROUND_HALF_UP);
    } else {
      return new BigDecimal(0);
    }
  }

  /**
   * 获取手刹手刹状态
   * */
  public Integer getHandbrake(){
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 153) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Handbrake machineAdditionalHandbrake = (MachineAdditional_Handbrake) additionalItem;
      return machineAdditionalHandbrake.getHandbrakeState();
    } else {
      //3为未知
      return 3;
    }
  }
  /**
   * 获取自动驾驶状态
   * */

  public Integer getAutopilot(){
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0x0FF) == 154) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Autopilot machineAdditionalAutopilot = (MachineAdditional_Autopilot) additionalItem;
      return machineAdditionalAutopilot.getAutopilotState();
    } else {
      return null;
    }
  }
  /**
   * 获取空调状态
   */
  public Integer getAirConditionerCircular() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 136) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_AirConditionerCircular airConditionerCircular = (MachineAdditional_AirConditionerCircular) additionalItem;
      return airConditionerCircular.getAirConditionerCircular();
    } else {
      return 0;
    }
  }


  /**
   * 获取订单状态
   */
  public Integer getTradeStatus() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 138) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_TradeStatus tradeStatus = (MachineAdditional_TradeStatus) additionalItem;
      return tradeStatus.getTradeStatus();
    } else {
      return 0;
    }
  }

  /**
   * 获取订单里程
   */
  public BigDecimal getTradeMiles() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 139) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_TradeMiles tradeMiles = (MachineAdditional_TradeMiles) additionalItem;
      return AccurateOperationUtils.mul(tradeMiles.getTradeMiles(), 0.1)
          .setScale(1, BigDecimal.ROUND_HALF_UP);
    } else {
      return new BigDecimal(0);
    }
  }

  /**
   * 获取业务订单RFID号
   */
  public String getTradeInitCard() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 140) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_TradeInitCard tradeInitCard = (MachineAdditional_TradeInitCard) additionalItem;
      return tradeInitCard.getTradeInitCard();
    } else {
      return "";
    }
  }

  /**
   * 获取业务订单RFID号
   */
  public String getTradeTakeCard() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 141) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_TradeTakeCard tradeTakeCard = (MachineAdditional_TradeTakeCard) additionalItem;
      return tradeTakeCard.getTradeTakeCard();
    } else {
      return null;
    }
  }

  /**
   * 获取订单开始时间
   */
  public Integer getTradeStartTime() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 142) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_TradeStartTime tradeStartTime = (MachineAdditional_TradeStartTime) additionalItem;
      return tradeStartTime.getTradeStartTime();
    } else {
      return null;
    }
  }

  /**
   * 获取订单结束时间
   */
  public Integer getTradeEndTime() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 143) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_TradeEndTime tradeEndTime = (MachineAdditional_TradeEndTime) additionalItem;
      return tradeEndTime.getTradeEndTime();
    } else {
      return null;
    }
  }

  /**
   * 获取报警项
   */
  public Integer getAlarm() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 145) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_Alarm alarm = (MachineAdditional_Alarm) additionalItem;
      return alarm.getAlarm() & 0xFFFF;
    } else {
      return 0;
    }
  }

  /**
   * 获取收到网络命令数量
   */
  public Integer getReceivedRemoteOrders() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 146) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_ReceivedRemoteOrders receivedRemoteOrders = (MachineAdditional_ReceivedRemoteOrders) additionalItem;
      return receivedRemoteOrders.getReceivedRemoteOrders();
    } else {
      return null;
    }
  }

  /**
   * 获取最后一条网络命令时间
   */
  public Integer getFinallyRemoteTime() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 147) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_FinallyRemoteTime finallyRemoteTime = (MachineAdditional_FinallyRemoteTime) additionalItem;
      return finallyRemoteTime.getFinallyRemoteTime();
    } else {
      return null;
    }
  }

  /**
   * 获取最后一条网络命令时间
   */
  public Integer getReceivedCanAmount() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 148) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_ReceivedCanAmount receivedCanAmount = (MachineAdditional_ReceivedCanAmount) additionalItem;
      return receivedCanAmount.getReceivedCanAmount();
    } else {
      return null;
    }
  }

  /**
   * 获取最后一个CAN包时间
   */
  public Integer getFinallyCanTime() {
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 149) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_FinallyCanTime finallyCanTime = (MachineAdditional_FinallyCanTime) additionalItem;
      return finallyCanTime.getFinallyCanTime();
    } else {
      return null;
    }
  }

  /**
   * 获取自动配置状态
   * **/
  public Boolean getAutoConfigStatusUnlockdoor(){
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 152) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_AutoConfigStatus autoConfigStatus = (MachineAdditional_AutoConfigStatus) additionalItem;
      return (autoConfigStatus.getAutoConfigStatus()&0x2)!=0x0;//关闭自动锁门
    } else {
      return null;
    }
  }

  /**
   * 获取自动配置状态
   * **/
  public Boolean getAutoConfigStatusCharge(){
    IMachineAdditionalItem additionalItem = null;
    for (IMachineAdditionalItem item : getAdditionals()) {
      if ((item.getAdditionalId() & 0xFF) == 152) {
        additionalItem = item;
        break;
      }
    }
    if (additionalItem != null) {
      MachineAdditional_AutoConfigStatus autoConfigStatus = (MachineAdditional_AutoConfigStatus) additionalItem;
      return (autoConfigStatus.getAutoConfigStatus()&0x1)!=0x0;//开启自动蓄电
    } else {
      return null;
    }
  }




  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getSubFucCode());
    if (getAdditionals() != null && getAdditionals().size() > 0) {
      for (IMachineAdditionalItem ad : getAdditionals()) {
        buff.put(ad.getAdditionalId());
        buff.put(ad.getAdditionalLength());
        buff.put(ad.WriteToBytes());
      }
    }
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    Byte additionalId = null;
    try {
      MyBuffer buff = new MyBuffer(messageBodyBytes);
      setSubFucCode(buff.get());
      setAdditionals(new java.util.ArrayList<>());

      while (buff.hasRemain()) {
        additionalId = buff.get();
        byte additionalLength = buff.get();
        byte[] additionalBytes = buff.gets(additionalLength);
        IMachineAdditionalItem item = MachineAdditionalFactory
            .createMachineAdditionalFactory(additionalId, additionalLength, additionalBytes);
        if (item != null) {
          getAdditionals().add(item);
        } else {
//        logger.info("未知的终端基础属性:" + additionalId + ",附加长度:" + additionalLength);
        }
      }
    }catch (Exception ex){
      ex.printStackTrace();
      logger.error(ex.getMessage(),ex);
      if (null != additionalId) {
        logger.error("messageBodyBytes: "+Tools.ToHexString(messageBodyBytes));
        logger.error("additionalId: 0x"+Tools.ToHexString(additionalId));
      }
    }
  }

  public int getSubFucCode() {
    return subFucCode & 0xFF;
  }

  public void setSubFucCode(int subFucCode) {
    this.subFucCode = subFucCode;
  }

  public final java.util.ArrayList<IMachineAdditionalItem> getAdditionals() {
    return additionals;
  }

  public final void setAdditionals(java.util.ArrayList<IMachineAdditionalItem> value) {
    additionals = value;
  }

}
