package com.ccclubs.frm.druid;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.druid.util.DruidPasswordCallback;

public class DruidSecurityPasswordCallback extends DruidPasswordCallback {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3608615762191331705L;

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		String pwd = properties.getProperty("password");
		if (StringUtils.isNotBlank(pwd)) {
			try {
				String password = "";//SecurityUtil.decryptDes(pwd, key);
				setPassword(password.toCharArray());
			} catch (Exception e) {
				setPassword(pwd.toCharArray());
			}
		}
	}

}
