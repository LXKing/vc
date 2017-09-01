package com.ccclubs.gateway.gb.mina;

import java.nio.charset.Charset;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class GbMessageCodecFactory implements ProtocolCodecFactory {
	private final GbMessageDecoder decoder;
	private final GbMessageEncoder encoder;

	public GbMessageCodecFactory() { 
		this.decoder = new GbMessageDecoder(Charset.forName("utf-8"));
		this.encoder = new GbMessageEncoder(Charset.forName("utf-8"));
	}

	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		return this.decoder;
	}

	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		return this.encoder;
	}
}
