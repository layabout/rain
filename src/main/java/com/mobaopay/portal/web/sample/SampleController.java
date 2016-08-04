package com.mobaopay.portal.web.sample;

import com.mobaopay.portal.web.support.message.MessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by ruby on 2016/5/30.
 * Email:liyufeng_23@163.com
 */
@Controller
public class SampleController {

    @ModelAttribute("nav")
    public String nav() {
        return "example";
    }

    @RequestMapping("/example")
    public String sample(Model model) {
        model.addAttribute(new SigninForm());
        return "sample/signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@Valid @ModelAttribute SigninForm signinForm, Errors errors, RedirectAttributes ra) {
        if(errors.hasErrors()) {
            return "sample/signin";
        }
        MessageHelper.addSuccessAttribute(ra, "登录成功！");
        return "redirect:/home";
    }
}
