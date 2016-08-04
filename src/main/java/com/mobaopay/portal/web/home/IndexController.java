package com.mobaopay.portal.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ruby on 16/6/5.
 * Email:liyufeng_23@163.com
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/","/index"})
    public String index() {
        return "home/index";
    }

    @RequestMapping("/sub1")
    public String subPage1(){
        return "home/sub1";
    }
}
