package com.codermi.mybatis.data.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author qiudm
 * @date 2019/2/13 10:03
 * @desc
 */
@Data
public class Student {

    private String id;//19 19100 001

    private String classesId;

    private String name;

    private Date birthday;

    //0-女 1-男
    private Integer sex = 1;

}
