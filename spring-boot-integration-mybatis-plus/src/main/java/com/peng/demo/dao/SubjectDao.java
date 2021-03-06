package com.peng.demo.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peng.demo.bean.Subject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author PengG
 * @date 2020/10/29 11:05
 */
@Repository
public interface SubjectDao extends BaseMapper<Subject> {

    /**
     * 根据ID查询数据
     * @param id id
     * @return 查询结果
     */
    @Select("SELECT id, name, create_time FROM subject WHERE id = #{id}")
    Subject get(Long id);

    @Insert("INSERT INTO subject (name, create_time) VALUES (#{name}, #{createTime})")
    int save(Subject subject);
}
