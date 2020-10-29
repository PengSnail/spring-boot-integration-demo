package com.peng.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.peng.demo.dataSource.DataSourceTypeEnum;
import com.peng.demo.dataSource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author PengG
 * @date 2020/10/28 19:25
 */
@MapperScan({"com.peng.demo.db.primary", "com.peng.demo.db.db2"})
@Configuration
@EnableTransactionManagement//开启声明式事务
public class MybatisPlusConfig {

    @Bean("primary")
    @ConfigurationProperties(prefix = "primary.datasource.druid")
    public DataSource primary() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("db2")
    @ConfigurationProperties(prefix = "db2.datasource.druid")
    public DataSource db2() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源配置
     * @return 多数据源
     */
    @Bean
    @Primary
    public DataSource multipleDataSource(
            @Qualifier("primary") DataSource primary,
            @Qualifier("db2") DataSource db2) {
        //获取当前线程的数据源类型
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //组拼目标数据源的映射
        HashMap<Object, Object> targetDataSources = new HashMap<>(8);
        targetDataSources.put(DataSourceTypeEnum.PRIMARY.getDb(), primary);
        targetDataSources.put(DataSourceTypeEnum.DB2.getDb(), db2);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

    /**
     * 构建 SqlSessionFactory
     * @return SqlSessionFactory
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(multipleDataSource(primary(), db2()));
        return factoryBean.getObject();
    }
}
