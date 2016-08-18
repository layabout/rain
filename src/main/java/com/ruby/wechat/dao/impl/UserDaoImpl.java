package com.ruby.wechat.dao.impl;

import com.ruby.common.persistence.hibernate.impl.BaseDaoImpl;
import com.ruby.wechat.dao.UserDao;
import com.ruby.wechat.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by ruby on 2016/8/18.
 * Email:liyufeng_23@163.com
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {
}
