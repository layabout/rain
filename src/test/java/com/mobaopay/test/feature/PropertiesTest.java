package com.mobaopay.test.feature;

import com.mobaopay.portal.Constants;
import com.mobaopay.test.BaseSpringTestRunner;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.*;

/**
 * Created by ruby on 2016/5/24.
 * Mail:liyufeng_23@163.com
 */
public class PropertiesTest extends BaseSpringTestRunner{
    private static final Logger logger = LoggerFactory.getLogger(PropertiesTest.class);

    @Test
    public void testReadProperties() {
        logger.info("find properties in wpms");
//        logger.info("the property value is : {}", Constants.MERCHAT_SERVICE_URL);
        assertEquals("http://merchant.mobaopay.tst", Constants.MERCHAT_SERVICE_URL);
    }
}
