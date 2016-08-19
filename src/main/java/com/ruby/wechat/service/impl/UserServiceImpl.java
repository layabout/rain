package com.ruby.wechat.service.impl;

import com.ruby.wechat.dao.UserDao;
import com.ruby.wechat.entity.User;
import com.ruby.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by ruby on 2016/8/18.
 * Email:liyufeng_23@163.com
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public User findUserByLoginId(String loginId) {
        return userDao.get("loginId", loginId);
    }
}




