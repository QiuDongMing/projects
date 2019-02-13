package com.codermi.mybatis.mapper;

import com.codermi.mybatis.data.entity.Student;
import com.codermi.mybatis.data.vo.StudentClassVo;
import com.codermi.mybatis.data.vo.StudentScoreVo;
import org.apache.ibatis.annotations.*;

/**
 * @author qiudm
 * @date 2019/2/13 10:29
 * @desc
 */
@Mapper
public interface StudentMapper {

    @Insert({"INSERT INTO t_student(id,name, classes_id,  birthday, sex)",
            "VALUES(#{id},#{name}, #{classesId}, #{birthday}, #{sex})"})
    int insert(Student student);


    @Select({"SELECT * FROM t_student where id = #{id}"})
    @Results(id="studentMap",value = {
            @Result(column = "classes_id", property = "classesId")
    })
    Student getById(String id);

    @Select({"SELECT * FROM t_student where id = #{id}"})
    @Results({
            @Result(column = "classes_id", property = "classesId"),
            @Result(column = "classes_id", property = "classes",
                    one = @One(select = "com.codermi.mybatis.mapper.ClassMapper.getById"))
    })
    StudentClassVo getStudentClassesById(String id);



    @Select({"SELECT * FROM t_student where id = #{id}"})
    @Results({
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "classes_id", property = "classesId"),
            @Result(column = "id", property = "scores",
                   many = @Many(select = "com.codermi.mybatis.mapper.ScoreMapper.getByUserId"))
    })
    StudentScoreVo getStudentScoreById(String id);


}
