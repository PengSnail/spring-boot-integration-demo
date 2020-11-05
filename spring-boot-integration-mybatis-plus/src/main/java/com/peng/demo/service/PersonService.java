package com.peng.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.peng.demo.bean.Person;

/**
 * @author PengG
 * @date 2020/10/28 9:26
 */
public interface PersonService extends IService<Person> {

    void save();

    /**
     * 根据ID删除目标数据
     * @param id id
     * @return 删除结果
     */
    int delById(Long id);

    /**
     * 更新数据
     * @param person 更新内容
     * @return 更新结果
     */
    int myUpdate(Person person);
}
