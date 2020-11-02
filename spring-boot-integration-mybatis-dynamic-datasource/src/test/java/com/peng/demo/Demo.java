package com.peng.demo;

import com.peng.demo.bean.Person;
import com.peng.demo.bean.Subject;
import com.peng.demo.service.db2.SubjectService;
import com.peng.demo.service.primary.PersonService;
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
    private PersonService personService;
    @Autowired
    private SubjectService subjectService;

    @Test
    public void test() {
        Person person = personService.get(1L);
        Person person2 = personService.get(2L);
        log.info("查询结果：{}, {}", person, person2);
        Subject subject = subjectService.get(1L);
        log.info("查询结果：{}", subject);
        Person person3 = personService.get(3L);
        log.info("查询结果：{}", person3);
    }

    @Test
    public void transactionalTest() {
        personService.save();
        subjectService.save();
    }
}
