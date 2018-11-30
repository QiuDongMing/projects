package com.qdm.es.data;

import lombok.Data;

/**
 * @author qiudm
 * @date 2018/11/28 15:01
 * @desc
 */
@Data
public class User {

    private String id;

    private String name;

    private Integer age;

    private Integer salary;

    private Long createTime;
}
