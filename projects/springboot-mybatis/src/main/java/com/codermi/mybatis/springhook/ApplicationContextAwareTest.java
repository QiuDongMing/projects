package com.codermi.mybatis.springhook;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author qiudm
 * @date 2019/2/15 9:56
 * @desc
 */
@Component
public class ApplicationContextAwareTest implements ApplicationContextAware {

    private static ApplicationContext applicationContext; // Spring应用上下文环境

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextAwareTest.applicationContext = applicationContext;
    }


    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 泛型方法
     * https://www.cnblogs.com/csyuan/p/6908303.html
     * @param beanName
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBeanDefinition(String beanName, Class<T> clazz) {
        return applicationContext.getBean(beanName, clazz);
    }



}
