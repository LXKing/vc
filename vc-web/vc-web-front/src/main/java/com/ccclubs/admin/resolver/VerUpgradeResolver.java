package com.ccclubs.admin.resolver;

import com.ccclubs.admin.model.VerUpgrade;
import com.ccclubs.frm.spring.resolver.Resolver;


public enum VerUpgradeResolver{
	
        软件版本号(new Resolver<VerUpgrade>("softVerIdText", com.ccclubs.admin.metadata.MetaDef.getVersionNo) {
		private static final long serialVersionUID = 2038897847L;

		@Override
		public <T> T execute(VerUpgrade record) {
				if(record.getSoftVerId()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getSoftVerId());
				return (T)result;
				}
		})
	,
        硬件版本号(new Resolver<VerUpgrade>("hardVerIdText", com.ccclubs.admin.metadata.MetaDef.getVersionNo) {
		private static final long serialVersionUID = 203882704L;

		@Override
		public <T> T execute(VerUpgrade record) {
				if(record.getHardVerId()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getHardVerId());
				return (T)result;
				}
		})
	,
        蓝牙版本(new Resolver<VerUpgrade>("bluetoothVerIdText", com.ccclubs.admin.metadata.MetaDef.getVersionNo) {
        private static final long serialVersionUID = 203882704L;

        @Override
        public <T> T execute(VerUpgrade record) {
            if(record.getHardVerId()==null){
                return null;
            }
            String result = "";
            result = this.getMetadata().get(record.getBluetoothVerId());
            return (T)result;
        }
    })
    ,
        主版本(new Resolver<VerUpgrade>("majorVersionIdText", com.ccclubs.admin.metadata.MetaDef.getVersionNo) {
        private static final long serialVersionUID = 203882704L;

        @Override
        public <T> T execute(VerUpgrade record) {
            if(record.getHardVerId()==null){
                return null;
            }
            String result = "";
            result = this.getMetadata().get(record.getMajorVersionId());
            return (T)result;
        }
    })
    ,
        车型(new Resolver<VerUpgrade>("modelIdText", com.ccclubs.admin.metadata.MetaDef.getVehicleModelName) {
		private static final long serialVersionUID = 203884399L;

		@Override
		public <T> T execute(VerUpgrade record) {
				if(record.getModelId()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getModelId());
				return (T)result;
				}
		})
	,
        终端类型(new Resolver<VerUpgrade>("telTypeText") {
		private static final long serialVersionUID = 2038880295L;

		@Override
		public <T> T execute(VerUpgrade record) {
				if(record.getTelType()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getTelType().toString().split(",");
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
        是否对外开放(new Resolver<VerUpgrade>("isOpenText") {
		private static final long serialVersionUID = 2038852160L;

		@Override
		public <T> T execute(VerUpgrade record) {
				if(record.getIsOpen()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getIsOpen().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "是";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "否";
				}
			}

				return (T)result;
				}
		})
	,
        文件服务器名称(new Resolver<VerUpgrade>("serFtpIdText", com.ccclubs.admin.metadata.MetaDef.getFtpServerName) {
		private static final long serialVersionUID = 2038837465L;

		@Override
		public <T> T execute(VerUpgrade record) {
				if(record.getSerFtpId()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getSerFtpId());
				return (T)result;
				}
		})
	,
        是否为拐点版本(new Resolver<VerUpgrade>("turnOffFlagText") {
		private static final long serialVersionUID = 203887964L;

		@Override
		public <T> T execute(VerUpgrade record) {
				if(record.getTurnOffFlag()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getTurnOffFlag().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "否";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "是";
				}
			}

				return (T)result;
				}
		})
	;
	
	Resolver<VerUpgrade> resolver;
	VerUpgradeResolver(Resolver<VerUpgrade> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<VerUpgrade> getResolver(){
		return this.resolver;
	}
	
}
