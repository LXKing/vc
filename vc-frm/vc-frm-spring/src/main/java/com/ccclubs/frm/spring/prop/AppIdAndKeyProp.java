package com.ccclubs.frm.spring.prop;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "api")
public class AppIdAndKeyProp {
	private HashMap<String, String> security;

	public HashMap<String, String> getSecurity() {
		return security;
	}

	public void setSecurity(HashMap<String, String> security) {
		this.security = security;
	}
 
}
