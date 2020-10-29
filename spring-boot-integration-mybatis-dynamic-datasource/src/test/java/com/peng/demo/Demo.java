package com.peng.demo;

import com.peng.demo.SpringBootIntegrationMybatisDynamicDatasourceTest;
import com.peng.demo.bean.Person;
import com.peng.demo.bean.Subject;
import com.peng.demo.db.db2.SubjectDao;
import com.peng.demo.db.primary.PersonDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PengG
 * @date 2020/10/28 14:09
 */
@Slf4j
public class Demo extends SpringBootIntegrationMybatisDynamicDatasourceTest {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private SubjectDao subjectDao;

    @Test
    public void test() {
        Person person = personDao.get(1L);
        Person person2 = personDao.get(2L);
        log.info("查询结果：{}, {}", person, person2);
        Subject subject = subjectDao.get(1L);
        log.info("查询结果：{}", subject);
        Person person3 = personDao.get(3L);
        log.info("查询结果：{}", person3);
    }
}
