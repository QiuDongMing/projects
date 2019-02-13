package com.codermi.mybatis.controller;

import com.codermi.mybatis.data.vo.StudentClassVo;
import com.codermi.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiudm
 * @date 2019/2/13 13:39
 * @desc
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/get/{id}")
    public StudentClassVo getStudentClassInfo(@PathVariable String id){
        return studentService.getById(id);
    }

}
