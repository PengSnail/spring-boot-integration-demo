package com.peng.demo.service.db2.impl;

import com.peng.demo.bean.Subject;
import com.peng.demo.db.db2.SubjectDao;
import com.peng.demo.service.db2.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author PengG
 * @date 2020/11/2 13:54
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Subject get(Long id) {
        return subjectDao.get(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save() {
        Subject subject = Subject.builder().name("篮球").createTime("2020-03-03").build();
        subjectDao.save(subject);
    }
}
