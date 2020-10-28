package com.peng.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PengG
 * @date 2020/9/28 15:58
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "search-server.elasticsearch")
public class ElasticsearchProperties {

    /**
     * 集群名称
     */
    private String clusterName = "elasticsearch";

    /**
     * 集群节点
     */
    private List<String> clusterNodes = new ArrayList<>();
}
