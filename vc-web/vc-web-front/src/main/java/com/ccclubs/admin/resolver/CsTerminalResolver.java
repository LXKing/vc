package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.CsTerminal;


public enum CsTerminalResolver{
	
		状态(new Resolver<CsTerminal>("cstStatusText") {
		private static final long serialVersionUID = 2038810842L;

		@Override
		public <T> T execute(CsTerminal record) {
				if(record.getCstStatus()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCstStatus().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("3")){
					result+=(i==0?"":",")+ "未授权";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "有效";
				}
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "无效";
				}
			}

				return (T)result;
				}
		})
	;
	
	Resolver<CsTerminal> resolver;
	CsTerminalResolver(Resolver<CsTerminal> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsTerminal> getResolver(){
		return this.resolver;
	}
	
}
