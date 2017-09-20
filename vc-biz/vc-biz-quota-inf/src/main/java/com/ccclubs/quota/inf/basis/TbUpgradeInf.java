package com.ccclubs.quota.inf.basis;

import com.ccclubs.quota.orm.model.TbUpgrade;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.basis.TbUpgradeAddInput;
import com.ccclubs.quota.vo.basis.TbUpgradeQueryInput;
import com.github.pagehelper.PageInfo;

public interface TbUpgradeInf {
	void add(TbUpgradeAddInput input);
	void del(BaseDeleteInput input);
	void mod(TbUpgradeAddInput input);
	TbUpgrade mod(Integer tbuId);
	PageInfo<TbUpgrade> que(TbUpgradeQueryInput input);
}
