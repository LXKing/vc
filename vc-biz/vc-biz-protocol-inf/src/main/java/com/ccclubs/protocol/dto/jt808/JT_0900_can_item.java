package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;


/**
 * CAN包数据内容
 * 
 * @author qsxiaogang
 * 
 */
public class JT_0900_can_item implements IMessageBody {

	private short canType;
	/**
	 * CAN id
	 * <p>
	 * bit31 表示 CAN 通道号，0：CAN1，1：CAN2； bit30 表示帧类型，0：标准帧，1：扩展帧； bit29
	 * 表示数据采集方式，0：原始数据，1：采 集区间的平均值； bit28-bit0 表示 CAN 总线 ID。
	 * </p>
	 */
	private short canId;

	/**
	 * CAN 数据
	 */
	private byte mCanData1;
	private byte mCanData2;
	private byte mCanData3;
	private byte mCanData4;
	private byte mCanData5;
	private byte mCanData6;
	private byte mCanData7;
	private byte mCanData8;

	public int getCanType() {
		return canType;
	}

	public void setCanType(short canType) {
		this.canType = canType;
	}

	public short getCanId() {
		return canId;
	}

	public void setCanId(short canId) {
		this.canId = canId;
	}

	public byte getmCanData1() {
		return mCanData1;
	}

	public void setmCanData1(byte mCanData1) {
		this.mCanData1 = mCanData1;
	}

	public byte getmCanData2() {
		return mCanData2;
	}

	public void setmCanData2(byte mCanData2) {
		this.mCanData2 = mCanData2;
	}

	public byte getmCanData3() {
		return mCanData3;
	}

	public void setmCanData3(byte mCanData3) {
		this.mCanData3 = mCanData3;
	}

	public byte getmCanData4() {
		return mCanData4;
	}

	public void setmCanData4(byte mCanData4) {
		this.mCanData4 = mCanData4;
	}

	public byte getmCanData5() {
		return mCanData5;
	}

	public void setmCanData5(byte mCanData5) {
		this.mCanData5 = mCanData5;
	}

	public byte getmCanData6() {
		return mCanData6;
	}

	public void setmCanData6(byte mCanData6) {
		this.mCanData6 = mCanData6;
	}

	public byte getmCanData7() {
		return mCanData7;
	}

	public void setmCanData7(byte mCanData7) {
		this.mCanData7 = mCanData7;
	}

	public byte getmCanData8() {
		return mCanData8;
	}

	public void setmCanData8(byte mCanData8) {
		this.mCanData8 = mCanData8;
	}

	@Override
	public byte[] WriteToBytes() {
		MyBuffer buff = new MyBuffer();
		buff.put(getCanType());
		buff.put(getCanId());
		buff.put(getmCanData1());
		buff.put(getmCanData2());
		buff.put(getmCanData3());
		buff.put(getmCanData4());
		buff.put(getmCanData5());
		buff.put(getmCanData6());
		buff.put(getmCanData7());
		buff.put(getmCanData8());
		return buff.array();
	}

	@Override
	public void ReadFromBytes(byte[] bytes) {
		MyBuffer buff = new MyBuffer(bytes);
		setCanId(buff.getShort());
		setCanId(buff.getShort());
		setmCanData1(buff.get());
		setmCanData2(buff.get());
		setmCanData3(buff.get());
		setmCanData4(buff.get());
		setmCanData5(buff.get());
		setmCanData6(buff.get());
		setmCanData7(buff.get());
		setmCanData8(buff.get());
	}

}
