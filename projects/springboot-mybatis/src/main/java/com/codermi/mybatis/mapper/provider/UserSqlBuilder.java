package com.codermi.mybatis.mapper.provider;

import com.codermi.mybatis.mapper.param.UserParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/12/12 17:15
 * @desc
 */
public class UserSqlBuilder {


    public static String findByCondition(UserParam userParam) {
        SQL sql = new SQL();
        sql.SELECT("*").FROM("t_user");
        if (StringUtils.isNotEmpty(userParam.getName())) {
            sql.WHERE("name=#{name}");
        }

        if (Objects.nonNull(userParam.getUserId())) {
            sql.WHERE("user_id=#{userId}");
        }

        return sql.toString();
    }


}
