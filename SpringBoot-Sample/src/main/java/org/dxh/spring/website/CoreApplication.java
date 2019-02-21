package org.dxh.spring.website;

import org.dxh.spring.website.config.BaseSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication{

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}
