package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.CsStruct;


public enum CsStructResolver{
	
		命令类型(new Resolver<CsStruct>("cssTypeText") {
		private static final long serialVersionUID = 2038857547L;

		@Override
		public <T> T execute(CsStruct record) {
				if(record.getCssType()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getCssType().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "高级命令";
				}
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "一般命令";
				}
			}

				return (T)result;
				}
		})
	,
		状态(new Resolver<CsStruct>("cssStatusText", com.ccclubs.admin.metadata.MetaDef.getDictLabel) {
		private static final long serialVersionUID = 2038898184L;

			@Override
			public <T> T execute(CsStruct record) {
					if(record.getCssStatus()==null){
					return null;
					}
					String result = "";
					result = this.getDictMetaData().get("status",record.getCssStatus());
					return (T)result;
					}
		})
	;
	
	Resolver<CsStruct> resolver;
	CsStructResolver(Resolver<CsStruct> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsStruct> getResolver(){
		return this.resolver;
	}
	
}
