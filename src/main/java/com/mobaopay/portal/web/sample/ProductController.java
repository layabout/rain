package com.mobaopay.portal.web.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ruby on 2016/5/27.
 * Email:liyufeng_23@163.com
 */
@Controller
public class ProductController {

    @ModelAttribute("nav")
    public String nav() {
        return "products";
    }

    @RequestMapping("/products")
    public String products() {
        return "sample/products";
    }
}
