package com.qdm.es.service;

import com.alibaba.fastjson.JSON;
import com.qdm.es.BaseTest;
import com.qdm.es.data.User;
import com.qdm.es.utils.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author qiudm
 * @date 2018/11/28 15:18
 * @desc
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void getById() throws Exception {
        String id = "JxSwY2cBMwF5D0HaWGAI";
        User byId = userService.getById(id);
        System.out.println("byId = " + JSON.toJSONString(byId));
    }

    @Test
    public void createUserIndex() throws Exception {
        User user = new User();
        user.setAge(11);
        user.setCreateTime(System.currentTimeMillis());
        user.setId(StringUtils.randomUUID());
        user.setName("aaa2_2");
        user.setSalary(6001);
        userService.createUserIndex(user);
    }

}