package com.ruby.wechat.api;

import com.ruby.wechat.api.dto.Button;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ruby on 2016/8/5.
 * Email:liyufeng_23@163.com
 */
@RestController
public class MenuController {

    @RequestMapping("/api/menu/get")
    public Button getMenu(){
        Button button = new Button();
        button.setType("click");
        button.setName("今日歌曲");
        button.setKey("10001");
        return button;
    }

}
