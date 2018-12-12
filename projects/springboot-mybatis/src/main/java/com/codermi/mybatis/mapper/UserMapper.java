package com.codermi.mybatis.mapper;

import com.codermi.mybatis.data.entity.User;
import com.codermi.mybatis.mapper.param.UserParam;
import com.codermi.mybatis.mapper.provider.UserSqlBuilder;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author qiudm
 * @date 2018/12/12 14:04
 * @desc
 */
@Mapper
public interface UserMapper {

    @Select({"select * from t_user where user_id=#{userId, jdbcType=INTEGER}"})
    User getByUserId(@Param("userId") int userId);

    @Select({"select * from t_user"})
    List<User> getUserList();

    @Insert({"insert into t_user(name, create_time) " +
            "values(#{name, jdbcType=VARCHAR}, #{createTime, jdbcType=TIMESTAMP})"
    })
    void insert(User user);

    @SelectProvider(type = UserSqlBuilder.class, method = "findByCondition")
    List<User> findByCondition(UserParam userParam);


}
