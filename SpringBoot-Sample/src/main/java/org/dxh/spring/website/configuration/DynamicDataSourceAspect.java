package org.dxh.spring.website.configuration;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.dxh.spring.website.annotation.TargetDataSource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;


@Aspect
@Order(-1)
@Component
@Log4j2
public class DynamicDataSourceAspect {

    @Pointcut("execution(* org.dxh.spring.website.service.*.list*(..))")
    public void pointCut() {
    }

    @Before("@annotation(targetDataSource)")
    public void doBefore(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        DataSourceKey dataSourceKey = targetDataSource.dataSourceKey();
        if (dataSourceKey == DataSourceKey.DB_SLAVE) {
        	log.info("DBソースは「" +  DataSourceKey.DB_SLAVE + "」");
            DynamicDataSourceContextHolder.set(DataSourceKey.DB_SLAVE);
        } else {
            log.info("DBソースは「" +  DataSourceKey.DB_MASTER + "」");
            DynamicDataSourceContextHolder.set(DataSourceKey.DB_MASTER);
        }
    }


    @After("@annotation(targetDataSource)")
    public void doAfter(JoinPoint joinPoint, TargetDataSource targetDataSource) {
    	log.info("接続クリア「" +  targetDataSource.dataSourceKey());
        DynamicDataSourceContextHolder.clear();
    }

    @Before(value = "pointCut()")
    public void doBeforeWithSlave(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        if (method.getDeclaringClass().isInterface()) {
            try {
                method = joinPoint.getTarget().getClass()
                        .getDeclaredMethod(joinPoint.getSignature().getName(), method.getParameterTypes());
            } catch (NoSuchMethodException e) {
            	log.info("メソッド存在しておりません！");
            }
        }
        if (null == method.getAnnotation(TargetDataSource.class)) {
            DynamicDataSourceContextHolder.setSlave();
        }
    }
}
