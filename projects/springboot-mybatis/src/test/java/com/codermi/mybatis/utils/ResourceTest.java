package com.codermi.mybatis.utils;

import com.codermi.mybatis.BaseTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.net.URL;

/**
 * @author qiudm
 * @date 2019/2/15 13:55
 * @desc
 */
public class ResourceTest extends BaseTest {

    @Test
    public void loadResources() {

        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        String fileName = "classpath:application.properties";

        fileName = "META-INF/my.txt";
//        Resource resource = applicationContext.getResource(fileName);

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        URL resource1 = contextClassLoader.getSystemResource(fileName);
        System.out.println("resource = " + resource1);
    }




}
