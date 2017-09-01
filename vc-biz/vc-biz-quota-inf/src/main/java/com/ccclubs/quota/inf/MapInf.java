package com.ccclubs.quota.inf;

import java.util.List;

import com.ccclubs.quota.orm.model.CsState;
import com.ccclubs.quota.vo.MapInput;
import com.ccclubs.quota.vo.MapOutput;

public interface MapInf {
	List<CsState> csStateList();
	
	MapOutput map(MapInput input);
	
	MapOutput district(MapInput input);
}
