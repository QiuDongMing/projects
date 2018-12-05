package com.codermi.security.controller;

import com.codermi.security.enums.ErrorCode;
import com.codermi.security.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
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


    @RequestMapping("/login_p")
    public JsonResult login() {
        LOGGER.info("login_p");
        return JsonResult.FAILURE(ErrorCode.NEED_LOGIN);
    }

    @RequestMapping("/get")
    public JsonResult get() {
        LOGGER.info("get");
        return JsonResult.SUCCESS("get");
    }


    @RequestMapping("/auth")
    @PreAuthorize("hasAuthority('perm')")
    public JsonResult auth() {
        LOGGER.info("auth");
        return JsonResult.SUCCESS("auth");
    }


}
