package com.codermi.security.controller;

import com.codermi.security.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiudm
 * @date 2018/12/3 11:23
 * @desc
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @RequestMapping("/login")
    public JsonResult login() {
        LOGGER.info("login");
        return JsonResult.SUCCESS("login");
    }

    @RequestMapping("/get")
    public JsonResult get() {
        LOGGER.info("get");
        return JsonResult.SUCCESS("get");
    }



}
