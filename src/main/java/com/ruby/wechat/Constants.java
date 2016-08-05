package com.ruby.wechat;

import com.ruby.common.configuration.ConfigurableConstants;

public class Constants extends ConfigurableConstants{

    static {
        init("config/wpms.properties");
    }

    //token
    public final static String TOKEN = p.getProperty("token");

}
