package com.ccclubs.admin.resolver;

import com.ccclubs.frm.spring.resolver.Resolver;
import com.ccclubs.admin.model.SrvUser;


public enum SrvUserResolver{

	状态(new Resolver<SrvUser>("suStatusText") {
		@Override
		public <T> T execute(SrvUser record) {

			if (record.getSuStatus() == null) {
				return null;
			}
			String result = "";
			String[] sArr = record.getSuStatus().toString().split(",");
			for (int i = 0; i < sArr.length; i++) {
				if (sArr[i].equals("1")) {
					result += (i == 0 ? "" : ",") + "有效";
				}
				if (sArr[i].equals("0")) {
					result += (i == 0 ? "" : ",") + "无效";
				}
			}
			return (T)result;
		}
	})

	;
	
	Resolver<SrvUser> resolver;
	SrvUserResolver(Resolver<SrvUser> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<SrvUser> getResolver(){
		return this.resolver;
	}
	
}
