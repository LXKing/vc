package com.ccclubs.quota.inf.basis;

import com.ccclubs.quota.orm.model.CsTerminal;
import com.ccclubs.quota.vo.basis.CsTerminalAddInput;
import com.ccclubs.quota.vo.basis.CsTerminalDelInput;
import com.ccclubs.quota.vo.basis.CsTerminalQueryInput;
import com.github.pagehelper.PageInfo;

public interface CsTerminalInf {
	void add(CsTerminalAddInput input);
	void del(CsTerminalDelInput input);
	void mod(CsTerminalAddInput input);
	CsTerminal mod(Long cstId);
	PageInfo<CsTerminal> que(CsTerminalQueryInput input);
}
