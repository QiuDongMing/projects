package com.qdm.mq.producer;

import com.alibaba.fastjson.JSON;
import com.qdm.mq.config.MqConstants;
import com.qdm.mq.data.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qiudm
 * @date 2018/12/29 15:21
 * @desc
 */
@Component
public class UserInfoProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendFanoutUserInfo(UserInfo userInfo) {
        LOGGER.info("send fanout Msg:{}", JSON.toJSONString(userInfo));
        rabbitTemplate.convertAndSend(MqConstants.USERINFO_FANOUT_EXCHANGE, null, JSON.toJSONString(userInfo));
    }


    public void sendDirectUserInfo(UserInfo userInfo) {
        LOGGER.info("send direct Msg:{}", JSON.toJSONString(userInfo));
        rabbitTemplate.convertAndSend(MqConstants.USERINTO_DIRECT_EXCHANGE, MqConstants.USERINTO_DIRECT_ROUTE_KEY,
                JSON.toJSONString(userInfo));
    }


    public void sendTopicUserInfo(UserInfo userInfo) {
        for(int i=0;i<10000;i++) {
            userInfo.setCreateTime(System.currentTimeMillis());
            if(userInfo.getType() == 0) {
                LOGGER.info("send topoic0 Msg:{}", JSON.toJSONString(userInfo));
                rabbitTemplate.convertAndSend(MqConstants.USERINTO_TOPIC_EXCHANGE,"userinfo.route.key.after",
                        JSON.toJSONString(userInfo));
            } else if(userInfo.getType() == 1) {
                LOGGER.info("send topoic1 Msg:{}", JSON.toJSONString(userInfo));
                rabbitTemplate.convertAndSend(MqConstants.USERINTO_TOPIC_EXCHANGE,"before.userinfo.route.key",
                        JSON.toJSONString(userInfo));
            }
        }

    }
}
