package com.ccclubs.engine.rule.inf;

public class GlobalConfig {

	private static boolean showSoure;

	public static boolean isShowSoure() {
		return showSoure;
	}

	public static void setShowSoure(boolean showSoure) {
		GlobalConfig.showSoure = showSoure;
	}

	public static String getClassName(Class modelClass) {
		return modelClass.getName().replaceAll("[^\\.]*\\.", "");
	}
}
