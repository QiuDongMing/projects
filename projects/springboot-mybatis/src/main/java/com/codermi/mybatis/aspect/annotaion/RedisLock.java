package com.codermi.mybatis.aspect.annotaion;

import java.lang.annotation.*;

/**
 * @author qiudm
 * @date 2019/1/25 16:21
 * @desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface RedisLock {

    /**
     * redis key
     * @return
     */
    String key() default "";

    /**
     * 过期时间
     * @return
     */
    int expire() default 60;


    String msg() default "正在处理中...";

}
