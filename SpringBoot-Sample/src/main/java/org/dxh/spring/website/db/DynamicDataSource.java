package org.dxh.spring.website.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		log.info("データソースは「" + DynamicDataSourceContextHolder.getDataSource() + "」");
		return DynamicDataSourceContextHolder.getDataSource();
	}

}
