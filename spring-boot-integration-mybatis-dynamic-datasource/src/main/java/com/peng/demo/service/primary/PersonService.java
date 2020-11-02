package com.peng.demo.service.primary;

import com.peng.demo.bean.Person;

/**
 * @author PengG
 * @date 2020/11/2 14:23
 */
public interface PersonService {

    Person get(Long id);

    void save();
}
