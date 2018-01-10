package com.ccclubs.quota.inf.basis;

import com.ccclubs.quota.orm.model.CsVehicle;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.basis.CsVehicleAddInput;
import com.ccclubs.quota.vo.basis.CsVehicleQueryInput;
import com.github.pagehelper.PageInfo;

public interface CsVehicleInf {
	void add(CsVehicleAddInput input);
	void del(BaseDeleteInput input);
	void mod(CsVehicleAddInput input);
	CsVehicle mod(Integer csvId);
	PageInfo<CsVehicle> que(CsVehicleQueryInput input);
}
