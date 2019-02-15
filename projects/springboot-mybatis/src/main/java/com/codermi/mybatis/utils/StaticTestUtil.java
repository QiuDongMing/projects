package com.codermi.mybatis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qiudm
 * @date 2019/2/14 9:46
 * @desc
 */
public class StaticTestUtil {

    private static final Logger logger = LoggerFactory.getLogger(StaticTestUtil.class);

    static {
        logger.info("init StaticTestUtil ");
    }

    public static void print() {
        logger.info("print StaticTestUtil");
    }


}
