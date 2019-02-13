package com.codermi.mybatis.mapper;

import com.codermi.mybatis.data.entity.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author qiudm
 * @date 2019/2/13 10:24
 * @desc
 */
@Mapper
public interface ClassMapper {

    @Select("SELECT * FROM t_classes where id = #{id}")
    Classes getById(String id);


}
