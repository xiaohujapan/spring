package org.dxh.spring.website;

import org.dxh.spring.website.utils.PropertyUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication{

	public static void main(String[] args) {
		
		//SpringApplication.run(CoreApplication.class, args);
		//System.out.println(baseSetting.toString());
		/****/
		String baseMode = PropertyUtil.getProperty("base.mode");
		System.out.println(baseMode);
	}
	
	 
}
