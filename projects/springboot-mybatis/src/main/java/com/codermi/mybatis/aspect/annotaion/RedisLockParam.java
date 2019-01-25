package com.codermi.mybatis.aspect.annotaion;

import java.lang.annotation.*;

/**
 * @author qiudm
 * @date 2019/1/25 16:40
 * @desc
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisLockParam {


}
