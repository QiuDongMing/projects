package com.codermi.security.controller;

import com.codermi.security.enums.ErrorCode;
import com.codermi.security.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiudm
 * @date 2018/12/5 14:57
 * @desc
 */
@RestController
@RequestMapping("/")
public class SecurityController {


    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);

    @RequestMapping("/login_p")
    public JsonResult login_p() {
        LOGGER.info("login_p");
        return JsonResult.FAILURE(ErrorCode.NEED_LOGIN);
    }



}
