package com.peng.demo.db.primary;

import com.peng.demo.bean.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author PengG
 * @date 2020/10/28 13:58
 */
@Repository
public interface PersonDao {

    /**
     * 根据ID查询数据
     * @param id id
     * @return 查询结果
     */
    @Select("SELECT id, name, age, birthday FROM person WHERE id = #{id}")
    Person get(Long id);

    @Insert("INSERT INTO person (name, age, birthday) VALUES (#{name}, #{age}, #{birthday})")
    int save(Person person);
}
