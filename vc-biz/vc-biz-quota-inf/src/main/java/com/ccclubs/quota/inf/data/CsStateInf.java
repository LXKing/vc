package com.ccclubs.quota.inf.data;

import com.ccclubs.quota.orm.model.CsState;
import com.ccclubs.quota.orm.model.CsStateBiz;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.data.CsStateAddInput;
import com.ccclubs.quota.vo.data.CsStateQueryInput;
import com.github.pagehelper.PageInfo;

public interface CsStateInf {
	void add(CsStateAddInput input);
	void del(BaseDeleteInput input);
	void mod(CsStateAddInput input);
	CsState mod(Integer cssId);
	PageInfo<CsStateBiz> que(CsStateQueryInput input);

}
