package com.ruby.wechat.web.html5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ruby on 2016/8/5.
 * Email:liyufeng_23@163.com
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/","/index","/home"}, method = RequestMethod.GET)
    public String home() {
        return "index";
    }
}
