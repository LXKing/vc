package com.ccclubs.gateway.jt808.mina;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;


public class SimpleMessageDecoder extends CumulativeProtocolDecoder {
	private static Logger logger = Logger.getLogger(SimpleMessageDecoder.class);
	private CharsetDecoder decoder;


	public SimpleMessageDecoder(Charset charset) {
		this.decoder = charset.newDecoder();
	}

	protected boolean doDecode(IoSession session, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		return true;
	}
}
