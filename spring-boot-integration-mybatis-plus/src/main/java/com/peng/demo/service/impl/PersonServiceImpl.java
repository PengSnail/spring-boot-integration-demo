package com.peng.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peng.demo.bean.Person;
import com.peng.demo.dao.PersonDao;
import com.peng.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author PengG
 * @date 2020/10/28 9:26
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao, Person> implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public int delById(Long id) {
        return personDao.delById(id);
    }

    @Override
    public int myUpdate(Person person) {
        return personDao.myUpdate(person);
    }
}
