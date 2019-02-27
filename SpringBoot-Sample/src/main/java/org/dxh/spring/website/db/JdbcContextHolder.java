package org.dxh.spring.website.db;

public class JdbcContextHolder {
	private final static ThreadLocal<String> local = new ThreadLocal<>();
	
	public static void putDataSource(String name) {
		local.set(name);
	}
	
	public static String getDataSource() {
		return local.get();
	}
	
	public static void clear() {
		local.remove();
	}
}
