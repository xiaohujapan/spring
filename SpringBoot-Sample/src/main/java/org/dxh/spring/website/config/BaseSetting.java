package org.dxh.spring.website.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:properties/base.properties")
public class BaseSetting {
	@Value("${base.mode}")
	private String baseMode;

	public String getBaseMode() {
		return baseMode;
	}

	public void setBaseMode(String baseMode) {
		this.baseMode = baseMode;
	}


	public String toString() {
		return "BaseSetting{" + "baseMode=" + baseMode + "}";
	}
	
}
