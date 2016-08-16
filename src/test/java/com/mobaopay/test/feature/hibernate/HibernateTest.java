package com.mobaopay.test.feature.hibernate;

import com.mobaopay.test.BaseSpringTestRunner;
import com.ruby.wechat.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ruby on 2016/8/16.
 * Email:liyufeng_23@163.com
 */
public class HibernateTest extends BaseSpringTestRunner {

    private static final Logger logger = LoggerFactory.getLogger(HibernateTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    @Rollback(value = false)
    @Transactional
    public void testHibernate() {
        logger.info("hibernate test start ...");
        Session session = sessionFactory.openSession();
        User user = new User();
        user.setName("hello spring 6");
        session.save(user);
        logger.info("test end ...");
    }
}
