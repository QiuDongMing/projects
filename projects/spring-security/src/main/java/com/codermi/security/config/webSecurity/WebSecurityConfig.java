package com.codermi.security.config.webSecurity;

import com.codermi.security.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
    private MyAuthFailHandler authenticationFailHandler;

    @Autowired
    private MyAuthSuccessHandler myAuthSuccessHandler;

    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity

                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()

                .and()
                .formLogin().loginPage("/user/login_p").loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .successHandler(myAuthSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .permitAll()

                .and()
                .logout().logoutUrl("/logout").logoutSuccessHandler(myLogoutSuccessHandler)
                .permitAll()

                .and()
                .sessionManagement().maximumSessions(1);

    }

    /**
     * 添加 UserDetailsService， 实现自定义登录校验
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        System.out.println("auth = " + auth);

        auth.userDetailsService(userDetailServiceImpl);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**", "/user/login_p");
    }

}
