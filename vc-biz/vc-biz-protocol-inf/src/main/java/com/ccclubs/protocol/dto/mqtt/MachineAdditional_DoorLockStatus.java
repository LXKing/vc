package com.ccclubs.protocol.dto.mqtt;
import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 门锁状态,终端信息
 */
@Deprecated
public class MachineAdditional_DoorLockStatus implements IMachineAdditionalItem {

  /**
   * 1门已锁，2有门未锁，0无效
   */
  private int doorLockStatus;

  public int getDoorLockStatus() {
    return doorLockStatus;
  }

  public void setDoorLockStatus(int doorLockStatus) {
    this.doorLockStatus = doorLockStatus;
  }

  @Override
  public byte getAdditionalId() {
    return 109;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getDoorLockStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setDoorLockStatus(buff.get());
  }
}
