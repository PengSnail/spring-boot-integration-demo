package com.peng.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.peng.demo.bean.Subject;


/**
 * @author PengG
 * @date 2020/11/2 14:23
 */
public interface SubjectService extends IService<Subject> {

    int save1();
}
