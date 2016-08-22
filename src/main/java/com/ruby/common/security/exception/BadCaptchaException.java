package com.ruby.common.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by ruby on 2016/8/22.
 * Email:liyufeng_23@163.com
 */
public class BadCaptchaException extends AuthenticationException {

    public BadCaptchaException(String msg) {
        super(msg);
    }

    public BadCaptchaException(String msg, Throwable t) {
        super(msg, t);
    }
}
