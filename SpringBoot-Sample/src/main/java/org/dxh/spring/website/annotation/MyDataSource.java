package org.dxh.spring.website.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.dxh.spring.website.constants.DataSourceType;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
public @interface MyDataSource {

	DataSourceType value() default DataSourceType.DB_Master;	
	
}
