package com.ccclubs.demo.inf;

import com.ccclubs.demo.mod.DemoInput;
import com.ccclubs.demo.mod.DemoOutput;

public interface DemoInf {
	String sayDemo(String notify);
	DemoOutput sayHi(DemoInput input);
	DemoOutput dubboxErrorCall(DemoInput input);
}
