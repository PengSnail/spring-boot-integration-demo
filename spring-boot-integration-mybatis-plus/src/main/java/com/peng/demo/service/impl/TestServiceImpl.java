package com.peng.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peng.demo.bean.Person;
import com.peng.demo.bean.Subject;
import com.peng.demo.dao.PersonDao;
import com.peng.demo.dao.SubjectDao;
import com.peng.demo.service.PersonService;
import com.peng.demo.service.SubjectService;
import com.peng.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author PengG
 * @date 2020/10/28 9:26
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private SubjectDao subjectDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save() {
        Subject subject = Subject.builder().name("篮球").createTime("2020-03-03").build();
        int save = subjectDao.save(subject);
//        int i = 1/0;
        return save;
    }

    @Override
    public int delById(Long id) {
        return 0;
    }

    @Override
    public int myUpdate(Person person) {
        return 0;
    }


}
