package com.ruby.wechat.service.impl;

import com.ruby.common.security.exception.BadCaptchaException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ruby on 2016/8/22.
 * Email:liyufeng_23@163.com
 */
public class UsernamePasswordCaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String captcha = request.getParameter("captcha");
        String captchaExpected = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        if(!captcha.equals(captchaExpected)) {
            throw new BadCaptchaException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCaptcha"));
        }
        return super.attemptAuthentication(request, response);
    }
}
