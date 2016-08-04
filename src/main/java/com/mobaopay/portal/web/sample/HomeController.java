package com.mobaopay.portal.web.sample;

import com.mobaopay.portal.web.DataDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruby on 2016/5/26.
 * Email:liyufeng_23@163.com
 */
@Controller
public class HomeController {

    @ModelAttribute("nav")
    public String nav() {
        return "home";
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String index(Model model)
    {
        List<DataDto> list = new ArrayList<DataDto>();
        for(int i = 0; i<10; i++){
            DataDto dto = new DataDto();
            dto.setColumn1("content1" + i);
            dto.setColumn2(String.valueOf(i));
            dto.setColumn3("content3" + i);
            list.add(dto);
        }
        model.addAttribute("data",list);

        String cardNo = "123456789123456789";
        model.addAttribute("cardNo",cardNo);
        return "sample/layout";
    }

}
