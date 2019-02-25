package org.dxh.spring.website.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PropertyUtil {
	private static String BASE_PROPERTIES_FILE = "properties/base.properties";
	
	private static Properties props;
    static{
        loadProps();
    }

    synchronized static private void loadProps(){
        props = new Properties();
        InputStream in = null;
        try {
            in = PropertyUtil.class.getClassLoader().getResourceAsStream(BASE_PROPERTIES_FILE);
            props.load(in);
        } catch (FileNotFoundException e) {
        	log.error("ファイル「"+BASE_PROPERTIES_FILE + "」存在しておりません！");
        } catch (IOException e) {
        	log.error("IOエラー:" + e.toString());
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
            	log.error("ファイル「"+BASE_PROPERTIES_FILE + "」クローズエラー");
            }
        }
        log.debug("ファイル「" + BASE_PROPERTIES_FILE + "」：" + props);
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}
