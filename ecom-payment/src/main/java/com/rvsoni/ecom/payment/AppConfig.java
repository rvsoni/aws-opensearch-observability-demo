package com.rvsoni.ecom.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="ecom")
public class AppConfig {
	
	private static final Logger log = LoggerFactory.getLogger(AppConfig.class);
	
	private String userServiceURL;
	private String logDir;
	
	public String getUserServiceURL() {
		return userServiceURL;
	}

	public void setUserServiceURL(String userServiceURL) {
		this.userServiceURL = userServiceURL;
	}

	public String getLogDir() {
		return logDir;
	}

	public void setLogDir(String logDir) {
		this.logDir = logDir;
	}

	
}