package com.rvsoni.ecom.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="ecom")
public class AppConfig {
	
	private static final Logger log = LoggerFactory.getLogger(AppConfig.class);
	
	private String userAddressServiceURL;
	private String logDir;
	
	public String getUserAddressServiceURL() {
		return userAddressServiceURL;
	}

	public void setUserAddressServiceURL(String userAddressServiceURL) {
		this.userAddressServiceURL = userAddressServiceURL;
	}

	public String getLogDir() {
		return logDir;
	}

	public void setLogDir(String logDir) {
		this.logDir = logDir;
	}

	
}