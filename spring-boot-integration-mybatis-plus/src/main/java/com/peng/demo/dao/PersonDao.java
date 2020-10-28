package com.peng.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peng.demo.bean.Person;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

/**
 * @author PengG
 * @date 2020/10/28 13:58
 */
@Repository
public interface PersonDao extends BaseMapper<Person> {

    /**
     * 根据ID删除目标数据
     * @param id id
     * @return 删除结果
     */
    @Delete("DELETE FROM person WHERE id = #{id}")
    int delById(Long id);

    /**
     * 更新数据
     * @param person 更新内容
     * @return 更新结果
     */
    int myUpdate(Person person);
}
