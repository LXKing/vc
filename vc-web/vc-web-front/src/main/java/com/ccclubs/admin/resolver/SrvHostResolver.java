package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.SrvHost;


public enum SrvHostResolver{
	
		转发指令结果(new Resolver<SrvHost>("shTransformRemoteText") {
		private static final long serialVersionUID = 2038894694L;

		@Override
		public <T> T execute(SrvHost record) {
				if(record.getShTransformRemote()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getShTransformRemote().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "转发";
				}
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "不转发";
				}
			}

				return (T)result;
				}
		})
	,
		转发状态(new Resolver<SrvHost>("shTransformStatusText") {
		private static final long serialVersionUID = 2038834621L;

		@Override
		public <T> T execute(SrvHost record) {
				if(record.getShTransformStatus()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getShTransformStatus().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "转发";
				}
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "不转发";
				}
			}

				return (T)result;
				}
		})
	,
		转发CAN(new Resolver<SrvHost>("shTransformCanText") {
		private static final long serialVersionUID = 2038814163L;

		@Override
		public <T> T execute(SrvHost record) {
				if(record.getShTransformCan()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getShTransformCan().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "转发";
				}
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "不转发";
				}
			}

				return (T)result;
				}
		})
	,
		状态(new Resolver<SrvHost>("shStatusText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038893332L;

			@Override
			public <T> T execute(SrvHost record) {
					if(record.getShStatus()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("status",record.getShStatus());
					return (T)result;
					}
		})
	;
	
	Resolver<SrvHost> resolver;
	SrvHostResolver(Resolver<SrvHost> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<SrvHost> getResolver(){
		return this.resolver;
	}
	
}
