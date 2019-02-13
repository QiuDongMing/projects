package com.codermi.mybatis.service;

import com.alibaba.fastjson.JSON;
import com.codermi.mybatis.BaseTest;
import com.codermi.mybatis.data.entity.Student;
import com.codermi.mybatis.data.vo.StudentClassVo;
import com.codermi.mybatis.data.vo.StudentScoreVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author qiudm
 * @date 2019/2/13 11:22
 * @desc
 */
public class StudentServiceTest extends BaseTest  {

    @Autowired
    private StudentService studentService;

    @Test
    public void getById() {
        String id = "1919100001";
        StudentClassVo studentClassVo = studentService.getById(id);
        System.out.println("JSON.toJSONString(studentClassVo) = " + JSON.toJSONString(studentClassVo));
    }


    @Test
    public void getStudentScoreById() {
        String id = "1919100001";
        StudentScoreVo StudentScoreVo = studentService.getStudentScoreById(id);
        System.out.println("JSON.toJSONString(StudentScoreVo) = " + JSON.toJSONString(StudentScoreVo));
    }

    @Test
    public void addStudent() {
        String id = "1919100004";
        Student student = new Student();
        student.setId(id);
        student.setBirthday(new Date());
        student.setClassesId("1001");
        student.setName("增加");
        studentService.addStudent(student);
    }




}