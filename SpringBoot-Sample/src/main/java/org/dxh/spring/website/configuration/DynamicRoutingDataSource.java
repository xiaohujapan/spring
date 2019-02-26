package org.dxh.spring.website.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		log.info("現在のDBソースは"+ DynamicDataSourceContextHolder.get());
        return DynamicDataSourceContextHolder.get();
	}

}
