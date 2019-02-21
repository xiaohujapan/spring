package org.dxh.spring.website.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:properties/base.properties")
@ConfigurationProperties(prefix = "base")
public class BaseSetting {
	private String mode;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}


	public String toString() {
		return "BaseSetting{" + "mode=" + mode + "}";
	}
	
}
