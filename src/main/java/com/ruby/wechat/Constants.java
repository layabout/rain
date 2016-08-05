package com.ruby.wechat;

import com.ruby.common.configuration.ConfigurableConstants;

public class Constants extends ConfigurableConstants{

    static {
        init("config/wpms.properties");
    }

    //商户中心地址
    public final static String MERCHAT_SERVICE_URL = p.getProperty("merchant_service_url",
            "http://merchant.mobaopay.dev");

}
