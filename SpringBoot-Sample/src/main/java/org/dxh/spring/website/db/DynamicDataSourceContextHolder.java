package org.dxh.spring.website.db;

public class DynamicDataSourceContextHolder {
	
	private final static ThreadLocal<String> localThread  = new ThreadLocal<>();
	
	public static void setDataSource(String name) {
		localThread.set(name);
	}
	
	public static String getDataSource() {
		return localThread.get();
	}
	
	public static void clear() {
		localThread.remove();
	}
}
