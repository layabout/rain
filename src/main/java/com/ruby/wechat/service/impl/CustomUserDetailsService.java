package com.ruby.wechat.service.impl;

import com.ruby.wechat.entity.User;
import com.ruby.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by ruby on 2016/8/18.
 * Email:liyufeng_23@163.com
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.findUserByLoginId(s);
        if(user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return null;
    }
}
