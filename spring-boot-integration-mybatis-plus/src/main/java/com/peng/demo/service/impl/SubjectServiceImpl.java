package com.peng.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peng.demo.bean.Subject;
import com.peng.demo.dao.SubjectDao;
import com.peng.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author PengG
 * @date 2020/11/2 13:54
 */
@DS("db2")
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectDao, Subject> implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    /**
     * 事务传播行为需设置为：Propagation.REQUIRES_NEW，否则数据源将切换失败
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save1() {
        Subject subject = Subject.builder().name("篮球").createTime("2020-03-03").build();
        int save = subjectDao.save(subject);
//        int i = 1/0;
        return save;
    }
}
