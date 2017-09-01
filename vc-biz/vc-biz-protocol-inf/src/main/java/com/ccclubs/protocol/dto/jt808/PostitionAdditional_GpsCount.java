package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IPositionAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

public class PostitionAdditional_GpsCount implements IPositionAdditionalItem {

	public final byte getAdditionalId() {
		return 0x31;
	}

	public final byte getAdditionalLength() {
		return 0x01;
	}

	/**
	 * GPS数量
	 */
	private byte count;

	public final byte[] WriteToBytes() {
		MyBuffer buff = new MyBuffer();
		buff.put(getCount());
		return buff.array();
	}

	public final void ReadFromBytes(byte[] bytes) {
		MyBuffer buff = new MyBuffer(bytes);
		setCount(buff.get());
	}

	public byte getCount() {
		return count;
	}

	public void setCount(byte count) {
		this.count = count;
	}
}