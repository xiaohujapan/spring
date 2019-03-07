package org.dxh.spring.website.constants;

public enum RedisSourceType {
	//ランキングDB
	RANKING_DB("ranking_db",0),
	//セッションDB
	SESSION_DB("session_db",1),
	// 重複チェック
	CHECK_DB("check_db",2);

	
	private String name;
	private int value;
	
	private RedisSourceType(String name,int value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
}
