package com.peng.demo.dataSource;

/**
 * @author PengG
 * @date 2020/10/29 9:36
 */
public enum DataSourceTypeEnum {
    /** 数据源 primary */
    PRIMARY("PRIMARY"),
    /** 数据源 db2 */
    DB2("DB2"),
    ;

    private String db;

    DataSourceTypeEnum(String db) {
        this.db = db;
    }

    public String getDb() {
        return db;
    }
}
