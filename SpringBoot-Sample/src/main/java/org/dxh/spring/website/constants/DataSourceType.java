package org.dxh.spring.website.constants;

public enum DataSourceType {
	//　　マスタDB
	DB_Master("db_master"),
	//　　スレーブDB
	DB_Slave("db_slave"),
	// メールDB
	DB_MAIL("db_mail"),
	// アクセスDB
	DB_ACCESS("db_access");
	
	private String name;
	
	private DataSourceType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
