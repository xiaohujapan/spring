package org.dxh.spring.website.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value= {"classpath:properties/base.properties"})
public class BaseConfig {
	@Value("${base.mode}")
	private String baseMode;

	public String getBaseMode() {
		return baseMode;
	}

	public void setBaseMode(String baseMode) {
		this.baseMode = baseMode;
	}
}
