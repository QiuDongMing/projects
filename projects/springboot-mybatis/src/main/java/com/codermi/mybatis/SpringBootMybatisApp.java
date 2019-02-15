package com.codermi.mybatis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author qiudm
 * @date 2018/12/12 13:55
 * @desc
 */
@SpringBootApplication
@EnableAsync
public class SpringBootMybatisApp {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApp.class, args);
    }


}
