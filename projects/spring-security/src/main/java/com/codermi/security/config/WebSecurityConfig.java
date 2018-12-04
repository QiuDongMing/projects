package com.codermi.security.config;

import com.codermi.security.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author qiudm
 * @date 2018/7/25 9:56
 * @desc
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    private MyAuthenticationFailHandler authenticationFailHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity

                .csrf().disable()
                .authorizeRequests()

                .anyRequest().authenticated()

                .and()
                .formLogin()
                .failureHandler(authenticationFailHandler)
                .usernameParameter("username").passwordParameter("password")
                .permitAll()  //开启登录

                .and()
                .exceptionHandling().authenticationEntryPoint(new Http401AuthenticationEntryPoint("no login"))

                .and()
                .sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);

    }

    /**
     * 添加 UserDetailsService， 实现自定义登录校验
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        System.out.println("auth = " + auth);
        auth.userDetailsService(userDetailServiceImpl);
    }

}
