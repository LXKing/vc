package com.ccclubs.protocol.dto.mqtt;


import com.ccclubs.protocol.inf.IMachineAdditionalItem;

/**
 * 终端相关信息，通过消息ID，消息长度，消息内容格式组装
 * Created by qsxiaogang on 2017/4/17.
 */
public class MachineAdditionalFactory {

  public static IMachineAdditionalItem createMachineAdditionalFactory(int additionalId, byte length,
      byte[] bytes) {
    IMachineAdditionalItem additional = null;
    switch (additionalId & 0xFF) {
      case 0x01:
        MachineAdditional_Serial serialItem = new MachineAdditional_Serial();
        serialItem.setAdditionalLength(length);
        serialItem.ReadFromBytes(bytes);
        additional = serialItem;
        break;
      case 0x02:
        MachineAdditional_SimNo simNoItem = new MachineAdditional_SimNo();
        simNoItem.setAdditionalLength(length);
        simNoItem.ReadFromBytes(bytes);
        additional = simNoItem;
        break;
      case 0x03:
        MachineAdditional_Vin vinItem = new MachineAdditional_Vin();
        vinItem.setAdditionalLength(length);
        vinItem.ReadFromBytes(bytes);
        additional = vinItem;
        break;
      case 0x04:
        additional = new MachineAdditional_Model();
        additional.ReadFromBytes(bytes);
        break;
      case 0x05:
        additional = new MachineAdditional_Version();
        additional.ReadFromBytes(bytes);
        break;
      case 0x06:
        additional = new MachineAdditional_SoftwareVersionI();
        additional.ReadFromBytes(bytes);
        break;
      case 0x07:
        additional = new MachineAdditional_SoftwareVersionII();
        additional.ReadFromBytes(bytes);
        break;
      case 0x08:
        additional = new MachineAdditional_BleVersion();
        additional.ReadFromBytes(bytes);
        break;
      case 0x09:
        additional = new MachineAdditional_NetworkType();
        additional.ReadFromBytes(bytes);
        break;
      case 0x0A:
        additional = new MachineAdditional_Protocol();
        additional.ReadFromBytes(bytes);
        break;
      case 0x0B:
        MachineAdditional_ICCID iccidItem = new MachineAdditional_ICCID();
        iccidItem.setAdditionalLength(length);
        iccidItem.ReadFromBytes(bytes);
        additional = iccidItem;
        break;
      case 0x0C:
        additional = new MachineAdditional_MacAddress();
        additional.ReadFromBytes(bytes);
        break;
      case 0x0D:
        additional = new MachineAdditional_MediaCurrentVersion();
        additional.ReadFromBytes(bytes);
        break;
      case 0x0E:
        additional = new MachineAdditional_MediaNewVersion();
        additional.ReadFromBytes(bytes);
        break;
      case 0x0F:
        MachineAdditional_Server serverItem = new MachineAdditional_Server();
        serverItem.setAdditionalLength(length);
        serverItem.ReadFromBytes(bytes);
        additional = serverItem;
        break;
      case 0x10:
        additional = new MachineAdditional_Port();
        additional.ReadFromBytes(bytes);
        break;
      case 0x11:
        additional = new MachineAdditional_PlugGun();
        additional.ReadFromBytes(bytes);
        break;
      case 0x12:
        additional = new MachineAdditional_CanBaudRate();
        additional.ReadFromBytes(bytes);
        break;
      case 0x14:
        additional = new MachineAdditional_SystemTime();
        additional.ReadFromBytes(bytes);
        break;
      case 0x15:
        additional = new MachineAdditional_RunTime();
        additional.ReadFromBytes(bytes);
        break;
      case 0x16:
        MachineAdditional_F_PublishTopic publishTopic = new MachineAdditional_F_PublishTopic();
        publishTopic.setAdditionalLength(length);
        publishTopic.ReadFromBytes(bytes);
        additional = publishTopic;
        break;
      case 0x17:
        MachineAdditional_F_SubscribeTopic subscribeTopic = new MachineAdditional_F_SubscribeTopic();
        subscribeTopic.setAdditionalLength(length);
        subscribeTopic.ReadFromBytes(bytes);
        additional = subscribeTopic;
        break;
      case 0x19:
        additional = new MachineAdditional_F_Version();
        additional.ReadFromBytes(bytes);
        break;
      case 0x1A:
        additional = new MachineAdditional_F_IapVersion();
        additional.ReadFromBytes(bytes);
        break;
      case 0x1B:
        additional = new MachineAdditional_F_AppVersion();
        additional.ReadFromBytes(bytes);
        break;
      // 中导软件版本 28,29,30 硬件版本，软件版本，分时租赁插件版本
      case 28:
        additional = new MachineAdditional_Z_HardWareVersion();
        additional.ReadFromBytes(bytes);
        break;
      case 29:
        additional = new MachineAdditional_Z_SoftWareVersion();
        additional.ReadFromBytes(bytes);
        break;
      case 30:
        additional = new MachineAdditional_Z_PluginVersion();
        additional.ReadFromBytes(bytes);
        break;

      case 31:
        additional = new MachineAdditional_OnlineTime();
        additional.ReadFromBytes(bytes);
        break;
      case 0x20:
        additional = new MachineAdditional_DisconnectedTime();
        additional.ReadFromBytes(bytes);
        break;
      case 33:
        MachineAdditional_BleKey bleKey = new MachineAdditional_BleKey();
        bleKey.setAdditionalLength(length);
        bleKey.ReadFromBytes(bytes);
        additional = bleKey;
        break;
      case 34:
        additional = new MachineAdditional_PepsVersion();
        additional.ReadFromBytes(bytes);
        break;

      // 触发事件
      case 100:
        additional = new MachineAdditional_MainDriverDoorStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 101:
        additional = new MachineAdditional_DeputyDriverDoorStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 102:
        additional = new MachineAdditional_AllDoorStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 103:
        additional = new MachineAdditional_EngineStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 104:
        additional = new MachineAdditional_ChargeStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 105:
        additional = new MachineAdditional_KeyStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 106:
        additional = new MachineAdditional_WindowsStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 107:
        additional = new MachineAdditional_LightsStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 108:
        additional = new MachineAdditional_GearStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 109:
        additional = new MachineAdditional_DoorLockStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 110:
        additional = new MachineAdditional_AntiTheftStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 111:
        additional = new MachineAdditional_SeatBeltStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 112:
        additional = new MachineAdditional_MergeDoorStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 113:
        additional = new MachineAdditional_GpsStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 114:
        additional = new MachineAdditional_BaseStationStatus();
        additional.ReadFromBytes(bytes);
        break;
      case 116:
        additional = new MachineAdditional_ObdMile();
        additional.ReadFromBytes(bytes);
        break;
      case 118:
        additional = new MachineAdditional_SOC();
        additional.ReadFromBytes(bytes);
        break;

      case 202:
        additional = new MachineAdditional_MergeDoorStatusWithMask();
        additional.ReadFromBytes(bytes);
        break;
      case 204:
        additional = new MachineAdditional_DoorLockStatusWithMask();
        additional.ReadFromBytes(bytes);
        break;
      case 206:
        additional = new MachineAdditional_LightsStatusWithMask();
        additional.ReadFromBytes(bytes);
        break;
      case 208:
        additional = new MachineAdditional_ControlStatusWithMask();
        additional.ReadFromBytes(bytes);
        break;
    }
    return additional;
  }
}
