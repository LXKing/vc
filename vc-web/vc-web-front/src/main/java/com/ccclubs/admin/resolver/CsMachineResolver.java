package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.CsMachine;


public enum CsMachineResolver{
	
		接入商(new Resolver<CsMachine>("csmAccessText", com.ccclubs.admin.metadata.MetaDef.getAccessName) {
		private static final long serialVersionUID = 203886309L;

		@Override
		public <T> T execute(CsMachine record) {
				if(record.getCsmAccess()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCsmAccess());
				return (T)result;
				}
		})
	,
		终端类型(new Resolver<CsMachine>("csmTeTypeText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038823457L;

			@Override
			public <T> T execute(CsMachine record) {
					if(record.getCsmTeType()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("csm_te_type",record.getCsmTeType());
					return (T)result;
					}
		})
	,
		协议类型(new Resolver<CsMachine>("csmProtocolText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038866873L;

			@Override
			public <T> T execute(CsMachine record) {
					if(record.getCsmProtocol()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("csm_protocol",record.getCsmProtocol());
					return (T)result;
					}
		})
	,
		适配车型(new Resolver<CsMachine>("csmSuitText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038820900L;

			@Override
			public <T> T execute(CsMachine record) {
					if(record.getCsmSuit()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("suit",record.getCsmSuit());
					return (T)result;
					}
		})
	,
		终端协议(new Resolver<CsMachine>("csmProTypeText") {
		private static final long serialVersionUID = 203886825L;

		@Override
		public <T> T execute(CsMachine record) {
				if(record.getCsmProType()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCsmProType().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "808";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "mqtt";
				}
			}

				return (T)result;
				}
		})
	,
		状态(new Resolver<CsMachine>("csmStatusText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038863654L;

			@Override
			public <T> T execute(CsMachine record) {
					if(record.getCsmStatus()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("status",record.getCsmStatus());
					return (T)result;
					}
		})
	;
	
	Resolver<CsMachine> resolver;
	CsMachineResolver(Resolver<CsMachine> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsMachine> getResolver(){
		return this.resolver;
	}
	
}
