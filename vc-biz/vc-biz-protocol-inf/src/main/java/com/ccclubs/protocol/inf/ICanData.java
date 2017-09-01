package com.ccclubs.protocol.inf;

import java.util.Map;

public interface ICanData {

	public int getCanId();

	public int getLength();

	public void traceStruct();

	public Map<String, Object> getMap();

	public Map<String, Object> getErrorInfoMap();

	public Class getClassType();
}
