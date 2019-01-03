package com.qdm.mq.producer;

import com.qdm.mq.BaseTest;
import com.qdm.mq.data.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author qiudm
 * @date 2018/12/29 15:32
 * @desc
 */
public class UserInfoProducerTest extends BaseTest {

    @Autowired
    private UserInfoProducer userInfoProducer;

    @Test
    public void sendUserInfo() throws Exception {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setCreateTime(System.currentTimeMillis());
//        userInfo.setName("name-1");
//        userInfo.setUserId("1001");
//        userInfoProducer.sendUserInfo(userInfo);
//
//        TimeUnit.SECONDS.sleep(5);
    }


}