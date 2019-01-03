package com.qdm.mq.controller;

import com.qdm.mq.data.UserInfo;
import com.qdm.mq.producer.UserInfoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiudm
 * @date 2018/12/29 15:35
 * @desc
 */
@RequestMapping("/send")
@RestController
public class MessageSendController {

    @Autowired
    private UserInfoProducer userInfoProducer;

    @RequestMapping("/fanout/userInfo")
    public void sendFanoutUserInfo(@RequestBody UserInfo userInfo) {
        userInfoProducer.sendFanoutUserInfo(userInfo);
    }

    @RequestMapping("/direct/userInfo")
    public void sendDirectUserInfo(@RequestBody UserInfo userInfo) {
        userInfoProducer.sendDirectUserInfo(userInfo);
    }

   @RequestMapping("/topic/userInfo")
    public void sendTopicUserInfo(@RequestBody UserInfo userInfo) {
        userInfoProducer.sendTopicUserInfo(userInfo);
    }






}
