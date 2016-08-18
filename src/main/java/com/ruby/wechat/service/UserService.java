package com.ruby.wechat.service;


import com.ruby.wechat.entity.User;

/**
 * Created by ruby on 2016/8/18.
 * Email:liyufeng_23@163.com
 */
public interface UserService {
    public User findUserByLoginId(String loginId);
}
