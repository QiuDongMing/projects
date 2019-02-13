package com.codermi.mybatis.data.vo;

import com.codermi.mybatis.data.entity.Classes;
import com.codermi.mybatis.data.entity.Student;
import lombok.Data;

/**
 * @author qiudm
 * @date 2019/2/13 10:30
 * @desc
 */
@Data
public class StudentClassVo extends Student {

    private Classes classes;

}
