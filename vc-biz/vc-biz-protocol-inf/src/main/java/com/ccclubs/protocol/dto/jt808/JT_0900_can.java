package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import java.util.ArrayList;
import java.util.List;


public class JT_0900_can implements IMessageBody {

	private String time;
	private byte count;
	/**
	 * CAN 包
	 */
	private List<JT_0900_can_item> canList;

	public byte getCount() {
		return count;
	}

	public void setCount(byte count) {
		this.count = count;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<JT_0900_can_item> getCanList() {
		return canList;
	}

	public void setCanList(List<JT_0900_can_item> canList) {
		this.canList = canList;
	}

	@Override
	public byte[] WriteToBytes() {
		MyBuffer buff = new MyBuffer();
		buff.put(Byte.parseByte(getTime().substring(2, 4), 16));
		buff.put(Byte.parseByte(getTime().substring(5, 7), 16));
		buff.put(Byte.parseByte(getTime().substring(8, 10), 16));
		buff.put(Byte.parseByte(getTime().substring(11, 13), 16));
		buff.put(Byte.parseByte(getTime().substring(14, 16), 16));
		buff.put(Byte.parseByte(getTime().substring(17, 19), 16));
		buff.put(getCount());
		if (getCount() > 0) {
			for (JT_0900_can_item item : canList) {
				if (item != null && item.getCanId() > 0) {
					buff.put(item.WriteToBytes());
				}
			}
		}
		return buff.array();
	}

	@Override
	public void ReadFromBytes(byte[] bytes) {
		MyBuffer buff = new MyBuffer(bytes);
		byte[] timeBytes = buff.gets(6);
		setTime("20" + String.format("%02X", timeBytes[0]) + "-" + String.format("%02X", timeBytes[1]) + "-" + String
        .format("%02X", timeBytes[2]) + " "
				+ String.format("%02X", timeBytes[3]) + ":" + String.format("%02X", timeBytes[4]) + ":" + String
        .format("%02X", timeBytes[5]));
		setCount(buff.get());
		this.canList = new ArrayList<JT_0900_can_item>();
		for (int m = 0; m < getCount(); m++) {
			JT_0900_can_item jt = new JT_0900_can_item();
			int dataLength = 4 + 8;
			jt.ReadFromBytes(buff.gets(dataLength));
			this.canList.add(jt);
		}

	}

}
