package org.dxh.spring.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan(basePackages = "org.dxh.spring.website.mapper")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class},scanBasePackages = "org.dxh.spring.website")
public class CoreApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CoreApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}
