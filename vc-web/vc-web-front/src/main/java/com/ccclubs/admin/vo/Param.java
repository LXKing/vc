package com.ccclubs.admin.vo;

import com.ccclubs.protocol.util.StringUtils;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Joel
 *
 * @param <K>
 * @param <V>
 */
public class Param<K, V> extends HashMap<K, V> {

	private static final long serialVersionUID = 745766903911019839L;

	/**
	 * 根据返回类型获取
	 * @param key
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String key, Class<?> clazz) {
		if (key == null)
			return null;

		V value = super.get(key);
		if (value != null) {
			if (clazz != null) {
				if (clazz == Short.class) {
					return (T) Short.valueOf(value.toString());
				} else if (clazz == Long.class) {
					return (T) Long.valueOf(value.toString());
				} else if (clazz == String.class) {
					return (T) String.valueOf(value.toString());
				} else if (clazz == Boolean.class) {
					return (T) Boolean.valueOf(value.toString());
				} else if (clazz == Double.class) {
					return (T) Double.valueOf(value.toString());
				} else if (clazz == Float.class) {
					return (T) Float.valueOf(value.toString());
				} else if (clazz == Date.class) {
					return (T) StringUtils.date(value.toString(), "YYYY-MM-dd HH:mm:ss");
				} else if (clazz == Integer.class){
					return (T) Integer.valueOf(value.toString());
				}
			} else {
				return (T) value;
			}
		}

		return null;
	}

	/**
	 * 根据默认值获取
	 * @param key
	 * @param defaultValue	默认值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String key, T defaultValue) {
		if (key == null)
			return null;

		V value = super.get(key);
		if (value != null) {
			if (defaultValue instanceof Long) {
				return (T) Long.valueOf(value.toString());
			} else if (defaultValue instanceof Date) {
				return (T)  StringUtils.date(value.toString(), "YYYY-MM-dd HH:mm:ss");
			} else if (defaultValue instanceof Short) {
				return (T) Short.valueOf(value.toString());
			} else if (defaultValue instanceof Boolean) {
				return (T) Boolean.valueOf(value.toString());
			} else if (defaultValue instanceof Double) {
				return (T) Double.valueOf(value.toString());
			} else if (defaultValue instanceof Float) {
				return (T) Float.valueOf(value.toString());
			} else if (defaultValue instanceof Integer) {
				return (T) Integer.valueOf(value.toString());
			}
			return (T) value.toString();
		}

		return defaultValue;
	}
	
	public Param<K,V> set(K key, V value){
		super.put(key, value);
		return this;
	}
	
	public int getPage() {
		return get("page", 0) + 1;
	}
}
