package com.peng.demo.dataSource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author PengG
 * @date 2020/10/29 11:08
 */
@Slf4j
@Aspect
@Order(1) //保证数据源切换的AOP早于事务的AOP
@Component
public class DatasourceSelectorAspect {

    /**
     * 定义 primary 数据源切入点
     */
    @Pointcut("execution(* com.peng.demo.service.primary..*.*(..))")
    private void primaryAspect(){}

    /**
     * 定义 db2 数据源切入点
     */
    @Pointcut("execution(* com.peng.demo.service.db2..*.*(..))")
    private void db2Aspect(){}

    /**
     * primary 数据源切入点的前置通知
     */
    @Before("primaryAspect()")
    public void primary() {
        log.info("切换数据源 primary");
        DataSourceContextHolder.setDbType(DataSourceTypeEnum.PRIMARY);
    }

    /**
     * db2 数据源切入点的前置通知
     */
    @Before("db2Aspect()")
    public void db2() {
        log.info("切换数据源 db2");
        DataSourceContextHolder.setDbType(DataSourceTypeEnum.DB2);
    }
}
