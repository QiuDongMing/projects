package com.codermi.mybatis.data.vo;

import com.codermi.mybatis.data.entity.Score;
import com.codermi.mybatis.data.entity.Student;
import lombok.Data;

import java.util.List;

/**
 * @author qiudm
 * @date 2019/2/13 14:23
 * @desc
 */
@Data
public class StudentScoreVo extends Student {

    private List<Score> scores;

}
