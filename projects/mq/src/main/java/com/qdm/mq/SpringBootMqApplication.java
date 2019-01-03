package com.qdm.mq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qiudm
 * @date 2018/12/29 14:55
 * @desc
 */
@SpringBootApplication
@EnableRabbit
public class SpringBootMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMqApplication.class, args);
    }

}
