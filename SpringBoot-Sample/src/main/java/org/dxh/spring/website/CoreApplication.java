package org.dxh.spring.website;

import org.dxh.spring.website.utils.CommonUtil;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class CoreApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CoreApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication appliaction = new SpringApplication(CoreApplication.class);
		appliaction.setDefaultProperties(CommonUtil.getApplicationProperties());
		appliaction.setBannerMode(Banner.Mode.OFF);
		appliaction.run(args);
		log.info("サービス　Start!");
	}
	 
}
