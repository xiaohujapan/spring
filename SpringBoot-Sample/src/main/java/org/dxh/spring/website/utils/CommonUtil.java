package org.dxh.spring.website.utils;

import java.util.Properties;

public class CommonUtil {
	
	public static Properties getApplicationProperties() {
		Properties properties = new Properties();
		String baseMode = PropertyUtil.getProperty("base.mode");
		//　本番サーバ
		if("3".equals(baseMode)) {
			properties = PropertyUtil.getProperties("properties/application-honban.properties");
		//　テストサーバ
		}else if("2".equals(baseMode)) {
			properties = PropertyUtil.getProperties("properties/application-test.properties");
		}else {
			properties = PropertyUtil.getProperties("properties/application-local.properties");
		}
		return properties;
	}
	
}
