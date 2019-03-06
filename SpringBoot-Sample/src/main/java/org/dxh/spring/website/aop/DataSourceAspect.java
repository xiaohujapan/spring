package org.dxh.spring.website.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.dxh.spring.website.annotation.MyDataSource;
import org.dxh.spring.website.db.DynamicDataSourceContextHolder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Order(1)
@Component
@Log4j2
public class DataSourceAspect {
	
	@Pointcut("execution(* org.dxh.spring.website.service..*.*(..))")
	public void aspect() { }
	
	@Before("aspect()")
	private void doBefore(JoinPoint point) {
		Object target = point.getTarget();  
        String method = point.getSignature().getName();  
        Class<?> classz = target.getClass();  
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();  
        
        try {  
            Method m = classz.getMethod(method, parameterTypes);  
            if (m != null && m.isAnnotationPresent(MyDataSource.class)) {  
            	MyDataSource data = m.getAnnotation(MyDataSource.class);  
                DynamicDataSourceContextHolder.setDataSource(data.value().getName()); 
                log.info("=======データ付いてしました！" ,data.value().getName());
            }  
        } catch (Exception e) {  
        	log.error("error:" + e.toString());
        }  
	}
	
	@After("@annotation(myDataSource)")
	private void doAfter(JoinPoint joinPoint, MyDataSource myDataSource) {
		log.info("実行完了のソースをクリアしました" ,myDataSource.value().getName());
		DynamicDataSourceContextHolder.clear();
	}
}