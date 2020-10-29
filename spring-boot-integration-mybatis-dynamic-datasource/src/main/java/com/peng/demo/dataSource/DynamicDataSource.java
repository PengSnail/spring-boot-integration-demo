package com.peng.demo.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 文档{https://github.com/alibaba/druid/wiki/%E6%95%B0%E6%8D%AE%E5%BA%93%E5%A4%9A%E6%95%B0%E6%8D%AE%E6%BA%90}
 * @author PengG
 * @date 2020/10/29 9:32
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDbType();
    }
}
