package org.dxh.spring.website.db;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.dxh.spring.website.constants.DataSourceType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class DataSourceConfig {
	@Bean(name = "master")
	@ConfigurationProperties(prefix = "multiple.datasource.master") 
	public DataSource dataSource1() {
		log.info("Master-DB");
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "slave")
	@ConfigurationProperties(prefix = "multiple.datasource.slave") 
	public DataSource dataSource2() {
		log.info("Slave-DB");
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="dynamicDataSource")
	@Primary
	public DataSource dataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		DataSource master = dataSource1();
		DataSource slave = dataSource2();
		dynamicDataSource.setDefaultTargetDataSource(master);	
		Map<Object,Object> map = new HashMap<>();
		map.put(DataSourceType.Master.getName(), master);
		map.put(DataSourceType.Slave.getName(), slave);
		dynamicDataSource.setTargetDataSources(map);			
		return dynamicDataSource;
	}
}
