package com.qdm.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author qiudm
 * @date 2018/11/28 11:41
 * @desc
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.qdm.es")
public class EsApp {

    public static void main(String[] args) {
        SpringApplication.run(EsApp.class, args);
    }

}
