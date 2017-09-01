package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;

public class JT_FF03 implements IMessageBody {
	private byte[] msgBody;

	@Override
	public byte[] WriteToBytes() {
		return getMsgBody();
	}

	@Override
	public void ReadFromBytes(byte[] messageBodyBytes) {
		setMsgBody(messageBodyBytes);
	}

	public byte[] getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(byte[] msgBody) {
		this.msgBody = msgBody;
	}
}
