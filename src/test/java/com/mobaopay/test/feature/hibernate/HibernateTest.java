package com.mobaopay.test.feature.hibernate;

import com.mobaopay.test.BaseSpringTestRunner;
import com.mobaopay.test.feature.hibernate.dao.UserDao;
import com.mobaopay.test.feature.hibernate.entity.User;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ruby on 2016/8/16.
 * Email:liyufeng_23@163.com
 */
public class HibernateTest extends BaseSpringTestRunner {

    private static final Logger logger = LoggerFactory.getLogger(HibernateTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    @Rollback(false)
    @Transactional
    public void testHibernate() {
        logger.info("hibernate test start ...");

        DetachedCriteria query = DetachedCriteria.forClass(User.class);

        List<User> list = userDao.page(query,2,1);
        for(User item : list) {
            System.out.println(item.getName());
        }
//        User user = new User();
//        user.setName("hibernate test");
//
//        userDao.save(user);

        logger.info("test end ...");
    }
}
