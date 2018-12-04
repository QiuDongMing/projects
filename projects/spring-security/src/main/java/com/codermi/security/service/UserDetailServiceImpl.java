package com.codermi.security.service;

import javafx.beans.property.SimpleListProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/12/3 12:36
 * @desc
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LOGGER.info("s:{}",s);
        if(Objects.equals(s, "qdm")) {
            List<SimpleGrantedAuthority> simpleGrantedAuthorities = new SimpleListProperty<>();
            return new User("qdm", "123", simpleGrantedAuthorities);
        } else {
            throw new UsernameNotFoundException("用户不存在！");
        }
    }

}
