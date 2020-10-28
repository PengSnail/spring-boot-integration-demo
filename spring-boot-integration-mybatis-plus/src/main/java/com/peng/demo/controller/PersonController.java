package com.peng.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peng.demo.bean.Person;
import com.peng.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PengG
 * @date 2020/10/28 14:31
 */
@Slf4j
@RestController
@RequestMapping("/index/")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("test")
    public void test(Page<Person> page) {
        Page<Person> personPage = personService.page(page);
        log.info("分页结果:{}", personPage.getRecords());
    }
}
