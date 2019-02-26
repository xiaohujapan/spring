package org.dxh.spring.website.configuration;

public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<DataSourceKey> currentDatesource = new ThreadLocal<>();

    public static void clear() {
        currentDatesource.remove();
    }

    public static DataSourceKey get() {
        return currentDatesource.get();
    }


    public static void set(DataSourceKey value) {
        currentDatesource.set(value);
    }
    
    public static void setMaster() {
        DynamicDataSourceContextHolder.set(DataSourceKey.DB_MASTER);
    }


    public static void setSlave() {
        DynamicDataSourceContextHolder.set(DataSourceKey.DB_SLAVE);
    }
}
