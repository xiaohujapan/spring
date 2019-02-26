package org.dxh.spring.website.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //通过该注解来表明该类是一个Spring配置，相当于一个XML文件
@ComponentScan(basePackages="org.dxh.spring.website.test") //配置扫描包
public class SpringConfig {
	
	@Bean //通过该注解来表明这是一个BEAN对象，相当于XML中的<bean>
	public UserDAO getUserDAO() {
		return new UserDAO();   //直接New对象做演示
	}
}
