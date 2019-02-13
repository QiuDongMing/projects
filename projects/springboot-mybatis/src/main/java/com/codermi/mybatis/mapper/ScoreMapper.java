package com.codermi.mybatis.mapper;

import com.codermi.mybatis.data.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author qiudm
 * @date 2019/2/13 14:38
 * @desc
 */
@Mapper
public interface ScoreMapper {

    @Select({"SELECT * FROM  t_score WHERE stu_id = #{stuId}"})
    List<Score> getByUserId(String stuId);


}
