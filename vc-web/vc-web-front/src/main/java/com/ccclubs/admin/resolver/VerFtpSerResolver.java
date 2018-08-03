package com.ccclubs.admin.resolver;

import com.ccclubs.admin.model.VerFtpSer;
import com.ccclubs.frm.spring.resolver.Resolver;


public enum VerFtpSerResolver{
	
		服务器类型(new Resolver<VerFtpSer>("typeText") {
		private static final long serialVersionUID = 2038856365L;

		@Override
		public <T> T execute(VerFtpSer record) {
				if(record.gettype()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.gettype().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "ftp服务器";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "http服务器";
				}
			}

				return (T)result;
				}
		})
	;
	
	Resolver<VerFtpSer> resolver;
	VerFtpSerResolver(Resolver<VerFtpSer> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<VerFtpSer> getResolver(){
		return this.resolver;
	}
	
}
