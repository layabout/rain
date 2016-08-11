package com.ruby.wechat.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        model.addAttribute("user", getPrincipal());
        return "index";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
