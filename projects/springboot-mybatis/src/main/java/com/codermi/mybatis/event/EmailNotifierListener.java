package com.codermi.mybatis.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author qiudm
 * @date 2019/2/14 16:13
 * @desc 定义实现ApplicationListener接收邮件事件的监听
 */
@Component
public class EmailNotifierListener implements ApplicationListener/*<EmailEvent>*/ {

    private static final Logger logger = LoggerFactory.getLogger(EmailNotifierListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
//        logger.info(" EmailNotifierListener ");
//        logger.info(" 邮件发送地址-：" + emailEvent.getAddress());
//        logger.info(" 邮件发送内容-：" + emailEvent.getText());
        if (event instanceof EmailEvent) {
            EmailEvent emailEvent = (EmailEvent) event;
            logger.info(" 邮件发送地址-：" + emailEvent.getAddress());
            logger.info(" 邮件发送内容-：" + emailEvent.getText());
        } else {
            System.out.println(" 容器自身事件 " + event);
            logger.info(" 容器自身事件-：" + event);
        }
    }

}
