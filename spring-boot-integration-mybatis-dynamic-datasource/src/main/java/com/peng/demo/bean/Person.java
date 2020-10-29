package com.peng.demo.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author PengG
 * @date 2020/10/28 14:01
 */
@Data
@Builder
public class Person {

    private static final long serialVersionUID = -1;

    /** 主键ID */
    private Long id;

    /** 姓名 */
    private String name;

    /** 年龄 */
    private Integer age;

    /** 生日 */
    private String birthday;
}
