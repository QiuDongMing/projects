package com.codermi.mybatis.data.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author qiudm
 * @date 2018/12/12 15:46
 * @desc
 */
@Data
public class UserVo {

    private int userId;

    private String name;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
