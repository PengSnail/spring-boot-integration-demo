package com.peng.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peng.demo.bean.Person;
import com.peng.demo.dao.PersonDao;
import com.peng.demo.service.PersonService;
import com.peng.demo.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author PengG
 * @date 2020/10/28 9:26
 */
@Slf4j
@DS("master")
@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao, Person> implements PersonService {

    @Autowired
    private PersonDao personDao;
    @Autowired
    private SubjectService subjectService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save() {
        Person person = Person.builder().name("蔡徐坤").age(3).birthday("2020-03-03").build();
        int insert = personDao.insert(person);
        log.info("PersonDao: {}", insert);
        int save = subjectService.save();
        log.info("SubjectService: {}", save);
    }

    @Override
    public int delById(Long id) {
        return personDao.delById(id);
    }

    @Override
    public int myUpdate(Person person) {
        return personDao.myUpdate(person);
    }
}
