package com.qdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author qiudm
 * @date 2018/11/30 14:13
 * @desc
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.qdm")
public class SpringBootApp {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }


}
