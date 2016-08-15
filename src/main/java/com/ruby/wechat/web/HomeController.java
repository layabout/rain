package com.ruby.wechat.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ruby on 2016/8/10.
 * Email:liyufeng_23@163.com
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/","/home","/index"}, method = RequestMethod.GET)
    public String home(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
