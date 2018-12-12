package com.codermi.mybatis.data.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author qiudm
 * @date 2018/12/12 13:57
 * @desc
 */
@Data
public class User {

    private int userId;

    private String name;

    private Date createTime;

}
