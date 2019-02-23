package org.dxh.spring.website;

import org.dxh.spring.website.config.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;


public class Test{
	@Autowired
	BaseConfig baseConfig;
	
	public void print() {
		System.out.println(baseConfig.getBaseMode());
	}
	
}