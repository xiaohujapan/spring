package org.dxh.spring.website.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.dxh.spring.website.constants.DataSourceType;
import org.dxh.spring.website.db.DynamicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@MapperScan(basePackages = "org.dxh.spring.website.mapper")
@Configuration
public class DataSourceConfig {
	
	@Bean(name = "db_master")
	@ConfigurationProperties(prefix = "multiple.datasource.master") 
	public DataSource dataSourceMaster() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean(name = "db_slave")
	@ConfigurationProperties(prefix = "multiple.datasource.slave") 
	public DataSource dataSourceSlave() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean(name = "db_mail")
	@ConfigurationProperties(prefix = "multiple.datasource.mail") 
	public DataSource dataSourceMail() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean(name = "db_access")
	@ConfigurationProperties(prefix = "multiple.datasource.access") 
	public DataSource dataSourceAccess() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean(name="dynamicDataSource")
	@Primary
	public DataSource dataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		DataSource master 	  = dataSourceMaster();
		DataSource slave   	  = dataSourceSlave();
		//DataSource mail   	  = dataSourceMail();
		//DataSource access    = dataSourceAccess();
		
		dynamicDataSource.setDefaultTargetDataSource(master);	
		
		Map<Object,Object> map = new HashMap<>();
		map.put(DataSourceType.DB_Master.getName(), master);
		map.put(DataSourceType.DB_Slave.getName(), slave);
		//map.put(DataSourceType.DB_MAIL.getName(), slave);
 	    //map.put(DataSourceType.DB_ACCESS.getName(), slave);
		
		dynamicDataSource.setTargetDataSources(map);			
		return dynamicDataSource;
	}
	
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }


    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
	
}
