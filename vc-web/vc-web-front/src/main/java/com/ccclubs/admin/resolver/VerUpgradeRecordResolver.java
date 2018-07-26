package com.ccclubs.admin.resolver;

import com.ccclubs.admin.model.VerUpgradeRecord;
import com.ccclubs.frm.spring.resolver.Resolver;


public enum VerUpgradeRecordResolver{
	
		车型(new Resolver<VerUpgradeRecord>("carModelText", com.ccclubs.admin.metadata.MetaDef.getVehicleModelName) {
		private static final long serialVersionUID = 2038864217L;

		@Override
		public <T> T execute(VerUpgradeRecord record) {
				if(record.getCarModel()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCarModel());
				return (T)result;
				}
		})
	,
        车机类型(new Resolver<VerUpgradeRecord>("teTypeText") {
            private static final long serialVersionUID = 2038815437L;

            @Override
            public <T> T execute(VerUpgradeRecord record) {
                if(record.getTeType()==null){
                    return null;
                }
                String result = "";
                String[] sArr = record.getTeType().toString().split(",");
                for(int i=0;i<sArr.length;i++){
                    if(sArr[i].equals("0")){
                        result+=(i==0?"":",")+ "车厘子";
                    }
                    if(sArr[i].equals("1")){
                        result+=(i==0?"":",")+ "中导";
                    }
                    if(sArr[i].equals("2")){
                        result+=(i==0?"":",")+ "慧翰";
                    }
                    if(sArr[i].equals("3")){
                        result+=(i==0?"":",")+ "通领";
                    }
                }

                return (T)result;
            }
        })
	,
		当前版本(new Resolver<VerUpgradeRecord>("fromVersionText", com.ccclubs.admin.metadata.MetaDef.getUpgradeVersionNo) {
		private static final long serialVersionUID = 2038867102L;

		@Override
		public <T> T execute(VerUpgradeRecord record) {
				if(record.getFromVersion()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getFromVersion());
				return (T)result;
				}
		})
	,
		目的版本(new Resolver<VerUpgradeRecord>("toVersionText", com.ccclubs.admin.metadata.MetaDef.getUpgradeVersionNo) {
		private static final long serialVersionUID = 2038897701L;

		@Override
		public <T> T execute(VerUpgradeRecord record) {
				if(record.getToVersion()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getToVersion());
				return (T)result;
				}
		})
	,
		状态(new Resolver<VerUpgradeRecord>("statusText") {
		private static final long serialVersionUID = 2038830455L;

		@Override
		public <T> T execute(VerUpgradeRecord record) {
				if(record.getstatus()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getstatus().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "待升级";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "升级中";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "已升级";
				}
				if(sArr[i].equals("3")){
					result+=(i==0?"":",")+ "升级失败";
				}
				if(sArr[i].equals("-1")){
					result+=(i==0?"":",")+ "无效";
				}
			}

				return (T)result;
				}
		})
	;
	
	Resolver<VerUpgradeRecord> resolver;
	VerUpgradeRecordResolver(Resolver<VerUpgradeRecord> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<VerUpgradeRecord> getResolver(){
		return this.resolver;
	}
	
}
