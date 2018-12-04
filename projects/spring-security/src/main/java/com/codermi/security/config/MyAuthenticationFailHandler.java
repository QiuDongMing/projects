package com.codermi.security.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qiudm
 * @date 2018/12/4 17:53
 * @desc
 */
@Component
public class MyAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        this.setDefaultFailureUrl(null);
        System.out.println(" = = = =  = = =" );
        super.onAuthenticationFailure(request, response, exception);
    }

}
