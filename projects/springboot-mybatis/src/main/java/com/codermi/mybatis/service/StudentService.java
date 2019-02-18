package com.codermi.mybatis.service;

import com.codermi.mybatis.data.entity.Student;
import com.codermi.mybatis.data.vo.StudentClassVo;
import com.codermi.mybatis.data.vo.StudentScoreVo;
import com.codermi.mybatis.event.EmailEvent;
import com.codermi.mybatis.mapper.StudentMapper;
import com.codermi.mybatis.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qiudm
 * @date 2019/2/13 11:20
 * @desc
 */
@Service
@Transactional
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentMapper studentMapper;

    public StudentClassVo getById( String id) {
        /**
         * 测试spring的事件监听
         */
        ApplicationContext context = SpringContextUtil.getApplicationContext();
        EmailEvent emailEvent = new EmailEvent("qdm@qq.com", " content ", "test");
        context.publishEvent(emailEvent);

        return studentMapper.getStudentClassesById(id);
    }


    public StudentScoreVo getStudentScoreById(String id) {
        return studentMapper.getStudentScoreById(id);
    }


    public void addStudent(Student student) {
        studentMapper.insert(student);
    }


}
