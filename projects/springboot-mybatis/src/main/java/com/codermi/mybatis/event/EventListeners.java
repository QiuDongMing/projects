package com.codermi.mybatis.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author qiudm
 * @date 2019/2/14 18:29
 * @desc 定义事件监听器
 */
@Component
public class EventListeners {

    private static final Logger logger = LoggerFactory.getLogger(EventListeners.class);

    @EventListener
    @Async
    public void emailNotifierListener(EmailEvent emailEvent) throws Exception {
        logger.info(" EmailNotifierListener with @EventListener");
        TimeUnit.SECONDS.sleep(3);
        logger.info("  @EventListener邮件发送地址-：" + emailEvent.getAddress());
        logger.info("  @EventListener邮件发送内容-：" + emailEvent.getText());
    }

}
