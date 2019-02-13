package com.codermi.mybatis.service;

import com.codermi.mybatis.data.entity.Student;
import com.codermi.mybatis.data.vo.StudentClassVo;
import com.codermi.mybatis.data.vo.StudentScoreVo;
import com.codermi.mybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private StudentMapper studentMapper;

    public StudentClassVo getById(String id) {
        return studentMapper.getStudentClassesById(id);
    }


    public StudentScoreVo getStudentScoreById(String id) {
        return studentMapper.getStudentScoreById(id);
    }


    public void addStudent(Student student) {
        studentMapper.insert(student);
    }


}
