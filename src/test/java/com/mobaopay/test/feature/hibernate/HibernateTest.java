package com.mobaopay.test.feature.hibernate;

import com.mobaopay.test.BaseSpringTestRunner;
import com.mobaopay.test.feature.hibernate.dao.UserDao;
import com.mobaopay.test.feature.hibernate.entity.User;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ruby on 2016/8/16.
 * Email:liyufeng_23@163.com
 */
public class HibernateTest extends BaseSpringTestRunner {

    private static final Logger logger = LoggerFactory.getLogger(HibernateTest.class);

    @Autowired
    private UserDao userTestDao;

    @Test
    @Transactional
    public void testHibernate() throws Exception {
        logger.info("hibernate test start ...");

        DetachedCriteria query = DetachedCriteria.forClass(User.class);

        List<User> list = userTestDao.page(query,2,1);
        for(User item : list) {
            System.out.println(item.getName());
        }

    }
}
