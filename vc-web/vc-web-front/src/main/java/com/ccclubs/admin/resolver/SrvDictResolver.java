package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.SrvDict;


public enum SrvDictResolver{
	
		删除标记(new Resolver<SrvDict>("delFlagText") {
		private static final long serialVersionUID = 203889284L;

		@Override
		public <T> T execute(SrvDict record) {
				if(record.getDelFlag()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getDelFlag().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "删除";
				}
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "正常";
				}
			}

				return (T)result;
				}
		})
	;
	
	Resolver<SrvDict> resolver;
	SrvDictResolver(Resolver<SrvDict> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<SrvDict> getResolver(){
		return this.resolver;
	}
	
}
