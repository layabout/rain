package com.ruby.wechat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ruby on 2016/8/10.
 * Email:liyufeng_23@163.com
 */
@Controller
public class AccountController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
