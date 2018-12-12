package com.codermi.mybatis.service;

import com.alibaba.fastjson.JSON;
import com.codermi.mybatis.BaseTest;
import com.codermi.mybatis.data.entity.User;
import com.codermi.mybatis.data.vo.UserVo;
import com.codermi.mybatis.utils.Pagination;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author qiudm
 * @date 2018/12/12 14:35
 * @desc
 */
public class UserServiceTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;


    @Test
    public void updateUserName() throws Exception {
        userService.updateUserName(100000, "hello");
    }




    @Test
    public void getByUserId() throws Exception {
        int userId = 100000;
        User user = userService.getByUserId(userId);
        System.out.println("user = " + user);
    }

    @Test
    public void getUserList() throws Exception {
        Pagination<UserVo> pagination = userService.getUserList(2, 2);

        LOGGER.info("userList:{}", JSON.toJSONString(pagination));
    }


    @Test
    public void insert() throws Exception {
        String name = "qdm1";
        userService.insert(name);
    }

    @Test
    public void findByCondition() throws Exception {
        userService.findByCondition();
    }


}