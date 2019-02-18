package com.codermi.mybatis.springhook;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author qiudm
 * @date 2019/2/15 9:48
 * @desc
 * InitializingBean接口只有一个方法#afterPropertiesSet，
 * 作用是：当一个Bean实现InitializingBean，#afterPropertiesSet方法里面可以添加
 * 自定义的初始化方法或者做一些资源初始化操作(Invoked by a BeanFactory after it
 * has set all bean properties supplied ==> "当BeanFactory 设置完所有的Bean
 * 属性之后才会调用#afterPropertiesSet方法")。
 * 将代码同spring耦合了，不推荐
 *
 * 作者：zhrowable
 * 链接：https://www.jianshu.com/p/e22b9fef311c
 * 來源：简书
 * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */
public class InitializingBeanTest implements InitializingBean {

    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        /**
         * @See MyConfig
         */
        System.out.println("getName() = " + getName());
    }


    public void myInitMethod() {
        System.out.println("myInitMethod getName() = " + getName());
    }

    public void myDestroyMethod() {
        System.out.println(" myDestroyMethod " );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
