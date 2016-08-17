package com.ruby.wechat.service.impl;

import com.ruby.wechat.dao.UserDao;
import com.ruby.wechat.entity.User;
import com.ruby.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ruby on 2016/8/17.
 * Email:liyufeng_23@163.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Integer id) {
        return userDao.get(id);
    }
}
