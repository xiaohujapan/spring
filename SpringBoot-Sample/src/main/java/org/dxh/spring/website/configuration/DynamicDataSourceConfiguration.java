package org.dxh.spring.website.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;


@MapperScan(basePackages = "org.dxh.spring.website.mapper")
@Configuration
public class DynamicDataSourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "multiple.datasource.master")
    public DataSource dbMaster() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "multiple.datasource.slave")
    public DataSource dbSlave() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public DataSource dynamicDataSource() {
        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        dataSource.setDefaultTargetDataSource(dbMaster());
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DataSourceKey.DB_MASTER, dbMaster());
        dataSourceMap.put(DataSourceKey.DB_SLAVE, dbSlave());
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("org.dxh.spring.website.mapper");
        //sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
