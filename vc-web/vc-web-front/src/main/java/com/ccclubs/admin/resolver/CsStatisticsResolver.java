package com.ccclubs.admin.resolver;

import com.ccclubs.admin.metadata.MetaDef;
import com.ccclubs.admin.vo.Resolver;
import com.ccclubs.admin.model.CsStatistics;


public enum CsStatisticsResolver{

	车型(new Resolver<CsStatistics>("cssCarModelText", MetaDef.getVehicleModelName) {
		private static final long serialVersionUID = 2038866019L;

		@Override
		public <T> T execute(CsStatistics record) {
			if(record.getCssCarModel()==null){
				return null;
			}
			String result = "";
			result = this.getMetadata().get(record.getCssCarModel());
			return (T)result;
		}
	})
			;
	Resolver<CsStatistics> resolver;
	CsStatisticsResolver(Resolver<CsStatistics> resolver){
		this.resolver = resolver;
	}
	
	public String getName(){
		return this.resolver.getName();
	}
	
	public Resolver<CsStatistics> getResolver(){
		return this.resolver;
	}
	
}
