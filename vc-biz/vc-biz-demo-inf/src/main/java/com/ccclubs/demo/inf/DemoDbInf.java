package com.ccclubs.demo.inf;

import com.ccclubs.demo.mod.DbInput;
import com.ccclubs.demo.mod.DbOutput;
import com.ccclubs.demo.mod.DbPageInput;
import com.ccclubs.demo.mod.DbPageOutput;

public interface DemoDbInf {
	String sayDbDemo(String db);
	DbOutput dbList(DbInput input);
	DbPageOutput dbList(DbPageInput input);
}
