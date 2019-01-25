package com.codermi.config;

import com.codermi.beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiudm
 * @date 2019/1/21 17:20
 * @desc
 */
@Configuration
public class AppConfig {

    @Bean(name = "myBean")
    public MyBean createMyBean() {
        return new MyBean("1", "beanName");
    }


}
