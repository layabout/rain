package com.ruby.wechat.api;

import com.ruby.wechat.Constants;
import com.ruby.wechat.web.support.util.SHA1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ruby on 2016/8/5.
 * Email:liyufeng_23@163.com
 */
@RestController
public class WeChatServer {

    private static final Logger logger = LoggerFactory.getLogger(WeChatServer.class);

    @RequestMapping("/api")
    public String index(@RequestParam(value="signature") String signature, @RequestParam(value = "timestamp") String timestamp, @RequestParam(value = "nonce") String nonce, @RequestParam(value="echostr") String echostr) {

        logger.trace("微信签名验证开始...");
        logger.trace("接收参数[signature={}, timestamp={}, nonce={}, echostr={}]",signature, timestamp, nonce, echostr);

        String token = Constants.TOKEN;

        List<String> params = new ArrayList<String>();
        params.add(token);
        params.add(timestamp);
        params.add(nonce);

        Collections.sort(params, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        String encode = SHA1.encode(params.get(0) + params.get(1) + params.get(2));
        logger.trace("本地参数签名值:{}", encode);
        logger.trace("远程参数签名值:{}", signature);

        if(encode.equals(signature)) {
            logger.trace("signature verification");
            return echostr;
        } else {
            logger.trace("signature failure");
            return "验签失败";
        }
    }
}
