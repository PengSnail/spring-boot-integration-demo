package com.peng.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @author PengG
 * @date 2020/10/28 14:01
 */
@Data
@Builder
@TableName("person")
public class Person {

    private static final long serialVersionUID = -1;

    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 姓名 */
    private String name;

    /** 年龄 */
    private Integer age;

    /** 生日 */
    private String birthday;
}
