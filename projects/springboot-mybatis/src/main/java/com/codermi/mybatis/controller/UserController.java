package com.codermi.mybatis.controller;

import com.codermi.mybatis.data.vo.UserVo;
import com.codermi.mybatis.service.UserService;
import com.codermi.mybatis.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiudm
 * @date 2018/12/12 16:54
 * @desc
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list/{pageNum}/{pageSize}")
    public Pagination<UserVo> getUserList(@PathVariable int pageNum,@PathVariable int pageSize) {
        return userService.getUserList(pageNum, pageSize);
    }


}
