package com.peng.demo.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author PengG
 * @date 2020/10/29 10:59
 */
@Data
@Builder
public class Subject {
    private static final long serialVersionUID = -1;

    /** 主键ID */
    private Long id;

    /** 姓名 */
    private String name;

    /** 创建时间 */
    private String createTime;
}
