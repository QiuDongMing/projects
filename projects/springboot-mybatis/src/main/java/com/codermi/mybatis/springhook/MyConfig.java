package com.codermi.mybatis.springhook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author qiudm
 * @date 2019/2/15 9:49
 * @desc
 */
@Configuration
public class MyConfig {

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    public InitializingBeanTest initMyBean() {
        InitializingBeanTest myBean = new InitializingBeanTest();
        myBean.setName("myBeanName");
        return myBean;
    }

    @Bean
    public DisposableBeanTest initDisposableBeanTest() {
        DisposableBeanTest myBean = new DisposableBeanTest();
        myBean.setName("DisposableBeanTest");
        return myBean;
    }


}
