package com.qdm.mq.customer;

import com.alibaba.fastjson.JSON;
import com.qdm.mq.config.MqConstants;
import com.qdm.mq.data.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author qiudm
 * @date 2018/12/29 15:15
 * @desc
 */
@Component
public class DealUserInfoCustomer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DealUserInfoCustomer.class);


    @RabbitListener(queues = {MqConstants.USERINFO_QUEUE, MqConstants.USERINFO_QUEUE2})
    public void processUserInfo(String msg) {
        LOGGER.info("DealUserInfoCustomer fanout  receive:{}", msg);
        UserInfo userInfo = JSON.parseObject(msg, UserInfo.class);
        System.out.println("userInfo = " + userInfo);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(
                    value = MqConstants.USERINTO_DIRECT_EXCHANGE,
                    durable = "true"
            ),
            key = MqConstants.USERINTO_DIRECT_ROUTE_KEY,
            value = @Queue(
                    value = MqConstants.USERINFO_DIRECT_QUEUE,
                    durable = "true"
            )
    ))
    public void processDirectUserInfo(String msg) {
        LOGGER.info("DealUserInfoCustomer direct  receive:{}", msg);
        UserInfo userInfo = JSON.parseObject(msg, UserInfo.class);
        System.out.println("userInfo = " + userInfo);
    }


    @RabbitListener(queues = {MqConstants.USERINFO_TOPIC_QUEUE1})
    public void processTopicUserInfo1(String msg) {
        LOGGER.info("DealUserInfoCustomer topic1  receive:{}", msg);
        UserInfo userInfo = JSON.parseObject(msg, UserInfo.class);
        System.out.println("userInfo = " + userInfo);
    }

    @RabbitListener(queues = {MqConstants.USERINFO_TOPIC_QUEUE2})
    public void processTopicUserInfo2(String msg) {
        LOGGER.info("DealUserInfoCustomer topic2  receive:{}", msg);
        UserInfo userInfo = JSON.parseObject(msg, UserInfo.class);
        System.out.println("userInfo = " + userInfo);
    }



}
