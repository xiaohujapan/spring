package org.dxh.spring.website.constants;

public enum DataSourceType {
	//　　マスタDB
	Master("master"),
	//　　スレーブDB
	Slave("slave");
	
	private String name;
	
	private DataSourceType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
	}
}
