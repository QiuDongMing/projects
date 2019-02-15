package com.codermi.mybatis.springhook;

import org.springframework.beans.factory.DisposableBean;

/**
 * @author qiudm
 * @date 2019/2/15 10:05
 * @desc
 * DisposableBean接口只有一个方法#destroy，作用是：当一个单例Bean实现DisposableBean，
 * #destroy可以添加自定义的一些销毁方法或者资源释放操作(Invoked by a BeanFactory on
 * destruction of a singleton ==>"单例销毁时由BeanFactory调用#destroy")
 * 将代码同spring耦合了，不推荐
 * 作者：zhrowable
 * 链接：https://www.jianshu.com/p/e22b9fef311c
 * 來源：简书
 * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 *
 */
public class DisposableBeanTest implements DisposableBean {

    private String name;

    @Override
    public void destroy() throws Exception {
        System.out.println(" 销毁资源 " );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
