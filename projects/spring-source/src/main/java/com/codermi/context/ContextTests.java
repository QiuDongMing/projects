package com.codermi.context;

import com.codermi.beans.MyBean;
import com.codermi.config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;

import java.io.File;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

/**
 * @author qiudm
 * @date 2019/1/21 16:52
 * @desc
 */
public class ContextTests {


    public static void main(String[] args) throws Exception {
        //new ContextTests().annotationApplicationContextStart();
        resourcesTest();

    }


    /**
     * 注解的方式启动spring容器
     *
     */
    @Test
    public void annotationApplicationContextStart() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AppConfig.class);
        context.refresh();

        MyBean myBean = (MyBean)context.getBean("myBean");
        System.out.println("myBean = " + myBean);

        AppConfig appConfig =  (AppConfig)context.getBean("appConfig");
        System.out.println("appConfig = " + appConfig);


        String applicationName = context.getApplicationName();
        String displayName = context.getDisplayName();
        System.out.println("applicationName = " + applicationName);
        System.out.println("displayName = " + displayName);
    }

    /**
     * System获取properties测试
     */
    @Test
    public void systemTest() {
        Properties properties = System.getProperties();
        Set<String> propertyNames = properties.stringPropertyNames();
        for (String propertyName : propertyNames) {
            String property = System.getProperty(propertyName);
            System.out.println(propertyName + " = " + property);
        }
    }



    public static void resourcesTest() throws Exception {
        String fileLocation = "classpath:spring-my.xml";
       // fileLocation = "http://community.test.file.dachentech.com.cn/FgmR3ssG0nb9YGTP16VmA6OaPhNW";
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource(fileLocation);
        boolean exists = resource.exists();
        String filename = resource.getFilename();
        System.out.println("exists = " + exists);
        System.out.println("filename = " + filename);
        String description = resource.getDescription();
        System.out.println("description = " + description);
    }












}
