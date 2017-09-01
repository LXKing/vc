package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IPositionAdditionalItem;

/**
 * 刹车、转向等信号状态״̬
 * 
 */
public class PostitionAdditional_Signal implements IPositionAdditionalItem {

	public final byte getAdditionalId() {
		return 0x25;
	}

	public final byte getAdditionalLength() {
		return 0x4;
	}

	/**
	 *扩展信号	
	 */
	private int signal;

	public final byte[] WriteToBytes() {
		if (BitConverter.IsLittleEndian) {
			byte[] bytes = new byte[4];
			bytes[0] = (byte) (signal >> 24);
			bytes[1] = (byte) (signal >> 16);
			bytes[2] = (byte) (signal >> 8);
			bytes[3] = (byte) signal;
			return bytes;
		} else {
			return BitConverter.GetBytes(signal);
		}
	}

	public final void ReadFromBytes(byte[] bytes) {
		if (BitConverter.IsLittleEndian) {
			signal = ((int) ((bytes[0] << 24) + (bytes[1] << 16) + (bytes[2] << 8) + bytes[3]));
		} else {
			signal = (BitConverter.ToUInt32(bytes, 0));
		}
	}

	public int getSignal() {
		return signal;
	}

	public void setSignal(int signal) {
		this.signal = signal;
	}
}