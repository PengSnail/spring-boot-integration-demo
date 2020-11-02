package com.peng.demo.service.db2;

import com.peng.demo.bean.Subject;

/**
 * @author PengG
 * @date 2020/11/2 14:23
 */
public interface SubjectService {

    Subject get(Long id);

    void save();
}
