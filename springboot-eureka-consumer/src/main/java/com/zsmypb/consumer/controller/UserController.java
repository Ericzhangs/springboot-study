package com.zsmypb.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangs.
 * @date 2020/3/17.
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/buy")
    public String butTicket(String name) {
        return name + "买到了" + restTemplate.getForObject("http://EUREKA-PROVIDER/getTicket", String.class);
    }
}
