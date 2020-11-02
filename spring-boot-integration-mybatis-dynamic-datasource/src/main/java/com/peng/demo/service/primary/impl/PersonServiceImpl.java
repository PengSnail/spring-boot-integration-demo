package com.peng.demo.service.primary.impl;

import com.peng.demo.bean.Person;
import com.peng.demo.db.primary.PersonDao;
import com.peng.demo.service.primary.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author PengG
 * @date 2020/11/2 13:54
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    public Person get(Long id) {
        return personDao.get(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save() {
        Person person = Person.builder().name("蔡徐坤").age(3).birthday("2020-03-03").build();
        personDao.save(person);
    }
}
