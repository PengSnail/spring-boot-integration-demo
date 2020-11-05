package com.peng.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peng.demo.SpringBootIntegrationMybatisPlusTest;
import com.peng.demo.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author PengG
 * @date 2020/10/28 14:09
 */
@Slf4j
public class Demo extends SpringBootIntegrationMybatisPlusTest {

    @Autowired
    private PersonService personService;

    /**
     * Mybatis-plus封装的新增单条数据 save 方法
     */
    @Test
    public void save() {
        Person tom = Person.builder().name("Tom").age(20).birthday("2020-02-02").build();
        boolean save = personService.save(tom);
        log.info("新增数据结果【save】:{}, 返回Id={}", save, tom.getId());
    }

    /**
     * Mybatis-plus封装的根据ID删除数据 removeById 方法
     */
    @Test
    public void delete() {
        boolean remove = personService.removeById(2L);
        log.info("删除数据结果【removeById】:{}", remove);
    }

    /**
     * Mybatis-plus封装的更新数据 removeById 方法
     */
    @Test
    public void update() {
        Person luce = Person.builder().id(1L).name("Luce").age(18).birthday("2020-03-03").build();
        boolean update = personService.updateById(luce);
        log.info("更新结果【updateById】:{}", update);
    }

    /**
     * Mybatis-plus封装的查询所有数据 list 方法
     */
    @Test
    public void select() {
        List<Person> list = personService.list();
        log.info("所有数据【list】:{}", list);
    }

    /**
     * Mybatis-plus封装的无条件分页查询 page 方法
     */
    @Test
    public void page() {
        Page<Person> page = new Page<Person>(1, 2);
        page.addOrder(OrderItem.desc("id"));
        Page<Person> personPage = personService.page(page);
        log.info("分页数据【page】:{}", personPage.getRecords());
    }

    /**
     * Mybatis-plus封装的查询单条数据 getById 方法
     */
    @Test
    public void get() {
        //根据 ID 查询
        Person byId = personService.getById(1L);
        log.info("查询结果【getById】:{}", byId);
    }

    /**
     * 自定义条件查询
     */
    @Test
    public void condition() {
        QueryWrapper<Person> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "Tom").and((i)-> i.ge("age", "18"));
        List<Person> list = personService.list(wrapper);
        log.info("条件查询【list】:{}", list);
    }

    /**
     * 多数据源切换事务测试
     */
    @Test
    public void test() {
        personService.save();
    }
}
