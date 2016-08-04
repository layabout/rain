package com.mobaopay.portal.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruby on 2016/6/3.
 * Email:liyufeng_23@163.com
 */
@Service
public class BusinessService {

    public List<String> getHeadlines(){
        List<String> list = new ArrayList<String>();
        list.add("白马已经老了，只能慢慢的走，但终是能回到中原的。");
        list.add("红颜弹指老，刹那芳华。");
        list.add("慧极必伤，情深不寿，强极则辱，谦谦君子，温润如玉。");
        list.add("向来痴，从此醉。");
        list.add("永不放下，光明总会到来。");
        list.add("两个都钟爱，便是两个都不钟爱。");
        list.add("你瞧这些白云聚了又散，散了又聚，人生离合，亦复如斯。");
        return list;
    }
}
