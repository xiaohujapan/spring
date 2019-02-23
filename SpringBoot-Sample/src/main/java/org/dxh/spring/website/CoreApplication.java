package org.dxh.spring.website;

import org.dxh.spring.website.config.BaseConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoreApplication{

	public static void main(String[] args) {
		
		//SpringApplication.run(CoreApplication.class, args);
		//System.out.println(baseSetting.toString());
		/****/
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BaseConfig.class);

		BaseConfig resourceService = context.getBean(BaseConfig.class);
		System.out.println(resourceService.getBaseMode());
		resourceService.toString();

        context.close();
		
	}
	
	 
}
