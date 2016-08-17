package com.mobaopay.test.feature.hibernate.dao.impl;

import com.mobaopay.test.feature.hibernate.dao.UserDao;
import com.mobaopay.test.feature.hibernate.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by ruby on 2016/8/17.
 * Email:liyufeng_23@163.com
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {
}
