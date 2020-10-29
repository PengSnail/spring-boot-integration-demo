package com.peng.demo.dataSource;

/**
 * @author PengG
 * @date 2020/10/29 9:39
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源信息
     * @param dbType 数据源枚举类型
     */
    public static void setDbType(DataSourceTypeEnum dbType) {
        CONTEXT_HOLDER.set(dbType.getDb());
    }

    /**
     * 获取当前数据源信息
     * @return 数据源类型
     */
    public static String getDbType() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDbType() {
        CONTEXT_HOLDER.remove();
    }
}
