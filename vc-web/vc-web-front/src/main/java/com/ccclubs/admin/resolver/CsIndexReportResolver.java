package com.ccclubs.admin.resolver;

import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.CsIndexReport;


public enum CsIndexReportResolver{
	
		车辆VIN码(new Resolver<CsIndexReport>("csVinText", com.ccclubs.admin.metadata.MetaDef.getVehicleVin) {
		private static final long serialVersionUID = 203885135L;

		@Override
		public <T> T execute(CsIndexReport record) {
				if(record.getCsVin()==null){
				return null;
				}
				String result = "";
				result = this.getMetadata().get(record.getCsVin());
				return (T)result;
				}
		})
	,
		车机号(new Resolver<CsIndexReport>("csNumberText") {
		private static final long serialVersionUID = 2038871255L;

		@Override
		public <T> T execute(CsIndexReport record) {
				if(record.getCsNumber()==null){
				return null;
				}
				String result = "";
				return (T)result;
				}
		})
	,
		数据类型(new Resolver<CsIndexReport>("dataTypeText") {
		private static final long serialVersionUID = 2038810766L;

		@Override
		public <T> T execute(CsIndexReport record) {
				if(record.getDataType()==null){
				return null;
				}
				String result = "";
				String[] sArr = record.getDataType().toString().split(",");
			for(int i=0;i<sArr.length;i++){
				if(sArr[i].equals("0")){
					result+=(i==0?"":",")+ "正常";
				}
				if(sArr[i].equals("1")){
					result+=(i==0?"":",")+ "未纳入";
				}
				if(sArr[i].equals("2")){
					result+=(i==0?"":",")+ "超标";
				}
			}

				return (T)result;
				}
		})
	;
	
	Resolver<CsIndexReport> resolver;
	CsIndexReportResolver(Resolver<CsIndexReport> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsIndexReport> getResolver(){
		return this.resolver;
	}
	
}
