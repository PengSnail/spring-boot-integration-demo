package com.peng.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author PengG
 * @date 2020/10/29 11:36
 */
@SpringBootApplication
public class SpringBootIntegrationMybatisDynamicDatasource {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntegrationMybatisDynamicDatasource.class, args);
    }
}
